import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LogginS extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogginS frame = new LogginS();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogginS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 395, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		user = new JTextField();
		user.setBounds(169, 32, 162, 31);
		contentPane.add(user);
		user.setColumns(10);
		
		pass = new JPasswordField();
		pass.setToolTipText("Escribe el password de usuario");
		pass.setBounds(169, 74, 162, 31);
		contentPane.add(pass);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(113, 40, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setBounds(94, 82, 74, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				char[] input = pass.getPassword();
				if(user.getText().equals("Admin") && isPasswordCorrect(input))
				{
					JOptionPane.showMessageDialog(null, "Ingreso correcto ");
					dispose();
					Inventario window = new Inventario();
					window.getFrame().setVisible(true);
					//Inventario.main(null);
				}else{
					JOptionPane.showMessageDialog(null, "Error al ingresar");
				}
			}
		});
		btnAceptar.setBounds(242, 127, 89, 23);
		contentPane.add(btnAceptar);
	}
	//Password
	private static boolean isPasswordCorrect(char[] input) {
	    boolean isCorrect = true;
	    char[] correctPassword = { 'p', 'a', 's', 's', 'w', 'o', 'r','d' };

	    if (input.length != correctPassword.length) {
	        isCorrect = false;
	    } else {
	        isCorrect = Arrays.equals (input, correctPassword);
	    }

	    //Zero out the password.
	    Arrays.fill(correctPassword,'0');

	    return isCorrect;
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
