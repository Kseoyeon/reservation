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

import kr.or.connect.reservation.dto.Promotion;

import static kr.or.connect.reservation.dao.PromotionDaoSqls.*;

@Repository
public class PromotionDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Promotion> rowMapper = BeanPropertyRowMapper.newInstance(Promotion.class);
	
	public PromotionDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("promotion");
	}
	
	public List<Promotion> selectPromotion() {
		Map<String, Integer> params = new HashMap<>();
		return jdbc.query(SELECT_PROMOTION, params, rowMapper);
	}
	
	public int PromotionCount() {
		return jdbc.queryForObject(PROMOTION_COUNT, Collections.emptyMap(), Integer.class);
	}
}
