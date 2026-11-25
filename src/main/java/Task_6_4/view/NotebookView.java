package Task_6_4.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NotebookView extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Task6.4.2.0.fxml"));
        Parent root = fxmlLoader.load();

        stage.setTitle("Notebook");
        stage.setScene(new Scene(root));
        stage.show();
    }
}