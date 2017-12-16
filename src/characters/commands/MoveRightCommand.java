package characters.commands;

import characters.GameCharacter;
import constants.Map;

public class MoveRightCommand extends Command {

	public MoveRightCommand(GameCharacter player) {
		super(player);
	}

	public boolean execute() {
		return player.move(Map.playerKeys.RIGHT);
	}

	@Override
	public boolean canExecute() {
		return player.canMove(Map.playerKeys.RIGHT);
	}

	@Override
	public String toString() {
		return "right";
	}
}
