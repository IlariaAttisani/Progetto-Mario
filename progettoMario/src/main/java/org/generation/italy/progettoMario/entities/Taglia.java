package org.generation.italy.progettoMario.entities;

import javax.persistence.Entity;

@Entity
public class Taglia {

	int id;
	String nome;
	
	public Taglia() {
		super();
	}
	public Taglia(int id, String nome) {
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

}
