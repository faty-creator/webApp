package test;

import dao.AdminDao;
import dao.EtudiantDao;
import dao.ProjetEtudiantDao;
import dao.AffectationProjetDao;
import dao.UserDao;

import entities.Admin;
import entities.Etudiant;
import entities.ProjetEtudiant;
import entities.AffectationProjet;

import util.HibernateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        // Initialisation de la session Hibernate
        HibernateUtil.getSessionFactory();

        // Création des DAO
        AdminDao adminDao = new AdminDao();
        EtudiantDao etudiantDao = new EtudiantDao();
        ProjetEtudiantDao projetDao = new ProjetEtudiantDao();
        AffectationProjetDao affectationDao = new AffectationProjetDao();
        UserDao userDao = new UserDao();

        // Création d'un administrateur
        Admin admin = new Admin("Admin", "Khadija", "admin@email.com", "admin123");
        adminDao.create(admin);
        System.out.println("Administrateur créé avec succès");

        // Création des étudiants
        Etudiant etudiant1 = new Etudiant("Agourram", "Fatimaezzahra", "agourramfatimaezzahra0@gmail.com", "fati123", "EE884424");
        Etudiant etudiant2 = new Etudiant("Abbadi", "Meriem", "mery@gmail.com", "mery456", "EE112233");

        etudiantDao.create(etudiant1);
        etudiantDao.create(etudiant2);
        System.out.println("Étudiants créés avec succès");

        // Création des projets
        ProjetEtudiant projet1 = new ProjetEtudiant("Système de gestion", "Développement d'un système de gestion scolaire", "Prof. Zahid", 2023);
        ProjetEtudiant projet2 = new ProjetEtudiant("Application mobile", "Création d'une application Android", "Prof. Lachgar", 2023);

        projetDao.create(projet1);
        projetDao.create(projet2);
        System.out.println("Projets créés avec succès");

        // Affectation des étudiants aux projets
        Date aujourdhui = new Date();
        AffectationProjet affectation1 = new AffectationProjet(etudiant1, projet1, aujourdhui, null);
        AffectationProjet affectation2 = new AffectationProjet(etudiant2, projet1, aujourdhui, null);
        AffectationProjet affectation3 = new AffectationProjet(etudiant2, projet2, aujourdhui, null);

        affectationDao.create(affectation1);
        affectationDao.create(affectation2);
        affectationDao.create(affectation3);
        System.out.println("Affectations créées avec succès");

        // Liste des projets
        System.out.println("\nListe des projets:");
        List<ProjetEtudiant> projets = projetDao.findAll();
        for (ProjetEtudiant p : projets) {
            System.out.println("- " + p.getTitre() + " (" + p.getAnnee() + ")");
        }

        // Affectation des étudiants
        System.out.println("\nAffectation des étudiants:");
        List<AffectationProjet> affectations = affectationDao.findAll();
        for (AffectationProjet a : affectations) {
            System.out.println("- " + a.getEtudiant().getNom() + " " + a.getEtudiant().getPrenom()
                    + " -> " + a.getProjet().getTitre());
        }

        // Suivi des projets 
        System.out.println("\nSuivi des projets:");
        for (ProjetEtudiant p : projets) {
            System.out.println("\nProjet: " + p.getTitre());
            System.out.println("Étudiants affectés:");
            for (AffectationProjet a : p.getAffectations()) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                System.out.println("- " + a.getEtudiant().getNom() + " " + a.getEtudiant().getPrenom()
                        + " (depuis " + sdf.format(a.getDateDebut()) + ")");
            }
        }
    }
}