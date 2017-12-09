package characters;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

public class IsKeyPressed {

	private static volatile boolean wPressed = false;
	private static volatile boolean dPressed = false;
	private static volatile boolean aPressed = false;
	private static volatile boolean sPressed = false;

	public static boolean isWPressed() {
		synchronized (IsKeyPressed.class) {
			return wPressed;
		}
	}

	public static boolean isDPressed() {
		synchronized (IsKeyPressed.class) {
			return dPressed;
		}
	}

	public static boolean isAPressed() {
		synchronized (IsKeyPressed.class) {
			return aPressed;
		}
	}

	public static boolean isSPressed() {
		synchronized (IsKeyPressed.class) {
			return sPressed;
		}
	}

	public static void main(String[] args) {
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

			@Override
			public boolean dispatchKeyEvent(KeyEvent ke) {
				synchronized (IsKeyPressed.class) {
					switch (ke.getID()) {
					case KeyEvent.KEY_PRESSED:
						if (ke.getKeyCode() == KeyEvent.VK_W) {
							wPressed = true;
						}
						if (ke.getKeyCode() == KeyEvent.VK_D) {
							dPressed = true;
						}
						if (ke.getKeyCode() == KeyEvent.VK_A) {
							aPressed = true;
						}
						if (ke.getKeyCode() == KeyEvent.VK_S) {
							sPressed = true;
						}
						break;

					case KeyEvent.KEY_RELEASED:
						if (ke.getKeyCode() == KeyEvent.VK_W) {
							wPressed = false;
						}
						if (ke.getKeyCode() == KeyEvent.VK_D) {
							dPressed = false;
						}
						if (ke.getKeyCode() == KeyEvent.VK_A) {
							aPressed = false;
						}
						if (ke.getKeyCode() == KeyEvent.VK_S) {
							sPressed = false;
						}
						break;
					}
					return false;
				}
			}

		});

		if (IsKeyPressed.isWPressed()) {
			// do your thing.
		}
		if (IsKeyPressed.isDPressed()) {
			// do your thing.
		}
		if (IsKeyPressed.isAPressed()) {
			// do your thing.
		}
		if (IsKeyPressed.isSPressed()) {
			// do your thing.
		}
	}
}