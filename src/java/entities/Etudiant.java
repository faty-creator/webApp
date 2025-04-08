package entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "etudiants")

public class Etudiant extends User {

    @Column(name = "cne", unique = true, length = 255)
    private String cne;

    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AffectationProjet> affectations = new ArrayList<>();

   
    public Etudiant() {
        super();
    }

    public Etudiant(String nom, String prenom, String email, String motDePasse, String cne) {
        super(nom, prenom, email, motDePasse);
        this.cne = cne;
    }

    
    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public List<AffectationProjet> getAffectations() {
        return affectations;
    }

    public void addAffectation(AffectationProjet affectation) {
        affectations.add(affectation);
        affectation.setEtudiant(this);
    }
}