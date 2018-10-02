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
@Table(name="telefonos")
public class Telefonos implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "telefonos_Seq")
	@SequenceGenerator(name = "telefonos_Seq", sequenceName = "TELEFONOS_SEQ")
	@Column(name = "tel_id", updatable = false, nullable = false)
	private Long tel_id;
	
	@Column(name="telefono")
	@NotEmpty
	private String telefono;

	@Column(name="cli_num_documento")
	@NotEmpty
	private String cli_num_documento;
	@NotNull
	
	@Column(name="cod_estado")
	@NotEmpty
	private String cod_estado;
	@NotNull
	
	public Long getTel_id() {
		return tel_id;
	}
	public void setTel_id(Long tel_id) {
		this.tel_id = tel_id;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCli_num_documento() {
		return cli_num_documento;
	}
	public void setCli_num_documento(String cli_num_documento) {
		this.cli_num_documento = cli_num_documento;
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
