package ejTema1MVC;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;

public class Vista extends JFrame {
	
	
	private JFrame frame;
	private static final long serialVersionUID=1L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnAnyadir;
	private JScrollPane scrollPane;
	private JTextArea textArea_1;
	private JScrollPane scrollPane_1;
	private final JTextArea textArea=new JTextArea();

	/**
	 * Launch the application. // lo comento porque el main está en la clase Principal.java
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Vista window = new Vista();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Vista() {
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 139, 414, 46);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 295, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnAnyadir = new JButton("Anyadir");
		btnAnyadir.setBounds(315, 10, 89, 23);
		panel.add(btnAnyadir);
		btnAnyadir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 115);
		getContentPane().add(scrollPane);
		
		TextArea textArea = new TextArea();
		scrollPane.setColumnHeaderView(textArea);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 205, 404, 183);
		getContentPane().add(scrollPane_1);
		
		TextArea textArea_1 = new TextArea();
		scrollPane_1.setColumnHeaderView(textArea_1);
		
		
		initialize();
		
		
		
		setVisible(true); //
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		((JFrame) frame).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public JButton getAnyadir() {
		return btnAnyadir; //desde Controlador se llama y devuelve el 
	}
	
	public JTextField getTextField() {
		return textField;
	}
	
	public JTextArea getTextArea() {
		return textArea;
	}
	
	public JTextArea getTextArea_1() {
		return textArea_1;
	}
}
