package com.ecommerce.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="usu_id")
	private Long usuId;

	@Column(name="usu_tip")
	private String usuTip;

	@Column(name="usu_nom")
	private String usuNom;

	@Column(name="usu_dni")
	private String usuDni;

	@Column(name="usu_ema")
	private String usuEma;

	@Column(name="usu_dir")
	private String usuDir;

	@Column(name="usu_tel")
	private String usuTel;

	@Column(name="usu_con")
	private String usuCon;

	@OneToMany(mappedBy="usuario")
	private List<Boleta> boletas;
}
