package tarea.models.services;

import java.util.List;

import tarea.models.entities.Usuarios;

public interface UsuariosService {
	public List<Usuarios> findAll();	
	public void save(Usuarios usuarios);	
	public Usuarios findOne(Long id);	
	public void delete(Long usu_id);	
}
