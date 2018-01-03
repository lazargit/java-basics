package streams;

public class User {
	
	private String name;
	private int alter;
	
	@Override
	public String toString() {
		return "User [name=" + name + ", alter=" + alter + "]";
	}
	public User(String name, int alter) {
		super();
		this.name = name;
		this.alter = alter;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAlter() {
		return alter;
	}
	public void setAlter(int alter) {
		this.alter = alter;
	}
	

}
