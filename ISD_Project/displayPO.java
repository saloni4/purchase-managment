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

import net.proteanit.sql.DbUtils;

public class displayPO extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	Connection con=null;
	public static void main(String[] args) {
		/***EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					displayPO frame = new displayPO();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});***/
	}

	/**
	 * Create the frame.
	 */
	public displayPO(int id) {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lnm", "root", "lnmiit");
		}
		catch(Exception e){
			
				
			
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 439, 180);
		contentPane.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnViewPo = new JButton("View PO");
		btnViewPo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select * from indent where indentId='"+id+"'";
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					 
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnViewPo.setBounds(291, 11, 102, 46);
		contentPane.add(btnViewPo);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l=new Login();
				l.setVisible(true);
			}
		});
		btnLogOut.setBounds(334, 264, 89, 23);
		contentPane.add(btnLogOut);
		
		
		
		
	}

}
