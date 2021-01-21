package testing;

import static org.junit.Assert.*;

//DO NOT CHANGE THESE IMPORTS
import project1.Module;
import project1.ModuleRecord;
import project1.ModuleResult;
import project1.Qualification;
import project1.Student;

import static org.junit.Assert.*;

import org.junit.Test;

import a.a;

// This is a junit test class if you wish to use one. It contains a sample
// student. You do NOT need to review the code in this class and you CAN
// modify it to add your own test data if you wish.
public class JUnitTest {

	@Test
	public void GetNameTest() {
		String name = "John Smith";
		Student s = new Student(name, "150789456");
		assertEquals("Test for getName: ", name, s.getName());
	}

	@Test
	public void testGetCode() {
		String name = "John Smith";
		Student s = new Student(name, "150789456");
		assertEquals("Test for getCode: ", name, s.getName());
		// fail("Not yet implemented");
	}

	@Test
	public void testGetTitle() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSemesterOneCredits() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSemesterTwoCredits() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSemesterThreeCredits() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTotalCredits() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLevel() {
		fail("Not yet implemented");
	}

	@Test
	public void testRecordMark() {

		fail("Not yet implemented");
	}

	@Test
	public void testGetModuleMark() {
		String name = "John Smith";
		Student s = new Student(name, "150789456");
		Module m = new Module("CSC8001", "Programming and data structures", 20, 0, 0, 7);
		s.addModule(m);
		ModuleRecord m1 = new ModuleRecord(m);
		assertEquals("Test for getCode: ", m1, s.getModuleRecords(0));
		fail("Not yet implemented");
	}

	/*
	 * @Test public void testGetModuleResult() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testGetModule() { fail("Not yet implemented"); }
	 */
	@Test
	public void testAddModule() {
		String name = "John Smith";
		Student s = new Student(name, "150789456");
		Module m = new Module("CSC8001", "Programming and data structures", 20, 0, 0, 7);
		s.addModule(m);
		assertEquals(s.getModuleRecords()[0].getModule(), m);
	/*	
	}
	@Test
	public void testRemoveModule() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckModuleSelection() {
		fail("Not yet implemented");
	}
*/
	@Test
	public void testGetName() {
		String name = "John Smith";
		Student s = new Student(name, "150789456");
		assertEquals("Test for getName: ", name, s.getName());
		// fail("Not yet implemented");
	}
	/*
	 * @Test public void testGetAverage() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testGetQualification() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testCheckAllModulesPassed() { fail(
	 * "Not yet implemented"); }
	 */
}
