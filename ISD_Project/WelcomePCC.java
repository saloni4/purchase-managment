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

public class WelcomePCC extends JFrame {

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
	public WelcomePCC(String w) {
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 300);
		getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Check Status");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkStatus cs=new checkStatus();
				cs.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 102, 51));
		btnNewButton_1.setBounds(126, 58, 112, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Vendor List");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendorList vl=new vendorList();
				vl.setVisible(true);
			}
		});
		btnNewButton_2.setForeground(new Color(255, 102, 51));
		btnNewButton_2.setBounds(248, 58, 121, 23);
		getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("   WELCOME  PCC");
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
		
		JButton btnAddVendor = new JButton("Add Vendor");
		btnAddVendor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddVendor av = new AddVendor();
				av.setVisible(true);
			}
		});
		btnAddVendor.setForeground(new Color(205, 133, 63));
		btnAddVendor.setBounds(0, 58, 112, 23);
		getContentPane().add(btnAddVendor);
		
		JButton btnApprovereject = new JButton("Approve/Reject");
		btnApprovereject.setForeground(new Color(255, 102, 51));
		btnApprovereject.setBounds(385, 58, 112, 23);
		getContentPane().add(btnApprovereject);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
