package ru.inno.market;

import ru.inno.market.model.Client;
import ru.inno.market.model.Order;

import java.util.Map;

public class OrderTest {
    public static void main(String[] args) {
        Order order = new Order(100, new Client(124, "Test"));
        System.out.println(order);

        System.out.println(order.getClient());
        System.out.println(order.getId());




    }
}
