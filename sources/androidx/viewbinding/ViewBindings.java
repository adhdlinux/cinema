package androidx.viewbinding;

import android.view.View;
import android.view.ViewGroup;

public class ViewBindings {
    private ViewBindings() {
    }

    public static <T extends View> T a(View view, int i2) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            T findViewById = viewGroup.getChildAt(i3).findViewById(i2);
            if (findViewById != null) {
                return findViewById;
            }
        }
        return null;
    }
}
