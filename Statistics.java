import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Statistics {

    public  static void generateNumGroupStats(String title, String stats){
        Stage currentWindow = new Stage();
        Label label = new Label();
        HBox box = new HBox(20);
        box.getChildren().add(label);
        currentWindow.initModality(Modality.APPLICATION_MODAL);
        currentWindow.setTitle("Statistics for " + title);
        currentWindow.setMinWidth(400);
        currentWindow.setMinHeight(200);
        label.setText(stats);
        Scene sc = new Scene(box);
        currentWindow.setScene(sc);
        currentWindow.show();
    }

    public  static void generateNumUsersStats(String title, String stats){
        Stage currentWindow = new Stage();
        Label label = new Label();
        HBox box = new HBox(20);
        box.getChildren().add(label);
        currentWindow.initModality(Modality.APPLICATION_MODAL);
        currentWindow.setTitle("Statistics for " + title);
        currentWindow.setMinWidth(400);
        currentWindow.setMinHeight(200);
        label.setText(stats);
        Scene sc = new Scene(box);
        currentWindow.setScene(sc);
        currentWindow.show();
    }

    public  static void generatePositiveTweetsStats(String title, String stats){
        Stage currentWindow = new Stage();
        Label label = new Label();
        HBox box = new HBox(20);
        box.getChildren().add(label);
        currentWindow.initModality(Modality.APPLICATION_MODAL);
        currentWindow.setTitle("Statistics for " + title);
        currentWindow.setMinWidth(400);
        currentWindow.setMinHeight(200);
        label.setText(stats);
        Scene sc = new Scene(box);
        currentWindow.setScene(sc);
        currentWindow.show();
    }

    public  static void generateTotalTweetsStats(String title, String stats){
        Stage currentWindow = new Stage();
        Label label = new Label();
        HBox box = new HBox(20);
        box.getChildren().add(label);
        currentWindow.initModality(Modality.APPLICATION_MODAL);
        currentWindow.setTitle("Statistics for " + title);
        currentWindow.setMinWidth(400);
        currentWindow.setMinHeight(200);
        label.setText(stats);
        Scene sc = new Scene(box);
        currentWindow.setScene(sc);
        currentWindow.show();
    }
}
