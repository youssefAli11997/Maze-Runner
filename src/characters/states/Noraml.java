package characters.states;

import characters.CharacterState;
import characters.GameCharacter;

/**
 * Created by M.Sharaf on 08/12/2017.
 */
public class Noraml extends CharacterState {
    GameCharacter character;

    public Noraml(GameCharacter character){
        this.character = character;
    }

    @Override
    public void setHealthChange(int health) {
        if (health <= 0){
            this.die();
        }

        character.setHealth(health);
    }

    @Override
    public void fire() {
        character.getWeapon().action();
    }

    @Override
    public void die() {
    	character.setHealth(0);
    }
}
