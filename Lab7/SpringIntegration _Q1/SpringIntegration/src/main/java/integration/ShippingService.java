package integration;

public class ShippingService {
    public String shipOrder(Order order){
        System.out.println("Shipping...");
        System.out.println(order);
        return "Shipped";
    }
}
