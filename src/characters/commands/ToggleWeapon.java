package characters.commands;

import characters.GameCharacter;

public class ToggleWeapon extends Command{

	public ToggleWeapon(GameCharacter player) {
		super(player);
	}

	@Override
	public boolean execute() {
		return false;
	}

	@Override
	public boolean canExecute() {
		return false;
	}

}
