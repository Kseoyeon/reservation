package kr.or.connect.reservation.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.DisplayInfoImage;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;

import static kr.or.connect.reservation.dao.ProductDaoSqls.*;

@Repository
public class ProductDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);
	private RowMapper<ProductImage> rowMapper_PI = BeanPropertyRowMapper.newInstance(ProductImage.class);
	private RowMapper<DisplayInfoImage> rowMapper_DI = BeanPropertyRowMapper.newInstance(DisplayInfoImage.class);
	private RowMapper<ProductPrice> rowMapper_PP = BeanPropertyRowMapper.newInstance(ProductPrice.class);
	
	public ProductDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("product");
	}
	
	public List<Product> selectProduct(Integer id) {
		Map<String, Integer> params = new HashMap<>();
		params.put("id", id);
		return jdbc.query(SELECT_PRODUCT_ALL, params, rowMapper);
	}
	
	public List<Product> selectCategoryProduct(Integer categoryId, Integer start, Integer limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(SELECT_PRODUCT, params, rowMapper);
	}
	
	public int ProductAllCount() {
		return jdbc.queryForObject(PRODUCT_COUNT, Collections.emptyMap(), Integer.class);
	}
	
	public int ProductCategoryCount(Integer id) {
		Map<String, ?> params = Collections.singletonMap("categoryId", id);
		return jdbc.queryForObject(TOTAL_COUNT_BY_CATEGORY, params, Integer.class);
	}
	
	public List<Product> selectEachProduct(Integer id) {
		Map<String, Integer> params = new HashMap<>();
		params.put("id", id);
		return jdbc.query(SELECT_DISPLAY_INFO, params, rowMapper);
	}
	
	public List<ProductImage> selectProductImage(Integer id) {
		Map<String, Integer> params = new HashMap<>();
		params.put("id", id);
		return jdbc.query(SELECT_PRODUCT_IMG, params, rowMapper_PI);
	}
	
	public List<DisplayInfoImage> selectDisplayInfoImage(Integer id) {
		Map<String, Integer> params = new HashMap<>();
		params.put("id", id);
		return jdbc.query(SELECT_DISPLAY_INFO_IMG, params, rowMapper_DI);
	}
	
	public List<ProductPrice> selectProductPrice(Integer id) {
		Map<String, Integer> params = new HashMap<>();
		params.put("id", id);
		return jdbc.query(SELECT_PRODUCTPRICES, params, rowMapper_PP);
	}
	
	public int AvgScore(Integer id) {
		Map<String, ?> params = Collections.singletonMap("id", id);
		return jdbc.queryForObject(AVGSCORE, params, Integer.class);
	}
}
