package pe.edu.upc.ropa.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.ropa.model.entity.Product;
import pe.edu.upc.ropa.model.repository.ProductRepository;

@Named
@ApplicationScoped

public class ProductRepositoryImpl implements ProductRepository {

	@PersistenceContext(unitName = "ropaPU")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	@Override
	public Optional<Product> findById(Integer id) throws Exception {
		return this.findById(id, Product.class);
	}

	@Override
	public List<Product> findAll() throws Exception {
		String jpql = "SELECT product FROM Product product";
		return this.findByQuery(Product.class, jpql); 
	}

	@Override
	public List<Product> findByData(String data) throws Exception {
		String jpql = "SELECT product FROM Product product WHERE product.name LIKE '%" + data + "%'";  
		return this.findByQuery(Product.class, jpql);
	}

	@Override
	public List<Product> findByName(String name) throws Exception {
		String jpql = "SELECT product FROM Product product WHERE product.name = '" + name + "'";
		return this.findByQuery(Product.class, jpql);
	}

}
