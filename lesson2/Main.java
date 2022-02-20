

public class Main {
	
	public static void main (String[] argv) {
		
		Student std1 = new Student("James", "Gosling", "0987654");
		Student std2 = new Student("Dennis", "Ritchie", "1234567");

		std1.setGrade(18);
		std2.setGrade(17.5);

		std1.printStudentInfo();
		std1.printStudentInfo();


	}
}
