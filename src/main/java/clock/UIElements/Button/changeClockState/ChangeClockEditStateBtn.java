package clock.UIElements.Button.changeClockState;

import clock.UIElements.Button.abstractButtons.ClockStateEditButton;

/**
 * SEIS 770 – Object Oriented Patterns & Architecture
 * State Pattern Clock: Heather Mortenson | Ross Weinstein
 */

public class ChangeClockEditStateBtn extends ClockStateEditButton {

    private String buttonText = "Edit Hours";

    public ChangeClockEditStateBtn() {
        super();
        this.setUpButton();
    }

    private void setUpButton() {
        this.setText(this.buttonText);
        this.setStyle("-fx-text-fill: yellow;");

        this.setOnAction((event) -> {
            this.makeSureClockIsRunning();
            this.clock.nextClockEditState();
            this.updateChangeClockEditStateBtnText();
        });

        this.setOnMouseEntered((event)-> {
            this.setText("Next State");
        });

        this.setOnMouseExited((event) -> {
            this.setText(this.buttonText);
        });
    }

    private void updateChangeClockEditStateBtnText() {
        if (this.buttonText.equals("Edit Hours")) {
            this.buttonText = " Edit Min ";
        } else if (this.buttonText.equals(" Edit Min ")) {
            this.buttonText = " Edit Sec ";
        } else {
            this.buttonText = "Edit Hours";
        }
        this.setText(this.buttonText);
    }
}
