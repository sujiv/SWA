package application.serviceb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceBController {

    @Value("${greeting}")
    String message;

    @RequestMapping("/")
    public String getName(){
        return message;
    }
}
