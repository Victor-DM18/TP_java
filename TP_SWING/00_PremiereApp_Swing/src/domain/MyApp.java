package domain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyApp extends JFrame {

	private JPanel getContentPane;
	private JTextField txtPseudo;
	private JButton btnAnnuler;
	private JLabel lblVoici;
	private JButton btnEffacer;
	private JButton btnOk;
	private JTextField txtAffichePseudo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyApp frame = new MyApp();
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
	public MyApp() {
		setTitle("Connection avec votre pseudo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(450, 300);
		this.setLocationRelativeTo( null );
		getContentPane = new JPanel();
		
		getContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane.setLayout(new BorderLayout(20,40));
		setContentPane(getContentPane);

		// TOP
		JPanel top = new JPanel();
		getContentPane.add(top, BorderLayout.NORTH);
		JLabel lblEnterPseudo = new JLabel("Entrez votre pseudo");
		lblEnterPseudo.setHorizontalAlignment(SwingConstants.CENTER);
		top.add(lblEnterPseudo, BorderLayout.NORTH);

		txtPseudo = new JTextField();
		txtPseudo.setColumns(10);
		top.add(txtPseudo);

		// MIDDLE
		JPanel middle = new JPanel();
		middle.setLayout(new BorderLayout(20, 40));

		getContentPane.add(middle);
		middle.setLayout(new GridLayout(1,3, 40, 40));
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener( e -> {
			this.dispose();
		});
		btnAnnuler.setPreferredSize(new Dimension(100, 50));
		btnAnnuler.setLayout(new BorderLayout());
		middle.add(btnAnnuler, BorderLayout.WEST);


		btnEffacer = new JButton("Effacer");
		btnEffacer.setPreferredSize(new Dimension(100, 50));
		btnEffacer.setMaximumSize( new Dimension(2000,50));
		
		middle.add(btnEffacer, BorderLayout.CENTER);
		
		btnEffacer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEffacer_onClick(e);
			}
		});


		btnOk = new JButton("OK");
		btnOk.setPreferredSize(new Dimension(100,200));
		middle.add(btnOk, BorderLayout.EAST);
		
		btnOk.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnOk_onClick(e);
			}
		});

		// BOTTON

		JPanel botton = new JPanel();
		getContentPane.add(botton, BorderLayout.SOUTH);
		lblVoici = new JLabel("voici votre pseudo");
		botton.add(lblVoici, BorderLayout.SOUTH);
		
		txtAffichePseudo = new JTextField();
		botton.add(txtAffichePseudo);
		txtAffichePseudo.setColumns(10);
		
		
	}
	
	private void btnOk_onClick(ActionEvent e) {
		txtAffichePseudo.setText(txtPseudo.getText());
	}
	
	private void btnEffacer_onClick(ActionEvent e ) {
		txtPseudo.setText("");
		txtAffichePseudo.setText("");
	}
	
	
}
