package ru.inno.market.core;

import ru.inno.market.model.*;

import java.util.HashMap;
import java.util.Map;

public class MarketService {

    private int orderCounter;
    private Map<Integer, Order> orders;

    public MarketService() {
        orderCounter = 1;
        orders = new HashMap<>();
    }

    public int createOrderFor(Client client){
        int id = orderCounter++;
        Order order = new Order(id, client);
        orders.put(id, order);

        return order.getId();
    }

    public boolean addItemToOrder(Item item, int orderId ){
        orders.get(orderId).addItem(item);
        return true;
    }

    public double applyDiscountForOrder(int orderId, PromoCodes codes){
        Order order = orders.get(orderId);
        order.applyDiscount(codes.getDiscount());
        return order.getTotalPrice();
    }

    public Order getOrderInfo(int id) {
        return orders.get(id);
    }
}

