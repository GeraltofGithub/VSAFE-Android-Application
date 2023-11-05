package com.example.vscan1;

public class DataClass {
    private String Dataname;
    private String Dataphoneno;
    private String Dataimg;
    private String key;

    public DataClass(String Dataname, String Dataphoneno, String Dataimg) {
        this.Dataname = Dataname;
        this.Dataphoneno = Dataphoneno;
        this.Dataimg = Dataimg;
    }

    public DataClass(){
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getKey() {
        return key;
    }
    public String getDataname() {
        return Dataname;
    }

    public String getDataphoneno() {
        return Dataphoneno;
    }

    public String getDataimg(){
        return Dataimg;
    }
}
