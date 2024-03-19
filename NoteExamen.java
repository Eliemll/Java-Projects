import java.util.*;

public class NoteExamen {
    // Déclaration des variables
    private double noteExamen;
    private String nomExamen;

    // Déclaration d'une liste contenant tous les objets
    private static List<NoteExamen> listeDesObjets = new ArrayList<>();

    // Constructeur
    NoteExamen(String nomExamen, double noteExamen) {
        this.noteExamen = noteExamen;
        this.nomExamen = nomExamen;
        
        // Ajout de l'objet à la liste 
        listeDesObjets.add(this);
    }

    // Modificateurs
    public void setNoteExamen(double nouvelleNoteExamen) {
        this.noteExamen = nouvelleNoteExamen;
    }

    public void setNomExamen(String nouveauNomExamen) {
        this.nomExamen = nouveauNomExamen;
    }

    // Modifie l'objet
    public void setAll(String nomExamen, double noteExamen) {
        this.nomExamen = nomExamen;
        this.noteExamen = noteExamen;
    }

    // Accesseurs
    public String getNomExamen() {
        return this.nomExamen;
    }

    public double getNoteExamen() {
        return this.noteExamen;
    } 

    public static void afficherTous() {
        for (NoteExamen noteExamen : listeDesObjets) {
            System.out.println("Examen : " + noteExamen.getNomExamen() + ", Note : " + noteExamen.getNoteExamen());
        }
    }
}