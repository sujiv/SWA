package integration;

public class ShippingService2 {
    public String shipOrder(Order order){
        System.out.println("Shipping...");
        System.out.println(order);
        return "Next day Shipped";
    }
}
