package project1;

// this class represents a student
public class Student {
	// made all public final static
	public final static int MAX_NUMBER_OF_MODULES = 13;
	public final static int VALID_NUMBER_OF_REGISTERED_CREDITS = 180;
	public final static int PROJECT_CREDITS = 60;
	public final static int MINIMUM_LEVEL_7_CREDITS = 150;
	public final static int MAXIMUM_LEVEL_6_CREDITS = 30;
	public final static int MINIMUM_PROJECT_CREDITS = 60;
	public final static int MSC_WITH_DISTINCTION_AVERAGE = 70;
	public final static int MSC_WITH_MERIT_AVERAGE = 60;
	public final static int MSC_AVERAGE = 50;

	String studentName;
	String studentNumber;
	ModuleRecord[] moduleRecords = new ModuleRecord[13];

	public Student(String name, String number) {

		studentName = name;
		studentNumber = number;
	}

	// add a module to the student's record
	public void addModule(Module m) {

		int i = findFreeLocation();
		moduleRecords[i] = new ModuleRecord(m);
	}

	// delete a module from the student's record
	public void removeModule(Module m) {

		int i = findModuleIndex(m);
		moduleRecords[i] = null;
	}

	// verify that the student has a valid module selection
	public boolean checkModuleSelection() {

		int sumLevel6Credits = 0;
		int sumLevel7Credits = 0;
		// int sumOtherCredits = 0; redundant variable
		int sem1Credits = 0;
		int sem2Credits = 0;
		int sem3Credits = 0;

		boolean projectModule = false;
		// for (int i = 1; i < MAX_NUMBER_OF_MODULES; i++) {
		for (int i = 0; i < MAX_NUMBER_OF_MODULES; i++) {
			System.out.println("The value of sem1Credits is: " + sem1Credits);
			if (moduleRecords[i] != null) {
				// add up the credits
				if (moduleRecords[i].getModule().getLevel() == Module.MSC_MODULE_LEVEL) {
					// sumLevel7Credits +=
					// moduleRecords[i].getModule().getSemesterOneCredits();
					sumLevel7Credits += moduleRecords[i].getModule().getTotalCredits();
				} else if (moduleRecords[i].getModule().getLevel() == Module.STAGE_3_MODULE_LEVEL) {
					sumLevel6Credits += moduleRecords[i].getModule().getTotalCredits();
				}
				if (projectModule = moduleRecords[i].getModule().getTotalCredits() >= MINIMUM_PROJECT_CREDITS) {
					sem1Credits += moduleRecords[i].getModule().getSemesterOneCredits();
					sem2Credits += moduleRecords[i].getModule().getSemesterTwoCredits();
					sem3Credits += moduleRecords[i].getModule().getSemesterThreeCredits();
				}

			}
		}

		// check that there is at least one project module, there isn't too many
		// level 6 credits, there is enough total credits and enough credits in
		// each semester
		return !(/* (sumOtherCredits > 0) || */ !projectModule || (sumLevel6Credits > MAXIMUM_LEVEL_6_CREDITS)
				|| (sumLevel6Credits + sumLevel7Credits != VALID_NUMBER_OF_REGISTERED_CREDITS) || sem1Credits < 50
				|| sem1Credits > 70 || sem2Credits < 50 || sem2Credits > 70 || sem3Credits < 50 || sem3Credits > 70);
	}

	// return the student's name
	public String getName() {

		return studentName;
	}

	// record a module mark for that student
	public void recordMark(Module m, int mark) {

		int i = findModuleIndex(m);

		// find the module and record the mark
		// moduleRecords[i].recordMark(i);
		moduleRecords[i].recordMark(mark);
	}

	// calculate the student's overall average mark - this works out the
	// weighted average which you can assume is correct
	public int getAverage() {

		int credits = 0;
		int sum = 0;
		for (int i = 0; i < MAX_NUMBER_OF_MODULES; i++) {
			if (moduleRecords[i] != null) {
				int moduleCredits = moduleRecords[i].getModule().getTotalCredits();
				int moduleMark = moduleRecords[i].getModuleMark();
				credits += moduleCredits;
				sum += moduleCredits * moduleMark;
			}
		}

		return (int) ((double) sum / (double) credits + 0.5);
	}

	// return the overall degree classification
	public Qualification getQualification() {

		// all modules chosen are valid and no modules have been failed
		if (checkModuleSelection() && checkAllModulesPassed()) {
			if (getAverage() >= MSC_WITH_DISTINCTION_AVERAGE) {
				/* // clever clogs */
				// return Qualification.MSC_WITH_MERIT;
				// Comment Changed to MSC with Distinction and changed the
				// return statement
				return Qualification.MSC_WITH_DISTINCTION;
			} else if (getAverage() >= MSC_WITH_MERIT_AVERAGE) {
				/* // merit */
				// MSC with Merit
				// return Qualification.MSC_WITH_DISTINCTION; changed to return
				// Qualification.MSC_WITH_MERIT;
				return Qualification.MSC_WITH_MERIT;
			} else if (getAverage() >= MSC_AVERAGE) {
				// MSC pass
				return Qualification.MSC;
			} else {
				/* // you are the weakest link, goodbye */
				// Changed comment to fail
				return Qualification.FAIL;
			}
		} else {
			// else fail
			return Qualification.FAIL;
		}
	}

	// Private method to locate the index of a particular module in the array
	private int findModuleIndex(Module m) {
		int i;
		for (i = 0; i <= MAX_NUMBER_OF_MODULES; i++) {
			if (moduleRecords[i] != null && moduleRecords[i].getModule().equals(m)) {
				break;
			}
		}
		return i;
	}

	// Private method to find the next free slot in the array in which a module
	// can be added
	private int findFreeLocation() {
		int i;
		for (i = 0; i < MAX_NUMBER_OF_MODULES; i++) {
			if (moduleRecords[i] == null) {
				break;
			}
		}
		return i;
	}

	// Private method to check that there are no modules which have been failed
	// public boolean checkAllModulesPassed() {
	private boolean checkAllModulesPassed() {

		for (int i = 0; i < MAX_NUMBER_OF_MODULES; i++) {
			if (moduleRecords[i] != null) {
				if (moduleRecords[i].getModuleResult() == ModuleResult.FAIL) {
					return false;
				}
			}
		}
		return true;
	}
	// End private methods

	public ModuleRecord getModuleRecords(int i) {
		return moduleRecords[i];
	}

	public void setModuleRecords(ModuleRecord[] moduleRecords) {
		this.moduleRecords = moduleRecords;
	}
}
