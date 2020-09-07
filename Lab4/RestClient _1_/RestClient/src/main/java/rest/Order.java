package rest;

import java.util.List;

public class Order {

    private Long id;
    private List<OrderEntry> orderEntryList;
    private Address billing;
    private Address shipping;
}
