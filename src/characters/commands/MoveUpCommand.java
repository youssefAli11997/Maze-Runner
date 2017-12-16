package characters.commands;

import characters.GameCharacter;
import constants.Map;

public class MoveUpCommand extends Command {

	public MoveUpCommand(GameCharacter player) {
		super(player);
	}

	public boolean execute() {
		return player.move(Map.playerKeys.UP);
	}

	@Override
	public boolean canExecute() {
		return player.canMove(Map.playerKeys.UP);
	}

	@Override
	public String toString() {
		return "up";
	}
}
