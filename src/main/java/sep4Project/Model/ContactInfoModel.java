package sep4Project.Model;

public class ContactInfoModel {

        private String ID;
        private String Name;
        private String Address;
        private String Phone;
        private String Email;

        public ContactInfoModel(String id, String name, String address, String phone, String email) {
            this.ID = id;
            this.Name = name;
            this.Address = address;
            this.Phone = phone;
            this.Email = email;
        }

        public String getID() {
            return ID;
        }
        public String getName() {
            return Name;
        }

        public void setName(String name) {
            this.Name = name;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String address) {
            this.Address = address;
        }

        public String getPhone() {
            return Phone;
        }

        public void setPhone(String phone) {
            this.Phone = phone;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String email) {
            this.Email = email;
        }
    }

