package ISD_Project;

import java.awt.BorderLayout;




import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.*;
import javax.swing.*;
import java.sql.PreparedStatement;
import net.proteanit.sql.DbUtils;

public class DisplayTendor extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	Connection con=null;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayTendor frame = new DisplayTendor();
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
	public DisplayTendor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoadTendorDetails = new JButton("Load Tendor  Details");
		btnLoadTendorDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select * from vendor where Iname='"+id+"'";
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					 
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			
		});
		btnLoadTendorDetails.setBounds(295, 24, 165, 35);
		contentPane.add(btnLoadTendorDetails);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 77, 498, 214);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(373, 313, 89, 23);
		contentPane.add(btnLogOut);
	}
}
