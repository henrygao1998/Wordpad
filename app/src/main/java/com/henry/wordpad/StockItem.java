package com.henry.wordpad;

public class StockItem {

    private int id;
    private String curName;
    private String curRate;

    public StockItem(){
        this.curRate = "";
        this.curName = "";
    }


    public StockItem(String curName, String curRate) {
        this.curRate = curRate;
        this.curName = curName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurName() {
        return curName;
    }

    public void setCurName(String curName) {
        this.curName = curName;
    }

    public String getCurRate() {
        return curRate;
    }

    public void setCurRate(String curRate) {
        this.curRate = curRate;
    }
}
