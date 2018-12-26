package ISD_Project;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Success extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btnHomePage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			//public void run() {
			//	try {
				//	Success frame = new Success();
				//	frame.setVisible(true);
				//} catch (Exception e) {
				//	e.printStackTrace();
				//}
			//}
		//});//
	}

	/**
	 * Create the frame.
	 */
	public Success(String w) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblYourIndentHas = new JLabel("Your Indent has been created Successfully!! \r\n");
		
		lblYourIndentHas.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourIndentHas.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblYourIndentHas.setBounds(52, 56, 414, 71);
		contentPane.add(lblYourIndentHas);
		
		lblNewLabel = new JLabel("Please note the reference Intend Id: ");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblNewLabel.setBounds(62, 124, 390, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lnm", "root", "lnmiit");
			Statement stmt=null;
			stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from  indent where uname='"+w+"'");
			rs.next();
			String s=rs.getString("indentId");
			lblNewLabel_1.setText(s);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		lblNewLabel_1.setBounds(72, 179, 190, 49);
		contentPane.add(lblNewLabel_1);
		
		btnHomePage = new JButton("Home Page");
		btnHomePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(w.equals("director")|| w.equals("HoD") || w.equals("FO")) 
				{
					WelcomeAA wi=new WelcomeAA(w);
					wi.setVisible(true);
				}
				else if(w.equals("pcc")) {
					WelcomePCC wi=new WelcomePCC(w);
					wi.setVisible(true);
				}
				else {
					WelcomeIndentor wi=new WelcomeIndentor(w);
					wi.setVisible(true);
				}
			}
		});
		btnHomePage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHomePage.setBounds(342, 205, 110, 23);
		contentPane.add(btnHomePage);
	}
}
