package sep4Project.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sep4Project.DAO.PanelInstallationDAO;
import sep4Project.Model.PanelInstallationModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class PanelInstallationController {

    @FXML
    public TableColumn id;
    @FXML
    public TableColumn panelType;
    @FXML
    public TableColumn placement;
    @FXML
    public TableColumn manufacture;
    @FXML
    public TableColumn date;
    @FXML
    public Button checkspesific;
    @FXML
    public TextField panelID;
    @FXML
    public DatePicker panelInstallDate;
    @FXML
    public TableView panelInstallTable;


    PanelInstallationDAO panIn = new PanelInstallationDAO();

    ArrayList<PanelInstallationModel> a = (ArrayList<PanelInstallationModel>) panIn.GetAllPanelInstallationData();
    ObservableList<PanelInstallationModel> data = FXCollections.<PanelInstallationModel>observableArrayList(a);

    public void initialize() {

        id.setCellValueFactory(new PropertyValueFactory<PanelInstallationModel, String>("id"));
        date.setCellValueFactory(new PropertyValueFactory<PanelInstallationModel, Date>("InstallDate"));
        placement.setCellValueFactory(new PropertyValueFactory<PanelInstallationModel, String>("Placement"));
        panelType.setCellValueFactory(new PropertyValueFactory<PanelInstallationModel, String>("PanelType"));
        manufacture.setCellValueFactory(new PropertyValueFactory<PanelInstallationModel, String>("Manufacturer"));

        panelInstallTable.setItems(data);
    }

    public void checkButton() {
        if (panelID.getText().equals("")) {
            getPanelInstallationByDate(panelInstallDate.getValue());
        } else {
            getPanelInstallationByID(panelID.getText());

        }
    }

    public void getPanelInstallationByID(String ID) {
        ID = panelID.getText();

        ArrayList<PanelInstallationModel> a = (ArrayList<PanelInstallationModel>) panIn.getPanelInstallationByID(ID);
        ObservableList<PanelInstallationModel> data = FXCollections.<PanelInstallationModel>observableArrayList(a);

        id.setCellValueFactory(new PropertyValueFactory<PanelInstallationModel, String>("id"));
        date.setCellValueFactory(new PropertyValueFactory<PanelInstallationModel, Date>("InstallDate"));
        placement.setCellValueFactory(new PropertyValueFactory<PanelInstallationModel, String>("Placement"));
        panelType.setCellValueFactory(new PropertyValueFactory<PanelInstallationModel, String>("PanelType"));
        manufacture.setCellValueFactory(new PropertyValueFactory<PanelInstallationModel, String>("Manufacturer"));

        panelInstallTable.setItems(data);

    }

    public void getPanelInstallationByDate(LocalDate installDate) {
        installDate = panelInstallDate.getValue();

        ArrayList<PanelInstallationModel> a = (ArrayList<PanelInstallationModel>) panIn.getPanelInstallationByDate(panelInstallDate);
        ObservableList<PanelInstallationModel> data = FXCollections.<PanelInstallationModel>observableArrayList(a);

        id.setCellValueFactory(new PropertyValueFactory<PanelInstallationModel, String>("id"));
        date.setCellValueFactory(new PropertyValueFactory<PanelInstallationModel, Date>("InstallDate"));
        placement.setCellValueFactory(new PropertyValueFactory<PanelInstallationModel, String>("Placement"));
        panelType.setCellValueFactory(new PropertyValueFactory<PanelInstallationModel, String>("PanelType"));
        manufacture.setCellValueFactory(new PropertyValueFactory<PanelInstallationModel, String>("Manufacturer"));

        panelInstallTable.setItems(data);
    }

}
