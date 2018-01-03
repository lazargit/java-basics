package binding;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			TilePane root = new TilePane();
			Scene scene = new Scene(root,400,400);
			Temperatur temp = new Temperatur();
			
			Button b1 = new Button("+1");
			Button b2 = new Button("-1");
			ProgressBar pb = new ProgressBar();
			// Action
			
			
			b1.setOnAction( e->{
				temp.setTemperatur(temp.getTemperatur()+0.1F);
			});
			
			b2.setOnAction( e->{
				temp.setTemperatur(temp.getTemperatur()-0.1F);
			});
			
			//Binding
			pb.progressProperty().bind(temp.temperaturProperty());
			root.getChildren().addAll(b1,b2,pb);
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
