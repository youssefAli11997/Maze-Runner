package characters.states;

import characters.CharacterState;
import characters.GameCharacter;

/**
 * Created by M.Sharaf on 08/12/2017. any death isn't counted go to normal state
 * after some time (10s)
 */
public class Immortal extends CharacterState {

	public Immortal(GameCharacter character) {
		super(character);
	}

	@Override
	public void die() {

	}
	
	@Override
	public String toString() {
		return "Immortal";
	}
}
