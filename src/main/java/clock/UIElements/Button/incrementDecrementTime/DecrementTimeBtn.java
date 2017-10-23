package clock.UIElements.Button.incrementDecrementTime;

import clock.UIElements.Button.abstractButtons.IncrementDecrementButton;

/**
 * SEIS 770 – Object Oriented Patterns & Architecture
 * State Pattern Clock: Heather Mortenson | Ross Weinstein
 */

public class DecrementTimeBtn extends IncrementDecrementButton {

    public DecrementTimeBtn() {
        super();
        this.setUpButton();
    }

    private void setUpButton() {
        this.setText("-");
        this.setOnAction( (event) -> {
            this.pauseIfEditingSeconds();
            this.clock.decrementTime();
        });
    }
}
