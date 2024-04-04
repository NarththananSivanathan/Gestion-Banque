package fr.esic.controller;

import fr.esic.model.Address;
import fr.esic.model.Banque;
import fr.esic.model.Client;
import fr.esic.model.Compte;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperationClient {

    //Les methodes pours les operations d'un client

    public static Banque banque = new Banque();

    public static void creationClient() {
        String nom = MyLibrary.saisieString("Votre Nom");
        String prenom = MyLibrary.saisieString("Votre prenom");
        Date dateNaissance = MyLibrary.saisieDate("Votre date de naissance en format JJ/MM/AAAA");
        String lieuNaissance = MyLibrary.saisieString("Votre lieu de Naissance");

        // Vérifiez si le client existe déjà
        if (banque.clientExisteDeja(nom, prenom, dateNaissance, lieuNaissance)) {
            MyLibrary.afficher("Ce client existe déjà !");
            return; // Ne créez pas de nouveau client
        }
        String login = MyLibrary.saisieString("Votre email");
        String password = MyLibrary.saisieString("Votre mot de passe");
        String verifierpass = MyLibrary.saisieString("Reecrire le mot de passe");
        Address a = OperationAddress.createAddress();



        while (!password.equals(verifierpass)) {
            MyLibrary.afficher("Les mots de passe ne correspondent pas. Veuillez réessayer.");
            password = MyLibrary.saisieString("Votre mot de passe");
            verifierpass = MyLibrary.saisieString("Réécrire le mot de passe");
        }

        List<Compte> comptes = new ArrayList<>();
        comptes.add(OperationCompte.createCompte());

        Client c = new Client(nom, prenom, dateNaissance, lieuNaissance, login, password, a, comptes);
        banque.add(c);
    }

    public static Client authClient() {
        String login = MyLibrary.saisieString("Votre identifiant ");
        String password = MyLibrary.saisieString("Votre mot de passe");

        Client c = null;

        for (Client client : banque.getClients()) {
            if (client.getLogin().equals(login) && client.getPassword().equals(password)) {
                c = client;
            }
        }
        return c;
    }

}
