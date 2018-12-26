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
public class displayVendor extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			//public void run() {
				//try {
					//displayVendor frame = new displayVendor();
					//frame.setVisible(true);
				//} catch (Exception e) {
					//e.printStackTrace();
				//}
			//}
		//});//
	}
Connection con=null;
private JButton btnHomePage;
	/**
	 * Create the frame.
	 */
	public displayVendor(String s) {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lnm", "root", "lnmiit");
		}
		catch(Exception e){
			
				
			
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDisplay = new JButton("Load Vendor Details");
		btnDisplay.setFont(new Font("Sitka Banner", Font.BOLD | Font.ITALIC, 16));
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select * from vendor where Iname='"+s+"'";
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					 
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			}
		);
		btnDisplay.setBounds(270, 23, 196, 34);
		contentPane.add(btnDisplay);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 77, 491, 217);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnHomePage = new JButton("Log Out");
		btnHomePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l=new Login();
				l.setVisible(true);
			}
		});
		btnHomePage.setBounds(196, 329, 102, 34);
		contentPane.add(btnHomePage);
	}

}
