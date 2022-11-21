package sep4Project.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sep4Project.Model.ContactInfoModel;

public class EditContactController {

    @FXML
    public TextField name;
    @FXML
    public TextField address;
    @FXML
    public TextField phone;
    @FXML
    public TextField email;
    @FXML
    public TextField id;


    public ContactInfoModel getDataFromTextField(){
        String Name = name.getText();
        String Address = address.getText();
        String Phone = phone.getText();
        String Email = email.getText();
        String ID = id.getText();
        return new ContactInfoModel(ID,Name,Address,Phone,Email);
    }

    public void editContact(ContactInfoModel contact){
        name.setText(contact.getName());
        address.setText(contact.getAddress());
        phone.setText(contact.getPhone());
        email.setText(contact.getEmail());
    }


}
