package ISD_Project;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AppReject extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/***EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppReject frame = new AppReject();
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
	public AppReject(String w) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblApprovereject = new JLabel("Approve/Reject");
		lblApprovereject.setBounds(150, 11, 105, 14);
		contentPane.add(lblApprovereject);
		
		JLabel lblEnterIndentId = new JLabel("Enter Indent Id");
		lblEnterIndentId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEnterIndentId.setBounds(22, 66, 99, 14);
		contentPane.add(lblEnterIndentId);
		
		textField = new JTextField();
		int id=Integer.parseInt(textField.getText().toString());
		
		textField.setBounds(140, 63, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please enter some value!");
				}
				
			}
		});
		btnEnter.setBounds(274, 62, 89, 23);
		contentPane.add(btnEnter);
		
		JLabel label = new JLabel("");
		label.setBounds(22, 236, 46, 14);
		contentPane.add(label);
		
		JLabel lblSuggestion = new JLabel("Suggestion");
		lblSuggestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuggestion.setBounds(0, 289, 95, 14);
		contentPane.add(lblSuggestion);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(90, 271, 195, 50);
		contentPane.add(textField_1);
		
		JButton btnReject = new JButton("Reject and Reconsider");
		btnReject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(w.equals("Director"))
				{
					WelcomeD wd=new WelcomeD(w);
					wd.setVisible(true);
				}
			}
		});
		btnReject.setBounds(293, 285, 141, 23);
		contentPane.add(btnReject);
		
		JButton btnA = new JButton("Approve");
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lnm", "root", "lnmiit");
					Statement stmt=con.createStatement();
					
					ResultSet rs;
					if(w.equals("Director"))
					{
						String sql="update indent set approvedByDir ='yes' where indentId='"+id+"'";
						rs=stmt.executeQuery(sql);
					}
					else if(w.equals("HoD"))
					{
						String sql="update indent set approvedByHoD ='yes' where indentId='"+id+"'";
						rs=stmt.executeQuery(sql);
					}
					else if(w.equals("FO"))
					{
						String sql="update indent set approvedByFO ='yes' where indentId='"+id+"'";
						rs=stmt.executeQuery(sql);
					}
					 
					if(w.equals("Director"))
					{
						WelcomeD wd=new WelcomeD(w);
						wd.setVisible(true);
					}
					
				}
				catch(Exception e)
				{
					
				}
			}
		});
		btnA.setBounds(319, 237, 89, 23);
		contentPane.add(btnA);
	}
}

