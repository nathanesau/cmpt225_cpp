package example;

public class IncomparableClass2 implements MyInterface {

	protected int number;
	protected String str;
	
	public IncomparableClass2(int num, String s) {
		number = num;
		str = s;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return number;
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
	
}
