package com.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecommerce.models.Usuario;
import com.ecommerce.repositories.UsuarioDao;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {
	@Autowired
	private UsuarioDao usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = findByUsuarioEmail(email);
		
		if (usuario == null) {
			throw new UsernameNotFoundException("Correo o contraseña invalidos");
		}
		
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority(usuario.getUsuTip()));
		
		UserDetails ud = new User(usuario.getUsuEma(), usuario.getUsuCon(), roles);
		return ud;
	}
	
	@Override
	public Usuario findByUsuarioEmail(String email) {
		return usuarioRepository.findByUsuEma(email);
	}
	
	@Override 
	public void saveUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	@Override
	public List<Usuario> getAllUsuarios() {
		return this.usuarioRepository.findAll();
	}
	
	@Override
    public void deleteUsuario(Long usuId) {
        this.usuarioRepository.deleteById(usuId);
    }

	@Override
	public Usuario getUsuarioById(Long usuId) {
		return usuarioRepository.findById(usuId).orElse(null);
	}
}
