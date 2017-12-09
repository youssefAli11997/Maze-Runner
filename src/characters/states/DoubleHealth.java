package characters.states;

import characters.CharacterState;
import characters.GameCharacter;

/**
 * Created by M.Sharaf on 08/12/2017.
 * double increase health and half decrease health
 * gifts should increase and bombs should decrease to set value !
 * or we can set value an do some math here -> if new is greater double the difference and so on
 * go to normal state after some time (10s)
 */
public class DoubleHealth implements CharacterState {
    GameCharacter character;

    public DoubleHealth(GameCharacter character){
        this.character = character;
    }

    @Override
    public void setHealthChange(int health) {

    }

    @Override
    public void fire() {

    }

    @Override
    public void die() {

    }
}
