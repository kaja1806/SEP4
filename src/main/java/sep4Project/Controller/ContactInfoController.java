package sep4Project.Controller;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import sep4Project.DAO.ContactInfoDAO;
import sep4Project.Model.ContactInfoModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class ContactInfoController {
    @FXML
    public TableView ManufacturerTable;
    @FXML
    public TableColumn name;
    @FXML
    public TableColumn address;
    @FXML
    public TableColumn phone;
    @FXML
    public TableColumn email;
    @FXML
    public Button addNew;
    @FXML
    public TextField Name;
    @FXML
    public TextField Address;
    @FXML
    public TextField Phone;
    @FXML
    public TextField Email;
    @FXML
    public AnchorPane border;

    @FXML
    ContactInfoDAO ContactInfo = new ContactInfoDAO();
    ArrayList<ContactInfoModel> a = (ArrayList<ContactInfoModel>) ContactInfo.getAllContactInfo();
    ObservableList<ContactInfoModel> data = FXCollections.<ContactInfoModel>observableArrayList(a);

    public void initialize() {

        name.setCellValueFactory(new PropertyValueFactory<ContactInfoModel, String>("Name"));
        address.setCellValueFactory(new PropertyValueFactory<ContactInfoModel, String>("Address"));
        phone.setCellValueFactory(new PropertyValueFactory<ContactInfoModel, String>("Phone"));
        email.setCellValueFactory(new PropertyValueFactory<ContactInfoModel, String>("Email"));

        ManufacturerTable.setItems(data);

        ManufacturerTable.setRowFactory(
                new Callback<TableView<ContactInfoModel>, TableRow<ContactInfoModel>>() {
                    @Override
                    public TableRow<ContactInfoModel> call(TableView<ContactInfoModel> tableView) {
                        final TableRow<ContactInfoModel> row = new TableRow<>();
                        final ContextMenu rowMenu = new ContextMenu();
                        MenuItem editContact = new MenuItem("Edit");
                        editContact.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                showEditDialog((ContactInfoModel) ManufacturerTable.getSelectionModel().getSelectedItem());
                            }
                        });
                        MenuItem removeContact = new MenuItem("Delete");
                        removeContact.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                int index = data.indexOf(ManufacturerTable.getSelectionModel().getSelectedItem());
                                ContactInfo.deleteManufacturer(data.get(index).getID());
                                data.remove(ManufacturerTable.getSelectionModel().getSelectedItem());
                                ManufacturerTable.setItems(data);
                            }
                        });
                        rowMenu.getItems().addAll(editContact, removeContact);

                        row.contextMenuProperty().bind(Bindings.when(Bindings.isNotNull(row.itemProperty()))
                                .then(rowMenu).otherwise((ContextMenu) null));
                        return row;
                    }
                }
        );

    }

    @FXML
    public void showEditDialog(ContactInfoModel ContactInfoModel) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(border.getScene().getWindow());
        dialog.setTitle("Edit contact");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/EditContact.fxml"));
        try {
            dialog.getDialogPane().setContent(loader.load());
        } catch (IOException e) {
            System.out.println("Error in dialog panel :" + e);
        }

        ButtonType save = new ButtonType("Save");
        dialog.getDialogPane().getButtonTypes().add(save);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        EditContactController editContactController = loader.getController();
        editContactController.editContact(ContactInfoModel);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == save) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Update existing manufacturer contact details?");
            alert.setTitle("Confirm update");
            alert.setHeaderText("Save Changes?");
            Optional<ButtonType> result1 = alert.showAndWait();
            if (result1.isPresent() && result1.get() == ButtonType.OK) {

                ContactInfoModel updatedContact = editContactController.getDataFromTextField();
                data.add(data.indexOf(ContactInfoModel), updatedContact);
                data.remove(ContactInfoModel);
                ContactInfo.updateManufacturerData(updatedContact, ContactInfoModel.getID());

            }
        }
    }

    public void addNewManufacturer() {
        ContactInfo.createManufacturerData(Name.getText(), Address.getText(), Phone.getText(), Email.getText());
        Name.clear();
        Address.clear();
        Phone.clear();
        Email.clear();

        border.getClass().getResource("/View/ContactInfo.fxml");

        ManufacturerTable.setItems(data);
        name.setSortType(TableColumn.SortType.ASCENDING);

    }
}