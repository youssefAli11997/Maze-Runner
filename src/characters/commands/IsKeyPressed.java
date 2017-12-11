package characters.commands;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import characters.GameCharacter;

public class IsKeyPressed {

	// buttons Constants
	private final static int upButton = KeyEvent.VK_UP;
	private final static int rightButton = KeyEvent.VK_RIGHT;
	private final static int downButton = KeyEvent.VK_DOWN;
	private final static int leftButton = KeyEvent.VK_LEFT;
	private final static int fireButton = KeyEvent.VK_SPACE;
	private final static int jumpButton = KeyEvent.VK_ALT;
	private final static int toggleWeaponButton = KeyEvent.VK_T;

	// Button booleans indicate if pressed
	private static volatile boolean UpButtonPressed = false;
	private static volatile boolean RightButtonPressed = false;
	private static volatile boolean LeftButtonPressed = false;
	private static volatile boolean DownButtonPressed = false;
	private static volatile boolean FireButtonPressed = false;
	private static volatile boolean JumpButtonPressed = false;
	private static volatile boolean toggleWeaponButtonPressed = false;

	private static Command command;
	protected static GameCharacter player;
	protected static Object object;

	IsKeyPressed(GameCharacter player) {
		IsKeyPressed.player = player;
	}

	public static void Press() {

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
			@Override
			public boolean dispatchKeyEvent(KeyEvent ke) {
				synchronized (IsKeyPressed.class) {
					switch (ke.getID()) {
					case KeyEvent.KEY_PRESSED:
						caseKeyPressed(ke);
						break;

					case KeyEvent.KEY_RELEASED:
						caseKeyReleased(ke);
						break;
					}
					return false;
				}
			}
		});
		applyButtonsActions();
	}

	private static void caseKeyPressed(KeyEvent ke) {
		switch (ke.getKeyCode()) {
		case upButton:
			UpButtonPressed = true;
			break;

		case rightButton:
			RightButtonPressed = true;
			break;

		case leftButton:
			LeftButtonPressed = true;
			break;

		case downButton:
			DownButtonPressed = true;
			break;

		case fireButton:
			FireButtonPressed = true;
			break;

		case jumpButton:
			JumpButtonPressed = true;
			break;
			
		case toggleWeaponButton:
			toggleWeaponButtonPressed = true;
			break;
		}
	}

	private static void caseKeyReleased(KeyEvent ke) {
		switch (ke.getKeyCode()) {
		case upButton:
			UpButtonPressed = false;
			break;

		case rightButton:
			RightButtonPressed = false;
			break;

		case leftButton:
			LeftButtonPressed = false;
			break;

		case downButton:
			DownButtonPressed = false;
			break;

		case fireButton:
			FireButtonPressed = false;
			break;

		case jumpButton:
			JumpButtonPressed = false;
			break;
			
		case toggleWeaponButton:
			toggleWeaponButtonPressed = false;
			break;
		}
	}

	private static void applyButtonsActions() {
		if (IsKeyPressed.isUpButtonPressed()) {
			command = new MoveUpCommand(player);
			command.execute();
		}
		if (IsKeyPressed.isRightButtonPressed()) {
			command = new MoveRightCommand(player);
			command.execute();
		}
		if (IsKeyPressed.isLeftButtonPressed()) {
			command = new MoveLeftCommand(player);
			command.execute();
		}
		if (IsKeyPressed.isDownButtonPressed()) {
			command = new MoveDownCommand(player);
			command.execute();
		}
		if (IsKeyPressed.isFireButtonPressed()) {
			command = new FireCommand(player,object);
			command.execute();
		}
		if (IsKeyPressed.isJumpButtonPressed()) {
			command = new JumpCommand(player);
			command.execute();
		}
		if (IsKeyPressed.isToggleWeaponPressed()) {
			command = new ToggleWeapon(player);
			command.execute();
		}
	}

	private static boolean isUpButtonPressed() {
		synchronized (IsKeyPressed.class) {
			return UpButtonPressed;
		}
	}

	private static boolean isRightButtonPressed() {
		synchronized (IsKeyPressed.class) {
			return RightButtonPressed;
		}
	}

	private static boolean isLeftButtonPressed() {
		synchronized (IsKeyPressed.class) {
			return LeftButtonPressed;
		}
	}

	private static boolean isDownButtonPressed() {
		synchronized (IsKeyPressed.class) {
			return DownButtonPressed;
		}
	}

	private static boolean isFireButtonPressed() {
		synchronized (IsKeyPressed.class) {
			return FireButtonPressed;
		}
	}

	private static boolean isJumpButtonPressed() {
		synchronized (IsKeyPressed.class) {
			return JumpButtonPressed;
		}
	}

	private static boolean isToggleWeaponPressed() {
		synchronized (IsKeyPressed.class) {
			return toggleWeaponButtonPressed;
		}
	}
}