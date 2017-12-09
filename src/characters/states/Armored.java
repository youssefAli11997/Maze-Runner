package characters.states;

import characters.CharacterState;
import characters.GameCharacter;

/**
 * Created by M.Sharaf on 08/12/2017.
 * first death isn't counted, enemy or bomb vanish, go to Normal state
 * go to normal state after some time (10s)
 */
public class Armored extends CharacterState {
    GameCharacter character;

    public Armored(GameCharacter character){
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
