package com.example.earthquakeapp;

public class Help {
    private int id;
    private String productName;
    private String productComment;
    private int numOfProducts;

    public Help(int id, String productName, String productComment, int numOfProducts) {
        this.id = id;
        this.productName = productName;
        this.productComment = productComment;
        this.numOfProducts = numOfProducts;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductComment() {
        return productComment;
    }

    public int getNumOfProducts() {
        return numOfProducts;
    }
}