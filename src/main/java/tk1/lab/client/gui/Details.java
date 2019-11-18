package tk1.lab.client.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import tk1.lab.server.model.Flight;
import tk1.lab.server.model.FlightStatus;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.Window.Type;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Details {

	private JFrame frmFlightDetails;
	private JTextField textField;
	private JTextField txtAsd;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField txtt;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	String aircraftType = null;
	FlightStatus status = null;
	String IATACode = null;
	String airlineName = null;
	int flightNumber;
	
	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Details window = new Details();
					window.frmFlightDetails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Details() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Flight f = new Flight();
		frmFlightDetails = new JFrame();
		frmFlightDetails.setTitle("Flight Details");
		frmFlightDetails.setBounds(100, 100, 529, 412);
		frmFlightDetails.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmFlightDetails.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}
			public void inputMethodTextChanged(InputMethodEvent arg0) {
				IATACode = f.getIATACode();
			}
		});
		textField.setBounds(126, 14, 130, 14);
		frmFlightDetails.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("IATA Code:");
		lblNewLabel.setLabelFor(textField);
		lblNewLabel.setBounds(10, 14, 62, 14);
		frmFlightDetails.getContentPane().add(lblNewLabel);
		
		txtAsd = new JTextField();
		txtAsd.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
				aircraftType = f.getAircraftType();
			}
		});
		txtAsd.setText("asd.66441TK");
		txtAsd.setBounds(126, 39, 130, 14);
		frmFlightDetails.getContentPane().add(txtAsd);
		txtAsd.setColumns(10);
		
		JLabel lblAircraftModel = new JLabel("Aircraft Model:");
		lblAircraftModel.setLabelFor(txtAsd);
		lblAircraftModel.setBounds(10, 39, 76, 14);
		frmFlightDetails.getContentPane().add(lblAircraftModel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(126, 64, 130, 14);
		frmFlightDetails.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTrackingNumber = new JLabel("Tracking Number:");
		lblTrackingNumber.setLabelFor(textField_2);
		lblTrackingNumber.setBounds(10, 64, 95, 14);
		frmFlightDetails.getContentPane().add(lblTrackingNumber);
		
		textField_1 = new JTextField();
		textField_1.setBounds(126, 89, 130, 14);
		frmFlightDetails.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
				
				f.getOriginDate();
			}
		});
		textField_3.setBounds(126, 114, 130, 14);
		frmFlightDetails.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		txtt = new JTextField();
		txtt.setText("2018-10-09T15:25:00");
		txtt.setColumns(10);
		txtt.setBounds(126, 139, 130, 14);
		frmFlightDetails.getContentPane().add(txtt);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(126, 164, 130, 14);
		frmFlightDetails.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(126, 189, 130, 14);
		frmFlightDetails.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(126, 214, 130, 14);
		frmFlightDetails.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(126, 239, 130, 14);
		frmFlightDetails.getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(126, 264, 130, 14);
		frmFlightDetails.getContentPane().add(textField_9);
		
		JLabel lblDepartureAirport = new JLabel("Departure Airport:");
		lblDepartureAirport.setLabelFor(textField_1);
		lblDepartureAirport.setBounds(10, 89, 95, 14);
		frmFlightDetails.getContentPane().add(lblDepartureAirport);
		
		JLabel lblOriginDate = new JLabel("Origin Date:");
		lblOriginDate.setLabelFor(textField_3);
		lblOriginDate.setBounds(10, 114, 95, 14);
		frmFlightDetails.getContentPane().add(lblOriginDate);
		
		JLabel lblScheduledDeparture = new JLabel("Scheduled Departure:");
		lblScheduledDeparture.setLabelFor(txtt);
		lblScheduledDeparture.setBounds(10, 139, 110, 14);
		frmFlightDetails.getContentPane().add(lblScheduledDeparture);
		
		JLabel lblDepartureTerminal = new JLabel("Departure Terminal:");
		lblDepartureTerminal.setLabelFor(textField_5);
		lblDepartureTerminal.setBounds(10, 164, 110, 14);
		frmFlightDetails.getContentPane().add(lblDepartureTerminal);
		
		JLabel lblDepartureGates = new JLabel("Departure Gates:");
		lblDepartureGates.setLabelFor(textField_6);
		lblDepartureGates.setBounds(10, 189, 95, 14);
		frmFlightDetails.getContentPane().add(lblDepartureGates);
		
		JLabel lblEstimatedDeparture = new JLabel("Estimated Departure:");
		lblEstimatedDeparture.setLabelFor(textField_7);
		lblEstimatedDeparture.setBounds(10, 214, 95, 14);
		frmFlightDetails.getContentPane().add(lblEstimatedDeparture);
		
		JLabel lblCheckinLocation = new JLabel("Check-in Location:");
		lblCheckinLocation.setLabelFor(textField_8);
		lblCheckinLocation.setBounds(10, 239, 95, 14);
		frmFlightDetails.getContentPane().add(lblCheckinLocation);
		
		JLabel lblCheckinCounter = new JLabel("Check-in Counter:");
		lblCheckinCounter.setLabelFor(textField_9);
		lblCheckinCounter.setBounds(10, 264, 95, 14);
		frmFlightDetails.getContentPane().add(lblCheckinCounter);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(126, 289, 130, 14);
		frmFlightDetails.getContentPane().add(textField_10);
		
		JLabel lblCheckinStart = new JLabel("Check-in Start:");
		lblCheckinStart.setLabelFor(textField_10);
		lblCheckinStart.setBounds(10, 289, 95, 14);
		frmFlightDetails.getContentPane().add(lblCheckinStart);
		
		JLabel lblFlightStatus = new JLabel("Flight Status:");
		lblFlightStatus.setBounds(10, 314, 95, 14);
		frmFlightDetails.getContentPane().add(lblFlightStatus);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				status = f.getStatus();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Landed", "Not Landed"}));
		comboBox.setBounds(126, 314, 380, 23);
		frmFlightDetails.getContentPane().add(comboBox);
		
		JLabel lblOperatingAirlines = new JLabel("Operating Airlines:");
		lblOperatingAirlines.setBounds(271, 14, 95, 14);
		frmFlightDetails.getContentPane().add(lblOperatingAirlines);
		
		textField_11 = new JTextField();
		textField_11.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
				airlineName = f.getAirlineName();
			}
		});
		textField_11.setColumns(10);
		textField_11.setBounds(376, 14, 130, 14);
		frmFlightDetails.getContentPane().add(textField_11);
		
		JLabel lblArrivalAirport = new JLabel("Arrival Airport:");
		lblArrivalAirport.setBounds(271, 89, 95, 14);
		frmFlightDetails.getContentPane().add(lblArrivalAirport);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(376, 89, 130, 14);
		frmFlightDetails.getContentPane().add(textField_12);
		
		JLabel lblScheduledArrival = new JLabel("Scheduled Arrival:");
		lblScheduledArrival.setBounds(271, 139, 95, 14);
		frmFlightDetails.getContentPane().add(lblScheduledArrival);
		
		JLabel lblArrivalTerminal = new JLabel("Arrival Terminal:");
		lblArrivalTerminal.setBounds(271, 164, 95, 14);
		frmFlightDetails.getContentPane().add(lblArrivalTerminal);
		
		JLabel lblArrivalGates = new JLabel("Arrival Gates:");
		lblArrivalGates.setBounds(271, 189, 95, 14);
		frmFlightDetails.getContentPane().add(lblArrivalGates);
		
		JLabel lblEstimatedArrival = new JLabel("Estimated Arrival:");
		lblEstimatedArrival.setBounds(271, 214, 95, 14);
		frmFlightDetails.getContentPane().add(lblEstimatedArrival);
		
		JLabel lblCheckinEnd = new JLabel("Check-in End:");
		lblCheckinEnd.setBounds(271, 289, 95, 14);
		frmFlightDetails.getContentPane().add(lblCheckinEnd);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(376, 139, 130, 14);
		frmFlightDetails.getContentPane().add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(376, 164, 130, 14);
		frmFlightDetails.getContentPane().add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(376, 189, 130, 14);
		frmFlightDetails.getContentPane().add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(376, 214, 130, 14);
		frmFlightDetails.getContentPane().add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(376, 289, 130, 14);
		frmFlightDetails.getContentPane().add(textField_17);
		
		JButton btnSave = new JButton("Save");
		btnSave.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				f.setAircraftType(aircraftType);
				f.setAirlineName(airlineName);
				f.setFlightNumber(flightNumber);
				f.setIATACode(IATACode);
				f.setStatus(status);
			}
		});
		btnSave.setBounds(417, 341, 89, 23);
		frmFlightDetails.getContentPane().add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(316, 341, 89, 23);
		frmFlightDetails.getContentPane().add(btnCancel);
	}
}
