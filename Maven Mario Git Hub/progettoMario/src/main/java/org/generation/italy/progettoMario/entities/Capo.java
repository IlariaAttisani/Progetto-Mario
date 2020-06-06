package org.generation.italy.progettoMario.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Capo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nome;
	private String codiceArticolo;
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	private Double prezzo;
	private String colore;
	private String taglia;
	private String sesso;
	private int quantita;
	
	public Capo() {
		super();
	}

	public Capo(int id, String nome, String codiceArticolo, Categoria categoria, Double prezzo, String colore,
			String taglia, String sesso, int quantita) {
		super();
		this.id = id;
		this.nome = nome;
		this.codiceArticolo = codiceArticolo;
		this.categoria = categoria;
		this.prezzo = prezzo;
		this.colore = colore;
		this.taglia = taglia;
		this.sesso = sesso;
		this.quantita = quantita;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
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
