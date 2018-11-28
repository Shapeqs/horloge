package clockView;

import clockControler.ClockControler;
import clockModel.ClockModel;
import javafx.scene.input.KeyCode;

import java.util.Observable;

public class HourClockView extends ButtonClockView {

    public HourClockView(ClockModel model, ClockControler controler) {
        super(model, controler);
        add.setOnAction(e-> this.controler.incHour(1));
        sub.setOnAction(e-> this.controler.incHour(-1));
        time.setText(model.getHour() + "");
        time.setOnKeyPressed(e->{
            int number;
            if (e.getCode() == KeyCode.ENTER) {
                try {
                    number = Integer.parseInt(time.getText());
                } catch (NumberFormatException exeption){
                    number = model.getHour();
                }
                this.controler.incHour(number-model.getHour());
            }
        });
    }

    @Override
    public void update(Observable observable, Object o) {
        time.setText(model.getHour() + "");
    }
}
