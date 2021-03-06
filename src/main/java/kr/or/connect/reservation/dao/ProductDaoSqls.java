package kr.or.connect.reservation.dao;

public class ProductDaoSqls {
	public static final String SELECT_PRODUCTPRICE = "SELECT product_price.id AS productPriceId, product.id AS productId, "
			+ "product_price.price_type_name, product_price.price, product_price.discount_rate, "
			+ "product_price.create_date, product_price.modify_date FROM product "
			+ "INNER JOIN display_info ON product.id = display_info.product_id "
			+ "INNER JOIN product_price ON product.id = product_price.product_id "
			+ "WHERE display_info.id = :displayInfoId ORDER BY productPriceId desc";
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
	public static final String SELECT_PRODUCTPRICES = "select * from product_price where product_id = :id order by price asc";
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
	public static final String AVGSCORE = "select avg(score) from reservation_user_comment where product_id = :id";
}
