package jsptest;

import java.io.Serializable;

/**
 * @author ad
 */
public class LiuyanBean implements Serializable {
    private String name=null;
    private String word=null;

    public LiuyanBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
