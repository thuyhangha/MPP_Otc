package application;
	
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
			/*BorderPane root = new BorderPane();*/
			//Parent root = FXMLLoader.load(getClass().getResource(Resource.CHECKOUTBOOKFORM));
			Parent root = FXMLLoader.load(getClass().getResource(Resource.MEMBERVIEW));
			Scene scene = new Scene(root,800,600);
			/*Parent root = FXMLLoader.load(getClass().getResource(Resource.MEMBERADD));
			Scene scene = new Scene(root,500,600);*/
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			/*TestData test = new TestData();
			SerializeAll seALL = new SerializeAll();
			seALL.deSerializeData();*/
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
