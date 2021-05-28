package frsl.metamodel;

public interface SelectionObservable {
	public void registerObserver(SelectionObserver observer);
	public void unregisterObserver(SelectionObserver observer);
	public void notifyObservers();
}
