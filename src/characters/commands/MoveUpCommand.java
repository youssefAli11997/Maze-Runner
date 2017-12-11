package characters.commands;

import characters.GameCharacter;

public class MoveUpCommand extends Command {

	public MoveUpCommand(GameCharacter player) {
		super(player);
	}

	public boolean execute() {
		return player.move("up");
	}
}
