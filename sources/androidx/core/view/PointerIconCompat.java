package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.PointerIcon;

public final class PointerIconCompat {

    /* renamed from: a  reason: collision with root package name */
    private final PointerIcon f2766a;

    static class Api24Impl {
        private Api24Impl() {
        }

        static PointerIcon a(Bitmap bitmap, float f2, float f3) {
            return PointerIcon.create(bitmap, f2, f3);
        }

        static PointerIcon b(Context context, int i2) {
            return PointerIcon.getSystemIcon(context, i2);
        }

        static PointerIcon c(Resources resources, int i2) {
            return PointerIcon.load(resources, i2);
        }
    }

    private PointerIconCompat(PointerIcon pointerIcon) {
        this.f2766a = pointerIcon;
    }

    public static PointerIconCompat b(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new PointerIconCompat(Api24Impl.b(context, i2));
        }
        return new PointerIconCompat((PointerIcon) null);
    }

    public Object a() {
        return this.f2766a;
    }
}
