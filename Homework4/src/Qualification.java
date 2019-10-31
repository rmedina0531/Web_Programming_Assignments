
public class Qualification {
	private String qualification;
	private boolean required = false;
	
	public Qualification(String q, boolean b) {
		this.qualification = q;
		this.required = b;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}
	
	
	
}
