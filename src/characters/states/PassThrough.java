package characters.states;

import characters.CharacterState;
import characters.GameCharacter;

/**
 * Created by M.Sharaf on 08/12/2017.
 * can pass throw only one wall or bomb without breaking it then goes to Normal state
 */
public class PassThrough implements CharacterState {
    GameCharacter character;

    public PassThrough(GameCharacter character){
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
