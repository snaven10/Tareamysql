package tarea.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tarea.models.entities.Perfiles;
import tarea.models.entities.Usuarios;
import tarea.models.services.PerfilesService;
import tarea.models.services.UsuariosService;

@Controller
@SessionAttributes("usuarios")
public class UsuariosControllers {
	@Autowired
	private UsuariosService usuariosService; 
	/*private PerfilesService perfilesService;*/
	
	@RequestMapping(value="/listarusuarios", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("title","listado de usuarios");
		model.addAttribute("usuarios", usuariosService.findAll());
		return "listarusuarios";
	}
	
	@RequestMapping(value="/formusuarios") 
	public String crear(Map<String, Object> model) {
		Usuarios usuarios = new Usuarios();
		/*model.put("perfiles", perfilesService.findAll());*/
		model.put("usuarios", usuarios);
		model.put("title", "Formulario de usuarios");
		return "formusuarios";
	}
	
	@RequestMapping(value="/formusuarios", method=RequestMethod.POST)
	public String guardar(@Valid Usuarios usuarios, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus ) {
		usuariosService.save(usuarios);
		sessionStatus.setComplete();
		
		flash.addFlashAttribute("success","Usuario creado con exito");
		return "redirect:listarusuarios";
	}
	
	@RequestMapping(value="/formusuarios/{usu_id}")
	public String editar(@PathVariable(value="usu_id") Long usu_id, Map<String, Object> model, RedirectAttributes flash) {
		Usuarios usuarios = null;
		if (usu_id > 0) {
			usuarios = usuariosService.findOne(usu_id);
		}else {
			flash.addFlashAttribute("error","El Id del usuarios no puede ser cero");
			return "redirect:/listarusuarios";
		}
		/*model.put("perfiles", perfilesService.findAll());*/
		model.put("usuarios", usuarios);
		model.put("title", "Editar usuarios");
		
		return "formusuarios";
	}
	
	@RequestMapping(value="/eliminarusuarios/{usu_id}")
	public String eliminar(@PathVariable(value="usu_id") Long usu_id, RedirectAttributes flash) {
		if (usu_id > 0 ) {
			usuariosService.delete(usu_id);
		}
		flash.addFlashAttribute("success","Usuarios eliminado con exito");
		return "redirect:/listarusuarios";
	}
}
