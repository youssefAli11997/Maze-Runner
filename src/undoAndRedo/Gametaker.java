package undoAndRedo;

import java.util.ArrayList;

public class Gametaker {

	private ArrayList<Memento> undoMementos = new ArrayList<>();
	private ArrayList<Memento> redoMementos = new ArrayList<>();
	int currentUndoMoment = 0;
	int currentRedoMoment = 0;

	public void addUndoMemento(Memento m) {
		undoMementos.add(m);
		currentUndoMoment++;

	}

	public void addRedoMemento(Memento m) {
		redoMementos.add(m);
		currentRedoMoment++;
	}

	public Memento getUndoMemento() {
		if (currentUndoMoment >= 0) {
			Memento m = undoMementos.get(currentUndoMoment);
			redoMementos.add(m);
			currentRedoMoment++;
			undoMementos.remove(currentUndoMoment);
			currentUndoMoment--;
			return m;
		}
		return null;// TODO what to do if no previous state
	}

	public Memento getRedoMemento() {

		if (currentRedoMoment >= 0) {
			Memento m = redoMementos.get(currentRedoMoment);
			undoMementos.add(m);
			currentUndoMoment++;
			redoMementos.remove(currentRedoMoment);
			currentRedoMoment--;
			return m;
		}
		return null;
	}
}
