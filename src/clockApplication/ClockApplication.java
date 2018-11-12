package clockApplication;

import clockView.*;
import clockModel.ClockModel;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.*;

public class ClockApplication extends Application {

    private ClockModel model;
    private ArrayList<Stage> stages = new ArrayList<>();
    private static ArrayList<ClockView> views = new ArrayList<>();

    @Override
    public void start(Stage all) {

        Date d = new Date();
        SimpleDateFormat h = new SimpleDateFormat ("hh");
        SimpleDateFormat m = new SimpleDateFormat ("mm");
        SimpleDateFormat s = new SimpleDateFormat ("ss");
        int H = Integer.parseInt(h.format(d));
        int M = Integer.parseInt(m.format(d));
        int S = Integer.parseInt(s.format(d));

        model = new ClockModel(H, M, S);
        //model = new ClockModel(23, 59, 59);

        double height = 335;
        double width = 600;
        double col1 = 30;
        double col2 = 700;
        double row1 = 30;
        double row2 = 370;
        double row3 = 800;

        String name = "QUERRE";

        PrimaryClockView primaryClockView = new PrimaryClockView(model);
        DefaultClockView defaultClockView = new DefaultClockView(model);
        HourClockView hourClockView = new HourClockView(model);
        MinuteClockView minuteClockView = new MinuteClockView(model);
        SecondClockView secondClockView = new SecondClockView(model);

        model.addObserver(primaryClockView);
        model.addObserver(defaultClockView);
        model.addObserver(hourClockView);
        model.addObserver(minuteClockView);
        model.addObserver(secondClockView);

        Stage all2 = new Stage();
        Stage hour = new Stage();
        Stage minute = new Stage();
        Stage second = new Stage();

        all.setTitle(name + " - all");
        stages.add(all);
        all.setScene(primaryClockView.scene());
        all.setX(col2);
        all.setY(row1);

        all2.setTitle(name + " - all2");
        all2.setScene(defaultClockView.scene());
        stages.add(all2);
        all2.setX(col2);
        all2.setY(row3);

        hour.setTitle(name + " - hour");
        hour.setScene(hourClockView.scene());
        stages.add(hour);
        hour.setX(col1);
        hour.setY(row1);

        minute.setTitle(name + " - minute");
        minute.setScene(minuteClockView.scene());
        stages.add(minute);
        minute.setX(col1);
        minute.setY(row2);

        second.setTitle(name + " - second");
        second.setScene(secondClockView.scene());
        stages.add(second);
        second.setX(col1);
        second.setY(row3);

        for (Stage stage : stages) {
            stage.setMaxHeight(height);
            stage.setMinHeight(height);
            stage.setMaxWidth(width);
            stage.setMinWidth(width);
            stage.setResizable(true);
            stage.setOnCloseRequest(e->Platform.exit());
            stage.show();
        }
    }

    public static void main(String[] args){
        launch(args);
    }
}
