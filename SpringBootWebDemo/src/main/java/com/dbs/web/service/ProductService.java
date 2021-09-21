package com.dbs.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.web.beans.Product;
import com.dbs.web.repository.ProductRepository;


@Service
public class ProductService {


	public ProductService() {
	}

	@Autowired
	private ProductRepository repository;

	public long getProductsCount()
	{
		return this.repository.count();
	}
	public int insertProduct(Product product)
	{
		if(this.repository.findById(product.getPid()).isPresent())
			return -1;
		try {
			return this.repository.save(product).getPid();
		}catch(IllegalArgumentException e )
		{
			return -1;
		}
	}
	public boolean updateProduct(Product product)
	{
		try {
			this.repository.save(product);
		}catch(IllegalArgumentException e )
		{
			return false;
		}
		return true;
	}

	public boolean deleteProduct(int id) throws Exception
	{
		try {
			this.repository.deleteById(id);
		}catch(IllegalArgumentException e )
		{
			
			throw new IllegalArgumentException("Could not delete");
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
		return true;
	}
	public Product findProductById(int id)
	{
		try {
			Optional<Product> prod = this.repository.findById(id);

			return prod.orElseThrow(()->{
	
				return new EntityNotFoundException("Product with "+id + " does not exist");
			});

		}catch(IllegalArgumentException e )
		{
			return null;
		}

	}
	
	public List<Product> getProducts(double price)
	{
		return this.repository.findAllByPriceGreaterThan(price);
	}
	public List<Product> getProducts()
	{
		List<Product> products = new ArrayList<Product>();
		this.repository.findAll().forEach(prod->products.add(prod));
		return products;
	}
}
