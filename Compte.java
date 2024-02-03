import java.util.*;

public class Compte {
    // Déclaration des variables
    private double solde;
    private String nomCompte;
    private List<Transaction> listeDesTransactions;  // Liste des objets Transaction

    /*   Déclaration des variables statiques */
    private static List<Compte> listeDesComptes = new ArrayList<>();    // Liste pour stocker tous les comptes ouverts

    /*   Constructeurs   */
    // Constructeur par défaut
    public Compte(String nomCompte) {
        this.solde = 0.0;
        this.nomCompte = nomCompte;
        this.listeDesTransactions = new ArrayList<>();
    }

    // Constructeur avec solde
    public Compte(double solde, String nomCompte) {
        this.solde = solde;
        this.nomCompte = nomCompte;
        this.listeDesTransactions = new ArrayList<>();
    }

    /*   Getters   */ 
    public double getSolde() {
        return this.solde;
    }

    public String getNomCompte() {
        return this.nomCompte;
    }

    public static List<Compte> getListeDesComptes() {
        return listeDesComptes;
    }

    // Méthode pour enregistrer les comptes
    public static void enregistrerCompte(Compte nouveauCompte) {
        listeDesComptes.add(nouveauCompte);
    }

    // Méthode pour afficher tous les comptes ouverts
    public static void afficherTousLesComptes() {
        System.out.println("Listes des comptes");
        for (Compte compte : listeDesComptes) {
            System.out.println(compte.getNomCompte());
        }
    }

    /*   Méthodes d'enregistrement des opérations   */

    // Méthode pour enregistrer une dépense
    public void depense(String nomDepense, double montant) {
        // Vérifier si le solde est assez grand
        if (montant <= solde) {
            // Enregistrer la dépense dans la liste d'objets des transactions
            listeDesTransactions.add(new Transaction(nomDepense, -montant));

            // Mettre à jour le solde
            solde -= montant;

            // Afficher la réussite de l'opération
            System.out.println("Achat enregistré");

        } else {
            System.out.println("Solde insuffisant, impossible de réaliser l'achat");
        }
    }

    // Méthode pour enregistrer un virement externe
    public void virementExterne(String nomVirementExterne, double montant) {
        // Enregistrer le virement externe
        listeDesTransactions.add(new Transaction(nomVirementExterne, montant));

        // Mettre à jour le solde
        solde += montant;

        // Afficher la réussite de l'opération
        System.out.println("Virement externe enregistré");
    }

    // Méthode pour enregistrer un virement interne
    public static void virementInterne(Compte cbDon, Compte cbDest, double montant) {
        // Vérifier si le solde du compte Donnateur est suffisant
        if (montant <= cbDon.solde) {
            // Enregistrer la transaction
            cbDon.listeDesTransactions.add(new Transaction("Virement vers " + cbDest.getNomCompte(), -montant));
            cbDest.listeDesTransactions.add(new Transaction("Virement depuis " + cbDon.getNomCompte(), montant));

            // Mettre à jour les soldes
            cbDon.solde -= montant;
            cbDest.solde += montant;

            // Afficher la réussite de l'opération
            System.out.println("Virement interne réalisé avec succès");

        } else {
            System.out.println("Solde insuffisant du compte iniateur, impossible d'effectuer la transaction");
        }
    }

    // Méthode d'affichage des soldes
    public static void afficheSoldes() {
        System.out.println("Solde de tous les comptes : ");
        // Boucle for pour afficher le solde de chaque compte
        for (Compte compte : listeDesComptes) {
            System.out.println(compte.getNomCompte() + " : Solde = " + compte.solde);
        }
    }

    // Méthode pour afficher les transactions d'un compte
    public void afficherTransactions() {
        System.out.println("Transactions du " + getNomCompte() + " :");
        // Boucle for pour afficher chaque transaction avec le montant associé
        for (Transaction transaction : listeDesTransactions) {
            System.out.println(transaction.getNomTransaction() + " : " + transaction.getmontantTransaction());
        }
    }
}
