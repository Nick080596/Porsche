package ticketsystem.io;

import ticketsystem.Ticket;

import java.io.IOException;
import java.util.List;

public class TicketsWriter extends CSVWriter {

  public TicketsWriter(String filename)  {
    super(filename);
  }

  // kategorie fehlt noch
  public void write(List<Ticket> tickets) throws IOException {
    open();
    // schleife über alle Tickets
    for (Ticket ticket : tickets) {
      // Ticket Nummer fehl noch
      write(ticket.getCustomerName());
      writeTab();
      write(ticket.getName());
      writeTab();
      write(ticket.getmodel());
      writeNewLine();
    }
    close();
  }
}
