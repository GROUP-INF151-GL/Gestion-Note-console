# Système de gestion de notes (Java)

Ce projet est une application console permettant :
- D'ajouter plusieurs étudiants
- D'éviter les doublons grâce au matricule unique
- D'ajouter des notes par matière
- De calculer automatiquement la moyenne générale
- De classer les notes par matière
- D'exporter toutes les données dans un fichier texte
- Version entièrement orientée objet

## Structure du projet
- Etudiant.java : représente un étudiant et ses notes
- SystemeScolaire.java : gère les fonctionnalités du système
- Main.java : lance le menu principal

## Exécution
Compiler puis exécuter :

javac *.java
java Main

Les données sont exportées dans `export_notes.txt`
