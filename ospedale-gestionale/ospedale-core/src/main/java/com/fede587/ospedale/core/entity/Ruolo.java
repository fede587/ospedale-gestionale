package com.fede587.ospedale.core.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ruoli")

public class Ruolo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	@Column(nullable = false, unique = true, length = 64)

	private String nome;

	public Ruolo() {
	}

	public Ruolo(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
