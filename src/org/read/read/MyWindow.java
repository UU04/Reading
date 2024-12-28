package org.read.read;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JProgressBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Color;

public class MyWindow {

	private JFrame frmChannelManagementConsole;
	private JPasswordField E_passwordField;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField MS_passwordField;

	final static JLabel panel = new JLabel("T: time C: count");
	static int itemcount = -1;
	static JList list = new JList();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyWindow window = new MyWindow();
					window.frmChannelManagementConsole.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		while(true) {
			for (int i = 8; i > 0; i--) {
				panel.setText("T: "+i+" C: "+itemcount);
//				System.out.println(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if(i==8) {
					SysMang.main();
				}
			}
		}
	}
	
	/**
	 * Create the application.
	 */
	public MyWindow() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmChannelManagementConsole = new JFrame();
		frmChannelManagementConsole.setTitle("Channel Management Console");
		frmChannelManagementConsole.setBounds(150, 150, 600, 450);
		frmChannelManagementConsole.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChannelManagementConsole.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Execution Key");
		lblNewLabel.setToolTipText("*4 Digit code key for command execution");
		lblNewLabel.setBounds(12, 10, 82, 15);
		frmChannelManagementConsole.getContentPane().add(lblNewLabel);

		E_passwordField = new JPasswordField();
		E_passwordField.setBounds(106, 7, 52, 21);
		frmChannelManagementConsole.getContentPane().add(E_passwordField);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(new Color(0, 255, 64));
		progressBar.setToolTipText("");
		progressBar.setBounds(170, 10, 252, 14);
		frmChannelManagementConsole.getContentPane().add(progressBar);

		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("System Status");
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "AUTO", "MANUAL", "STOP" }));
		comboBox.setBounds(12, 35, 82, 23);
		frmChannelManagementConsole.getContentPane().add(comboBox);

		JButton UP_btn = new JButton("UPDATE");
		UP_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String input = E_passwordField.getText();
//				System.out.println(input);

				if (input.equalsIgnoreCase("andt777")) {
					progressBar.setValue(100);
					UP_btn.setText("*EXECUTE RDY*");
				} else {
					System.exit(0);
				}
			}
		});

		UP_btn.setBounds(279, 35, 143, 23);
		frmChannelManagementConsole.getContentPane().add(UP_btn);

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] { "loading", "", "", "", ":)" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setSelectedIndex(1);
		list.setBounds(12, 68, 135, 333);
		frmChannelManagementConsole.getContentPane().add(list);

		JButton REG_btn = new JButton("REGISTER");
		REG_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",
				        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				    // yes option
					
				} else {
				    // no option
				}
			}
		});
		REG_btn.setBounds(437, 228, 135, 23);
		frmChannelManagementConsole.getContentPane().add(REG_btn);

		JButton btnNewButton_1_1 = new JButton("DELETE");
		btnNewButton_1_1.setBounds(162, 227, 82, 23);
		frmChannelManagementConsole.getContentPane().add(btnNewButton_1_1);

		JButton btnNewButton_1_1_1 = new JButton("FREEZE");
		btnNewButton_1_1_1.setBounds(162, 194, 82, 23);
		frmChannelManagementConsole.getContentPane().add(btnNewButton_1_1_1);

		textField = new JTextField();
		textField.setBounds(456, 78, 116, 21);
		frmChannelManagementConsole.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("CODE(option)");
		lblNewLabel_1.setBounds(362, 81, 82, 15);
		frmChannelManagementConsole.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Max. Capacity");
		lblNewLabel_1_1.setBounds(347, 112, 97, 15);
		frmChannelManagementConsole.getContentPane().add(lblNewLabel_1_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(456, 109, 116, 21);
		frmChannelManagementConsole.getContentPane().add(textField_1);

		JCheckBox chckbxNewCheckBox = new JCheckBox("DELETE RES?");
		chckbxNewCheckBox.setBounds(456, 136, 115, 23);
		frmChannelManagementConsole.getContentPane().add(chckbxNewCheckBox);

		JCheckBox chckbxPublic = new JCheckBox("PUBLIC?");
		chckbxPublic.setBounds(456, 158, 115, 23);
		frmChannelManagementConsole.getContentPane().add(chckbxPublic);

		JCheckBox chckbxNoApprove = new JCheckBox("NO APPROVE?");
		chckbxNoApprove.setBounds(456, 183, 115, 23);
		frmChannelManagementConsole.getContentPane().add(chckbxNoApprove);

		JButton btnNewButton_1_1_1_1 = new JButton("CALL-CH");
		btnNewButton_1_1_1_1.setBounds(162, 161, 121, 23);
		frmChannelManagementConsole.getContentPane().add(btnNewButton_1_1_1_1);

		JButton btnNewButton_1_1_1_1_1 = new JButton("CALL-CAST");
		btnNewButton_1_1_1_1_1.setBounds(162, 135, 121, 23);
		frmChannelManagementConsole.getContentPane().add(btnNewButton_1_1_1_1_1);

		panel.setBounds(159, 68, 124, 15);
		frmChannelManagementConsole.getContentPane().add(panel);

		JLabel lblNewLabel_2_1 = new JLabel("Total 0000 players ONLINE");
		lblNewLabel_2_1.setBounds(106, 39, 162, 15);
		frmChannelManagementConsole.getContentPane().add(lblNewLabel_2_1);

		MS_passwordField = new JPasswordField();
		MS_passwordField.setBounds(373, 229, 52, 21);
		frmChannelManagementConsole.getContentPane().add(MS_passwordField);

		JLabel lblNewLabel_1_1_1 = new JLabel("MASTER PIN");
		lblNewLabel_1_1_1.setBounds(321, 211, 97, 15);
		frmChannelManagementConsole.getContentPane().add(lblNewLabel_1_1_1);
	}	
}
