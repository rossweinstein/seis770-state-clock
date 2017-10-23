package clock.model.stateClock.clockStates;

import clock.model.stateClock.statePatternClock.ProgrammableClock;

public class SecondsEditState implements EditClockState {

    private ProgrammableClock clock;

    public SecondsEditState(ProgrammableClock clock) {
        this.clock = clock;
    }

    @Override
    public void nextClockEditState() {
        this.clock.setClockState(new HoursEditState(clock));
    }

    @Override
    public void incrementTime() {
        this.clock.incrementSecond();
    }

    @Override
    public void decrementTime() {
        this.clock.decrementSecond();
    }
}
