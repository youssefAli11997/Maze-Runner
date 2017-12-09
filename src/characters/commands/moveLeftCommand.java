package characters.commands;

import characters.GameCharacter;

public class moveLeftCommand extends Command {

	public moveLeftCommand(GameCharacter player) {
		super(player);

	}

	public void execute() {
		player.move("left");
	}

}
