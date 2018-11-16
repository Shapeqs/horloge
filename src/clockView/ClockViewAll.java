package clockView;

import clockControler.ClockControler;
import clockModel.ClockModel;

import java.util.Observable;

public class ClockViewAll extends ClockView{

    public ClockViewAll(ClockModel model, ClockControler controler) {
        super(model, controler);
        time.setText(model.getHour() + "h:" + model.getMinute() + "m:" + model.getSecond() + "s");
    }

    @Override
    public void update(Observable observable, Object o) {
        time.setText(model.getHour() + "h:" + model.getMinute() + "m:" + model.getSecond() + "s");
    }
}
