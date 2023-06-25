package com.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ecommerce.models.Usuario;
import com.ecommerce.services.UsuarioServiceImpl;

@Controller
public class UsuarioController {
	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPwdEncoder;
	
	@GetMapping({"/","/login"})
	public String login(Model model) {
		model.addAttribute("usuario",new Usuario());
		return "login";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
    @GetMapping("/registro")
    public String registrarUsuario(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "registroUsuario";
    }

    @PostMapping("/registro")
    public String registrarUsuario(@ModelAttribute Usuario usuario) {
    	usuario.setUsuTip("ROLE_CLIENTE");
    	usuario.setUsuCon(bCryptPwdEncoder.encode(usuario.getUsuCon()));
        usuarioService.saveUsuario(usuario);
        return "redirect:/?exito";
    }
}
