package ru.inno.market;

import ru.inno.market.core.MarketService;
import ru.inno.market.model.*;

public class MarketServiceTest {
    public static void main(String[] args) {
        MarketService service = new MarketService();

        service.createOrderFor(new Client(124, "Nick"));
        System.out.println("Заказ " + service.getOrderInfo(1));
        service.createOrderFor(new Client(125, "Nick1"));
        System.out.println("Заказ " + service.getOrderInfo(2));

        boolean addItem = service.addItemToOrder(new Item(1, "Apple iPhone SE", Category.SMARTPHONES, 97990), 1);
        if (!addItem) {
            System.out.println("Товар не добавлен в корзину");
        } else {
            System.out.println("Товар в корзине ");
        }

        double discount = service.applyDiscountForOrder(1, PromoCodes.HAPPY_NEW_YEAR);
        if (discount == 0) {
            System.out.println("Скидка по Промокоду не может быть применена" );
        }else{
            System.out.println("Цена с промокодом:  " + discount);
        }

        Order orderInfo = service.getOrderInfo(1);
        System.out.println("Информация по заказу: " + orderInfo);
    }
}

