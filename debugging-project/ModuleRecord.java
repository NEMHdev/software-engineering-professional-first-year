package project1;

// this class represents a module record
public class ModuleRecord {

	Module m;
	public int mark;

	public ModuleRecord(Module m, int mark) {

		this.m = m;
		this.mark = mark;
	}

	public ModuleRecord(Module m) {

		this.m = m;
	}

	public void recordMark(int mark) {

		this.mark = mark;
	}

	public int getModuleMark() {

		return mark;
	}

	public ModuleResult getModuleResult() {

		if (m.getLevel() == Module.MSC_MODULE_LEVEL && mark >= Module.MSC_MODULE_PASS_MARK
				|| mark >= Module.UG_MODULE_PASS_MARK) {
			return ModuleResult.PASS;
		} else {
			return ModuleResult.FAIL;
		}
	}

	public Module getModule() {

		return m;
	}
}