package es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain;

import javax.persistence.*;

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
    private List<Vehicle> vehicles;

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
        v.setPerson(this);
    }

    public void removeVehicle(Vehicle v) {
        vehicles.remove(v);
        v.setPerson(null);
    }
}
