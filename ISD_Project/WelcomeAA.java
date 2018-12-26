package ISD_Project;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Choice;
import java.awt.List;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class WelcomeAA extends JFrame {

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		/**EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeIndentor frame = new WelcomeIndentor();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});**/
	}

	/**
	 * Create the frame.
	 */
	public WelcomeAA(String w) {
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 300);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Create Indent");
		btnNewButton.setForeground(new Color(255, 102, 51));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Memo m;
				try {
					m = new Memo(w);
					m.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(10, 58, 112, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Check Status");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkStatus cs=new checkStatus();
				cs.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 102, 51));
		btnNewButton_1.setBounds(132, 58, 112, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Vendor List");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendorList vl=new vendorList();
				vl.setVisible(true);
			}
		});
		btnNewButton_2.setForeground(new Color(255, 102, 51));
		btnNewButton_2.setBounds(260, 58, 121, 23);
		getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("   WELCOME " + w);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblNewLabel.setBounds(126, 11, 194, 36);
		getContentPane().add(lblNewLabel);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l=new Login();
				l.setVisible(true);
			}
		});
		btnLogOut.setForeground(new Color(255, 102, 51));
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogOut.setBounds(205, 189, 102, 23);
		getContentPane().add(btnLogOut);
		
		JButton btnNewButton_3 = new JButton("Approve/Reject");
		btnNewButton_3.setForeground(new Color(255, 102, 51));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppReject ar=new AppReject(w);
				ar.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(391, 58, 135, 23);
		getContentPane().add(btnNewButton_3);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
