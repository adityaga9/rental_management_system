import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.SystemColor;

public class BuyerSignup 
{
	private JFrame frmRentForm;
	private JTextField textField1;
	private JTextField textField2;
	private JPasswordField passwordField;
	private JTextField textField3;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyerSignup window = new BuyerSignup();
					window.frmRentForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public BuyerSignup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRentForm = new JFrame();
		frmRentForm.setTitle("Buyer signup");
		frmRentForm.getContentPane().setBackground(SystemColor.activeCaption);
		frmRentForm.getContentPane().setFont(new Font("Dialog", Font.BOLD, 17));
		frmRentForm.setBounds(0, 0, 1920, 1080);
		frmRentForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRentForm.getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("username");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Snap ITC", Font.PLAIN, 17));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(841, 394, 99, 38);
		frmRentForm.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Snap ITC", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(841, 482, 99, 27);
		frmRentForm.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Contact no");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Snap ITC", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(841, 562, 117, 28);
		frmRentForm.getContentPane().add(lblNewLabel_3);

		textField1 = new JTextField();
		textField1.setBounds(1011, 401, 207, 27);
		frmRentForm.getContentPane().add(textField1);
		textField1.setColumns(10);

		textField2 = new JTextField();
		textField2.setColumns(10);
		textField2.setBounds(1011, 563, 207, 30);
		frmRentForm.getContentPane().add(textField2);

		JLabel lblNewLabel_4 = new JLabel("Buyer Sign up");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_4.setBounds(859, 198, 347, 71);
		frmRentForm.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("RENT FORUM");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(750, 72, 399, 41);
		frmRentForm.getContentPane().add(lblNewLabel_5);

		JButton btnNewButton = new JButton("Signup");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) 
			{
				String userid=textField.getText();
				String username = textField1.getText();
				String password = passwordField.getText();
				String contact = textField2.getText();
				String address= textField3.getText();

				if (userid==null || username == null || username.trim().length() == 0 || address == null || address.trim().length() == 0
						|| password == null || password.trim().length() == 0 || contact == null
						|| contact.trim().length() == 0) {
					JOptionPane.showMessageDialog(null, "Please Enter all the Fields");
				} else if (contact.trim().length() != 10) {
					JOptionPane.showMessageDialog(null, "Please Enter all the valid phone number");
				}
				else 
				{
					try {
						String query="insert into buyer(b_buyerid,b_buyername,b_password,b_contactno,address) values(?,?,?,?,?)";
						Connection con1 = DB.getConnection();
						PreparedStatement st11 = con1.prepareStatement(query);
						st11.setString(1,userid);
						st11.setString(2, username);
						st11.setString(3, password);
						st11.setString(4, contact);
						st11.setString(5, address);
						st11.execute();
					    JOptionPane.showMessageDialog(null, "data inserted successfully");
					    con1.close();
					} 
					catch (SQLException e) 
					{
						//TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 17));
		btnNewButton.setBounds(892, 748, 99, 38);
		frmRentForm.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 17));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frmRentForm.setVisible(false);
				Home.main(null);
			}
		});
		btnNewButton_1.setBounds(1656, 869, 99, 38);
		frmRentForm.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				textField1.setText("");
				passwordField.setText("");
				textField2.setText("");
				textField3.setText("");
			}
		});
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 17));
		btnNewButton_2.setBounds(1132, 753, 87, 28);
		frmRentForm.getContentPane().add(btnNewButton_2);

		passwordField = new JPasswordField();
		passwordField.setBounds(1011, 482, 207, 29);
		frmRentForm.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_6 = new JLabel("Address");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Snap ITC", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(841, 645, 99, 28);
		frmRentForm.getContentPane().add(lblNewLabel_6);
		
		textField3 = new JTextField();
		textField3.setBounds(1011, 647, 207, 28);
		frmRentForm.getContentPane().add(textField3);
		textField3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("user id");
		lblNewLabel.setForeground(new Color(240, 255, 255));
		lblNewLabel.setFont(new Font("Snap ITC", Font.PLAIN, 17));
		lblNewLabel.setBounds(841, 315, 99, 27);
		frmRentForm.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(1011, 317, 207, 25);
		frmRentForm.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("D:\\DBMSProject\\Rental\\Rental_management_system\\src\\images\\08.jpg"));
		lblNewLabel_7.setBounds(0, 0, 1902, 1033);
		frmRentForm.getContentPane().add(lblNewLabel_7);
	}
}
