package clockView;

import clockControler.ClockControler;
import clockModel.ClockModel;

import java.util.Observable;

public class MinuteClockView extends ButtonClockView {

    public MinuteClockView(ClockModel model, ClockControler controler) {
        super(model, controler);
        add.setOnAction(e -> this.controler.incMinute(1));
        sub.setOnAction(e -> this.controler.incMinute(-1));
        time.setText(model.getMinute() + "");
    }

    @Override
    public void update(Observable observable, Object o) {
        time.setText(model.getMinute() + "");
    }
}
