package model;

public class Genie {
	
	private int id;
	private String name;
	private String category;
	private String severity;
	private String description;
	
	public Genie() {
		super();
	}
	
	public Genie(int id, String name, String category, String severity, String description) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.severity = severity;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Genie [id=" + id + ", name=" + name + ", category=" + category + ", severity=" + severity
				+ ", description=" + description + "]";
	}
	
	

}
