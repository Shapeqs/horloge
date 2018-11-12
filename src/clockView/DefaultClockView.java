package clockView;

import clockModel.ClockModel;
import javafx.scene.control.Button;

import java.util.Observable;

public class DefaultClockView extends ButtonClockView {

    public DefaultClockView(ClockModel model) {
        super(model);
        int spacing = 190;
        time.setLayoutX(180);
        Button third = new Button("+1000s");
        third.setOnAction(e-> controler.incSecond(1000));
        third.setLayoutX(30);
        third.setLayoutY(add.getLayoutY());
        add.setOnAction(e-> controler.incSecond(100));
        add.setText("+100s");
        add.setLayoutX(third.getLayoutX() + third.getWidth() + spacing);
        sub.setOnAction(e-> controler.incSecond(10));
        sub.setText("+10s");
        sub.setLayoutX(add.getLayoutX() + add.getWidth() + spacing);
        time.setText(model.getHour() + "h:" + model.getMinute() + "m:" + model.getSecond() + "s");
        pane.getChildren().add(third);
    }

    @Override
    public void update(Observable observable, Object o) {
        time.setText(model.getHour() + "h:" + model.getMinute() + "m:" + model.getSecond() + "s");
    }
}
