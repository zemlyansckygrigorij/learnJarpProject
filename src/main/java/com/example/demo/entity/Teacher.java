package com.example.demo.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String firstName;
    private String secondName;
    private String lastName;
    private Date dateBirth;
    private String address;
    private String qualification;
    private String biography;

    public Teacher() {
    }
    public Teacher(TeacherXML teacher) {
        this.id = teacher.getId();
        this.firstName = teacher.getFirstName();
        this.secondName = teacher.getSecondName();
        this.lastName = teacher.getLastName();
        this.dateBirth = teacher.getDateBirth();
        this.address = teacher.getAddress();
        this.qualification = teacher.getQualification();
        this.biography = teacher.getBiography();
    }
    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateBirth=" + dateBirth +
                ", address='" + address + '\'' +
                ", qualification='" + qualification + '\'' +
                ", biography='" + biography + '\'' +
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

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id && Objects.equals(firstName, teacher.firstName) && Objects.equals(secondName, teacher.secondName) && Objects.equals(lastName, teacher.lastName) && Objects.equals(dateBirth, teacher.dateBirth) && Objects.equals(address, teacher.address) && Objects.equals(qualification, teacher.qualification) && Objects.equals(biography, teacher.biography);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, secondName, lastName, dateBirth, address, qualification, biography);
    }
}
