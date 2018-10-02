package tarea.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tarea.models.dao.PerfilesDao;
import tarea.models.entities.Perfiles;

@Service
public class PefilesServiceInter implements PerfilesService{
	@Autowired
	private PerfilesDao perfilesDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Perfiles> findAll() {
		return (List<Perfiles>) perfilesDao.findAll();
	}

	@Override
	@Transactional
	public void save(Perfiles perfiles) {
		perfilesDao.save(perfiles);		
	}

	@Override
	@Transactional(readOnly=true)
	public Perfiles findOne(Long perf_id) {
		return perfilesDao.findById(perf_id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long perf_id) {
		perfilesDao.deleteById(perf_id);
	}
}
