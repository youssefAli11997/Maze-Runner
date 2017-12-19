package characters.states;

import characters.CharacterState;
import characters.GameCharacter;

/**
 * Created by M.Sharaf on 08/12/2017. can pass throw only one wall or bomb
 * without breaking it then goes to Normal state
 */
public class PassThrough extends CharacterState {

	public PassThrough(GameCharacter character) {
		super(character);
	}

	@Override
	public void die() {

	}
	
	@Override
	public String toString() {
		return "Pass Through";
	}
}
