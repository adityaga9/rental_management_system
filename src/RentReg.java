import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.Color;

public class RentReg {

	private JFrame frmRentForm;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	private JTextField textField7;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RentReg window = new RentReg();
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
	public RentReg() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void feedback()
	{
		DefaultTableModel model = new DefaultTableModel(new String[] 
				{
				"HOUSEID", "BUYERNAME", "FEEDBACK", "RATING" }, 0);
		try {
			String sql = "SELECT * FROM feedback";
			Connection conn = DB.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) 
			{
				String houseid = rs.getString("houseid");
				String buyer = rs.getString("f_buyername");
				String feedback = rs.getString("feedback");
				String rating = rs.getString("f_rating");
				model.addRow(new Object[] { houseid, buyer, feedback, rating });
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
	public void register()
	{
		DefaultTableModel model=new DefaultTableModel(new String[]{"HOUSEID","OWNERID","CONTACTNO","ADDRESS","RENTAMOUNT","ROOMS"},0);
		try 
		{
			String sql="SELECT * FROM REGISTER";
			Connection conn=DB.getConnection();
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				String houseid=rs.getString("r_houseid");
				String ownerid=rs.getString("r_ownerid");
				String contact=rs.getString("r_contactno");
				String address=rs.getString("r_address");
				String rentamt=rs.getString("r_rentamount");
				String rooms=rs.getString("r_rooms");
				model.addRow(new Object[] {houseid,ownerid,contact,address,rentamt,rooms});
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
		frmRentForm = new JFrame();
		frmRentForm.setForeground(new Color(0, 0, 205));
		frmRentForm.setFont(new Font("Dubai Medium", Font.BOLD, 12));
		frmRentForm.setTitle("Rent Register");
		frmRentForm.getContentPane().setFont(new Font("Elephant", Font.PLAIN, 17));
		frmRentForm.setBounds(0,0,1920, 1080);
		frmRentForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRentForm.getContentPane().setLayout(null);
		
		JLabel lblRentForum = new JLabel("Rent Forum");
		lblRentForum.setForeground(Color.WHITE);
		lblRentForum.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
		lblRentForum.setHorizontalAlignment(SwingConstants.CENTER);
		lblRentForum.setBounds(783, 56, 328, 77);
		frmRentForm.getContentPane().add(lblRentForum);
		
		JLabel newlabel1 = new JLabel("renthouse id");
		newlabel1.setForeground(Color.WHITE);
		newlabel1.setFont(new Font("Snap ITC", Font.PLAIN, 17));
		newlabel1.setBounds(237, 310, 131, 33);
		frmRentForm.getContentPane().add(newlabel1);
		
		JLabel newlabel4 = new JLabel("Contact no");
		newlabel4.setForeground(Color.WHITE);
		newlabel4.setFont(new Font("Snap ITC", Font.PLAIN, 17));
		newlabel4.setBounds(237, 445, 131, 33);
		frmRentForm.getContentPane().add(newlabel4);
		
		JLabel newlabel5 = new JLabel("Address");
		newlabel5.setForeground(Color.WHITE);
		newlabel5.setFont(new Font("Snap ITC", Font.PLAIN, 17));
		newlabel5.setBounds(237, 520, 131, 23);
		frmRentForm.getContentPane().add(newlabel5);
		
		textField1 = new JTextField();
		textField1.setBounds(406, 312, 137, 33);
		frmRentForm.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setBounds(406, 375, 137, 33);
		frmRentForm.getContentPane().add(textField2);
		textField2.setColumns(10);
		
		textField4 = new JTextField();
		textField4.setBounds(406, 445, 137, 33);
		frmRentForm.getContentPane().add(textField4);
		textField4.setColumns(10);
		
		JLabel newlabel2 = new JLabel("owner id");
		newlabel2.setForeground(Color.WHITE);
		newlabel2.setFont(new Font("Snap ITC", Font.PLAIN, 17));
		newlabel2.setBounds(237, 378, 131, 23);
		frmRentForm.getContentPane().add(newlabel2);
		
		textField5 = new JTextField();
		textField5.setBounds(406, 510, 137, 33);
		frmRentForm.getContentPane().add(textField5);
		textField5.setColumns(10);
		
		JLabel newlabel6 = new JLabel("Rent Amount");
		newlabel6.setForeground(Color.WHITE);
		newlabel6.setFont(new Font("Snap ITC", Font.PLAIN, 17));
		newlabel6.setBounds(237, 576, 131, 33);
		frmRentForm.getContentPane().add(newlabel6);
		
		textField6 = new JTextField();
		textField6.setBounds(406, 576, 137, 33);
		frmRentForm.getContentPane().add(textField6);
		textField6.setColumns(10);
		
		JLabel newlabel7 = new JLabel("Rooms");
		newlabel7.setForeground(Color.WHITE);
		newlabel7.setFont(new Font("Snap ITC", Font.PLAIN, 17));
		newlabel7.setBounds(237, 647, 115, 26);
		frmRentForm.getContentPane().add(newlabel7);
		
		textField7 = new JTextField();
		textField7.setBounds(406, 646, 137, 33);
		frmRentForm.getContentPane().add(textField7);
		textField7.setColumns(10);
		
		JButton btnNewButton = new JButton("View");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				//Adminactions.Interested();
				DefaultTableModel model = new DefaultTableModel(new String[] {
						"BUEYRID", "HOUSEID" }, 0);

				try {
					String sql = "SELECT * FROM INTEREST";
					Connection conn = DB.getConnection();
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery(sql);
					while (rs.next()) {
						String buyer = rs.getString("i_buyerid");
						String house = rs.getString("i_houseid");
						model.addRow(new Object[] { buyer, house });
					}
					table.setModel(model);
					conn.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e);
				}

			}
		});
		btnNewButton.setFont(new Font("Georgia", Font.BOLD, 20));
		btnNewButton.setBounds(1498, 808, 122, 33);
		frmRentForm.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frmRentForm.setVisible(false);
				updaterent.main(null);
				
			}
		});
		btnNewButton_1.setFont(new Font("Georgia", Font.BOLD, 20));
		btnNewButton_1.setBounds(1211, 808, 122, 33);
		frmRentForm.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frmRentForm.setVisible(false);
				Home.main(null);
			}
		});
		btnNewButton_2.setFont(new Font("Georgia", Font.BOLD, 20));
		btnNewButton_2.setBounds(1697, 946, 122, 33);
		frmRentForm.getContentPane().add(btnNewButton_2);
		
		JButton btnregister = new JButton("Register");
		btnregister.addActionListener(new ActionListener() {
			//private JLabel textField3;

			public void actionPerformed(ActionEvent arg0) 
			{
				String houseid = textField1.getText();
				String ownerid = textField2.getText();
				String contact= textField4.getText();
				String address=textField5.getText();
				String rentamount=textField6.getText();
				String rooms=textField7.getText();

				if (houseid == null || houseid.trim().length() == 0 || ownerid == null ||ownerid.trim().length() == 0
						|| contact == null
						|| contact.trim().length() == 0 || address==null || address.trim().length()==0 || rentamount==null ||
						rentamount.trim().length()==0 || rooms==null || rooms.trim().length()==0) {
					JOptionPane.showMessageDialog(null, "Please Enter all the Fields");
				} else if (contact.trim().length() != 10) 
				{
					JOptionPane.showMessageDialog(null, "Please Enter the valid phone number");
				}
				else 
				{
					try
					{
						String query="insert into register(r_houseid,r_ownerid,r_contactno,r_address,r_rentamount,r_rooms) values(?,?,?,?,?,?)";
						Connection con1 = DB.getConnection();
						PreparedStatement st11 = con1.prepareStatement(query);
						st11.setString(1, textField1.getText());
						st11.setString(2, textField2.getText());
						st11.setString(3, textField4.getText());
						st11.setString(4, textField5.getText());
						st11.setString(5, textField6.getText());
						st11.setString(6, textField7.getText());
						st11.execute();
					    JOptionPane.showMessageDialog(null, "data inserted successfully");
					    register();
					    con1.close();
					} 
					catch (SQLException e) 
					{
						//TODO Auto-generated catch block
						//e.printStackTrace();
						JOptionPane.showMessageDialog(null,e);
					}
				}
			}
		});
		btnregister.setFont(new Font("Georgia", Font.BOLD, 20));
		btnregister.setBounds(237, 741, 131, 33);
		frmRentForm.getContentPane().add(btnregister);
		
		JButton btnreset = new JButton("Reset");
		btnreset.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				textField1.setText("");
				textField2.setText("");
				textField4.setText("");
				textField5.setText("");
				textField6.setText("");
				textField7.setText("");
			}
		});
		btnreset.setFont(new Font("Georgia", Font.BOLD, 20));
		btnreset.setBounds(428, 741, 115, 33);
		frmRentForm.getContentPane().add(btnreset);
		
		JLabel lblNewLabel = new JLabel("click update for modifications\r\n of registered house");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(1117, 854, 300, 33);
		frmRentForm.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("click to view the interested buyers");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(1448, 862, 252, 25);
		frmRentForm.getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(767, 388, 841, 135);
		frmRentForm.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_3 = new JButton("Load");
		btnNewButton_3.setFont(new Font("Georgia", Font.BOLD, 20));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				register();
			}
		});
		btnNewButton_3.setBounds(359, 808, 102, 33);
		frmRentForm.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("View Feedback");
		btnNewButton_4.setFont(new Font("Georgia", Font.BOLD, 20));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frmRentForm.setVisible(false);
				Qryslnowner.main(null);
			}
		});
		btnNewButton_4.setBounds(791, 822, 201, 33);
		frmRentForm.getContentPane().add(btnNewButton_4);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setIcon(new ImageIcon("D:\\DBMSProject\\Rental\\Rental_management_system\\src\\images\\16.jpg"));
		lblNewLabel_2.setBounds(0, 0, 1902, 1033);
		frmRentForm.getContentPane().add(lblNewLabel_2);
		register();
		
		
	}
}
