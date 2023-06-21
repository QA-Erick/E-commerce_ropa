package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.ecommerce.models.Usuario;


public interface UsuarioService {
	public List<Usuario> getAllUsuarios();
	
	public void deleteUsuario(Long usuId);
	
	void saveUsuario(Usuario usuario);
	
    Usuario getUsuarioById(Long usuId);
}
