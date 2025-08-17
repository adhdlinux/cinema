package androidx.appcompat.content.res;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.ContextCompat;

@SuppressLint({"RestrictedAPI"})
public final class AppCompatResources {
    private AppCompatResources() {
    }

    public static ColorStateList a(Context context, int i2) {
        return ContextCompat.getColorStateList(context, i2);
    }

    public static Drawable b(Context context, int i2) {
        return ResourceManagerInternal.h().j(context, i2);
    }
}
