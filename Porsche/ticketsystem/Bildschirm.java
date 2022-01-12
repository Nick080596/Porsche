package ticketsystem;

import java.awt.BorderLayout; //Das hier ist in meinem Code, alles danach (bis nächstes Texfeld) nicht

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
// Bis hierhin.

public class Bildschirm extends JFrame {
	private JLayeredPane Anzeigefenster;
	private JPanel panel_Ticket;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JTextField textField_KundenName;
	private JPanel panel_Kategorie;
	private JPanel panel_Startbildschirm;
	private JLabel lblNewLabel_6;
	private JTextField textField;
	private JLabel lblNewLabel_9;
	private JTextField textField_1;
	private JLabel lblNewLabel_10;
	private JTextField textField_2;
	private JPanel panel_Kunde;
	private JLabel lblNewLabel_11;
	private JButton btnNewButton_4;
	public Kunde kunde;
	private JTable table;
	private JScrollPane scrollPane;

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
		lblNewLabel.setFont(new Font("BankGothic Md BT", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 29, 89, 14);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("Ticket");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Anzeigefenster.removeAll();
				Anzeigefenster.add(panel_Ticket);
				Anzeigefenster.repaint();
				Anzeigefenster.revalidate();}
			// LL Verlinkung vom Button zur Unterseite 
			
		});
		btnNewButton.setBounds(10, 100, 89, 23);
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
		lblNewLabel_5.setBounds(92, 48, 185, 114);
		panel_Startbildschirm.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel(" Ticketsystem");
		lblNewLabel_6.setFont(new Font("Bahnschrift", Font.PLAIN, 23));
		lblNewLabel_6.setBounds(105, 134, 221, 64);
		panel_Startbildschirm.add(lblNewLabel_6);
		
		panel_Kategorie = new JPanel();
		panel_Kategorie.setBackground(Color.WHITE);
		Anzeigefenster.add(panel_Kategorie, "name_6848962272100");
		panel_Kategorie.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Kategorie");
		lblNewLabel_4.setBounds(158, 11, 74, 14);
		panel_Kategorie.add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(71, 71, 196, 22);
		panel_Kategorie.add(comboBox);
		
		JPanel panel_TicketBearbeiten = new JPanel();
		Anzeigefenster.setLayer(panel_TicketBearbeiten, 5);
		panel_TicketBearbeiten.setBackground(Color.WHITE);
		Anzeigefenster.add(panel_TicketBearbeiten, "name_92370989658200");
		panel_TicketBearbeiten.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 63, 491, 274);
		panel_TicketBearbeiten.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Nr", "Name", "Vorname", "Kunden Nr"
			}
		));
		
		
		panel_Kunde = new JPanel();
		panel_Kunde.setBackground(Color.WHITE);
		panel_Kunde.setForeground(Color.BLACK);
		Anzeigefenster.add(panel_Kunde, "name_2029437332700");
		panel_Kunde.setLayout(null);
		
		lblNewLabel_2 = new JLabel("Kunde");
		lblNewLabel_2.setBounds(159, 11, 48, 14);
		panel_Kunde.add(lblNewLabel_2);
		
		textField_KundenName = new JTextField();
		textField_KundenName.setBounds(104, 58, 96, 20);
		panel_Kunde.add(textField_KundenName);
		textField_KundenName.setColumns(10);
		// LL Eingabefeld Name
		 
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setBounds(10, 58, 84, 14);
		panel_Kunde.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(104, 85, 96, 20);
		panel_Kunde.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Vorname");
		lblNewLabel_8.setBounds(10, 85, 84, 14);
		panel_Kunde.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Kunden Nr:");
		lblNewLabel_9.setBounds(10, 116, 84, 14);
		panel_Kunde.add(lblNewLabel_9);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(104, 116, 96, 20);
		panel_Kunde.add(textField_1);
		
		lblNewLabel_10 = new JLabel("Ticket Nr.:");
		lblNewLabel_10.setBounds(10, 144, 84, 14);
		panel_Kunde.add(lblNewLabel_10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(104, 144, 96, 20);
		panel_Kunde.add(textField_2);
		
		btnNewButton_4 = new JButton("Speichern");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 kunde = new Kunde(textField_KundenName.getText(), textField.getText(), textField_1.getText(), textField_2.getText());
			     
			}
		});
		btnNewButton_4.setBounds(111, 237, 89, 23);
		panel_Kunde.add(btnNewButton_4);
		
		
		
		panel_Ticket = new JPanel();
		panel_Ticket.setBackground(Color.WHITE);
		Anzeigefenster.add(panel_Ticket, "name_1615201381600");
		panel_Ticket.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Was ist Ihr Problem ?");
		lblNewLabel_1.setBounds(143, 11, 148, 14);
		panel_Ticket.add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(71, 164, 257, 99);
		textArea.setBackground(new Color(192, 192, 192));
		panel_Ticket.add(textArea);
		
		JLabel lblNewLabel_7 = new JLabel("Kommentar :");
		lblNewLabel_7.setBounds(71, 151, 111, 14);
		panel_Ticket.add(lblNewLabel_7);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Problem 1");
		rdbtnNewRadioButton.setBounds(71, 39, 220, 23);
		panel_Ticket.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Problem 2");
		rdbtnNewRadioButton_1.setBounds(71, 65, 220, 23);
		panel_Ticket.add(rdbtnNewRadioButton_1);
		
		btnNewButton_1 = new JButton("Kunde");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Anzeigefenster.removeAll();
				Anzeigefenster.add(panel_Kunde);
				Anzeigefenster.repaint();
				Anzeigefenster.revalidate();}
				// LL Verlinkung vom Button zur Unterseite 
		});
		btnNewButton_1.setBounds(10, 66, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Kategorie");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Anzeigefenster.removeAll();
				Anzeigefenster.add(panel_Kategorie);
				Anzeigefenster.repaint();
				Anzeigefenster.revalidate();}
			// LL Verlinkung vom Button zur Unterseite (Metoden)
			
		});
		btnNewButton_2.setBounds(10, 281, 89, 23);
		contentPane.add(btnNewButton_2);
		
		lblNewLabel_11 = new JLabel("Bearbeiten");
		lblNewLabel_11.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_11.setBounds(10, 188, 89, 14);
		contentPane.add(lblNewLabel_11);
		
		JButton btnNewButton_1_1 = new JButton("Kunde");
		btnNewButton_1_1.setBounds(10, 213, 89, 23);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_3 = new JButton("Ticket");
		btnNewButton_3.setBounds(10, 247, 89, 23);
		contentPane.add(btnNewButton_3);
		
	
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
