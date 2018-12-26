package ISD_Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;

public class searchVendor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchVendor frame = new searchVendor();
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
	public searchVendor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterTheItem = new JLabel("Enter the item name");
		lblEnterTheItem.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
		lblEnterTheItem.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterTheItem.setBounds(22, 74, 142, 14);
		contentPane.add(lblEnterTheItem);
		
		textField = new JTextField();
		
		textField.setBounds(22, 112, 178, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lnm", "root", "lnmiit");
					Statement stmt=con.createStatement();
					if(textField.getText().trim().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "Please Enter some value!");
					}
						
					String sql="select * from vendor where Iname='"+textField.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(sql);
				    if(rs.next())
				    {
				    	displayVendor dv=new displayVendor(textField.getText().toString());
						dv.setVisible(true);
				    	
				    }
					else
					{
						JOptionPane.showMessageDialog(null, "No such vendors found!");
                     }
						rs.close();
						stmt.close();
					con.close();
				}
				catch(Exception ex)
				{
					System.out.print(ex);
				}
			}
			
		});
		btnSearch.setBounds(22, 177, 89, 23);
		contentPane.add(btnSearch);
		
		JLabel lblSearchVendor = new JLabel("Search Vendor");
		lblSearchVendor.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchVendor.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblSearchVendor.setBounds(130, 11, 160, 36);
		contentPane.add(lblSearchVendor);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l=new Login();
				l.setVisible(true);
			}
		});
		btnLogOut.setBounds(321, 45, 89, 23);
		contentPane.add(btnLogOut);
	}
}
