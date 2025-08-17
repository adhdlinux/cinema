package com.unity3d.services.core.misc;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.unity3d.services.core.log.DeviceLog;

public class ViewUtilities {
    public static float dpFromPx(Context context, float f2) {
        return f2 / context.getResources().getDisplayMetrics().density;
    }

    public static float pxFromDp(Context context, float f2) {
        return f2 * context.getResources().getDisplayMetrics().density;
    }

    public static void removeViewFromParent(View view) {
        if (view != null && view.getParent() != null) {
            try {
                ((ViewGroup) view.getParent()).removeView(view);
            } catch (Exception e2) {
                DeviceLog.exception("Error while removing view from it's parent", e2);
            }
        }
    }

    public static void setBackground(View view, Drawable drawable) {
        try {
            View.class.getMethod("setBackground", new Class[]{Drawable.class}).invoke(view, new Object[]{drawable});
        } catch (Exception e2) {
            DeviceLog.exception("Couldn't run" + "setBackground", e2);
        }
    }
}
