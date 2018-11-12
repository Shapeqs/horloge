package clockModel;

import clockException.ClockException;

import java.util.Observable;

public class ClockModel extends Observable {
    public static final int MAX_HOUR = 24;
    public static final int MAX_MINSEC = 60;
    public static final int MIN_TIME = 0;
    int hour = 0;
    int minute = 0;
    int second = 0;

    public ClockModel(){
    }

    public ClockModel(int h, int m, int s){
        hour = h;
        minute = m;
        second = s;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public void setHour(int hour) throws ClockException {
        if (minute >= MIN_TIME && minute < MAX_MINSEC) {
            this.hour = hour;
            setChanged();
            notifyObservers();
        } else {
            throw new ClockException("Heures non comprises entre 0 et 23");
        }
    }

    public void setMinute(int minute) throws ClockException {
        if (minute >= MIN_TIME && minute < MAX_MINSEC) {
            this.minute = minute;
            setChanged();
            notifyObservers();
        } else {
            throw new ClockException("Minutes non comprises entre 0 et 59");
        }
    }

    public void setSecond(int second) throws ClockException {
        if (second >= MIN_TIME && second < MAX_MINSEC) {
            this.second = second;
            setChanged();
            notifyObservers();
        } else {
            throw new ClockException("Secondes non comprises entre 0 et 59");
        }
    }
}
