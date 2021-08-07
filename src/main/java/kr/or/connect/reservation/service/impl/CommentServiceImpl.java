package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.CommentDao;
import kr.or.connect.reservation.dto.Comment;
import kr.or.connect.reservation.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {	
	
	private final CommentDao commentDao;
	
	public CommentServiceImpl(CommentDao commentDao) {
		this.commentDao = commentDao;
	}
	
	@Override
	@Transactional
	public List<Comment> getAllComments(Integer start) {
		List<Comment> list = commentDao.selectAllComment(start, CommentService.LIMIT);
		return list;
	}
	
	@Override
	@Transactional
	public List<Comment> getProductComments(Integer id, Integer start) {
		List<Comment> list = commentDao.selectProductComment(id, start, CommentService.LIMIT);
		return list;
	}
	
	@Override
	public int getAllCount() {
		return commentDao.commentAllCount();
	}
	
	@Override
	public int getProductCount(Integer id) {
		return commentDao.commentProductCount(id);
	}
}
