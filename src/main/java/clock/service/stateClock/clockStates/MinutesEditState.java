package clock.service.stateClock.clockStates;


import clock.service.stateClock.statePatternClock.ProgrammableClock;

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
