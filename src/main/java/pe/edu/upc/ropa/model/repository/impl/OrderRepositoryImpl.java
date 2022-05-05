package pe.edu.upc.ropa.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.edu.upc.ropa.model.entity.Order;

import pe.edu.upc.ropa.model.repository.OrderRepository;

@Named
@ApplicationScoped

public class OrderRepositoryImpl implements OrderRepository {

	@PersistenceContext(unitName = "ropaPU")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	@Override
	public Optional<Order> findById(Integer id) throws Exception {
		return this.findById(id, Order.class);
	}

	@Override
	public List<Order> findAll() throws Exception {
		String jpql= "SELECT order FROM Order order";
		return this.findByQuery(Order.class, jpql);
	}

	@Override
	public List<Order> findByData(String data) throws Exception {
		String jpql = "SELECT order FROM Order order WHERE order.pickUpWay LIKE '%" + data + "%'";  
		return this.findByQuery(Order.class, jpql);
	}

	@Override
	public List<Order> findByPickUpWay(String pickUpWay) throws Exception {
		String jpql = "SELECT order FROM Order order WHERE order.pickUpWay = '" + pickUpWay + "'";
		return this.findByQuery(Order.class, jpql);
	}

}
