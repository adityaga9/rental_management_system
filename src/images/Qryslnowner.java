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

	private JFrame frame;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField textField2;
	private JPasswordField passwordField1;
	private JButton btnNewButton1;
	private JLabel lblNewLabel_6;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JTextArea textArea;
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
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(0, 0, 1366,768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 132, 893, 278);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		load2();
			
			lblNewLabel = new JLabel("buyerid");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Georgia", Font.BOLD, 17));
			lblNewLabel.setBounds(65, 488, 109, 28);
			frame.getContentPane().add(lblNewLabel);
			
			lblNewLabel_1 = new JLabel("password");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setFont(new Font("Georgia", Font.BOLD, 17));
			lblNewLabel_1.setBounds(65, 543, 109, 24);
			frame.getContentPane().add(lblNewLabel_1);
			
			lblNewLabel_2 = new JLabel("query");
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setFont(new Font("Georgia", Font.BOLD, 17));
			lblNewLabel_2.setBounds(68, 609, 89, 29);
			frame.getContentPane().add(lblNewLabel_2);
			
			textField = new JTextField();
			textField.setBounds(214, 490, 136, 29);
			frame.getContentPane().add(textField);
			textField.setColumns(10);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(214, 543, 136, 28);
			frame.getContentPane().add(passwordField);
			
			lblNewLabel_3 = new JLabel("ownerid");
			lblNewLabel_3.setForeground(Color.WHITE);
			lblNewLabel_3.setFont(new Font("Georgia", Font.BOLD, 17));
			lblNewLabel_3.setBounds(573, 482, 109, 28);
			frame.getContentPane().add(lblNewLabel_3);
			
			btnNewButton = new JButton("submit");
			btnNewButton.setFont(new Font("Georgia", Font.BOLD, 16));
			btnNewButton.addActionListener(new ActionListener() 
			{
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) 
				{
					try {
						Connection con = DB.getConnection();
						Statement st = con.createStatement();
						ResultSet rs;
						rs = st.executeQuery("select b_buyerid,b_password from buyer where b_buyerid='"
										+ textField.getText()
										+ "' and b_password='"
										+ passwordField.getText() + "'");
						if (rs.next()) 
						{
							try {
								String query="insert into buyerquery(q_buyerid,query) values(?,?)";
								Connection con1 = DB.getConnection();
								PreparedStatement st11 = con1.prepareStatement(query);
								st11.setString(1, textField.getText());
								
								st11.setString(2, textArea.getText());
								
								st11.execute();
							    JOptionPane.showMessageDialog(null, "query submitted");
							    load();
							    con.close();
							} 
							catch (SQLException e1) 
							{
								//TODO Auto-generated catch block
								e1.printStackTrace();
							}
						} 
						else 
						{
							JOptionPane.showMessageDialog(null,"invalid credentials");
						}
					} 
					catch (SQLException e2) 
					{
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
			});
			btnNewButton.setBounds(136, 671, 98, 33);
			frame.getContentPane().add(btnNewButton);
			
			lblNewLabel_4 = new JLabel("password");
			lblNewLabel_4.setForeground(Color.WHITE);
			lblNewLabel_4.setFont(new Font("Georgia", Font.BOLD, 17));
			lblNewLabel_4.setBounds(573, 539, 109, 28);
			frame.getContentPane().add(lblNewLabel_4);
			
			lblNewLabel_5 = new JLabel("solution");
			lblNewLabel_5.setForeground(Color.WHITE);
			lblNewLabel_5.setFont(new Font("Georgia", Font.BOLD, 17));
			lblNewLabel_5.setBounds(573, 611, 109, 27);
			frame.getContentPane().add(lblNewLabel_5);
			
			textField2 = new JTextField();
			textField2.setBounds(720, 482, 129, 28);
			frame.getContentPane().add(textField2);
			textField2.setColumns(10);
			
			passwordField1 = new JPasswordField();
			passwordField1.setBounds(720, 539, 129, 28);
			frame.getContentPane().add(passwordField1);
			
			btnNewButton1 = new JButton("submit");
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
			btnNewButton1.setBounds(720, 670, 98, 33);
			frame.getContentPane().add(btnNewButton1);
			
			lblNewLabel_6 = new JLabel("RENT FORUM");
			lblNewLabel_6.setForeground(Color.WHITE);
			lblNewLabel_6.setFont(new Font("Georgia", Font.BOLD, 24));
			lblNewLabel_6.setBounds(653, 61, 198, 40);
			frame.getContentPane().add(lblNewLabel_6);
			
			btnNewButton_1 = new JButton("reset");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					textField.setText("");
					passwordField.setText("");
					textArea.setText("");
				}
			});
			btnNewButton_1.setFont(new Font("Georgia", Font.BOLD, 16));
			btnNewButton_1.setBounds(280, 672, 89, 31);
			frame.getContentPane().add(btnNewButton_1);
			
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
			btnNewButton_2.setBounds(872, 670, 98, 34);
			frame.getContentPane().add(btnNewButton_2);
			
			btnNewButton_3 = new JButton("Back");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					frame.setVisible(false);
					RentReg.main(null);
				}
			});
			btnNewButton_3.setFont(new Font("Georgia", Font.BOLD, 17));
			btnNewButton_3.setBounds(1167, 130, 109, 29);
			frame.getContentPane().add(btnNewButton_3);
			
			textArea = new JTextArea();
			textArea.setBounds(214, 599, 253, 33);
			frame.getContentPane().add(textArea);
			
			textArea_1 = new JTextArea();
			textArea_1.setBounds(720, 599, 293, 36);
			frame.getContentPane().add(textArea_1);
			
			JLabel lblNewLabel_7 = new JLabel("Query");
			lblNewLabel_7.setForeground(Color.WHITE);
			lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_7.setFont(new Font("Georgia", Font.BOLD, 15));
			lblNewLabel_7.setBounds(179, 432, 89, 31);
			frame.getContentPane().add(lblNewLabel_7);
			
			JLabel lblNewLabel_8 = new JLabel("Solution");
			lblNewLabel_8.setForeground(Color.WHITE);
			lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_8.setFont(new Font("Georgia", Font.BOLD, 15));
			lblNewLabel_8.setBounds(667, 433, 89, 28);
			frame.getContentPane().add(lblNewLabel_8);
			
			lblNewLabel_9 = new JLabel("");
			lblNewLabel_9.setIcon(new ImageIcon(Qryslnowner.class.getResource("/images/05.jpg")));
			lblNewLabel_9.setBounds(-134, 0, 1350, 729);
			frame.getContentPane().add(lblNewLabel_9);
			
		
		
	}
}
