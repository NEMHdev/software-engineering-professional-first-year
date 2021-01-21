package testing;

import a.a;
//DO NOT CHANGE THESE IMPORTS
import project1.Module;
import project1.ModuleRecord;
import project1.ModuleResult;
import project1.Qualification;
import project1.Student;

// This is a driver class if you wish to use one. It contains a sample
// student. You do NOT need to review the code in this class and you CAN
// modify it to add your own test data if you wish.
public class Test {

	public static void main(String[] args) {

		// new student object
		Student chris = new Student("Chris", "1");
		Module csc8005 = new Module("CSC8005", "Software Engineering with Group Project", 10, 10, 0, 7);

		// test for student object
		System.out.println("Name value of student object should be 'Chris': " + chris.getName());

	}
}
