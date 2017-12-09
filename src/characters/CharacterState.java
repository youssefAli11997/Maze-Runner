package characters;

import game_engine.Game;

/**
 * Created by M.Sharaf on 08/12/2017. both player and enemy can have them all
 * states should be obtained from gifts some states have same default
 * implementation !!
 */
public abstract class CharacterState {
	GameCharacter character;

	public CharacterState(GameCharacter character) {
		this.character = character;
	}

	public GameCharacter getCharacter() {
		return character;
	}

	public void setHealthChange(int health) {

		if (health + character.getHealth() <= 0) {
			this.die();
		} else {
			character.setHealth(health + character.getHealth());
		}

	}

	public void fire() {
		character.getWeapon().action();
	}

	public void die() {

	}
}
