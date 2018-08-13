package com.poc.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "CONTATO")
@SequenceGenerator(name="CONTATO_SEQ", sequenceName="contato_codigo_contato_seq", allocationSize=1)
public class Contato implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CODIGO_CONTATO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTATO_SEQ")
	private Long codigoContato;
	
	@Column(name = "CELULAR")
	private String celular;
	
	@Column(name = "TELEFONE")
	private String telefone;
	
	@Column(name = "EMAIL")
	private String email;
	

	/*
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="COD_CLIENTE", referencedColumnName="COD_CLIENTE")
	private Cliente cliente;
	*/
	public Long getCodigoContato() {
		return codigoContato;
	}

	public void setCodigoContato(Long codigoContato) {
		this.codigoContato = codigoContato;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoContato == null) ? 0 : codigoContato.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (codigoContato == null) {
			if (other.codigoContato != null)
				return false;
		} else if (!codigoContato.equals(other.codigoContato))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contato [codContato=" + codigoContato + ", celular=" + celular + ", telefone=" + telefone + ", email="
				+ email + "]";
	}
	
	
	
	
}