public class Student {

	private String firstname;

	private String lastname;

	// student's number contains at least 7 digits, e.g: 9931023
	private String id;

	private double grade;

	public Student(String firstname, String lastname, String id) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.id = id;
		
		//assuming that the student's grade is zero
		
		grade = 0;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}

	public void setLastName(String lastname) {
		this.lastname = lastname;
	}

	public void setId(String id) {
		if (id.length() > 6) {
			this.id = id;
		} else {
			System.out.println("Your input is invalid");
		}
	}

	public void setGrade(double grade) {
		if (grade >= 0 && grade <= 20) {
			this.grade = grade;
		} else {
			System.out.println("Your input is invalid");	
		}
	}

	public String getFirstName() {
		return firstname;
	}

	public String getLastName() {
		return lastname;
	}

	public String getId() {
		return id;
	}

	public double getGrade() {
		return grade;
	}

	public void printStudentInfo() {
		System.out.println(firstname + " " + lastname + "\nID : " + id + "\nGRADE : " + grade);
	
	}

}
