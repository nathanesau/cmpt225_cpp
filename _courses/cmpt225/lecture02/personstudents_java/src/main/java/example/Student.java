package example;

public class Student extends Person
{
	public static final int NUMBER_OF_GRADES = 10;
	public static final int MIN_GRADE = 0;
	public static final int MAX_GRADE = 100;
	int[] grades;

	
	/**
	 * Class constructor - initializes the data fields
	 * 
	 * @param newID - ID of the student  
	 * @param newFirstName - student's first name
	 * @param newLastName - student's last name
	 * 
	 */
	Student(int newID, String newFirstName, String newLastName, int newGender)
	{
		super(newID, newFirstName, newLastName, newGender);
		grades = new int[NUMBER_OF_GRADES];
	}
	
	
	/**
	 * Sets the i'th grade the value newGrade
	 * 
	 * @param i
	 * @param newGrade
	 * 
	 */
	public void setGrade(int i, int newGrade)
	{
		// check that the parameters are valid, and set the i'th grade the value newGrade 
		if (i>= 1 && i <= NUMBER_OF_GRADES && newGrade>=MIN_GRADE && newGrade<=MAX_GRADE)
			grades[i-1] = newGrade;
	}
	
	/**
	 * Computes the average grade
	 * 
	 * @return the average grade
	 */
	public double getAverage()
	{
		int sum = 0;
		int i = 0;
		while (i < grades.length)
		{
			sum += grades[i];
			i++;
		}
		if (grades.length == 0)
			return 0;
		else
			return sum/grades.length;
	}
	
	
	@Override	
	public String toString() {
		return super.toString() + "; Average grade = " + String.valueOf(getAverage());	
	}
	

}


