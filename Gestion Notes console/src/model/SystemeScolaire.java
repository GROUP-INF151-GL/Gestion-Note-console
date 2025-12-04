package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SystemeScolaire {

    private Map<String, Etudiant> etudiants = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void ajouterEtudiant() {
        System.out.print("Nom de l’étudiant: ");
        String nom = scanner.nextLine();

        System.out.print("Matricule : ");
        String matricule = scanner.nextLine();

        if (etudiants.containsKey(matricule)) {
            System.out.println("❌ Ce matricule existe déjà !");
            return;
        }

        Etudiant e = new Etudiant(nom, matricule);
        etudiants.put(matricule, e);

        System.out.println("✔ Étudiant ajouté !");
    }

    public void ajouterNote() {
        System.out.print("Entrer le matricule : ");
        String matricule = scanner.nextLine();

        Etudiant e = etudiants.get(matricule);
        if (e == null) {
            System.out.println("❌ Étudiant non trouvé !");
            return;
        }

        System.out.print("Matière : ");
        String matiere = scanner.nextLine();

        System.out.print("Note : ");
        double note = scanner.nextDouble();
        scanner.nextLine();

        e.ajouterNote(matiere, note);

        System.out.println("✔ Note ajoutée !");
    }

    public void afficherNotes() {
        System.out.print("Matricule : ");
        String matricule = scanner.nextLine();

        Etudiant e = etudiants.get(matricule);
        if (e == null) {
            System.out.println("❌ Étudiant non trouvé !");
            return;
        }

        System.out.println("\n🔹 Notes de " + e.getNom() + " (" + e.getMatricule() + ")");
        for (String matiere : e.getNotes().keySet()) {
            System.out.println("➡ " + matiere + " : " + e.getNotes().get(matiere));
        }

        System.out.println("⭐ Moyenne : " + String.format("%.2f", e.getMoyenne()));
    }

    public void exporter() {
        try (FileWriter writer = new FileWriter("export_notes.txt")) {

            for (Etudiant e : etudiants.values()) {
                writer.write("\nÉtudiant : " + e.getNom() + " (" + e.getMatricule() + ")\n");
                writer.write("---------------------------------------\n");

                for (String matiere : e.getNotes().keySet()) {
                    writer.write(matiere + " : " + e.getNotes().get(matiere) + "\n");
                }

                writer.write("Moyenne : " + String.format("%.2f", e.getMoyenne()) + "\n\n");
            }

            System.out.println("✔ Export effectué dans 'export_notes.txt'");
        } catch (IOException e) {
            System.out.println("❌ Erreur lors de l’export !");
        }
    }

    public void menu() {
        int choix;

        do {
            System.out.println("\n===== MENU SYSTÈME SCOLAIRE =====");
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Ajouter une note");
            System.out.println("3. Afficher les notes d’un étudiant");
            System.out.println("4. Exporter en fichier texte");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");

            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1 -> ajouterEtudiant();
                case 2 -> ajouterNote();
                case 3 -> afficherNotes();
                case 4 -> exporter();
                case 0 -> System.out.println("Au revoir !");
                default -> System.out.println("Choix invalide !");
            }

        } while (choix != 0);
    }
}
