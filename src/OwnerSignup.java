import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
//import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class OwnerSignup {

	private JFrame frmOwnerSignup;
	private JTextField textField;
	private JTextField textField2;
	private JPasswordField passwordField;
	private JTextField textField1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OwnerSignup window = new OwnerSignup();
					window.frmOwnerSignup.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OwnerSignup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOwnerSignup = new JFrame();
		frmOwnerSignup.setTitle("Owner signup ");
		frmOwnerSignup.getContentPane().setFont(new Font("Georgia", Font.BOLD, 17));
		frmOwnerSignup.setBounds(0,0,1920, 1080);
		frmOwnerSignup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOwnerSignup.getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("RENT FORUM");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(841, 76, 219, 70);
		frmOwnerSignup.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("Owner Signup");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(828, 225, 257, 70);
		frmOwnerSignup.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("UserName");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Snap ITC", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(781, 456, 106, 31);
		frmOwnerSignup.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Snap ITC", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(781, 540, 106, 32);
		frmOwnerSignup.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Contact no");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Snap ITC", Font.PLAIN, 17));
		lblNewLabel_6.setBounds(764, 625, 134, 29);
		frmOwnerSignup.getContentPane().add(lblNewLabel_6);

		textField = new JTextField();
		textField.setBounds(972, 457, 220, 31);
		frmOwnerSignup.getContentPane().add(textField);
		textField.setColumns(10);

		textField2 = new JTextField();
		textField2.setBounds(972, 623, 220, 31);
		frmOwnerSignup.getContentPane().add(textField2);
		textField2.setColumns(10);

		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.setFont(new Font("Georgia", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String ownerid=textField1.getText();
				String name = textField.getText();
				@SuppressWarnings("deprecation")
				String password=passwordField.getText();
				String contact = textField2.getText();
				if (ownerid==null || name == null || name.trim().length() == 0 || 
						password== null ||name.trim().length() == 0 || contact == null
						|| contact.trim().length() == 0) 
				{

					JOptionPane.showMessageDialog(null,
							"Please Enter all the Fields");

				} else if (contact.length()!= 10) 
				{
					JOptionPane.showMessageDialog(null,"enter valid phone number");
				} 
				else
				{
					try 
					{
						
						//JOptionPane.showMessageDialog(null,"Please"+ownerid+" "+name+" "+ password);

						String query="insert into OWNER values('"+ownerid+"','"+name + "','"+ password +"',"+contact+")";
						Connection con2= DB.getConnection();
						PreparedStatement  stmt= con2.prepareStatement(query);
						//JOptionPane.showMessageDialog(null,query);
						
						/*CallableStatement stmt=con2.prepareCall("{ call PROC(?,?,?,?)}");
						stmt.setString(1,ownerid);
						stmt.setString(2, name);
						stmt.setString(3, password);
						stmt.setString(4,contact);*/
						stmt.execute();
						JOptionPane.showMessageDialog(null,"SignUp successful");
						con2.close();
					} 
					catch (SQLException e1) 
					{
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnNewButton.setBounds(764, 723, 123, 32);
		frmOwnerSignup.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setFont(new Font("Georgia", Font.BOLD, 17));
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				textField1.setText("");
				textField.setText("");
				passwordField.setText("");
				textField2.setText("");
			}
		});
		btnNewButton_1.setBounds(1049, 723, 95, 32);
		frmOwnerSignup.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.setFont(new Font("Georgia", Font.BOLD, 17));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{   
				frmOwnerSignup.setVisible(false);
				Home.main(null);
			}
		});
		btnNewButton_3.setBounds(1626, 865, 106, 32);
		frmOwnerSignup.getContentPane().add(btnNewButton_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(972, 540, 220, 32);
		frmOwnerSignup.getContentPane().add(passwordField);
		
		JLabel lblNewLabel = new JLabel("owner id");
		lblNewLabel.setFont(new Font("Snap ITC", Font.PLAIN, 17));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(781, 372, 95, 31);
		frmOwnerSignup.getContentPane().add(lblNewLabel);
		
		textField1 = new JTextField();
		textField1.setBounds(973, 372, 219, 31);
		frmOwnerSignup.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\DBMSProject\\Rental\\Rental_management_system\\src\\images\\10.jpg"));
		lblNewLabel_2.setBounds(0, 0, 1902, 1033);
		frmOwnerSignup.getContentPane().add(lblNewLabel_2);
	}
}
