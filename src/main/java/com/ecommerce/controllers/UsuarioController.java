package com.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.models.Usuario;
import com.ecommerce.service.UsuarioService;
import com.ecommerce.service.UsuarioServiceImpl;



@Controller
@RequestMapping("/home")
public class UsuarioController {

	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	@Value("${index.titulo.text}")
	private String title;
	
	@GetMapping({"/index","/","","/home"})
	public String index(Model model) {
		model.addAttribute("titulo",title);
		return "indexUsuario";
	}
	
	@GetMapping("/delete/{usuId}")
    public String deleteUsuario(@PathVariable Long usuId) {
        usuarioService.deleteUsuario(usuId);
        return "redirect:/home";
    }
	
	@ModelAttribute("usuarios")
	public List<Usuario> obtenerUsuarios(){
		List<Usuario> usuarios = usuarioService.getAllUsuarios();
		
		return usuarios;
	}
	
	
	@GetMapping("/edit/{usuId}")
    public String showEditForm(@PathVariable("usuId") Long usuId, Model model) {
        Usuario usuario = usuarioService.getUsuarioById(usuId);
        model.addAttribute("usuario", usuario);
        return "editUsuario";
    }

    @PostMapping("/edit/{usuId}")
    public String updateUsuario(@PathVariable("usuId") Long usuId, @ModelAttribute Usuario usuario) {
        usuario.setUsuId(usuId);
        usuarioService.saveUsuario(usuario);
        return "redirect:/home";
    }
    
    
    @GetMapping("/add")
    public String showAddForm(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "addUsuario";
    }

    @PostMapping("/add")
    public String addUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.saveUsuario(usuario);
        return "redirect:/home";
    }
}



























