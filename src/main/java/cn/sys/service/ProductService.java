package cn.sys.service;

import java.util.List;

import cn.sys.entity.Product;
import cn.sys.entity.ProductExample;
import cn.sys.utils.PageResult;

public interface ProductService {

	List<Product> findAll();

	void add(Product Product);

	void update(Product Product);

	PageResult findPage(ProductExample example, Integer page, Integer rows);

	cn.sys.entity.Product findOne(Integer id);

	void delete(int parseInt);

	List<Product> findAll(ProductExample example);

}
