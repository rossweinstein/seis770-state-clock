package clock.service.stateClock.clockStates;


import clock.service.stateClock.statePatternClock.ProgrammableClock;

public class HoursEditState implements EditClockState {

    private ProgrammableClock clock;

    public HoursEditState(ProgrammableClock clock) {
        this.clock = clock;
    }

    @Override
    public void nextClockEditState() {
        this.clock.setClockState(this.clock.getMinutesEditState());
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
