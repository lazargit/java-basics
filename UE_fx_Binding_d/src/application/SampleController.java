package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.shape.Rectangle;

public class SampleController implements Initializable{

	@FXML ColorPicker colorPicker;
	@FXML Rectangle rec;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Binding verwenden
		
		
		rec.fillProperty().bind(colorPicker.valueProperty());
		
	}
	
}
