package characters.commands;

import characters.GameCharacter;

public class Command {

	protected GameCharacter player;

	public Command(GameCharacter player) {
		this.player = player;
	}

	public void execute() {
	}
}
