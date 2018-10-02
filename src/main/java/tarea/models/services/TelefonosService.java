package tarea.models.services;

import java.util.List;

import tarea.models.entities.Telefonos;

public interface TelefonosService {	
	public List<Telefonos> findAll();	
	public void save(Telefonos telefonos);	
	public Telefonos findOne(Long id);	
	public void delete(Long tel_id);	
}
