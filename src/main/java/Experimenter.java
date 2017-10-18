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

import java.util.HashMap;
import java.util.Map;
import java.util.*;

/**
 * Created by loezerl-fworks on 18/10/17.
 */
public class Experimenter {

    public static String KYOTO_DATABASE = "/home/loezerl-fworks/Downloads/kyoto.arff";;
    public static String DIABETES_DATABASE = "/home/loezerl-fworks/IdeaProjects/Experimenter/diabetes.arff";;
    public static SparkConf conf;

    public static void main(String[] args) throws Exception{


        //        local[2] - seta o numero de threads
        conf = new SparkConf().setAppName("spark-knn").setMaster("local[2]").set("spark.cores.max", "8");
        JavaStreamingContext jssc = new JavaStreamingContext(conf, Durations.seconds(10));
        jssc.sparkContext().setLogLevel("ERROR");

        Map<String, Integer> topicMap = new HashMap<>();
        topicMap.put("instances", 1);

        JavaPairReceiverInputDStream<String, String> messages =
                KafkaUtils.createStream(jssc, "localhost:2181", "teste", topicMap);

//
//        KNN2 tadsasda = new KNN2(7, 1000, "euclidean");

        KNN my_classifier = new KNN(7, 1000, "euclidean");
        Classifier.setInstance(my_classifier);

        Prequential evaluator = new Prequential(my_classifier);

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

        //lines.print();
        jssc.start();

        try{
            jssc.awaitTerminationOrTimeout(50000);
        }catch (InterruptedException e){
            System.err.println("FUDEU BAHIA -> " + e.getMessage());
            System.exit(1);
        }
    }

    public static class InstanceParser{

        public static Vector<Double> Parser(String element){
            List<String> Elements = Arrays.asList(element.split(","));

            Vector<Double> Array = new Vector<>();
            for(String el: Elements){
                Array.add(Double.parseDouble(el));
            }
            return Array;
        }
    }

     public static class PrequentialMap {

        public static boolean run(Vector<Double> instance){
            Classifier classifier = Classifier.getInstance();
            Boolean answer = classifier.test(instance);
            classifier.train(instance);
            return answer;
        }
    }


}
