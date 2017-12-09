package characters.commands;

import characters.GameCharacter;

public class MoveUpCommand extends Command {

	public MoveUpCommand(GameCharacter player) {
		super(player);
	}

	public void execute() {
		player.move("up");
	}
}
