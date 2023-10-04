package sew9.worttrainer.jschulz04;

import java.io.IOException;
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
        WortEintrag worteintrag1 = new WortEintrag("Kuh", "https://media.istockphoto.com/id/1319467946/photo/young-black-and-white-cow-heifer-in-a-meadow-looking-in-the-camera.jpg?s=612x612&w=0&k=20&c=Z1maGtrEMrbAEVw6ZTJwyvq2_rkolky9LJX34mSZ6Kg=");

        //Wortliste
        WortListe wortliste1 = new WortListe();
        wortliste1.addWort(worteintrag1);

        //Worttrainer
        WortTrainer trainer = new WortTrainer(wortliste1);
        SpeichernUndLaden sul = new SpeichernUndLaden(trainer);
        try {
            sul.laden();
        } catch (IOException e) {
            System.out.println("EI OU Exteption");
        }

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
                    try {
                        sul.speichern();
                    } catch (IOException e) {
                        System.out.println("EI OU Exteption");
                    }
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