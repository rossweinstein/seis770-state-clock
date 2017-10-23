package clock.model.stateClock.clockStates;


import clock.model.stateClock.statePatternClock.ProgrammableClock;

/**
 * SEIS 770 – Object Oriented Patterns & Architecture
 * State Pattern Clock: Heather Mortenson | Ross Weinstein
 */

public class MinutesEditState implements EditClockState {

    private ProgrammableClock clock;

    public MinutesEditState(ProgrammableClock clock) {
        this.clock = clock;
    }

    @Override
    public void nextClockEditState() {
        this.clock.setClockState(new SecondsEditState(clock));
    }

    @Override
    public void incrementTime() {
        this.clock.incrementMinute();
    }

    @Override
    public void decrementTime() {
        this.clock.decrementMinute();
    }
}
