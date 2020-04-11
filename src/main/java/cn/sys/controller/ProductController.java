package cn.sys.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.sys.entity.CategoryExample;
import cn.sys.entity.Product;
import cn.sys.entity.ProductExample;
import cn.sys.entity.User;
import cn.sys.entity.Product;
import cn.sys.service.ProductService;
import cn.sys.utils.PageResult;
import cn.sys.utils.Result;

@RestController
@RequestMapping(value="product")
public class ProductController {

	@Autowired
	private ProductService ProductService;
	
	@RequestMapping("findAll")
	public List<Product> findALl(Product Product){
		ProductExample example = new ProductExample();
		return ProductService.findAll(example);
	}
	
	@RequestMapping("add")
	public Result add(HttpServletRequest request,Product Product){
		try {
			if(Product.getId()==null){
				Product.setDate(new Date());
				this.ProductService.add(Product);
			}else{
				this.ProductService.update(Product);
			}
			return new Result(true, "成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "失败");
		}
	}
	
	@RequestMapping("findPage")
	public PageResult findPage(Product product,Integer page,Integer rows){
		ProductExample example = new ProductExample();
		ProductExample.Criteria criteria = example.createCriteria();
		if(product.getName()!=null && product.getName() !=""){
			criteria.andNameLike("%"+product.getName()+"%");
		}
		if(product.getCid() != null){
			criteria.andCidEqualTo(product.getCid());
		}
		return this.ProductService.findPage(example,page,rows);
	}
	
	@RequestMapping("findOne")
	public Product findOne(Integer id){
		Product Product = this.ProductService.findOne(id);
		return Product;
	}
	
	@RequestMapping(value="delete")
	public Result delete(String ids,Integer a){
		
		try {
			for (String id : ids.split(",")) {
				this.ProductService.delete(Integer.parseInt(id));
			}
			return new Result(true, "操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "操作失败");
		}
	} 
	
}
