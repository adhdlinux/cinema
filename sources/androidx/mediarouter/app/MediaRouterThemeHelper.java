package androidx.mediarouter.app;

import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.mediarouter.R$attr;
import androidx.mediarouter.R$color;
import androidx.mediarouter.R$drawable;
import androidx.mediarouter.R$style;

final class MediaRouterThemeHelper {

    /* renamed from: a  reason: collision with root package name */
    private static final int f10455a = R$color.mr_dynamic_dialog_icon_light;

    private MediaRouterThemeHelper() {
    }

    static Context a(Context context) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, l(context));
        int p2 = p(contextThemeWrapper, R$attr.mediaRouteTheme);
        if (p2 != 0) {
            return new ContextThemeWrapper(contextThemeWrapper, p2);
        }
        return contextThemeWrapper;
    }

    static Context b(Context context, int i2, boolean z2) {
        int i3;
        if (i2 == 0) {
            if (!z2) {
                i3 = androidx.appcompat.R$attr.B;
            } else {
                i3 = androidx.appcompat.R$attr.f104o;
            }
            i2 = p(context, i3);
        }
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i2);
        if (p(contextThemeWrapper, R$attr.mediaRouteTheme) != 0) {
            return new ContextThemeWrapper(contextThemeWrapper, l(contextThemeWrapper));
        }
        return contextThemeWrapper;
    }

    static int c(Context context) {
        int p2 = p(context, R$attr.mediaRouteTheme);
        if (p2 == 0) {
            return l(context);
        }
        return p2;
    }

    static int d(Context context) {
        int o2 = o(context, 0, androidx.appcompat.R$attr.f114y);
        if (ColorUtils.e(o2, o(context, 0, 16842801)) < 3.0d) {
            return o(context, 0, androidx.appcompat.R$attr.f109t);
        }
        return o2;
    }

    static Drawable e(Context context) {
        return j(context, R$drawable.mr_cast_checkbox);
    }

    static int f(Context context, int i2) {
        if (ColorUtils.e(-1, o(context, i2, androidx.appcompat.R$attr.f114y)) >= 3.0d) {
            return -1;
        }
        return -570425344;
    }

    static Drawable g(Context context) {
        return i(context, R$attr.mediaRouteDefaultIconDrawable);
    }

    static float h(Context context) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(16842803, typedValue, true)) {
            return typedValue.getFloat();
        }
        return 0.5f;
    }

    private static Drawable i(Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{i2});
        Drawable r2 = DrawableCompat.r(AppCompatResources.b(context, obtainStyledAttributes.getResourceId(0, 0)));
        if (r(context)) {
            DrawableCompat.n(r2, ContextCompat.getColor(context, f10455a));
        }
        obtainStyledAttributes.recycle();
        return r2;
    }

    private static Drawable j(Context context, int i2) {
        Drawable r2 = DrawableCompat.r(AppCompatResources.b(context, i2));
        if (r(context)) {
            DrawableCompat.n(r2, ContextCompat.getColor(context, f10455a));
        }
        return r2;
    }

    static Drawable k(Context context) {
        return j(context, R$drawable.mr_cast_mute_button);
    }

    private static int l(Context context) {
        if (r(context)) {
            if (f(context, 0) == -570425344) {
                return R$style.Theme_MediaRouter_Light;
            }
            return R$style.Theme_MediaRouter_Light_DarkControlPanel;
        } else if (f(context, 0) == -570425344) {
            return R$style.Theme_MediaRouter_LightControlPanel;
        } else {
            return R$style.Theme_MediaRouter;
        }
    }

    static Drawable m(Context context) {
        return i(context, R$attr.mediaRouteSpeakerIconDrawable);
    }

    static Drawable n(Context context) {
        return i(context, R$attr.mediaRouteSpeakerGroupIconDrawable);
    }

    private static int o(Context context, int i2, int i3) {
        if (i2 != 0) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, new int[]{i3});
            int color = obtainStyledAttributes.getColor(0, 0);
            obtainStyledAttributes.recycle();
            if (color != 0) {
                return color;
            }
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i3, typedValue, true);
        if (typedValue.resourceId != 0) {
            return context.getResources().getColor(typedValue.resourceId);
        }
        return typedValue.data;
    }

    static int p(Context context, int i2) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i2, typedValue, true)) {
            return typedValue.resourceId;
        }
        return 0;
    }

    static Drawable q(Context context) {
        return i(context, R$attr.mediaRouteTvIconDrawable);
    }

    private static boolean r(Context context) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(androidx.appcompat.R$attr.H, typedValue, true) || typedValue.data == 0) {
            return false;
        }
        return true;
    }

    static void s(Context context, Dialog dialog) {
        int i2;
        View decorView = dialog.getWindow().getDecorView();
        if (r(context)) {
            i2 = R$color.mr_dynamic_dialog_background_light;
        } else {
            i2 = R$color.mr_dynamic_dialog_background_dark;
        }
        decorView.setBackgroundColor(ContextCompat.getColor(context, i2));
    }

    static void t(Context context, ProgressBar progressBar) {
        int i2;
        if (progressBar.isIndeterminate()) {
            if (r(context)) {
                i2 = R$color.mr_cast_progressbar_progress_and_thumb_light;
            } else {
                i2 = R$color.mr_cast_progressbar_progress_and_thumb_dark;
            }
            progressBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(context, i2), PorterDuff.Mode.SRC_IN);
        }
    }

    static void u(Context context, View view, View view2, boolean z2) {
        int o2 = o(context, 0, androidx.appcompat.R$attr.f114y);
        int o3 = o(context, 0, androidx.appcompat.R$attr.f115z);
        if (z2 && f(context, 0) == -570425344) {
            o3 = o2;
            o2 = -1;
        }
        view.setBackgroundColor(o2);
        view2.setBackgroundColor(o3);
        view.setTag(Integer.valueOf(o2));
        view2.setTag(Integer.valueOf(o3));
    }

    static void v(Context context, MediaRouteVolumeSlider mediaRouteVolumeSlider) {
        int i2;
        int i3;
        if (r(context)) {
            i3 = ContextCompat.getColor(context, R$color.mr_cast_progressbar_progress_and_thumb_light);
            i2 = ContextCompat.getColor(context, R$color.mr_cast_progressbar_background_light);
        } else {
            i3 = ContextCompat.getColor(context, R$color.mr_cast_progressbar_progress_and_thumb_dark);
            i2 = ContextCompat.getColor(context, R$color.mr_cast_progressbar_background_dark);
        }
        mediaRouteVolumeSlider.b(i3, i2);
    }

    static void w(Context context, MediaRouteVolumeSlider mediaRouteVolumeSlider, View view) {
        int f2 = f(context, 0);
        if (Color.alpha(f2) != 255) {
            f2 = ColorUtils.k(f2, ((Integer) view.getTag()).intValue());
        }
        mediaRouteVolumeSlider.a(f2);
    }
}
