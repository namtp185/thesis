package frsl.metamodel;

public abstract class Message {
	protected String description;
	
	public Message() {
		
	}
	
	public Message(String description) {
		this.setDescription(description);
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}

	@Override
	public String toString() {
		return this.description;
	}
}
