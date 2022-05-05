package pe.edu.upc.ropa.business.crud.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pe.edu.upc.ropa.model.entity.Order;

import pe.edu.upc.ropa.business.crud.OrderService;
import pe.edu.upc.ropa.model.repository.JpaRepository;
import pe.edu.upc.ropa.model.repository.OrderRepository;

@Named
@ApplicationScoped

public class OrderServiceImpl implements OrderService {
	
	@Inject
	private OrderRepository orderRepository;

	@Override
	public JpaRepository<Order, Integer> getJpaRepository() {
		return this.orderRepository;
	}

	@Override
	public List<Order> findByPickUpWay(String pickUpWay) throws Exception {
		return this.orderRepository.findByPickUpWay(pickUpWay);
	}

}
