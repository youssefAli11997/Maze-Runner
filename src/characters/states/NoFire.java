package characters.states;

import characters.CharacterState;
import characters.GameCharacter;

/**
 * Created by M.Sharaf on 08/12/2017. can't fire go to normal state after some
 * time (10s)
 */
public class NoFire extends CharacterState {

	public NoFire(GameCharacter character) {
		super(character);
	}

	@Override
	public void fire(Object object) {
		// do nothong
	}
	
	@Override
	public String toString() {
		return "No Fire";
	}
	
}
