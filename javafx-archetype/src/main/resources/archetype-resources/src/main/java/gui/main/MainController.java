package ${package}.gui.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

	@FXML
	private BorderPane rootPane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void handleExampleButton(ActionEvent event) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Example alert");
		alert.setHeaderText("Example header");
		alert.setContentText("Example content");

		alert.showAndWait();
	}
}
