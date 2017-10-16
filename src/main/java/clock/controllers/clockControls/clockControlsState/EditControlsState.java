package clock.controllers.clockControls.clockControlsState;

import clock.controllers.clockControls.ClockControls;
import clock.service.stateClock.clockStates.SecondsEditState;
import clock.service.stateClock.statePatternClock.ProgrammableClock;
import clock.service.stateClock.statePatternClock.StateClock;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.util.Arrays;
import java.util.List;

public class EditControlsState implements ClockControlsState{

    private Button changeClockEditStateBtn;
    private Button returnToNoEditStateBtn;

    private HBox incrementDecrementTimeBtnHBox;
    private Button incrementTimeBtn;
    private Button decrementTimeBtn;

    private ClockControls clockControls;
    private StateClock clock;

    public EditControlsState(ClockControls clockControls) {
        this.clockControls = clockControls;
        this.clock = ProgrammableClock.getClock();
        this.setUpAllButtons();
    }

    @Override
    public void toggleClockControlState() {
        this.clockControls.setClockControlsEditState(this.clockControls.getNoEditState());
    }

    @Override
    public List<Node> getAllChildren() {
        return Arrays.asList(this.incrementDecrementTimeBtnHBox, this.changeClockEditStateBtn, this.returnToNoEditStateBtn);
    }

    private void setUpAllButtons() {
        this.setUpChangeClockEditStateBtn();
        this.setUpReturnToNoEditStateBtn();
        this.setUpIncrementDecrementTimeHBox();
    }

    private void setUpChangeClockEditStateBtn() {
        this.changeClockEditStateBtn = new Button("Edit Hours");
        this.changeClockEditStateBtn.getStyleClass().add("editButton");
        this.changeClockEditStateBtn.setStyle("-fx-text-fill: yellow;");
        this.changeClockEditStateBtn.setOnAction( (event) -> {
            this.makeSureClockIsRunning();
            this.clock.nextClockEditState();
            this.updateChangeClockEditStateBtnText();
        });
    }

    private void updateChangeClockEditStateBtnText() {
        if (this.changeClockEditStateBtn.textProperty().get().equals("Edit Hours")) {
            this.changeClockEditStateBtn.setText(" Edit Min ");
        } else if (this.changeClockEditStateBtn.textProperty().get().equals(" Edit Min ")) {
            this.changeClockEditStateBtn.setText(" Edit Sec ");
        } else {
            this.changeClockEditStateBtn.setText("Edit Hours");
        }
    }

    private void setUpReturnToNoEditStateBtn() {
        this.returnToNoEditStateBtn = new Button(" End ");
        this.returnToNoEditStateBtn.getStyleClass().add("editButton");
        this.returnToNoEditStateBtn.setOnAction( (event) -> {
            this.makeSureClockIsRunning();
            this.clock.resetToNoEditClockEditState();
            this.changeClockEditStateBtn.setText("Edit Hours");
            this.toggleClockControlState();
        });
    }

    private Button setUpIncrementTimeBtn() {
        this.incrementTimeBtn = new Button("+");
        this.incrementTimeBtn.getStyleClass().add("editButton");
        this.incrementTimeBtn.setOnAction( (event) -> {
            this.pauseIfEditingSeconds();
            this.clock.incrementTime();
        });
        return this.incrementTimeBtn;
    }

    private Button setUpDecrementTimeBtn() {
        this.decrementTimeBtn = new Button("-");
        this.decrementTimeBtn.getStyleClass().add("editButton");
        this.decrementTimeBtn.setOnAction( (event) -> {
            this.pauseIfEditingSeconds();
            this.clock.decrementTime();
        });
        return this.decrementTimeBtn;
    }

    private void setUpIncrementDecrementTimeHBox() {
        this.incrementDecrementTimeBtnHBox = new HBox();
        incrementDecrementTimeBtnHBox.getChildren().addAll(this.setUpDecrementTimeBtn(), this.setUpIncrementTimeBtn());
    }

    private void pauseIfEditingSeconds() {
        if (this.clock.getClockState() instanceof SecondsEditState) {
            this.clock.pause();
        }
    }

    private void makeSureClockIsRunning() {
        if (!this.clock.isClockRunning()) {
            this.clock.run();
        }
    }
}
