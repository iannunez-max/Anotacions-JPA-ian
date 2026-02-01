package es.ilerna.M0486.ra3.pt22.pt3.anotacions.jpa.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Car;
import es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Motorcycle;
import es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Person;
import es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Plane;
import es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Student;
import es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Teacher;
import es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Vehicle;

public class Main {

	private static List<Person> people = new ArrayList<>();
	private static List<Vehicle> vehicles = new ArrayList<>();
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcio;

		do {
			System.out.println("\n===== MENÚ PRINCIPAL =====");
			System.out.println("1) Fase 1: Crear dades de prova");
			System.out.println("2) Fase 2: Treure vehicles de persones");
			System.out.println("3) Fase 3: Actualitzar un vehicle");
			System.out.println("0) Sortir");
			System.out.print("Escull una opció: ");

			opcio = sc.nextInt();
			sc.nextLine();

			switch (opcio) {
				case 1:
					fase1();
					break;
				case 2:
					fase2();
					break;
				case 3:
					fase3();
					break;
				case 0:
					System.out.println("Fins aviat!");
					break;
				default:
					System.out.println("Opció incorrecta.");
			}

		} while (opcio != 0);

		sc.close();
		HibernateSession.getSessionFactory().close();
	}
	
	private static void fase1() {
	    Session session = HibernateSession.getSessionFactory().openSession();
	    Transaction tx = session.beginTransaction();

	   
	    Person p1 = new Person("STUDENT", "Anna Lopez", 111111111);
	    Person p2 = new Person("STUDENT", "Jordi Martinez", 222222222);
	    Person p3 = new Person("STUDENT", "Clara Sanchez", 333333333);
	    Person p4 = new Person("TEACHER", "Joan Perez", 444444444);
	    Person p5 = new Person("TEACHER", "Maria Gomez", 555555555);
	    Person p6 = new Person("TEACHER", "Pere Ruiz", 666666666);

	    
	    Car v1 = new Car("Toyota", 2020, 18000f, 5, 5);
	    Car v2 = new Car("Ford", 2019, 15000f, 5, 5);
	    Plane v3 = new Plane("Cessna", 2015, 120000f, 1111, true);
	    Plane v4 = new Plane("Boeing", 2010, 900000f, 2222, false);
	    Motorcycle v5 = new Motorcycle("Yamaha", 2021, 9000f, false);
	    Motorcycle v6 = new Motorcycle("Harley-Davidson", 2018, 20000f, true);

	  
	    p1.addVehicle(v1);
	    p2.addVehicle(v2);
	    p3.addVehicle(v3);
	    p4.addVehicle(v4);
	    p5.addVehicle(v5);
	    p6.addVehicle(v6);

	 
	    session.save(p1);
	    session.save(p2);
	    session.save(p3);
	    session.save(p4);
	    session.save(p5);
	    session.save(p6);

	    tx.commit();
	    session.close();
	    System.out.println("Fase 1 completada.");
	}

	
	private static void fase2() {
	    Session session = HibernateSession.getSessionFactory().openSession();
	    Transaction tx = session.beginTransaction();

	    Vehicle v1 = session.get(Vehicle.class, 1);

	    if (v1 != null) {
	        v1.setPerson(null);   
	        session.update(v1);
	        System.out.println("Fase 2 completada: Vehicle 1 dissociat.");
	    } else {
	        System.out.println("Error: Vehicle 1 no trobat.");
	    }

	    tx.commit();
	    session.close();
	}

	private static void fase3() {
	    Session session = HibernateSession.getSessionFactory().openSession();
	    Transaction tx = session.beginTransaction();

	    Vehicle v1 = session.get(Vehicle.class, 1);

	    if (v1 instanceof Car) {
	        Car c1 = (Car) v1;
	        c1.setBrand("Seat");
	        c1.setPrice(19999f);
	        c1.setYear(2022);
	        c1.setPerson(null);   
	        session.update(c1);
	        System.out.println("Fase 3 completada: Vehicle 1 modificat.");
	    } else {
	        System.out.println("Error: Vehicle 1 no és un Car.");
	    }

	    tx.commit();
	    session.close();
	}

}
