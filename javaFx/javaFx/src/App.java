import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {

        Label label = new Label("Welcome to JavaFX");

        Button button = new Button("Click Me");

        button.setOnAction(event -> {
            label.setText("Button clicked!");
        });

        VBox root = new VBox(20);
        root.getChildren().addAll(label, button);

        Scene scene = new Scene(root, 400, 250);

        stage.setTitle("JavaFX Demo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
