package application;
	
import com.library.model.TestData;
import com.library.recourse.Resource;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			TestData testData = new TestData();
			testData.addDummyData();
			Parent root = FXMLLoader.load(getClass().getResource(Resource.MAINSCREEN));
			Scene scene = new Scene(root, 1150, 800);
			primaryStage.setTitle("Library project group 7");
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
