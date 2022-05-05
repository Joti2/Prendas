package pe.edu.upc.ropa.model.repository;

import java.util.List;

import pe.edu.upc.ropa.model.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByName(String name) throws Exception;
}
