package characters.commands;

import characters.GameCharacter;

public abstract class Command {

	protected GameCharacter player;

	public Command(GameCharacter player) {
		this.player = player;
	}

	public abstract boolean execute();

	public abstract boolean canExecute();
}
