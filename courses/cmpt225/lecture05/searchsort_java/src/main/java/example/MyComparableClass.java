package example;

public class MyComparableClass implements Comparable<MyComparableClass> {

	protected int ID;
	protected String name;

	public MyComparableClass(int id, String n) {
		ID = id;
		name = n;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getID() {
		return ID;
	}

	@Override
	public int compareTo(MyComparableClass other) {
		if (this.ID > other.ID)
			return 1;
		else if (this.ID < other.ID)
			return -1;
		else // this.ID == other.ID
			return name.compareTo(other.name);
	}

	@Override
	public String toString() {

		return this.name + this.ID;
	}
	
}
