package evaluators;

import classifiers.Classifier;
import org.apache.spark.api.java.function.Function;
import scala.Tuple2;

import java.io.Serializable;
import java.util.Vector;

/**
 * Created by loezerl-fworks on 18/10/17.
 */
public class Evaluator  {
    public Classifier classifier;
    public Evaluator(Classifier _classifier){
        this.classifier = _classifier;
    }

    public boolean run(Vector<Double> instance){ return false;}
}
