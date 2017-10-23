package clock.UIElements.HBox;

import clock.UIElements.Button.incrementDecrementTime.DecrementTimeBtn;
import clock.UIElements.Button.incrementDecrementTime.IncrementTimeBtn;
import javafx.scene.layout.HBox;

/**
 * SEIS 770 – Object Oriented Patterns & Architecture
 * State Pattern Clock: Heather Mortensen | Ross Weinstein
 */

public class IncrementDecrementTimeBtnHBox extends HBox {

    public IncrementDecrementTimeBtnHBox() {
        this.getChildren().addAll(
                new DecrementTimeBtn(),
                new IncrementTimeBtn()
        );
    }
}
