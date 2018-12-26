package ISD_Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewPO extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPO frame = new ViewPO();
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
	public ViewPO() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblViewPurchaseOrder = new JLabel("View Purchase Order");
		lblViewPurchaseOrder.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblViewPurchaseOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewPurchaseOrder.setBounds(126, 11, 183, 27);
		contentPane.add(lblViewPurchaseOrder);
		
		JLabel lblEnterIndentId = new JLabel("Enter Indent ID");
		lblEnterIndentId.setBounds(34, 74, 108, 27);
		contentPane.add(lblEnterIndentId);
		
		textField = new JTextField();
		int id=Integer.parseInt(textField.getText().toString());
		textField.setBounds(152, 75, 114, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayPO dp=new displayPO(id);
				dp.setVisible(true);
			}
		});
		btnShow.setBounds(316, 76, 89, 23);
		contentPane.add(btnShow);
	}

}
