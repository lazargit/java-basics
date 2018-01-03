package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			TreeView<String> tree = new TreeView<>();
			TreeItem<String> rootItem = new TreeItem<>("Root");
			TreeItem<String> item1 = new TreeItem<>("A");
			TreeItem<String> item1a = new TreeItem<>("AA");
			
			TreeItem<String> item2 = new TreeItem<>("B");
			
			rootItem.getChildren().add(item1);
			item1.getChildren().add(item1a);
			rootItem.getChildren().add(item2);
			rootItem.setExpanded(true);
			tree.setRoot(rootItem);
			
			root.setCenter(tree);
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
