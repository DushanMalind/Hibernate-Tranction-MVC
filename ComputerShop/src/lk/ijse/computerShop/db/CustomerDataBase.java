package lk.ijse.computerShop.db;

import lk.ijse.computerShop.to.Customer;

import java.util.ArrayList;

public class CustomerDataBase {
    public static ArrayList<Customer>customerTable=new ArrayList<Customer>();

    static {
        customerTable.add(
                new Customer(001,"Bandara","Galle","25000")
        );
    }

}
