package com.fede587.ospedale.core.entity;

public class Ruolo {
	private Long id;
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
