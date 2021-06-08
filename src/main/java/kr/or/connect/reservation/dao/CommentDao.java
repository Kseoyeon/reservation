package kr.or.connect.reservation.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Comment;

import static kr.or.connect.reservation.dao.ReservationDaoSqls.*;

@Repository
public class CommentDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Comment> rowMapper = BeanPropertyRowMapper.newInstance(Comment.class); 
	
	public CommentDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("comment");
	}
	
	public List<Comment> selectAllComment(Integer start, Integer limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(SELECT_COMMENT, params, rowMapper);
	}
	
	public List<Comment> selectProductComment(Integer id, Integer start, Integer limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("id", id);
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(SELECT_COMMENT_BY_PRODUCT, params, rowMapper);
	}
	
	public int commentAllCount() {
		return jdbc.queryForObject(COMMENT_COUNT, Collections.emptyMap(), Integer.class);
	}
	
	public int commentProductCount(Integer id) {
		Map<String, ?> params = Collections.singletonMap("id", id);
		return jdbc.queryForObject(COMMENT_COUNT_BY_PRODUCT, params, Integer.class);
	}
}
