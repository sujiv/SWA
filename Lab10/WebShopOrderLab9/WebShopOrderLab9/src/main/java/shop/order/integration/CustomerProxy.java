package shop.order.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestOperations;

import shop.order.service.OrderCustomerDTO;



@Component
public class CustomerProxy {	
	@Autowired
	CustomerFeignClient customerClient;

	public OrderCustomerDTO getOrderCustomer(String customerNumber) {
		OrderCustomerDTO customer = customerClient.getOrderCustomer(customerNumber);
		return customer;
	};

	@FeignClient("CustomersService") 
	interface CustomerFeignClient { 
	  @GetMapping("/ordercustomer/{customerNumber}")
	  public OrderCustomerDTO getOrderCustomer(@PathVariable("customerNumber") String customerNumber); 
	 } 
}



