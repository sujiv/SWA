package integration;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway
public interface GreetingGateway {

	@Gateway(requestChannel = "inputChannel")
	String handleRequest(Message<String> message);

	@Gateway(requestChannel = "inputChannel2")
	String handleOrder(Message<Order> order);

	@Gateway(requestChannel = "inputChannel3")
	String shipOrder(Message<Order> order);
}
