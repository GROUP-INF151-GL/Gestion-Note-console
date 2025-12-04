package model;

import java.util.*;

public class Etudiant {
    private String nom;
    private String matricule;
    private Map<String, List<Double>> notesParMatiere = new HashMap<>();

    public Etudiant(String nom, String matricule) {
        this.nom = nom;
        this.matricule = matricule;
    }

    public String getNom() { return nom; }
    public String getMatricule() { return matricule; }

    public void ajouterNote(String matiere, double note) {
        notesParMatiere.putIfAbsent(matiere, new ArrayList<>());
        notesParMatiere.get(matiere).add(note);
    }

    public Map<String, List<Double>> getNotes() {
        return notesParMatiere;
    }

    public double getMoyenne() {
        double somme = 0;
        int count = 0;

        for (List<Double> notes : notesParMatiere.values()) {
            for (double n : notes) {
                somme += n;
                count++;
            }
        }

        return count == 0 ? 0 : somme / count;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "nom='" + nom + '\'' +
                ", matricule='" + matricule + '\'' +
                ", notesParMatiere=" + notesParMatiere +
                '}';
    }
}
