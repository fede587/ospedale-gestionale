package ospedale.ospedale_core.entità;

import java.util.LinkedHashSet;
import java.util.Set;

public class Reparto {
    private Long id;

    private String nome;

    private String descrizione;

    private Set<Dottore> dottori = new LinkedHashSet<>();

    public Reparto() {}
    public Reparto(String nome, String descrizione) { this.nome = nome; this.descrizione = descrizione; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescrizione() { return descrizione; }
    public void setDescrizione(String descrizione) { this.descrizione = descrizione; }
    public Set<Dottore> getDottori() { return dottori; }
    public void setDottori(Set<Dottore> dottori) { this.dottori = dottori;}
}
