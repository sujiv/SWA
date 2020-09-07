package shop.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class OrderService {

	@Autowired
	RestTemplate restTemplate;

	@Value("${order.service.url}")
	String orderServiceUrl;
	
	public void createOrder(ShoppingCartDTO shoppingCartDTO) {
		restTemplate.postForObject(orderServiceUrl,shoppingCartDTO,Object.class);
	}
}
