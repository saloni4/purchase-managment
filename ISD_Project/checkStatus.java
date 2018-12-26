package ISD_Project;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import net.proteanit.sql.DbUtils;

public class checkStatus extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			//public void run() {
				//try {
					//checkStatus frame = new checkStatus();
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
	public checkStatus() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setFont(new Font("Modern No. 20", Font.BOLD, 23));
		lblStatus.setBounds(157, 11, 92, 22);
		contentPane.add(lblStatus);
		
		JLabel lblEnterIndentId = new JLabel("Enter Indent Id");
		lblEnterIndentId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterIndentId.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterIndentId.setBounds(10, 54, 106, 14);
		contentPane.add(lblEnterIndentId);
		
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		textField.setBounds(126, 53, 113, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lnm", "root", "lnmiit");
					Statement stmt=con.createStatement();
					String sql="select approvedByHoD,approvedByFO,approvedByDir,POGenrated,completed from indent where indentId='"+textField.getText()+"'";
					ResultSet rs=stmt.executeQuery(sql);
				    if(!rs.next())
				    {
				    	JOptionPane.showMessageDialog(null, "No such indents found!");
				    }
					else
					{
						displayStatus ds = new displayStatus(textField.getText().toString());
						ds.setVisible(true);
                     }
						rs.close();
						stmt.close();
					con.close();
				}catch(Exception e)
				{
					System.out.print(e);
					
				}
			}
		});
		btnCheck.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		btnCheck.setBounds(286, 56, 89, 23);
		contentPane.add(btnCheck);
		
		
	}
}
