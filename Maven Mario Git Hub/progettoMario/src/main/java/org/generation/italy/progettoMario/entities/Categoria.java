package org.generation.italy.progettoMario.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nome;
//	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="categoria")
//	private List<Capo> capi;
	
	public Categoria() {
		super();
	}
	
	public Categoria(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
//	public List<Capo> getCapi() {
//		return capi;
//	}
//	public void setCapi(List<Capo> capi) {
//		this.capi = capi;
//	}

}