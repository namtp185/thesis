package frsl.metamodel;

public class Entity extends NamedEntity {
	public Entity(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return "entity " + this.name + "\n";  
	}
}
