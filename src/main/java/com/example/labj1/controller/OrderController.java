package com.example.labj1.controller;
import com.example.labj1.logic.OrderLogic;
import com.example.labj1.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class OrderController {

     @Autowired
     OrderLogic orderLogic;

     @PostMapping("v1/orders")
     public void placeOrder(@RequestBody Order Order)
     {
         orderLogic.createOrder(Order);
     }

}
