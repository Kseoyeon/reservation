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
	
	public static final String SELECT_PROMOTION = "";
	public static final String PROMOTION_COUNT = "";
}