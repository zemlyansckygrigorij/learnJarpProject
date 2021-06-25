package com.example.demo.entity;

import javax.xml.bind.annotation.*;
import java.util.Date;
/*
* https://www.baeldung.com/jaxb
* @XmlRootElement: the name of the root XML element is derived from the class name and we can also specify the name of the root element of the XML using its name attribute
@XmlType: define the order in which the fields are written in the XML file
@XmlElement: define the actual XML element name which will be used
@XmlAttribute: define the id field is mapped as an attribute instead of an element
@XmlTransient: annotate fields that we don't want to be included in XML
*
* */
@XmlRootElement(name = "book")
@XmlType(propOrder = { "id", "firstName", "secondName" , "lastName", "dateBirth", "address", "qualification"})
public class TeacherXML {
    public TeacherXML() {
    }

    private int id;

    private String firstName;
    private String secondName;
    private String lastName;
    private Date dateBirth;
    private String address;
    private String qualification;
    private String biography;

    public TeacherXML(Teacher teacher) {
        this.id = teacher.getId();
        this.firstName = teacher.getFirstName();
        this.secondName = teacher.getSecondName();
        this.lastName = teacher.getLastName();
        this.dateBirth = teacher.getDateBirth();
        this.address = teacher.getAddress();
        this.qualification = teacher.getQualification();
        this.biography = teacher.getBiography();
    }

    public int getId() {
        return id;
    }
    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    @XmlAttribute
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }
    @XmlAttribute
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }
    @XmlElement(name = "family")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateBirth() {
        return dateBirth;
    }
    @XmlAttribute
    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getAddress() {
        return address;
    }
    @XmlAttribute
    public void setAddress(String address) {
        this.address = address;
    }

    public String getQualification() {
        return qualification;
    }
    @XmlAttribute
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getBiography() {
        return biography;
    }
    @XmlTransient
    public void setBiography(String biography) {
        this.biography = biography;
    }
}
