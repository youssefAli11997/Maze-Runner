package characters;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

public class IsKeyPressed {
	private static volatile boolean wPressed = false;

	public static boolean isWPressed() {
		synchronized (IsKeyPressed.class) {
			return wPressed;
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
						break;

					case KeyEvent.KEY_RELEASED:
						if (ke.getKeyCode() == KeyEvent.VK_W) {
							wPressed = false;
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
	}
}