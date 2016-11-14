package com.paul.client;

import io.codearte.jfairy.Fairy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;

import javax.naming.NamingException;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;

import com.paul.UserCRUD;
import com.paul.client.connection.JBossConnection;
import com.paul.model.User;

public class Layout_1 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private static JTextField textField;
	private static JTextField passwordField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private JButton btnNew;
	private JButton btnUpdate;
	private JButton btnRemove;
	private JButton btnRefresh;
	private static DefaultTableModel model;
	private JSplitPane splitPane;
	private JScrollPane scrollPane;
	private static JRadioButton rdbtnMale;
	private static ButtonGroup buttonGroup;
	private JRadioButton rdbtnFemale;
	private static JSpinner spinner;
	private static JComboBox comboBox;
	private static JCheckBox chckbxNewCheckBox;
	
	private static UserCRUD bean;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws NamingException {
		/* fake data injection */
		Fairy fairy = Fairy.create();
//		BaseProducer base = fairy.baseProducer();
//		Person person = fairy.person();
//		User user;
//		for(int i=0;i<10;i++){
//			user = new User(
//					person.username(),
//					person.password(),
//					person.nationalIdentityCardNumber(),
//					base.randomBetween(0, 1),
//					person.age(),
//					base.randomBetween(0, 5),
//					person.getAddress().toString(),
//					person.email(),
//					person.telephoneNumber(),
//					base.randomBetween(0, 1));
//			add(user);
//
//			System.out.println("-----------------------------------------");
//			person = fairy.person();
//		}

		Layout_1 frame = new Layout_1();
		frame.setVisible(true);
		refresh();
	}

	/**
	 * Create the frame.
	 */
	public Layout_1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setResizeWeight(1.0);
		contentPane.add(splitPane);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.8);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_1);
		
		JPanel panel = new JPanel();
		splitPane_1.setLeftComponent(panel);
		panel.setLayout(new MigLayout("", "[][grow][][grow]", "[][][][][grow]"));
		
		JLabel lblName = new JLabel("Name:");
		panel.add(lblName, "cell 0 0");
		
		textField = new JTextField();
		panel.add(textField, "cell 1 0,growx");
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		panel.add(lblPassword, "cell 2 0");
		
		passwordField = new JTextField();
		passwordField.setColumns(10);
		panel.add(passwordField, "cell 3 0,growx");
		
		JLabel lblId = new JLabel("ID:");
		panel.add(lblId, "cell 0 1");
		
		textField_1 = new JTextField();
		panel.add(textField_1, "cell 1 1,growx");
		textField_1.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender:");
		panel.add(lblGender, "cell 2 1");
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setSelected(true);
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnMale);
		panel.add(rdbtnMale, "flowx,cell 3 1");
		
		rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		panel.add(rdbtnFemale, "cell 3 1");
		
		JLabel lblAge = new JLabel("Age:");
		panel.add(lblAge, "cell 0 2");
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		JComponent editor = (JSpinner.DefaultEditor)spinner.getEditor();
		JFormattedTextField ftf = ((JSpinner.DefaultEditor)editor).getTextField();
		ftf.setColumns(3);
		panel.add(spinner, "cell 1 2");
		
		JLabel lblCountry = new JLabel("Country:");
		panel.add(lblCountry, "cell 2 2,alignx left");
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Taiwan", "China", "Japan", "Korea", "Singapore", "Hong Kong"}));
		comboBox.setMaximumRowCount(5);
		panel.add(comboBox, "cell 3 2,growx");
		
		JLabel lblAddress = new JLabel("Address:");
		panel.add(lblAddress, "cell 0 3,alignx left");
		
		textField_2 = new JTextField();
		panel.add(textField_2, "cell 1 3,growx");
		textField_2.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		panel.add(lblEmail, "cell 2 3,alignx left");
		
		textField_3 = new JTextField();
		panel.add(textField_3, "cell 3 3,growx");
		textField_3.setColumns(10);
		
		JLabel lblTel = new JLabel("Tel:");
		panel.add(lblTel, "cell 0 4,alignx left");
		
		textField_4 = new JTextField();
		panel.add(textField_4, "cell 1 4,growx");
		textField_4.setColumns(10);
		
		JLabel lblWantNews = new JLabel("Want news?");
		panel.add(lblWantNews, "cell 2 4");
		
		chckbxNewCheckBox = new JCheckBox("Yes");
		panel.add(chckbxNewCheckBox, "flowx,cell 3 4");
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setContinuousLayout(true);
		splitPane_2.setResizeWeight(0.5);
		splitPane_1.setRightComponent(splitPane_2);
		
		JSplitPane splitPane_3 = new JSplitPane();
		splitPane_3.setContinuousLayout(true);
		splitPane_3.setResizeWeight(0.5);
		splitPane_2.setLeftComponent(splitPane_3);
		
		btnNew = new JButton("New");
		btnNew.addActionListener(this);
		splitPane_3.setLeftComponent(btnNew);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(this);
		splitPane_3.setRightComponent(btnUpdate);
		
		JSplitPane splitPane_4 = new JSplitPane();
		splitPane_4.setContinuousLayout(true);
		splitPane_4.setResizeWeight(0.5);
		splitPane_2.setRightComponent(splitPane_4);
		
		btnRemove = new JButton("Remove");
		btnRemove.addActionListener(this);
		splitPane_4.setLeftComponent(btnRemove);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(this);;
		splitPane_4.setRightComponent(btnRefresh);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		splitPane.setLeftComponent(scrollPane_1);
		

		model = new DefaultTableModel(new Object[][] {}, new String[] {"Name", "Password", "ID Number", "Gender", "Age", "Country", "Address", "Email", "Telephone", "News"}) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				if(me.getClickCount() == 2) {
					JTable target = (JTable) me.getSource();
					int row = target.getSelectedRow();
					textField.setText((String)target.getValueAt(row, 0));
					passwordField.setText((String)target.getValueAt(row, 1));
					textField_1.setEditable(false);
					textField_1.setText((String)target.getValueAt(row, 2));
					if(((String)target.getValueAt(row, 3)).equals("Male"))
						rdbtnMale.setSelected(true);
					else
						rdbtnFemale.setSelected(true);
					spinner.setValue((int)target.getValueAt(row, 4));
					String[] countries = {"Taiwan", "China", "Japan", "Korea", "Singapore", "Hong Kong"};
					comboBox.setSelectedIndex(Arrays.asList(countries).indexOf((String)target.getValueAt(row, 5)));
					textField_2.setText((String)target.getValueAt(row, 6));
					textField_3.setText((String)target.getValueAt(row, 7));
					textField_4.setText((String)target.getValueAt(row, 8));
					if(((String)target.getValueAt(row, 9)).equals("Yes"))
						chckbxNewCheckBox.setSelected(true);
					else
						chckbxNewCheckBox.setSelected(false);
					
				}
			}
		});
		scrollPane_1.setViewportView(table);
	}

	
	/* Action of Buttons */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnRefresh)
			refresh();
		else if(e.getSource() == btnNew)
			addUser();
		else if(e.getSource() == btnRemove)
			remove();
		else if(e.getSource() == btnUpdate)
			update();
		else
			JOptionPane.showMessageDialog(null, "No button is applicable." , "Error", JOptionPane.ERROR_MESSAGE);
	}

	
	
	/* Refreshing button's operation */
	public static void refresh(){
		try {
			bean = (UserCRUD) JBossConnection.getConnection();
			List<User> users = bean.findAll();
			model.setNumRows(0);
			String gender = "Male";
			String[] countries = {"Taiwan", "China", "Japan", "Korea", "Singapore", "Hong Kong"};
			String country ="Taiwan";
			String news ="Yes";
			for(User user : users) {
				/* transform into readable */
				if(user.getGender() == 0)
					gender = "Female";
				else
					gender = "Male";
				/* transform into readable */
				country = countries[user.getCountry()];
				/* transform into readable */
				if(user.getNews() == 0)
					news = "No";
				else
					news = "Yes";
				model.addRow(new Object[] {user.getName(), user.getPassword(), user.getIDNumber(), gender, user.getAge(), country, user.getAddress(), user.getEmail(), user.getTel(), news});
			}
		} catch (NamingException e) {
			JOptionPane.showMessageDialog(null, "Database connection is problematic." , "Error", JOptionPane.ERROR_MESSAGE);
		}
		textField_1.setEditable(true);
	}
	
	
	/* Adding Button's operation */
	/* Input: User class */
	public static void addUser(){
		try {
			bean = (UserCRUD) JBossConnection.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		if(bean.findOne(textField_1.getText()) instanceof User) {
			JOptionPane.showMessageDialog(null, "Duplicated User.");
		} else {
			int radio = (rdbtnMale.isSelected()) ? 1 : 0;
			int spin = (Integer) spinner.getValue();
			int box = (Integer) comboBox.getSelectedIndex();
			int check = (chckbxNewCheckBox.isSelected()) ? 1 : 0;
			User u = new User(
						textField.getText(),
						passwordField.getText(),
						textField_1.getText(),
						radio,
						spin,
						box,
						textField_2.getText(),
						textField_3.getText(),
						textField_4.getText(),
						check
					);
			bean.addUser(u);
			JOptionPane.showMessageDialog(null, "Finished!");
			refresh();
			
		/* front-end regular expression restrictions */
//		try {
//			if(textField_4.getText().matches("(09)+[0-9]{8}") && textField.getText().matches("[A-Za-z0-9]{1,20}")) {
//				bean = (UserCRUD) JBossConnection.getConnection();
//				bean.addUser(textField.getText(), textField_4.getText());
//				JOptionPane.showMessageDialog(null, "Finished!");
//				refresh();
//			} else {
//				JOptionPane.showMessageDialog(null, "Wrong Format!");
//			}
//		} catch (ConstraintViolationException cve) {
//			JOptionPane.showMessageDialog(null, "Duplicated rows." , "Error", JOptionPane.ERROR_MESSAGE);
//		} catch (NamingException e) {
//			JOptionPane.showMessageDialog(null, "Database connection is problematic." , "Error", JOptionPane.ERROR_MESSAGE);
//		}
			textField_1.setEditable(true);
		}
	}
	public static void remove(){
		try {
			bean = (UserCRUD) JBossConnection.getConnection();
			if(bean.findOne(textField_1.getText()) != null) {
				bean.removeUser(textField_1.getText());
				JOptionPane.showMessageDialog(null, "Finished!");
				refresh();
			} else {
				JOptionPane.showMessageDialog(null, "Cannot find the user!" , "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (NamingException e) {
			JOptionPane.showMessageDialog(null, "Database connection is problematic." , "Error", JOptionPane.ERROR_MESSAGE);
		}
		textField_1.setEditable(true);
	}
	public static void update(){
		try {
			/* front-end regular expression restrictions */
//			if(textField_4.getText().matches("(09)+[0-9]{8}")) {
//				if(textField.getText().matches("[A-Za-z0-9]{1,20}")) {
					bean = (UserCRUD) JBossConnection.getConnection();
					if(bean.findOne(textField_1.getText()) != null) {
						int radio = (rdbtnMale.isSelected()) ? 1 : 0;
						int spin = (Integer) spinner.getValue();
						int box = (Integer) comboBox.getSelectedIndex();
						int check = (chckbxNewCheckBox.isSelected()) ? 1 : 0;
						User u = new User(
									textField.getText(),
									passwordField.getText(),
									textField_1.getText(),
									radio,
									spin,
									box,
									textField_2.getText(),
									textField_3.getText(),
									textField_4.getText(),
									check
								);
						bean.updateUser(u);
						JOptionPane.showMessageDialog(null, "Finished!");
						refresh();
					} else {
						JOptionPane.showMessageDialog(null, "Cannot find the user!" , "Error", JOptionPane.ERROR_MESSAGE);
					}
//				} else {
//					JOptionPane.showMessageDialog(null, "Wrong Format of Name!" , "Error", JOptionPane.ERROR_MESSAGE);
//				}
//			} else {
//				JOptionPane.showMessageDialog(null, "Wrong Format of Telephone!" , "Error", JOptionPane.ERROR_MESSAGE);
//			}
		} catch (NamingException e) {
			JOptionPane.showMessageDialog(null, "Database connection is problematic." , "Error", JOptionPane.ERROR_MESSAGE);
		}
		textField_1.setEditable(true);
	}
	
}
