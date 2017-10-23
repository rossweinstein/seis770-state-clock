package clock.UIElements.Button.incrementDecrementTime;

import clock.UIElements.Button.abstractButtons.IncrementDecrementButton;

/**
 * SEIS 770 – Object Oriented Patterns & Architecture
 * State Pattern Clock: Heather Mortensen | Ross Weinstein
 */

public class IncrementTimeBtn extends IncrementDecrementButton {

    public IncrementTimeBtn() {
        super();
        this.setUpButton();
    }

    private void setUpButton() {
        this.setText("+");
        this.setOnAction( (event) -> {
            this.pauseIfEditingSeconds();
            this.clock.incrementTime();
        });
    }
}
