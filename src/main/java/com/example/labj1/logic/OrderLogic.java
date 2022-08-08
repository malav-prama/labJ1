package com.example.labj1.logic;
import com.example.labj1.dao.OrderDao;
import com.example.labj1.model.Inventory;
import com.example.labj1.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
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
    public void createOrder(Order order) {
        System.out.println("order: " + order);
        String inventoryUrl = "http://localhost:8081/inventory/v2";

        UriComponentsBuilder url = UriComponentsBuilder.fromUriString(inventoryUrl)

                //.queryParam("productId", Integer.parseInt(order.getLineItems().get(0).getProductInfo().getId()));
                .queryParam("productId", 24234);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(headers);
        Inventory inventory = restTemplate.exchange(url.build().toUri().toString(), HttpMethod.GET, entity, Inventory.class).getBody();
        System.out.println("inventory data :: " + inventory.getTotalQuantity());
        if (order.getLineItems().get(0).getId() == inventory.getProductId() && order.getLineItems().get(0).getQuantity() <= inventory.getTotalQuantity()) {
            System.out.print("true");

            //orderDao.saveOrder(order);
        }
    }
}
