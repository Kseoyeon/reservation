package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.Product;

public interface ProductService {
	public static final Integer LIMIT = 4;
	public List<Product> getProducts(Integer id);
	public List<Product> getCategoryProducts(Integer categoryId, Integer start);
	public int getProductCount(Integer id);
	public int getAllProductCount();
}
