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

	    public void setPerson(Person person) {
	        this.person = person;
	    }
}
