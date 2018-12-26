package ISD_Project;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Tendor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	Connection con=null;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tendor frame = new Tendor();
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
	public Tendor() {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lnm", "root", "lnmiit");
		}
		catch(Exception e){
			
				
			
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 466);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTenderNotices = new JLabel("Tender Notices");
		lblTenderNotices.setBounds(33, 11, 225, 48);
		lblTenderNotices.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTenderNotices.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTenderNotices);
		
		JLabel lblSendQuotationFor = new JLabel("Send Quotation for any at pcc.institute@abc.com");
		lblSendQuotationFor.setBounds(125, 390, 338, 14);
		lblSendQuotationFor.setForeground(Color.GRAY);
		lblSendQuotationFor.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblSendQuotationFor);
		
		JButton btnFetchDetails = new JButton("FETCH DETAILS");
		btnFetchDetails.setBounds(273, 27, 126, 23);
		btnFetchDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="select item.Iname,item.IType,item.Features,item.quantity,indent.timeline,indent.Idate from item inner join indent on (item.intendorId=indent.uname) where (indent.approvedByHoD='yes' and approvedByDir='yes' and approvedByFO='yes' and POGenrated='no')";
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					if(rs.next())
				    {
				    	DisplayTendor dv=new DisplayTendor();
						dv.setVisible(true);
				    	
				    }
					else
					{
						JOptionPane.showMessageDialog(null, "No such vendors found!");
                     }
					 
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		contentPane.add(btnFetchDetails);
	}
}
