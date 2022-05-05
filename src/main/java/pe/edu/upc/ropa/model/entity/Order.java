package pe.edu.upc.ropa.model.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "orders", indexes = {@Index(columnList = "pick_up_way", name = "orders_index_pick_up_way")})

public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
		
	@Column(name = "pick_up_way", length = 30, nullable = false)
	private String pickUpWay;
		
	@Column(name = "order_date",length = 30, nullable = false)
	private String orderDate;
	
	@Column(name = "total", nullable = false)
	private float total;
	
	@OneToMany(mappedBy = "order")
	private List<Customer> customers;
	
	public Order() {
		customers=new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public String getPickUpWay() {
		return pickUpWay;
	}

	public void setPickUpWay(String pickUpWay) {
		this.pickUpWay = pickUpWay;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	
	
	
	 
}
