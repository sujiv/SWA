package shop.order.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Component
public class ProductCatalogProxy {
	
	@Autowired
	ProductsFeignClient productsClient;

	public void updateStock(String productNumber, int quantity) {
		productsClient.updateStock(productNumber, quantity);
	};


	@FeignClient("AccountService") 
	interface ProductsFeignClient { 
	  @PostMapping("/updateStock/{productNumber}/{quantity}")
	  public void updateStock(@PathVariable("productNumber") String productNumber, @PathVariable("quantity") int quantity); 
	 } 
}
