package frsl.sequence_diagram.util;

public class Builder {
	private StringBuilder sb;
	
	public Builder() {
		sb = new StringBuilder();
		sb.append("@startuml\n");
	}
	
	public void append(String str) {
		sb.append(str);
	}
	
	public String render() {
		sb.append("@enduml\n");
		return sb.toString();
	}
}
