package com.henry.wordpad;

public class StockItem {

    private int id;
    private String stockName;
    private String stockIndex;

    public StockItem(){
        this.stockIndex = "";
        this.stockName = "";
    }


    public StockItem(String stockName, String stockIndex) {
        this.stockIndex = stockIndex;
        this.stockName = stockName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getStockIndex() {
        return stockIndex;
    }

    public void setStockIndex(String stockIndex) {
        this.stockIndex = stockIndex;
    }
}
