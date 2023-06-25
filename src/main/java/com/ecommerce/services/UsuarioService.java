package com.ecommerce.services;

import com.ecommerce.models.Usuario;

public interface UsuarioService {
	Usuario findByUsuarioEmail(String email);
	void saveUsuario(Usuario usuario);
}
