package rest;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestClientApplication implements CommandLineRunner {
	@Autowired
	private RestOperations  restTemplate;


	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);
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
		// task1
		Product product1 = new Product();
		product1.setProdName("item1");
		product1.setPrice(100.0);
		product1.setTax(1.1);

		product1 = restTemplate.postForObject("http://localhost:8080/products", product1, Product.class);

		//task2
		Product product2 = new Product();
		product2.setProdName("item2");
		product2.setPrice(100.0);
		product2.setTax(1.1);

		product2 = restTemplate.postForObject("http://localhost:8080/products", product2, Product.class);

		//task3
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		MultiValueMap<String, Object> map= new LinkedMultiValueMap<String, Object>();
		map.add("cartId", 1);
		map.add("productCode", product1.getCode());
		map.add("qty", 3);

		HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(map, headers);

		ResponseEntity<String> response = restTemplate.postForEntity( "http://localhost:8080/cart", request , String.class );

		//task4
		MultiValueMap<String, Object> map2= new LinkedMultiValueMap<String, Object>();
		map.add("cartId", 1);
		map.add("productCode", product2.getCode());
		map.add("qty", 2);

		HttpEntity<MultiValueMap<String, Object>> request2 = new HttpEntity<MultiValueMap<String, Object>>(map, headers);

		ResponseEntity<String> response2 = restTemplate.postForEntity( "http://localhost:8080/cart", request , String.class );

		//task5
		String response3 = restTemplate.getForObject( "http://localhost:8080/checkout/1" , String.class );

		//task6
		Order order = restTemplate.getForObject( "http://localhost:8080/order/1" , Order.class );
		System.out.println(order);
	}

}
