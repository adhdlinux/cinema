package androidx.appcompat.resources;

import android.content.res.Resources;
import android.util.TypedValue;

public class Compatibility$Api15Impl {
    private Compatibility$Api15Impl() {
    }

    public static void a(Resources resources, int i2, int i3, TypedValue typedValue, boolean z2) {
        resources.getValueForDensity(i2, i3, typedValue, z2);
    }
}
