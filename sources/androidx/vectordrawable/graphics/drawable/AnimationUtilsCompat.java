package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class AnimationUtilsCompat {
    private AnimationUtilsCompat() {
    }

    public static Interpolator a(Context context, int i2) throws Resources.NotFoundException {
        return AnimationUtils.loadInterpolator(context, i2);
    }
}
