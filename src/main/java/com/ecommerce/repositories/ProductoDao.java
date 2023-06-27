package com.ecommerce.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.models.Producto;

@Repository
public interface ProductoDao extends CrudRepository<Producto, Integer> {
	public List<Producto> findAll();
	
	public List<Producto> findAllByPrdNomContainingIgnoreCase(String nombre);
}
