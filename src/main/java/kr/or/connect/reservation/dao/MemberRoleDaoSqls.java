package kr.or.connect.reservation.dao;

public class MemberRoleDaoSqls {
	public static final String SELECT_ALL_BY_EMAIL = "SELECT mr.id, mr.user_id, mr.role_name FROM user_role mr JOIN user m ON mr.user_id = m.id WHERE m.email = :email";
	public static final String INSERT_ADMIN_ROLE = 
			"INSERT INTO user_role(user_id, role_name) "
			+ "VALUES (:userId, \"ROLE_ADMIN\");";
	public static final String INSERT_USER_ROLE = 
			"INSERT INTO user_role(user_id, role_name) "
			+ "VALUES (:userId, \"ROLE_USER\");";
}
