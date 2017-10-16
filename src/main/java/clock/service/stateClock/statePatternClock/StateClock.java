package clock.service.stateClock.statePatternClock;

import clock.service.stateClock.clockStates.EditClockState;
import io.reactivex.Observable;
import javafx.beans.property.IntegerProperty;

public interface StateClock extends EditClockState {

    EditClockState getClockState();
    void setClockState(EditClockState clockState);
    void resetToNoEditClockEditState();
    void setClockToHoursEditState();
    IntegerProperty hoursProperty();
    IntegerProperty minutesProperty();
    IntegerProperty secondsProperty();
    void run();
    void pause();
    boolean isClockRunning();
    Observable<EditClockState> stateChange();
}
