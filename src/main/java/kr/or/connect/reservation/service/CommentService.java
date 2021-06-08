package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.Comment;

public interface CommentService {
	public static final Integer LIMIT = 5;
	public List<Comment> getAllComments(Integer start);
	public List<Comment> getProductComments(Integer id, Integer start);
	public int getAllCount();
	public int getProductCount(Integer id);
}
