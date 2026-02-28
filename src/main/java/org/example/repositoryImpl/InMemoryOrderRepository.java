package org.example.repositoryImpl;

import org.example.entities.Order;
import org.example.repositories.OrderRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryOrderRepository implements OrderRepository {

    private ConcurrentHashMap<String,Order> orderMap;

    public InMemoryOrderRepository(){
        this.orderMap=new ConcurrentHashMap<>();
    }

    @Override
    public void save(Order order) {
        orderMap.put(order.getOrderId(),order);
    }
}
