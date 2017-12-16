package characters.commands;

import characters.GameCharacter;
import constants.Map;

public class MoveLeftCommand extends Command {

	public MoveLeftCommand(GameCharacter player) {
		super(player);

	}

	public boolean execute() {
		return player.move(Map.playerKeys.LEFT);
	}

	@Override
	public boolean canExecute() {
		return player.canMove(Map.playerKeys.LEFT);
	}

	@Override
	public String toString() {
		return "left";
	}
}
