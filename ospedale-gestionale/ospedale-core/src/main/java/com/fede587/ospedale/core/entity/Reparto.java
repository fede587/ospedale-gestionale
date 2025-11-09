package com.fede587.ospedale.core.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "reparti", uniqueConstraints = @UniqueConstraint(columnNames = "nome"))

public class Reparto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	private String nome;
	@NotBlank
	@Column(nullable = false)

	private String descrizione;
	@OneToMany(mappedBy = "reparto")

	private Set<Dottore> dottori = new LinkedHashSet<>();

	public Reparto() {
	}

	public Reparto(String nome, String descrizione) {
		this.nome = nome;
		this.descrizione = descrizione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Set<Dottore> getDottori() {
		return dottori;
	}

	public void setDottori(Set<Dottore> dottori) {
		this.dottori = dottori;
	}
}
