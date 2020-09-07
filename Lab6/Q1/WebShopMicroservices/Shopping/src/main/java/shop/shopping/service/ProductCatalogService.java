package shop.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductCatalogService {

	@Autowired
	RestTemplate restTemplate;

	@Value("${product.service.url}")
	String productServiceUrl;

	public ProductDTO getProduct(String productnumber) {
		System.out.println(productServiceUrl);
		ProductDTO result = restTemplate.getForObject(productServiceUrl+"/"+productnumber, ProductDTO.class);
		System.out.println(result);
		return result;
	}
	public void setStock(String productnumber, int quantity, String locationcode) {
		ProductDTO result = getProduct(productnumber);
		if (result!=null) {
			restTemplate.postForObject(productServiceUrl+"/stock/"+result.productnumber+"/"+quantity+"/"+locationcode,null, Object.class);
		}
	}
}
