import java.util.*;

public class Main {
    // Déclaration de la fonction Main 
    public static void main(String[] args) {
        // Création de deux Étudiants
        Etudiant elie = new Etudiant("Elie Molle", 2005, Pays.francophone, "Chimie", 10.87, "Informatique", 11.35, "Mathématiques", 8);
        Etudiant arnaud = new Etudiant("Arnaud Valliamee", 2004, Pays.francophone, "Chimie", 7.9, "Informatique", 9.65, "Mathématiques", 7);

        // Obtention de l'âge
        System.out.println("Voici l'age des étudiants renseignés : ");
        System.out.println();
        System.out.println("Elie Mollé : " + elie.getAge());
        System.out.println("Arnaud Valliamee : " + arnaud.getAge());
        System.out.println();

        // Obtention des moyennes et des mention 
        System.out.println("Voici les moyennes et les mentions obtenues");
        System.out.println();
        System.out.println ("Elie Mollé : Moyenne = " + elie.getMoyenne() + ", mention obtenue : " + elie.getMention());
        System.out.println ("Arnaud Valliamee : Moyenne = " + arnaud.getMoyenne() + ", mention obtenue : " + arnaud.getMention());
    }
}