package windowBuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import javax.swing.BoxLayout;
import javax.swing.JDesktopPane;
import java.awt.GridLayout;
import java.awt.Panel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import java.awt.ComponentOrientation;
import java.awt.Color;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.Box;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.List;
import java.awt.Choice;
import java.awt.SystemColor;
import java.awt.CardLayout;

public class window extends JFrame {

	private JPanel contentPane;
	private JTable table;


	/**
	 * Create the frame.
	 */
	public window() 
	{
		
		String column[]={"ID","NAME","SALARY"};     
		
		   String data[][]={ {"101","Amit","670000"},    
          {"102","Jai","780000"},    
          {"101","Sachin","700000"}}; 
		
		
		setTitle("Spritpreise");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setBackground(Color.RED);
		contentPanel.setBounds(190, 97, 994, 464);
		contentPanel.setLayout(new CardLayout(0, 0));
		
		JPanel alertsPane = new JPanel();
		alertsPane.setBackground(Color.RED);
		
		
		
		JPanel locationBackground = new JPanel();
		locationBackground.setBackground(Color.DARK_GRAY);
		locationBackground.setBounds(0, 0, 200, 98);
		contentPane.add(locationBackground);
		locationBackground.setLayout(null);
		
		JLabel locationDisplay = new JLabel("Location", SwingConstants.CENTER);
		locationDisplay.setBounds(0, 0, 200, 98);
		locationBackground.add(locationDisplay);
		locationDisplay.setForeground(new Color(255, 255, 255));
		locationDisplay.setBackground(Color.DARK_GRAY);
		locationDisplay.setFont(new Font("Verdana", Font.BOLD, 15));
		
		JPanel head = new JPanel();
		head.setBackground(new Color(105, 105, 105));
		head.setBounds(192, 0, 992, 98);
		contentPane.add(head);
		head.setLayout(null);
		
		
		JTable table_1 = new JTable(data,column);
		table_1.setBounds(116, 173, 876, 386);
		head.add(table_1);
		table_1.setFont(new Font("Verdana", Font.BOLD, 15));
		table_1.setBackground(Color.WHITE);
		table_1.setSurrendersFocusOnKeystroke(true);
		table_1.setTableHeader(null);
		table_1.getTableHeader();
		
		JLabel hyperlinkMaps = new JLabel("Nach Maps");
		hyperlinkMaps.setToolTipText("Auf Google Maps anschauen");
		hyperlinkMaps.setBackground(new Color(255, 255, 255));
		hyperlinkMaps.setBounds(809, 33, 111, 28);
		head.add(hyperlinkMaps);
		
		JComboBox auswahlSpritArt = new JComboBox();
		auswahlSpritArt.setBounds(632, 32, 111, 28);
		auswahlSpritArt.setBackground(new Color(255, 255, 255));
		auswahlSpritArt.setFont(new Font("Verdana", Font.PLAIN, 11));
		auswahlSpritArt.setName("");
		head.add(auswahlSpritArt);
		
		JComboBox auswahlRadius = new JComboBox();
		auswahlRadius.setBounds(455, 32, 111, 28);
		auswahlRadius.setName("");
		auswahlRadius.setFont(new Font("Verdana", Font.PLAIN, 11));
		auswahlRadius.setBackground(new Color(255, 255, 255));
		head.add(auswahlRadius);
		
		JTextPane eingabeStadt = new JTextPane();
		eingabeStadt.setFont(new Font("Verdana", Font.PLAIN, 15));
		eingabeStadt.setBounds(59, 32, 328, 28);
		eingabeStadt.setDisabledTextColor(new Color(255, 255, 255));
		eingabeStadt.setBackground(new Color(255, 255, 255));
		head.add(eingabeStadt);
		
		
		JPanel sidebar = new JPanel();
		sidebar.setBackground(new Color(169, 169, 169));
		sidebar.setBounds(0, 97, 200, 464);
		contentPane.add(sidebar);
		sidebar.setLayout(null);
		
		JLabel dateLabel = new JLabel("Datum");
		dateLabel.setFont(new Font("Verdana", Font.PLAIN, 11));
		dateLabel.setBounds(10, 439, 46, 14);
		sidebar.add(dateLabel);
		
		JLabel timeLabel = new JLabel("Uhrzeit");
		timeLabel.setFont(new Font("Verdana", Font.PLAIN, 11));
		timeLabel.setBounds(144, 439, 46, 14);
		sidebar.add(timeLabel);
		
		Button homeButton = new Button("Home");
		homeButton.setFont(new Font("Verdana", Font.BOLD, 12));
		homeButton.setBounds(51, 54, 97, 22);
		sidebar.add(homeButton);
		
		Button alertButton = new Button("Alerts");
		alertButton.setFont(new Font("Verdana", Font.BOLD, 12));
		alertButton.setBounds(51, 141, 97, 22);
		sidebar.add(alertButton);
		
		Button settingsButton = new Button("Settings");
		settingsButton.setFont(new Font("Verdana", Font.BOLD, 12));
		settingsButton.setBounds(51, 230, 97, 22);
		sidebar.add(settingsButton,"1");
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.CYAN);
		mainPanel.setBounds(192, 97, 992, 464);
		contentPane.add(mainPanel);
		mainPanel.setLayout(null);
		
		JPanel settingsPanel = new JPanel();
		settingsPanel.setBounds(0, 0, 992, 464);
		mainPanel.add(settingsPanel);
		settingsPanel.setBackground(Color.RED);
		
		JPanel homePanel = new JPanel();
		homePanel.setBounds(0, 0, 992, 464);
		homePanel.setBackground(Color.MAGENTA);
		mainPanel.add(homePanel);
		
		JPanel alertsPanel = new JPanel();
		alertsPanel.setBackground(Color.BLUE);
		alertsPanel.setBounds(0, 0, 992, 464);
		mainPanel.add(alertsPanel);
		
		
		homeButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("homeButton");
				settingsPanel.setVisible(false);
				alertsPanel.setVisible(false);
				homePanel.setVisible(true);
			}
		});
		
		alertButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("Alert");
				mainPanel.setVisible(false);
				settingsPanel.setVisible(false);
				alertsPanel.setVisible(true);
			}
		});
		
		settingsButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("SettingsButton");
				mainPanel.setVisible(false);
				alertsPanel.setVisible(false);
				settingsPanel.setVisible(true);
			}
		});
		
		//setLayout(new FlowLayout());
		
	}
}
