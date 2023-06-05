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
@Table(name = "Producto")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="prd_id")
	private int prdId;

	@Column(name="prd_nom")
	private String prdNom;

	@Column(name="prd_des")
	private String prdDes;

	@Column(name="prd_pre")
	private double prdPre;

	@ManyToOne
	@JoinColumn(name="id_cat")
	private Categoria categoria;

	@OneToMany(mappedBy="producto")
	private List<ItemsBoleta> itemsBoletas;
}
