package com.example.labj1.model;

import java.util.List;

public class LineItems {

    private Integer quantity;
    private List <ProductInfo> lineItems;
    private Integer lineItemTotal;

    public List<ProductInfo> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<ProductInfo> lineItems) {
        this.lineItems = lineItems;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getLineItemTotal() {
        return lineItemTotal;
    }

    public void setLineItemTotal(Integer lineItemTotal) {
        this.lineItemTotal = lineItemTotal;
    }
}
