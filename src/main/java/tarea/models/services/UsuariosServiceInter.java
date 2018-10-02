package tarea.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tarea.models.dao.UsuariosDao;
import tarea.models.entities.Usuarios;

@Service
public class UsuariosServiceInter implements UsuariosService{
	@Autowired
	private UsuariosDao usuariosDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Usuarios> findAll() {
		return (List<Usuarios>) usuariosDao.findAll();
	}

	@Override
	@Transactional
	public void save(Usuarios perfiles) {
		usuariosDao.save(perfiles);		
	}

	@Override
	@Transactional(readOnly=true)
	public Usuarios findOne(Long usu_id) {
		return usuariosDao.findById(usu_id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long usu_id) {
		usuariosDao.deleteById(usu_id);
	}
}
