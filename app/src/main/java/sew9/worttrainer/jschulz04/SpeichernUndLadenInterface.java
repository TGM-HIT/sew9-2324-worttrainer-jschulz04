package sew9.worttrainer.jschulz04;
import java.io.*;
import java.util.Scanner;
/**
 * Die Klasse SpeichernUndLaden
 * @author Johannes Schulz
 * @version 20-09-2022
 */
public interface SpeichernUndLadenInterface{

	/**
	 * Speichert den Worttrainer in der angegebenen Datei
	 * @param filename Der Speicherort
	 * @throws IOException Excpetion
	 */
	public void speichern(String filename) throws IOException;

	/**
	 * Speichert den Worttrainer in der Default-Datei
	 */
	public void speichern() throws IOException;

	/**
	 * Lädt den Worttrainer aus der angegebenen Datei
	 * @param filename der Speicherrort
	 * @return den geladenen Worttrainer
	 */
	public void laden(String filename) throws IOException;
	
	/**
	 * Lädt den Worttrainer aus der Default-Datei
	 * @throws IOException
	 * @return den geladenen Worttrainer
	 */
	public void laden() throws IOException;
}