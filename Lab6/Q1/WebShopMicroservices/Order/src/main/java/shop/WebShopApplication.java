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
import shop.order.service.OrderService;

@SpringBootApplication
public class WebShopApplication implements CommandLineRunner {
	@Autowired
	private RestOperations  restTemplate;

	@Autowired
	OrderService orderService;

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

		/*//get the order
		//todo: call the order component to get the order and print the result
        orderService.getOrder(args[0]).print();
		
		//add customer to order
		//todo: call the order component to add a customer to the order
        orderService.setCustomer(args[0], args[1]);
		
		//confirm the order
		//todo: call the order component to confirm the order
        orderService.confirm(args[0]);
		
		//get the order
		//todo: call the order component to get the order and print the result
        orderService.getOrder(args[0]).print();*/
		
	}


}
