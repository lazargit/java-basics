package threads;


/*
 * Variante 2: Runnable implementieren
 */
public class MyRunnable implements Runnable{
	
	
	private boolean stop =false;
	@Override
	public void run() {
		while (!stop) {
			
			try {
				Thread.sleep(100);
				System.out.println("run...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}// Thread Ende
	
	public void stopThread(){
		stop=true;
	}
	
	public static void main(String[] args) {
		MyRunnable r1 = new MyRunnable();
		Thread t1 = new Thread(r1);
		t1.start();
	}
	
	
}
