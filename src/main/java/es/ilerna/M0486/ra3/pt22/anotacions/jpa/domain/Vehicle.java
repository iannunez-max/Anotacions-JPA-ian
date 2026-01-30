package es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String brand;
    private Integer year;
    private Float price;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Vehicle() {}

    public Vehicle(String brand, Integer year, Float price) {
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    public Integer getId() { return id; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }

    public Float getPrice() { return price; }
    public void setPrice(Float price) { this.price = price; }

    public Person getPerson() { return person; }
    public void setPerson(Person person) { this.person = person; }
}
