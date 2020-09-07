package integration;

public class ShippingService1 {
    public String shipOrder(Order order){
        if(order.getAmount()>175.0)
        System.out.println("Shipping...");
        System.out.println(order);
        return "Normal Shipped";
    }
}
