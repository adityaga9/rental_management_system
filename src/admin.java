import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class admin {

	private JFrame frmAdminLogin;
	private JTextField textuser;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin window = new admin();
					window.frmAdminLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminLogin = new JFrame();
		frmAdminLogin.setTitle("Admin login");
		frmAdminLogin.setSize(new Dimension(461, 313));
		frmAdminLogin.setResizable(true);
		frmAdminLogin.setBounds(0, 0, 1920, 1080);
		frmAdminLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminLogin.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("ADMIN LOGIN");
		lblNewLabel.setForeground(new Color(245, 245, 245));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(719, 200, 510, 86);
		frmAdminLogin.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("username");
		lblNewLabel_1.setForeground(new Color(245, 245, 245));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(781, 417, 139, 52);
		frmAdminLogin.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(new Color(245, 245, 245));
		lblNewLabel_2.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(781, 550, 163, 52);
		frmAdminLogin.getContentPane().add(lblNewLabel_2);

		textuser = new JTextField();
		textuser.setBounds(991, 420, 152, 52);
		frmAdminLogin.getContentPane().add(textuser);
		textuser.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(991, 555, 152, 49);
		frmAdminLogin.getContentPane().add(passwordField);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Georgia", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection con = DB.getConnection();
					Statement st = con.createStatement();
					@SuppressWarnings("deprecation")
					ResultSet rs = st.executeQuery("select userid,password from admin where userid='"
									+ textuser.getText()
									+ "' and password='"
									+ passwordField.getText() + "'");
					//rs.insertRow();

					if (rs.next()) 
					{
						JOptionPane.showMessageDialog(null, "login success");
						frmAdminLogin.setVisible(false);
						Adminactions.main(null);

					} 
					else 
					{
						JOptionPane.showMessageDialog(null,"invalid credentials");
					}
					con.close();
					
				} 
				catch (Exception e) 
				{
					System.out.println(e);
				}
			}
		});
		btnNewButton.setBounds(781, 716, 114, 33);
		frmAdminLogin.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Georgia", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frmAdminLogin.setVisible(false);
				Home.main(null);

			}
		});
		btnNewButton_1.setBounds(1667, 877, 102, 33);
		frmAdminLogin.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Reset");
		btnNewButton_2.setFont(new Font("Georgia", Font.BOLD, 16));
		btnNewButton_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				textuser.setText("");
				passwordField.setText("");
			}
		});
		btnNewButton_2.setBounds(1009, 716, 102, 33);
		frmAdminLogin.getContentPane().add(btnNewButton_2);
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setForeground(Color.CYAN);
		lblNewLabel_3.setIcon(new ImageIcon("D:\\DBMSProject\\Rental\\Rental_management_system\\src\\images\\11.jpg"));
		lblNewLabel_3.setBounds(0, 0, 1902, 1033);
		frmAdminLogin.getContentPane().add(lblNewLabel_3);
		
		JLabel lblUserid = new JLabel("userid");
		lblUserid.setBounds(545, 239, 56, 16);
		frmAdminLogin.getContentPane().add(lblUserid);
	}
}
