package sew9.worttrainer.jschulz04;
import java.net.*;
import javax.swing.JOptionPane;

/**
 * Klasse für Worteintrag
 * @author Johannes Schulz
 * @version 20-09-2022
 * 
 */
public class WortEintrag {
	private String wort;
	private String url;

	/**
	 * Konstruktor
	 * @param w Wort
	 * @param u URL
	 */
	public WortEintrag(String w, String u) {
		setWort(w);
		setUrl(u);
	}

	/**
	 * überprüft ob die URL sinnvoll ist
	 * @param u URL
	 * @return ob sie sinnvoll ist
	 */
	public static boolean checkURL(String u) {
		if(u==null) {
			new NullPointerException("URL leer");
			return false;
		}
		else {
			try {
				URL web = new URL(u);
				web.toURI();
				return true;
			} catch(MalformedURLException e) {
				return false;
			} catch(URISyntaxException e) {
				return false;
			}
		}
	}

	public void setWort(String wort) {
		try{
			if(wort.length()>=2){
				this.wort=wort;
			}
			else {
				throw new IllegalArgumentException("Das Wort ist zu kurz!");
			}
		} catch(IllegalArgumentException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}

	public void setUrl(String u) {
		if(!checkURL(url)){
			this.url=u;
		}else {
			throw new NullPointerException("Die Url ist ungültig!");
        }
	}

	public String getWort() {
		return this.wort;
	}

	public String getUrl() {
		return this.url;
	}
	
	/**
	 * Gibt Wort und URL als String zurück
	 * @return der fertige String
	 */
	@Override
	public String toString() {
		return wort+"; "+url;
	}

}



