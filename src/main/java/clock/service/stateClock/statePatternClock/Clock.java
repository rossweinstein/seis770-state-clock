package clock.service.stateClock.statePatternClock;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Clock extends TimerTask {

    private IntegerProperty hours;
    private IntegerProperty minutes;
    private IntegerProperty seconds;
    private Timer timer;
    private boolean clockIsRunning = false;

    public Clock(LocalTime time) {
        this.hours = new SimpleIntegerProperty(time.getHour());
        this.minutes = new SimpleIntegerProperty(time.getMinute());
        this.seconds = new SimpleIntegerProperty(time.getSecond());
    }

    public IntegerProperty hoursProperty() {
        return hours;
    }

    public IntegerProperty minutesProperty() {
        return minutes;
    }

    public IntegerProperty secondsProperty() {
        return seconds;
    }

    public String toString() {
        return "Current Set Time: " + this.hoursProperty().get() + ":" + this.minutesProperty().get()
                + ":" + this.secondsProperty().get();
    }

    public void incrementHour() {
        int adjustedTime = incrementTime(this.hours.get()) % 24;
        this.hours.set(adjustedTime);
    }

    public void decrementHour() {
        int adjustedTime = decrementTime(this.hours.get());
        int correctTime = adjustedTime < 0 ? 23 : adjustedTime;
        this.hours.set(correctTime);
    }

    public void incrementMinute() {
        int adjustedTime = correctMinutesAndSecondsIncrement(this.minutes.get());
        this.minutes.set(adjustedTime);
    }

    public void decrementMinute() {
        int adjustedTime = correctMinutesAndSecondsDecrement(this.minutes.get());
        this.minutes.set(adjustedTime);
    }

    public void incrementSecond() {
        int adjustedTime = correctMinutesAndSecondsIncrement(this.seconds.get());
        this.seconds.set(adjustedTime);
    }

    public void decrementSecond() {
        int adjustedTime = correctMinutesAndSecondsDecrement(this.seconds.get());
        this.seconds.set(adjustedTime);
    }

    private int correctMinutesAndSecondsIncrement (int time) {
        return incrementTime(time) % 60;
    }

    private int correctMinutesAndSecondsDecrement (int time) {
        int decrementedTime = decrementTime(time);
        return decrementedTime < 0 ? 59 : decrementedTime;
    }

    private int incrementTime(int currentTime) {
        return currentTime + 1;
    }

    private int decrementTime(int currentTime) {
        return currentTime - 1;
    }

    private void refreshClock() {
        if (seconds.get() == 0) {
            incrementMinute();
            if (minutes.get() == 0) {
                incrementHour();
            }
        }
    }

    @Override
    public void run() {
        this.timer = new Timer();
        this.clockIsRunning = true;
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                incrementSecond();
                refreshClock();
            }
        }, 1000, 1000);
    }

    public void pause() {
        if (this.clockIsRunning) {
            this.timer.cancel();
            this.clockIsRunning = false;
        }
    }

    public boolean isClockRunning() {
        return this.clockIsRunning;
    }
}
