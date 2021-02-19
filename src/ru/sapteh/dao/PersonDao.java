package ru.sapteh.dao;

import javafx.collections.ObservableList;
import ru.sapteh.model.Person;

import java.util.List;

public interface PersonDao<T> {
    String SQL_FIND_ALL = "SELECT * FROM " + Person.TABLE_NAME;
    String SQL_INSERT = String.format("INSERT INTO %s (%s %s %s %s %s %s %s) values (?, ?, ?, ?, ?, ?, ?)",
            Person.TABLE_NAME, Person.FIRSTNAME_COLUMN, Person.LASTNAME_COLUMN, Person.STREET_COLUMN,
            Person.CITY_COLUMN, Person.POSTALCODE_COLUMN, Person.BIRTHDAY_COLUMN, Person.IMAGE_COLUMN);

    ObservableList<T> findAll();
    void insert(T t);
    void update(T t);
    void delete(T t);
}
