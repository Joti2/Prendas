package pe.edu.upc.ropa.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.ropa.business.crud.CrudService;
import pe.edu.upc.ropa.business.crud.OrderService;
import pe.edu.upc.ropa.model.entity.Order;



@Named("orderView")
@ViewScoped
public class OrderView implements Serializable, EntityView<Order, Integer> {

	private static final long serialVersionUID = 1L;
	
	private List<Order> entities;
	private Order entitySelected;
	private List<Order> entitiesSelected;
	private Order entitySearch;

	@Inject
	private OrderService entityService;
	
	@PostConstruct
	public void init() {
		this.entitiesSelected = new ArrayList<>();
		this.entitySearch = new Order();
		getAllEntities();
	}
	
	@Override
	public CrudService<Order, Integer> getCrudService() {
		return this.entityService;
	}

	@Override
	public void createNew() {
		this.entitySelected= new Order();
	}

	@Override
	public Integer getIdFromEntitySelected() {
		return this.entitySelected.getId();
	}

	@Override
	public void searchEntity() {
		try {	
			this.entities = this.entityService.search(this.entitySearch.getPickUpWay());
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}

	public List<Order> getEntities() {
		return entities;
	}

	public void setEntities(List<Order> entities) {
		this.entities = entities;
	}

	public Order getEntitySelected() {
		return entitySelected;
	}

	public void setEntitySelected(Order entitySelected) {
		this.entitySelected = entitySelected;
	}

	public List<Order> getEntitiesSelected() {
		return entitiesSelected;
	}

	public void setEntitiesSelected(List<Order> entitiesSelected) {
		this.entitiesSelected = entitiesSelected;
	}

	public Order getEntitySearch() {
		return entitySearch;
	}

	public void setEntitySearch(Order entitySearch) {
		this.entitySearch = entitySearch;
	}

	public OrderService getEntityService() {
		return entityService;
	}

	public void setEntityService(OrderService entityService) {
		this.entityService = entityService;
	}

	

}
