package sew9.worttrainer.jschulz04;

import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Testet alle Worttrainer Methoden
 * @author Johannes Schulz
 * @version 20-09-2022
 * 
 */
public class App {
    public static void main(String[] args) {
        //Worteintrag
        WortEintrag worteintrag1 = new WortEintrag("eins", "www.eins.com");

        //Wortliste
        WortListe wortliste1 = new WortListe();
        wortliste1.addWort(worteintrag1);

        //Worttrainer
        WortTrainer trainer = new WortTrainer(wortliste1);
        String antwort = "";
        ImageIcon ii;

        Random r = new Random();
        boolean  wortRichtig = false, spielBeendet = false;

        JOptionPane.showMessageDialog(null, "Herzlich Willkommen zu meinem Worttrainer");
        while(!spielBeendet) {
            WortEintrag neuesWort = trainer.getWortListe().getWortEintragArray()[r.nextInt(trainer.getWortListe().getWortEintragArray().length)];
            do{
                try {
                    ii = new ImageIcon(new URL(neuesWort.getUrl()));
                    JOptionPane.showMessageDialog(null, "Merk dir das Bild: ", "Display Image", JOptionPane.INFORMATION_MESSAGE, ii);
                    antwort = JOptionPane.showInputDialog(null, "Was war auf dem Bild zu sehen?");
                } catch (Exception e) {
                    System.out.println("FELA");
                }
                if(antwort.equals("")){
                    spielBeendet = true;
                    break;
                }
                if(antwort.equals(neuesWort.getWort())) {
                    JOptionPane.showMessageDialog(null, "Richtig :)");
                    trainer.addRichtig(1);
                    wortRichtig = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Falsch :(");
                    trainer.addFalsch(1);
                    wortRichtig = false;
                }
            }while(!wortRichtig);
        }
        JOptionPane.showMessageDialog(null, "Richtig: "+trainer.getRichtig()+" Falsch: "+trainer.getFalsch());
    }
}