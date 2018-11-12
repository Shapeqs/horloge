package clockView;

import clockModel.ClockModel;
import javafx.scene.control.Button;

public abstract class ButtonClockView extends ClockView{

    Button add = new Button("+");
    Button sub = new Button("-");

    public ButtonClockView(ClockModel model) {
        super(model);
        time.setLayoutX(270);
        add.setLayoutX(150);
        add.setLayoutY(200);
        sub.setLayoutX(add.getLayoutX() + 220);
        sub.setLayoutY(add.getLayoutY());
        pane.getChildren().addAll(add, sub);
    }
}
