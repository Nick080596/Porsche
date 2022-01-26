package ticketsystem.io;

import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {

  private String fileName;
  private FileWriter writer;
  public CSVWriter(String fileName) {
    this.fileName = fileName;
  }

  void open() throws IOException {
    writer = new FileWriter(fileName);
  }

  void writeTab() throws IOException {
    writer.write("\t");
  }

  // write Aberladen für string
  void write(String str) throws IOException {
    writer.write(str);
  }

  // write überladen für int
  void write(int i) throws IOException {
    writer.write(String.valueOf(i));
  }

  // string mit Zeilenumbruch
  void writeNewLine() throws IOException {
    writer.write("\n");
  }

  // Exception muß außerhalb behandelt werden
  void close() throws IOException {
    writer.close();
  }

}
