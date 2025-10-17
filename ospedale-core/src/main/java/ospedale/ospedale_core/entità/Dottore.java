package ospedale.ospedale_core.entità;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class Dottore {

	private Long id;
	@NotBlank
	private String nome;
	@NotBlank
	private String cognome;
	@Email
	private String email;
	@Pattern(regexp = "^[0-9 +()\\-]*$", message = "Telefono non valido")
	private String telefono;

	private String competenza;

	public Dottore() {
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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getSpecializzazione() {
		return competenza;
	}

	public void setSpecializzazione(String competenza) {
		this.competenza = competenza;
	}

}
