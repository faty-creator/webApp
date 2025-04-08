package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "affectation_projet")
@IdClass(AffectationProjet.AffectationId.class)
public class AffectationProjet implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "etudiant_id", referencedColumnName = "id_user")
    private Etudiant etudiant;

    @Id
    @ManyToOne
    @JoinColumn(name = "projet_id", referencedColumnName = "id_pro")
    private ProjetEtudiant projet;

    @Column(name = "date_debut")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Column(name = "date_fin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;

    public AffectationProjet() {
    }

    public AffectationProjet(Etudiant etudiant, ProjetEtudiant projet, Date dateDebut, Date dateFin) {
        this.etudiant = etudiant;
        this.projet = projet;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    // Classe interne pour la clé composite
    public static class AffectationId implements Serializable {
        private int etudiant;  // Correspond à idUser de Etudiant
        private int projet;    // Correspond à idPro de ProjetEtudiant

        public AffectationId() {
        }

        public AffectationId(int etudiant, int projet) {
            this.etudiant = etudiant;
            this.projet = projet;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AffectationId that = (AffectationId) o;
            return etudiant == that.etudiant && projet == that.projet;
        }

        @Override
        public int hashCode() {
            return Objects.hash(etudiant, projet);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AffectationProjet that = (AffectationProjet) o;
        return Objects.equals(etudiant, that.etudiant) &&
               Objects.equals(projet, that.projet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(etudiant, projet);
    }

    // Getters et setters
    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public ProjetEtudiant getProjet() {
        return projet;
    }

    public void setProjet(ProjetEtudiant projet) {
        this.projet = projet;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
}