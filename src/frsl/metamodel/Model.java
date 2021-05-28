package frsl.metamodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model implements ModelObservable {
	
	
	private Map<String, Entity> entities;
	private Map<String, Actor> actors;
	private List<Message> messages;
	private List<Node> nodes;
	// For getting original information from sourceModel
	private UseCase usecase;
	
	// get corresponding node from step
	private Map<String, Node> nodesMap;
	
	public Model(UseCase usecase) {
		this.usecase = usecase;
		observers = new ArrayList<>();
		entities = new HashMap<>();
		actors = new HashMap<>();
		messages = new ArrayList<>();
		nodes = new ArrayList<>();
		nodesMap = new HashMap<>();
	}
	
	protected List<ModelObserver> observers;
	
	public void registerObserver(ModelObserver observer) {
		observers.add(observer);
	}
	public void unregisterObserver(ModelObserver observer) {
		observers.remove(observer);
	}
	
	public void notifyObservers() {
		for(ModelObserver ob: observers) {
			ob.update(this);
		}
	}
	
	private void internalStateChanged() {
		notifyObservers();
	}
	
	// Entity
	public void addEntity(Entity e) {
		entities.put(e.getName(), e);
		internalStateChanged();
	}
	
	public void removeEntity(String key) {
		entities.remove(key);
		internalStateChanged();
	}
	
	public Entity getEntity(String key) {
		return entities.get(key);
	}
	
	public Map<String, Entity> getEntities() {
		return this.entities;
	}
	
	// Actor
	public void addActor(Actor a) {
		actors.put(a.getName(), a);
		internalStateChanged();
	}
	
	public void removeActor(String key) {
		actors.remove(key);
		internalStateChanged();
	}
	
	public Actor getActor(String key) {
		return actors.get(key);
	}
	
	public Map<String, Actor> getActors() {
		return this.actors;
	}
	
	public boolean hasActor(String key) {
		return getActor(key) != null;
	}
	
	public void addMessage(Message message) {
		messages.add(message);
	}
	
	public void addMessages(List<Message> messages) {
		this.messages.addAll(messages);
	}
	
	public List<Message> getMessages() {
		return this.messages;
	}
	
	public void addNode(Node node) {
		nodes.add(node);
	}
	
	public void addNodes(List<Node> nodes) {
		this.nodes.addAll(nodes);
	}
	
	public Node getNode(String stepName) {
		return this.nodesMap.get(stepName);
	}
	
	public Collection<Node> getNodeValues() {
		return this.nodesMap.values();
	}
	
	public void addNode(String name, Node node) {
		nodesMap.put(name, node);
	}
	
	public List<Node> getNodes() {
		return this.nodes;
	}
	
	public List<USLNode> getUslNodes() {
		return usecase.getUslNodes();
	}
}
