package clockView;

import clockApplication.ClockApplication;
import clockModel.ClockModel;

import java.util.Observable;

public class HourClockView extends ButtonClockView {

    public HourClockView(ClockModel model) {
        super(model);
        add.setOnAction(e->{
            controler.incHour(1);
        });
        sub.setOnAction(e->{
            controler.incHour(-1);
        });
        time.setText(model.getHour() + "");

        System.out.println(model.getHour());
        System.out.println(model.getMinute());
    }

    @Override
    public void update(Observable observable, Object o) {
        time.setText(model.getHour() + "");
    }
}
