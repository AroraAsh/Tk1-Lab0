package tk1.lab.client.gui;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import tk1.lab.client.MainClient;
import tk1.lab.server.model.Flight;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

public class FlightListGui {

	public JFrame frmFlightList;
	private JTable table;
	private String[] col = {"Operating Airline","IATA Code","Trcking No.","Departure","Arrival","Terminal",
			"Scheduled Departure","Scheduled Arrival"};
	DefaultTableModel tableModel = new DefaultTableModel(col, 0);
	public static List<Flight> flightList = new ArrayList<>();
	/**
	 * Create the application.
	 */
	public FlightListGui() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFlightList = new JFrame();
		frmFlightList.setTitle("Flight List");
		frmFlightList.setBounds(100, 100, 578, 411);
		frmFlightList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFlightList.getContentPane().setLayout(null);
		
		table = new JTable(tableModel);
		table.setBounds(0, 0, 562, 338);
		frmFlightList.getContentPane().add(table);
		
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Details.NewScreen();		
			}
		});
		btnNew.setBounds(137, 343, 89, 23);
		frmFlightList.getContentPane().add(btnNew);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(236, 343, 89, 23);
		frmFlightList.getContentPane().add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(335, 343, 89, 23);
		frmFlightList.getContentPane().add(btnDelete);
	}
	
	public void setFlightListData(List<Flight> flights) {
		this.tableModel.setRowCount(0);
		for(Flight flight: flights) {
			Object[]  rowData = {flight.getAirlineName(),flight.getIATACode(),flight.getFlightNumber(),flight.getDepartureData().getAirport(),
					flight.getArrivalData().getAirport(),flight.getArrivalData().getGateNo(),flight.getDepartureData().getScheduledDateTime().toString(),
					flight.getDepartureData().getEstimatedDateTime().toString()};
			this.tableModel.addRow(rowData);
			}
		this.tableModel.fireTableDataChanged();
	}
}
