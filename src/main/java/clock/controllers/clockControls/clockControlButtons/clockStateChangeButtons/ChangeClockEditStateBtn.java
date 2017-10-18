package clock.controllers.clockControls.clockControlButtons.clockStateChangeButtons;

import clock.controllers.clockControls.clockControlButtons.abstractButtons.ClockStateEditButton;

public class ChangeClockEditStateBtn extends ClockStateEditButton {

    public ChangeClockEditStateBtn() {
        super();
        this.setUpButton();
    }

    private void setUpButton() {
        this.setText("Edit Hours");
        this.setStyle("-fx-text-fill: yellow;");
        this.setOnAction((event) -> {
            this.makeSureClockIsRunning();
            this.clock.nextClockEditState();
            this.updateChangeClockEditStateBtnText();
        });
    }

    private void updateChangeClockEditStateBtnText() {
        if (this.textProperty().get().equals("Edit Hours")) {
            this.setText(" Edit Min ");
        } else if (this.textProperty().get().equals(" Edit Min ")) {
            this.setText(" Edit Sec ");
        } else {
            this.setText("Edit Hours");
        }
    }
}
