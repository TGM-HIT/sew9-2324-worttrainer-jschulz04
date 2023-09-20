package sew9.worttrainer.jschulz04;

import java.io.IOException;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 * Testet alle Worttrainer Methoden
 * @author Johannes Schulz
 * @version 20-09-2022
 * 
 */
public class Main {
    public static void main(String[] args) {
        //Worteintrag
        WortEintrag worteintrag1 = new WortEintrag("eins", "https://www.eins.com");
        WortEintrag worteintrag2 = new WortEintrag("zwei", "http://www.zwei.com");
        WortEintrag worteintrag3 = new WortEintrag("drei", "http://www.drei.com");

        //Wortliste
        WortListe wortliste1 = new WortListe();
        wortliste1.addWort(worteintrag1);
        wortliste1.addWort(worteintrag2);
        wortliste1.addWort(worteintrag3);

        //Worttrainer
        WortTrainer trainer = new WortTrainer(wortliste1);
    }
}