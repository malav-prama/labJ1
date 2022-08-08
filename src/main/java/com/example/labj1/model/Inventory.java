package com.example.labj1.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="inventory")
public class Inventory {
    private int productId;
    private int totalQuantity;

    @Override
    public String toString() {
        return "Inventory{" +
                "productId=" + productId +
                ", totalQuantity=" + totalQuantity +
                '}';
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
}
