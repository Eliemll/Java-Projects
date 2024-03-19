import java.util.*;

public class Promotion {
    /*   VARIABLES   */
    // Variables d'instances 
    private String nom;
    private int annee;
    // Variable dérivé de la relation
    private ArrayList<Etudiant> listeEtudiants;

    /*   CONSTRUCTEUR   */
    // Constructeur par défaut
    public Promotion() {
        this.nom = "unknown";
        this.annee = 2024;
        this.listeEtudiants = new ArrayList<>();
    }

    // Constructeur avec paramètres
    public Promotion(String nom, int annee) {
        this.nom = nom;
        this.annee = annee;
        this.listeEtudiants = new ArrayList<>();
    }

    /*   GETTERS & SETTERS */
    // Getter & Setter variable année
    public int getAnnee() {
        return this.annee;
    } 

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    // Getter listeEtudiants
    public ArrayList<Etudiant> getListeEtudiants() {
        return this.listeEtudiants;
    }

    /*   MÉTHODES   */
    // Inscription d'un étudiant
    public void inscrire(Etudiant etudiant) {
        this.getListeEtudiants().add(etudiant);
    }

    // Moyenne générale
    public double getMoyenneGenerale() {
        int nbEleves = this.getSize();

        // Vérification du nombre d'élèves
        if (nbEleves == 0) {
            return 0;
        } 

        double somme = 0;
        for (int i = 0; i < nbEleves; i++) {
                somme += this.getEtudiant(i).getMoyenne();
                }
        return somme / nbEleves;            
    }

    // Méthode qui affiche les résulatats de chaque étudiants 
    public void afficheResultats() {
        for (int i = 0; i < this.getSize(); i++) {
            System.out.println(this.getEtudiant(i).ligneResultats());
        }
    }

    // Méthode qui renvoie le nom des étudiants admis
    public void admis() {
        for (int i = 0; i < this.getSize(); i++) {
            if (this.getEtudiant(i).getMention() != Mention.Ajourné) {
                System.out.println(this.getEtudiant(i).getNom());
            }
        }
    }
    
    // Méthode pour renvoyer tout les étudiants non francophones
    public void getNonFrancophone() {
        for (int i = 0; i < this.getSize(); i++) {
            if (this.getEtudiant(i).getCodePays() == Pays.etrangerNonFrancophone) {
                System.out.println(this.getEtudiant(i).getNom());
            }
        }
    }

    // Méthode major de promo
    public void getMajor() {
        double max = 0;
        for (int i = 0; i < this.getSize(); i++) {
            if (this.getEtudiant(i).getMoyenne() > max) {
                max = this.getEtudiant(i).getMoyenne();
            }
        }
        System.out.println(max);
    }

    // Méthode pour obtenir le i-ème étudiant de la listeEtudiants
    public Etudiant getEtudiant(int i) {
        return this.listeEtudiants.get(i);
    } 

    // Méthode retournant la taille de la liste : nombre d'étudiants 
    public int getSize() {
        return this.listeEtudiants.size();
    }
}