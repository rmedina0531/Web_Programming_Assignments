import java.util.ArrayList;

public class Department {
	private ArrayList<Faculty> faculty;
	private String  name;
	
	public Department(String name) {
		this.name = name;
		this.faculty = new ArrayList<>();
	}
	
	
	public int getSize() {
		return this.faculty.size();
	}
	public ArrayList<Faculty> getFaculty() {
		return faculty;
	}
	public void setFaculty(ArrayList<Faculty> faculty) {
		this.faculty = faculty;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void addFaculty(String name, boolean chair) {
		this.faculty.add(new Faculty(name, this.name, chair));
	}
	public Faculty getHead() {
		if (this.faculty.size() == 0) {
			return null;
		}
		return faculty.get(0);
	}
	public ArrayList<Faculty> getTail() {
		ArrayList<Faculty> output = new ArrayList<>();
		if (this.faculty.size() <2) {
			return null;
		}
		for (int i = 1; i < this.faculty.size(); i++) {
			output.add(this.faculty.get(i));
		}
		return output;
	}
	
}
