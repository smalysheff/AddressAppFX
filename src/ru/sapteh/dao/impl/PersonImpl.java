package ru.sapteh.dao.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.sapteh.Database;
import ru.sapteh.dao.PersonDao;
import ru.sapteh.model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PersonImpl implements PersonDao<Person>{

    private Connection connection;

    public PersonImpl() {
        connection = Database.getConnection();
    }


    @Override
    public ObservableList<Person> findAll() {
        ObservableList<Person> people = FXCollections.observableArrayList();
        Person person;

        try {
            PreparedStatement statement = connection.prepareStatement(PersonDao.SQL_FIND_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(Person.ID_COLUMN);
                String firstName = resultSet.getString(Person.FIRSTNAME_COLUMN);
                String lastName = resultSet.getString(Person.LASTNAME_COLUMN);
                String street = resultSet.getString(Person.STREET_COLUMN);
                String city = resultSet.getString(Person.CITY_COLUMN);
                int postalCode = Integer.parseInt(resultSet.getString(Person.POSTALCODE_COLUMN));
                String birthday = resultSet.getString(Person.BIRTHDAY_COLUMN);
                String image = resultSet.getString(Person.IMAGE_COLUMN);
                person = new Person(id, firstName, lastName, street, city, postalCode, birthday, image);
                people.add(person);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return people;
    }

    @Override
    public void insert(Person person) {

    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(Person person) {

    }
}
