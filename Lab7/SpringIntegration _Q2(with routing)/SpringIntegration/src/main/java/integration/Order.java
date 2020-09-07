package integration;

public class Order {

    private Integer orderNumber;
    private double amount;

    public Order(Integer orderNumber, Double amount) {
        this.setOrderNumber(orderNumber);
        this.setAmount(amount);
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString(){
        return "{orderNumber:"+orderNumber+", amount:"+amount+"}";
    }
}
