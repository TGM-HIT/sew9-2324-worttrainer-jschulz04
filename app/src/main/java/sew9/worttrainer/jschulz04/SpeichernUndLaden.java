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
		writer = new BufferedWriter(new FileWriter(f));
		writer.write(wortTrainer.getRichtig() + System.lineSeparator() + wortTrainer.getFalsch() + System.lineSeparator());
		writer.close();
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
	public void laden(String filename) throws IOException {
		Scanner reader = new Scanner(new BufferedReader(new FileReader(filename)));
		try {
			int richtige = Integer.parseInt(reader.nextLine());
			int falsche = Integer.parseInt(reader.nextLine());
			wortTrainer.addRichtig(richtige);
			wortTrainer.addFalsch(falsche);		
		} finally {
		reader.close();
		}
	}
	
	/**
	 * Lädt den Worttrainer aus der Default-Datei
	 * @throws IOException
	 * @return den geladenen Worttrainer
	 */
	public void laden() throws IOException {
		laden(this.filename);
	}
}