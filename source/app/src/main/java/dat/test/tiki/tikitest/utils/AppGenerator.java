package dat.test.tiki.tikitest.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import java.util.Random;

import dat.test.tiki.tikitest.R;

public class AppGenerator {

    public static final String KEY_WORD_BASE_URL = "https://gist.githubusercontent.com/talenguyen/38b790795722e7d7b1b5db051c5786e5/raw/bcb7729cadbbb0fcc97d22d0676575524fa7f372/";

    public static final String RANDOM_IMAGE = "https://picsum.photos/100/100/?random";

    public static int getRandomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    // set background and color
    public static Drawable getRoundBackground(Context context, int colorHex) {
        Drawable mDrawable = ContextCompat.getDrawable(context, R.drawable.bg_radius_round);
        if (mDrawable != null) {
            mDrawable.setColorFilter(new PorterDuffColorFilter(colorHex, PorterDuff.Mode.MULTIPLY));
        }
        return mDrawable;
    }
}
