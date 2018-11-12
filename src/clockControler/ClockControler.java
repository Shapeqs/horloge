package clockControler;

import clockException.ClockException;
import clockModel.ClockModel;

public class ClockControler {

    private ClockModel model;

    public ClockControler(ClockModel modele) {
        model = modele;
    }

    public void setHour(int newHour) {
        try {
            model.setHour(newHour);
        } catch (ClockException e) {
            e.printStackTrace();
        }
    }

    public void setMinute(int newMinute) {
        try {
            model.setMinute(newMinute);
        } catch (ClockException e) {
            e.printStackTrace();
        }
    }

    public void setSecond(int newSecond) {
        try {
            model.setSecond(newSecond);
        } catch (ClockException e) {
            e.printStackTrace();
        }
    }

    public void incHour(int ajout) {
        int h = model.getHour();
        int newHour = h + ajout;
        if (newHour < ClockModel.MIN_TIME){
            setHour(ClockModel.MAX_HOUR + (newHour % ClockModel.MAX_MINSEC));
        } else if (newHour >= ClockModel.MAX_HOUR){
            setHour(newHour % ClockModel.MAX_HOUR);
        } else {
            setHour(newHour);
        }
    }

    public void incMinute(int ajout) {
        int m = model.getMinute();
        int newMinute = m + ajout;
        if (newMinute < ClockModel.MIN_TIME){
            setMinute(ClockModel.MAX_MINSEC + (newMinute % ClockModel.MAX_MINSEC));
            incHour((ClockModel.MAX_MINSEC + newMinute) / ClockModel.MAX_MINSEC - 1);
        } else if (newMinute >= ClockModel.MAX_MINSEC){
            setMinute(newMinute % ClockModel.MAX_MINSEC);
            incHour(newMinute/ClockModel.MAX_MINSEC);
        } else {
            setMinute(newMinute);
        }
    }

    public void incSecond(int ajout) {
        int s = model.getSecond();
        int newSecond = s + ajout;
        if (newSecond < ClockModel.MIN_TIME){
            setSecond(ClockModel.MAX_MINSEC + (newSecond % ClockModel.MAX_MINSEC));
            incMinute((ClockModel.MAX_MINSEC + newSecond)/ClockModel.MAX_MINSEC - 1);
        } else if (newSecond >= ClockModel.MAX_MINSEC){
            setSecond(newSecond % ClockModel.MAX_MINSEC);
            incMinute(newSecond/ClockModel.MAX_MINSEC);
        } else {
            setSecond(newSecond);
        }
    }

}
