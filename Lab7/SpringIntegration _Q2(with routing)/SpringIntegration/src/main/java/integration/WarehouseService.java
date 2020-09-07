package integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class WarehouseService {
    @Autowired
    private GreetingGateway gateway;

    public String getOrder(Order order){
        System.out.println("Stocking order");
        System.out.println(order);
        String shipMode = order.getAmount()>175?"nextday":"normal";
        Message<Order> orderStocked = MessageBuilder.withPayload(order).setHeader("status",shipMode).build();
        return "Stocked and "+gateway.shipOrder(orderStocked);
    }
}
