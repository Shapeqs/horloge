package clockView;

import clockApplication.ClockApplication;
import clockModel.ClockModel;

import java.util.Observable;

public class SecondClockView extends ButtonClockView {

    public SecondClockView(ClockModel model) {
        super(model);
        add.setOnAction(e->controler.incSecond(1));
        sub.setOnAction(e->controler.incSecond(-1));
        time.setText(model.getSecond() + "");
    }

    @Override
    public void update(Observable observable, Object o) {
        time.setText(model.getSecond() + "");
    }
}
