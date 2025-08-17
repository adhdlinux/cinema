package androidx.appcompat.widget;

import android.os.Build;
import android.view.View;

public class TooltipCompat {

    static class Api26Impl {
        private Api26Impl() {
        }

        static void a(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    private TooltipCompat() {
    }

    public static void a(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            Api26Impl.a(view, charSequence);
        } else {
            TooltipCompatHandler.h(view, charSequence);
        }
    }
}
