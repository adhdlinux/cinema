package androidx.core.content.res;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public final class ResourcesCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f2514a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private static final WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> f2515b = new WeakHashMap<>(0);

    /* renamed from: c  reason: collision with root package name */
    private static final Object f2516c = new Object();

    static class Api21Impl {
        private Api21Impl() {
        }

        static Drawable a(Resources resources, int i2, Resources.Theme theme) {
            return resources.getDrawable(i2, theme);
        }

        static Drawable b(Resources resources, int i2, int i3, Resources.Theme theme) {
            return resources.getDrawableForDensity(i2, i3, theme);
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static int a(Resources resources, int i2, Resources.Theme theme) {
            return resources.getColor(i2, theme);
        }

        static ColorStateList b(Resources resources, int i2, Resources.Theme theme) {
            return resources.getColorStateList(i2, theme);
        }
    }

    private static class ColorStateListCacheEntry {

        /* renamed from: a  reason: collision with root package name */
        final ColorStateList f2517a;

        /* renamed from: b  reason: collision with root package name */
        final Configuration f2518b;

        /* renamed from: c  reason: collision with root package name */
        final int f2519c;

        ColorStateListCacheEntry(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            int i2;
            this.f2517a = colorStateList;
            this.f2518b = configuration;
            if (theme == null) {
                i2 = 0;
            } else {
                i2 = theme.hashCode();
            }
            this.f2519c = i2;
        }
    }

    private static final class ColorStateListCacheKey {

        /* renamed from: a  reason: collision with root package name */
        final Resources f2520a;

        /* renamed from: b  reason: collision with root package name */
        final Resources.Theme f2521b;

        ColorStateListCacheKey(Resources resources, Resources.Theme theme) {
            this.f2520a = resources;
            this.f2521b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ColorStateListCacheKey.class != obj.getClass()) {
                return false;
            }
            ColorStateListCacheKey colorStateListCacheKey = (ColorStateListCacheKey) obj;
            if (!this.f2520a.equals(colorStateListCacheKey.f2520a) || !ObjectsCompat.a(this.f2521b, colorStateListCacheKey.f2521b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return ObjectsCompat.b(this.f2520a, this.f2521b);
        }
    }

    public static abstract class FontCallback {
        public static Handler e(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void c(int i2, Handler handler) {
            e(handler).post(new d(this, i2));
        }

        public final void d(Typeface typeface, Handler handler) {
            e(handler).post(new c(this, typeface));
        }

        /* renamed from: h */
        public abstract void f(int i2);

        /* renamed from: i */
        public abstract void g(Typeface typeface);
    }

    public static final class ThemeCompat {

        static class Api23Impl {

            /* renamed from: a  reason: collision with root package name */
            private static final Object f2522a = new Object();

            /* renamed from: b  reason: collision with root package name */
            private static Method f2523b;

            /* renamed from: c  reason: collision with root package name */
            private static boolean f2524c;

            private Api23Impl() {
            }

            @SuppressLint({"BanUncheckedReflection"})
            static void a(Resources.Theme theme) {
                synchronized (f2522a) {
                    if (!f2524c) {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                            f2523b = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e2) {
                            Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e2);
                        }
                        f2524c = true;
                    }
                    Method method = f2523b;
                    if (method != null) {
                        try {
                            method.invoke(theme, new Object[0]);
                        } catch (IllegalAccessException | InvocationTargetException e3) {
                            Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e3);
                            f2523b = null;
                        }
                    }
                }
            }
        }

        static class Api29Impl {
            private Api29Impl() {
            }

            static void a(Resources.Theme theme) {
                theme.rebase();
            }
        }

        private ThemeCompat() {
        }

        public static void a(Resources.Theme theme) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                Api29Impl.a(theme);
            } else if (i2 >= 23) {
                Api23Impl.a(theme);
            }
        }
    }

    private ResourcesCompat() {
    }

    private static void a(ColorStateListCacheKey colorStateListCacheKey, int i2, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (f2516c) {
            WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> weakHashMap = f2515b;
            SparseArray sparseArray = weakHashMap.get(colorStateListCacheKey);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                weakHashMap.put(colorStateListCacheKey, sparseArray);
            }
            sparseArray.append(i2, new ColorStateListCacheEntry(colorStateList, colorStateListCacheKey.f2520a.getConfiguration(), theme));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0043, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.res.ColorStateList b(androidx.core.content.res.ResourcesCompat.ColorStateListCacheKey r5, int r6) {
        /*
            java.lang.Object r0 = f2516c
            monitor-enter(r0)
            java.util.WeakHashMap<androidx.core.content.res.ResourcesCompat$ColorStateListCacheKey, android.util.SparseArray<androidx.core.content.res.ResourcesCompat$ColorStateListCacheEntry>> r1 = f2515b     // Catch:{ all -> 0x0045 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x0045 }
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch:{ all -> 0x0045 }
            if (r1 == 0) goto L_0x0042
            int r2 = r1.size()     // Catch:{ all -> 0x0045 }
            if (r2 <= 0) goto L_0x0042
            java.lang.Object r2 = r1.get(r6)     // Catch:{ all -> 0x0045 }
            androidx.core.content.res.ResourcesCompat$ColorStateListCacheEntry r2 = (androidx.core.content.res.ResourcesCompat.ColorStateListCacheEntry) r2     // Catch:{ all -> 0x0045 }
            if (r2 == 0) goto L_0x0042
            android.content.res.Configuration r3 = r2.f2518b     // Catch:{ all -> 0x0045 }
            android.content.res.Resources r4 = r5.f2520a     // Catch:{ all -> 0x0045 }
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch:{ all -> 0x0045 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0045 }
            if (r3 == 0) goto L_0x003f
            android.content.res.Resources$Theme r5 = r5.f2521b     // Catch:{ all -> 0x0045 }
            if (r5 != 0) goto L_0x0031
            int r3 = r2.f2519c     // Catch:{ all -> 0x0045 }
            if (r3 == 0) goto L_0x003b
        L_0x0031:
            if (r5 == 0) goto L_0x003f
            int r3 = r2.f2519c     // Catch:{ all -> 0x0045 }
            int r5 = r5.hashCode()     // Catch:{ all -> 0x0045 }
            if (r3 != r5) goto L_0x003f
        L_0x003b:
            android.content.res.ColorStateList r5 = r2.f2517a     // Catch:{ all -> 0x0045 }
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            return r5
        L_0x003f:
            r1.remove(r6)     // Catch:{ all -> 0x0045 }
        L_0x0042:
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            r5 = 0
            return r5
        L_0x0045:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0045 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ResourcesCompat.b(androidx.core.content.res.ResourcesCompat$ColorStateListCacheKey, int):android.content.res.ColorStateList");
    }

    public static int c(Resources resources, int i2, Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.a(resources, i2, theme);
        }
        return resources.getColor(i2);
    }

    public static ColorStateList d(Resources resources, int i2, Resources.Theme theme) throws Resources.NotFoundException {
        ColorStateListCacheKey colorStateListCacheKey = new ColorStateListCacheKey(resources, theme);
        ColorStateList b2 = b(colorStateListCacheKey, i2);
        if (b2 != null) {
            return b2;
        }
        ColorStateList k2 = k(resources, i2, theme);
        if (k2 != null) {
            a(colorStateListCacheKey, i2, k2, theme);
            return k2;
        } else if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.b(resources, i2, theme);
        } else {
            return resources.getColorStateList(i2);
        }
    }

    public static Drawable e(Resources resources, int i2, Resources.Theme theme) throws Resources.NotFoundException {
        return Api21Impl.a(resources, i2, theme);
    }

    public static Drawable f(Resources resources, int i2, int i3, Resources.Theme theme) throws Resources.NotFoundException {
        return Api21Impl.b(resources, i2, i3, theme);
    }

    public static Typeface g(Context context, int i2) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return m(context, i2, new TypedValue(), 0, (FontCallback) null, (Handler) null, false, false);
    }

    public static Typeface h(Context context, int i2, TypedValue typedValue, int i3, FontCallback fontCallback) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return m(context, i2, typedValue, i3, fontCallback, (Handler) null, true, false);
    }

    public static void i(Context context, int i2, FontCallback fontCallback, Handler handler) throws Resources.NotFoundException {
        Preconditions.g(fontCallback);
        if (context.isRestricted()) {
            fontCallback.c(-4, handler);
            return;
        }
        m(context, i2, new TypedValue(), 0, fontCallback, handler, false, false);
    }

    private static TypedValue j() {
        ThreadLocal<TypedValue> threadLocal = f2514a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    private static ColorStateList k(Resources resources, int i2, Resources.Theme theme) {
        if (l(resources, i2)) {
            return null;
        }
        try {
            return ColorStateListInflaterCompat.a(resources, resources.getXml(i2), theme);
        } catch (Exception e2) {
            Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e2);
            return null;
        }
    }

    private static boolean l(Resources resources, int i2) {
        TypedValue j2 = j();
        resources.getValue(i2, j2, true);
        int i3 = j2.type;
        if (i3 < 28 || i3 > 31) {
            return false;
        }
        return true;
    }

    private static Typeface m(Context context, int i2, TypedValue typedValue, int i3, FontCallback fontCallback, Handler handler, boolean z2, boolean z3) {
        Resources resources = context.getResources();
        int i4 = i2;
        resources.getValue(i2, typedValue, true);
        Typeface n2 = n(context, resources, typedValue, i2, i3, fontCallback, handler, z2, z3);
        if (n2 != null || fontCallback != null || z3) {
            return n2;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i2) + " could not be retrieved.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Typeface n(android.content.Context r17, android.content.res.Resources r18, android.util.TypedValue r19, int r20, int r21, androidx.core.content.res.ResourcesCompat.FontCallback r22, android.os.Handler r23, boolean r24, boolean r25) {
        /*
            r0 = r18
            r1 = r19
            r4 = r20
            r11 = r22
            r12 = r23
            java.lang.String r13 = "ResourcesCompat"
            java.lang.CharSequence r2 = r1.string
            if (r2 == 0) goto L_0x00bb
            java.lang.String r14 = r2.toString()
            java.lang.String r2 = "res/"
            boolean r2 = r14.startsWith(r2)
            r15 = -3
            r16 = 0
            if (r2 != 0) goto L_0x0025
            if (r11 == 0) goto L_0x0024
            r11.c(r15, r12)
        L_0x0024:
            return r16
        L_0x0025:
            int r2 = r1.assetCookie
            r7 = r21
            android.graphics.Typeface r2 = androidx.core.graphics.TypefaceCompat.f(r0, r4, r14, r2, r7)
            if (r2 == 0) goto L_0x0035
            if (r11 == 0) goto L_0x0034
            r11.d(r2, r12)
        L_0x0034:
            return r2
        L_0x0035:
            if (r25 == 0) goto L_0x0038
            return r16
        L_0x0038:
            java.lang.String r2 = r14.toLowerCase()     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
            java.lang.String r3 = ".xml"
            boolean r2 = r2.endsWith(r3)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
            if (r2 == 0) goto L_0x006f
            android.content.res.XmlResourceParser r2 = r0.getXml(r4)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
            androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry r2 = androidx.core.content.res.FontResourcesParserCompat.b(r2, r0)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
            if (r2 != 0) goto L_0x0059
            java.lang.String r0 = "Failed to find font-family tag"
            android.util.Log.e(r13, r0)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
            if (r11 == 0) goto L_0x0058
            r11.c(r15, r12)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
        L_0x0058:
            return r16
        L_0x0059:
            int r6 = r1.assetCookie     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
            r1 = r17
            r3 = r18
            r4 = r20
            r5 = r14
            r7 = r21
            r8 = r22
            r9 = r23
            r10 = r24
            android.graphics.Typeface r0 = androidx.core.graphics.TypefaceCompat.c(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
            return r0
        L_0x006f:
            int r5 = r1.assetCookie     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
            r1 = r17
            r2 = r18
            r3 = r20
            r4 = r14
            r6 = r21
            android.graphics.Typeface r0 = androidx.core.graphics.TypefaceCompat.d(r1, r2, r3, r4, r5, r6)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
            if (r11 == 0) goto L_0x0089
            if (r0 == 0) goto L_0x0086
            r11.d(r0, r12)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
            goto L_0x0089
        L_0x0086:
            r11.c(r15, r12)     // Catch:{ XmlPullParserException -> 0x00a0, IOException -> 0x008a }
        L_0x0089:
            return r0
        L_0x008a:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to read xml resource "
            r1.append(r2)
            r1.append(r14)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r13, r1, r0)
            goto L_0x00b5
        L_0x00a0:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to parse xml resource "
            r1.append(r2)
            r1.append(r14)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r13, r1, r0)
        L_0x00b5:
            if (r11 == 0) goto L_0x00ba
            r11.c(r15, r12)
        L_0x00ba:
            return r16
        L_0x00bb:
            android.content.res.Resources$NotFoundException r2 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Resource \""
            r3.append(r5)
            java.lang.String r0 = r0.getResourceName(r4)
            r3.append(r0)
            java.lang.String r0 = "\" ("
            r3.append(r0)
            java.lang.String r0 = java.lang.Integer.toHexString(r20)
            r3.append(r0)
            java.lang.String r0 = ") is not a Font: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ResourcesCompat.n(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, androidx.core.content.res.ResourcesCompat$FontCallback, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }
}
