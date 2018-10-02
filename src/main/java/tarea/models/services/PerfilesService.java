package tarea.models.services;

import java.util.List;

import tarea.models.entities.Perfiles;

public interface PerfilesService {
	public List<Perfiles> findAll();	
	public void save(Perfiles perfiles);	
	public Perfiles findOne(Long id);	
	public void delete(Long perf_id);	
}
