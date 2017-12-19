package observer;

public interface TimerSubject {
	public void addObserver(TimerObserver ob);
	public void removeObserver(TimerObserver ob);
	public void notifyObservers();
}
