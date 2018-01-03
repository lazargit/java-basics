package listener;
	
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
			
//			//Binding -> wenn Binding keine setter verwenden!
//			pb.progressProperty().bind(temp.temperaturProperty());
			//Listener
			
//			temp.temperaturProperty().addListener(new ChangeListener<Number>() {
//
//				@Override
//				public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//					// TODO Auto-generated method stub
//					
//				}
//			});
			temp.temperaturProperty().addListener( (observable,oldValue,newValue)->{
				//
				if(newValue!=null){
					pb.setProgress(newValue.doubleValue());
					
				}
			});
			
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
