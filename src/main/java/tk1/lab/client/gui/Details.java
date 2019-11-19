package tk1.lab.client.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import tk1.lab.client.MainClient;
import tk1.lab.server.model.ArrivalDepartureData;
import tk1.lab.server.model.CheckIn;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFormattedTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.Format;
import java.text.NumberFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Details {

	private JFrame frmFlightDetails;
	private JTextField txtIATACode;
	private JTextField txtAircraftType;
	private JTextField txtDepartureAirport;
	private JTextField txtDepartureTerminal;
	private JTextField txtDepartureGate;
	private JTextField txtCheckInLoc;
	private JTextField txtCheckInCounter;
	private JTextField txtOperatingAirline;
	private JTextField txtArrivalAirport;
	private JTextField txtArrivalTerminal;
	private JTextField txtArrivalGate;
	JComboBox comboBoxFlightStatus;
	JFormattedTextField txtFormatOriginDate;
	JFormattedTextField txtFormatScheduledArrival;
	JFormattedTextField txtFormatScheduledDeparture;
	JFormattedTextField txtFormatEstimatedArrival;
	JFormattedTextField txtFormatEstimatedDeparture;
	JFormattedTextField txtFlightNumber;
	JFormattedTextField txtCheckInStart;
	JFormattedTextField txtCheckInEnd;
	String aircraftType = null;
	FlightStatus status = null;
	String IATACode = null;
	String airlineName = null;
	int flightNumber;
	private boolean isEdit = false;
	
	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Details window = new Details();
					window.frmFlightDetails.setVisible(true);
					window.isEdit = false;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void NewEditScreen(Flight flight) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Details window = new Details();
					window.frmFlightDetails.setVisible(true);
					window.setEditValues(flight);
					window.isEdit = true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setEditValues(Flight flight) {
		this.txtAircraftType.setText(flight.getAircraftType());
		this.txtArrivalAirport.setText(flight.getArrivalData().getAirport());
		this.txtArrivalGate.setText(flight.getArrivalData().getGateNo().toString());
		this.txtArrivalTerminal.setText(flight.getArrivalData().getTerminal());
		this.txtCheckInCounter.setText(flight.getDepartureData().getCheckInData().getCheckInCounter());
		this.txtCheckInEnd.setValue(flight.getDepartureData().getCheckInData().getCheckInTimeEnd());
		this.txtCheckInStart.setValue(flight.getDepartureData().getCheckInData().getCheckInTimeStart());
		this.txtCheckInLoc.setText(flight.getDepartureData().getCheckInData().getCheckInLocation()+"");
		this.txtDepartureAirport.setText(flight.getDepartureData().getAirport());
		this.txtDepartureGate.setText(flight.getDepartureData().getGateNo().toString());
		this.txtDepartureTerminal.setText(flight.getDepartureData().getTerminal());
		this.txtFlightNumber.setValue(flight.getFlightNumber());
		this.txtFormatEstimatedArrival.setValue(flight.getArrivalData().getEstimatedDateTime());
		this.txtFormatEstimatedDeparture.setValue(flight.getDepartureData().getEstimatedDateTime());
		this.txtFormatOriginDate.setValue(flight.getOriginDate());
		this.txtFormatScheduledArrival.setValue(flight.getArrivalData().getScheduledDateTime());
		this.txtFormatScheduledDeparture.setValue(flight.getDepartureData().getScheduledDateTime());
		this.txtIATACode.setText(flight.getIATACode());
		this.txtOperatingAirline.setText(flight.getAirlineName());
		this.txtIATACode.setEditable(false);
		this.txtFlightNumber.setEditable(false);
		
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
		try {
		System.out.println("Initialise");
		Flight f = new Flight();
		frmFlightDetails = new JFrame();
		frmFlightDetails.setTitle("Flight Details");
		frmFlightDetails.setBounds(100, 100, 529, 412);
		frmFlightDetails.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmFlightDetails.getContentPane().setLayout(null);
		
		txtIATACode = new JTextField();
		
		txtIATACode.setBounds(126, 14, 130, 14);
		frmFlightDetails.getContentPane().add(txtIATACode);
		txtIATACode.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("IATA Code:");
		lblNewLabel.setLabelFor(txtIATACode);
		lblNewLabel.setBounds(10, 14, 62, 14);
		frmFlightDetails.getContentPane().add(lblNewLabel);
		
		txtAircraftType = new JTextField();
		
		txtAircraftType.setText("asd.66441TK");
		txtAircraftType.setBounds(126, 39, 130, 14);
		frmFlightDetails.getContentPane().add(txtAircraftType);
		txtAircraftType.setColumns(10);
		
		JLabel lblAircraftModel = new JLabel("Aircraft Type:");
		lblAircraftModel.setLabelFor(txtAircraftType);
		lblAircraftModel.setBounds(10, 39, 76, 14);
		frmFlightDetails.getContentPane().add(lblAircraftModel);
		
		JLabel lblTrackingNumber = new JLabel("Tracking Number:");
		lblTrackingNumber.setBounds(10, 64, 95, 14);
		frmFlightDetails.getContentPane().add(lblTrackingNumber);
		
		txtDepartureAirport = new JTextField();
		txtDepartureAirport.setBounds(126, 89, 130, 14);
		frmFlightDetails.getContentPane().add(txtDepartureAirport);
		txtDepartureAirport.setColumns(10);
		
		txtDepartureTerminal = new JTextField();
		txtDepartureTerminal.setColumns(10);
		txtDepartureTerminal.setBounds(126, 164, 130, 14);
		frmFlightDetails.getContentPane().add(txtDepartureTerminal);
		
		txtDepartureGate = new JTextField();
		txtDepartureGate.setColumns(10);
		txtDepartureGate.setBounds(126, 189, 130, 14);
		frmFlightDetails.getContentPane().add(txtDepartureGate);
		
		txtCheckInLoc = new JTextField();
		txtCheckInLoc.setColumns(10);
		txtCheckInLoc.setBounds(126, 239, 130, 14);
		frmFlightDetails.getContentPane().add(txtCheckInLoc);
		
		txtCheckInCounter = new JTextField();
		txtCheckInCounter.setColumns(10);
		txtCheckInCounter.setBounds(126, 264, 130, 14);
		frmFlightDetails.getContentPane().add(txtCheckInCounter);
		
		JLabel lblDepartureAirport = new JLabel("Departure Airport:");
		lblDepartureAirport.setLabelFor(txtDepartureAirport);
		lblDepartureAirport.setBounds(10, 89, 95, 14);
		frmFlightDetails.getContentPane().add(lblDepartureAirport);
		
		JLabel lblOriginDate = new JLabel("Origin Date:");
		lblOriginDate.setBounds(10, 114, 95, 14);
		frmFlightDetails.getContentPane().add(lblOriginDate);
		
		JLabel lblScheduledDeparture = new JLabel("Scheduled Departure:");
		lblScheduledDeparture.setBounds(10, 139, 110, 14);
		frmFlightDetails.getContentPane().add(lblScheduledDeparture);
		
		JLabel lblDepartureTerminal = new JLabel("Departure Terminal:");
		lblDepartureTerminal.setLabelFor(txtDepartureTerminal);
		lblDepartureTerminal.setBounds(10, 164, 110, 14);
		frmFlightDetails.getContentPane().add(lblDepartureTerminal);
		
		JLabel lblDepartureGates = new JLabel("Departure Gates:");
		lblDepartureGates.setLabelFor(txtDepartureGate);
		lblDepartureGates.setBounds(10, 189, 95, 14);
		frmFlightDetails.getContentPane().add(lblDepartureGates);
		
		JLabel lblEstimatedDeparture = new JLabel("Estimated Departure:");
		lblEstimatedDeparture.setBounds(10, 214, 95, 14);
		frmFlightDetails.getContentPane().add(lblEstimatedDeparture);
		
		JLabel lblCheckinLocation = new JLabel("Check-in Location:");
		lblCheckinLocation.setLabelFor(txtCheckInLoc);
		lblCheckinLocation.setBounds(10, 239, 95, 14);
		frmFlightDetails.getContentPane().add(lblCheckinLocation);
		
		JLabel lblCheckinCounter = new JLabel("Check-in Counter:");
		lblCheckinCounter.setLabelFor(txtCheckInCounter);
		lblCheckinCounter.setBounds(10, 264, 95, 14);
		frmFlightDetails.getContentPane().add(lblCheckinCounter);
		
		JLabel lblCheckinStart = new JLabel("Check-in Start:");
		lblCheckinStart.setBounds(10, 289, 95, 14);
		frmFlightDetails.getContentPane().add(lblCheckinStart);
		
		JLabel lblFlightStatus = new JLabel("Flight Status:");
		lblFlightStatus.setBounds(10, 314, 95, 14);
		frmFlightDetails.getContentPane().add(lblFlightStatus);
		
		comboBoxFlightStatus = new JComboBox();
		comboBoxFlightStatus.setModel(new DefaultComboBoxModel(FlightStatus.values()));
		
		comboBoxFlightStatus.setBounds(126, 314, 380, 23);
		frmFlightDetails.getContentPane().add(comboBoxFlightStatus);
		
		JLabel lblOperatingAirlines = new JLabel("Operating Airlines:");
		lblOperatingAirlines.setBounds(271, 14, 95, 14);
		frmFlightDetails.getContentPane().add(lblOperatingAirlines);
		
		txtOperatingAirline = new JTextField();
		
		txtOperatingAirline.setColumns(10);
		txtOperatingAirline.setBounds(376, 14, 130, 14);
		frmFlightDetails.getContentPane().add(txtOperatingAirline);
		
		JLabel lblArrivalAirport = new JLabel("Arrival Airport:");
		lblArrivalAirport.setBounds(271, 89, 95, 14);
		frmFlightDetails.getContentPane().add(lblArrivalAirport);
		
		txtArrivalAirport = new JTextField();
		txtArrivalAirport.setColumns(10);
		txtArrivalAirport.setBounds(376, 89, 130, 14);
		frmFlightDetails.getContentPane().add(txtArrivalAirport);
		
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
		
		txtArrivalTerminal = new JTextField();
		txtArrivalTerminal.setColumns(10);
		txtArrivalTerminal.setBounds(376, 164, 130, 14);
		frmFlightDetails.getContentPane().add(txtArrivalTerminal);
		
		txtArrivalGate = new JTextField();
		txtArrivalGate.setColumns(10);
		txtArrivalGate.setBounds(376, 189, 130, 14);
		frmFlightDetails.getContentPane().add(txtArrivalGate);
		
		JButton btnSave = new JButton("Save");
		
		
		btnSave.setBounds(415, 341, 89, 23);
		frmFlightDetails.getContentPane().add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(316, 341, 89, 23);
		frmFlightDetails.getContentPane().add(btnCancel);
		
		SimpleDateFormat formatOriginDate = new SimpleDateFormat("yyyy-MM-dd");
		 txtFormatOriginDate = new JFormattedTextField(formatOriginDate);
		
		txtFormatOriginDate.setBounds(126, 114, 130, 14);
		frmFlightDetails.getContentPane().add(txtFormatOriginDate);
		
		SimpleDateFormat formatScheduledArrival = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		 txtFormatScheduledArrival = new JFormattedTextField(formatScheduledArrival);
		
		txtFormatScheduledArrival.setBounds(376, 136, 127, 20);
		txtFormatScheduledArrival.setValue(new Date());
		frmFlightDetails.getContentPane().add(txtFormatScheduledArrival);
		
		SimpleDateFormat formatScheduledDeparture = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		 txtFormatScheduledDeparture = new JFormattedTextField(formatScheduledDeparture);
		lblScheduledDeparture.setLabelFor(txtFormatScheduledDeparture);
		txtFormatScheduledDeparture.setBounds(126, 142, 130, 14);
		txtFormatScheduledDeparture.setValue(new Date());
		frmFlightDetails.getContentPane().add(txtFormatScheduledDeparture);
		
		SimpleDateFormat formatEstimatedDeparture = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		 txtFormatEstimatedDeparture = new JFormattedTextField(formatEstimatedDeparture);
		txtFormatEstimatedDeparture.setBounds(126, 217, 130, 14);
		txtFormatEstimatedDeparture.setValue(new Date());
		frmFlightDetails.getContentPane().add(txtFormatEstimatedDeparture);
		
		SimpleDateFormat formatEstimatedArrival = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		 txtFormatEstimatedArrival = new JFormattedTextField(formatEstimatedArrival);
		txtFormatEstimatedArrival.setBounds(376, 214, 130, 14);
		txtFormatEstimatedArrival.setValue(new Date());
		frmFlightDetails.getContentPane().add(txtFormatEstimatedArrival);
		
		
		NumberFormat longFormat = NumberFormat.getIntegerInstance();

		NumberFormatter numberFormatter = new NumberFormatter(longFormat);
		numberFormatter.setValueClass(Long.class); //optional, ensures you will always get a long value
		numberFormatter.setAllowsInvalid(false); //this is the key!!
		numberFormatter.setMinimum(0l); //Optional
		 txtFlightNumber = new JFormattedTextField(numberFormatter);
		txtFlightNumber.setBounds(126, 64, 130, 14);
		frmFlightDetails.getContentPane().add(txtFlightNumber);
		
		SimpleDateFormat formatCheckInStart = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		 txtCheckInStart = new JFormattedTextField(formatCheckInStart);
		txtCheckInStart.setBounds(126, 289, 130, 14);
		frmFlightDetails.getContentPane().add(txtCheckInStart);
		
		SimpleDateFormat formatCheckInEnd = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		 txtCheckInEnd = new JFormattedTextField(formatCheckInEnd);
		txtCheckInEnd.setBounds(376, 289, 130, 14);
		frmFlightDetails.getContentPane().add(txtCheckInEnd);
		
		
		System.out.println("Adding Keypress");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					System.out.println("Adding CheckInData");
				CheckIn checkIn = new CheckIn();
				checkIn.setCheckInCounter(txtCheckInCounter.getText());
				checkIn.setCheckInLocation(Integer.parseInt(txtCheckInLoc.getText()));
				checkIn.setCheckInTimeEnd((Date)txtCheckInStart.getValue());
				checkIn.setCheckInTimeStart((Date)txtCheckInEnd.getValue());
				System.out.println("Adding DepData");
				ArrivalDepartureData depData = new ArrivalDepartureData();
				depData.setAirport(txtDepartureAirport.getText());
				depData.setScheduledDateTime((Date)txtFormatScheduledDeparture.getValue());
				depData.setGateNo(Integer.parseInt(txtDepartureGate.getText()));
				depData.setCheckInData(checkIn);
				depData.setEstimatedDateTime((Date)txtFormatEstimatedDeparture.getValue());
				
				System.out.println("Adding ArrData");
				ArrivalDepartureData arrData = new ArrivalDepartureData();
				arrData.setAirport(txtArrivalAirport.getText());
				arrData.setScheduledDateTime((Date)txtFormatScheduledArrival.getValue());
				arrData.setGateNo(Integer.parseInt(txtArrivalGate.getText()));
				arrData.setCheckInData(null);
				arrData.setEstimatedDateTime((Date)txtFormatEstimatedArrival.getValue());
				
				System.out.println("Adding FlightData");
				f.setAircraftType(txtAircraftType.getText());
				f.setAirlineName(txtOperatingAirline.getText());
				f.setArrivalData(arrData);
				f.setDepartureData(depData);
				f.setFlightNumber(Integer.parseInt(txtFlightNumber.getText()));
				f.setIATACode(txtIATACode.getText());
				f.setStatus((FlightStatus)comboBoxFlightStatus.getSelectedItem());
				f.setOriginDate((Date)txtFormatOriginDate.getValue());
				System.out.println("Adding Server");
				if(!isEdit)
					MainClient.stub.addNewFlight(MainClient.clientName, f);
				else
					MainClient.stub.updateFlight(MainClient.clientName, f);
				exit();
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void exit() {
		this.frmFlightDetails.dispose();
	}
}
