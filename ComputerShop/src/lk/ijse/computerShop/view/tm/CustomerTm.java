package lk.ijse.computerShop.view.tm;

import javafx.scene.control.Button;

public class CustomerTm {
    private long id;
    private String name;
    private String address;
    private String contact;
    private Button btn;

    public CustomerTm() {
    }

    public CustomerTm(long id, String name, String address, String contact, Button btn) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.btn = btn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
