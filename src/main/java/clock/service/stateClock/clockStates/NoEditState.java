package clock.service.stateClock.clockStates;

import clock.service.stateClock.statePatternClock.ProgrammableClock;

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
