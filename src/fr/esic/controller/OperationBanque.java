package fr.esic.controller;

import fr.esic.model.Address;
import fr.esic.model.Banque;
import fr.esic.model.Client;

public class OperationBanque {

    private static Banque banque = new Banque();

    public static Banque getBanque() {
        return banque;
    }

    public static void listerClients() {
        for (Client client : banque.getClients()) {
            MyLibrary.afficher(client.infoClient());
        }
    }

    public static void rechercherClient(String recherche) {
        for (Client client : banque.getClients()) {
            if (client.getNom().contains(recherche) || client.getPrenom().contains(recherche)) {
                MyLibrary.afficher(client.infoClient());
            }
        }
    }

    public static void modifierClient(Client client, String nom, String prenom, Address adresse) {
        client.setNom(nom);
        client.setPrenom(prenom);
        client.setAdresse(adresse);
    }

    public static void supprimerClient(Client client) {
        banque.getClients().remove(client);
    }

}
