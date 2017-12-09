package characters.commands;

import characters.GameCharacter;

public class MoveRightCommand extends Command {

	public MoveRightCommand(GameCharacter player) {
		super(player);
	}

	public void execute() {
		player.move("right");
	}

}
