package ticketsystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

import ticketsystem.io.KategoryWriter;
import ticketsystem.io.TicketsWriter;
import javax.swing.JList;

public class Bildschirm extends JFrame {
	private JLayeredPane Anzeigefenster;
	private JPanel panel_KategorieBearbeiten;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_1;
	
	private JPanel panel_Startbildschirm;
	private JLabel lblNewLabel_6;
	
	private JPanel panel_TicketAnlegen;
	private JLabel lblNewLabel_11;
	private JButton btnNewButton_4;
	private JTable table_Kunde;
	private JScrollPane scrollPane;
	private JButton btnNewButton_5;
	private JLabel lblNewLabel_backround;
	private JLabel lblNewLabel_12;
	private JButton btnNewButton_6;
	private JScrollPane scrollPane_2;
	private JButton btnNewButton_7;
	private JTable table_Kategorie;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JButton btnNewButton_2;
	private JButton btnNewButton_8;
	private JButton btn_CSV_download;
	private JButton btnNewButton_3;
	private JTextField textField;

	//Ab heir Array f�r Kategorie

	Vector<Ticketkategorie> kategory = new Vector();
	private JTextField textField_1;; 	
		
	// LL ab hier Array f�r Tickets 
	Vector<Ticket> tickets = new Vector(); // vektor ist eine Liste (die synchroniert ist) das Modell
	private JComboBox comboBox_KategorieWählen;
	private JTextField textField_Vorname;
	private JTextField textField_KundenName;
	private JTextField textField_Model;
	private JLabel lblNewLabel_PorscheStartseite;
	private JButton btn_CSV_upload;
	private JPanel panel_TicketBearbeiten;
	private JLabel lblNewLabel_9;
	private JTextField textField_change_customerName;
	private JLabel lblNewLabel_10;
	private JTextField textField_change_Name;
	private JLabel lblNewLabel_16;
	private JButton btn_save_update;
	private JLabel lblNewLabel_17;
	private JTextField textField_chance_Time;
	private JLabel lblNewLabel_18;
	private JLabel lblNewLabel_19;
	private JComboBox comboBox_KategorieAendern;
	private JTextField textField_change_Comment;
	private JLabel lblNewLabel_20;
	private JScrollPane scrollPane_1;
	private JTable table;
	private JButton btnNewButton_9;
	private JButton btnNewButton_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bildschirm frame = new Bildschirm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	void updateKategoryTable () {
		
		Vector columnLabels = new Vector();
		columnLabels.add("Kategorie");
				
		
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnLabels);
		table_Kategorie.setModel(model);
		
		for (int i = 0; i< kategory.size(); i++) {
			
			model.addRow( new Object[] {
				kategory.get(i).getKategoryName()
			});
			}
		}
	
		void updateTicketTable () {
//			DefaultTableModel model = (DefaultTableModel) table_Kunde.getModel();

			Vector columnLabels = new Vector();
			columnLabels.add("Ticket Nr");
			columnLabels.add("Name");
			columnLabels.add("Vorname");
			columnLabels.add("Auto Model");
			columnLabels.add("Kategorie");
			

			DefaultTableModel tmodel = new DefaultTableModel();
			tmodel.setColumnIdentifiers(columnLabels);
			table_Kunde.setModel(tmodel);

			for (int i = 0; i < tickets.size(); i++) {

				tmodel.addRow( new Object[] {
						"2022_"+i,
						tickets.get(i).getCustomerName(),
						tickets.get(i).getName(),
						tickets.get(i).getmodel(),
						"N/A",
					
				});

				table_Kunde.setModel(tmodel);

//				model.addRow(new Object[] {
//						"2022_"+i,
//						tickets.get(i).getKndenname(),
//						tickets.get(i).getVorname(),
//						tickets.get(i).getBearbeitungsZeit(),
//						tickets.get(i).getKommentar()
//				});
//
//				table_Kunde.setValueAt("2022_"+i, i, 0);
//				table_Kunde.setValueAt(tickets.get(i).getKndenname(), i, 1);
//				table_Kunde.setValueAt(tickets.get(i).getVorname(), i, 2);
//				table_Kunde.setValueAt(tickets.get(i).getBearbeitungsZeit(), i, 3);
//				//table_Kunde.setValueAt(arrTicket[i].getKategorie(), i, 4);
//				table_Kunde.setValueAt(tickets.get(i).getKommentar(), i, 5);
			}


//			for(int i = 0; tickets.length > i ; i++) {
//				if(tickets[i] !=null) {
//					table_Kunde.setValueAt("2022_"+i, i, 0);
//					table_Kunde.setValueAt(tickets[i].getKndenname(), i, 1);
//					table_Kunde.setValueAt(tickets[i].getVorname(), i, 2);
//					table_Kunde.setValueAt(tickets[i].getBearbeitungsZeit(), i, 3);
//					//table_Kunde.setValueAt(arrTicket[i].getKategorie(), i, 4);
//					table_Kunde.setValueAt(tickets[i].getKommentar(), i, 5);
//
//				}
//			}
				
	}

	public void clearTicketFields() {
		// LL Textfeld leeren
		textField_KundenName.setText("");
		textField_Vorname.setText("");
		textField_Model.setText("");
		
		//comboBox_KategorieW�hlen.removeAllItems();

	}
	
	public void clearKategoryField() {
		// LL Textfeld Kategorie leeren
		textField_1.setText("");

}
	
	public void showOverview(JPanel panel_TicketTabelle) {

		// LL Festern zum �bersicht wechseln
		Anzeigefenster.removeAll();
		Anzeigefenster.add(panel_TicketTabelle);
		Anzeigefenster.repaint();
		Anzeigefenster.revalidate();

	}
	
public void showOverview2(JPanel panel_KategorieBearbeiten) {
		
		Anzeigefenster.removeAll();
		Anzeigefenster.add(panel_KategorieBearbeiten);
		Anzeigefenster.repaint();
		Anzeigefenster.revalidate();
}

	public Ticket createTicketFromUI() {
		Ticket ticket = new Ticket();

		ticket.setCustomerName(textField_KundenName.getText());
		ticket.setName(textField_Vorname.getText());
		ticket.setModel(textField_Model.getText());
		//arrTicket[i].setKategorie(comboBox_KategorieW�hlen.getSelectedItem().toString());

		return ticket;
	}
	public Ticketkategorie createKategoryFromUI() {
		Ticketkategorie kategory = new Ticketkategorie();
		
		kategory.setKategoryName(textField_1.getText());
		
		return kategory;
	}
	/**
	 * Create the frame.
	 */
	public Bildschirm() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("MENU");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("BankGothic Md BT", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 56, 89, 14);
		contentPane.add(lblNewLabel);

		btnNewButton = new JButton("Kategorie");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Anzeigefenster.removeAll();
				Anzeigefenster.add(panel_KategorieBearbeiten);
				Anzeigefenster.repaint();
				Anzeigefenster.revalidate();
			}
			// LL Verlinkung vom Button zur Unterseite

		});
		btnNewButton.setBounds(10, 247, 117, 23);
		contentPane.add(btnNewButton);

		Anzeigefenster = new JLayeredPane();
		Anzeigefenster.setBounds(149, 31, 600, 425);
		contentPane.add(Anzeigefenster);
		Anzeigefenster.setLayout(new CardLayout(0, 0));

		panel_Startbildschirm = new JPanel();
		panel_Startbildschirm.setBackground(Color.WHITE);
		Anzeigefenster.add(panel_Startbildschirm, "name_8144671825200");
		panel_Startbildschirm.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Willkommen bei Porsche");
		lblNewLabel_5.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_5.setBackground(Color.WHITE);
		lblNewLabel_5.setBounds(32, 43, 185, 114);
		panel_Startbildschirm.add(lblNewLabel_5);
		// LL WillkommensText

		lblNewLabel_6 = new JLabel("Ticketsystem");
		lblNewLabel_6.setFont(new Font("Bahnschrift", Font.PLAIN, 23));
		lblNewLabel_6.setBounds(32, 130, 221, 64);
		panel_Startbildschirm.add(lblNewLabel_6);
	
		lblNewLabel_PorscheStartseite = new JLabel("Bild1");
		Image img = new ImageIcon(this.getClass().getResource("/porsche_20911carreras2wdcp8e_lowaggressive.png")).getImage();
		lblNewLabel_PorscheStartseite.setIcon(new ImageIcon(img));
		lblNewLabel_PorscheStartseite.setBounds(42, 52, 600, 425);
		panel_Startbildschirm.add(lblNewLabel_PorscheStartseite);
		// LL HintergrundBild

		JPanel panel_TicketTabelle = new JPanel();
		Anzeigefenster.setLayer(panel_TicketTabelle, 5);
		panel_TicketTabelle.setBackground(Color.WHITE);
		Anzeigefenster.add(panel_TicketTabelle, "name_92370989658200");
		panel_TicketTabelle.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 580, 203);
		panel_TicketTabelle.add(scrollPane);

		table_Kunde = new JTable();
		table_Kunde.setFont(new Font("Arial", Font.PLAIN, 11));
		scrollPane.setViewportView(table_Kunde);


//		table_Kunde.setModel();

//		table_Kunde.setModel(new DefaultTableModel(
//			new Object[][] {
//				{"", null, null, null, null, null},
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//				{null, null, null, null, null, null},
//			},
//			new String[] {
//				"Ticket Nr", "Name", "Vorname", "Bearbeitungszeit", "Kategorie", "Kommentar"
//			}
//				));

		btnNewButton_5 = new JButton("Ticket Bearbeiten");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				Anzeigefenster.removeAll();
				Anzeigefenster.add(panel_TicketBearbeiten);
				Anzeigefenster.repaint();
				Anzeigefenster.revalidate();
			}
		});
		btnNewButton_5.setBounds(419, 238, 156, 39);
		panel_TicketTabelle.add(btnNewButton_5);
		
		
		btnNewButton_2 = new JButton("Ticket L\u00F6schen");
		btnNewButton_2.setBounds(419, 288, 156, 39);
		panel_TicketTabelle.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow  = table_Kunde.getSelectedRow();
				if (selectedRow >= 0) {
					tickets.remove(selectedRow);
					updateTicketTable();
				}
			}
		});

		btn_CSV_download = new JButton("CSV speichern");
		btn_CSV_download.setBounds(408, 367, 167, 48);
		btn_CSV_download.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TicketsWriter ticketWriter = new TicketsWriter("/Users/nj/Desktop/Porsche.csv");
				try {
					ticketWriter.write(tickets);
				} catch (IOException ex) {

					JOptionPane.showMessageDialog(null, ex.getMessage(),
							"Es ist ein Fehler aufgetreten", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel_TicketTabelle.add(btn_CSV_download);
		
		btnNewButton_3 = new JButton("Nach Kategorien sotieren/suchen");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(38, 288, 272, 50);
		panel_TicketTabelle.add(btnNewButton_3);
		
		textField = new JTextField();
		textField.setBounds(38, 259, 200, 26);
		panel_TicketTabelle.add(textField);
		textField.setColumns(10);
		
		btn_CSV_upload = new JButton("CSV einlesen");
		btn_CSV_upload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_CSV_upload.setBounds(169, 366, 200, 50);
		panel_TicketTabelle.add(btn_CSV_upload);
		// LL Position des Button 5 zum Speichern der Bearbeitungstabelle

		panel_TicketAnlegen = new JPanel();
		panel_TicketAnlegen.setBackground(Color.WHITE);
		panel_TicketAnlegen.setForeground(Color.BLACK);
		Anzeigefenster.add(panel_TicketAnlegen, "name_2029437332700");
		panel_TicketAnlegen.setLayout(null);

		lblNewLabel_2 = new JLabel("Ticket erstellen");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(86, 11, 191, 14);
		panel_TicketAnlegen.add(lblNewLabel_2);

		textField_KundenName = new JTextField();
		textField_KundenName.setBounds(104, 58, 96, 20);
		panel_TicketAnlegen.add(textField_KundenName);
		textField_KundenName.setColumns(10);
		// LL Eingabefeld Name

		JLabel lblNewLabel_3 = new JLabel("Name:");
		lblNewLabel_3.setBounds(10, 58, 84, 14);
		panel_TicketAnlegen.add(lblNewLabel_3);

		textField_Vorname = new JTextField();
		textField_Vorname.setBounds(104, 85, 96, 20);
		panel_TicketAnlegen.add(textField_Vorname);
		textField_Vorname.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Vorname:");
		lblNewLabel_8.setBounds(10, 85, 84, 14);
		panel_TicketAnlegen.add(lblNewLabel_8);
		
		// LL Anlegen und speichern eines Tickets durch "Speichern/Anlegen"
		btnNewButton_4 = new JButton("Speichern/Anlegen");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tickets.add(createTicketFromUI());

//			for(int i = 0, gespeichert = 0; tickets.length>i ; i++) {
//			if(tickets[i]==null && gespeichert==0) {

//				ticket.setKundenName(textField_KundenName.getText());
//				ticket.setVorname(textField_Vorname.getText());
//				ticket.setKommentar(textField_Kommentar.getText());
//				ticket.setBearbeitungsZeit(Integer.parseInt(textField_BearbeitungsZeit.getText()));	// LL Sting in ein int umwandeln
//				//arrTicket[i].setKategorie(comboBox_KategorieW�hlen.getSelectedItem().toString());
//
//				tickets[i] = createTicketFromUI();

//				gespeichert++; // LL heir l�uft eine Schleife, bis ein ArrayFled unbesetzt ist

				clearTicketFields();
				// LL Textfeld leeren
//				textField_KundenName.setText("");
//				textField_Vorname.setText("");
//				textField_Kommentar.setText("");
//				textField_BearbeitungsZeit.setText("");
				//comboBox_KategorieW�hlen.removeAllItems();

				// LL Festern zum �bersicht wechseln
				showOverview(panel_TicketTabelle);
//				Anzeigefenster.removeAll();
//				Anzeigefenster.add(panel_TicketTabelle);
//				Anzeigefenster.repaint();
//				Anzeigefenster.revalidate();
				
				updateTicketTable ();
				// Zum Aktullisieren
//				}
//			}
			}
	//kunde = new Kunde(textField_KundenName.getText(), textField_Vorname.getText(), textField_BearbeitungsZEit,getText() );
				// Hier soll/m�ssen alle Felder ausgef�llt sein ??
		
			
		});
		btnNewButton_4.setBounds(104, 273, 161, 23);
		panel_TicketAnlegen.add(btnNewButton_4);
		
		lblNewLabel_14 = new JLabel("Kateorie w\u00E4hlen:");
		lblNewLabel_14.setBounds(10, 216, 121, 14);
		panel_TicketAnlegen.add(lblNewLabel_14);
		
		comboBox_KategorieWählen = new JComboBox();
		comboBox_KategorieWählen.addItem("A");
		comboBox_KategorieWählen.addItem("B");
		comboBox_KategorieWählen.setBounds(104, 210, 200, 27);
		panel_TicketAnlegen.add(comboBox_KategorieWählen);
		
		textField_Model = new JTextField();
		textField_Model.setColumns(10);
		textField_Model.setBounds(104, 111, 96, 20);
		panel_TicketAnlegen.add(textField_Model);
		
		lblNewLabel_15 = new JLabel("Auto Model:");
		lblNewLabel_15.setBounds(10, 110, 200, 27);
		panel_TicketAnlegen.add(lblNewLabel_15);
		
		panel_TicketBearbeiten = new JPanel();
		panel_TicketBearbeiten.setBackground(Color.WHITE);
		Anzeigefenster.add(panel_TicketBearbeiten, "name_106073983523400");
		panel_TicketBearbeiten.setLayout(null);
		
		lblNewLabel_9 = new JLabel("Ticket bearbeiten ");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_9.setBounds(97, 28, 191, 14);
		panel_TicketBearbeiten.add(lblNewLabel_9);
		
		textField_change_customerName = new JTextField();
		textField_change_customerName.setColumns(10);
		textField_change_customerName.setBounds(115, 75, 96, 20);
		panel_TicketBearbeiten.add(textField_change_customerName);
		
		lblNewLabel_10 = new JLabel("Name:");
		lblNewLabel_10.setBounds(21, 75, 84, 14);
		panel_TicketBearbeiten.add(lblNewLabel_10);
		
		textField_change_Name = new JTextField();
		textField_change_Name.setColumns(10);
		textField_change_Name.setBounds(115, 102, 96, 20);
		panel_TicketBearbeiten.add(textField_change_Name);
		
		lblNewLabel_16 = new JLabel("Vorname:");
		lblNewLabel_16.setBounds(21, 102, 84, 14);
		panel_TicketBearbeiten.add(lblNewLabel_16);
		
		btn_save_update = new JButton("Bearbeitung speichern ");
		btn_save_update.setBounds(409, 202, 161, 23);
		panel_TicketBearbeiten.add(btn_save_update);
		
		lblNewLabel_17 = new JLabel("Bearbeitungszeit:");
		lblNewLabel_17.setBounds(21, 189, 108, 14);
		panel_TicketBearbeiten.add(lblNewLabel_17);
		
		textField_chance_Time = new JTextField();
		textField_chance_Time.setColumns(10);
		textField_chance_Time.setBounds(139, 186, 54, 20);
		panel_TicketBearbeiten.add(textField_chance_Time);
		
		lblNewLabel_18 = new JLabel("Stunden");
		lblNewLabel_18.setBounds(203, 188, 121, 20);
		panel_TicketBearbeiten.add(lblNewLabel_18);
		
		lblNewLabel_19 = new JLabel("Kateorie w\u00E4hlen:");
		lblNewLabel_19.setBounds(21, 233, 121, 14);
		panel_TicketBearbeiten.add(lblNewLabel_19);
		
		comboBox_KategorieAendern = new JComboBox();
		comboBox_KategorieAendern.setBounds(115, 227, 200, 27);
		panel_TicketBearbeiten.add(comboBox_KategorieAendern);
		
		textField_change_Comment = new JTextField();
		textField_change_Comment.setColumns(10);
		textField_change_Comment.setBounds(115, 133, 277, 50);
		panel_TicketBearbeiten.add(textField_change_Comment);
		
		lblNewLabel_20 = new JLabel("Kommentar:");
		lblNewLabel_20.setBounds(21, 127, 200, 27);
		panel_TicketBearbeiten.add(lblNewLabel_20);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 269, 550, 133);
		panel_TicketBearbeiten.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Nr.", "BearbeitungsZeit", "Kommentar"
			}
		));
		scrollPane_1.setViewportView(table);

		panel_KategorieBearbeiten = new JPanel();
		panel_KategorieBearbeiten.setBackground(Color.WHITE);
		Anzeigefenster.add(panel_KategorieBearbeiten, "name_1615201381600");
		panel_KategorieBearbeiten.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Was ist das Problem ?");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 26));
		lblNewLabel_1.setBounds(39, 11, 424, 94);
		panel_KategorieBearbeiten.add(lblNewLabel_1);
		

		JLabel lblNewLabel_7 = new JLabel("Kategorie anlegen:");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(39, 117, 177, 14);
		panel_KategorieBearbeiten.add(lblNewLabel_7);

		btnNewButton_6 = new JButton("Anlegen");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				kategory.add(createKategoryFromUI());
				
				clearKategoryField();
				
				
				showOverview2(panel_KategorieBearbeiten);
				updateKategoryTable ();
			}
		});
		btnNewButton_6.setBounds(134, 180, 150, 32);
		panel_KategorieBearbeiten.add(btnNewButton_6);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(334, 63, 256, 351);
		panel_KategorieBearbeiten.add(scrollPane_2);

		table_Kategorie = new JTable();
		// Kategorie[] arrKategorie = new Kategorie [30];
	//	table_Kategorie.setModel(
	//			new DefaultTableModel(
	//					new Object[][] { 
	//						{ null },{ null }, { null }, { null }, { null }, { null }, { null }, { null },
	//							{ null }, { null }, { null }, { null }, { null }, { null }, { null }, { null },
	//							{ null }, { null }, { null }, { null }, { null }, { null }, { null }, { null },
	//							{ null }, { null }, { null }, { null }, { null }, { null }, },
	//					new String[] { "Kategorien" }));
		scrollPane_2.setViewportView(table_Kategorie);

		btnNewButton_7 = new JButton("L\u00F6schen");
		btnNewButton_7.setBounds(134, 266, 150, 32);
		panel_KategorieBearbeiten.add(btnNewButton_7);
	
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow  = table_Kategorie.getSelectedRow();
				if (selectedRow >= 0) {
					kategory.remove(selectedRow);
					updateKategoryTable();
				}
			}
		});
		
		btnNewButton_8 = new JButton("Bearbeiten");
		btnNewButton_8.setBounds(134, 223, 150, 32);
		panel_KategorieBearbeiten.add(btnNewButton_8);
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.GREEN);
		textField_1.setBounds(39, 137, 245, 32);
		panel_KategorieBearbeiten.add(textField_1);
		//textField_1.setColumns(10);
		
		btnNewButton_9 = new JButton("Als CSV speichern");
		btnNewButton_9.setBounds(10, 375, 177, 39);
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KategoryWriter kategoryWriter = new KategoryWriter("/Users/nj/Desktop/Kategory.csv");
				try {
					kategoryWriter.write(kategory);
				} catch (IOException ex) {

					JOptionPane.showMessageDialog(null, ex.getMessage(),
							"Es ist ein Fehler aufgetreten", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel_KategorieBearbeiten.add(btnNewButton_9);
		
		btnNewButton_10 = new JButton("CSV hochladen");
		btnNewButton_10.setBounds(197, 375, 124, 39);
		panel_KategorieBearbeiten.add(btnNewButton_10);

		btnNewButton_1 = new JButton("Ticket anlegen");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Anzeigefenster.removeAll();
				Anzeigefenster.add(panel_TicketAnlegen);
				Anzeigefenster.repaint();
				Anzeigefenster.revalidate();	
	// LL Verlinkung vom Button zur Unterseite
			}
		
		});
		btnNewButton_1.setBounds(10, 81, 117, 23);
		contentPane.add(btnNewButton_1);

		lblNewLabel_11 = new JLabel("Bearbeiten");
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_11.setBounds(10, 188, 89, 14);
		contentPane.add(lblNewLabel_11);

		JButton btnNewButton_1_1 = new JButton("Ticket_Tabelle");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Anzeigefenster.removeAll();
				Anzeigefenster.add(panel_TicketTabelle);
				Anzeigefenster.repaint();
				Anzeigefenster.revalidate();
			}
			// LL Verlinkung zur Unterseite mit Tablle Kunden

		});
		btnNewButton_1_1.setBounds(10, 213, 129, 23);
		contentPane.add(btnNewButton_1_1);

		lblNewLabel_backround = new JLabel("Hintergrund_Werkstat");
		Image img1 = new ImageIcon(this.getClass().getResource("/Hintergrund1.jpg")).getImage();
		lblNewLabel_backround.setIcon(new ImageIcon(img1));
		lblNewLabel_backround.setBounds(0, 0, 1048, 557);
		contentPane.add(lblNewLabel_backround) ;

	}

	private static class __Tmp {
		private static void __tmp() {
			JPanel __wbp_panel = new JPanel();
		}
	}
}
