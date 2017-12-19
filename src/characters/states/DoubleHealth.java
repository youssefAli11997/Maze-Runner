package characters.states;

import characters.CharacterState;
import characters.GameCharacter;

/**
 * Created by M.Sharaf on 08/12/2017. double increase health and half decrease
 * health gifts should increase and bombs should decrease to set value ! or we
 * can set value an do some math here -> if new is greater double the difference
 * and so on go to normal state after some time (10s)
 */
public class DoubleHealth extends CharacterState {

	public DoubleHealth(GameCharacter character) {
		super(character);
	}

	@Override
	public void setHealthChange(int health) {
		if (health < 0) {
			health /= 2;
		} else {
			health *= 2;
		}

		if (health + super.getCharacter().getHealth() <= 0) {
			this.die();
		} else {
			super.getCharacter().setHealth(health + super.getCharacter().getHealth());
		}

	}
	
	@Override
	public String toString() {
		return "Double HP";
	}
}
