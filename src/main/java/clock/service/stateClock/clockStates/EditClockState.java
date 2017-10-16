package clock.service.stateClock.clockStates;

public interface EditClockState {

    void nextClockEditState();
    void incrementTime();
    void decrementTime();
}
