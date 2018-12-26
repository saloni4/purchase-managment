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

public class WelcomeD extends JFrame {

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
	public WelcomeD(String w) {
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 300);
		
		JButton btnNewButton_2 = new JButton("Vendor List");
		btnNewButton_2.setBounds(61, 58, 121, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendorList vl=new vendorList();
				vl.setVisible(true);
			}
		});
		getContentPane().setLayout(null);
		btnNewButton_2.setForeground(new Color(255, 102, 51));
		getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("   WELCOME  DIRECTOR");
		lblNewLabel.setBounds(126, 11, 252, 36);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		getContentPane().add(lblNewLabel);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(178, 172, 102, 23);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l=new Login();
				l.setVisible(true);
			}
		});
		btnLogOut.setForeground(new Color(255, 102, 51));
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(btnLogOut);
		
		JButton btnApprovereject = new JButton("Approve/Reject Indents");
		btnApprovereject.setForeground(new Color(255, 102, 51));
		btnApprovereject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AppReject ard=new AppReject(w);
				ard.setVisible(true);
			}
		});
		btnApprovereject.setBounds(245, 58, 157, 23);
		getContentPane().add(btnApprovereject);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
