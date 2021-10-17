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

public class Qrysln {

	private JFrame frmBuyerQrysln;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	private JLabel lblNewLabel_6;
	private JButton btnNewButton_1;
	private JButton btnNewButton_3;
	private JTextArea textArea;
	private JLabel lblNewLabel_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Qrysln window = new Qrysln();
					window.frmBuyerQrysln.setVisible(true);
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
	public Qrysln() 
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
		frmBuyerQrysln = new JFrame();
		frmBuyerQrysln.setTitle("Buyer qrysln");
		frmBuyerQrysln.setBounds(0, 0, 1920, 1080);
		frmBuyerQrysln.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBuyerQrysln.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(749, 440, 893, 143);
		frmBuyerQrysln.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		load2();
			
			lblNewLabel = new JLabel("buyerid");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Snap ITC", Font.PLAIN, 17));
			lblNewLabel.setBounds(217, 536, 109, 28);
			frmBuyerQrysln.getContentPane().add(lblNewLabel);
			
			lblNewLabel_1 = new JLabel("Password");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setFont(new Font("Snap ITC", Font.PLAIN, 17));
			lblNewLabel_1.setBounds(217, 602, 109, 24);
			frmBuyerQrysln.getContentPane().add(lblNewLabel_1);
			
			lblNewLabel_2 = new JLabel("Query");
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setFont(new Font("Snap ITC", Font.PLAIN, 17));
			lblNewLabel_2.setBounds(231, 687, 89, 29);
			frmBuyerQrysln.getContentPane().add(lblNewLabel_2);
			
			textField = new JTextField();
			textField.setBounds(357, 538, 136, 29);
			frmBuyerQrysln.getContentPane().add(textField);
			textField.setColumns(10);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(357, 602, 136, 28);
			frmBuyerQrysln.getContentPane().add(passwordField);
			
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
			btnNewButton.setBounds(266, 773, 98, 33);
			frmBuyerQrysln.getContentPane().add(btnNewButton);
			
			lblNewLabel_6 = new JLabel("RENT FORUM");
			lblNewLabel_6.setForeground(Color.WHITE);
			lblNewLabel_6.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
			lblNewLabel_6.setBounds(866, 101, 222, 40);
			frmBuyerQrysln.getContentPane().add(lblNewLabel_6);
			
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
			btnNewButton_1.setBounds(429, 774, 89, 31);
			frmBuyerQrysln.getContentPane().add(btnNewButton_1);
			
			btnNewButton_3 = new JButton("Back");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					frmBuyerQrysln.setVisible(false);
					View.main(null);
				}
			});
			btnNewButton_3.setFont(new Font("Georgia", Font.BOLD, 17));
			btnNewButton_3.setBounds(1668, 879, 109, 29);
			frmBuyerQrysln.getContentPane().add(btnNewButton_3);
			
			textArea = new JTextArea();
			textArea.setBounds(357, 676, 274, 55);
			frmBuyerQrysln.getContentPane().add(textArea);
			
			JLabel lblNewLabel_7 = new JLabel("Query");
			lblNewLabel_7.setForeground(Color.WHITE);
			lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_7.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
			lblNewLabel_7.setBounds(286, 453, 119, 43);
			frmBuyerQrysln.getContentPane().add(lblNewLabel_7);
			
			lblNewLabel_9 = new JLabel("");
			lblNewLabel_9.setIcon(new ImageIcon("D:\\DBMSProject\\Rental\\Rental_management_system\\src\\images\\15.jpg"));
			lblNewLabel_9.setBounds(0, 0, 1902, 1033);
			frmBuyerQrysln.getContentPane().add(lblNewLabel_9);
			
		
		
	}
}
