package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

public final class PathInterpolatorCompat {

    static class Api21Impl {
        private Api21Impl() {
        }

        static PathInterpolator a(float f2, float f3) {
            return new PathInterpolator(f2, f3);
        }

        static PathInterpolator b(float f2, float f3, float f4, float f5) {
            return new PathInterpolator(f2, f3, f4, f5);
        }

        static PathInterpolator c(Path path) {
            return new PathInterpolator(path);
        }
    }

    private PathInterpolatorCompat() {
    }

    public static Interpolator a(float f2, float f3, float f4, float f5) {
        return Api21Impl.b(f2, f3, f4, f5);
    }
}
