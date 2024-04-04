package fr.esic.model;

import java.util.Date;
import java.util.List;

public class Client {

    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String lieuNaissance;
    private String login;
    private String password;
    private Address adresse ;
    private List<Compte> comptes ;

    //Constructor

    public Client() {
        // TODO Auto-generated constructor stub
    }


    public Client(String nom, String prenom, Date dateNaissance, String lieuNaissance, String login, String password,
                  Address adresse, List<Compte> comptes) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.login = login;
        this.password = password;
        this.adresse = adresse;
        this.comptes = comptes;
    }



    //Getters and Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }



    public Date getDateNaissance() {
        return dateNaissance;
    }


    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }


    public String getLieuNaissance() {
        return lieuNaissance;
    }


    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAdresse() {
        return adresse;
    }

    public void setAdresse(Address adresse) {
        this.adresse = adresse;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

    //Methods

    //Avoir les informations d'un client
    public String infoClient() {
        return prenom + " " + nom + " ==> ["+ login + "]\n" + adresse.infoAddress()+ "\n";
    }

    //Afficher la liste des comptes d'un client

    public String afficherComptes() {
        String data = "";
        for (Compte compte : comptes) {
            data += compte.infoCompte() + "\n" ;
        }
        return data;
    }


    public Compte trouverCompteParNumero(String numeroCompte) {
        for (Compte compte : comptes) {
            if (compte.getNumeroCompte().equals(numeroCompte)) {
                return compte;
            }
        }
        return null;
    }

}
