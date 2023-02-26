package lk.ijse.computerShop.to;

import javax.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @Column(name = "Customer_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "Customer_name")
    private String name;
    @Column(name = "Address")
    private String address;
    @Column(name = "Contact")
    private String contact;

    public Customer() {
    }

    public Customer(long id, String name, String address, String contact) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
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

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
