package com.ecommerce.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.models.Producto;

@Repository
public interface ProductoDao extends CrudRepository<Producto, Integer> {
	public List<Producto> findAll();
	
	public List<Producto> findAllByPrdNomContainingIgnoreCase(String nombre);
	
	//NUEVOS MÉTODOS
	//OBTENER UN ELEMENTO
	//Producto findByprdIdAndDeletedFalse(Long id);//findById(Long id);
	//ELIMINAR UN ELEMENTO
    void deleteByprdId(int id);
}
