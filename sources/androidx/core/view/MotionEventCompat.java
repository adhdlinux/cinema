package androidx.core.view;

import android.view.MotionEvent;

public final class MotionEventCompat {
    private MotionEventCompat() {
    }

    public static boolean a(MotionEvent motionEvent, int i2) {
        return (motionEvent.getSource() & i2) == i2;
    }
}
