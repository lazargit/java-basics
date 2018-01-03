package app;

import exception.MyException1;

public class ExceptionTest {
	
	public static double div(double a, double b) throws MyException1{
		if(b==0){
			throw new MyException1("Rechenfehler!");
		}
		return a /b;
	}
	
	
	public static void m1() throws MyException1{
		double d = div(2, 0);
	}
	
	
	
	public static void main(String[] args) {
		
		
		try {
			m1();
		} catch (MyException1 e) {
			System.out.println("Bitte nicht durch 0 teilen "+e.getMessage());
		}
		
		
	}

}
