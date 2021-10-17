import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
//import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class View {

	private JFrame frmBuyerView;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_11;
	private JTable table;
	private JTextArea textArea;
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try {
					View window = new View();
					window.frmBuyerView.setVisible(true);
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
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBuyerView = new JFrame();
		frmBuyerView.setTitle("Buyer view");
		frmBuyerView.getContentPane().setFont(new Font("Georgia", Font.BOLD, 17));
		frmBuyerView.setBounds(0, 0, 1920, 1080);
		frmBuyerView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBuyerView.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RENT FORUM");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(820, 80, 280, 42);
		frmBuyerView.getContentPane().add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("Register Interested house");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(760, 660, 340, 61);
		frmBuyerView.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Query");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				frmBuyerView.setVisible(false);
				Qrysln.main(null);
			}
		});
		btnNewButton.setFont(new Font("Georgia", Font.BOLD, 16));
		btnNewButton.setBounds(355, 571, 93, 33);
		frmBuyerView.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Interested");
		btnNewButton_1.setFont(new Font("Georgia", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String buyerid = textField.getText();
				String houseid = textField_1.getText();
				if (buyerid == null || buyerid.trim().length() == 0 || 
						houseid== null ||houseid.trim().length() == 0) 
				{

					JOptionPane.showMessageDialog(null,
							"Please Enter all the Fields");

				} 
				else
				{
					try 
					{
						String query="insert into interest(i_buyerid,i_houseid) values(?,?)";
						Connection con2= DB.getConnection();
						PreparedStatement  stmt= con2.prepareStatement(query);
						stmt.setString(1, buyerid);
						stmt.setString(2, houseid);
						stmt.execute();
						JOptionPane.showMessageDialog(null,"done.....");
						con2.close();
					} 
					catch (SQLException e1) 
					{
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null,e1);
					}
				}
			}
		});
		btnNewButton_1.setBounds(1069, 777, 123, 42);
		frmBuyerView.getContentPane().add(btnNewButton_1);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(251, 253, 123, 30);
		frmBuyerView.getContentPane().add(textField_11);
		
		JLabel lblNewLabel_2 = new JLabel("buyer id");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Snap ITC", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(774, 809, 121, 42);
		frmBuyerView.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("house id");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Snap ITC", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(774, 751, 121, 33);
		frmBuyerView.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(906, 815, 122, 42);
		frmBuyerView.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(907, 751, 121, 42);
		frmBuyerView.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JTextField textField_2 = new JTextField();
		textField_2.setBounds(251, 314, 120, 30);
		frmBuyerView.getContentPane().add(textField_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(642, 385, 810, 139);
		frmBuyerView.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		DefaultTableModel model=new DefaultTableModel(new String[]{"HOUSEID","OWNERNAME","CONTACTNO","ADDRESS","RENTAMOUNT","ROOMS"},0);
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
			
			
			JButton btnNewButton_4 = new JButton("Exit");
			btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					frmBuyerView.setVisible(false);
					Home.main(null);
				}
			});
			btnNewButton_4.setFont(new Font("Georgia", Font.BOLD, 17));
			btnNewButton_4.setBounds(1596, 884, 109, 40);
			frmBuyerView.getContentPane().add(btnNewButton_4);
			
			textArea = new JTextArea();
			textArea.setBounds(251, 385, 264, 54);
			frmBuyerView.getContentPane().add(textArea);
			
			JLabel lblNewLabel_11 = new JLabel("Feedback");
			lblNewLabel_11.setForeground(Color.WHITE);
			lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_11.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
			lblNewLabel_11.setBounds(149, 168, 169, 48);
			frmBuyerView.getContentPane().add(lblNewLabel_11);

			JLabel lblNewLabel_21 = new JLabel("house id");
			lblNewLabel_21.setForeground(Color.WHITE);
			lblNewLabel_21.setFont(new Font("Snap ITC", Font.PLAIN, 17));
			lblNewLabel_21.setBounds(124, 253, 93, 29);
			frmBuyerView.getContentPane().add(lblNewLabel_21);

			JLabel lblNewLabel_31 = new JLabel("buyer id");
			lblNewLabel_31.setForeground(Color.WHITE);
			lblNewLabel_31.setFont(new Font("Snap ITC", Font.PLAIN, 17));
			lblNewLabel_31.setBounds(124, 317, 107, 23);
			frmBuyerView.getContentPane().add(lblNewLabel_31);

			JLabel lblNewLabel_4 = new JLabel("feedback");
			lblNewLabel_4.setForeground(Color.WHITE);
			lblNewLabel_4.setFont(new Font("Snap ITC", Font.PLAIN, 17));
			lblNewLabel_4.setBounds(124, 396, 93, 30);
			frmBuyerView.getContentPane().add(lblNewLabel_4);

			

			JLabel lblNewLabel_5 = new JLabel("rating");
			lblNewLabel_5.setForeground(Color.WHITE);
			lblNewLabel_5.setFont(new Font("Snap ITC", Font.PLAIN, 17));
			lblNewLabel_5.setBounds(138, 496, 93, 28);
			frmBuyerView.getContentPane().add(lblNewLabel_5);
			
			JButton btnSubmit = new JButton("submit");
			btnSubmit.setFont(new Font("Georgia", Font.BOLD, 16));
			btnSubmit.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					
				    String houseid = textField_11.getText();
				    String buyerid = textField_2.getText();
					String feedback= textArea.getText();
					String rating = (String) comboBox.getSelectedItem();
					if(houseid==null || houseid.trim().length()==0 || buyerid==null || buyerid.trim().length()==0 
							|| feedback==null || feedback.trim().length()==0 || rating==null || rating.trim().length()==0)
					{
						JOptionPane.showMessageDialog(null,"please enter all the fields");
					}
					else
					{
						try 
						{
							String query2 = "insert into feedback(f_houseid,f_buyerid,feedback,f_rating) values(?,?,?,?)";
							Connection con2 = DB.getConnection();
							PreparedStatement st2 = con2.prepareStatement(query2);
							st2.setString(1, houseid);
							st2.setString(2, buyerid);
							st2.setString(3, feedback);
							int value=Integer.parseInt(rating);
							st2.setInt(4,value);
							st2.execute();
							JOptionPane.showMessageDialog(null,"feedback submitted");
							con2.close();
						} 
						catch (SQLException e1) 
						{
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null,e1);
						}
					}
				}
			});
			btnSubmit.setBounds(96, 571, 93, 33);
			frmBuyerView.getContentPane().add(btnSubmit);
			
			comboBox = new JComboBox<String>();
			comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5"}));
			comboBox.setBounds(251, 496, 54, 33);
			frmBuyerView.getContentPane().add(comboBox);
			
			
			JButton btnNewButton_2 = new JButton("reset");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{
					textField_11.setText("");
					textField_2.setText("");
					textArea.setText("");
				}
			});
			btnNewButton_2.setFont(new Font("Georgia", Font.BOLD, 16));
			btnNewButton_2.setBounds(220, 571, 98, 33);
			frmBuyerView.getContentPane().add(btnNewButton_2);
			
			comboBox_1 = new JComboBox<String>();
			comboBox_1.setBounds(149, 734, 93, 33);
			frmBuyerView.getContentPane().add(comboBox_1);
			try {
				Connection con = DB.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select r_houseid from register");
				while (rs.next()) {
					comboBox_1.addItem(rs.getString(1));
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
			
			JButton btnNewButton_3 = new JButton("Search");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					try {

						String sql = "SELECT * FROM REGISTER WHERE r_houseid='"
								+ comboBox_1.getSelectedItem() + "'";
						Connection conn = DB.getConnection();
						Statement st = conn.createStatement();
						ResultSet rs = st.executeQuery(sql);
						DefaultTableModel model = (DefaultTableModel) table
								.getModel();
						model.setRowCount(0);

						if (rs.next()) {
							String house=rs.getString("r_houseid");
							String owner=rs.getString("r_ownername");
							String contact=rs.getString("r_contactno");
							String address=rs.getString("r_address");
							String rentamt=rs.getString("r_rentamount");
							String rooms=rs.getString("r_rooms");
							model.addRow(new Object[] {house,owner,contact,address,rentamt,rooms});
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
			btnNewButton_3.setFont(new Font("Georgia", Font.BOLD, 16));
			btnNewButton_3.setBounds(276, 733, 98, 33);
			frmBuyerView.getContentPane().add(btnNewButton_3);
			
			JLabel lblNewLabel_6 = new JLabel("Search");
			lblNewLabel_6.setForeground(Color.WHITE);
			lblNewLabel_6.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
			lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_6.setBounds(223, 673, 95, 42);
			frmBuyerView.getContentPane().add(lblNewLabel_6);
			
			JLabel lblNewLabel_7 = new JLabel("");
			lblNewLabel_7.setIcon(new ImageIcon("D:\\DBMSProject\\Rental\\Rental_management_system\\src\\images\\14.jpg"));
			lblNewLabel_7.setBounds(0, 0, 1902, 1033);
			frmBuyerView.getContentPane().add(lblNewLabel_7);
			
			
		
	}
}
