package clock.controllers.clockControls.clockControlsState;

import javafx.scene.Node;
import java.util.List;

public interface ClockControlsState {
    void toggleClockControlState();
    List<Node> getAllChildren();
}
