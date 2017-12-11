package characters.commands;

import characters.GameCharacter;

public class JumpCommand extends Command {

	public JumpCommand(GameCharacter player) {
		super(player);

	}

	public boolean execute() {
		return player.move("jump");
	}

	@Override
	public boolean canExecute() {
		return false;
	}

}
