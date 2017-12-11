package characters.commands;

import characters.GameCharacter;

public class FireCommand extends Command {

	public FireCommand(GameCharacter player) {
		super(player);
	}

	public boolean execute() {
		return player.fire();
	}

}
