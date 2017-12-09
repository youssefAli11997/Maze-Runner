package characters.states;

import characters.CharacterState;
import characters.GameCharacter;

/**
 * Created by M.Sharaf on 08/12/2017.
 * can't fire
 * go to normal state after some time (10s)
 */
public class NoFire extends CharacterState {
    GameCharacter character;

    public NoFire(GameCharacter character){
        this.character = character;
    }

    @Override
    public void setHealthChange(int health) {

    }

    @Override
    public void fire() {
        //do nothong
    }

    @Override
    public void die() {

    }
}
