import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;
import java.util.Map;


public class CompteMain {
    // Fonction main
    public static void main(String[] args) {
        // Déclaration de la variable continuer
        String continuer;

        // Liste des comptes 
        List<Compte> listeCompte = new ArrayList<>();
        
        // Création d'un objet pour lire l'éntrée du clavier 
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue dans votre espace client");

        // Création par défaut d'un compte courant
        Compte compteCourant = new Compte("compteCourant");
        listeCompte.add(compteCourant);

        // Boucle while pour permettre au client d'effectuer des transactions tant qu'il le souhaite
        do {
            // Menu
            System.out.println("Veuillez choisir une opération à effectuer :");
            System.out.println("1. Créer un nouveau compte bancaire");
            System.out.println("2. Afficher le solde des comptes existants");
            System.out.println("3. Enregistrer une dépense");
            System.out.println("4. Enregistrer un virement externe");
            System.out.println("5. Effectuer un virement interne");
            System.out.println("6. Afficher les transactions effectués sur un compte");
            System.out.println("0. Quitter");

            // Entrée du choix client
            int saisie = scanner.nextInt();
            scanner.nextLine();
            

            switch (saisie) {
                case 1:
                    // Vérification du nombre de compte ouvert
                    if (Compte.getListeComptes().size() < 3) {
                        // Création d'un nouveau compte
                        System.out.println("Veuillez entrer le nom de votre nouveau compte");
                        String saisie1 = scanner.nextLine();
                        
                        Compte cb2 = new Compte(saisie1);

                        // Ajout du compte à la liste des comptes
                        listeCompte.add(cb2); 
                    } else {
                        System.out.println("Opération impossible, vous ne pouvez créer que trois comptes au maximum");
                    }
                    break;

                case 2:
                    // Appel de la fonction afficheSolde pour chaque compte
                    Compte.afficheSoldes();
                    break;
                
                case 3:
                    // Dépense affilié au compte courant 
                    System.out.println("Veuillez saisir un nom pour la transaction");
                    String nomTransaction = scanner.nextLine();
                    
                    System.out.println("Veuillez saisir un montant pour la transaction");
                    double montant = scanner.nextDouble();
                    scanner.nextLine();
                    
                    compteCourant.depense(nomTransaction, -montant);
                    break;
                
                case 4:
                    System.out.println("Veuillez saisir un nom pour la transaction");
                    String nomTransaction1 = scanner.nextLine();
                    
                    System.out.println("Veuillez saisir un montant pour la transaction");
                    double montant1 = scanner.nextDouble();
                    scanner.nextLine();

                    compteCourant.virementExterne(nomTransaction1, montant1);
                    break;
                
                case 5:
                    if (listeCompte.size() < 2) {
                        System.out.println("Erreur! Vous ne possédez qu'un compte");
                    } else {
                        System.out.println("Veuillez saisir le compte initiateur de la transaction");
                        Compte.afficherTousLesComptes();
                        String nomCompte1 = scanner.nextLine();

                        for (Compte compte1 : listeCompte) {
                            if (compte1.getNomCompte().equals(nomCompte1)) {
                                System.out.println("Veuillez saisir le compte receveur de la transaction");
                                Compte.afficherTousLesComptes();
                                String nomCompte2 = scanner.nextLine();

                                for (Compte compte2 : listeCompte) {
                                    if (compte2.getNomCompte().equals(nomCompte2)) {
                                        System.out.println("Veuillez saisir le montant de la transaction");
                                        double montant2 = scanner.nextDouble();
                                        compte1.virementInterne(compte2, montant2);
                                        break;
                                    } else {
                                        System.out.println("Erreur! Veuillez choisir un compte existant");
                                    }
                                }
                                break;
                            }
                        }
                    }
                    break;

                case 6:
                    System.out.println("Veuillez choisir un compte pour lequel afficher les transactions");
                    Compte.afficherTousLesComptes();
                    String compte3 = scanner.nextLine();

                    // Test de l'existence du compte choisi
                    for (Compte compte : listeCompte) {
                        if (compte.getNomCompte().equals(compte3)) {
                            compte.afficherTransactions();
                        } else {
                            System.out.println("Erreur! Veuillez saisir un compte existant");
                        }
                    }
                    break;

                case 0:
                    System.out.println("Au revoir!");
                
                default:
                    System.out.println("Erreur! Veuillez réessayer");
                    break;
            }

            System.out.println("Voulez continuer vos opérations ?: (O/N)");
            continuer = scanner.nextLine();

        } while (continuer.equals("O") || continuer.equals("o"));
    } 
}