package com.example.demo.entity;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@TypeDef(
        name = "pgsql_enum",
        typeClass = PostgreSQLEnumType.class
)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String firstName;
    private String secondName;
    private String lastName;
    private Date dateBirthday;
    private String address;
    private boolean married;

    @Enumerated(EnumType.STRING)
    @Type( type = "pgsql_enum" )
    private Gender gender;

    public Student() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && married == student.married && Objects.equals(firstName, student.firstName) && Objects.equals(secondName, student.secondName) && Objects.equals(lastName, student.lastName) && Objects.equals(dateBirthday, student.dateBirthday) && Objects.equals(address, student.address) && gender == student.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, lastName, dateBirthday, address, married, gender);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateBirthday=" + dateBirthday +
                ", address='" + address + '\'' +
                ", marriage=" + married +
                ", gender=" + gender +
                '}';
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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateBirthday() {
        return dateBirthday;
    }

    public void setDateBirthday(Date dateBirthday) {
        this.dateBirthday = dateBirthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isMarriage() {
        return married;
    }

    public void setMarriage(boolean marriage) {
        this.married = marriage;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
