
package sep4Project.Controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.*;

public class MainPageController {

    @FXML
    public AnchorPane energyStatus;
    @FXML
    public AnchorPane waterStatus;
    @FXML
    public AnchorPane ManufacturerInfo;
    @FXML
    public AnchorPane panelinstallation;
    @FXML
    public Tab showData;

    public AnchorPane getEnergyStatus() {
        return energyStatus;
    }

}