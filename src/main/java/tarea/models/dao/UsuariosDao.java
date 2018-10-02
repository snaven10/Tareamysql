package tarea.models.dao;

import org.springframework.data.repository.CrudRepository;

import tarea.models.entities.Usuarios;

public interface UsuariosDao extends CrudRepository<Usuarios, Long>{

}
