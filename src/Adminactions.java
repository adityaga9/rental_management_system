import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
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
import java.awt.Font;
//import java.awt.Window.Type;

public class Adminactions {

	private JFrame frmAdminAction;
	private JTextField textField;
	private JTextField textField1;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminactions window = new Adminactions();
					window.frmAdminAction.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Adminactions() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	public void mousepressed(MouseEvent e)
	{
		
		
	}
	public void load()
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
				String house=rs.getString("r_houseid");
				String ownerid=rs.getString("r_ownerid");
				String contact=rs.getString("r_contactno");
				String address=rs.getString("r_address");
				String rentamt=rs.getString("r_rentamount");
				String rooms=rs.getString("r_rooms");
				model.addRow(new Object[] {house,ownerid,contact,address,rentamt,rooms});
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
	public static void Interested()
	{
		DefaultTableModel model = new DefaultTableModel(new String[] {"BUYERID", "HOUSEID" }, 0);

		try {
			String sql = "SELECT * FROM INTEREST";
			Connection conn = DB.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String buyer = rs.getString("I_BUEYRID");
				String house = rs.getString("I_HOUSEID");
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
	
	public static void buyer()
	{
		DefaultTableModel model = new DefaultTableModel(new String[] 
				{
				"BUYERID","BUYER NAME", "CONTACT NO","ADDRESS"}, 0);
		try {
			String sql = "SELECT B_BUYERID,B_BUYERNAME,B_CONTACTNO,ADDRESS FROM BUYER";
			Connection conn = DB.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) 
			{
				String buyerid=rs.getString("B_BUYERID");
				String buyername = rs.getString("B_BUYERNAME");
				String contactno= rs.getString("B_CONTACTNO");
				String address= rs.getString("ADDRESS");
				model.addRow(new Object[] { buyerid,buyername,contactno,address });
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
	
	
	public static void owner()
	{
		DefaultTableModel model = new DefaultTableModel(new String[] 
				{
				"OWNERID","OWNERNAME", "CONTACT NO"}, 0);
		try {
			String sql = "SELECT O_OWNERID,O_OWNERNAME,O_CONTACTNO FROM OWNER";
			Connection conn = DB.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) 
			{
				String ownerid=rs.getString("O_OWNERID");
				String ownername = rs.getString("O_OWNERNAME");
				String contactno= rs.getString("O_CONTACTNO");
				model.addRow(new Object[] { ownerid,ownername,contactno  });
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
	public static void feedback()
	{
		DefaultTableModel model = new DefaultTableModel(new String[] 
				{
				"HOUSEID", "BUYERID", "FEEDBACK", "RATING" }, 0);
		try {
			String sql = "SELECT * FROM feedback";
			Connection conn = DB.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) 
			{
				String houseid = rs.getString("f_houseid");
				String buyerid = rs.getString("f_buyerid");
				String feedback = rs.getString("feedback");
				String rating = rs.getString("f_rating");
				model.addRow(new Object[] { houseid, buyerid, feedback, rating });
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
	private void initialize() 
	{
		frmAdminAction = new JFrame();
		frmAdminAction.setTitle("Admin action");
		frmAdminAction.getContentPane().setFont(new Font("Dialog", Font.BOLD, 14));
		frmAdminAction.setBounds(00, 00,1920, 1080);
		frmAdminAction.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("owner id");
		lblNewLabel.setFont(new Font("Snap ITC", Font.PLAIN, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(514, 706, 101, 31);
		
		JLabel lblNewLabel_1 = new JLabel("buyer id");
		lblNewLabel_1.setFont(new Font("Snap ITC", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(1092, 710, 87, 23);
		
		textField = new JTextField();
		textField.setBounds(676, 706, 132, 31);
		textField.setColumns(10);
		
		textField1 = new JTextField();
		textField1.setBounds(1238, 706, 132, 31);
		textField1.setColumns(10);
		
		JLabel lblRentForum = new JLabel("RENT FORUM");
		lblRentForum.setForeground(new Color(255, 250, 250));
		lblRentForum.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
		lblRentForum.setBounds(812, 71, 290, 66);
		lblRentForum.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("Rent Owner");
		lblNewLabel_2.setFont(new Font("Snap ITC", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(565, 647, 132, 33);
		
		JLabel lblNewLabel_3 = new JLabel("For Buyer");
		lblNewLabel_3.setFont(new Font("Snap ITC", Font.PLAIN, 15));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(1144, 647, 113, 32);
		
		JButton btnbuyer = new JButton("Remove");
		btnbuyer.setFont(new Font("Georgia", Font.BOLD, 13));
		btnbuyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String username=textField1.getText();
			     if (username == null || username.trim().length() == 0)
			     {
			    	 JOptionPane.showMessageDialog(null, "enter the buyer id");
			     }
			     else
			     {
			    	 try {
							String query="delete from buyer where b_buyerid='"+textField1.getText()+"'";
							Connection con = DB.getConnection();
							PreparedStatement st = con.prepareStatement(query);
							//ResultSet rs = st.executeQuery("delete from owner where o_ownername='"+textField+"'");
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
		btnbuyer.setBounds(1158, 772, 120, 33);
		
		
		
		JButton btnowner = new JButton("Remove");
		btnowner.setFont(new Font("Georgia", Font.BOLD, 13));
		btnowner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
					 String name=textField.getText();
				     if (name == null || name.trim().length() == 0)
				     {
				    	 JOptionPane.showMessageDialog(null, "enter the ownerid");
				     }
				     else
				     {
				    	 try {
								String query="delete from owner where o_ownerid='"+textField.getText()+"'";
								Connection con = DB.getConnection();
								PreparedStatement st = con.prepareStatement(query);
								//ResultSet rs = st.executeQuery("delete from owner where o_ownername='"+textField+"'");
								st.execute();
								JOptionPane.showMessageDialog(null, "removed successfully");
								load();
								con.close();
							}
				    	 catch (Exception e) {
								System.out.println(e);
							}
				     }
			}
		});
		btnowner.setBounds(590, 772, 120, 33);
		frmAdminAction.getContentPane().setLayout(null);
		frmAdminAction.getContentPane().add(lblNewLabel);
		frmAdminAction.getContentPane().add(lblNewLabel_1);
		frmAdminAction.getContentPane().add(textField);
		frmAdminAction.getContentPane().add(textField1);
		frmAdminAction.getContentPane().add(lblRentForum);
		frmAdminAction.getContentPane().add(lblNewLabel_2);
		frmAdminAction.getContentPane().add(lblNewLabel_3);
		frmAdminAction.getContentPane().add(btnbuyer);
		frmAdminAction.getContentPane().add(btnowner);
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.setFont(new Font("Georgia", Font.BOLD, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frmAdminAction.setVisible(false);
				Home.main(null);
			}
		});
		btnNewButton_2.setBounds(1556, 872, 120, 41);
		frmAdminAction.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("View feedback");
		btnNewButton.setFont(new Font("Georgia", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				feedback();
			}
		});
		btnNewButton.setBounds(215, 260, 151, 33);
		frmAdminAction.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(590, 301, 965, 142);
		frmAdminAction.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		load();
		
		
		
		
		JButton btnNewButton_1 = new JButton("View owner");
		btnNewButton_1.setFont(new Font("Georgia", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				owner();
			}
		});
		btnNewButton_1.setBounds(215, 336, 151, 33);
		frmAdminAction.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("View buyer");
		btnNewButton_3.setFont(new Font("Georgia", Font.BOLD, 14));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				buyer();
			}
		});
		btnNewButton_3.setBounds(215, 410, 151, 33);
		frmAdminAction.getContentPane().add(btnNewButton_3);

		
		JButton btnNewButton_4 = new JButton("Interested");
		btnNewButton_4.setFont(new Font("Georgia", Font.BOLD, 14));
		btnNewButton_4.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Interested();

			}
		});
		btnNewButton_4.setBounds(215, 489, 151, 33);
		frmAdminAction.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Register");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				load();
			}
		});
		btnNewButton_5.setFont(new Font("Georgia", Font.BOLD, 14));
		btnNewButton_5.setBounds(215, 571, 151, 33);
		frmAdminAction.getContentPane().add(btnNewButton_5);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\DBMSProject\\Rental\\Rental_management_system\\src\\images\\12.jpg"));
		lblNewLabel_4.setBounds(0, 0, 1902, 1033);
		frmAdminAction.getContentPane().add(lblNewLabel_4);
	}
}
