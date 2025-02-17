# 🏦 Gestion Banque

## 📄 Description du projet

L'Application Bancaire est une solution de gestion de comptes bancaires permettant aux clients et aux administrateurs de gérer leurs finances de manière sécurisée et efficace. L'application suit l'architecture Modèle-Vue-Contrôleur (MVC) pour assurer une séparation claire des responsabilités et une meilleure maintenance du code.

## 🚀 Fonctionnalités

### 🧑‍💼 Côté Client
1. **Création de comptes :** Les clients peuvent s'inscrire avec leurs informations personnelles.
2. **Connexion sécurisée :** Authentification des clients avec leurs identifiants.
3. **Gestion des comptes :**
   - Consultation du solde.
   - Dépôts et retraits.
   - Virements entre comptes.
   - Consultation de l'historique des transactions.
     
### 👨‍💻 Côté Administrateur
1. **Gestion des clients :**
   - Création, modification et suppression de comptes clients.
2. **Supervision des comptes bancaires :**
   - Suivi des transactions et des opérations bancaires.

## 🏗️ Architecture du Projet

L'application est conçue selon le modèle MVC :

- Modèle (`src/fr/esic/model/`) : Définit les classes représentant les entités principales : `Client`, `Compte`, `Transaction`, etc.
- Vue (`src/fr/esic/view/`) : Interface utilisateur textuelle permettant l'affichage et l'interaction avec l'utilisateur.
- Contrôleur (`src/fr/esic/controller/`) : Contient la logique métier et l'interaction entre la vue et le modèle.

## 🛠️ Technologies Utilisées
- Langage : `Java`
- Stockage des données : `ArrayList` pour gérer dynamiquement les clients et transactions.
- Sécurité : Validation des entrées pour éviter les erreurs et fraudes.

## 📦 Installation et Exécution

### 📋 Prérequis
- `Java JDK 8` ou supérieur
- Un environnement de développement comme `IntelliJ IDEA` ou `Eclipse`

### 🪜 Étapes d'Installation
1. Cloner ou télécharger le projet depuis le dépôt Git.
2. Ouvrir le projet avec un IDE compatible avec Java.
3. Compiler et exécuter la classe principale `Program.java` située dans `src/fr/esic/view/`.



