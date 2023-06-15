package com.ecommerce.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.models.Usuario;


@Repository
public interface UsuarioDao extends CrudRepository<Usuario, Long> {
	public List <Usuario> findAll();
	
	public void deleteById(Long usuId);
}
