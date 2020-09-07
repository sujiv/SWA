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

import shop.customers.domain.Customer;
import shop.customers.service.AddressDTO;
import shop.customers.service.CustomerDTO;
import shop.customers.service.CustomerService;
import shop.customers.web.CustomerController;
import shop.order.domain.Order;
import shop.order.service.OrderDTO;
import shop.order.service.OrderService;
import shop.products.service.ProductCatalogService;
import shop.products.service.ProductDTO;
import shop.shopping.service.ShoppingCartDTO;
import shop.shopping.service.ShoppingService;

@SpringBootApplication
public class WebShopApplication implements CommandLineRunner {
	@Autowired
	private RestOperations  restTemplate;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ProductCatalogService productCatalogService;

	@Autowired
	ShoppingService shoppingService;

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
		//create customer
		CustomerDTO customerDto = new CustomerDTO("101","Frank","Brown","fBrown@Hotmail.com","123456");
		AddressDTO addressDTO = new AddressDTO("1000 N main Street", "Fairfield","52557","USA");
		customerDto.setAddress(addressDTO);
		//todo: call the customer component to add the customer
		customerService.addCustomer(customerDto);

		// get customer
		//todo: call the customer component to get the customer with id 101 and print the result
		CustomerDTO customer = customerService.getCustomer("101");

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
		Order order = shoppingService.checkout("1");

		//get the order
		//todo: call the order component to get the order and print the result
        orderService.getOrder(order.getOrdernumber()).print();
		
		//add customer to order
		//todo: call the order component to add a customer to the order
        orderService.setCustomer(order.getOrdernumber(),customer.getCustomerNumber());
		
		//confirm the order
		//todo: call the order component to confirm the order
        orderService.confirm(order.getOrdernumber());
		
		//get the order
		//todo: call the order component to get the order and print the result
        orderService.getOrder(order.getOrdernumber()).print();
		
	}


}
