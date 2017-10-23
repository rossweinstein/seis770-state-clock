package clock.model.stateClock.statePatternClock;

import clock.model.stateClock.clockStates.EditClockState;
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
    Observable<String> stateChange();
}
