package ISD_Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class vendorList extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vendorList frame = new vendorList();
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
	public vendorList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(5, 5, 554, 0);
		contentPane.add(label);
		
		JLabel lblVendorList = new JLabel("Vendor List");
		lblVendorList.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblVendorList.setHorizontalAlignment(SwingConstants.CENTER);
		lblVendorList.setBounds(278, 32, 120, 34);
		contentPane.add(lblVendorList);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Id", "Vendor_Name", "Supply_Type", "Address", "Phone", "Feedback", "Payment_Type"},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(36);
		table.getColumnModel().getColumn(1).setPreferredWidth(87);
		table.getColumnModel().getColumn(3).setPreferredWidth(88);
		table.getColumnModel().getColumn(5).setPreferredWidth(151);
		table.setBounds(20, 106, 734, 80);
		contentPane.add(table);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				searchVendor sv=new searchVendor();
				sv.setVisible(true);
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearch.setBounds(278, 230, 89, 34);
		contentPane.add(btnSearch);
		
		JButton btnViewPo = new JButton("View PO");
		btnViewPo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPO v=new ViewPO();
				v.setVisible(true);
			}
		});
		btnViewPo.setBounds(511, 230, 89, 34);
		contentPane.add(btnViewPo);
	}

}
