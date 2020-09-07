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
        Message<Order> orderStocked = MessageBuilder.withPayload(order).setHeader("Status","stocked").build();
        return "Stocked and "+gateway.shipOrder(orderStocked);
    }
}
