package pe.edu.upc.ropa.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Categoria {
	
	@Id
	private Integer id;
	
    @OneToMany
	private List<Product> products;

}
