package characters.commands;

import characters.GameCharacter;

public class JumpCommand extends Command {

	public JumpCommand(GameCharacter player) {
		super(player);

	}

	public void execute() {
		player.move("jump");
	}

}
