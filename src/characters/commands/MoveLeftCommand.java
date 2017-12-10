package characters.commands;

import characters.GameCharacter;

public class MoveLeftCommand extends Command {

	public MoveLeftCommand(GameCharacter player) {
		super(player);

	}

	public void execute() {
		player.move("left");
	}

}
