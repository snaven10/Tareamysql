package tarea.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tarea.models.dao.TelefonosDao;
import tarea.models.entities.Telefonos;

@Service
public class TelefonosServiceInter implements TelefonosService {	
	@Autowired
	private TelefonosDao telefonosdao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Telefonos> findAll() {
		return (List<Telefonos>) telefonosdao.findAll();
	}

	@Override
	@Transactional
	public void save(Telefonos telefonos) {
		telefonosdao.save(telefonos);		
	}

	@Override
	@Transactional(readOnly=true)
	public Telefonos findOne(Long tel_id) {
		return telefonosdao.findById(tel_id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long tel_id) {
		telefonosdao.deleteById(tel_id);
	}
}
