/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Santos
 */
@XmlRootElement
@Entity
@Table(name="professor")

public class ProfessorModel implements Serializable {



	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prof_codigo")

	private Integer codigo;
	@Column(name = "prof_nome", length = 50, nullable = false)
	private String nome;
	@Column(name = "prof_email", length = 50, nullable = true)
	private String email;
	@Column(name = "prof_fone", length = 50, nullable = false)
	 private String fone;

	public ProfessorModel() {

	}
	public ProfessorModel(Integer codigo, String nome, String email, String fone) {
		
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.fone = fone;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfessorModel other = (ProfessorModel) obj;
		return Objects.equals(codigo, other.codigo);
	}
}

