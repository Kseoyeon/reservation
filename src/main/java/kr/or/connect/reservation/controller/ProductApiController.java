package kr.or.connect.reservation.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.service.ProductService;

@RestController
@RequestMapping(path="/api")
public class ProductApiController {
	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	public Map<String, Object> list(@RequestParam(name="start", required=false, defaultValue="1") int start) {
		List<Product> list = productService.getProducts(start);
		
		int totalcount = productService.getAllProductCount();
		int count = list.size();
		
		Map<String,Object> map = new HashMap<>();
		map.put("totalcount", totalcount);
		map.put("count", count);
		map.put("products", list);
		return map;
	}
	
	@GetMapping("/products/{categoryId}")
	public Map<String, Object> categoryList(@PathVariable(name="categoryId")Integer id,
			@RequestParam(name="start", required=false, defaultValue="0") int start) {
		List<Product> categoryList = productService.getCategoryProducts(id, start-1);
		
		int totalCount = productService.getProductCount(id);
		int count = categoryList.size();
		Map<String,Object> map = new HashMap<>();
		map.put("totalcount", totalCount);
		map.put("count", count);
		map.put("products", categoryList);
		return map;
	}
}
