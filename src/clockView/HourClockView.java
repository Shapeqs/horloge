package clockView;

import clockControler.ClockControler;
import clockModel.ClockModel;

import java.util.Observable;

public class HourClockView extends ButtonClockView {

    public HourClockView(ClockModel model, ClockControler controler) {
        super(model, controler);
        add.setOnAction(e-> this.controler.incHour(1));
        sub.setOnAction(e-> this.controler.incHour(-1));
        time.setText(model.getHour() + "");
    }

    @Override
    public void update(Observable observable, Object o) {
        time.setText(model.getHour() + "");
    }
}
