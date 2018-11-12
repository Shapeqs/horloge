package clockView;

import clockControler.ClockControler;
import clockModel.ClockModel;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.Label;

import java.util.Observer;

public abstract class ClockView implements Observer {
    private Scene scene;
    final AnchorPane pane = new AnchorPane();
    final Label time = new Label();
    final ClockControler controler;
    final ClockModel model;

    ClockView(ClockModel model) {
        this.model = model;
        controler = new ClockControler(model);
        pane.setId("root");
        pane.getChildren().add(time);
        time.setLayoutX(180);
        time.setLayoutY(30);
        scene = new Scene(pane, 300, 150);
        scene.getStylesheets().add("file:resources/style.css");
    }

    public Scene scene() {
        return scene;
    }
}
