package clock.model.stateClock.clockStates;

public interface EditClockState {
    void nextClockEditState();
    void incrementTime();
    void decrementTime();
}
