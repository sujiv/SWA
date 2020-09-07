package shop.shopping.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import shop.shopping.service.ProductDTO;

@Component
public class ProductCatalogProxy {
	
	@Autowired
	ProductsFeignClient productsClient;
	
	public ProductDTO getProduct(String productnumber) {
		ProductDTO product = productsClient.getProduct(productnumber);
		return product;
	};


	@FeignClient("ProductsService") 
	interface ProductsFeignClient { 
	  @GetMapping("/product/{productNumber}")
	  public ProductDTO getProduct(@PathVariable("productNumber") String productNumber); 
	 } 
}
