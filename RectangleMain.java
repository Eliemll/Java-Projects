import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RectangleMain {
    // Fonction Main
    public static void main(String[] args){

        // Déclaration des variables
        String continuer = "";


        // Création de l'objet scanner de la classe Scanner pour lire le flux d'éntrée du clavier 
        Scanner scanner = new Scanner(System.in);

        // Création d'un menu pour l'interface utilisateur
        System.out.println("Bienvenue dans votre programme !");
        do {
            //Liste des options proposées
            System.out.println();   // Effectue un saut d'une ligne
            System.out.println("Veuillez choisir parmi les options proposées");
            System.out.println();
            System.out.println("1. Créer un nouvel objet");
            System.out.println("2. Lister les caractéristiques d'un rectangle");
            System.out.println("3. Lister dans l'ordre décroissant les rectangles les plus grands");
            System.out.println("0. Quitter");
            System.out.println();

            // Entrée du choix
            int choix = scanner.nextInt(); // Affectation de la saisie clavier à la variable choix
            scanner.nextLine();     // Lecture de toute la ligne pour un retour à la ligne à la fin

            // Instructions à faire en fonction du choix de l'utilisateur
            switch (choix) {
                
                // Choix de la 1ère option : Création d'un nouvel objet
                case 1:
                    System.out.println();
                    System.out.println("Vous avez choisi de créer un nouveau rectangle ");
                    System.out.println();

                    // Choisir un nom pour le rectangle
                    System.out.print("Veuillez choisir un nom pour votre rectangle: ");
                    String nomRectangle = scanner.nextLine();
                    // Demande de saisie d'une longueur 
                    System.out.print("Veuillez choisir une longueur pour votre nouvel Objet :");
                    // Entrée de la longueur
                    int longueur = scanner.nextInt();
                    scanner.nextLine();
                    // Demande de saisie d'une largeur
                    System.out.print("Veuillez choisir une largeur pour votre nouvel Objet :");
                    // Entrée de la largeur
                    int largeur = scanner.nextInt();
                    scanner.nextLine();
                    
                    // Entrée de la couleur en RGB
                    System.out.println("Veuillez rentrez les trois paramètres de couleur");
                    // Entrée de R
                    System.out.print("R : ");
                    int R = scanner.nextInt();
                    scanner.nextLine();
                    // Entrée de G
                    System.out.print("G : ");
                    int G = scanner.nextInt();
                    scanner.nextLine();
                    // Entrée de B
                    System.out.print("B : ");
                    int B = scanner.nextInt();
                    scanner.nextLine();
                    
                    // Entrée de la position du rectangle
                    System.out.println("Veuillez choisir la position en abscisse de votre rectangle");
                    int x = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Veuillez choisir la position en ordonnée de votre rectangle");
                    int y = scanner.nextInt();
                    scanner.nextLine();

                    // Création du rectangle
                    Rectangle nouveauRectangle = new Rectangle(longueur, largeur, new Couleur(R, G, B), new Position(x, y));

                    // Enregistrement du nom du rectangle
                    Rectangle.enregistrerNomRectangle(nomRectangle);
                    // Enregistrement du nouveau rectangle dans la liste de tous les rectangles
                    Rectangle.enregistrerRectangle(nouveauRectangle);

                    // Affichage de la réussite de l'enregistrement du nouveau rectangle
                    System.out.println("Votre nouveau rectangle a bien été enregistré");

                    // Choix de continuer les opérations
                    System.out.print("Voulez vous continuer ? (o/O pour oui, autre pour non): ");
                    continuer = scanner.nextLine();
                    break;
                
                // Choix de l'option 2 : caractéristique d'un rectangle
                case 2:
                    System.out.println("Vous avez choisi de lister les caractéristiques d'un rectangle");

                    // Entrée du nom du rectangle
                    System.out.print("Veuillez saisir le nom du rectangle considéré: ");
                    String nomSaisi = scanner.nextLine();

                    // Opération de recherche du rectangle
                    Rectangle rectangleSelectionne = Rectangle.trouverRectangleParNom(nomSaisi);

                    //Vérifier si le rectangle a été trouvé
                    if (rectangleSelectionne != null) {
                        System.out.println("Informations sur le rectangle selectionné: ");
                        System.out.println(rectangleSelectionne.toString());
                    } else {
                        System.out.println("Aucun rectangle n'a été trouvé avec le nom spécifié");
                    }
                    // Choix de continuer les opérations
                    System.out.print("Voulez vous continuer ? (o/O pour oui, autre pour non): ");
                    continuer = scanner.nextLine();
                    break;
                
                // Lister dans l'ordre décroissant les rectangles les plus grands
                case 3:
                    // Vérifier qu'au moins un rectangle a été instancié
                    if (Rectangle.getTousLesRectangles() == null) {
                        System.out.println("Vous n'avez pas encore crée de rectangle");
                    } else {
                        System.out.println();
                        System.out.println("Voici la liste de tout des rectangles les plus grands");
                        System.out.println();
                        for (Rectangle rectangle : Rectangle.getTousLesRectangles()) {
                            System.out.println("Rectangle :" + rectangle.getNomRectangle() + ", aire : " + rectangle.getAire());
                        }
                    }
                    // Choix de continuer les opérations
                    System.out.print("Voulez vous continuer ? (o/O pour oui, autre pour non): ");
                    continuer = scanner.nextLine();
                    break;
                
                // Quitter
                case 0:
                    System.out.println("Au revoir!");
                    continuer = "non";
            }
        } while (continuer.equalsIgnoreCase("o"));
    }
} 
// javac Rectangle.java RectangleMain.java
// java RectangleMain