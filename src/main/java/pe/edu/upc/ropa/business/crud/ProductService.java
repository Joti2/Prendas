package pe.edu.upc.ropa.business.crud;

import java.util.List;

import pe.edu.upc.ropa.model.entity.Product;

public interface ProductService extends CrudService<Product, Integer> {
	List<Product> findByName(String name) throws Exception;
}
