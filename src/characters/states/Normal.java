package characters.states;

import characters.CharacterState;
import characters.GameCharacter;

/**
 * Created by M.Sharaf on 08/12/2017.
 */
public class Normal extends CharacterState {

	public Normal(GameCharacter character) {
		super(character);
	}
	
	@Override
	public String toString() {
		return "Normal";
	}
	
}
