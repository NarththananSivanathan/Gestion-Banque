package fr.esic.model;

import java.util.Date;

public class Transaction {

    private String description;
    private double montant;
    private Date date;
    private String statut ;

    //Constructeurs

    public Transaction() {

    }

    public Transaction(String description, double montant, Date date, String statut) {

        this.description = description;
        this.montant = montant;
        this.date = date;
        this.statut = statut;
    }

    //Getters et Setters

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String infoTransaction() {
        return date + " --> " + description + " de " + montant + "€" + "==> " + statut ;
    }

}
