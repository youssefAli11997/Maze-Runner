package characters.commands;

import characters.GameCharacter;

public class FireCommand extends Command {
	protected Object object;

	public FireCommand(GameCharacter player, Object object) {
		super(player);
	}
	public boolean execute() {
		return player.fire(object);
	}

	@Override
	public boolean canExecute() {
		return true;
	}
}
