package tarea.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="perfiles")
public class Perfiles implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perfiles_Seq")
	@SequenceGenerator(name = "perfiles_Seq", sequenceName = "PERFILES_SEQ")
	@Column(name = "perf_id", updatable = false, nullable = false)
	private Long perf_id;
	
	@Column(name="descripcion")
	@NotEmpty
	private String descripcion;
	@NotNull
	
	@Column(name="cod_estado")
	@NotEmpty
	private String cod_estado;
	@NotNull
	
	public Long getPerf_id() {
		return perf_id;
	}
	public void setPerf_id(Long perf_id) {
		this.perf_id = perf_id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCod_estado() {
		return cod_estado;
	}
	public void setCod_estado(String cod_estado) {
		this.cod_estado = cod_estado;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
}
