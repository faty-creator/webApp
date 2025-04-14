package dao;

import entities.Etudiant;
import entities.ProjetEtudiant;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class EtudiantDao extends AbstractDao<Etudiant> {

    public EtudiantDao() {
        super(Etudiant.class);
    }

    public Etudiant findByEmail(String email) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            Etudiant etudiant = (Etudiant) session.getNamedQuery("Etudiant.findByEmail")
                    .setParameter("email", email)
                    .uniqueResult();
            tx.commit();
            return etudiant;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<Etudiant> findByProjectYear(int annee) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            List<Etudiant> etudiants = session.getNamedQuery("Etudiant.findByProjectYear")
                    .setParameter("annee", annee)
                    .list();
            tx.commit();
            return etudiants;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
