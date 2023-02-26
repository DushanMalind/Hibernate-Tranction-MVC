package lk.ijse.computerShop.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lk.ijse.computerShop.db.DBConnection;
import lk.ijse.computerShop.repository.CustomerRepository;
import lk.ijse.computerShop.to.Customer;
import lk.ijse.computerShop.view.tm.CustomerTm;

public class CustomerFormController {

    public AnchorPane mealPackagesId;

    public TextField txtCustomerId;
    public TextField txtCustomerName;
    public TextField txtAddress;
    public TextField txtContact;
    public TableView<CustomerTm> customerTable;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colOption;
    public TextField txtSearch;
    public Button btnCustomer;
    public Label lblId;
    public Label lblName;
    public Label lblAddress;
    public Label lblContact;


    private Matcher userId;
    private Matcher userName;
    private Matcher userAddress;
    private Matcher userContact;
    private String searchText = "";

    public static ArrayList<Customer> getAllCustomer() throws ClassNotFoundException, SQLException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet result = connection.prepareStatement("SELECT * FROM customer").executeQuery();
        ArrayList<Customer> data = new ArrayList();
        while (result.next()) {
            Customer c = new Customer(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)
            );

            data.add(c);
        }
        return data;*/
        return null;
    }

    public void btnBackMainWindow(ActionEvent actionEvent) throws IOException {
//        Navigation.navigation(Routes.DASHBOARD,mealPackagesId);
        mealPackagesId.getChildren().clear();
    }

    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));

        searchCustomers(searchText);

        customerTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (null != newValue) {
                setData(newValue);
            }
        });

        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            searchText = newValue;
            searchCustomers(searchText);
        });

        setPatterns();

    }

    private void setData(CustomerTm tm) {
        txtCustomerId.setText(String.valueOf(tm.getId()));
        txtCustomerName.setText(tm.getName());
        txtAddress.setText(tm.getAddress());
        txtContact.setText(tm.getContact());
        btnCustomer.setText("  Update Customer");
    }

    private void searchCustomers(String text) {
        String searchText = "%" + text + "%";
       /* try {
            ObservableList<CustomerTm> tmList = FXCollections.observableArrayList();

            Connection connection = DBConnection.getDbConnection().getConnection();
            String sql = "select * from customer WHERE name LIKE ? || address LIKE ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, searchText);
            statement.setString(2, searchText);
            ResultSet set = statement.executeQuery();

            while (set.next()) {
                Button btn = new Button("Delete");
                CustomerTm tm = new CustomerTm(set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4), btn);
                tmList.add(tm);

                btn.setOnAction(event -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure Deleted ?", ButtonType.YES, ButtonType.NO);
                    Optional<ButtonType> buttonType = alert.showAndWait();
                    if (buttonType.get() == ButtonType.YES) {

                        try {
                            Connection connection1 = DBConnection.getDbConnection().getConnection();
                            String sql1 = "Delete from Customer where cusId=?";
                            PreparedStatement statement1 = connection1.prepareStatement(sql1);
                            statement1.setString(1, tm.getId());

                            if (statement1.executeUpdate() > 0) {
                                searchCustomers(searchText);
                                new Alert(Alert.AlertType.INFORMATION, "Customer Deleted").show();
                            } else {
                                new Alert(Alert.AlertType.INFORMATION, "Customer Not Deleted").show();
                            }

                        } catch (ClassNotFoundException | SQLException e) {

                        }
                        *//*boolean isDeleted=CustomerDataBase.customerTable.remove(c);*//*
                    }
                });
            }
            customerTable.setItems(tmList);
        } catch (ClassNotFoundException | SQLException e) {

        }
        *//*ObservableList<CustomerTm> tmList= FXCollections.observableArrayList();
        for (Customer c:CustomerDataBase.customerTable
             ) {
        }*/

    }

    private void setPatterns() {

        Pattern userIdPattern = Pattern.compile(".*(C0)([1-9]{1})([0-9]{1}.*)");  //(c0)([1-9]{1})([0-9]{1})
        userId = userIdPattern.matcher(txtCustomerId.getText());

        Pattern userNamePattern = Pattern.compile(".*[a-zA-Z]{4,}"); //[a-zA-Z0-9]{4,}
        userName = userNamePattern.matcher(txtCustomerName.getText());

        Pattern userAddressPattern = Pattern.compile(".*[a-zA-Z0-9]{4,}"); //^[a-zA-Z0-9]{4,}$
        userAddress = userAddressPattern.matcher(txtAddress.getText());

        Pattern userContactPattern = Pattern.compile(".*(?:7|0|(?:\\+94))[0-9]{9,10}");//.*^(?:7|0|(?:\+94))[0-9]{9,10}$*
        userContact = userContactPattern.matcher(txtContact.getText());

    }

    private void clearFields() {
        txtCustomerId.clear();
        txtCustomerName.clear();
        txtAddress.clear();
        txtContact.clear();
    }

    public void btnSaveCustomer(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        //hibernate data Save Views
        CustomerRepository customerRepository=new CustomerRepository();
        Customer customer=getCustomerEntity();
        customerRepository.saveCustomer(customer);

    }

    private Customer getCustomerEntity(){
        //Data Add view
        Customer customer=new Customer();
        customer.setId(Long.parseLong(txtCustomerId.getText()));
        customer.setName(txtCustomerName.getText());
        customer.setAddress(txtAddress.getText());
        customer.setContact(txtContact.getText());

        return customer;
    }

    public void btnClearDatan(ActionEvent actionEvent) {
        txtCustomerId.clear();
        txtCustomerName.clear();
        txtAddress.clear();
        txtContact.clear();
    }

    public void btnNewCustomer(ActionEvent actionEvent) {
        btnCustomer.setText("Save Customer");
    }
}



