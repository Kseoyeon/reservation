package kr.or.connect.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.Category;
import kr.or.connect.reservation.service.CategoryService;

@RestController
@RequestMapping(path="/api")
public class CategoryApiController {
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/categories")
	public Map<String, Object> list(@RequestParam(name="start", required=false, defaultValue="0") int start) {
		
		List<Category> list = categoryService.getCategories();
		
		int count = categoryService.getCategoryCount();
		
		Map<String,Object> map = new HashMap<>();
		map.put("size", count);
		map.put("items", list);
		
		return map;
	}
}
