package com.example.labj1.dao;
import com.example.labj1.model.Order;
import com.example.labj1.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDao {

    @Autowired
    OrderRepository orderRepository;

    public void saveOrder(Order order)
    {
        orderRepository.save(order);
    }

}
