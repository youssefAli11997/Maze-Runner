package characters.states;

import characters.CharacterState;
import characters.GameCharacter;

/**
 * Created by M.Sharaf on 08/12/2017.
 * any death isn't counted
 * go to normal state after some time (10s)
 */
public class Immortal implements CharacterState {
    GameCharacter character;

    public Immortal(GameCharacter character){
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
