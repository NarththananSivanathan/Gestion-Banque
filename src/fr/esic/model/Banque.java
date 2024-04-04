package fr.esic.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Banque {

    private List<Client> clients ;


    public Banque() {
        this.clients = new ArrayList<>();
    }

    //Getters et Setters

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public void add(Client c) {
        clients.add(c);
    }


    public boolean clientExisteDeja(String nom, String prenom, Date dateNaissance, String lieuNaissance) {
        for (Client client : this.getClients()) {
            if (client.getNom().equals(nom) &&
                    client.getPrenom().equals(prenom) &&
                    client.getDateNaissance().equals(dateNaissance) &&
                    client.getLieuNaissance().equals(lieuNaissance)) {
                return true; // Le client existe déjà
            }
        }
        return false; // Le client n'existe pas
    }
}
