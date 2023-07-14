package hospital_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Patient {
	static int id;
	String uniId;
	String firstName;
	String lastName;
	int age;
	String gender;
	List<Appointment> ap = new ArrayList<>();

	Patient() {
		uniId = "ID" + id;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first name: ");
		firstName = sc.nextLine();
		System.out.println("Enter the last name: ");
		lastName = sc.nextLine();
		System.out.println("Enter the age: ");
		age = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the gender: ");
		gender = sc.next();
	}

	{
		id++;
	}

	@Override
	public String toString() {
		return uniId + " " + firstName + " " + lastName + " " + age + " " + gender;
	}
}

class Appointment {
	String date;
	String time;
	String docName;

	public Appointment() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the date: ");
		date = sc.nextLine();
		System.out.println("Enter the time: ");
		time = sc.nextLine();
		System.out.println("Enter the docName");
		docName = sc.nextLine();
	}

	@Override
	public String toString() {
		return date + " " + time + " " + docName;
	}
}

public class Driver {
	static List<Patient> p = new ArrayList<>();

	public static void addPatient() {
		p.add(new Patient());
	}

	public static void bookAppointment() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id to book appointment");
		String id = sc.nextLine();
		int index = search(id);
		if (index != -1) {
			p.get(index).ap.add(new Appointment());
		} else {
			System.out.println("cannot book the appointment patient not exist");
		}
	}

	public static int search(String id) {
		boolean b = false;
		int i = 0;
		for (; i < p.size(); i++) {
			if (p.get(i).uniId.equalsIgnoreCase(id)) {
				b = true;
				break;
			}
		}
		if (b) {
			System.out.println(p.get(i));
			return i;
		} else {
			System.out.println("not exist please");
			return -1;
		}
	}

	public static void displayLog() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter id to check appointment log");
		String id = sc.nextLine();
		int index = search(id);
		if (index != -1) {
			System.out.println(p.get(index).ap);
		} else {
			System.out.println("patient not exist");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Enter 1 to add Patient");
			System.out.println("Enter 2 to book Appointment");
			System.out.println("Enter 3 to search details");
			System.out.println("Enter 4 to display appointment login");
			System.out.println("Enter 5 to exit");
			int x = sc.nextInt();
			switch (x) {
			case 1:
				addPatient();
				System.out.println(p);
				break;
			case 2:
				bookAppointment();
				break;
			case 3:
				System.out.println("Enter id to search");
				sc.nextLine();
				String id = sc.nextLine();
				search(id);
				break;
			case 4:
				displayLog();
				break;
			case 5:
				System.exit(0);
			}
		}
	}

}
