package ticketsystem;

public class Ticket {
	String customerName;
	private String name;
	String model;
	// LL Ticket Attribute
	
	
	public String getCustomerName() {
		return customerName;
	}
	public String getName() {
		return name;
	
	}
	public String getmodel() {
		return model;
	}
	
	// LL getMethoden zu den Attributen 


 		// LL Set Methode zu den Attributen 
	
		void setCustomerName(String customerName) { this.customerName = customerName;}
		void setName(String v) {
			name = v;	
		}
	
		void setModel(String m) {
			model = m;
	}
		
}

