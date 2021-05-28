package frsl.metamodel;

public interface ModelObservable {
	public void registerObserver(ModelObserver observer);
	public void unregisterObserver(ModelObserver observer);
	public void notifyObservers();
}
