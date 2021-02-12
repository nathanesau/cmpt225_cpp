package example;

public class MyComparableClass3  implements  Comparable<IncomparableClass1> {

	protected int number;
	protected String str;
	
	public MyComparableClass3(int id, String n) {
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
	public int compareTo(IncomparableClass1 other) {
		if (this.number > other.getNumber())
			return 1;
		else if (this.number < other.getNumber())
			return -1;
		else // this.ID == other.ID
			return str.compareTo(other.getStr()); 
	}
	
	@Override
	public String toString() {
		
		return this.number + " " + this.str;
	}
	
}
