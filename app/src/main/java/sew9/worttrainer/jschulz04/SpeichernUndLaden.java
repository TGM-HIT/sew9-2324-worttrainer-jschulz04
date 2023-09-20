package sew9.worttrainer.jschulz04;
import java.io.*;
import java.util.Scanner;
/**
 * Die Klasse SpeichernUndLaden
 * @author Johannes Schulz
 * @version 20-09-2022
 */
public class SpeichernUndLaden{
	private final String filename = "worttrainer.txt";
	WortTrainer wortTrainer;

	/**
	 * 
	 * @param versuche Die Versuche
	 * @param anzahlRichtig Wieviele richtig sind.	
	 * @param wortliste Die Wortliste
	 */
	public SpeichernUndLaden(WortTrainer wortTrainer) {
		this.wortTrainer = wortTrainer;
	}

	/**
	 * Speichert den Worttrainer in der angegebenen Datei
	 * @param filename Der Speicherort
	 * @throws IOException Excpetion
	 */
	public void speichern(String filename) throws IOException {
		File f = new File(filename);
		BufferedWriter writer = null;
		WortEintrag[] wortliste = wortTrainer.getWortListe().getWortEintragArray();
		writer = new BufferedWriter(new FileWriter(f));
		writer.write(wortTrainer.getRichtig() + System.lineSeparator() + wortTrainer.getFalsch() + System.lineSeparator());
		for (int i = 0; i < wortliste.length; ++i) {
			writer.write(wortliste[i].getWort() + ";" + wortliste[i].getUrl() + System.lineSeparator());
		}
		if (writer != null) {
			writer.close();
		}
	}

	/**
	 * Speichert den Worttrainer in der Default-Datei
	 */
	public void speichern() throws IOException {
		speichern(this.filename);
	}

	/**
	 * Lädt den Worttrainer aus der angegebenen Datei
	 * @param filename der Speicherrort
	 * @return den geladenen Worttrainer
	 */
	public WortTrainer laden(String filename) throws IOException {
		Scanner reader = new Scanner(new BufferedReader(new FileReader(filename)));
		String[] text;
		WortTrainer worttrainer = new WortTrainer();
		try {
			worttrainer.addRichtig(Integer.parseInt((reader.nextLine())));
			worttrainer.addFalsch(Integer.parseInt(reader.nextLine()));

			while (reader.hasNext()) {
				text = reader.nextLine().split(";");

				worttrainer.getWortListe().addWort(new WortEintrag(text[0], text[1]));
			}		
		} finally {
		reader.close();
		}
		return worttrainer;
	}
	
	/**
	 * Lädt den Worttrainer aus der Default-Datei
	 * @throws IOException
	 * @return den geladenen Worttrainer
	 */
	public WortTrainer laden() throws IOException {
		return laden(this.filename);
	}
}