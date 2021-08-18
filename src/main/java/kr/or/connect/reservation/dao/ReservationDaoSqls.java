package kr.or.connect.reservation.dao;

public class ReservationDaoSqls {
	public static final String SELECT_RESERVATIONINFO = "";
	public static final String SELECT_ALL = "";
	public static final String UPDATE_CANCEL = "UPDATE  reservation_info SET cancel_flag= 1  WHERE id = :reservationId";
}