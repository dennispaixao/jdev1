package thread;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Fila_Thread extends Thread {

	private static ConcurrentLinkedQueue<Pessoa> pilha_fila = new ConcurrentLinkedQueue<Pessoa>();

	public static void add(Pessoa p) {
		pilha_fila.add(p);

	}

	public void run() {
		System.out.println("fila rodando");

		while (true) {
			Iterator it = pilha_fila.iterator();
			synchronized (pilha_fila) { // bloqueia o acesso a lista por outros processos, para ser acessado apenas pela
								// thread
				while (it.hasNext()) {
					Pessoa p = (Pessoa) it.next();
					// processar 10 mil notas fiscais
					// gerar lista enorme de pdf
					// gerar envio em massa de email
					System.out.println("------------------");
					System.out.println(p.getNome());
					System.out.println(p.getEmail());
					it.remove(); // remove da lista
					try {// dar um tempo para descarga de memória
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
