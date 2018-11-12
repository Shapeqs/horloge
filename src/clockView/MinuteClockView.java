package clockView;

import clockModel.ClockModel;

import java.util.Observable;

public class MinuteClockView extends ButtonClockView {

    public MinuteClockView(ClockModel model) {
        super(model);
        add.setOnAction(e -> controler.incMinute(1));
        sub.setOnAction(e -> controler.incMinute(-1));
        time.setText(model.getMinute() + "");
    }

    @Override
    public void update(Observable observable, Object o) {
        time.setText(model.getMinute() + "");
    }
}
