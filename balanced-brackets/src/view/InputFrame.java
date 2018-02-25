package view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import controller.Controller;


public class InputFrame extends JFrame {

	private JTextField inputField=null;
	private JButton buttonSend=null;
	
	
	public InputFrame() {
		createFrame();
	}
	
	
	private void createFrame() {
		setTitle("Input Brackets");
		setVisible(true);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(1, 2));
		setSize(300, 80);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.add(getInputField());
		super.add(getButtonSend());
	}
		
	
	public JTextField getInputField() {
		if(inputField == null) {
			inputField = new JTextField();
			inputField.setFont(new Font("Arial", Font.BOLD, 20));
		}
		return inputField;
	}
	
	
	private JButton getButtonSend() {
		if(buttonSend == null) {
			buttonSend = new JButton("Send");
			buttonSend.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					if(inputField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please, input a sequence os brackets.");
					}else {
						
						String sequence = inputField.getText();
						boolean isValid = new Controller().isBalanced(sequence);
						
						if(isValid) {
							JOptionPane.showMessageDialog(null, "Is valid!");
						}else {
							JOptionPane.showMessageDialog(null, "Is not valid!");
						}
					}
				}
			});
		}
		return buttonSend;
	}
}
