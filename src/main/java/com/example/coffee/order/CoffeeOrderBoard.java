package com.example.coffee.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class CoffeeOrderBoard {
    private static final Logger logger = LoggerFactory.getLogger(CoffeeOrderBoard.class);
    private final List<Order> orders;
    private int nextOrderNumber;

    public CoffeeOrderBoard() {
        this.orders = new LinkedList<>();
        this.nextOrderNumber = 1;
    }

    public void add(String customerName) {
        Order newOrder = new Order(nextOrderNumber++, customerName);
        orders.add(newOrder);
        logger.info("Added new order: {}", newOrder);
    }

    public void deliver() {
        if (!orders.isEmpty()) {
            Order orderToDeliver = orders.remove(0);
            logger.info("Delivered order: {}", orderToDeliver);
        } else {
            logger.warn("No orders to deliver.");
        }
    }

    public void deliver(int orderNumber) {
        Optional<Order> orderToDeliver = orders.stream()
                .filter(order -> order.getOrderNumber() == orderNumber)
                .findFirst();

        if (orderToDeliver.isPresent()) {
            orders.remove(orderToDeliver.get());
            logger.info("Delivered order: {}", orderToDeliver.get());
        } else {
            logger.warn("Order with number {} not found.", orderNumber);
        }
    }

    public void draw() {
        if (orders.isEmpty()) {
            logger.info("No orders in the queue.");
        } else {
            System.out.println("Num | Name");
            for (Order order : orders) {
                System.out.println(order);
            }
        }
    }
}

