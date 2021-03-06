package kr.or.connect.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.Promotion;
import kr.or.connect.reservation.service.PromotionService;

@RestController
@RequestMapping(path="/api")
public class PromotionApiController {
	@Autowired
	PromotionService promotionService;
	
	@GetMapping("/promotions")
	public Map<String, Object> list() {
		List<Promotion> list = promotionService.getPromotions();
		int size = promotionService.getPromotionCount();
		
		Map<String,Object> map = new HashMap<>();
		map.put("size", size);
		map.put("items", list);
		return map;
	}
}
