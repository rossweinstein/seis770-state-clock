package clock.model.stateClock.clockStates;

import clock.model.stateClock.statePatternClock.ProgrammableClock;

/**
 * SEIS 770 – Object Oriented Patterns & Architecture
 * State Pattern Clock: Heather Mortensen | Ross Weinstein
 */

public class NoEditState implements EditClockState {

    private ProgrammableClock clock;

    public NoEditState(ProgrammableClock clock) {
        this.clock = clock;
    }

    @Override
    public void nextClockEditState() {
        clock.setClockState(new HoursEditState(clock));
    }

    @Override
    public void incrementTime() {}

    @Override
    public void decrementTime() {}
}
