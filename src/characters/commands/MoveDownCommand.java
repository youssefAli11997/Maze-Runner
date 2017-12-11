package characters.commands;

import characters.GameCharacter;

public class MoveDownCommand extends Command {

	public MoveDownCommand(GameCharacter player) {
		super(player);

	}

	public boolean execute() {
		return player.move("down");
	}

	@Override
	public boolean canExecute() {
		return player.canMove("down");
	}

}
