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

import tarea.models.entities.Telefonos;
import tarea.models.services.TelefonosService;

@Controller
@SessionAttributes("telefonos")
public class TelefonosControllers {
	@Autowired
	private TelefonosService telefonosService;
	
	@RequestMapping(value="/listartelefonos", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("title","listado de tlefonos");
		model.addAttribute("telefonos", telefonosService.findAll());
		return "listartelefonos";
	}
	
	@RequestMapping(value="/formtelefonos") 
	public String crear(Map<String, Object> model) {
		Telefonos telefonos = new Telefonos();
		model.put("telefonos", telefonos);
		model.put("title", "Formulario de telefonos");
		return "formtelefonos";
	}
	
	@RequestMapping(value="/formtelefonos", method=RequestMethod.POST)
	public String guardar(@Valid Telefonos telefonos, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus ) {
		telefonosService.save(telefonos);
		sessionStatus.setComplete(); 
		
		flash.addFlashAttribute("success","Telefono creado con exito");
		return "redirect:listartelefonos";
	}
	
	@RequestMapping(value="/formtelefonos/{tel_id}")
	public String editar(@PathVariable(value="tel_id") Long tel_id, Map<String, Object> model, RedirectAttributes flash) {
		Telefonos telefonos = null;
		if (tel_id > 0) {
			telefonos = telefonosService.findOne(tel_id);
		}else {
			flash.addFlashAttribute("error","El Id del telefono no puede ser cero");
			return "redirect:/listartelefonos";
		}
		model.put("telefonos", telefonos);
		model.put("title", "Editar telefono");
		
		return "formtelefonos";
	}
	
	@RequestMapping(value="/eliminartelefonos/{tel_id}")
	public String eliminar(@PathVariable(value="tel_id") Long tel_id, RedirectAttributes flash) {
		if (tel_id > 0 ) {
			telefonosService.delete(tel_id);
		}
		flash.addFlashAttribute("success","Telefono eliminado con exito");
		return "redirect:/listartelefonos";
	}
}
