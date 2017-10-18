package clock.service.stateClock.statePatternClock;

import clock.service.stateClock.clockStates.*;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

import java.time.LocalTime;

public class ProgrammableClock extends Clock implements StateClock {

    private static StateClock clock = new ProgrammableClock();

    private EditClockState clockState;
    private PublishSubject<String> stateChangeObserver;

    private ProgrammableClock() {
        super(LocalTime.now());
        this.clockState = new NoEditState(this);
        this.stateChangeObserver = PublishSubject.create();
    }

    public static StateClock getClock() {
        return clock;
    }

    public Observable<String> stateChange() {
        return this.stateChangeObserver;
    }

    @Override
    public void nextClockEditState() {
        this.clockState.nextClockEditState();
       this.sendStateChangeNotice();
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
        this.clockState = new NoEditState(this);
        this.sendStateChangeNotice();
    }

    @Override
    public void setClockToHoursEditState() {
        this.clockState = new HoursEditState(this);
        this.sendStateChangeNotice();
    }

    private void sendStateChangeNotice() {
        this.stateChangeObserver.onNext(this.getClockStateName());
    }

    private String getClockStateName() {
        String[] clockStateStringParts = this.getClockState().toString().split("\\.");
        return clockStateStringParts[4].split("@")[0];
    }
}
