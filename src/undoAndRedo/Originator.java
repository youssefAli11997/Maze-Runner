package undoAndRedo;

public class Originator {
	
    private StateOfTheGame state;

    public void setState(StateOfTheGame state) {
        this.state = state;
    }

    public Memento save() {
        return new Memento(state);
    }
   
    public StateOfTheGame restore(Memento m) {
        state = m.getState();
        return state;
    }
}
