package example;

public class EqualsClass {

	protected int ID;
	protected String name;

	public EqualsClass(int id, String n) {
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
	public String toString() {

		return this.name + this.ID;
	}

	@Override
	public boolean equals(Object otherObj) {
		if (this == otherObj)
			return true;
		if (otherObj == null)
			return false;
		// if (!(obj instanceof EqualsClass))
		// return false;
		// Check for a stronger condition: the class of obj is exactly of EqualsClass
		if (this.getClass() != otherObj.getClass())
			return false;

		EqualsClass other = (EqualsClass) otherObj; // downcasting
		// if ((this.ID == other.ID) && (this.name == other.name) ) // wrong
		if ((this.ID == other.ID) && this.name.equals(other.name))
			return true;
		else
			return false;
	}

}
