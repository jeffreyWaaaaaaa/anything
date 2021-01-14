package com.jw9j.flinkInAction;

import lombok.Getter;
import lombok.Setter;
import org.apache.flink.api.java.utils.ParameterTool;

@Getter
@Setter
public class WordCountPojo {
    private String word;
    private int frequency;

    // constructor
    public WordCountPojo() {
    }

    public WordCountPojo(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    @Override
    public String toString(){ return "Word="+ word + "freq="+ frequency;}

    public static void main(String[] args) {
        for(int i=0;i< args.length;i++){
            System.out.println(args[i]);
        }
    }
}
