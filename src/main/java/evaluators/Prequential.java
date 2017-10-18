package evaluators;

import classifiers.Classifier;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.MapFunction;
import scala.Serializable;
import scala.Tuple2;
import org.apache.spark.streaming.dstream.MappedDStream;

import java.util.Vector;

/**
 * Created by loezerl-fworks on 18/10/17.
 */
public class Prequential extends Evaluator {

    public Prequential(Classifier _classifier) {
        super(_classifier);
    }

    @Override
    public boolean run(Vector<Double> instance){
        Boolean answer = this.classifier.test(instance);
        this.classifier.train(instance);
        return answer;
    }

}
