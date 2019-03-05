package com.example.furkan.apiexample.Classes;

public class Hisse {
    private String kod;
    private String sirket;
    private String tip;

    public Hisse(String kod, String sirket, String tip) {
        this.kod = kod;
        this.sirket = sirket;
        this.tip = tip;
    }


    public String getKod() {
        return kod;
    }

    public String getSirket() {
        return sirket;
    }

    public String getTip() {
        return tip;
    }
}
