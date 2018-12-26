package ISD_Project;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddVendor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblSupplyType;
	private JTextField textField_3;
	private JLabel lblAddressLocation;
	private JTextField textField_4;
	private JLabel lblPhone;
	private JTextField textField_5;
	private JLabel lblFeedback;
	private JButton btnSubmit;
	private JLabel lblPaymentForm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddVendor frame = new AddVendor();
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
	public AddVendor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPleaseFillThe = new JLabel("Please fill details of the Vendor");
		lblPleaseFillThe.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPleaseFillThe.setBounds(10, 11, 295, 26);
		contentPane.add(lblPleaseFillThe);
		
		textField = new JTextField();
		textField.setBounds(10, 61, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName.setBounds(10, 48, 70, 14);
		contentPane.add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(139, 61, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(142, 48, 70, 14);
		contentPane.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(261, 61, 86, 20);
		contentPane.add(textField_2);
		
		lblSupplyType = new JLabel("Supply Type\r\n");
		lblSupplyType.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSupplyType.setBounds(261, 48, 70, 14);
		contentPane.add(lblSupplyType);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 117, 258, 20);
		contentPane.add(textField_3);
		
		lblAddressLocation = new JLabel("Address / Location");
		lblAddressLocation.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAddressLocation.setBounds(10, 104, 112, 14);
		contentPane.add(lblAddressLocation);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(289, 117, 122, 20);
		contentPane.add(textField_4);
		
		lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPhone.setBounds(289, 104, 70, 14);
		contentPane.add(lblPhone);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(10, 161, 349, 20);
		contentPane.add(textField_5);
		
		lblFeedback = new JLabel("Feedback");
		lblFeedback.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFeedback.setBounds(10, 148, 70, 14);
		contentPane.add(lblFeedback);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSubmit.setBounds(335, 227, 89, 23);
		contentPane.add(btnSubmit);
		
		lblPaymentForm = new JLabel("Payment Form\r\n");
		lblPaymentForm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPaymentForm.setBounds(10, 192, 112, 14);
		contentPane.add(lblPaymentForm);
		
		JList list = new JList();
		list.setBounds(89, 227, 43, -6);
		contentPane.add(list);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cash", "Online"}));
		comboBox.setBounds(119, 192, 106, 20);
		contentPane.add(comboBox);
	}
}
