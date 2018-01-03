package application;


import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class MyService extends Service<String>{

	@Override
	protected Task<String> createTask() {

		Task<String> task = new Task<String>() {
			
			@Override
			protected String call() throws Exception {
				updateMessage("call...");// Nachrichten (String)
				final long MAX=100_000_00;
				long result =0;
				for (int i = 0; i <=MAX; i++) {
					result+=i;
					updateValue(""+result);// Zwischenergebnis
					updateProgress(i, MAX);
				}
				
				updateMessage("ende...");
				return "Result: "+result;
			}
		};
		
		
		
		
		return task;
	}


}
