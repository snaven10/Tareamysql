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
import tarea.models.services.PerfilesService;

@Controller
@SessionAttributes("perfiles")
public class PerfilesControllers {
	@Autowired
	private PerfilesService perfilesService;
	
	@RequestMapping(value="/listarperfiles", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("title","listado de perfiles");
		model.addAttribute("perfiles", perfilesService.findAll());
		return "listarperfiles";
	}
	
	@RequestMapping(value="/formperfiles") 
	public String crear(Map<String, Object> model) {
		Perfiles perfiles = new Perfiles();
		model.put("perfiles", perfiles);
		model.put("title", "Formulario de perfiles");
		return "formperfiles";
	}
	
	@RequestMapping(value="/formperfiles", method=RequestMethod.POST)
	public String guardar(@Valid Perfiles perfiles, BindingResult bindingResult, RedirectAttributes flash, SessionStatus sessionStatus ) {
		perfilesService.save(perfiles);
		sessionStatus.setComplete();
		
		flash.addFlashAttribute("success","Telefono creado con exito");
		return "redirect:listarperfiles";
	}
	
	@RequestMapping(value="/formperfiles/{perf_id}")
	public String editar(@PathVariable(value="perf_id") Long perf_id, Map<String, Object> model, RedirectAttributes flash) {
		Perfiles perfiles = null;
		if (perf_id > 0) {
			perfiles = perfilesService.findOne(perf_id);
		}else {
			flash.addFlashAttribute("error","El Id del perfiles no puede ser cero");
			return "redirect:/listarperfiles";
		}
		model.put("perfiles", perfiles);
		model.put("title", "Editar perfiles");
		
		return "formperfiles";
	}
	
	@RequestMapping(value="/eliminarperfiles/{perf_id}")
	public String eliminar(@PathVariable(value="perf_id") Long perf_id, RedirectAttributes flash) {
		if (perf_id > 0 ) {
			perfilesService.delete(perf_id);
		}
		flash.addFlashAttribute("success","Perfiles eliminado con exito");
		return "redirect:/listarperfiles";
	}
}
