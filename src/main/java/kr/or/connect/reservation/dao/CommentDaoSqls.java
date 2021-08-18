package kr.or.connect.reservation.dao;

public class CommentDaoSqls {
	public static final String SELECT_COMMENT = "select R.id, R.product_id, R.reservation_info_id, R.score, U.email as reservation_email, R.comment, R.create_date, R.modify_date\r\n"
			+ "from reservation_user_comment R\r\n"
			+ "inner join user U on R.user_id = U.id "
			+ "LIMIT :start, :limit";
	public static final String SELECT_COMMENT_BY_PRODUCT = "select R.id, R.product_id, R.reservation_info_id, R.score, U.email as reservation_email, R.comment, R.create_date, R.modify_date\r\n"
			+ "from reservation_user_comment R\r\n"
			+ "inner join user U on R.user_id = U.id where product_id = :id limit :start, :limit";
	public static final String COMMENT_COUNT = "select count(*) from reservation_user_comment";
	public static final String COMMENT_COUNT_BY_PRODUCT = "select count(*) from reservation_user_comment where product_id = :id";
}
