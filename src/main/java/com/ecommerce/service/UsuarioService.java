package com.ecommerce.service;

import java.util.List;

import com.ecommerce.models.Usuario;


public interface UsuarioService {
	public List<Usuario> getAllUsuarios();
	
	public void deleteUsuario(Long usuId);
}
