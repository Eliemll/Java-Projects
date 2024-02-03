import java.util.*;

public class Transaction {
    // Déclaration des variables
    private String nomTransaction;
    private double montantTransaction;

    // Déclaration du constructeur
    Transaction(String nomTransaction, double montantTransaction) {
        this.nomTransaction = nomTransaction;
        this.montantTransaction = montantTransaction;
    }

    /*   Setters   */
    public void setNomTransaction(String nomTransaction) {
        this.nomTransaction = nomTransaction;
    }

    public void setMontantTransaction(double montant) {
        this.montantTransaction = montant;
    }

    /*   Getters   */
    public String getNomTransaction() {
        return this.nomTransaction;
    }

    public double getmontantTransaction() {
        return this.montantTransaction;
    }
}
