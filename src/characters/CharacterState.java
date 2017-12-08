package characters;

/**
 * Created by M.Sharaf on 08/12/2017.
 * both player and enemy can have them
 * all states should be obtained from gifts
 * some states have same default implementation !!
 */
public interface CharacterState {
    public void setHealth(int health);
    public void fire();
    public void die();
}
