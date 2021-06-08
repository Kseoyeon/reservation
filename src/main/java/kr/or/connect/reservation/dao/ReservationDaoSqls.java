package kr.or.connect.reservation.dao;

public class ReservationDaoSqls {
	public static final String SELECT_CATEGORY = "select A.id, A.name, count(A.id) as count from category A left outer join product B on a.id = b.category_id group by A.id";
	public static final String SELECT_CATEGORY_COUNT = "select count(*) from category";
	public static final String SELECT_PRODUCT_ALL = "select P.id, C.id as category_id , D.id as display_info_id, C.name, P.description, P.content, P.event, D.opening_hours, "
			+ "D.place_name, D.place_lot, D.place_street, D.tel, D.homepage, D.email, D.create_date, "
			+ "D.modify_date, I.file_id from product P inner join category C on P.category_id = C.id "
			+ "inner join display_info D on P.id = D.product_id "
			+ "inner join product_image I on P.id = I.product_id where type = \"ma\" and D.id >= :id";
	public static final String SELECT_PRODUCT = "select P.id, C.id as category_id , D.id as display_info_id, C.name, P.description, P.content, P.event, D.opening_hours, "
			+ "D.place_name, D.place_lot, D.place_street, D.tel, D.homepage, D.email, D.create_date, "
			+ "D.modify_date, I.file_id from product P inner join category C on P.category_id = C.id "
			+ "inner join display_info D on P.id = D.product_id "
			+ "inner join product_image I on P.id = I.product_id where type = \"ma\" and C.id = :categoryId "
			+ "LIMIT :start, :limit";
	public static final String TOTAL_COUNT_BY_CATEGORY = "select count(*) from display_info d inner join product p on d.product_id = p.id "
			+ "inner join category c on p.category_id = c.id where c.id = :categoryId";
	
	public static final String PRODUCT_COUNT = "select count(*) from display_info d inner join product p on d.product_id = p.id "
			+ "inner join category c on p.category_id = c.id";
	
	public static final String SELECT_PROMOTION = "select M.id, M.product_id, .P.category_id, C.name as category_name, P.description, I.file_id from promotion M \r\n"
			+ "inner join product P on M.product_id = P.id \r\n"
			+ "inner join category C on P.category_id = C.id \r\n"
			+ "inner join product_image I on P.id = I.product_id where type = \"ma\"";
	public static final String PROMOTION_COUNT = "select count(*) from promotion";
	public static final String SELECT_DISPLAY_INFO = "select P.id, C.id as category_id , D.id as display_info_id, C.name, P.description, P.content, P.event, D.opening_hours, "
			+ "D.place_name, D.place_lot, D.place_street, D.tel, D.homepage, D.email, D.create_date, "
			+ "D.modify_date, I.file_id from product P inner join category C on P.category_id = C.id "
			+ "inner join display_info D on P.id = D.product_id "
			+ "inner join product_image I on P.id = I.product_id where type = \"ma\" and D.id = :id";
	public static final String SELECT_PRODUCT_IMG = "select p.id as product_id, I.id as product_image_id, I.type, I.file_id as file_info_id, F.file_name, F.save_file_name, F.content_type, F.delete_flag, F.create_date, F.modify_date\r\n"
			+ "from product_image I inner join product P on I.product_id = P.id \r\n"
			+ "inner join file_info F on I.file_id = F.id where type = \"ma\" and p.id = :id";
	public static final String SELECT_DISPLAY_INFO_IMG = "select D.id, D.display_info_id, D.file_id, F.file_name, F.save_file_name, F.content_type, F.delete_flag, F.create_date, F.modify_date\r\n"
			+ "from display_info_image D inner join file_info F on D.file_id = F.id\r\n"
			+ "inner join display_info DI on D.display_info_id = DI.id where DI.product_id = :id";
	public static final String SELECT_PRODUCTPRICES = "select * from product_price where product_id = :id order by price asc";
	public static final String AVGSCORE = "select avg(score) from reservation_user_comment where product_id = :id";
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