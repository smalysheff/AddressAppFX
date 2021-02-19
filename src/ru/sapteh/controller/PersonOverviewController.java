package ru.sapteh.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import ru.sapteh.Database;
import ru.sapteh.Main;
import ru.sapteh.dao.impl.PersonImpl;
import ru.sapteh.model.Person;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonOverviewController {
    private final Connection connection;

    public PersonOverviewController() {
        connection = Database.getConnection();
    }

    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label birthdayLabel;
    @FXML
    private ImageView personImgView;

    //Button
//    @FXML
//    private Button buttonDelete;

    Main main = new Main();

    ObservableList<Person> personData = FXCollections.observableArrayList();

    @FXML
    private void initialize() throws FileNotFoundException {

        PersonImpl personImpl = new PersonImpl();
        ObservableList<Person> people = personImpl.findAll();

        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        personTable.setItems(people);

        //Listener tab personTable Person Details
        showPersonDetails(null);
        personTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                    try {
                        showPersonDetails(newValue);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

        });




    }

    private void showPersonDetails (Person person) throws FileNotFoundException {
        if(person != null) {
            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());
            streetLabel.setText(person.getStreet());
            cityLabel.setText(person.getCity());
            postalCodeLabel.setText(String.valueOf(person.getPostalCode()));
            birthdayLabel.setText(person.getBirthday());
            personImgView.setImage(new Image(new FileInputStream(person.getImage())));
        } else {
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            streetLabel.setText("");
            cityLabel.setText("");
            postalCodeLabel.setText("");
            birthdayLabel.setText("");
            personImgView.setImage(null);
        }
    }


    @FXML
    private void handleDeletePerson() {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        Person person = personTable.getSelectionModel().getSelectedItem();

        if(selectedIndex >= 0){
            personTable.getItems().remove(person);

            String sqlDelete = String.format("DELETE FROM %s WHERE %s=?", Person.TABLE_NAME, Person.ID_COLUMN);
            try {
                PreparedStatement statement = connection.prepareStatement(sqlDelete);
                statement.setString(1, String.valueOf(person.getId()));
                statement.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("No selected");
            alert.setHeaderText("No selected Person");
            alert.setContentText("Please select a person int the table");
            alert.showAndWait();
        }


    }
}
