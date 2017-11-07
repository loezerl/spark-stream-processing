import classifiers.Classifier;
import classifiers.KNN;
import evaluators.Prequential;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaPairReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka.KafkaUtils;
import scala.Tuple2;
import util.InstanceParser;
import util.ResultBox;
import util.Results;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

/**
 * Created by loezerl-fworks on 18/10/17.
 */
public class Experimenter {

    public static SparkConf conf;

    public static void main(String[] args) throws Exception{


        //        local[2] - Number of Threads
        conf = new SparkConf().setAppName("spark-knn").setMaster("local[32]");
        Integer BATCH_TIME = 10;
        JavaStreamingContext jssc = new JavaStreamingContext(conf, Durations.seconds(BATCH_TIME));
        jssc.sparkContext().setLogLevel("ERROR");

        ResultBox resultados = new ResultBox();
        Results.setInstance(resultados);

        Map<String, Integer> topicMap = new HashMap<>();
        topicMap.put("instances", 1);

        JavaPairReceiverInputDStream<String, String> messages =
                KafkaUtils.createStream(jssc, "localhost:2181", "teste", topicMap);


        KNN my_classifier = new KNN(7, 1000, "euclidean");
        Classifier.setInstance(my_classifier);

        JavaDStream<String> lines = messages.map(Tuple2::_2);

        JavaDStream<Vector<Double>> values = lines.map(
                s -> InstanceParser.Parser(s)
        );

        JavaPairDStream<Boolean, Integer> answers = values.mapToPair(
            s -> new Tuple2<>(PrequentialMap.run(s), 1)
        );

        answers = answers.reduceByKey(
                (i1, i2) -> i1 + i2
        );

        answers.print();
        long total = Runtime.getRuntime().totalMemory();
        jssc.start();
        int minutes = 5;
        jssc.awaitTerminationOrTimeout(60000*minutes);
        jssc.stop();
        long used  = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        resultados.PrintResult();
        System.err.println("Memory: " + (used/1024.0)/1024.0);
    }
     public static class PrequentialMap {

        public static boolean run(Vector<Double> instance){
            Classifier classifier = Classifier.getInstance();
            Boolean answer = classifier.test(instance);
            Results r = Results.getInstance();
            r.setValue(answer);
            classifier.train(instance);
            return answer;
        }
    }


}
