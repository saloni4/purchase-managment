package ISD_Project;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuestHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuestHome frame = new GuestHome();
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
	public GuestHome() {
		setForeground(new Color(255, 255, 153));
		setBackground(new Color(255, 255, 153));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeGuest = new JLabel("Welcome Guest ");
		lblWelcomeGuest.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeGuest.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblWelcomeGuest.setBounds(125, 11, 186, 31);
		contentPane.add(lblWelcomeGuest);
		
		JButton btnVendorList = new JButton("Vendor List");
		btnVendorList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vendorList vl=new vendorList();
				vl.setVisible(true);
			}
		});
		btnVendorList.setBackground(Color.ORANGE);
		btnVendorList.setBounds(64, 108, 89, 23);
		contentPane.add(btnVendorList);
		
		JButton btnTender = new JButton("Tender Notice");
		btnTender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tendor t=new Tendor();
				t.setVisible(true);
			}
		});
		btnTender.setBackground(Color.ORANGE);
		btnTender.setBounds(233, 108, 122, 23);
		contentPane.add(btnTender);
	}

}
