package sew9.worttrainer.jschulz04;
import java.util.*;

/**
 * Klasse für Worttrainer
 * @author Johannes Schulz
 * @version 20-09-2022
 * 
 */
public class WortTrainer {

	private WortListe wortListe;
	private int fragen;
	private int richtig;
	private int falsch;

	/**
	 * Konstruktor
	 * @param wortListe Die liste die Benutzt wird
	 */
	public WortTrainer(){
		this.wortListe=new WortListe();
		this.fragen=0;
		this.richtig=0;
		this.falsch=0;
	}
	/**
	 * Konstruktor
	 * @param wortListe Die liste die Benutzt wird
	 */
	public WortTrainer(WortListe wortListe){
		this.wortListe=wortListe;
		this.fragen=0;
		this.richtig=0;
		this.falsch=0;
	}

	/**
	 * Gibt ein zufälliges wort aus der Liste zurück
	 * @return das zufällige Wort
	 */
	public WortEintrag getRandomWort() {
		boolean x=true;
		Random r=new Random();
		int random= r.nextInt(this.wortListe.getLength());
		while(x){
			if(this.wortListe.getWort(random)!=null){
				return this.wortListe.getWort(random);
			}
		}
		return null;
	}

	/**
	 * Gibt das Wort an dem Index aus der Liste zurück
	 * @param index der Index des Wortes
	 * @return Das wort an der Stelle
	 */
	public WortEintrag getWort(int index) {
		return this.wortListe.getWort(index);
	}

	/**
	 * Überprüft ob die Wörter übereinstimmen
	 * @param wort das Wort das zu Überprüfen ist
	 * @param index der Index an dem das Wort steht
	 * @return ob die Wörter übereinstimmen
	 */
	public boolean check(String wort,int index) {
		this.fragen++;
		if(this.wortListe.getWort(index).getWort().equals(wort)){
			this.richtig++;
			return true;
		}
		this.falsch++;
		return false;
	}

	/**
	 * Überprüft ob die Wörter übereinstimmen, auf groß/kleinschreibung wird nicht geachtet
	 * @param wort das Wort das zu Überprüfen ist
	 * @param index der Index an dem das Wort steht
	 * @return ob die Wörter übereinstimmen
	 */
	public boolean checkIgnoreCase(String wort,int index) {
		this.fragen++;
		if(wortListe.getWort(index).getWort().toLowerCase().equals(wort.toLowerCase())){
			this.richtig++;
			return true;
		}
		this.falsch++;
		return false;
	}
	public WortListe getWortListe() {
		return wortListe;
	}
	
	public int getFragen(){
		return fragen;
	}
	public int getRichtig(){
		return richtig;
	}
	public void addRichtig(int anzahl) {
		richtig += anzahl;
	}
	public int getFalsch(){
		return falsch;
	}
	public void addFalsch(int anzahl) {
		falsch += anzahl;
	}
	public String getFehlerQuote(){
		String fehlerQuote= new String("Von "+fragen+" Fragen waren "+richtig+" Wörter richtig und, "+falsch+" Wörter falsch");
		return fehlerQuote;
	}
}

