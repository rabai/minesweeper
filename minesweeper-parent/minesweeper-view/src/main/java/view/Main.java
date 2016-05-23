package view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
/**
 * A Main osztály, ahol az alkalmazás elindul.
 *
 */
// CHECKSTYLE:OFF
public class Main extends Application {

	/**
	 * A JavaFX-es kezdőképernyő betöltése.
	 * @param primaryStage a JavaFX által konstruált kezdő stage 
	 */
	@Override
	public void start(Stage primaryStage) {
		GridPane root;
		try {
			root = (GridPane) FXMLLoader.load(getClass().getResource("/view/StartScreen.fxml"));
			
			Scene scene = new Scene(root);
			
			primaryStage.setTitle("Aknakereső");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
