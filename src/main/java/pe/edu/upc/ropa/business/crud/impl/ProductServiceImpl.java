package pe.edu.upc.ropa.business.crud.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.ropa.business.crud.ProductService;
import pe.edu.upc.ropa.model.entity.Product;
import pe.edu.upc.ropa.model.repository.JpaRepository;
import pe.edu.upc.ropa.model.repository.ProductRepository;

@Named
@ApplicationScoped

public class ProductServiceImpl implements ProductService{
    
	@Inject
	private ProductRepository productRepository;
	
	@Override
	public JpaRepository<Product, Integer> getJpaRepository() {
		return this.productRepository;
	}

	@Override
	public List<Product> findByName(String name) throws Exception {
		return this.productRepository.findByName(name);
	}

}
