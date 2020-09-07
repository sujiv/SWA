package shop.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import shop.order.customerDTO.CustomerDTO;
import shop.order.domain.Customer;

@Service
public class CustomerService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${customer.service.url}")
    String customerServiceUrl;

    public CustomerDTO getCustomer(String customerNumber) {
        CustomerDTO customer = restTemplate.getForObject(customerServiceUrl+"/"+customerNumber,CustomerDTO.class);
        return customer;
    }

    public OrderCustomerDTO getOrderCustomer(String customerNumber) {
        CustomerDTO customer = getCustomer(customerNumber);
        if (customer!=null) {
            return OrderCustomerAdapter.getOrderCustomerDTO(customer);
        }
        else
            return null;
    }
}
