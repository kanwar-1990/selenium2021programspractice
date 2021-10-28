package ImpSeleniumSession;

public class ToString {

	public static void main(String[] args) {
		EmpName e = new EmpName();
		System.out.println(e.toString());// ImpSeleniumSession.EmpName@7852e922
		// toString is avaiable as default method
	}

}

class EmpName {
	String EmpID;
	String name;

	public EmpName() {
		EmpID = "12314";
		name = "Kanwar";
	}

	@Override
	public String toString() {
		return "Employee id is :" + EmpID + ":" + "Employee name :" + name;
	}
}
