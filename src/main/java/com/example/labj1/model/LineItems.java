package com.example.labj1.model;

import java.util.List;

public class LineItems {

    private Integer id;
    private Integer quantity;
    private ProductInfo productInfo;
    private Integer lineItemTotal;

    public LineItems(Integer id, Integer quantity, ProductInfo productInfo, Integer lineItemTotal) {
        this.id = id;
        this.quantity = quantity;
        this.productInfo = productInfo;
        this.lineItemTotal = lineItemTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    public Integer getLineItemTotal() {
        return lineItemTotal;
    }

    public void setLineItemTotal(Integer lineItemTotal) {
        this.lineItemTotal = lineItemTotal;
    }
}
