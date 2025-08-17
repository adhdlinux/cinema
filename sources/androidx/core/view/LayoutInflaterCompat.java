package androidx.core.view;

import android.view.LayoutInflater;

public final class LayoutInflaterCompat {
    private LayoutInflaterCompat() {
    }

    public static void a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
    }
}
