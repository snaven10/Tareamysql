package tarea.models.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="usuarios")
public class Usuarios implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarios_Seq")
	@SequenceGenerator(name = "usuarios_Seq", sequenceName = "USUARIOS_SEQ")
	@Column(name = "usu_id", updatable = false, nullable = false)
	private Long usu_id;
	
	@Column(name="usuario")
	@NotEmpty
	private String usuario;
	@NotNull
	
	@Column(name="password")
	@NotEmpty
	private String password;
	@NotNull
	
	@Column(name="nombre")
	@NotEmpty
	private String nombre;
	@NotNull
	
	@Column(name = "perf_id", unique = true, nullable = false)
	private Integer perf_id;
	@NotNull	
		
	@Column(name="cod_estado")
	@NotEmpty
	private String cod_estado;
	@NotNull
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fec_ingreso")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fec_ingreso;
	
	
	public Long getUsu_id() {
		return usu_id;
	}
	public void setUsu_id(Long usu_id) {
		this.usu_id = usu_id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getPerf_id() {
		return perf_id;
	}
	public void setPerf_id(Integer perf_id) {
		this.perf_id = perf_id;
	}
	public String getCod_estado() {
		return cod_estado;
	}
	public void setCod_estado(String cod_estado) {
		this.cod_estado = cod_estado;
	}
	public Date getFec_ingreso() {
		return fec_ingreso;
	}
	public void setFec_ingreso(Date fec_ingreso) {
		this.fec_ingreso = fec_ingreso;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
