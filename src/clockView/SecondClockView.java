package clockView;

import clockControler.ClockControler;
import clockModel.ClockModel;
import javafx.scene.input.KeyCode;

import java.util.Observable;

public class SecondClockView extends ButtonClockView {

    public SecondClockView(ClockModel model, ClockControler controler) {
        super(model, controler);
        add.setOnAction(e-> this.controler.incSecond(1));
        sub.setOnAction(e-> this.controler.incSecond(-1));
        time.setText(model.getSecond() + "");
        time.setOnKeyPressed(e->{
            int number;
            if (e.getCode() == KeyCode.ENTER) {
                try {
                    number = Integer.parseInt(time.getText());
                } catch (NumberFormatException exeption){
                    number = model.getSecond();
                }
                this.controler.incSecond(number-model.getSecond());
            }
        });
    }

    @Override
    public void update(Observable observable, Object o) {
        time.setText(model.getSecond() + "");
    }
}
