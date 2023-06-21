package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.models.Usuario;
import com.ecommerce.repositories.UsuarioDao;



@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDao usuarioRepository;
	
	@Override
	public List<Usuario> getAllUsuarios() {
		return this.usuarioRepository.findAll();
	}
	
	@Override
    public void deleteUsuario(Long usuId) {
        this.usuarioRepository.deleteById(usuId);
    }
	
	 @Override
	    public void saveUsuario(Usuario usuario) {
	        usuarioRepository.save(usuario);
	}
	 
	 @Override
	    public Usuario getUsuarioById(Long usuId) {
	        return usuarioRepository.findById(usuId).orElse(null);
	 }

}
