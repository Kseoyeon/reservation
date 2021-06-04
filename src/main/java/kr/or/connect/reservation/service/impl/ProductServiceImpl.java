package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.ProductDao;
import kr.or.connect.reservation.dto.DisplayInfoImage;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;
import kr.or.connect.reservation.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao productDao;
	
	@Override
	@Transactional
	public List<Product> getProducts(Integer id) {
		List<Product> list = productDao.selectProduct(id);
		return list;
	}
	
	@Override
	@Transactional
	public List<Product> getCategoryProducts(Integer categoryId, Integer start) {
		List<Product> list = productDao.selectCategoryProduct(categoryId, start, ProductService.LIMIT);
		return list;
	}
	
	@Override
	@Transactional
	public List<Product> getEachProduct(Integer id) {
		List<Product> list = productDao.selectEachProduct(id);
		return list;
	}
	
	@Override
	@Transactional
	public List<ProductImage> getProductImage(Integer id) {
		List<ProductImage> list = productDao.selectProductImage(id);
		return list;
	}
	
	@Override
	@Transactional
	public List<DisplayInfoImage> getDisplayInfoImage(Integer id) {
		List<DisplayInfoImage> list = productDao.selectDisplayInfoImage(id);
		return list;
	}
	
	@Override
	@Transactional
	public List<ProductPrice> getProductPrice(Integer id) {
		List<ProductPrice> list = productDao.selectProductPrice(id);
		return list;
	}
	
	@Override
	public int getProductCount(Integer id) {
		return productDao.ProductCategoryCount(id);
	}
	
	@Override
	public int getAllProductCount() {
		return productDao.ProductAllCount();
	}
	
	@Override
	public int getAvgScore(Integer id) {
		return productDao.AvgScore(id);
	}
}
