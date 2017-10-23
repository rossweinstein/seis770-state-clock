package clock.model.stateClock.clockStates;

/**
 * SEIS 770 – Object Oriented Patterns & Architecture
 * State Pattern Clock: Heather Mortenson | Ross Weinstein
 */

public interface EditClockState {
    void nextClockEditState();
    void incrementTime();
    void decrementTime();
}
