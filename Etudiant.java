import java.util.*;

public class Etudiant {
    // Déclaration des variables
    private String nom;
    private int age;
    private int dateDeNaissance;
    private String codeIns = null;
    private Pays codePays;
    private NoteExamen noteExamen1;
    private NoteExamen noteExamen2;
    private NoteExamen noteExamen3;


    // Déclaration de la liste des objets NoteExamen
    private static List<NoteExamen> toutesLesNotes = new ArrayList<>();

    // Déclaration de la liste des Étudiants
    private static List<Etudiant> tousLesEtudiants = new ArrayList<>();

    // Constructeur sans inscription
    Etudiant(String nom, int dateDeNaissance, Pays codePays, String nomExamen1, double noteExamen1, String nomExamen2, double noteExamen2, String nomExamen3, double noteExamen3) {
        this.nom = nom;
        this.age = 2023 - dateDeNaissance;
        this.dateDeNaissance = dateDeNaissance;
        this.codePays = codePays;
        this.noteExamen1 = new NoteExamen(nomExamen1, noteExamen1);
        this.noteExamen2 = new NoteExamen(nomExamen2, noteExamen2);
        this.noteExamen3 = new NoteExamen(nomExamen3, noteExamen3);

        // Ajout des notes à la liste 
        toutesLesNotes.add(this.noteExamen1);
        toutesLesNotes.add(this.noteExamen2);
        toutesLesNotes.add(this.noteExamen3);

        // Ajout de l'étudiant à la liste
        tousLesEtudiants.add(this);
    }

    // Constructeur avec inscription
    Etudiant(String nom, int dateDeNaissance, Pays c, String codeIns, String nomExamen1, double noteExamen1, String nomExamen2, double noteExamen2, String nomExamen3, double noteExamen3) {
        this.nom = nom;
        this.age = 2023 - dateDeNaissance;
        this.dateDeNaissance = dateDeNaissance;
        this.codeIns = codeIns;
        this.codePays = codePays;
        this.noteExamen1 = new NoteExamen(nomExamen1, noteExamen1);
        this.noteExamen2 = new NoteExamen(nomExamen2, noteExamen2);
        this.noteExamen3 = new NoteExamen(nomExamen3, noteExamen3);

        // Ajout de l'objet à la liste 
        toutesLesNotes.add(this.noteExamen1);
        toutesLesNotes.add(this.noteExamen2);
        toutesLesNotes.add(this.noteExamen3);

        // Ajout de l'étudiant à la liste
        tousLesEtudiants.add(this);
    }
    
    /*   Modificateurs   */

    // Modifier la date de naissance
    public void setDateDeNaissance(int nouvelleDateDeNaissance) {
        this.dateDeNaissance = nouvelleDateDeNaissance;
        this.age = 2023 - nouvelleDateDeNaissance;
    }

    // Modifier le code d'inscription
    public void setCodeIns(String newCodeIns) {
        this.codeIns = newCodeIns;
    }

    // Modifier les notes
    public void setNoteExamen(String nomExamen1, double noteExamen1, String nomExamen2, double noteExamen2, String nomExamen3, double noteExamen3) {
        this.noteExamen1.setAll(nomExamen1, noteExamen1);
        this.noteExamen2.setAll(nomExamen2, noteExamen2);
        this.noteExamen3.setAll(nomExamen3, noteExamen3);
    }

    /*   Accesseurs   */

    // Accéder au nom
    public String getNom() {
        return this.nom;
    }

    // Accéder à l'âge
    public int getAge() {
        return this.age;
    }

    // Accéder à la date de naissance
    public int getDateDeNaissance() {
        return this.dateDeNaissance;
    }

    // Accéder au Code d'inscription
    public String getCodeIns() {
        return this.codeIns;
    }

    // Accéder au codePays
    public Pays getCodePays() {
        return this.codePays;
    }

    // Obtenir la moyenne 
    public double getMoyenne() {
        return ((this.noteExamen1.getNoteExamen() + this.noteExamen2.getNoteExamen() + this.noteExamen3.getNoteExamen()) / 3);
    }

    // Obtenir la mention
    public Mention getMention() {
        // Bloc conditionnel pour renvoyer la mention adéquat
        if (this.getMoyenne() < 10) {
            return Mention.Ajourné;
        } else if (this.getMoyenne() >= 10 && this.getMoyenne() < 12) {
            return Mention.Admis;
        } else if (this.getMoyenne() >= 12 && this.getMoyenne() < 14) {
            return Mention.AssezBien;
        } else if (this.getMoyenne() >= 14 && this.getMoyenne() < 16) {
            return Mention.Bien;
        } else if (this.getMoyenne() >= 16) {
            return Mention.TresBien;
        } else {
            return Mention.Autre;
        }
    }

    // Méthode ligne Résultats 
    public String ligneResultats() {
        if (this.getMoyenne() < 10) {
            /*return "Nom : " + this.getNom() + ", Moyenne : " + this.getMoyenne() + ", Mention : " + this.getMention() + ", Ue non obtenues : " + */
            return "Nom : " + this.getNom() + ", Moyenne : " + this.getMoyenne() + ", Mention : " + this.getMention() + " T'as pas validé frerot";
        } else {
            return "Nom : " + this.getNom() + ", Moyenne : " + this.getMoyenne() + ", Mention : " + this.getMention();
        }
        
    }
}