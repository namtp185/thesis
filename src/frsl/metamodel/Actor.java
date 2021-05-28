package frsl.metamodel;

public class Actor extends NamedEntity {
	public Actor(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return "actor " + this.name + "\n";  
	}
}
