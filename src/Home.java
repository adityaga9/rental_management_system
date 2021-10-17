import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class Home 
{
	private JFrame frmHomePage;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField1;
	private JPasswordField passwordField1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Home window = new Home();
					window.frmHomePage.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home()
	{
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frmHomePage = new JFrame();
		frmHomePage.setForeground(new Color(0, 0, 205));
		frmHomePage.setFont(new Font("Dubai Medium", Font.BOLD, 12));
		frmHomePage.setTitle("Home page");
		frmHomePage.getContentPane().setFont(new Font("Georgia", Font.BOLD, 16));
		frmHomePage.getContentPane().setBackground(UIManager.getColor("Button.light"));
		frmHomePage.setBounds(00, 00, 1920 , 1080);
		frmHomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHomePage.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("WELCOME TO RENTAL MANAEGMENT SYSTEM");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(447, 89, 937, 54);
		frmHomePage.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Owner Login");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Snap ITC", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(341, 299, 234, 53);
		frmHomePage.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Buyers Login");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Snap ITC", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(1225, 298, 253, 54);
		frmHomePage.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("buyer id");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(1178, 438, 145, 38);
		frmHomePage.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(1178, 532, 145, 38);
		frmHomePage.getContentPane().add(lblNewLabel_4);

		textField = new JTextField();
		textField.setBounds(1404, 441, 165, 38);
		frmHomePage.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnNewButton_2 = new JButton("SignUp");
		btnNewButton_2.setFont(new Font("Georgia", Font.BOLD, 16));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frmHomePage.setVisible(false);
				BuyerSignup.main(null);
			}
		});
		btnNewButton_2.setBounds(1433, 640, 106, 38);
		frmHomePage.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Admin");
		btnNewButton_3.setFont(new Font("Georgia", Font.BOLD, 16));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frmHomePage.setVisible(false);
				admin.main(null);
			}
		});
		btnNewButton_3.setBounds(815, 862, 106, 38);
		frmHomePage.getContentPane().add(btnNewButton_3);

		JSeparator separator = new JSeparator();
		separator.setBounds(258, 261, 1, 131);
		frmHomePage.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(278, 110, 1, 282);
		frmHomePage.getContentPane().add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(299, 250, -79, -75);
		frmHomePage.getContentPane().add(separator_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(1404, 535, 165, 38);
		frmHomePage.getContentPane().add(passwordField);
		
		JButton btnNewButton_4 = new JButton("Signup");
		btnNewButton_4.setFont(new Font("Georgia", Font.BOLD, 16));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frmHomePage.setVisible(false);
				OwnerSignup.main(null);
			}
		});
		btnNewButton_4.setBounds(551, 640, 106, 38);
		frmHomePage.getContentPane().add(btnNewButton_4);
		
		JLabel lblNewLabel_5 = new JLabel("owner id");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBackground(UIManager.getColor("TextPane.selectionBackground"));
		lblNewLabel_5.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(299, 424, 125, 38);
		frmHomePage.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Password");
		lblNewLabel_6.setBackground(new Color(0, 0, 0));
		lblNewLabel_6.setForeground(new Color(240, 248, 255));
		lblNewLabel_6.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(279, 530, 145, 38);
		frmHomePage.getContentPane().add(lblNewLabel_6);
		
		textField1 = new JTextField();
		textField1.setBounds(480, 424, 165, 40);
		frmHomePage.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		passwordField1 = new JPasswordField();
		passwordField1.setBounds(480, 532, 165, 40);
		frmHomePage.getContentPane().add(passwordField1);
		
		JButton btnownerlogin = new JButton("Login");
		btnownerlogin.setFont(new Font("Georgia", Font.BOLD, 16));
		btnownerlogin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					Connection con = DB.getConnection();
					Statement st = con.createStatement();
					@SuppressWarnings("deprecation")
					ResultSet rs = st.executeQuery("select o_ownerid,o_password from owner where o_ownerid='"
									+ textField1.getText()
									+ "' and o_password='"
									+ passwordField1.getText()+"'");

					if (rs.next()) 
					{
						JOptionPane.showMessageDialog(null, "login success");
						frmHomePage.setVisible(false);
						RentReg.main(null);

					} 
					else 
					{
						JOptionPane.showMessageDialog(null,
								"invalid credentials");
						
					}
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
		btnownerlogin.setBounds(299, 640, 106, 38);
		frmHomePage.getContentPane().add(btnownerlogin);
		
		JButton btnbuyerlogin = new JButton("Login");
		btnbuyerlogin.setFont(new Font("Georgia", Font.BOLD, 16));
		btnbuyerlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					Connection con = DB.getConnection();
					Statement st = con.createStatement();
					@SuppressWarnings("deprecation")
					ResultSet rs = st.executeQuery("select b_buyerid,b_password from buyer where b_buyerid='"
									+ textField.getText()
									+ "' and b_password='"
									+ passwordField.getText() + "'");
					if (rs.next()) 
					{
						JOptionPane.showMessageDialog(null, "login success");
						frmHomePage.setVisible(false);
						View.main(null);
					} 
					else 
					{
						JOptionPane.showMessageDialog(null,
								"invalid credentials");
					}
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
		btnbuyerlogin.setBounds(1217, 640, 106, 38);
		frmHomePage.getContentPane().add(btnbuyerlogin);
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setFont(new Font("Georgia", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				System.exit(1);
			}
		});
		btnNewButton.setBounds(1506, 910, 106, 38);
		frmHomePage.getContentPane().add(btnNewButton);
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBackground(Color.WHITE);
		lblNewLabel_7.setIcon(new ImageIcon("D:\\DBMSProject\\Rental\\Rental_management_system\\src\\images\\07.jpg"));
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBounds(0, 0, 1902, 1033);
		frmHomePage.getContentPane().add(lblNewLabel_7);
	}
}
