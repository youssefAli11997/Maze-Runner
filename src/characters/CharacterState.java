package characters;

import org.apache.log4j.Logger;

import characters.players.Player;

/**
 * Created by M.Sharaf on 08/12/2017. both player and enemy can have them all
 * states should be obtained from gifts some states have same default
 * implementation !!
 */
public abstract class CharacterState {
	static Logger log = Logger.getLogger(CharacterState.class.getName());

	GameCharacter character;

	public CharacterState(GameCharacter character) {
		this.character = character;
	}

	public GameCharacter getCharacter() {
		return character;
	}

	public void setHealthChange(int health) {
		
		if (health + character.getHealth() <= 0) {
			log.info("player died");
			this.die();
		} else {
			character.setHealth(health + character.getHealth());
			log.info("change in health");
		}
		
	}

	public void fire(Object object) {
		character.getWeapon().action(object);
	}

	public void die() {

	}

	public void setScoreChange(long score) {
		Player player = (Player)getCharacter();
		player.setScore(player.getScore()+score);
		log.info("change in score");
	}
}
