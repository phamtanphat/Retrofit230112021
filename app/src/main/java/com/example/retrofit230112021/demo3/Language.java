package com.example.retrofit230112021.demo3;


public class Language {

    private En en;
    private Vn vn;

    public En getEn() {
        return en;
    }

    public void setEn(En en) {
        this.en = en;
    }

    public Vn getVn() {
        return vn;
    }

    public void setVn(Vn vn) {
        this.vn = vn;
    }

    @Override
    public String toString() {
        return "Language{" +
                "en=" + en +
                ", vn=" + vn +
                '}';
    }
}