package util;

/**
 * Created by loezerl-fworks on 19/10/17.
 */
public class ResultBox extends Results {

    private long hits;
    private long miss;
    public ResultBox(){
        this.hits=0;
        this.miss=0;
    }
    @Override
    public void setValue(Boolean value){
        if(value)
            this.hits++;
        else
            this.miss++;
    }

    public void PrintResult(){
        System.out.println("\n===================\n" +
                "Acertos: " + this.hits +
                "\nErros: " + this.miss +
                "\nInstancias: " + (this.hits+this.miss));
    }
}
