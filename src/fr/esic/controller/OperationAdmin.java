package fr.esic.controller;

import fr.esic.model.Admin;

public class OperationAdmin {

    // Créez un administrateur
    public static Admin createAdmin(String username, String password) {
        Admin admin = new Admin(username, password);
        return admin;
    }

    // Authentification de l'administrateur
    public static Admin authAdmin() {
        String username = MyLibrary.saisieString("Identifiant administrateur : ");
        String password = MyLibrary.saisieString("Mot de passe administrateur : ");
        if (username.equals("admin") && password.equals("admin")) {
            return new Admin(username, password);
        } else {
            return null;
        }
    }

    //Gestion des clients CRUD
    public static void gererClients() {
        // Implémenter la gestion des clients
        MyLibrary.afficher("Gestion des clients ");
    }

    // Gestion des comptes CRUD
    public static void gererComptes() {
        // Implémenter la gestion des comptes
        MyLibrary.afficher("Gestion des comptes ");
    }

}
