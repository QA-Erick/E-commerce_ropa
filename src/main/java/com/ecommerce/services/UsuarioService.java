package com.ecommerce.services;

import java.util.List;

import com.ecommerce.models.Usuario;

public interface UsuarioService {
	Usuario findByUsuarioEmail(String email);
	
	void saveUsuario(Usuario usuario);
	
	public List<Usuario> getAllUsuarios();
	
	public void deleteUsuario(Long usuId);
	
    Usuario getUsuarioById(Long usuId);
}
