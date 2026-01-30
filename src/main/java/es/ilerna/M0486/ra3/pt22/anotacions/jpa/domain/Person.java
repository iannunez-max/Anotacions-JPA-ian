package es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "person_type")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String surname;
    private Integer phoneNumber;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Vehicle> vehicles = new ArrayList<>();

    public Person() {}

    public Person(String name, String surname, Integer phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public Integer getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(Integer phoneNumber) { this.phoneNumber = phoneNumber; }

    public List<Vehicle> getVehicles() { return vehicles; }

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
        v.setPerson(this);
    }

    public void removeVehicle(Vehicle v) {
        vehicles.remove(v);
        v.setPerson(null);
    }
}

