package fr.esic.view;

import fr.esic.controller.MyLibrary;
import fr.esic.controller.OperationAdmin;
import fr.esic.controller.OperationClient;
import fr.esic.controller.OperationCompte;
import fr.esic.model.Admin;
import fr.esic.model.Client;
import fr.esic.model.Compte;

public class Menu {

    public static Client clientConnecte = null ;

    //Va servir à avoir des methodes pour l'affichage

    public static void menuPrincipal() {
        String msg = "Menu Principal \n\n 1- Créer un compte \n 2- Se connecter en tant que client \n 3- Se connecter en tant que admin \n\n 0- Quitter" ;

        boolean sortie = false ;

        while(sortie == false) {
            switch (MyLibrary.saisieInt(msg)) {
                case 1:
                    OperationClient.creationClient();
                    break;
                case 2:
                    clientConnecte = OperationClient.authClient();
                    if (clientConnecte != null) {
                        menuAfterConnected();
                    }
                    else {
                        MyLibrary.afficher("Identifiant ou mot de passe incorrect !!");
                    }
                    break;
                case 3:
                    //connexion admin
                    Admin admin = OperationAdmin.authAdmin();
                    if (admin != null) {
                        menuAdmin(admin);
                    } else {
                        MyLibrary.afficher("Identifiant ou mot de passe administrateur incorrect !");
                    }
                    break;

                case 0:
                    sortie = true;
                    break;

                default:
                    MyLibrary.afficher("Error !!!");
                    break;
            }
        }
    }

    public static void menuAfterConnected() {
        String msg = "Bonjour " + clientConnecte.getNom() + " " + clientConnecte.getPrenom() + "\n" + "Menu Operation sur un compte \n\n 1- Consulter son solde  \n 2- Faire un depot \n 3- Faire un retrait \n 4- Faire un virement \n 5- Historique de transaction  \n 6- Creer un autre compte \n\n 7- Se deconnecter  \n\n 0- Quitter" ;

        boolean sortie = false ;

        while(sortie == false) {
            switch (MyLibrary.saisieInt(msg)) {
                case 1:
                    OperationCompte.consulterSolde(clientConnecte);
                    break;
                case 2:
                    OperationCompte.depot(clientConnecte);
                    break;
                case 3:
                    OperationCompte.retrait(clientConnecte);
                    break;
                case 4:
                    OperationCompte.virement(clientConnecte);
                    break;
                case 5:
                    OperationCompte.consulterHistorique(clientConnecte);
                    break;
                case 6:
                    Compte c = OperationCompte.createCompte();
                    clientConnecte.getComptes().add(c);
                    MyLibrary.afficher(c.getNumeroCompte() + " a bien ete cree");
                    break;
                case 7:
                    sortie = true;
                    break;
                case 0:
                    System.exit(1);
                    break;

                default:
                    MyLibrary.afficher("Error !!!");
                    break;
            }
        }
    }


    public static void menuAdmin(Admin admin) {

        String msg = "Bonjour " +   "\n" + "Menu Administrateur \n\n 1 - Gérer les clients \n 2 - Gérer les comptes \n 3 - Se déconnecter  \n\n 0- Quitter" ;

        boolean sortie = false ;

        while(sortie == false) {
            switch (MyLibrary.saisieInt(msg)) {
                case 1:
                    OperationAdmin.gererClients();
                    break;
                case 2:
                    OperationAdmin.gererComptes();
                    break;
                case 3:
                    sortie = true;
                    break;
                case 0:
                    System.exit(1);
                    break;
                default:
                    MyLibrary.afficher("Error !!!");
                    break;
            }
        }
    }

}
