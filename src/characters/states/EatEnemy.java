package characters.states;

import characters.CharacterState;
import characters.GameCharacter;

/**
 * Created by M.Sharaf on 08/12/2017. kill enemy if you touch it
 */
public class EatEnemy extends CharacterState {

	public EatEnemy(GameCharacter character) {
		super(character);
	}

	@Override
	public void die() {
		// Enemy Die Player lives
	}
	
	@Override
	public String toString() {
		return "EAT Enemy";
	}
}
