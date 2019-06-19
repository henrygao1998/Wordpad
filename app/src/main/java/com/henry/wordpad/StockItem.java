package com.henry.wordpad;

public class StockItem {

    private int id;
    private String stockName;
    private String stockIndex;
    private String stockLead;
    private String stockRange;

    public StockItem(){
        this.stockIndex = "";
        this.stockName = "";
        this.stockLead = "";
        this.stockRange = "";
    }


    public StockItem(String stockName,String stockIndex,String stockLead,String stockRange) {
        this.stockIndex = stockIndex;
        this.stockName = stockName;
        this.stockLead = stockLead;
        this.stockRange = stockRange;
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

    public String getStockLead() {
        return stockLead;
    }

    public void setStockLead(String stockLead) {
        this.stockLead = stockLead;
    }

    public String getStockRange() {
        return stockRange;
    }

    public void setStockRange(String stockRange) {
        this.stockRange = stockRange;
    }
}
