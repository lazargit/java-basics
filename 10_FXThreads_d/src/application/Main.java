package application;
	
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			TilePane root = new TilePane();
			Scene scene = new Scene(root,400,400);
			
			
			Label l1 = new Label();
			Label l2 = new Label();

			ProgressIndicator pi = new ProgressIndicator();
			Button b1 = new Button("Start");
			b1.setOnAction(e ->{
				Task<String> task =createTask();
				new Thread(task).start();
				l1.textProperty().bind(task.messageProperty());//updateMessage()
				l2.textProperty().bind(task.valueProperty());//updateValue()
				pi.progressProperty().bind(task.progressProperty());
				
			});
			
			
			
			root.getChildren().addAll(b1,pi,l1,l2);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Task<String> createTask(){ // Task ist ein "Runnable"
		
		
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
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
