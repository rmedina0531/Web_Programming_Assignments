
public class Faculty {
	private String department, name;
	private boolean chair;
	
	
	public Faculty(String name, String department, boolean chair) {
		this.name = name;
		this.department = department;
		this.chair = chair;
	}
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getName() {
		if (this.isChair()) {
			return name + " (Chair)";
		}
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isChair() {
		return chair;
	}
	public void setChair(boolean chair) {
		this.chair = chair;
	}
	
	
}
