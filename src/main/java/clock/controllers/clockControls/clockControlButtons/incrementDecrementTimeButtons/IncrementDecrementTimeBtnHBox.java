package clock.controllers.clockControls.clockControlButtons.incrementDecrementTimeButtons;

import javafx.scene.layout.HBox;

public class IncrementDecrementTimeBtnHBox extends HBox {

    public IncrementDecrementTimeBtnHBox() {
        this.getChildren().addAll(
                new DecrementTimeBtn(),
                new IncrementTimeBtn()
        );
    }
}
