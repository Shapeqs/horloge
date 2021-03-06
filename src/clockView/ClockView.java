package clockView;

import clockControler.ClockControler;
import clockModel.ClockModel;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

import java.util.Observer;

public abstract class ClockView implements Observer {
    private Scene scene;
    final AnchorPane pane = new AnchorPane();
    final TextField time = new TextField();
    protected ClockControler controler;
    final protected ClockModel model;

    ClockView(ClockModel model, ClockControler controler) {
        this.model = model;
        this.controler = controler;
        pane.setId("root");
        pane.getChildren().add(time);
        time.setLayoutX(80);
        time.setLayoutY(30);
        scene = new Scene(pane, 300, 150);
        scene.getStylesheets().add("file:resources/style.css");
    }

    public Scene scene() {
        return scene;
    }
}
