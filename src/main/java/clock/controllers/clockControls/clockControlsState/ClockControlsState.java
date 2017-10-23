package clock.controllers.clockControls.clockControlsState;

import javafx.scene.Node;
import java.util.List;

/**
 * SEIS 770 – Object Oriented Patterns & Architecture
 * State Pattern Clock: Heather Mortenson | Ross Weinstein
 */

public interface ClockControlsState {
    void toggleClockControlState();
    List<Node> getAllChildren();
}
