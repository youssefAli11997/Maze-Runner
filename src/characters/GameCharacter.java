package characters;

import characters.players.Player;
import characters.states.Normal;
import constants.Map;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.weapons.Weapon;
import utils.weapons.types.Gun;
import utils.weapons.types.Sword;

import java.awt.*;

public abstract class GameCharacter {

    private int currentRow;
    private int currentColumn;
    private int gridRows;
    private int gridColumns;
    private int health;
    private int healthChange;
    private Point offset;
    private Weapon weapon;
    private Gun gun;
    private Sword sword;
    private CharacterState currentState;
    private javafx.scene.image.Image playerImage;
    private ImageView playerImageView;

    public void setPlayerImage(Image playerImage) {
        this.playerImage = playerImage;
        playerImageView.setImage(playerImage);
    }


    public ImageView getPlayerImageView() {
        return playerImageView;
    }

    public GameCharacter(int currentRow, int currentColumn, int gridRows, int gridColumns) {
        this.currentRow = currentRow;
        this.currentColumn = currentColumn;
        this.gridRows = gridRows;
        this.gridColumns = gridColumns;
        sword = new Sword((Player) this);
        gun = new Gun((Player) this);
        weapon = sword;
        currentState = new Normal(this);
        offset = new Point(0, 0);
        playerImageView = new ImageView();
    }

    public void toggleWeapon(){
        if(weapon instanceof Sword){
            weapon = gun;
        }
        else{
            weapon = sword;
        }
    }

    public int getCurrentColumn() {
        return currentColumn;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentColumn(int currentColumn) {
        this.currentColumn = currentColumn;
    }

    public boolean canMove(String direction) {
        if (direction.equalsIgnoreCase(Map.playerKeys.UP)) {
            if (currentRow == 0) {
                return false;
            }
            offset = new Point(-1, 0);
            return true;
        }
        if (direction.equalsIgnoreCase(Map.playerKeys.DOWN)) {
            if (currentRow == gridRows - 1) {
                return false;
            }
            offset = new Point(1, 0);
            return true;
        }
        if (direction.equalsIgnoreCase(Map.playerKeys.LEFT)) {
            if (currentColumn == 0) {
                return false;
            }
            offset = new Point(0, -1);
            return true;
        }
        if (direction.equalsIgnoreCase(Map.playerKeys.RIGHT)) {
            if (currentColumn == gridColumns - 1) {
                return false;
            }
            offset = new Point(0, 1);
            return true;
        }
        return false;
    }

    public boolean move(String direction) {
        if (direction.equalsIgnoreCase(Map.playerKeys.UP)) {
            if (currentRow == 0) {
                return false;
            }
            currentRow--;
            return true;
        }
        if (direction.equalsIgnoreCase(Map.playerKeys.DOWN)) {
            if (currentRow == gridRows - 1) {
                return false;
            }
            currentRow++;
            return true;
        }
        if (direction.equalsIgnoreCase(Map.playerKeys.LEFT)) {
            if (currentColumn == 0) {
                return false;
            }
            currentColumn--;
            return true;
        }
        if (direction.equalsIgnoreCase(Map.playerKeys.RIGHT)) {
            if (currentColumn == gridColumns - 1) {
                return false;
            }
            currentColumn++;
            return true;
        }
        return false;
    }

    private String directionMapped(int dir) {
        if (dir == Map.PlayerDirection.UP) {
            return Map.playerKeys.UP;
        } else if (dir == Map.PlayerDirection.RIGHT) {
            return Map.playerKeys.RIGHT;
        } else if (dir == Map.PlayerDirection.LEFT) {
            return Map.playerKeys.LEFT;
        } else if (dir == Map.PlayerDirection.DOWN) {
            return Map.playerKeys.DOWN;
        }
        return null;
    }

    public void draw(int dir, int row, int column) throws InterruptedException {
        //TODO make calculations -> crop photo and change offset

        int offsetX = 1;
        int offsetY = 1;

        if (dir == Map.PlayerDirection.UP) {
            offsetY = -1;
        } else if (dir == Map.PlayerDirection.LEFT) {
            offsetX = -1;
        }

        int finalDir = dir;
        int finalOffsetY = offsetY;
        int finalOffsetX = offsetX;
        final int[] imageIndex = {0};

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 4; i++) {
                imageIndex[0] *= 70;
                playerImageView.setViewport(new Rectangle2D(imageIndex[0], finalDir * 70, 70, 70));

                if (finalDir == Map.PlayerDirection.UP || finalDir == Map.PlayerDirection.DOWN) {
                    playerImageView.setLayoutX(column * 70);
                    playerImageView.setLayoutY(row * 70 - (70 * finalOffsetY) + (17.5 * finalOffsetY * i));
                } else if (finalDir == Map.PlayerDirection.RIGHT || finalDir == Map.PlayerDirection.LEFT) {
                    playerImageView.setLayoutX(column * 70 - (70 * finalOffsetX) + (17.5 * finalOffsetX * i));
                    playerImageView.setLayoutY(row * 70);
                }

                imageIndex[0] = i;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Thread.currentThread().interrupt();
        });
        t1.start();

    }

    public void setCurrentState(CharacterState newState) {
        currentState = newState;
    }

    public CharacterState getCurrentState() {
        return currentState;
    }

    /**
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * @param health the health change to set
     */
    public void setHealthChange(int health) {
        currentState.setHealthChange(health);
    }

    public int getHealthChange() {
        return healthChange;
    }

    /**
     * @return the weapon
     */
    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * @param weapon the weapon to set
     */
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public boolean fire(Object object) {
        currentState.fire(object);
        return weapon.getBullets() == 0;
    }

    public void die() {
        // TODO implement death better to call die than setting health to 0
        currentState.die();
    }

    public Point getOffset() {
        return offset;
    }
}