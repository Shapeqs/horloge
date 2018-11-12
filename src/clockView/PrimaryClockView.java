package clockView;

import clockModel.ClockModel;

import java.util.Observable;

public class PrimaryClockView extends ClockView{

    public PrimaryClockView(ClockModel model) {
        super(model);
        time.setText(model.getHour() + "h:" + model.getMinute() + "m:" + model.getSecond() + "s");
    }

    @Override
    public void update(Observable observable, Object o) {
        time.setText(model.getHour() + "h:" + model.getMinute() + "m:" + model.getSecond() + "s");
    }
}
