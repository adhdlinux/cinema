package androidx.appcompat.widget;

import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.core.graphics.drawable.DrawableCompat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DrawableUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f1244a = {16842912};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f1245b = new int[0];

    /* renamed from: c  reason: collision with root package name */
    public static final Rect f1246c = new Rect();

    static class Api18Impl {

        /* renamed from: a  reason: collision with root package name */
        private static final boolean f1247a;

        /* renamed from: b  reason: collision with root package name */
        private static final Method f1248b;

        /* renamed from: c  reason: collision with root package name */
        private static final Field f1249c;

        /* renamed from: d  reason: collision with root package name */
        private static final Field f1250d;

        /* renamed from: e  reason: collision with root package name */
        private static final Field f1251e;

        /* renamed from: f  reason: collision with root package name */
        private static final Field f1252f;

        /* JADX WARNING: Removed duplicated region for block: B:43:0x0057  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0064  */
        static {
            /*
                r0 = 1
                r1 = 0
                r2 = 0
                java.lang.String r3 = "android.graphics.Insets"
                java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ NoSuchMethodException -> 0x004e, ClassNotFoundException -> 0x0049, NoSuchFieldException -> 0x0044 }
                java.lang.Class<android.graphics.drawable.Drawable> r4 = android.graphics.drawable.Drawable.class
                java.lang.String r5 = "getOpticalInsets"
                java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x004e, ClassNotFoundException -> 0x0049, NoSuchFieldException -> 0x0044 }
                java.lang.reflect.Method r4 = r4.getMethod(r5, r6)     // Catch:{ NoSuchMethodException -> 0x004e, ClassNotFoundException -> 0x0049, NoSuchFieldException -> 0x0044 }
                java.lang.String r5 = "left"
                java.lang.reflect.Field r5 = r3.getField(r5)     // Catch:{ NoSuchMethodException -> 0x0041, ClassNotFoundException -> 0x003e, NoSuchFieldException -> 0x003b }
                java.lang.String r6 = "top"
                java.lang.reflect.Field r6 = r3.getField(r6)     // Catch:{ NoSuchMethodException -> 0x0038, ClassNotFoundException -> 0x0035, NoSuchFieldException -> 0x0032 }
                java.lang.String r7 = "right"
                java.lang.reflect.Field r7 = r3.getField(r7)     // Catch:{ ClassNotFoundException | NoSuchFieldException | NoSuchMethodException -> 0x002f }
                java.lang.String r8 = "bottom"
                java.lang.reflect.Field r3 = r3.getField(r8)     // Catch:{ ClassNotFoundException | NoSuchFieldException | NoSuchMethodException -> 0x002d }
                r8 = 1
                goto L_0x0055
            L_0x002d:
                goto L_0x0053
            L_0x002f:
                r7 = r1
                goto L_0x0053
            L_0x0032:
                r6 = r1
                goto L_0x0052
            L_0x0035:
                r6 = r1
                goto L_0x0052
            L_0x0038:
                r6 = r1
                goto L_0x0052
            L_0x003b:
                r5 = r1
                goto L_0x0047
            L_0x003e:
                r5 = r1
                goto L_0x004c
            L_0x0041:
                r5 = r1
                goto L_0x0051
            L_0x0044:
                r4 = r1
                r5 = r4
            L_0x0047:
                r6 = r5
                goto L_0x0052
            L_0x0049:
                r4 = r1
                r5 = r4
            L_0x004c:
                r6 = r5
                goto L_0x0052
            L_0x004e:
                r4 = r1
                r5 = r4
            L_0x0051:
                r6 = r5
            L_0x0052:
                r7 = r6
            L_0x0053:
                r3 = r1
                r8 = 0
            L_0x0055:
                if (r8 == 0) goto L_0x0064
                f1248b = r4
                f1249c = r5
                f1250d = r6
                f1251e = r7
                f1252f = r3
                f1247a = r0
                goto L_0x0070
            L_0x0064:
                f1248b = r1
                f1249c = r1
                f1250d = r1
                f1251e = r1
                f1252f = r1
                f1247a = r2
            L_0x0070:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.DrawableUtils.Api18Impl.<clinit>():void");
        }

        private Api18Impl() {
        }

        static Rect a(Drawable drawable) {
            if (Build.VERSION.SDK_INT < 29 && f1247a) {
                try {
                    Object invoke = f1248b.invoke(drawable, new Object[0]);
                    if (invoke != null) {
                        return new Rect(f1249c.getInt(invoke), f1250d.getInt(invoke), f1251e.getInt(invoke), f1252f.getInt(invoke));
                    }
                } catch (IllegalAccessException | InvocationTargetException unused) {
                }
            }
            return DrawableUtils.f1246c;
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static Insets a(Drawable drawable) {
            return drawable.getOpticalInsets();
        }
    }

    private DrawableUtils() {
    }

    public static boolean a(Drawable drawable) {
        return true;
    }

    static void b(Drawable drawable) {
        String name = drawable.getClass().getName();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 21 && "android.graphics.drawable.VectorDrawable".equals(name)) {
            c(drawable);
        } else if (i2 >= 29 && i2 < 31 && "android.graphics.drawable.ColorStateListDrawable".equals(name)) {
            c(drawable);
        }
    }

    private static void c(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(f1244a);
        } else {
            drawable.setState(f1245b);
        }
        drawable.setState(state);
    }

    public static Rect d(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 29) {
            return Api18Impl.a(DrawableCompat.q(drawable));
        }
        Insets a2 = Api29Impl.a(drawable);
        return new Rect(a2.left, a2.top, a2.right, a2.bottom);
    }

    public static PorterDuff.Mode e(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
