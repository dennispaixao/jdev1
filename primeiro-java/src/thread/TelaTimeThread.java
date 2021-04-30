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

public class TelaTimeThread extends JDialog {
	
	private JPanel jPanel = new JPanel(new GridBagLayout()); //Painel de componentes

	private JLabel descricaoHora = new JLabel("TimeThread1");
	private JTextField mostraTempo = new JTextField();
	private JLabel descricaoHora2 = new JLabel("TimeThread2");
	private JTextField mostraTempo2 = new JTextField();
	private JButton bstart= new JButton("Start");
	private JButton bstop = new JButton("Stop");
	
	
	Runnable thread = new Runnable() {
		
		@Override
		public void run() {
			while(true) {
				mostraTempo.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm.ss").
						format(Calendar.getInstance().getTime()));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	};
	
	
	Runnable thread2 = new Runnable() {
		
		@Override
		public void run() {
			while(true) {
				mostraTempo2.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").
						format(Calendar.getInstance().getTime()));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	};
	
	
	private Thread thread1Time;
	private Thread thread2Time;
	public TelaTimeThread() {
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
		bstart.setPreferredSize(new Dimension(132,25));
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
		jPanel.add(bstart,gb);
		gb.gridx++;
		jPanel.add(bstop,gb);
		
		
		bstart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				thread1Time = new Thread(thread);
				thread1Time.start();
				thread2Time = new Thread(thread2);
				thread2Time.start();
				bstart.setEnabled(false);
				bstop.setEnabled(true);
			}
		});
		
		bstop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				thread1Time.stop();
				thread2Time.stop();
				bstart.setEnabled(true);
				bstop.setEnabled(false);
				
			}
		});
		
		bstop.setEnabled(false);
		add(jPanel,BorderLayout.WEST);
		setVisible(true);
	}
	
}
