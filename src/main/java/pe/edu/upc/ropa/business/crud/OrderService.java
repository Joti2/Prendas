package pe.edu.upc.ropa.business.crud;

import java.util.List;

import pe.edu.upc.ropa.model.entity.Order;

public interface OrderService extends CrudService<Order, Integer>{
	List<Order> findByPickUpWay(String pickUpWay) throws Exception;
}
