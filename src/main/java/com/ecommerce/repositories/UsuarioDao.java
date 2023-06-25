package com.ecommerce.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.models.Usuario;

@Repository
public interface UsuarioDao extends CrudRepository<Usuario, Long> {
	Usuario findByUsuEma(String email);
	Usuario save(Usuario usuario);
}
