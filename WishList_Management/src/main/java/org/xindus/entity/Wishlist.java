package org.xindus.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Wishlist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int wID;
	
	@Column(nullable=false, unique =true)
	private String wname;
	
	@Column
	private String description;
	
	@ManyToOne
	@JoinColumn(name="uID")
	@JsonIgnore
	private User user;
	
	@OneToMany(mappedBy="wishlist", fetch = FetchType.EAGER)
	private List<Product> products;
}
