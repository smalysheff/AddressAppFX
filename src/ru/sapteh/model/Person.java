package ru.sapteh.model;

import java.util.Objects;

//POJO
public class Person {

    public static final String TABLE_NAME = "persons";
    public static final String ID_COLUMN = "id";
    public static final String FIRSTNAME_COLUMN = "firstName";
    public static final String LASTNAME_COLUMN = "lastName";
    public static final String STREET_COLUMN = "street";
    public static final String CITY_COLUMN = "city";
    public static final String POSTALCODE_COLUMN = "postal_code";
    public static final String BIRTHDAY_COLUMN = "birthday";
    public static final String IMAGE_COLUMN = "image";

    private int id;
    private String firstName;
    private String lastName;
    private String street;
    private int postalCode;
    private String city;
    private String birthday;
    private String image;

    public Person () {}

    public Person(int id, String firstName, String lastName, String street,
                  String city, int postalCode, String birthday, String image) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.birthday = birthday;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && postalCode == person.postalCode &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(street, person.street) &&
                Objects.equals(city, person.city) &&
                Objects.equals(birthday, person.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, street, postalCode, city, birthday);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", street='" + street + '\'' +
                ", postalCode=" + postalCode +
                ", city='" + city + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
