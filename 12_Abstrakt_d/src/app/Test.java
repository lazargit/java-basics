package app;


enum D{
	A,B
	
}
public class Test {

	public static void testmethode(AbstractFahrzeug f){
		f.fahre();
		f.stop();
	System.out.println(D.A.ordinal());
	}
	
	public static void main(String[] args) {
		AbstractFahrzeug f = new AbstractFahrzeug() {
			
			@Override
			public void fahre() {
				System.out.println("fahre...");
				
			}
		};
		
		
		
		f.fahre();
		f.stop();
		
		testmethode(new AbstractFahrzeug() {
			
			@Override
			public void fahre() {
				// TODO Auto-generated method stub
				
			}
		});

	}

}
