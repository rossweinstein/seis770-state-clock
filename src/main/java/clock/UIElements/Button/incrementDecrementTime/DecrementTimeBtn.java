package clock.UIElements.Button.incrementDecrementTime;

import clock.UIElements.Button.abstractButtons.IncrementDecrementButton;

/**
 * Created by Pamela on 10/17/17.
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
