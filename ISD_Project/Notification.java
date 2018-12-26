 package ISD_Project;
import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Notification extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			//public void run() {
				//try {
					//Notification frame = new Notification();
					//frame.setVisible(true);
				//} catch (Exception e) {
					//e.printStackTrace();
				//}
			//}
		//});
	}

	/**
	 * Create the frame.
	 */
	public Notification(String w) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNotificationForYou = new JLabel("Notifications for You ");
		lblNotificationForYou.setBounds(57, 31, 320, 48);
		lblNotificationForYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotificationForYou.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(lblNotificationForYou);
		
		JLabel lblNewLabel = new JLabel("");
		
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lnm", "root", "lnmiit");
			Statement stmt=null;
			stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from  notification where uname='"+w+"'");
			rs.next();
			String s=rs.getString("notfiy");
			lblNewLabel.setText(s);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		lblNewLabel.setBounds(35, 90, 355, 140);
		contentPane.add(lblNewLabel);
	}
}
