package clockView;

import clockControler.ClockControler;
import clockModel.ClockModel;
import javafx.scene.control.Button;

import java.util.Observable;

public class ButtonClockViewAll extends ButtonClockView {

    public ButtonClockViewAll(ClockModel model, ClockControler controler) {
        super(model, controler);
        time.setLayoutX(180);

        Button third = new Button("+1000s");
        third.setOnAction(e-> this.controler.incSecond(1000));
        third.setLayoutX(70);
        third.setLayoutY(add.getLayoutY());

        add.setOnAction(e-> this.controler.incSecond(100));
        add.setText("+100s");
        add.setLayoutX(third.getLayoutX() + 190);

        sub.setOnAction(e-> this.controler.incSecond(10));
        sub.setText("+10s");
        sub.setLayoutX(add.getLayoutX() + 160);

        time.setText(model.getHour() + "h:" + model.getMinute() + "m:" + model.getSecond() + "s");
        pane.getChildren().add(third);

    }

    @Override
    public void update(Observable observable, Object o) {
        time.setText(model.getHour() + "h:" + model.getMinute() + "m:" + model.getSecond() + "s");
    }
}
