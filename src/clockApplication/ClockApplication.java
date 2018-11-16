package clockApplication;

import clockControler.ClockControler;
import clockView.*;
import clockModel.ClockModel;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.text.SimpleDateFormat;
import java.util.*;

public class ClockApplication extends Application {

    private ClockModel model;
    private ClockControler controler;
    private ArrayList<Stage> stages = new ArrayList<>();

    private final int SECOND_ADDED = 1;
    private final long SLEEP_TIME_MILLISECOND = 1000;

    @Override
    public void start(Stage all) {

        Date d = new Date();
        SimpleDateFormat h = new SimpleDateFormat("hh");
        SimpleDateFormat m = new SimpleDateFormat("mm");
        SimpleDateFormat s = new SimpleDateFormat("ss");
        int H = Integer.parseInt(h.format(d));
        int M = Integer.parseInt(m.format(d));
        int S = Integer.parseInt(s.format(d));

        model = new ClockModel(H, M, S);
        //model = new ClockModel(0, 0, 0);
        controler = new ClockControler(model);

        double height = 335;
        double width = 600;
        double col1 = 1030;
        double col2 = 700;
        double row1 = 30;
        double row2 = 370;
        double row3 = 800;

        String name = "QUERRE";

        ClockViewAll clockViewAll = new ClockViewAll(model, controler);
        ButtonClockViewAll buttonClockViewAll = new ButtonClockViewAll(model, controler);
        HourClockView hourClockView = new HourClockView(model, controler);
        MinuteClockView minuteClockView = new MinuteClockView(model, controler);
        SecondClockView secondClockView = new SecondClockView(model, controler);

        model.addObserver(clockViewAll);
        model.addObserver(buttonClockViewAll);
        model.addObserver(hourClockView);
        model.addObserver(minuteClockView);
        model.addObserver(secondClockView);

        Stage all2 = new Stage();
        Stage hour = new Stage();
        Stage minute = new Stage();
        Stage second = new Stage();

        all.setTitle(name + " - all");
        stages.add(all);
        all.setScene(clockViewAll.scene());
        all.setX(col2);
        all.setY(row1);

        all2.setTitle(name + " - all2");
        all2.setScene(buttonClockViewAll.scene());
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
            stage.setOnCloseRequest(e -> Platform.exit());
            stage.show();
        }

        Platform.runLater(() -> {
            final ScheduledService<Void> time = new ScheduledService<Void>() {
                @Override
                protected Task<Void> createTask() {
                    return new Task<Void>() {

                        @Override
                        protected Void call() {
                            Platform.runLater(() -> {
                                controler.incSecond(SECOND_ADDED);
                                System.out.println(model.getHour() + ":" + model.getMinute() + ":" + model.getSecond());
                            });
                            return null;
                        }
                    };
                }

            };
            time.setPeriod(Duration.seconds(1));
            time.start();
        });

        /*Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(1000),
                ae -> controler.incSecond(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();*/


    }

    public static void main(String[] args) {
        launch(args);
    }
}
