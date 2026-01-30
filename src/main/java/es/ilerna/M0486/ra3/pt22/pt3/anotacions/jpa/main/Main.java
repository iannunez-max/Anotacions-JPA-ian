package es.ilerna.M0486.ra3.pt2.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.ilerna.M0486.ra3.pt2.domain.Car;
import es.ilerna.M0486.ra3.pt2.domain.Motorcycle;
import es.ilerna.M0486.ra3.pt2.domain.Person;
import es.ilerna.M0486.ra3.pt2.domain.Plane;
import es.ilerna.M0486.ra3.pt2.domain.Student;
import es.ilerna.M0486.ra3.pt2.domain.Teacher;
import es.ilerna.M0486.ra3.pt2.domain.Vehicle;

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

	    Student s1 = new Student();
	    s1.name = "Anna"; s1.surname = "Lopez"; s1.phoneNumber = 111111111; s1.studentCode = "STU001";

	    Student s2 = new Student();
	    s2.name = "Jordi"; s2.surname = "Martinez"; s2.phoneNumber = 222222222; s2.studentCode = "STU002";

	    Student s3 = new Student();
	    s3.name = "Clara"; s3.surname = "Sanchez"; s3.phoneNumber = 333333333; s3.studentCode = "STU003";

	    Teacher t1 = new Teacher();
	    t1.name = "Joan"; t1.surname = "Perez"; t1.phoneNumber = 444444444; t1.teacherCode = "TEA001";

	    Teacher t2 = new Teacher();
	    t2.name = "Maria"; t2.surname = "Gomez"; t2.phoneNumber = 555555555; t2.teacherCode = "TEA002";

	    Teacher t3 = new Teacher();
	    t3.name = "Pere"; t3.surname = "Ruiz"; t3.phoneNumber = 666666666; t3.teacherCode = "TEA003";

	    session.persist(s1);
	    session.persist(s2);
	    session.persist(s3);
	    session.persist(t1);
	    session.persist(t2);
	    session.persist(t3);

	    Car car1 = new Car();
	    car1.brand = "Toyota"; car1.price = 18000f; car1.year = 2020; car1.doors = 5; car1.seats = 5;
	    car1.person = s1;

	    Car car2 = new Car();
	    car2.brand = "Ford"; car2.price = 15000f; car2.year = 2019; car2.doors = 3; car2.seats = 4;
	    car2.person = t2;

	    Plane plane1 = new Plane();
	    plane1.brand = "Cessna"; plane1.price = 120000f; plane1.year = 2015; plane1.tailNumber = 11111; plane1.autopilot = true;
	    plane1.person = t1;

	    Plane plane2 = new Plane();
	    plane2.brand = "Boeing"; plane2.price = 900000f; plane2.year = 2010; plane2.tailNumber = 22222; plane2.autopilot = false;
	    plane2.person = s3;

	    Motorcycle m1 = new Motorcycle();
	    m1.brand = "Yamaha"; m1.price = 9000f; m1.year = 2021; m1.hasSidecar = false;
	    m1.person = s2;

	    Motorcycle m2 = new Motorcycle();
	    m2.brand = "Harley-Davidson"; m2.price = 20000f; m2.year = 2018; m2.hasSidecar = true;
	    m2.person = t3;

	    session.persist(car1);
	    session.persist(car2);
	    session.persist(plane1);
	    session.persist(plane2);
	    session.persist(m1);
	    session.persist(m2);

	    tx.commit();
	    session.close();
	}


	
	private static void fase2() {

	}

	private static void fase3() {

	}
}
