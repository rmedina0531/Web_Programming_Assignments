import java.util.ArrayList;

public class Job {
	private static int CURRENTID = 1;
	private int jobID;
	private String jobTitle, category, location;
	private ArrayList<Qualification> qualifications;
	
	public Job(String jobTitle, String category, String location, ArrayList<String> qualifications) {
		this.jobID = this.CURRENTID;
		this.CURRENTID++;
		
		this.jobTitle = jobTitle;
		this.category = category;
		this.location = location;
		this.qualifications = new ArrayList<>();
		
		this.qualifications.add(new Qualification("Java", false));
		this.qualifications.add(new Qualification("Python", false));
		this.qualifications.add(new Qualification("MySQL", false));
		this.qualifications.add(new Qualification("Oracle", false));
		this.qualifications.add(new Qualification("Azure", false));
		this.qualifications.add(new Qualification("AWS", false));
		
		this.setQualifications(qualifications);
	}
	
	
	public int getCurrentID() {
		return this.CURRENTID;
	}
	public int getJobID() {
		return jobID;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public ArrayList<Qualification> getQualifications() {
		return this.qualifications;
	}
	public String getQualificationsString() {
		StringBuilder output = new StringBuilder();
		for (Qualification q: this.qualifications) {
			if (q.isRequired()){
				output.append(q.getQualification() + ", ");
			}
		}
		if (output.length() < 2) {
			return null;
		}else {
			return output.substring(0,output.length() -2).toString();
		}
	}
	public void setQualifications(ArrayList<String> qual) {
		for (Qualification q: this.qualifications) {
			if (qual.contains(q.getQualification())) {
				q.setRequired(true);
			}else {
				q.setRequired(false);
			}
		}
	}
}
