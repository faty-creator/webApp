package test;

import dao.EtudiantDao;
import entities.Etudiant;
import entities.ProjetEtudiant;
import dao.ProjetEtudiantDao;
import dao.AffectationProjetDao;
import java.util.Date;

public class TestEmail {
    public static void main(String[] args) {
        try {
            EtudiantDao etudiantDao = new EtudiantDao();
            
            // Test findByEmail
            String testEmail = "agourramfatimaezzahra0@gmail.com";
            Etudiant etudiant = etudiantDao.findByEmail(testEmail);
            
            if (etudiant != null && etudiant.getEmail().equals(testEmail)) {
                System.out.println("Test findByEmail: SUCCÈS");
                System.out.println("Détails étudiant: " + etudiant.getNom() + " " + etudiant.getPrenom());
            } else {
                System.out.println("Test findByEmail: ÉCHEC");
            }
            
        } catch (Exception e) {
            System.err.println("Erreur lors des tests: " + e.getMessage());
            e.printStackTrace();
        }
    }
}