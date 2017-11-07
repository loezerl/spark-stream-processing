package util;

/**
 * Created by loezerl-fworks on 19/10/17.
 */
public class Results {


    private static Results instance;

    protected Results(){}

    public static synchronized Results getInstance(){
        if(instance == null){
            instance = new Results();
        }
        return instance;
    }
    public static synchronized void setInstance(Results obj){
        instance = obj;
    }

    public void setValue(Boolean value){}

}
