package characters.states;

import characters.CharacterState;
import characters.GameCharacter;

/**
 * Created by M.Sharaf on 08/12/2017. first death isn't counted, enemy or bomb
 * vanish, go to Normal state go to normal state after some time (10s)
 */
public class Armored extends CharacterState {

	public Armored(GameCharacter character) {
		super(character);
	}

		@Override
	public void die() {
		GameCharacter character = super.getCharacter();
		character.setCurrentState(new Normal(character));
	}
	
	@Override
	public String toString() {
		return "Armored";
	}
}
