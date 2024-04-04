package fr.esic.view;

import fr.esic.controller.OperationClient;
import fr.esic.controller.OperationCompte;
import fr.esic.model.Address;
import fr.esic.model.Client;
import fr.esic.model.Compte;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Program {

    static {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dateNaissance1 = null;
        try {
            dateNaissance1 = sdf.parse("18/01/1994");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Date dateNaissance2 = null;
        try {
            dateNaissance2 = sdf.parse("18/01/1994");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Compte c1 = new Compte("FR00P75015B"+OperationCompte.num , 150);
        OperationCompte.num ++;
        Compte c3 = new Compte("FR00P75015B"+OperationCompte.num , 0 );
        OperationCompte.num ++;
        Compte c4= new Compte("FR00P75015B"+OperationCompte.num , 315 );
        OperationCompte.num ++;

        List<Compte> comptes1 = new ArrayList<>();
        comptes1.add(c1);
        comptes1.add(c3);
        List<Compte> comptes2 = new ArrayList<>();
        comptes2.add(c4);

        Address a1 = new Address ("374 rue de vaugirad","75015" , "Paris" );
        Address a2 = new Address ("36 avenue pierre brossolet", "92240" , "Malakoff");

        Client client1 = new Client("JOJO" , "Jo" ,  dateNaissance1, "France" , "joel@esic.fr" , "azerty" , a1 , comptes1);
        Client client2 = new Client ("SIVA" , "Nath" , dateNaissance2, "France",  "nartha@esic.fr" , "azerty" , a2 , comptes2 );


        OperationClient.banque.add(client1);
        OperationClient.banque.add(client2);

    }

    public static void main(String[] args) {
        Menu.menuPrincipal();
    }
}
