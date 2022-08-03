package com.example.labj1.logic;
import com.example.labj1.dao.OrderDao;
import com.example.labj1.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OrderLogic {

    @Autowired
    OrderDao orderDao;



    @Transactional
    public void createOrder(Order Order)
    {
        orderDao.saveOrder(Order);
    }

}
