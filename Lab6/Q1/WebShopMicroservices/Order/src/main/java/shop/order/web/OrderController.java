package shop.order.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import shop.order.domain.Order;
import shop.order.service.OrderAdapter;
import shop.order.service.OrderDTO;
import shop.order.service.OrderService;
import shop.order.service.ShoppingCartDTO;

@RestController
public class OrderController {
	@Autowired
	OrderService orderService;
	
	
	@GetMapping("/order/{orderNumber}")
	public ResponseEntity<?> getCart(@PathVariable String orderNumber) {
		OrderDTO orderDTO  = orderService.getOrder(orderNumber);
		return new ResponseEntity<OrderDTO>(orderDTO, HttpStatus.OK);
	}
	
	@PostMapping("/order/{orderNumber}")
	public void confirm(@PathVariable String orderNumber) {
		orderService.confirm(orderNumber);
	}
	
	@PostMapping("/order/setCustomer/{orderNumber}/{customerNumber}")
	public ResponseEntity<?> SetCustomer(@PathVariable String orderNumber,@PathVariable String customerNumber) {
		orderService.setCustomer(orderNumber,customerNumber);
		OrderDTO orderDTO  = orderService.getOrder(orderNumber);
		return new ResponseEntity<OrderDTO>(orderDTO, HttpStatus.OK);
	}

	@PostMapping("/order")
	public ResponseEntity<?> createOrder(@RequestBody ShoppingCartDTO shoppingCartDTO){
		Order order = orderService.createOrder(shoppingCartDTO);
		return new ResponseEntity<OrderDTO>(OrderAdapter.getOrderDTO(order), HttpStatus.OK);
	}
	
}
