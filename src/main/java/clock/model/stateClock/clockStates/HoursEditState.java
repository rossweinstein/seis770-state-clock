package clock.model.stateClock.clockStates;


import clock.model.stateClock.statePatternClock.ProgrammableClock;

public class HoursEditState implements EditClockState {

    private ProgrammableClock clock;

    public HoursEditState(ProgrammableClock clock) {
        this.clock = clock;
    }

    @Override
    public void nextClockEditState() {
        this.clock.setClockState(new MinutesEditState(clock));
    }

    @Override
    public void incrementTime() {
        this.clock.incrementHour();
    }

    @Override
    public void decrementTime() {
        this.clock.decrementHour();
    }
}