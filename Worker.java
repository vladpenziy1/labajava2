package lab2;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.*;
import java.util.regex.Pattern;
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(propOrder = {"id","surname","name","lastname","gender","age"})
public class Worker implements Serializable {


    private int id;
    private String Surname;
    private String Name;
    private String Lastname;
    private String gender;
    private int age;

    @XmlTransient
    @JsonIgnore
    public String patt = "K[a-z]+";


    public int getId() {
        return id;
    }
    @XmlAttribute(name = "id")
    public void setId(int id) {
        this.id = id;
    }


    public String getSurname() {
        return Surname;
    }

    @XmlElement
    public void setSurname(String surname) {
        Surname = surname;
    }



    public String getName() {
        return Name;
    }

    @XmlElement
    public void setName(String name) {
        Name = name;
    }

    public String getLastname() {
        return Lastname;
    }


    @XmlElement
    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getGender() {
        return gender;
    }



    @XmlElement
    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }


    @XmlElement
    public void setAge(int age) {
        this.age = age;
    }


    public boolean older(){
        return this.age > 50;
    }

    public boolean worker(){
        return Pattern.matches(patt,this.Surname);
    }

    @JsonIgnore
    public String getGenderStr() { if (this.getGender() == "Male") return "This worker is man";
    else return "This worker is woman";}

    @Override
    public String toString() {
        return "\nWorker{" +
                "id=" + id +
                ", Surname='" + Surname + '\'' +
                ", Name='" + Name + '\'' +
                ", Lastname='" + Lastname + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                "}\n";
    }

    public static void main(String args[]){

    }

}
