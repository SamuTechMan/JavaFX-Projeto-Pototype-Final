package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class Main extends Application {
	// expondo uma referencia para cena principal
	private static Scene mainScene;

	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("MenuFX");
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/view.fxml"));
			ScrollPane scrollPane = loader.load();

			// Ajustar a barra de menu
			scrollPane.setFitToHeight(true);
			scrollPane.setFitToWidth(true);

			mainScene = new Scene(scrollPane);
			primaryStage.setTitle("Trabalho prático com Menu");
			primaryStage.setScene(mainScene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Scene getMainScene() {
		return mainScene;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
