package com.ecommerce.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Boleta")
public class Boleta implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bol_id")
	private int bolId;

	@Column(name="bol_fec")
	private String bolFec;
	
	@ManyToOne
	@JoinColumn(name="id_usu")
	private Usuario usuario;
	
	@OneToMany(mappedBy="boleta")
	private List<ItemsBoleta> itemsBoletas;
}
