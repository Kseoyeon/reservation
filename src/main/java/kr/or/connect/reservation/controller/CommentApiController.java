package kr.or.connect.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.Comment;
import kr.or.connect.reservation.service.CommentService;

@RestController
@RequestMapping(path="/api")
public class CommentApiController {
	@Autowired
	CommentService commentService;
	
	@GetMapping("/comments")
	public Map<String, Object> list(@RequestParam(name="productId", required=false, defaultValue="0") int productId,
			@RequestParam(name="start", required=false, defaultValue="0") int start) {
		
		if(productId == 0) {
			List<Comment> listAll = commentService.getAllComments(start-1);
			
			int totalCount = commentService.getAllCount();
			int count = listAll.size();
			
			Map<String,Object> map = new HashMap<>();
			map.put("totalCount", totalCount);
			map.put("commentCount", count);
			map.put("reservationUserComments", listAll);
			
			return map;
		} else {
			List<Comment> listProduct = commentService.getProductComments(productId, start-1);
			
			int totalCount = commentService.getProductCount(productId);
			int count = listProduct.size();
			
			Map<String,Object> map = new HashMap<>();
			map.put("totalCount", totalCount);
			map.put("commentCount", count);
			map.put("reservationUserComments", listProduct);
			
			return map;
		}
	}

}
