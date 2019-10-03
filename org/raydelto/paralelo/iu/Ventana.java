package org.raydelto.paralelo.iu;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.raydelto.paralelo.logica.paralelo.ManejadorDePuerto;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JTextField txtNumero = null;

	private JLabel lblNumero = null;

	private JButton btnPresentar = null;

	private JButton btnContar = null;
	
	private ManejadorDePuerto manejador = null;

	/**
	 * This is the default constructor
	 */
	
	{
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Ventana() {
		super();
		manejador = new ManejadorDePuerto();
		initialize();		
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(373, 196);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/chip.png")));
		this.setContentPane(getJContentPane());
		this.setTitle("Sistema de control del puerto paralelo v0.1");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lblNumero = new JLabel();
			lblNumero.setBounds(new Rectangle(13, 15, 338, 29));
			lblNumero.setText("Introduzca el número a presentar en la pantalla numérica");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getTxtNumero(), null);
			jContentPane.add(lblNumero, null);
			jContentPane.add(getBtnPresentar(), null);
			jContentPane.add(getBtnContar(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes txtNumero	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTxtNumero() {
		if (txtNumero == null) {
			txtNumero = new JTextField();
			txtNumero.setBounds(new Rectangle(13, 48, 338, 27));
			txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					if(e.getKeyChar() == 10){
						desplegar(txtNumero.getText());
					}else if(e.getKeyChar() < '0' || e.getKeyChar() > '9'){
						e.consume();
					}
				}
			});
		}
		return txtNumero;
	}

	/**
	 * This method initializes btnPresentar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnPresentar() {
		if (btnPresentar == null) {
			btnPresentar = new JButton();
			btnPresentar.setBounds(new Rectangle(13, 79, 338, 27));
			btnPresentar.setText("Presentar");
			btnPresentar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {					
					desplegar(txtNumero.getText());
				}
			});
		}
		return btnPresentar;
	}

	private void desplegar(String texto){
		texto = texto.trim();
		manejador.desplegarEnPantalla(Short.parseShort(texto));
	}
	/**
	 * This method initializes btnContar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnContar() {
		if (btnContar == null) {
			btnContar = new JButton();
			btnContar.setBounds(new Rectangle(13, 111, 338, 27));
			btnContar.setText("Contar desde 00 hasta 99");
			btnContar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					manejador.contar();
				}
			});
		}
		return btnContar;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
