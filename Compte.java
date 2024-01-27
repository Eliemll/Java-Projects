import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Compte {
    // Déclaration des variables
    private double solde;
    private String nomCompte;
    private Map<String, Double> transactions;
    // Liste pour stocker tous les comptes ouverts
    private static List<Compte> listeComptes = new ArrayList<>();

    // Constructeur par défaut
    public Compte(String nomCompte) {
        this.solde = 0.0;
        this.nomCompte = nomCompte;
        this.transactions = new HashMap<>();
        listeComptes.add(this);
    }

    // Constructeur avec solde
    public Compte(double solde, String nomCompte) {
        this.solde = solde;
        this.nomCompte = nomCompte;
        this.transactions = new HashMap<>();
        listeComptes.add(this);
    }

    // Getter 
    public String getNomCompte() {
        return this.nomCompte;
    }

    public static List<Compte> getListeComptes() {
        return listeComptes;
    }

    // Méthode pour enregistrer une dépense
    public void depense(String nomDepense, double montant) {
        // Vérifier si le solde est assez grand
        if (montant <= solde) {
            // Enregistrer la dépense dans la Map des transactions
            transactions.put(nomDepense, -montant);

            // Mettre à jour le solde
            solde -= montant;

            // Afficher la réussite de l'opération
            System.out.println("Achat réalisé avec succès");

        } else {
            System.out.println("Solde insuffisant, impossible de réaliser l'achat");
        }
    }

    // Méthode pour enregistrer un virement externe
    public void virementExterne(String nomExterne, double montant) {
        // Enregistrer le virement externe
        transactions.put(nomExterne, montant);

        // Mettre à jour le solde
        solde += montant;

        // Afficher la réussite de l'opération
        System.out.println("Virement reçu avec succès");
    }

    // Méthode pour enregistrer un virement interne
    public void virementInterne(Compte cbDest, double montant) {
        // Vérifier si le solde est suffisant
        if (montant <= solde) {
            // Enregistrer la transaction
            transactions.put("Virement vers " + cbDest.getNomCompte(), -montant);
            cbDest.transactions.put("Virement depuis " + getNomCompte(), montant);

            // Mettre à jour les soldes
            solde -= montant;
            cbDest.solde += montant;

            // Afficher la réussite de l'opération
            System.out.println("Virement réalisé avec succès");

        } else {
            System.out.println("Solde insuffisant, impossible d'effectuer la transaction");
        }
    }

    // Méthode d'affichage des soldes
    public static void afficheSoldes() {
        System.out.println("Solde de tous les comptes : ");
        // Boucle for pour afficher le solde de chaque compte
        for (Compte compte : listeComptes) {
            System.out.println(compte.nomCompte + " : Solde = " + compte.solde);
        }
    }

    // Méthode pour afficher les transactions d'un compte
    public void afficherTransactions() {
        System.out.println("Transactions du compte " + nomCompte + " :");
        // Boucle for pour afficher chaque transaction avec le montant associé
        for (Map.Entry<String, Double> entry : transactions.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    // Méthode pour afficher tous les comptes ouverts
    public static void afficherTousLesComptes() {
        System.out.println("Listes des comptes");
        for (Compte compte : listeComptes) {
            System.out.println(compte);
        }
    }
}