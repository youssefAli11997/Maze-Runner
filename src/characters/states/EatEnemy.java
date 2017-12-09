package characters.states;

import characters.CharacterState;
import characters.GameCharacter;

/**
 * Created by M.Sharaf on 08/12/2017.
 * kill enemy if you touch it
 */
public class EatEnemy extends CharacterState{
    GameCharacter character;

    public EatEnemy(GameCharacter character){
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
