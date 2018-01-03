package threads;


/*
 * Variante 1: Thread erweitern
 */
public class MyThread extends Thread{
	
	
	private boolean stop =false;
	@Override
	public void run() {
		while (!stop) {
			
			try {
				Thread.sleep(100);
				System.out.println(getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}// Thread Ende
	
	public void stopThread(){
		stop=true;
	}
	
	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		t1.start();
		MyThread t2 = new MyThread();
		t2.start();
		t2.setPriority(MAX_PRIORITY);
		MyThread t3 = new MyThread();
		t3.start();
		//t3.stop(); -> nicht verwenden
		t2.stopThread();
		//t2.start(); -> nicht ein zweites mal zu starten
	}
	
	
}
