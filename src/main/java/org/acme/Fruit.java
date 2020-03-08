package org.acme;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Fruit extends PanacheEntity{

//	@Id
//	@SequenceGenerator(
//			name="fruitSequence",
//			sequenceName = "fruit_id_seq",
//			allocationSize = 1,
//			initialValue = 4
//			)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "fruitSequence")
//	public Integer id;
	public String name;
	public String description;
	
	public Fruit() {
	}
	
	
	public Fruit(String name, String description) {
		this.name = name;
		this.description = description;
	}
}
