package game_engine;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * Created by M.Sharaf on 09/12/2017.
 * using this approach is better as game will render only once and on changing cells
 * making array of images will require updating canvas the whole time
 */
public class RenderEngine extends Transition {

    private final ImageView imageView;
    private final int count = 8;
    private final int columns = 4;
    private int width = 70;
    private int height = 70;

    private int lastIndex;

    public RenderEngine(ImageView imageView, Duration duration) {

        this.imageView = imageView;

        setCycleDuration(duration);
        setInterpolator(Interpolator.LINEAR);
    }

    @Override
    protected void interpolate(double frac) {
        final int index = Math.min((int) Math.floor(frac * count), count - 1);
        if (index != lastIndex) {
            final int x = (index % columns) * width;
            final int y = (index / columns) * height;
            imageView.setViewport(new Rectangle2D(x, y, width, height));
            lastIndex = index;
        }
    }
}
