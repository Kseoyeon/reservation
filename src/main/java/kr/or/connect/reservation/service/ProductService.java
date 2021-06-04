package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.DisplayInfoImage;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;

public interface ProductService {
	public static final Integer LIMIT = 4;
	public List<Product> getProducts(Integer id);
	public List<Product> getCategoryProducts(Integer categoryId, Integer start);
	public List<Product> getEachProduct(Integer id);	
	public List<ProductImage> getProductImage(Integer id);
	public List<DisplayInfoImage> getDisplayInfoImage(Integer id);
	public List<ProductPrice> getProductPrice(Integer id);
	public int getProductCount(Integer id);
	public int getAllProductCount();
	public int getAvgScore(Integer id);
}
