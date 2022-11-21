package sep4Project.Controller;


import javafx.fxml.FXML;
import sep4Project.DAO.EnergyStatusDAO;
import sep4Project.Model.EnergyStatusModel;
import com.sun.glass.ui.View;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class EnergyStatusController {

    @FXML
    public TableColumn EnergySDateTime;
    @FXML
    public TableColumn EnergySPower;
    @FXML
    public Button EnergyStatus;
    @FXML
    public TextField SolarPanelID;
    @FXML
   public  TableView EnergySTable;

    EnergyStatusDAO da = new EnergyStatusDAO();

    public void checkButton() {
        getEnergyStatusByID(SolarPanelID.getText());

    }

    public void initialize() {

        ArrayList<EnergyStatusModel> a = (ArrayList<EnergyStatusModel>) da.getEnergyStatus();
        ObservableList<EnergyStatusModel> data = FXCollections.<EnergyStatusModel>observableArrayList(a);

        EnergySDateTime.setCellValueFactory(new PropertyValueFactory<View, String>("DateAndTime"));
        EnergySPower.setCellValueFactory(new PropertyValueFactory<View, String>("Power"));

        EnergySTable.setItems(data);
    }

    public void getEnergyStatusByID(String ID) {
        ID = SolarPanelID.getText();

        ArrayList<EnergyStatusModel> a = (ArrayList<EnergyStatusModel>) da.getEnergyStatusByID(ID);
        ObservableList<EnergyStatusModel> data = FXCollections.<EnergyStatusModel>observableArrayList(a);

        EnergySDateTime.setCellValueFactory(new PropertyValueFactory<View, String>("DateAndTime"));
        EnergySPower.setCellValueFactory(new PropertyValueFactory<View, String>("Power"));

        EnergySTable.setItems(data);
    }
}

