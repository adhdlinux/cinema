package com.applovin.sdk;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.TypedValue;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.g;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class AppLovinSdkUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final Handler f16060a = new Handler(Looper.getMainLooper());

    public static final class Size {
        public static final Size ZERO = new Size(0, 0);

        /* renamed from: a  reason: collision with root package name */
        private int f16061a;

        /* renamed from: b  reason: collision with root package name */
        private int f16062b;

        private Size() {
        }

        public Size(int i2, int i3) {
            this.f16061a = i2;
            this.f16062b = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Size)) {
                return false;
            }
            Size size = (Size) obj;
            return this.f16061a == size.getWidth() && this.f16062b == size.getHeight();
        }

        public int getHeight() {
            return this.f16062b;
        }

        public int getWidth() {
            return this.f16061a;
        }

        public int hashCode() {
            int i2 = this.f16062b;
            int i3 = this.f16061a;
            return i2 ^ ((i3 >>> 16) | (i3 << 16));
        }

        public String toString() {
            return this.f16061a + "x" + this.f16062b;
        }
    }

    private static boolean a(String str, String str2) {
        for (String startsWith : CollectionUtils.explode(str2)) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    public static int dpToPx(Context context, int i2) {
        return (int) TypedValue.applyDimension(1, (float) i2, context.getResources().getDisplayMetrics());
    }

    public static boolean isEmulator() {
        return a(Build.DEVICE, "goldfish,vbox") || a(Build.HARDWARE, "ranchu,generic,vbox") || a(Build.MANUFACTURER, "Genymotion") || a(Build.MODEL, "Android SDK built for x86");
    }

    public static boolean isFireOS(Context context) {
        return "amazon".equalsIgnoreCase(Build.MANUFACTURER) || isFireTv(context);
    }

    public static boolean isFireTv(Context context) {
        return context.getPackageManager().hasSystemFeature("amazon.hardware.fire_tv");
    }

    public static boolean isSdkVersionGreaterThanOrEqualTo(String str) {
        return AppLovinSdk.VERSION_CODE >= Utils.toVersionCode(str);
    }

    public static boolean isTablet(Context context) {
        Point a2 = g.a(context);
        return Math.min(a2.x, a2.y) >= dpToPx(context, 600);
    }

    public static boolean isTv(Context context) {
        if (isFireTv(context)) {
            return true;
        }
        return context.getPackageManager().hasSystemFeature(g.d() ? "android.software.leanback" : "android.hardware.type.television");
    }

    public static boolean isValidString(String str) {
        return !TextUtils.isEmpty(str);
    }

    public static int pxToDp(Context context, int i2) {
        return (int) Math.ceil((double) (((float) i2) / context.getResources().getDisplayMetrics().density));
    }

    public static void runOnUiThread(Runnable runnable) {
        runOnUiThread(false, runnable);
    }

    public static void runOnUiThread(boolean z2, Runnable runnable) {
        if (z2 || !Utils.isMainThread()) {
            f16060a.post(runnable);
        } else {
            runnable.run();
        }
    }

    public static void runOnUiThreadDelayed(Runnable runnable, long j2) {
        runOnUiThreadDelayed(runnable, j2, f16060a);
    }

    public static void runOnUiThreadDelayed(Runnable runnable, long j2, Handler handler) {
        if (j2 > 0) {
            handler.postDelayed(runnable, j2);
        } else if (Utils.isMainThread()) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }

    public static Map<String, String> toMap(JSONObject jSONObject) throws JSONException {
        return JsonUtils.toStringMap(jSONObject);
    }
}
