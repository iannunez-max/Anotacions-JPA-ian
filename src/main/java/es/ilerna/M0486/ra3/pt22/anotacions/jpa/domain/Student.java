package es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain;

import javax.persistence.*;

@Entity
@DiscriminatorValue("STUDENT")
public class Student extends Person {

    private String studentCode;
}
