package ticketsystem.io;


import ticketsystem.Ticketkategorie;

import java.io.IOException;
import java.util.List;


public class KategoryWriter extends CSVWriter{
	
 public KategoryWriter(String filename) {
	 super(filename);
 }
 public void write(List<Ticketkategorie> kategory) throws IOException {
	 open();
	 //Schleife über alle Kategorien
	 for(Ticketkategorie kategorie : kategory) {
		 write(kategorie.getKategoryName());
		 writeTab();
	 }
	 close();
 }
}
