package characters.commands;

import characters.GameCharacter;

public class MoveDownCommand extends Command {

	public MoveDownCommand(GameCharacter player) {
		super(player);

	}

	public void execute() {
		player.move("down");
	}

}
