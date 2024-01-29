import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;


class Couleur {
    // Déclaration des variables
    private int R;
    private int G;
    private int B;  
    
    // Déclaration du constructeur
    Couleur(int R, int G, int B) {
        this.R = R;
        this.G = G;
        this.B = B;
    }

    // Méthode toString
    public String toString() {
        return "Couleur: (" + this.R + ", " + this.G + ", " + this.B + ")";
    }

}

class Position {
    // Déclaration des variables
    private int positionX;
    private int positionY;

    // Déclaration du constructeur
    Position(int x, int y) {
        this.positionX = x;
        this.positionY = y;
    }

    /*  Setters  */ 
    // Changer la position sur X du rectangle
    public void setX(int newX) {
        this.positionX = newX;
    }

    // Changer la position sur Y du rectangle
    public void setY(int newY) {
        this.positionY = newY;
    }

    /*   Getters   */ 
    // Obtenir la position sur X du rectangle
    public int getX() {
        return this.positionX;
    }
    //Obtenir la position sur Y du rectangle
    public int getY() {
        return this.positionY;
    }

    // Renvoie la position sur X et Y de la position du rectangle
    public String toString() {
        return "Point (" + this.getX() + ", " + this.getY() + ")";
    }
}

public class Rectangle {

    // Déclaration des variables
    private String nomRectangle;
    private int longueur; 
    private int largeur; 
    private Couleur couleur; 
    private Position position; 
    private static final int nombreDeCotes = 4;
    private static final int angleEntreDeuxCotes = 90;
    private static List<String> nomDeTousLesRectangles = new ArrayList<>();
    private static List<Rectangle> tousLesRectangles = new ArrayList<>();
    private static List<Rectangle> plusGrandsRectangle;
    

    /*   Getters   */ 
    public String getNomRectangle() {
        return this.nomRectangle;
    }
    // Perimetre
    public int getPerimetre() {
        return 2 * this.longueur + 2 * this.largeur;
    }

    // Aire
    public int getAire() {
        return this.longueur * this.largeur;
    }

    // Obtenir la liste de tous les rectangles
    public static List<Rectangle> getTousLesRectangles() {
        return tousLesRectangles;
    }

    /*   Constructeur   */
    Rectangle(int lon, int lar, Couleur couleur, Position position) {
        this.longueur = lon;
        this.largeur = lar;
        this.couleur  = couleur;
        this.position = position;
    }

    /*   Setters   */
    // Changer la longueur du rectangle
    public void setLongueur(int newLongueur) {
        this.longueur = newLongueur;
    }

    // Changer la largeur du rectangle
    public void setLargeur(int newLargeur) {
        this.largeur = newLargeur;
    }

    // Changer la couleur du rectangle
    public void setCouleur(int newR, int newG, int newB) {
        this.couleur = new Couleur(newR, newG, newB);
    }

    /*   Enregistrement dans les différentes listes   */

    // Enregistrement des noms des rectangle dans une liste
    public static void enregistrerNomRectangle(String nomRectangle) {
        nomDeTousLesRectangles.add(nomRectangle);
    }

    //  Première méthode pour enregistrer un nouvel objet dans la liste tousLesRectangles
    public static void enregistrerRectangle(Rectangle newRectangle) {
        tousLesRectangles.add(newRectangle);
    }

    // Méthode pour trouver un objet rectangle par son nom dans la liste tousLesRectangle
    public static Rectangle trouverRectangleParNom(String nom) {
        for (Rectangle rectangle : tousLesRectangles) {
            if (rectangle.getNomRectangle() != null && rectangle.getNomRectangle().equals(nom)) {
                return rectangle;
            }
        }
        return null;
    }

    // Méthode pour afficher les caractéristiques d"un rectangle
    public String toString() {
        return this.nomRectangle + " (longueur : " + this.longueur + ", largeur : " + this.largeur + ", perimetre: "+ this.getPerimetre() +", aire: " + this.getAire() + this.couleur.toString()+ ", " + this.position.toString() + ")";
    }

    /*   Grosse Méthode un peu aberrante pour obtenir une liste des 5 plus grands Rectangles   */ 

    // Sous classe pour comparer deux Rectangle par Aire
    private static class ComparerParAire implements Comparator<Rectangle> {
        public int compare(Rectangle thisRectangle, Rectangle otherRectangle) {
            return Integer.compare(otherRectangle.getAire(), thisRectangle.getAire());
        }
    }

    public static List<Rectangle> getPlusGrandsRectangles(List<Rectangle> tousLesRectangles) {
        List<Rectangle> listeTriee = new ArrayList<>(tousLesRectangles);
        Collections.sort(listeTriee, new ComparerParAire());

        int nombreMaxRectangles = Math.min(5, listeTriee.size());
        return listeTriee.subList(0, nombreMaxRectangles);
    }
}