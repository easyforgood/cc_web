package Model;

public class Source {

	private String name;
	private String type;
	private String path;

	public Source(String name, String type, String path) {
		super();
		this.name = name;
		this.type = type;
		this.path = path;
	}

	public Source(){
		
	}
	
	
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
