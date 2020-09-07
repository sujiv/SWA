package shop.shopping.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestOperations;

import shop.shopping.integration.ProductCatalogProxy.ProductsFeignClient;
import shop.shopping.service.ProductDTO;
import shop.shopping.service.ShoppingCartDTO;

@Component
public class OrderProxy {
	
	@Autowired
	OrdersFeignClient ordersFeignClient;
	
	public void createOrder(ShoppingCartDTO shoppingCartDTO) {
		ordersFeignClient.createOrder(shoppingCartDTO);	
	};

	@FeignClient("OrderService") 
	interface OrdersFeignClient { 
	  @PostMapping("/order/create")
	  public void createOrder(@RequestBody ShoppingCartDTO shoppingCartDTO); 
	 } 
}
