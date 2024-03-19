import java.util.*;

public class TestPromotion{
    // Méthode main
    public static void main(String[] args) {
        // Création de deux Étudiants
        Etudiant elie = new Etudiant("Elie Molle", 2005, Pays.francophone, "Chimie", 10.87, "Informatique", 11.35, "Mathématiques", 8);
        Etudiant arnaud = new Etudiant("Arnaud Valliamee", 2004, Pays.francophone, "Chimie", 7.9, "Informatique", 9.65, "Mathématiques", 7);

        // Création de la promotion 
        Promotion p = new Promotion("Peip A", 2023);

        // Ajouter les deux étudiants à la liste de la promotion
        p.inscrire(elie);
        p.inscrire(arnaud);

        // Test des méthodes  
        System.out.println(p.getSize());
        System.out.println(p.getEtudiant(0).getNom());
        System.out.println(p.getEtudiant(1).getNom());

        System.out.println(p.getMoyenneGenerale());
        p.afficheResultats();
        p.admis();
        p.getNonFrancophone();
        p.getMajor();

    }
}