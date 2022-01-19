public class Kunde {
    String name;
    /
     * @return the name
     */
    public String getName() {
        return name;
    }
    /
     * @param name
     * @param vorName
     * @param ticketNummer
     * @param kundenNummer
     */


    public Kunde(String name, String vorName, String ticketNummer, String kundenNummer) {
        this.name = name;
        this.vorName = vorName;
        this.ticketNummer = ticketNummer;
        this.kundenNummer = kundenNummer;    }
    @Override
    public String toString() {
        return "Kunde [name=" + name + ", vorName=" + vorName + ", ticketNummer=" + ticketNummer + ", kundenNummer="
                + kundenNummer + "]";
    }
    /
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /
     * @return the vorName
     */
    public String getVorName() {
        return vorName;
    }
    /
     * @param vorName the vorName to set
     */
    public void setVorName(String vorName) {
        this.vorName = vorName;
    }
    /
     * @return the ticketNummer
     */
    public String getTicketNummer() {
        return ticketNummer;
    }
    /
     * @param ticketNummer the ticketNummer to set
     */
    public void setTicketNummer(String ticketNummer) {
        this.ticketNummer = ticketNummer;
    }
    /
     * @return the kundenNummer
     */
    public String getKundenNummer() {
        return kundenNummer;
    }
    /**
     * @param kundenNummer the kundenNummer to set
     */
    public void setKundenNummer(String kundenNummer) {
        this.kundenNummer = kundenNummer;
    }
    String vorName;
    String ticketNummer;
    String kundenNummer;


}