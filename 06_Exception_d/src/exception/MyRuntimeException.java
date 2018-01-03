package exception;



//ungeprüfte Exception / unchecked
@SuppressWarnings("serial")
public class MyRuntimeException extends RuntimeException{

	public MyRuntimeException() {
	}

	public MyRuntimeException(String message) {
		super(message);
		
	}
	
	

}
