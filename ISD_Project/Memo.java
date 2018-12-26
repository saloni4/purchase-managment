package ISD_Project;
import java.awt.BorderLayout;
import java.sql.Date;
import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Memo extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField quantity;
	private JTextField cost;
	private JTextField spec;
	private JTextField type;
	private JTextField rec;
	private JLabel lblDepartment;
	private JTextField dep;
	private JLabel lblTimeline;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static String output;
	public Statement st;
	public static void main(String[] args) {
		LocalDate today=LocalDate.now(ZoneId.of("Asia/Kolkata"));
		output=today.toString();
		/***EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Memo frame = new Memo();
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
	public Memo(String w) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Item_Name");
		lblName.setBounds(29, 60, 86, 14);
		contentPane.add(lblName);
		
		name = new JTextField();
		name.setBounds(96, 57, 86, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(29, 106, 46, 14);
		contentPane.add(lblQuantity);
		
		quantity = new JTextField();
		quantity.setBounds(96, 103, 86, 20);
		contentPane.add(quantity);
		quantity.setColumns(10);
		
		JLabel lblCost = new JLabel("Cost");
		lblCost.setBounds(29, 149, 46, 14);
		contentPane.add(lblCost);
		
		cost = new JTextField();
		cost.setBounds(96, 146, 86, 20);
		contentPane.add(cost);
		cost.setColumns(10);
		
		JLabel lblSpecification = new JLabel("Specification");
		lblSpecification.setBounds(248, 60, 81, 14);
		contentPane.add(lblSpecification);
		
		spec = new JTextField();
		spec.setBounds(343, 57, 86, 20);
		contentPane.add(spec);
		spec.setColumns(10);
		
		JLabel lblItemType = new JLabel("Item Type");
		lblItemType.setBounds(248, 103, 81, 14);
		contentPane.add(lblItemType);
		
		type = new JTextField();
		type.setBounds(343, 100, 86, 20);
		contentPane.add(type);
		type.setColumns(10);
		
		JLabel lblRecommender = new JLabel("Recommender");
		lblRecommender.setBounds(248, 152, 81, 14);
		contentPane.add(lblRecommender);
		
		rec = new JTextField();
		rec.setBounds(343, 149, 86, 20);
		contentPane.add(rec);
		rec.setColumns(10);
		
		lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(29, 189, 72, 14);
		contentPane.add(lblDepartment);
		
		dep = new JTextField();
		dep.setBounds(96, 189, 86, 20);
		contentPane.add(dep);
		dep.setColumns(10);
		
		lblTimeline = new JLabel("TimeLine");
		lblTimeline.setBounds(248, 192, 46, 14);
		contentPane.add(lblTimeline);
		
		JLabel lblFillUpThe = new JLabel("Fill up the following fields of a Memo");
		lblFillUpThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblFillUpThe.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblFillUpThe.setBounds(29, 11, 400, 27);
		contentPane.add(lblFillUpThe);
		
		textField = new JTextField();
		textField.setBounds(343, 189, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lnm", "root", "lnmiit");
					con.setAutoCommit(false);
					
					String s1=name.getText();
					String s2=type.getText();
					String s3=spec.getText();
					String s4=quantity.getText();
					String s5=lblTimeline.getText();
					String s6=lblDepartment.getText();
					String s7=rec.getText();
					String s8=cost.getText();
					if(name.getText().trim().isEmpty()||type.getText().trim().isEmpty()||spec.getText().trim().isEmpty()||lblTimeline.getText().trim().isEmpty()||quantity.getText().trim().isEmpty()||lblDepartment.getText().trim().isEmpty()||cost.getText().trim().isEmpty()||rec.getText().trim().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "All the fields are mandatory!");
					}
					else
					{
						String query="insert into item(Iname,IType,Features,intendorId,quantity) "+"values(?,?,?,?,?)";
						PreparedStatement p=con.prepareStatement(query);
						p.setString(1, s1);
						p.setString(2, s2);
						p.setString(3, s3);
						p.setString(4, w);
						p.setInt(5, Integer.parseInt(s4));
						p.execute();
						con.commit();
						
						
						
						
						JOptionPane.showMessageDialog(null, "Submitted Successfully!");
						
					}
					
					
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		});
		btnSubmit.setBounds(96, 287, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				WelcomeIndentor wi = new WelcomeIndentor(w);
				wi.setVisible(true);
			}
		});
		btnCancel.setBounds(248, 287, 89, 23);
		contentPane.add(btnCancel);
	}
}
