package kr.or.connect.reservation.dao;

import javax.sql.DataSource;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.ReservationInfo;

import static kr.or.connect.reservation.dao.ReservationDaoSqls.*;



@Repository
public class ReservationDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<ReservationInfo> rowMapper = BeanPropertyRowMapper.newInstance(ReservationInfo.class);
	
	public ReservationDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("reservation_info");
	}
	
	public List<ReservationInfo> getReservationInfoList(String reservationEmail) {
		Map<String, String> params = new HashMap<>();
		params.put("reservationEmail", reservationEmail);
		return jdbc.query(SELECT_ALL, params, rowMapper);
	}
	
	public List<ReservationInfo> getReservationInfo(int reservationId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("reservationId", reservationId);
		return jdbc.query(SELECT_RESERVATIONINFO, params, rowMapper);
	}
	
	public void setCancelReservation(int reservationId) {
		Map<String, ?> params = Collections.singletonMap("reservationId", reservationId);
		jdbc.update(UPDATE_CANCEL, params);
	}
	
	
}
