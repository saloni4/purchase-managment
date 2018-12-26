package ISD_Project;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class displayStatus extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					displayStatus frame = new displayStatus();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	}

	/**
	 * Create the frame.
	 */
	public displayStatus(String s) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDisplayStatus = new JButton("Display Status");
		btnDisplayStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lnm", "root", "lnmiit");
					Statement stmt=con.createStatement();
					String query="select from indent where uname = '"+s+"'";
					
					ResultSet rs=stmt.executeQuery(query);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					 
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			
		});
		btnDisplayStatus.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnDisplayStatus.setBounds(245, 24, 179, 40);
		contentPane.add(btnDisplayStatus);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 98, 429, 192);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
