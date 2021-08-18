package kr.or.connect.reservation.dao;

public class CategoryDaoSqls {
	public static final String SELECT_CATEGORY = "select A.id, A.name, count(A.id) as count from category A left outer join product B on a.id = b.category_id group by A.id";
	public static final String SELECT_CATEGORY_COUNT = "select count(*) from category";
}
