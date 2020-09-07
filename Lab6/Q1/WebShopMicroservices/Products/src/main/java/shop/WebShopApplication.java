package shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import shop.products.service.ProductCatalogService;
import shop.products.service.ProductDTO;

@SpringBootApplication
public class WebShopApplication implements CommandLineRunner {

	@Autowired
	private ProductCatalogService productCatalogService;

	public static void main(String[] args) {
		SpringApplication.run(WebShopApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
		return restTemplate;
	}

	@Override
	public void run(String... args) throws Exception {

		//create products

		//todo: call the product component to create the first product
		productCatalogService.addProduct("1", "Product one", 100.0);
		//todo: call the product component to create the second product
		productCatalogService.addProduct("2", "Product second", 100.0);

		//set stock
		//todo: call the product component to set the stock for the first product
		productCatalogService.setStock("1", 10, "MI 48120");

		//get a product
		//todo: call the product component to get the the first product and print the result
		ProductDTO productDTO = productCatalogService.getProduct("1");
		productDTO.print();
		
	}


}
