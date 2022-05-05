package pe.edu.upc.ropa.model.repository;

import java.util.List;

import pe.edu.upc.ropa.model.entity.Order;


public interface OrderRepository extends JpaRepository<Order, Integer> {
	List<Order> findByPickUpWay(String pickUpWay) throws Exception;
}
