package fr.esic.controller;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyLibrary {
    //Les methodes pour aider

    public static int saisieInt(String msg) {
        return Integer.parseInt(JOptionPane.showInputDialog(msg));
    }

    public static double saisieDouble(String msg) {
        return Double.parseDouble(JOptionPane.showInputDialog(msg));
    }

    public static String saisieString(String msg) {
        return JOptionPane.showInputDialog(msg);
    }

    public static void afficher(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    public static Date saisieDate(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        Date date = null;
        boolean saisieValide = false;

        while (!saisieValide) {
            try {
                String dateStr = JOptionPane.showInputDialog(msg);
                date = sdf.parse(dateStr);
                saisieValide = true;
            } catch (ParseException e) {
                // La date n'est pas au bon format, affichez un message d'erreur et réessayez.
                JOptionPane.showMessageDialog(null, "Format de date invalide. Utilisez le format MM/dd/yyyy.");
            }
        }

        return date;
    }
}
