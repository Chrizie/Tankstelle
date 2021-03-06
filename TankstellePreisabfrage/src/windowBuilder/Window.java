package windowBuilder;

import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableColumnModel;

import function.APIBeans;
import function.Main;
import function.SucheDB;

import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
//import javax.swing.SwingUtilities;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.BooleanControl;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
//import javax.swing.JWindow;
import javax.swing.JCheckBox;
import javax.swing.JSlider;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
//import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
//import java.time.LocalDate;
import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.CardLayout;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
//import java.util.Set;
//import java.util.function.IntPredicate;
//import java.util.logging.SimpleFormatter;
import java.awt.Dimension;
//import javax.swing.JPopupMenu;
//import java.awt.Component;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;

public class Window extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	Clip clip;
	boolean pirateAudio;
	Main main;
	APIBeans beans;
	
	public Window() throws Exception 
	{
		main = new Main("",0,0);
		beans = new APIBeans();
		String column[]={"ID","NAME","SALARY","test","test"};     
		SucheDB db = new SucheDB("", 0, 0);
		   
		ArrayList<SucheDB> townList = db.getLatLngFromDB();
		
		JPanel contentPane = new JPanel();
		setTitle("Spritpreise");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
			JPanel contentPanel = new JPanel();
			contentPanel.setBackground(Color.RED);
			contentPanel.setBounds(190, 97, 994, 464);
			contentPanel.setLayout(new CardLayout(0, 0));
					
						
							//---------- Home ----------
							JPanel homePanel = new JPanel();
							homePanel.setMinimumSize(new Dimension(32767, 32767));
							homePanel.setVerifyInputWhenFocusTarget(false);
							homePanel.setFocusable(false);
							homePanel.setBackground(SystemColor.activeCaption);
							homePanel.setBounds(199, 97, 985, 464);
							contentPane.add(homePanel);
							homePanel.setLayout(null);
							
						
							
							
							
							
					JPanel piratePanel = new JPanel();
					piratePanel.setBackground(SystemColor.activeCaption);
					piratePanel.setBounds(199, 97, 985, 464);
					piratePanel.setVisible(false);
					contentPane.add(piratePanel);
					piratePanel.setLayout(null);
					
					JLabel pirate = new JLabel(new ImageIcon("assets/pirate-dance.gif"));
					pirate.setBounds(284, 61, 361, 334);
					piratePanel.add(pirate);
					//---------- Create New alert ENDE ----------
					
						
					//---------- Settings ----------
					JPanel settingsPanel = new JPanel();
					settingsPanel.setBackground(SystemColor.activeCaption);
					settingsPanel.setBounds(199, 97, 985, 464);
					contentPane.add(settingsPanel);
					settingsPanel.setLayout(null);
					
						JLabel lblNewLabel = new JLabel("Beim hochfahren starten");
						lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 13));
						lblNewLabel.setBounds(10, 11, 219, 33);
						settingsPanel.add(lblNewLabel);
						
						
							JCheckBox autostartCheckbox = new JCheckBox("");
							autostartCheckbox.setBackground(SystemColor.activeCaption);
							autostartCheckbox.setBounds(213, 18, 21, 23);
							settingsPanel.add(autostartCheckbox);
							
								JLabel lblNewLabel_1 = new JLabel("Lautst\u00E4rke der Alerts");
								lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 13));
								lblNewLabel_1.setBounds(10, 67, 189, 23);
								settingsPanel.add(lblNewLabel_1);
								
								JSlider lautst?rkeSlider = new JSlider();
								lautst?rkeSlider.setBackground(SystemColor.activeCaption);
								lautst?rkeSlider.setBounds(213, 64, 200, 26);
								settingsPanel.add(lautst?rkeSlider);
								
									JLabel alertTonAuswahl = new JLabel("Auswahl des alert sounds");
									alertTonAuswahl.setFont(new Font("Verdana", Font.BOLD, 13));
									alertTonAuswahl.setBounds(10, 119, 189, 33);
									settingsPanel.add(alertTonAuswahl);
									
									JComboBox<String> alertTonAuswahlcomboBox = new JComboBox<String>();
									alertTonAuswahlcomboBox.setBackground(SystemColor.window);
									alertTonAuswahlcomboBox.setBounds(213, 126, 200, 22);
									settingsPanel.add(alertTonAuswahlcomboBox);
									
									JButton piratenKnopf = new JButton("Piratenknopf");
									piratenKnopf.setBounds(774, 386, 139, 23);
									settingsPanel.add(piratenKnopf);
						
				//---------- Home ENDE ----------
				
					
				//---------- Alerts ----------
				JPanel alertsPanel = new JPanel();
				alertsPanel.setBackground(SystemColor.activeCaption);
				alertsPanel.setBounds(199, 97, 985, 464);
				contentPane.add(alertsPanel);
				
					//DefaultTableModel modelAlerts = new DefaultTableModel(null, 5);
					JTable 	alertsTable = new JTable();
					alertsTable.setBackground(SystemColor.activeCaption);
					alertsTable.setFont(new Font("Tahoma", Font.BOLD, 16));
					alertsTable.setBounds(10, 63, 965, 390);
					alertsTable.setVisible(true);
					alertsPanel.setLayout(null);
					alertsTable.setShowGrid(false);
					alertsPanel.add(alertsTable);
					
						JLabel checkBoxAlert = new JLabel("Alerts einschalten");
						checkBoxAlert.setFont(new Font("Verdana", Font.BOLD, 13));
						checkBoxAlert.setBounds(21, 22, 131, 17);
						alertsPanel.add(checkBoxAlert);
						
						JCheckBox alertEinschaltenCheckbox = new JCheckBox("");
						alertEinschaltenCheckbox.setBackground(SystemColor.activeCaption);
						alertEinschaltenCheckbox.setBounds(201, 18, 21, 21);
						alertsPanel.add(alertEinschaltenCheckbox);
						
						JButton neuenAlertButton = new JButton("Neuen Alert erstellen");
						neuenAlertButton.setBounds(622, 17, 133, 23);
						alertsPanel.add(neuenAlertButton);
						
					

			
				//---------- Display Links oben ----------
				JPanel locationBackground = new JPanel();
				locationBackground.setBackground(SystemColor.windowBorder);
				locationBackground.setBounds(0, 0, 200, 98);
				contentPane.add(locationBackground);
				locationBackground.setLayout(null);
				
					JLabel locationDisplay = new JLabel("Location", SwingConstants.CENTER);
					locationDisplay.setBounds(0, 0, 200, 98);
					locationBackground.add(locationDisplay);
					locationDisplay.setForeground(new Color(255, 255, 255));
					locationDisplay.setBackground(SystemColor.windowBorder);
					locationDisplay.setFont(new Font("Verdana", Font.BOLD, 15));
				//---------- Display Links oben ENDE ----------
				
					
				//---------- Head ----------
				JPanel head = new JPanel();
				head.setBackground(SystemColor.activeCaptionBorder);
				head.setBounds(192, 0, 992, 98);
				contentPane.add(head);
				head.setLayout(null);
				
					JLabel lblNewLabel_4 = new JLabel("Ortseingabe");
					lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD, 12));
					lblNewLabel_4.setBounds(59, 11, 98, 14);
					head.add(lblNewLabel_4);
				
					JTextPane eingabeStadt = new JTextPane();
					eingabeStadt.setFont(new Font("Verdana", Font.PLAIN, 15));
					eingabeStadt.setBounds(59, 32, 328, 28);
					eingabeStadt.setDisabledTextColor(new Color(255, 255, 255));
					eingabeStadt.setBackground(new Color(255, 255, 255));
					eingabeStadt.addInputMethodListener(null);
					head.add(eingabeStadt);
					
					/** TODO
					 * Read input in Textfield 
					 * add the elements from ArrayList where that contains the town String
					 * if clicked, add name to textfield
					 * get lat and lng to the city from DB
					 */
					
					
					JComboBox<String> autocompletePopup = new JComboBox<String>();
					autocompletePopup.setBounds(59, 59, 328, 28);
					
					eingabeStadt.getDocument().addDocumentListener(new DocumentListener() 
					{
						  public void changedUpdate(DocumentEvent e) 
						  {
						    try {
								warn();
							} catch (HeadlessException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						  }
						  public void removeUpdate(DocumentEvent e) 
						  {
						    try {
								warn();
							} catch (HeadlessException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						  }
						  public void insertUpdate(DocumentEvent e) 
						  {
						    try {
								warn();
							} catch (HeadlessException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						  }

						  public void warn() throws HeadlessException, Exception 
						  {
							  String selectedText;
							  for(int i = 0; i < townList.size(); i++)
								{
								  //TODO St?nde sind in der DB gro?geschrieben, "ALZENAU"
								  	selectedText = eingabeStadt.getText();
								  	System.out.println(townList.get(i));
									if(townList.get(i).toString().equals(selectedText))
									{
										autocompletePopup.addItem(selectedText);
										List<SucheDB> latlng = db.getLatLngFromDBByTown(selectedText);
										System.out.println(latlng.get(0).toString());
										//TODO Probleme lat und lng aus der DB zu bekommen 
										//System.out.println(beans.setLat(latlng.get(1)));
										//System.out.println(latlng.get(2));
										
									}
								}
						  }
						});
					
					
//					for(int i = 0; i < db.getLatLngFromDB().size(); i++)
//					{
//						if(db.getLatLngFromDB().get(i).equals(selectedText))
//						{
//							autocompletePopup.addItem(db.getLatLngFromDB().get(i));
//						}
//					}
					
					
					
					
					
					
//					autocompletePopup.getPopupMenuListeners();
//					autocompletePopup.addPopupMenuListener(null);
					
					autocompletePopup.setVisible(true);
					head.add(autocompletePopup);
					
					JLabel lblNewLabel_5 = new JLabel("Treibstoff");
					lblNewLabel_5.setFont(new Font("Verdana", Font.BOLD, 12));
					lblNewLabel_5.setBounds(632, 11, 66, 14);
					head.add(lblNewLabel_5);
					
					JComboBox<String> auswahlSpritArt = new JComboBox<String>();
					auswahlSpritArt.setBounds(632, 32, 111, 28);
					auswahlSpritArt.setBackground(new Color(255, 255, 255));
					auswahlSpritArt.setFont(new Font("Verdana", Font.BOLD, 11));
					auswahlSpritArt.addItem("e5");
					auswahlSpritArt.addItem("e10");
					auswahlSpritArt.addItem("diesel");
					head.add(auswahlSpritArt);
					
					JLabel lblNewLabel_6 = new JLabel("Umkreis");
					lblNewLabel_6.setFont(new Font("Verdana", Font.BOLD, 12));
					lblNewLabel_6.setBounds(455, 11, 71, 14);
					head.add(lblNewLabel_6);
					
					JComboBox<String> auswahlRadius = new JComboBox<String>();
					auswahlRadius.setBounds(455, 32, 111, 28);
					auswahlRadius.addItem("5");
					auswahlRadius.addItem("10");
					auswahlRadius.addItem("25");
					auswahlRadius.setFont(new Font("Verdana", Font.BOLD, 11));
					auswahlRadius.setBackground(new Color(255, 255, 255));
					head.add(auswahlRadius);
					
					Button suchenButton = new Button("Suche");
					suchenButton.setActionCommand("Suche");
					suchenButton.setFont(new Font("Verdana", Font.BOLD, 12));
					suchenButton.setBounds(817, 32, 97, 28);
					head.add(suchenButton);
					
				//---------- Head ENDE ----------
				
					
				//---------- Sidebar ----------
				JPanel sidebar = new JPanel();
				sidebar.setBackground(SystemColor.activeCaptionBorder);
				sidebar.setBounds(0, 97, 200, 464);
				contentPane.add(sidebar);
				sidebar.setLayout(null);

				
							//---------- Create New Alert ----------
							JPanel createNewAlertPanel = new JPanel();
							createNewAlertPanel.setBackground(SystemColor.activeCaption);
							createNewAlertPanel.setBounds(199, 97, 985, 464);
							contentPane.add(createNewAlertPanel);
							createNewAlertPanel.setLayout(null);
						
								JLabel lblNewLabel_2 = new JLabel("Ortseingabe");
								lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 13));
								lblNewLabel_2.setBounds(10, 11, 148, 42);
								createNewAlertPanel.add(lblNewLabel_2);
								
								JTextPane eingabeStadtCreateAlert = new JTextPane();
								eingabeStadtCreateAlert.setFont(new Font("Verdana", Font.PLAIN, 15));
								eingabeStadtCreateAlert.setDisabledTextColor(Color.WHITE);
								eingabeStadtCreateAlert.setBackground(Color.WHITE);
								eingabeStadtCreateAlert.setBounds(10, 56, 328, 28);
								createNewAlertPanel.add(eingabeStadtCreateAlert);
								
								JLabel lblNewLabel_3 = new JLabel("Ab wieviel \u20AC/L");
								lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 13));
								lblNewLabel_3.setBounds(10, 110, 148, 28);
								createNewAlertPanel.add(lblNewLabel_3);
								
								JTextPane setPriceCreateAlert = new JTextPane();
								setPriceCreateAlert.setFont(new Font("Verdana", Font.PLAIN, 15));
								setPriceCreateAlert.setDisabledTextColor(Color.WHITE);
								setPriceCreateAlert.setBackground(Color.WHITE);
								setPriceCreateAlert.setBounds(10, 149, 142, 28);
								createNewAlertPanel.add(setPriceCreateAlert);
								
								
								JLabel lblNewLabel_3_1 = new JLabel("Umkreis");
								lblNewLabel_3_1.setFont(new Font("Verdana", Font.BOLD, 13));
								lblNewLabel_3_1.setBounds(10, 199, 148, 28);
								createNewAlertPanel.add(lblNewLabel_3_1);
								
								JComboBox<String> auswahlRadiusCreateAlert = new JComboBox<String>();
								auswahlRadiusCreateAlert.setName("");
								auswahlRadiusCreateAlert.setFont(new Font("Verdana", Font.PLAIN, 11));
								auswahlRadiusCreateAlert.setBackground(Color.WHITE);
								auswahlRadiusCreateAlert.setBounds(10, 238, 84, 28);
								createNewAlertPanel.add(auswahlRadiusCreateAlert);
								
								JLabel lblNewLabel_3_1_1 = new JLabel("Treibstoff Art");
								lblNewLabel_3_1_1.setFont(new Font("Verdana", Font.BOLD, 13));
								lblNewLabel_3_1_1.setBounds(10, 284, 148, 28);
								createNewAlertPanel.add(lblNewLabel_3_1_1);
								
								JComboBox<String> auswahlTreibstoffCreateAlert = new JComboBox<String>();
								auswahlTreibstoffCreateAlert.setName("");
								auswahlTreibstoffCreateAlert.setFont(new Font("Verdana", Font.PLAIN, 11));
								auswahlTreibstoffCreateAlert.setBackground(Color.WHITE);
								auswahlTreibstoffCreateAlert.setBounds(10, 323, 84, 28);
								createNewAlertPanel.add(auswahlTreibstoffCreateAlert);
					//---------- Settings ENDE ----------
					
					Date today = Calendar.getInstance().getTime();
					SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("dd.MM.yyyy");
					JLabel dateLabel = new JLabel(dateTimeFormatter.format(today));
					dateLabel.setFont(new Font("Verdana", Font.PLAIN, 11));
					dateLabel.setBounds(10, 439, 87, 14);
					sidebar.add(dateLabel);
					
					LocalTime zeit = LocalTime.now();
					System.out.println(zeit);
					JLabel timeLabel = new JLabel(zeit.getHour()+":"+zeit.getMinute());
					timeLabel.setFont(new Font("Verdana", Font.PLAIN, 11));
					timeLabel.setBounds(146, 439, 44, 14);
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
					//---------- Sidebar ENDE ----------
					
					//---------- Button actions ----------
					homeButton.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent e) 
						{
							createNewAlertPanel.setVisible(false);
							settingsPanel.setVisible(false);
							alertsPanel.setVisible(false);
							piratePanel.setVisible(false);
							homePanel.setVisible(true);
							if(pirateAudio == true){stopAudio();}
						}
					});
					
					neuenAlertButton.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent e) 
						{
							homePanel.setVisible(false);
							alertsPanel.setVisible(false);
							settingsPanel.setVisible(false);
							piratePanel.setVisible(false);
							createNewAlertPanel.setVisible(true);
							if(pirateAudio == true){stopAudio();}
							
						}
					});
					alertButton.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent e) 
						{
							createNewAlertPanel.setVisible(false);
							homePanel.setVisible(false);
							piratePanel.setVisible(false);
							settingsPanel.setVisible(false);
							alertsPanel.setVisible(true);
							if(pirateAudio == true){stopAudio();}
						}
					});
					
					settingsButton.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent e) 
						{
							createNewAlertPanel.setVisible(false);
							piratePanel.setVisible(false);
							homePanel.setVisible(false);
							alertsPanel.setVisible(false);
							settingsPanel.setVisible(true);
							if(pirateAudio == true){stopAudio();}
							
							
						}
					});
					
					piratenKnopf.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent e) 
						{
							pirateAudio = true;
							createNewAlertPanel.setVisible(false);
							homePanel.setVisible(false);
							alertsPanel.setVisible(false);
							settingsPanel.setVisible(false);
							piratePanel.setVisible(true);
							startAudio();
						}
					});
					
					suchenButton.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent e) 
						{
							try 
							{
								String sprit = (String) auswahlSpritArt.getSelectedItem();
								String radius = (String) auswahlRadius.getSelectedItem();
								
								//System.out.println(latlng);
								
								main.setData(sprit,radius);
								main.getData();
								
								DefaultTableModel model = new DefaultTableModel(main.parse(), column);
								JTable ausgabeTabelle = new JTable(model);
								ausgabeTabelle.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
								ausgabeTabelle.getColumnModel().getColumn(0).setPreferredWidth(250);
								ausgabeTabelle.setDefaultEditor(Object.class, null);
								ausgabeTabelle.setSelectionBackground(SystemColor.textHighlight);
								ausgabeTabelle.setAutoCreateRowSorter(true);
								ausgabeTabelle.setShowGrid(false);
								ausgabeTabelle.setFont(new Font("Tahoma", Font.BOLD, 13));
								ausgabeTabelle.setBackground(SystemColor.activeCaption);
								ausgabeTabelle.setBounds(10, 11, 965, 442);
								homePanel.add(ausgabeTabelle);
								TableModelEvent tableModelEvent = new TableModelEvent(model);
								model.fireTableChanged(tableModelEvent);
							}
							catch (IOException e1) 
							{
								e1.printStackTrace();
							}
							
						}
					});
					//---------- Button Actions ENDE ----------
	}
	
	public void audio()
	{
		try
		{
			File audio = new File("assets/Sea_Shanty_2.wav");
			AudioInputStream audioStream;
			audioStream = AudioSystem.getAudioInputStream(audio);
			clip = AudioSystem.getClip();
			clip.open(audioStream);
			FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			volume.setValue(-13);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		}
 		catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) 
 		{
			e.printStackTrace();
		}
	}
	
	public void startAudio()
	{
		audio();
		clip.start();
	}
	
	public void stopAudio() 
	{
		BooleanControl muteControl = (BooleanControl) clip.getControl(BooleanControl.Type.MUTE);
		if(muteControl != null)
		{
		    muteControl.setValue(true);
		    clip.loop(0);
			clip.flush();
		}
	}
/*	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
*/
	
}

