

public class Lab {
	
	private Student[] students;
	private String teacherName;

	//the day in which this lab is held
	private String dayOfWeek;
	private int maxSize;
	private int currentSize;
	private double avgGrade;

	//constructor
	public Lab(String teacherName, String dayOfWeek, int maxSize) {
		this.teacherName = teacherName;
		this.dayOfWeek = dayOfWeek;
		this.maxSize = maxSize;
		//create an array of students with the size "maxSize"
		students = new Student[maxSize];
		// at first we have 0 students in this class
		currentSize = 0;
	}


	//methods
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public void setdayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public void setAvgGrade(double avgGrade) {
		if (avgGrade >= 0 && avgGrade <= 20) {
			this.avgGrade = avgGrade;
		} else {
			System.out.println("Your input is invalid!");
		}
	}

	public void setCurrentSize(int currentSize) {
		this.currentSize = currentSize;
	}
	public void setStudents(Student[] students) {
		this.students = students;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public double getAvgGrade() {
		return avgGrade;
	}

	public int getCurrentSize() {
		return currentSize;
	}

	public Student[] getStudents() {
		return students;
	}

	public void calAvg() {
		double sum = 0;
		for (int i = 0; i < currentSize; i++) {
			sum += students[i].getGrade();
		}

	   avgGrade = sum / currentSize;	
	}

	public void enrollStudent(Student student ) {
		if (currentSize < maxSize) {
			students[currentSize] = student;
			currentSize++;
			calAvg();
		} else {
			System.out.println("Your can't add students anymore!");
		}
	}

	public void printLabInfo() {
		System.out.println("teacher name : " + teacherName + "\naverage of class : " + avgGrade + "\nnumber of students : " + currentSize + "\n\n");
		for (int i = 0; i < currentSize; i++) {
			System.out.println("Student " + (i + 1));
			System.out.println("Name : " + students[i].getFirstName() + " " + students[i].getLastName());
			System.out.println("ID : " + students[i].getId());
			System.out.println("Grade : " + students[i].getGrade() + "\n");
		}
	}
}

