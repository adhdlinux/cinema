package butterknife.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import java.lang.reflect.Array;
import java.util.List;

public final class Utils {
    private static final TypedValue VALUE = new TypedValue();

    private Utils() {
        throw new AssertionError("No instances.");
    }

    @SafeVarargs
    public static <T> T[] arrayFilteringNull(T... tArr) {
        int i2 = 0;
        for (T t2 : tArr) {
            if (t2 != null) {
                tArr[i2] = t2;
                i2++;
            }
        }
        if (i2 == r0) {
            return tArr;
        }
        T[] tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i2);
        System.arraycopy(tArr, 0, tArr2, 0, i2);
        return tArr2;
    }

    public static <T> T castParam(Object obj, String str, int i2, String str2, int i3, Class<T> cls) {
        try {
            return cls.cast(obj);
        } catch (ClassCastException e2) {
            throw new IllegalStateException("Parameter #" + (i2 + 1) + " of method '" + str + "' was of the wrong type for parameter #" + (i3 + 1) + " of method '" + str2 + "'. See cause for more info.", e2);
        }
    }

    public static <T> T castView(View view, int i2, String str, Class<T> cls) {
        try {
            return cls.cast(view);
        } catch (ClassCastException e2) {
            String resourceEntryName = getResourceEntryName(view, i2);
            throw new IllegalStateException("View '" + resourceEntryName + "' with ID " + i2 + " for " + str + " was of the wrong type. See cause for more info.", e2);
        }
    }

    public static <T> T findOptionalViewAsType(View view, int i2, String str, Class<T> cls) {
        return castView(view.findViewById(i2), i2, str, cls);
    }

    public static View findRequiredView(View view, int i2, String str) {
        View findViewById = view.findViewById(i2);
        if (findViewById != null) {
            return findViewById;
        }
        String resourceEntryName = getResourceEntryName(view, i2);
        throw new IllegalStateException("Required view '" + resourceEntryName + "' with ID " + i2 + " for " + str + " was not found. If this view is optional add '@Nullable' (fields) or '@Optional' (methods) annotation.");
    }

    public static <T> T findRequiredViewAsType(View view, int i2, String str, Class<T> cls) {
        return castView(findRequiredView(view, i2, str), i2, str, cls);
    }

    public static float getFloat(Context context, int i2) {
        TypedValue typedValue = VALUE;
        context.getResources().getValue(i2, typedValue, true);
        if (typedValue.type == 4) {
            return typedValue.getFloat();
        }
        throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(i2) + " type #0x" + Integer.toHexString(typedValue.type) + " is not valid");
    }

    private static String getResourceEntryName(View view, int i2) {
        if (view.isInEditMode()) {
            return "<unavailable while editing>";
        }
        return view.getContext().getResources().getResourceEntryName(i2);
    }

    public static Drawable getTintedDrawable(Context context, int i2, int i3) {
        Resources.Theme theme = context.getTheme();
        TypedValue typedValue = VALUE;
        if (theme.resolveAttribute(i3, typedValue, true)) {
            Drawable r2 = DrawableCompat.r(ContextCompat.getDrawable(context, i2).mutate());
            DrawableCompat.n(r2, ContextCompat.getColor(context, typedValue.resourceId));
            return r2;
        }
        throw new Resources.NotFoundException("Required tint color attribute with name " + context.getResources().getResourceEntryName(i3) + " and attribute ID " + i3 + " was not found.");
    }

    @SafeVarargs
    public static <T> List<T> listFilteringNull(T... tArr) {
        return new ImmutableList(arrayFilteringNull(tArr));
    }
}
