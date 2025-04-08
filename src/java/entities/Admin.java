package entities;

import javax.persistence.*;

@Entity
@Table(name = "admins")
public class Admin extends User {

    public Admin() {
        super();
    }

    public Admin(String nom, String prenom, String email, String motDePasse) {
        super(nom, prenom, email, motDePasse);
    }

    @Override
    public String toString() {
        return "Admin [id=" + getId() + 
               ", nom=" + getNom() + 
               ", prenom=" + getPrenom() + 
               ", email=" + getEmail() + "]";
    }
}