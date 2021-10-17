import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class Qryslnowner {

	private JFrame frmOwnerQrysln;
	private JTable table;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField textField2;
	private JPasswordField passwordField1;
	private JButton btnNewButton1;
	private JLabel lblNewLabel_6;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JTextArea textArea_1;
	private JLabel lblNewLabel_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Qryslnowner window = new Qryslnowner();
					window.frmOwnerQrysln.setVisible(true);
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
	public Qryslnowner() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void load()
	{
		DefaultTableModel model=new DefaultTableModel(new String[]{"BUYER ID","QUERY"},0);
		try 
		{
			String sql="SELECT q_buyerid,QUERY FROM BUYERQUERY";
			Connection conn=DB.getConnection();
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				String buyerid=rs.getString("q_buyerid");
				String query=rs.getString("query");
				model.addRow(new Object[] {buyerid,query});
			}
			table.setModel(model);
            conn.close();
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void load1()
	{
		DefaultTableModel model=new DefaultTableModel(new String[]{"BUYER ID","QUERY","SOLUTION"},0);
		try 
		{
			String sql="SELECT B.Q_BUYERID,B.QUERY,S.SOLUTION FROM BUYERQUERY B,OWNERSOLUTION S";
			Connection conn=DB.getConnection();
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				String buyerid=rs.getString("Q_BUYERID");
				String query=rs.getString("query");
				String solution=rs.getString("solution");
				//String solution=rs.getString("solution");
				model.addRow(new Object[] {buyerid,query,solution});
			}
			table.setModel(model);
            conn.close();
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void load2()
	{
		DefaultTableModel model=new DefaultTableModel(new String[]{"BUYER ID","QUERY"},0);
		try 
		{
			String sql="SELECT * FROM BUYERQUERY";
			Connection conn=DB.getConnection();
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				String buyerid=rs.getString("Q_BUYERID");
				String query=rs.getString("query");
				model.addRow(new Object[] {buyerid,query});
			}
			table.setModel(model);
            conn.close();
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void initialize() {
		frmOwnerQrysln = new JFrame();
		frmOwnerQrysln.setTitle("Owner qrysln");
		frmOwnerQrysln.setBounds(0, 0, 1920,1080);
		frmOwnerQrysln.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOwnerQrysln.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(749, 434, 895, 155);
		frmOwnerQrysln.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		load2();
			
			lblNewLabel_3 = new JLabel("owner id");
			lblNewLabel_3.setForeground(Color.WHITE);
			lblNewLabel_3.setFont(new Font("Snap ITC", Font.PLAIN, 17));
			lblNewLabel_3.setBounds(192, 434, 109, 28);
			frmOwnerQrysln.getContentPane().add(lblNewLabel_3);
			
			lblNewLabel_4 = new JLabel("Password");
			lblNewLabel_4.setForeground(Color.WHITE);
			lblNewLabel_4.setFont(new Font("Snap ITC", Font.PLAIN, 17));
			lblNewLabel_4.setBounds(192, 508, 109, 28);
			frmOwnerQrysln.getContentPane().add(lblNewLabel_4);
			
			lblNewLabel_5 = new JLabel("solution");
			lblNewLabel_5.setForeground(Color.WHITE);
			lblNewLabel_5.setFont(new Font("Snap ITC", Font.PLAIN, 17));
			lblNewLabel_5.setBounds(192, 583, 109, 27);
			frmOwnerQrysln.getContentPane().add(lblNewLabel_5);
			
			textField2 = new JTextField();
			textField2.setBounds(328, 435, 129, 28);
			frmOwnerQrysln.getContentPane().add(textField2);
			textField2.setColumns(10);
			
			passwordField1 = new JPasswordField();
			passwordField1.setBounds(328, 509, 129, 28);
			frmOwnerQrysln.getContentPane().add(passwordField1);
			
			btnNewButton1 = new JButton("Submit");
			btnNewButton1.setFont(new Font("Georgia", Font.BOLD, 16));
			btnNewButton1.addActionListener(new ActionListener() 
			{
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) 
				{
					
					try {
						Connection con = DB.getConnection();
						Statement st = con.createStatement();
						ResultSet rs;
						rs = st.executeQuery("select o_ownerid,o_password from owner where o_ownerid='"
										+ textField2.getText()
										+ "' and o_password='"
										+ passwordField1.getText() + "'");
						if (rs.next()) 
						{
							try {
								String query="insert into ownersolution(o_ownerid,solution) values(?,?)";
								Connection con1 = DB.getConnection();
								PreparedStatement st11 = con1.prepareStatement(query);
								st11.setString(1, textField2.getText());
								//st11.setString(2, passwordField.getText());
								st11.setString(2, textArea_1.getText());
								//st11.setString(4, textField3.getText());
								st11.execute();
							    JOptionPane.showMessageDialog(null, "solution submitted");
							    load1();
							    con1.close();
							} 
							catch (SQLException e1) 
							{
								//TODO Auto-generated catch block
								e1.printStackTrace();
							}

						} 
						else 
						{
							JOptionPane.showMessageDialog(null,
									"invalid credentials");
						}
						con.close();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

				}
			});
			btnNewButton1.setBounds(212, 709, 98, 33);
			frmOwnerQrysln.getContentPane().add(btnNewButton1);
			
			lblNewLabel_6 = new JLabel("RENT FORUM");
			lblNewLabel_6.setForeground(Color.WHITE);
			lblNewLabel_6.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
			lblNewLabel_6.setBounds(862, 62, 209, 55);
			frmOwnerQrysln.getContentPane().add(lblNewLabel_6);
			
			btnNewButton_2 = new JButton("Reset");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					textField2.setText("");
					passwordField1.setText("");
					textArea_1.setText("");
				}
			});
			btnNewButton_2.setFont(new Font("Georgia", Font.BOLD, 16));
			btnNewButton_2.setBounds(399, 709, 89, 32);
			frmOwnerQrysln.getContentPane().add(btnNewButton_2);
			
			btnNewButton_3 = new JButton("Back");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					frmOwnerQrysln.setVisible(false);
					RentReg.main(null);
				}
			});
			btnNewButton_3.setFont(new Font("Georgia", Font.BOLD, 17));
			btnNewButton_3.setBounds(1696, 902, 109, 29);
			frmOwnerQrysln.getContentPane().add(btnNewButton_3);
			
			textArea_1 = new JTextArea();
			textArea_1.setBounds(328, 583, 293, 55);
			frmOwnerQrysln.getContentPane().add(textArea_1);
			
			JLabel lblNewLabel_8 = new JLabel("Solution");
			lblNewLabel_8.setForeground(Color.WHITE);
			lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_8.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
			lblNewLabel_8.setBounds(223, 365, 171, 40);
			frmOwnerQrysln.getContentPane().add(lblNewLabel_8);
			
			lblNewLabel_9 = new JLabel("");
			lblNewLabel_9.setIcon(new ImageIcon("D:\\DBMSProject\\Rental\\Rental_management_system\\src\\images\\15.jpg"));
			lblNewLabel_9.setBounds(0, 0, 1902, 1033);
			frmOwnerQrysln.getContentPane().add(lblNewLabel_9);
			
		
		
	}
}
