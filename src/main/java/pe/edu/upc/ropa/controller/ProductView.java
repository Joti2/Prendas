package pe.edu.upc.ropa.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.ropa.model.entity.Product;
import pe.edu.upc.ropa.business.crud.CrudService;
import pe.edu.upc.ropa.business.crud.ProductService;



@Named("productView")
@ViewScoped

public class ProductView implements Serializable, EntityView<Product, Integer> {

	private static final long serialVersionUID = 1L;
	
	private List<Product> entities;
	private Product entitySelected;
	private List<Product> entitiesSelected;
	private Product entitySearch;

	@Inject
	private ProductService entityService;
	
	@PostConstruct
	public void init() {
		this.entitiesSelected = new ArrayList<>();
		this.entitySearch = new Product();
		getAllEntities();
	}
	
	@Override
	public CrudService<Product, Integer> getCrudService() {
		return this.entityService;
	}

	@Override
	public void createNew() {
		this.entitySelected= new Product();
		
	}

	@Override
	public Integer getIdFromEntitySelected() {
		return this.entitySelected.getId();
	}

	@Override
	public void searchEntity() {
		try {	
			this.entities = this.entityService.search(this.entitySearch.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}

	public List<Product> getEntities() {
		return entities;
	}

	public void setEntities(List<Product> entities) {
		this.entities = entities;
	}

	public Product getEntitySelected() {
		return entitySelected;
	}

	public void setEntitySelected(Product entitySelected) {
		this.entitySelected = entitySelected;
	}

	public List<Product> getEntitiesSelected() {
		return entitiesSelected;
	}

	public void setEntitiesSelected(List<Product> entitiesSelected) {
		this.entitiesSelected = entitiesSelected;
	}

	public Product getEntitySearch() {
		return entitySearch;
	}

	public void setEntitySearch(Product entitySearch) {
		this.entitySearch = entitySearch;
	}

	public ProductService getEntityService() {
		return entityService;
	}

	public void setEntityService(ProductService entityService) {
		this.entityService = entityService;
	}

	
}
