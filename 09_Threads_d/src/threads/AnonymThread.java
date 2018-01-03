package threads;
/*
 * Variante 3: Anonym
 */
public class AnonymThread {

	public static void main(String[] args) {
		Thread t1= new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				System.out.println("run...");
			}
		});
		
		t1.start();
		
		//Java 8
		
		Thread t2 = new Thread(()->{
			System.out.println("run...");
		});
		t2.start();

	}

}
