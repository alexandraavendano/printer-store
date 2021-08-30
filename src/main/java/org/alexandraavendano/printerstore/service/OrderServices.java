package org.alexandraavendano.printerstore.service;

import org.alexandraavendano.printerstore.models.Item;
import org.alexandraavendano.printerstore.models.Order;
import org.alexandraavendano.printerstore.models.Product;
import org.alexandraavendano.printerstore.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServices {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServices(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public double calculateItemsPrice(List<Item> items) {
        double total=0D;

        for(Item item: items) {
            total+=item.getPrice()*item.getQuantity();
            for(Product p: item.getCustomizations()){
                total+= p.getPrice()* item.getQuantity();
            }
        }

        return total;
    }

    public Order create(Order order) {
        order.setTotalPrice(calculateItemsPrice(order.getItems()));
        order.setTotalPrice(calculateItemsPrice(order.getItems()));
        return orderRepository.save(order);
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    public Iterable<Order> findBy(String email) {
        return orderRepository.findByClient_EmailOrderByDateDesc(email);
    }

    public Iterable<Order> findAll(){
        return orderRepository.findAll();
    }
}