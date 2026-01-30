package es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain;

import javax.persistence.*;

@Entity
@DiscriminatorValue("TEACHER")
public class Teacher extends Person {

    private String teacherCode;
}