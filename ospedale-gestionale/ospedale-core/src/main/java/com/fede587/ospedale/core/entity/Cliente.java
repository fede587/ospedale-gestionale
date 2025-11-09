package com.fede587.ospedale.core.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="clienti", uniqueConstraints = @UniqueConstraint(columnNames = "username"))

public class Cliente {
	
	private Long id;   
	@NotBlank
    @Column(nullable=false, unique=true, length=100)

	private String username;
    @NotBlank
    @Column(nullable=false, length=200)

	private String password;

    private boolean abilitato = true;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="clienti_ruoli",
        joinColumns = @JoinColumn(name="cliente_id"),
        inverseJoinColumns = @JoinColumn(name="ruolo_id"))

	private Set<Ruolo> ruoli = new LinkedHashSet<>();

	public Cliente() {}
	public Cliente(String username, String password){ this.username=username; this.password=password; }

	public Long getId(){ return id; }
	public String getUsername(){ return username; }
	public void setUsername(String username){ this.username = username; }
	public String getPassword(){ return password; }
	public void setPassword(String password){ this.password = password; }
	public Set<Ruolo> getRuoli(){ return ruoli; }
	public void setRuoli(Set<Ruolo> ruoli){ this.ruoli = ruoli; }
    public boolean isAbilitato(){ return abilitato; }
    public void setAbilitato(boolean abilitato){ this.abilitato = abilitato; }

}
