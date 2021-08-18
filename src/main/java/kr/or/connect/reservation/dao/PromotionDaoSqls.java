package kr.or.connect.reservation.dao;

public class PromotionDaoSqls {
	public static final String SELECT_PROMOTION = "select M.id, M.product_id, .P.category_id, C.name as category_name, P.description, I.file_id from promotion M \r\n"
			+ "inner join product P on M.product_id = P.id \r\n"
			+ "inner join category C on P.category_id = C.id \r\n"
			+ "inner join product_image I on P.id = I.product_id where type = \"ma\"";
	public static final String PROMOTION_COUNT = "select count(*) from promotion";
}
