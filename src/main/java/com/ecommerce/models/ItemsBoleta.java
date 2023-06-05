package com.ecommerce.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Items_Boleta")
public class ItemsBoleta implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="itb_id")
	private int itbId;

	@Column(name="itb_can")
	private int itbCan;

	@ManyToOne
	@JoinColumn(name="id_bol")
	private Boleta boleta;

	@ManyToOne
	@JoinColumn(name="id_prd")
	private Producto producto;
}
