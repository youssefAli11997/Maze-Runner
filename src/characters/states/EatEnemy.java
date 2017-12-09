package characters.states;

import characters.CharacterState;
import characters.GameCharacter;

/**
 * Created by M.Sharaf on 08/12/2017.
 * kill enemy if you touch it
 */
public class EatEnemy implements CharacterState{
    GameCharacter character;

    public EatEnemy(GameCharacter character){
        this.character = character;
    }

    @Override
    public void setHealth(int health) {

    }

    @Override
    public void fire() {

    }

    @Override
    public void die() {

    }
}
