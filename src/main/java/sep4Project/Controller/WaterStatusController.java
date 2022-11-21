package sep4Project.Controller;

import com.sun.glass.ui.View;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sep4Project.DAO.WaterStatusDAO;
import sep4Project.Model.WaterStatusModel;

import java.util.ArrayList;

public class WaterStatusController {

    @FXML
    public TextField panelID;
    @FXML
    public Button check;
    @FXML
    public TableView waterTable;
    @FXML
    public TableColumn creationDate;
    @FXML
    public TableColumn Consumption;

    WaterStatusDAO da = new WaterStatusDAO();


    public void checkButton() {
        getWaterStatusByID(panelID.getText());

    }

    public void initialize() {

        ArrayList<WaterStatusModel> a = (ArrayList<WaterStatusModel>) da.getWaterStatus();
        ObservableList<WaterStatusModel> data = FXCollections.<WaterStatusModel>observableArrayList(a);

        creationDate.setCellValueFactory(new PropertyValueFactory<View, String>("DateAndTime"));
        Consumption.setCellValueFactory(new PropertyValueFactory<View, String>("WaterConsumption"));

        waterTable.setItems(data);
    }

    public void getWaterStatusByID(String ID) {
        ID = panelID.getText();

        ArrayList<WaterStatusModel> a = (ArrayList<WaterStatusModel>) da.getWaterStatusByID(ID);
        ObservableList<WaterStatusModel> data = FXCollections.<WaterStatusModel>observableArrayList(a);

        creationDate.setCellValueFactory(new PropertyValueFactory<View, String>("DateAndTime"));
        Consumption.setCellValueFactory(new PropertyValueFactory<View, String>("WaterConsumption"));

        waterTable.setItems(data);
    }

}
