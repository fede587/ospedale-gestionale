package ospedale.ospedale_core.entità;

import java.util.LinkedHashSet;
import java.util.Set;

public class Cliente {
	
	private Long id;
	private String username;
	private String password;

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
}
