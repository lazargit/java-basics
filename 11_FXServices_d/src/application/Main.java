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
			primaryStage.setTitle("FX Services");
			TilePane root = new TilePane();
			Scene scene = new Scene(root,400,400);
			
			
			Label l1 = new Label();
			Label l2 = new Label();

			ProgressIndicator pi = new ProgressIndicator();
			Button b1 = new Button("Start");
			MyService service = new MyService();
			l1.textProperty().bind(service.messageProperty());//updateMessage()
			l2.textProperty().bind(service.valueProperty());//updateValue()
			pi.progressProperty().bind(service.progressProperty());
			
			
			b1.setOnAction(e ->{
				
				service.restart(); // start()
			});
			
			service.setOnSucceeded(e->{
				System.out.println("Service ist erfolgreich fertig");
				// hier kann ich z.B. einen zweiten Service starten
			});
			
			root.getChildren().addAll(b1,pi,l1,l2);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
