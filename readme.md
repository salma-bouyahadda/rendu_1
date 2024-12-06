# RENDU-1
# Application de Gestion des Événements et Réservations avec JDBC

Ce projet implemente une application Java permettant de gérer des utilisateurs, des événements, des salles, des terrains, et des reservations via JDBC. L'application interagit avec une base de donnees relationnelle MySQL pour effectuer des operations CRUD (Creer, Lire, Mettre à jour, Supprimer)

## Contexte

L'ecole souhaite automatiser la gestion des événements, la réservation des salles et des terrains, ainsi que la gestion des utilisateurs (etudiant et professeur). Cette application permet de gerer les utilisateurs, les événements et les reservations de maniere simple

## Fonctionnalités

### 1. Gestion des Utilisateurs
- Ajouter un utilisateur
- Afficher la liste des utilisateurs
- Supprimer un utilisateur

### 2. Gestion des Événements
- Ajouter un evenement
- Afficher les evenements
- Modifier un evenement
- Supprimer un evenement

### 3. Gestion des Salles et Terrains
- Ajouter une salle
- Afficher les salles disponibles
- Supprimer une salle
- Ajouter un terrain
- Afficher les terrains disponibles
- Supprimer un terrain

### 4. Gestion des Reservations
- Reserver une salle et/ou un terrain pour un événement
- Verifier la disponibilite d'une salle/terrain
- Afficher les reservations existantes
- Modifier une reservation
- Supprimer une reservation

## Structure de la Base de Donnees

La base de donnees comprend les tables suivantes :

1. **Utilisateurs** : Contient les informations des utilisateurs (etudiant et professeur)
   - id_user, nom, prenom, email, type (étudiant ou professeur)

2. **Evenements** : Contient les informations des événements
   - id_event, nom_event, date_event, description, id_user (référence à l'utilisateur responsable)

3. **Salles** : Contient les informations des salles
   - id_salle, nom_salle, capacite

4. **Terrains** : Contient les informations des terrains.
   - id_terrain, nom_terrain, type

5. **Reservations** : Contient les informations des reservations effectuees
   - id_reservation, id_user, id_event, id_salle, id_terrain, date_reservation

## Test

**Resultat de main** :
- utilisateur ajoute
- utilisateur ajoute
- utilisateur ajoute
- liste des utilisateurs :
- ID: 1,Nom: salma,Prenom: bouya,Email: salma@gmail.com,Type: etudiant
- ID: 2,Nom: hassna,Prenom: hada,Email: hassna@gmail.com,Type: etudiant
- ID: 3,Nom: mounir,Prenom: bayan,Email: mounir@gmail.com,Type: professeur
- utilisateur supprime
- liste des utilisateurs apres supperssion :
- ID: 1,Nom: salma,Prenom: bouya,Email: salma@gmail.com,Type: etudiant
- ID: 3,Nom: mounir,Prenom: bayan,Email: mounir@gmail.com,Type: professeur
- salle ajoutee
- salle ajoutee
- salle ajoutee
- terrain ajoute
- terrain ajoute
- terrain ajoute

- liste des salles :
- Id: 1,Nom: salle A,Capacite: 50
- Id: 2,Nom: salle B,Capacite: 30
- Id: 3,Nom: salle C,Capacite: 50

- liste des terrains :
- Id: 1,Nom: terrain 1,Type: football
- Id: 2,Nom: terrain 2,Type: fasketball
- Id: 3,Nom: terrain 3,Type: volleyball
- salle supprimee
- terrain supprime

- liste des salles apres suppresission :
- Id: 1,Nom: salle A,Capacite: 50
- Id: 2,Nom: salle B,Capacite: 30

- liste des terrains apres suppression :
- Id: 1,Nom: terrain 1,Type: football
- Id: 2,Nom: terrain 2,Type: fasketball
- evenement ajoute
- evenement ajoute
- evenement ajoute

- liste des evenements :
- ID: 1,Nom: football tournament,Date: 2024-12-15,Description:  match,Id utilisar: 1
- ID: 2,Nom: DAMA,Date: 2024-12-20,Description: jeux,Id utilisateur: 3
- ID: 3,Nom: volley tournament,Date: 2024-12-19,Description:  match,Id utilisate 1
- evenement modifie

- liste des evenements apres modification :
- ID: 1,Nom: basketball,Date: 2024-12-18,Description: new match,Id utilisateur: 
- ID: 2,Nom: DAMA,Date: 2024-12-20,Description: jeux,Id utilisateur: 3
- ID: 3,Nom: volley tournament,Date: 2024-12-19,Description:  match,Id utilisate 1
- evenement supprime

- liste des evenements apres suppression :
- ID: 1,Nom: basketball,Date: 2024-12-18,Description: new match,Id utilisateur: isateur: - 1 volley tournament,Date: 2024-12-19,Description:  match,Id utilisate
- ID: 3,Nom: volley tournament,Date: 2024-12-19,Description:  match,Id utilisateur - effectuee
- : 1
- reservation effectuee
- reservation effectuee
- : 1                                                                  5
- ID: 3,Nom: volley tournament,Date: 2024-12-19,Description:  match,Id
0utilisatilisateur: 1,Evenement: 1,Salle: 1,Terrain: 1,Date: 2024-12-1teur: 1
- reservation effectuee
- reservation effectuee
- : 1
- ID: 3,Nom: volley tournament,Date: 2024-12-19,Description:  match,Id utilisUtilisateur: 1,Evenement: 1,Salle: 1,Terrain: 1,Date: 2024-12-1ateur: 1
- reservation effectuee                                                2
- reservation effectuee                                                0
- : 1
- ID: 3,Nom: volley tournament,Date: 2024-12-19,Description:  match,Id uti 1,Utilisateur: 1,Evenement: 1,Salle: 1,Terrain: 1,Date: 2024-12-1lisateur: 1                                                          0
- reservation effectuee
- reservation effectuee
- : 1
- ID: 3,Nom: volley tournament,Date: 2024-12-19,Description:  match,Id ut: 1,-Utilisateur:  1,Evenement: 1,Salle: 1,Terrain: 1,Date: 2024-12-1ilisateur: 1
- reservation effectuee
- reservation effectuee

- liste des reservations :
- ID: 1,Utilisateur: 1,Evenement: 1,Salle: 1,Terrain: 1,Date: 2024-12-15
- ID: 2,Utilisateur: 3,Evenement: 3,Salle: 2,Terrain: 2,Date: 2024-12-20

- disponibilite des salles :
- Salle 1 (2024-12-15): Indisponible
- Salle 2 (2024-12-20): Indisponible
- Salle 1 (2024-12-18): Disponible
- reservation modifiee

- liste des reservations apres modification :
- ID: 1,Utilisateur: 1,Evenement: 1,Salle: 2,Terrain: 2,Date: 2024-12-22
- ID: 2,Utilisateur: 3,Evenement: 3,Salle: 2,Terrain: 2,Date: 2024-12-20
- reservation supprimee

- liste des reservations apres suppression :
- ID: 2,Utilisateur: 3,Evenement: 3,Salle: 2,Terrain: 2,Date: 2024-12-20