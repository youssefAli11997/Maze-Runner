package characters.commands;

import characters.GameCharacter;
import constants.Map;

public class MoveDownCommand extends Command {

	public MoveDownCommand(GameCharacter player) {
		super(player);

	}

	public boolean execute() {
		return player.move(Map.playerKeys.DOWN);
	}

	@Override
	public boolean canExecute() {
		return player.canMove(Map.playerKeys.DOWN);
	}

	@Override
	public String toString() {
		return "down";
	}
}
