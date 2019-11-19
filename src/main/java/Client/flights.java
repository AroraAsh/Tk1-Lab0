package Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class flights {

	private JFrame frmFlightList;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					flight_list window = new flight_list();
					window.frmFlightList.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public flight_list() {
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
		
		table = new JTable();
		table.setBounds(0, 0, 562, 338);
		frmFlightList.getContentPane().add(table);
		
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				details.NewScreen();		
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
}
