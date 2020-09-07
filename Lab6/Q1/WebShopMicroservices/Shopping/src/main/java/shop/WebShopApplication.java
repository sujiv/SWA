package shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import shop.shopping.service.ShoppingCartDTO;
import shop.shopping.service.ShoppingService;

@SpringBootApplication
public class WebShopApplication implements CommandLineRunner {
	@Autowired
	private RestOperations  restTemplate;

	@Autowired
	ShoppingService shoppingService;

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

		// add products to the shoppingcart
		//todo: call the shopping component to add the first product to the cart
		shoppingService.addToCart("1", "1", 5);

		//todo: call the shopping component to add the second product to the cart
		shoppingService.addToCart("1", "2", 10);


		//get the shoppingcart
		//todo: call the shopping component to get the cart and print the result
		ShoppingCartDTO shoppingCartDTO = shoppingService.getCart("1");
		shoppingCartDTO.print();

		//checkout the cart
		//todo: call the shopping component to checkout the cart
//		Order order = shoppingService.checkout("1");
		
	}


}
