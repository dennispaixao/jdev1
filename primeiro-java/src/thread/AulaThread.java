package thread;

public class AulaThread {

	public static void main(String[] args) throws InterruptedException {
	
		Thread t1 = new Thread(Thread1);
		Thread t2 = new Thread(Thread2);
		t2.start();
		t1.start();
		System.out.println("fim");

	}

	
	private static Runnable Thread1 = new Runnable() {
		
		public void run() {
			for(int i = 0; i<10;i= i+2) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(i);
			}
			
		}
		
	};
private static Runnable Thread2 = new Runnable() {
		
		public void run() {
			for(int i = 1; i<10;i=i+2) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(i);
			}
			
		}
		
	};
	
}
