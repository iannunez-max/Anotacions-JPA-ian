package es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain;

import javax.persistence.*;

@Entity
public class Plane extends Vehicle {

    private Integer tailNumber;
    private boolean autopilot;
}
