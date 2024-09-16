package com.example.labj1.logic;
import com.example.labj1.dao.OrderDao;
import com.example.labj1.model.Inventory;
import com.example.labj1.model.Order;
import com.example.labj1.model.updateInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.Collections;

@Service
public class OrderLogic {


    @Autowired
    OrderDao orderDao;
    @Autowired
    RestTemplate restTemplate;


    @Transactional
    public ResponseEntity<?> createOrder(Order order) {
        System.out.println("order: " + order);
        String inventoryUrl = "http://localhost:8081/inventory/v2";

        UriComponentsBuilder url = UriComponentsBuilder.fromUriString(inventoryUrl).queryParam("productId", (order.getLineItems().get(0).getProductInfo().getId()));
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        Inventory inventory = restTemplate.exchange(url.build().toUri().toString(), HttpMethod.GET, entity, Inventory.class).getBody();
        System.out.println("inventory data :: " + inventory.getTotalQuantity());
        if (order.getLineItems().get(0).getProductInfo().getId() == inventory.getProductId() && order.getLineItems().get(0).getQuantity() <= inventory.getTotalQuantity()) {

            orderDao.saveOrder(order);
            int tempId=order.getLineItems().get(0).getProductInfo().getId();
            int tempQty=order.getLineItems().get(0).getQuantity();

            updateInventory updateInventory=new updateInventory();

            updateInventory.setProductId(tempId);
            updateInventory.setProductQt(tempQty);

            String putUrl="http://localhost:8081/inventory/v2/updateInventory";
            UriComponentsBuilder url2= UriComponentsBuilder.fromUriString(putUrl).queryParam("productId", (order.getLineItems().get(0).getProductInfo().getId()));
            HttpHeaders headersPut = new HttpHeaders();
            HttpEntity<updateInventory > entityPut = new HttpEntity<>(updateInventory);
            restTemplate.exchange(url2.build().toUri().toString(), HttpMethod.PUT, entityPut, updateInventory.class);
            return ResponseEntity.status(200).build();

        }
        else
            return ResponseEntity.status(406).build();

    }
}

