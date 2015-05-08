package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {

	private Stage primaryStage;
	private AnchorPane anchorPane;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		mainView();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void mainView() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/mainView.fxml"));
			anchorPane = (AnchorPane) loader.load();
			
			MainViewController controller = loader.getController();
			controller.setMain(this);
			
			Scene scene = new Scene(anchorPane);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
