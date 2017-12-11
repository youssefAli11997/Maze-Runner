package characters.commands;

import characters.GameCharacter;

public class FireCommand extends Command {
	protected Object object;

	public FireCommand(GameCharacter player, Object object) {
		super(player);
	}

	public void execute() {
		player.fire(object);
	}

}
