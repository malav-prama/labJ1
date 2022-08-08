package com.example.labj1.model;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.List;


@Document(collection="order")
public class Order {

    @Id
    private String id;
    private String totalCosts;
    private String orderDate;

    private UserInfo userInfo;

    private List<LineItems> lineItems;

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", totalCosts='" + totalCosts + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", userInfo=" + userInfo +
                ", lineItems=" + lineItems +
                '}';
    }

    public List<LineItems> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItems> lineItems) {
        this.lineItems = lineItems;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTotalCosts() {
        return totalCosts;
    }

    public void setTotalCosts(String totalCosts) {
        this.totalCosts = totalCosts;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
