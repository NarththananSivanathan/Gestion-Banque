package fr.esic.controller;

import fr.esic.model.Address;

public class OperationAddress {

    public static Address createAddress () {
        String rue = MyLibrary.saisieString("Votre numero et nom de la rue") ;
        String codePostal = MyLibrary.saisieString("Votre code postal");
        String ville = MyLibrary.saisieString("Votre ville");

        return new Address(rue, codePostal , ville);
    }

}
