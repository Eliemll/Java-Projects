import java.util.InputMismatchException;
import java.util.*;

public class CompteMain {
    // Fonction main
    public static void main(String[] args) {
        // Création d'un objet pour lire l'éntrée du clavier 
        Scanner scanner = new Scanner(System.in);

        // Création par défaut des comptes courant et épargnes
        Compte compteCourant = new Compte("Compte Courant");
        Compte.enregistrerCompte(compteCourant);

        Compte compteEpargne1 = new Compte("Livret A");
        Compte.enregistrerCompte(compteEpargne1);

        Compte compteEpargne2 = new Compte("Livret Jeune");
        Compte.enregistrerCompte(compteEpargne2);

        // Ajout du paiment Bourse + CAF
        compteCourant.virementExterne("Bourse + CAF", 650);

        // Message initial
        System.out.println("Bienvenue dans votre espace client");

        // Boucle while pour permettre au client d'effectuer des transactions tant qu'il le souhaite
        while (true) {
            // Menu
            System.out.println("Veuillez choisir une opération à effectuer :");
            System.out.println();
            System.out.println("1. Créer un nouveau compte bancaire");
            System.out.println("2. Afficher le solde des comptes existants");
            System.out.println("3. Enregistrer une dépense");
            System.out.println("4. Enregistrer un virement externe");
            System.out.println("5. Effectuer un virement interne");
            System.out.println("6. Afficher les transactions effectués sur un compte");
            System.out.println("0. Quitter");
            System.out.println();

            // Boucle d'essai pour traiter les erreurs de saisie 
            int saisie = 0;
            try {
                // Entrée du choix client
                saisie = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Erreur! Veuillez faire un choix parmi les options proposées");
            } finally {
                switch (saisie) {
                    case 1:
                    // Vérification du nombre de compte ouvert
                    if (Compte.getListeDesComptes().size() < 6) {
                        System.out.println();
                        // Création d'un nouveau compte
                        System.out.println("Veuillez entrer le nom de votre nouveau compte");
                        System.out.println();

                        String nomCompte = scanner.nextLine();
                        Compte nouveauCompte = new Compte(nomCompte);
                        Compte.enregistrerCompte(nouveauCompte);
                        System.out.println();

                    } else {
                        System.out.println("Opération impossible, vous ne pouvez créer que cinq comptes au maximum");
                    }
                    break;

                    case 2:
                        System.out.println();
                        // Appel de la fonction afficheSolde pour chaque compte
                        Compte.afficheSoldes();
                    break;
                
                    case 3:
                        System.out.println();
                        // Dépense affilié au compte courant 
                        System.out.println("Veuillez saisir un nom pour la transaction");
                        System.out.println();
                        String nomTransaction = scanner.nextLine();
                        System.out.println();
                    
                        System.out.println("Veuillez saisir un montant pour la transaction");
                        System.out.println();
                        double montant = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println();

                        // Vérification du solde
                        if (montant <= compteCourant.getSolde()) {
                            compteCourant.depense(nomTransaction, montant);
                        } else {
                            System.out.println("Opération impossible, votre solde est insuffisant");
                        }
                    break;
                
                    case 4:
                        System.out.println();
                        System.out.println("Veuillez saisir le nom pour la transaction");
                        System.out.println();
                        String nomVirement = scanner.nextLine();
                        System.out.println();
                    
                        System.out.println("Veuillez saisir le montant de la transaction");
                        System.out.println();
                        double montantVirement = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println();

                        compteCourant.virementExterne(nomVirement, montantVirement);
                    break;
                
                    case 5:
                        if (Compte.getListeDesComptes().size() < 2) {
                            System.out.println();
                            System.out.println("Erreur! Vous ne possédez qu'un compte");
                        } else {
                            System.out.println();
                            System.out.println("Veuillez saisir le compte initiateur de la transaction");
                            System.out.println();
                            Compte.afficheSoldes();
                            System.out.println();
                            String nomCompteInitiateur = scanner.nextLine();

                            // Utilisation de Stream pour filtrer les comptes par nom
                            Compte compteInitiateur = Compte.getListeDesComptes().stream()
                                    .filter(compte1 -> compte1.getNomCompte().equals(nomCompteInitiateur))
                                    .findFirst()
                                    .orElse(null);

                            // Vérification si le compte a été trouvé
                            if (compteInitiateur != null) {
                                System.out.println();
                                System.out.println("Veuillez saisir le compte destinataire de la transaction");
                                System.out.println();
                                Compte.afficheSoldes();
                                System.out.println();
                                String nomCompteDest = scanner.nextLine();

                                Compte compteReceveur = Compte.getListeDesComptes().stream()
                                        .filter(compte2 -> compte2.getNomCompte().equals(nomCompteDest))
                                        .findFirst()
                                        .orElse(null);
                                
                                // Vérification si le compte a été trouvé
                                if (compteReceveur != null) {
                                    System.out.println();
                                    System.out.println("Veuillez saisir le Montant du virement");
                                    System.out.println();
                                    double montantVirementInterne = scanner.nextDouble();
                                    scanner.nextLine();

                                    // Opération de virement interne
                                    Compte.virementInterne(compteInitiateur, compteReceveur, montantVirementInterne);

                                } else {
                                        System.out.println("Le compte destinataire de la transaction que vous avez choisi n'existe pas");
                                }
                            } else {
                                    System.out.println("Le compte à l'initiative de la transaction que vous avez choisi n'existe pas");
                            }
                        }
                    break;

                    case 6:
                        System.out.println();
                        System.out.println("Veuillez choisir un compte pour lequel afficher les transactions");
                        System.out.println();
                        Compte.afficheSoldes();
                        System.out.println();
                        String nomCompteRecherche = scanner.nextLine();

                        // Stream pour obtenir le compte associé au nom saisi
                        Compte compteRecherche = Compte.getListeDesComptes().stream()
                                .filter(compteR -> compteR.getNomCompte().equals(nomCompteRecherche))
                                .findFirst()
                                .orElse(null);
                        
                        // Vérification si le compte a été trouvé
                        if (compteRecherche != null) {
                            System.out.println();
                            compteRecherche.afficherTransactions();
                        } else {
                            System.out.println("Le compte choisi n'existe pas");
                        }
                    break;

                    case 0:
                        System.exit(0);
                    break;
                }
                System.out.println();
            }
        }
    } 
} 
// javac Compte.java CompteMain.java Transaction.java
// javac Compte.java CompteMain.java
// java CompteMain
