package fr.esic.controller;

import fr.esic.model.Client;
import fr.esic.model.Compte;
import fr.esic.model.Transaction;

import java.util.Date;

public class OperationCompte {

    public static int num = 1 ;

    public static Compte createCompte() {
        Compte c = new Compte("FR00P75015B"+ num , 0);
        num ++;
        return c;
    }

    public static Compte choixCompteByClient (Client client) {
        String data = "";
        int nb = 1;
        for (Compte c: client.getComptes()) {
            data += nb + " -"+ c.infoCompte() + "\n" ;
            nb++;
        }

        int choix = MyLibrary.saisieInt("Choisir le compte \n" + data);

        return client.getComptes().get(choix - 1);
    }

    public static void consulterSolde (Client client) {
        MyLibrary.afficher(choixCompteByClient(client).getSolde() + "€");
    }

    public static void consulterHistorique (Client client) {
        String data = "";
        int nb = 1;
        Compte c = choixCompteByClient(client);

        if (c != null) {
            for (Transaction t : c.getTransaction()) {
                data += nb + " -" + t.infoTransaction() + "\n";
                nb++;
            }
            MyLibrary.afficher(data);
        } else {
            MyLibrary.afficher("Le compte sélectionné n'est pas valide.");
        }

    }


    public static void depot(Client client) {
        Compte c = choixCompteByClient(client);
        double oldSolde = c.getSolde();
        Date date = new Date();
        double montant = MyLibrary.saisieDouble("Montant du dépôt");
        if (c.depot(montant) == true) {
            MyLibrary.afficher("Dépôt terminé !\nAncien solde : " + oldSolde + " €\nNouveau solde : " + c.getSolde());
            c.add(new Transaction("Dépôt", montant, date, "Succès"));
        } else {
            MyLibrary.afficher("Vous ne pouvez pas effectuer un dépôt de ce montant.");
            c.add(new Transaction("Dépôt", montant, date, "Échec"));
        }

    }

    public static void retrait(Client client) {
        Compte c = choixCompteByClient(client);
        double oldSolde = c.getSolde();
        Date date = new Date();
        double montant = MyLibrary.saisieDouble("Montant du retrait");
        if (c.retrait(montant) == true) {
            MyLibrary.afficher("Retrait terminé !\nAncien solde : " + oldSolde + " €\nNouveau solde : " + c.getSolde());
            c.add(new Transaction("Retrait", montant, date, "Succès"));
        } else {
            MyLibrary.afficher("Solde Insuffisant !!!");
            c.add(new Transaction("Retrait", montant, date, "Échec"));
        }

    }


    public static void virement(Client client) {
        Compte c = choixCompteByClient(client);
        double oldSolde = c.getSolde();
        Date date = new Date();
        String compte = MyLibrary.saisieString("Numero de Compte destinataire : ");
        Compte compteDestinataire = client.trouverCompteParNumero(compte);
        double montant = MyLibrary.saisieDouble("Montant du virement");

        if (compteDestinataire != null && c.virement(compteDestinataire, montant) == true ) {
            MyLibrary.afficher("Virement effectue !\nAncien solde : " + oldSolde + " €\nNouveau solde : " + c.getSolde());
            c.add(new Transaction("Virement vers " + compte , montant, date, "Succès"));
            compteDestinataire.add(new Transaction("Virement recu " + c , montant, date, "Succès"));
        } else {
            MyLibrary.afficher("Solde Insuffisant ou compte destinataire introuvable !!!");
            c.add(new Transaction("Virement vers " + compte , montant, date, "Échec"));
        }

    }

}
