package clock.service.stateClock.statePatternClock;

import clock.service.stateClock.clockStates.*;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

import java.time.LocalTime;

public class ProgrammableClock extends Clock implements StateClock {

    private static StateClock clock = new ProgrammableClock();

    private EditClockState noEditState;
    private EditClockState hoursEditState;
    private EditClockState minutesEditState;
    private EditClockState secondsEditState;
    private EditClockState clockState;
    private PublishSubject<EditClockState> stateHasChanged;

    private ProgrammableClock() {
        super(LocalTime.now());
        this.noEditState = new NoEditState(this);
        this.hoursEditState = new HoursEditState(this);
        this.minutesEditState = new MinutesEditState(this);
        this.secondsEditState = new SecondsEditState(this);
        this.clockState = this.noEditState;

        this.stateHasChanged = PublishSubject.create();
    }

    public static StateClock getClock() {
        return clock;
    }

    public EditClockState getHoursEditState() {
        return hoursEditState;
    }

    public EditClockState getMinutesEditState() {
        return minutesEditState;
    }

    public EditClockState getSecondsEditState() {
        return secondsEditState;
    }

    public Observable<EditClockState> stateChange() {
        return this.stateHasChanged;
    }

    @Override
    public void nextClockEditState() {
        this.clockState.nextClockEditState();
        this.stateHasChanged.onNext(this.getClockState());
    }

    @Override
    public void incrementTime() {
        this.clockState.incrementTime();
    }

    @Override
    public void decrementTime() {
        this.clockState.decrementTime();
    }

    @Override
    public void setClockState(EditClockState nextClockState) {
        this.clockState = nextClockState;
    }

    @Override
    public EditClockState getClockState() {
        return this.clockState;
    }

    @Override
    public void resetToNoEditClockEditState() {

        this.clockState = this.noEditState;
        this.stateHasChanged.onNext(this.getClockState());
    }

    @Override
    public void setClockToHoursEditState() {
        this.clockState = this.hoursEditState;
    }
}
