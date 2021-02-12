package example;

public class MyComparableClass4  implements MyInterface,  Comparable<MyInterface> {

	protected int number;
	protected String str;
	
	public MyComparableClass4(int num, String s) {
		number = num;
		str = s;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void setStr(String str) {
		this.str = str;
	}

	public String getStr() {
		return str;
	}
	
	public String toString() {
		
		return this.number + " " + this.str;
	}
	
	@Override

	public int compareTo(MyInterface other) {
		if (this.number > other.getNumber())
			return 1;
		else if (this.number < other.getNumber())
			return -1;
		else // this.ID == other.ID
			return str.compareTo(other.getStr()); 
	}
	
	public static void main(String[] args) {

	
	}
	
}
