package testing;

// DO NOT CHANGE THESE IMPORTS
import a.a; // Module
import a.b; // ModuleRecord
import a.c; // ModuleResult
import a.d; // Qualification
import a.e; // Student
import b.f; // Visualise

// This is a driver class if you wish to use one. It contains a sample
// student and modules. You do NOT need to review the code in this class
// and you CAN modify it to add your own test data if you wish.
public class VisualiseTest {

	// #TODO Edit student number
	public static final String STUDENT_NUMBER = "150108595";

	public static void main(String[] args) {

		// define modules
		a csc8001 = new a("CSC8001", "Programming and data structures", 20, 0, 0, 7);
		a csc8002 = new a("CSC8002", "Advanced Programming", 0, 20, 0, 7);
		a csc8004 = new a("CSC8004", "Networks and Web Technologies", 0, 20, 0, 7);
		a csc8005 = new a("CSC8005", "Software Engineering with Group Project", 10, 10, 0, 7);
		a csc8008 = new a("CSC8008", "Information Systems", 20, 0, 0, 7);
		a csc8009 = new a("CSC8009", "Research Methods for Computer Science", 0, 10, 0, 7);
		a csc8010 = new a("CSC8010", "Computer Environments", 10, 0, 0, 7);
		a csc8099 = new a("CSC8099", "Project and Dissertation for MSc Computer Science", 0, 0, 60, 7);

		// define student
		e s = new e("John Smith", "150123456");

		// add modules to student
		s.addModule(csc8001);
		s.addModule(csc8002);
		s.addModule(csc8004);
		s.addModule(csc8005);
		s.addModule(csc8008);
		s.addModule(csc8009);
		s.addModule(csc8010);
		s.addModule(csc8099);

		// record mark for that student
		s.recordMark(csc8001, 50);
		s.recordMark(csc8002, 75);
		s.recordMark(csc8004, 65);
		s.recordMark(csc8005, 55);
		s.recordMark(csc8008, 45);
		s.recordMark(csc8009, 35);
		s.recordMark(csc8010, 25);
		s.recordMark(csc8099, 15);

		// summary
		new f(STUDENT_NUMBER, s);

	}
}

/*
 * missing a bar Modules arn't in order
 * 
 */
