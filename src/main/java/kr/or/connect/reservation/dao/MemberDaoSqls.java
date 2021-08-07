package kr.or.connect.reservation.dao;

public class MemberDaoSqls {
	public static final String SELECT_ALL_BY_EMAIL = "SELECT id, name, password, email, phone, create_date, modify_date FROM user WHERE email = :email";
	public static final String INSERT_MEMBER = "INSERT INTO user(name, password, email, phone, create_date, modify_date) "
			+ "VALUES (:name, :password, :email, :phone, :createDate, :modifyDate);";
}
