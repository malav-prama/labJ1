package com.example.labj1.controller;
import com.example.labj1.logic.OrderLogic;
import com.example.labj1.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order/")
public class OrderController {

     @Autowired
     OrderLogic orderLogic;

     @PostMapping("v1/add/")
     public ResponseEntity<?> placeOrder(@RequestBody Order Order)
     {
        return orderLogic.createOrder(Order);

     }




}
