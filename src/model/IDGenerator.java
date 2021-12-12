package model;

public class IDGenerator {
	private static IDGenerator[] instance = new IDGenerator[2];
	private int id;
	
	private IDGenerator() {
		this.id = 1;
	}

	public static IDGenerator getInstance(int index) {
		if(instance[index]==null)
			instance[index] = new IDGenerator();
		return instance[index];
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int nextId() {
		return id++;
	}
}
