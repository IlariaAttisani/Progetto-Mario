package org.generation.italy.progettoMario.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Capo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String nome;
	String codiceArticolo;
	String categoria;
	Double prezzo;
	String colore;
	String taglia;
	int quantita;
	
	public Capo() {
		super();
	}
	
	public Capo(int id, String nome, String codiceArticolo, String categoria, Double prezzo, String colore,
			String taglia, int quantita) {
		super();
		this.id = id;
		this.nome = nome;
		this.codiceArticolo = codiceArticolo;
		this.categoria = categoria;
		this.prezzo = prezzo;
		this.colore = colore;
		this.taglia = taglia;
		this.quantita = quantita;
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
	public String getCodiceArticolo() {
		return codiceArticolo;
	}
	public void setCodiceArticolo(String codiceArticolo) {
		this.codiceArticolo = codiceArticolo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}
	public String getColore() {
		return colore;
	}
	public void setColore(String colore) {
		this.colore = colore;
	}
	public String getTaglia() {
		return taglia;
	}
	public void setTaglia(String taglia) {
		this.taglia = taglia;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

}
