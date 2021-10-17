import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class updaterent {

	private JFrame frmRentUpdate;
	private JTextField textField;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updaterent window = new updaterent();
					window.frmRentUpdate.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public updaterent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frmRentUpdate = new JFrame();
		frmRentUpdate.setTitle("Rent update ");
		frmRentUpdate.getContentPane().setFont(new Font("Georgia", Font.BOLD, 20));
		frmRentUpdate.setBounds(0, 00,1920, 1080);
		frmRentUpdate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRentUpdate.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RENT FORUM");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(788, 94, 255, 50);
		frmRentUpdate.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("LogOut");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frmRentUpdate.setVisible(false);
				Home.main(null);
			}
		});
		btnNewButton.setFont(new Font("Georgia", Font.BOLD, 20));
		btnNewButton.setBounds(1640, 880, 118, 33);
		frmRentUpdate.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("Georgia", Font.PLAIN, 13));
		textField.setBounds(1205, 495, 180, 33);
		frmRentUpdate.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Remove");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String houseid=textField.getText();
			     if (houseid== null || houseid.trim().length() == 0)
			     {
			    	 JOptionPane.showMessageDialog(null, "enter the valid houseid");
			     }
			     else
			     {
			    	 try 
			    	 {
							String query="delete from register where r_houseid='"+textField.getText()+"'";
							Connection con = DB.getConnection();
							PreparedStatement st = con.prepareStatement(query);
							st.execute();
							JOptionPane.showMessageDialog(null, "removed successfully");
							con.close();
					 }
			    	 catch (Exception e) 
			    	 {
							System.out.println(e);
					 }
			     }
			}
		});
		btnNewButton_1.setFont(new Font("Georgia", Font.BOLD, 20));
		btnNewButton_1.setBounds(1231, 577, 129, 33);
		frmRentUpdate.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("House Reg no*");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(398, 410, 180, 35);
		frmRentUpdate.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contact no*");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(398, 502, 180, 33);
		frmRentUpdate.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Rent Amount*");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(398, 577, 192, 54);
		frmRentUpdate.getContentPane().add(lblNewLabel_3);
		
		textField1 = new JTextField();
		textField1.setBounds(620, 410, 153, 31);
		frmRentUpdate.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setBounds(620, 501, 153, 31);
		frmRentUpdate.getContentPane().add(textField2);
		textField2.setColumns(10);
		
		textField3 = new JTextField();
		textField3.setBounds(620, 591, 153, 33);
		frmRentUpdate.getContentPane().add(textField3);
		textField3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Modification of registered house");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(701, 230, 464, 81);
		frmRentUpdate.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frmRentUpdate.setVisible(false);
				RentReg.main(null);
			}
		});
		btnNewButton_2.setFont(new Font("Georgia", Font.BOLD, 20));
		btnNewButton_2.setBounds(925, 855, 118, 33);
		frmRentUpdate.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				 String houseid=textField1.getText();
				 String contactno=textField2.getText();
				 String rentamount=textField3.getText();
			     if (houseid== null || houseid.trim().length() == 0 || contactno==null || contactno.trim().length()==0 ||
			    		 rentamount==null || rentamount.trim().length()==0)
			     {
			    	 JOptionPane.showMessageDialog(null, "enter the valid details");
			     }
			     else if(contactno.trim().length()!=10)
			     {
			    	 JOptionPane.showMessageDialog(null, "enter the valid phone number");
			     }
			     else
			     {
			    	 try {
							String query="update register set r_houseid='"+textField1.getText()+"',r_contactno='"+textField2.getText()+"',r_rentamount='"+textField3.getText()+"' where r_houseid='"+textField1.getText()+"'";
							Connection con = DB.getConnection();
							PreparedStatement st = con.prepareStatement(query);
							st.execute();
							JOptionPane.showMessageDialog(null, "table updated successfully");
							con.close();
						}
			    	 catch (Exception e) 
			    	 {
							System.out.println(e);
					 }
			     }
			}
		});
		btnNewButton_3.setFont(new Font("Georgia", Font.BOLD, 20));
		btnNewButton_3.setBounds(443, 691, 135, 33);
		frmRentUpdate.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Reset");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				textField1.setText("");
				textField2.setText("");
				textField3.setText("");
			}
		});
		btnNewButton_4.setFont(new Font("Georgia", Font.BOLD, 20));
		btnNewButton_4.setBounds(674, 691, 104, 33);
		frmRentUpdate.getContentPane().add(btnNewButton_4);
		
		JLabel lblNewLabel_5 = new JLabel("For Deletion");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Snap ITC", Font.PLAIN, 25));
		lblNewLabel_5.setBounds(1069, 395, 268, 50);
		frmRentUpdate.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("House Reg no");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(994, 492, 187, 43);
		frmRentUpdate.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setIcon(new ImageIcon("D:\\DBMSProject\\Rental\\Rental_management_system\\src\\images\\13.jpg"));
		lblNewLabel_7.setBounds(0, 0, 1902, 1033);
		frmRentUpdate.getContentPane().add(lblNewLabel_7);
	}
}
