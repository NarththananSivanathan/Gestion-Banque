package fr.esic.model;

import java.util.ArrayList;
import java.util.List;

public class Compte {

    private String numeroCompte;
    private double solde;
    private List<Transaction> transactions;


    //Constructors

    public Compte() {

    }


    public Compte(String numeroCompte, double solde) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.transactions = new ArrayList<Transaction>(); ;
    }



    //Getters and Setters

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public List<Transaction> getTransaction() {
        return transactions;
    }

    public void setTransaction(List<Transaction> transactions) {
        this.transactions = transactions;
    }


    //Les Methodes

    public String infoCompte() {
        return "N° " + numeroCompte + " : " + solde + "€";
    }

    public String afficherTransaction() {
        String data = "";
        for (Transaction transaction : transactions) {
            data += transaction.infoTransaction() + "\n" ;
        }
        return data;
    }

    public void add(Transaction transaction) {
        transactions.add(transaction);

    }

    public boolean depot(double montant) {
        if (montant > 0) {
            solde += montant;
            return true;
        }
        else {
            return false;
        }

    }


    public boolean retrait(double montant) {
        if(montant <= solde) {
            solde-=montant;
            return true;
        }else {
            return false;
        }
    }


    public boolean virement(Compte c, double montant) {
        if(this.retrait(montant)) {
            c.depot(montant);
            return true;
        }else {
            return false;
        }
    }


}
