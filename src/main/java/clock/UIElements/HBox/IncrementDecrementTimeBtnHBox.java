package clock.UIElements.HBox;

import clock.UIElements.Button.incrementDecrementTime.DecrementTimeBtn;
import clock.UIElements.Button.incrementDecrementTime.IncrementTimeBtn;
import javafx.scene.layout.HBox;

public class IncrementDecrementTimeBtnHBox extends HBox {

    public IncrementDecrementTimeBtnHBox() {
        this.getChildren().addAll(
                new DecrementTimeBtn(),
                new IncrementTimeBtn()
        );
    }
}
