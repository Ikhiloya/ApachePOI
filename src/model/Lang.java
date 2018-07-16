package model;

public class Lang {
    public String keyword;
    public String word;

    public Lang(String line) {
        String[] split = line.split("=");
        this.keyword = split[0];
        this.word = split[1];
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String    getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
