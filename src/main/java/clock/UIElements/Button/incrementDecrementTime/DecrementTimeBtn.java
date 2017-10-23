package clock.UIElements.Button.incrementDecrementTime;

import clock.UIElements.Button.abstractButtons.IncrementDecrementButton;


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
