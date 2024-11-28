package com.example.inventory.controller;

import com.example.inventory.model.Product;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.textfield.TextFields;

public class InventoryController {
    @FXML
    private TextField productNameFiled;
    @FXML
    private TextField stockFiled;
    @FXML
    private TextField searchField;
    @FXML
    private TableView<Product> productTable;

    @FXML
    private TableColumn<Product, String> nameColumn;
    @FXML

    private TableColumn<Product, Integer> stockColumn;
    private ObservableList<Product> inventary;

    @FXML
    private void initialize(){
        inventary = FXCollections.observableArrayList();
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        stockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        populateTestData();
        productTable.setItems(inventary);
    }

    private  void populateTestData(){
        inventary.add(new Product("Apple", 50));
        inventary.add(new Product("Milk", 30));
        inventary.add(new Product("Egg", 120));
    }


    @FXML
    private void handleSearch(){
        String searchQuery = searchField.getText().trim();
        if (searchQuery.isEmpty()){
                showAlert("Error", "Please enter product name", Alert.AlertType.ERROR);
                return;
        }
        Product product = findProductByName(searchQuery);
        if (product != null){
            productTable.getSelectionModel().select(product);
            productTable.scrollTo(product);
        }else {
            showAlert("Info", "Product not found", Alert.AlertType.INFORMATION);
        }
    }

    private void showAlert(String title, String content, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private Product findProductByName(String name){
        return inventary.stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .findFirst()
                .orElse(null);
    }

    @FXML
    private void handleAddOrUpdate(){

    }
}

