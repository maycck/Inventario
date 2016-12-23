import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Inventario {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public Inventario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setResizable(false);
		getFrame().setBounds(100, 100, 450, 300);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBounds(0, 0, 444, 21);
		getFrame().getContentPane().add(menuBar);
		
		JMenu mnNuevo = new JMenu("Nuevo");
		menuBar.add(mnNuevo);
		
		JMenuItem miProducto = new JMenuItem("Producto");
		mnNuevo.add(miProducto);
		
		JMenuItem miCliente = new JMenuItem("Cliente");
		mnNuevo.add(miCliente);
		
		JMenuItem miProveedor = new JMenuItem("Proveedor");
		mnNuevo.add(miProveedor);
		
		JMenu mnInventario = new JMenu("Inventario");
		menuBar.add(mnInventario);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
