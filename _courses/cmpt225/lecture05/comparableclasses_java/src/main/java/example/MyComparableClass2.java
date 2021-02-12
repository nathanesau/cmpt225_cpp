package example;

public class MyComparableClass2  implements Comparable<MyComparableClass1> {

	protected int number;
	protected String str;
	
	public MyComparableClass2(int id, String n) {
		number = id;
		str = n;
	}

	public void setName(String name) {
		this.str = name;
	}
	public String getName() {
		return str;
	}

	public void setID(int iD) {
		number = iD;
	}
	
	public int getID() {
		return number;
	}
	
	@Override
	public int compareTo(MyComparableClass1 other) {
		if (this.number > other.ID)
			return 1;
		else if (this.number < other.ID)
			return -1;
		else // this.ID == other.ID
			return str.compareTo(other.name); 
	}
	
	@Override
	public String toString() {
		
		return this.number + " " + this.str;
	}
	
}
