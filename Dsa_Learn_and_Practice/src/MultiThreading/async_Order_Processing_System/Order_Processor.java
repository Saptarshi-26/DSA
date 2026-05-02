package MultiThreading.async_Order_Processing_System;

public class Order_Processor {
    String take_order(Inventory inventory ,Order order){
        return inventory.reduce_stock(order.getAmount())?"Successful":"Unsuccessful";
    }
}
