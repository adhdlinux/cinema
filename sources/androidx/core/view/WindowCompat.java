package androidx.core.view;

import android.view.View;
import android.view.Window;

public final class WindowCompat {
    private WindowCompat() {
    }

    public static WindowInsetsControllerCompat a(Window window, View view) {
        return new WindowInsetsControllerCompat(window, view);
    }
}
