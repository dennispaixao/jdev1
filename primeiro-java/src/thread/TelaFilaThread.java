package thread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaFilaThread extends JDialog {
	
	private JPanel jPanel = new JPanel(new GridBagLayout()); //Painel de componentes

	private JLabel descricaoHora = new JLabel("Nome");
	private JTextField mostraTempo = new JTextField();
	private JLabel descricaoHora2 = new JLabel("Email");
	private JTextField mostraTempo2 = new JTextField();
	private JButton badd= new JButton("Add Lista");
	private JButton bstop = new JButton("Stop");
	
	
	
	private Thread thread1Time;
	private Thread thread2Time;
	
	private Fila_Thread fila = new Fila_Thread();
	
	
	public TelaFilaThread() {
		setTitle("Minha tela de Time com Threads");
		setSize(new Dimension(300,300));
		setLocationRelativeTo(null);
		setResizable(false);
		//fim primeira parte
		
		GridBagConstraints gb = new GridBagConstraints();//controlador de posicionamento de componentes
		gb.gridx =0;
		gb.gridy = 0;
		gb.gridwidth =2;
		gb.anchor = GridBagConstraints.WEST;
		gb.insets = new Insets(5,5,0,5);
		descricaoHora.setPreferredSize(new Dimension(290,25));
		descricaoHora2.setPreferredSize(new Dimension(290,25));	
		mostraTempo.setPreferredSize(new Dimension(275,25));
		mostraTempo2.setPreferredSize(new Dimension(275,25));
		badd.setPreferredSize(new Dimension(132,25));
		bstop.setPreferredSize(new Dimension(132,25));
		
		jPanel.add(descricaoHora,gb);
		gb.gridy++;
		jPanel.add(mostraTempo,gb);
		gb.gridy++;
		jPanel.add(descricaoHora2,gb);
		gb.gridy++;
		jPanel.add(mostraTempo2,gb);
		gb.gridy++;
		gb.gridwidth=1;
		jPanel.add(badd,gb);
		gb.gridx++;
		jPanel.add(bstop,gb);
		fila.start();
		
		badd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (fila==null) {
					fila = new Fila_Thread();
					fila.start();
					
				}
				for(int i = 1; i<20; i++) {
					Pessoa p = new Pessoa();
					p.setNome(mostraTempo.getText());
					p.setEmail(mostraTempo2.getText()+" "+i);	
					fila.add(p);
				}
				bstop.setEnabled(true);

			}
		});
		
		bstop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fila.stop();
				fila = null;
				bstop.setEnabled(false);
				
			}
		});
		
		bstop.setEnabled(false);
		add(jPanel,BorderLayout.WEST);
		
		setVisible(true);
	}
	
}
