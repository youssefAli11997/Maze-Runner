package undoAndRedo;

public class Memento {

	private StateOfTheGame state;

	public Memento(StateOfTheGame state) {
		this.state = state;
	}

	public StateOfTheGame getState() {
		return state;
	}
}
