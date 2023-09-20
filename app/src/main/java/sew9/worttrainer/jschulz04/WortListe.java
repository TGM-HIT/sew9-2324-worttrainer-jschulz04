package sew9.worttrainer.jschulz04;
import java.util.Arrays;


/**
 * Klasse für Worttrainer
 * @author Johannes Schulz
 * @version 20-09-2022
 * 
 */
public class WortListe {

	private WortEintrag[] wortListe;

	/**
	 * Konstruktor
	 */
	public WortListe() {
		this.wortListe= new WortEintrag[0];
	}

	/**
	 * Fügt ein wort zum Array hinzu
	 * @param wort das Wort das hinzugefügt wird
	 */
	public void addWort(WortEintrag wort) {
		boolean ende = false;
		for(int i = 0; i<wortListe.length && ende==false; i++) {
			if(this.wortListe[i] == null) {
				this.wortListe[i] = wort;
				ende = true;
			}
		}
		if(ende==false) {
			this.wortListe= Arrays.copyOf(this.wortListe, this.wortListe.length+1);
			this.wortListe[this.wortListe.length-1] = wort; 
		}
	}

	public WortEintrag getWort(int index) {
		return this.wortListe[index];
	}


	public WortEintrag[] getWortEintragArray() {
		return wortListe;
	}

	/**
	 * Gibt die Länge der Wortliste zurück
	 * @return Länge der Wortliste
	 */
	public int getLength(){
		return this.wortListe.length;
	}

	/**
	 * Löscht ein Wort aus der Wortliste
	 * @param wort Wort das gelöscht werden soll
	 * @return ob es erfolgreich war
	 */
	public boolean deleteWord(String wort) {
		for(int i=0;i<this.wortListe.length;i++){
			if(wortListe[i].getWort().equals(wort)){
				wortListe[i]=null;
				return true;
			}
		}
		return false;
	}

	/**
	 * Gibt gesamte Wortliste als String zurück
	 * @return der fertige String
	 */
	@Override
	public String toString() {
		String s="";
		for(int i=0; i<wortListe.length; i++){
			if(wortListe[i]!=null){
				s=s+"\n"+wortListe[i];
			}
		}
		return s;
	}
}
