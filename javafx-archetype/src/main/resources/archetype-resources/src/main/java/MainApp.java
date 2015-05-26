package ${package};

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ${package}.gui.main.MainController;

public class MainApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(MainController.class.getResource("main.fxml"));
		Parent view = loader.load();
		Scene scene = new Scene(view, 800, 600);
		primaryStage.setTitle("Sample application");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
