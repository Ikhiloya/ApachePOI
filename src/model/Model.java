package model;

public class Model {

//    private String keyword;
    private String english;
    private String french;
    private String portuguese;

    public Model( String english, String french, String portuguese) {
//        this.keyword = keyword;
        this.english = english;
        this.french = french;
        this.portuguese = portuguese;
    }

//    public String getKeyword() {
//        return keyword;
//    }
//
//    public void setKeyword(String keyword) {
//        this.keyword = keyword;
//    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getFrench() {
        return french;
    }

    public void setFrench(String french) {
        this.french = french;
    }

    public String getPortuguese() {
        return portuguese;
    }

    public void setPortuguese(String portuguese) {
        this.portuguese = portuguese;
    }

    @Override
    public String toString() {
        return "Model{" +
                ", english='" + english + '\'' +
                ", french='" + french + '\'' +
                ", portuguese='" + portuguese + '\'' +
                '}';
    }


}
