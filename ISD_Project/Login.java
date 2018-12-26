package ISD_Project;

import java.sql.*;
import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;
	private JLabel lblIfYouAre;
	private JButton btnGuest;
	private JLabel lblLoginPage;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("    UserName");
		lblUsername.setBounds(10, 78, 88, 26);
		lblUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(lblUsername);
		
		user = new JTextField();
		user.setBounds(127, 83, 205, 32);
		user.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(user);
		user.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("   Password");
		lblNewLabel.setBounds(20, 142, 78, 26);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(lblNewLabel);
		
		pass = new JPasswordField();
		pass.setBounds(127, 142, 205, 26);
		contentPane.add(pass);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(10, 198, 165, 32);
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
				}catch(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lnm", "root", "lnmiit");
					Statement stmt=con.createStatement();
					String sql="select * from intendor where uname='"+user.getText()+"' and pass='"+pass.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(sql);
				
					
					if(rs.next()) {
						
						if(user.getText().trim().equals("HD")||user.getText().trim().equals("FO"))
						{
							WelcomeAA wa=new WelcomeAA(user.getText().toString());
							wa.setVisible(true);
						}
						else if(user.getText().trim().equals("Director"))
						{
							WelcomeD wd=new WelcomeD(user.getText().toString());
							wd.setVisible(true);
						}
						else if(user.getText().trim().equals("PCC"))
						{
							WelcomePCC wp=new WelcomePCC("PCC");
							wp.setVisible(true);
						}
							
						else
						{
							WelcomeIndentor wi=new WelcomeIndentor(user.getText());
							   wi.setVisible(true);
						}
					}
					else if(user.getText().trim().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "Please enter username!");
					}
					else if(pass.getText().toString().trim().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "Please enter password!");
					}
					else 
						JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
					
					
						
					con.close();
				}catch(Exception e)
				{
					System.out.print(e);
					
				}
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 16));
		contentPane.add(btnNewButton);
		
		lblIfYouAre = new JLabel("If you are a guest user please click below");
		lblIfYouAre.setBounds(66, 262, 266, 26);
		lblIfYouAre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIfYouAre.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblIfYouAre);
		
		btnGuest = new JButton("GUEST");
		btnGuest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuestHome gh=new GuestHome();
				gh.setVisible(true);
			}
		});
		btnGuest.setBounds(157, 299, 89, 32);
		btnGuest.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		contentPane.add(btnGuest);
		
		lblLoginPage = new JLabel("LOGIN PAGE");
		lblLoginPage.setBounds(149, 11, 152, 32);
		lblLoginPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginPage.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		contentPane.add(lblLoginPage);
		
		JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Please contact IT Department at it.helpdesk@lnmiit.ac.in" );
			}
		});
		btnForgotPassword.setFont(new Font("Arial Black", Font.BOLD, 16));
		btnForgotPassword.setBounds(185, 198, 205, 32);
		contentPane.add(btnForgotPassword);
	}
}
