package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.appcompat.resources.Compatibility$Api21Impl;
import androidx.appcompat.resources.R$drawable;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

public final class ResourceManagerInternal {

    /* renamed from: h  reason: collision with root package name */
    private static final PorterDuff.Mode f1337h = PorterDuff.Mode.SRC_IN;

    /* renamed from: i  reason: collision with root package name */
    private static ResourceManagerInternal f1338i;

    /* renamed from: j  reason: collision with root package name */
    private static final ColorFilterLruCache f1339j = new ColorFilterLruCache(6);

    /* renamed from: a  reason: collision with root package name */
    private WeakHashMap<Context, SparseArrayCompat<ColorStateList>> f1340a;

    /* renamed from: b  reason: collision with root package name */
    private SimpleArrayMap<String, InflateDelegate> f1341b;

    /* renamed from: c  reason: collision with root package name */
    private SparseArrayCompat<String> f1342c;

    /* renamed from: d  reason: collision with root package name */
    private final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> f1343d = new WeakHashMap<>(0);

    /* renamed from: e  reason: collision with root package name */
    private TypedValue f1344e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1345f;

    /* renamed from: g  reason: collision with root package name */
    private ResourceManagerHooks f1346g;

    static class AsldcInflateDelegate implements InflateDelegate {
        AsldcInflateDelegate() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return AnimatedStateListDrawableCompat.m(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e2);
                return null;
            }
        }
    }

    private static class AvdcInflateDelegate implements InflateDelegate {
        AvdcInflateDelegate() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return AnimatedVectorDrawableCompat.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e2);
                return null;
            }
        }
    }

    private static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
        public ColorFilterLruCache(int i2) {
            super(i2);
        }

        private static int a(int i2, PorterDuff.Mode mode) {
            return ((i2 + 31) * 31) + mode.hashCode();
        }

        /* access modifiers changed from: package-private */
        public PorterDuffColorFilter b(int i2, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(a(i2, mode)));
        }

        /* access modifiers changed from: package-private */
        public PorterDuffColorFilter c(int i2, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(a(i2, mode)), porterDuffColorFilter);
        }
    }

    static class DrawableDelegate implements InflateDelegate {
        DrawableDelegate() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            String classAttribute = attributeSet.getClassAttribute();
            if (classAttribute != null) {
                try {
                    Drawable drawable = (Drawable) DrawableDelegate.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    Compatibility$Api21Impl.c(drawable, context.getResources(), xmlPullParser, attributeSet, theme);
                    return drawable;
                } catch (Exception e2) {
                    Log.e("DrawableDelegate", "Exception while inflating <drawable>", e2);
                }
            }
            return null;
        }
    }

    private interface InflateDelegate {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    public interface ResourceManagerHooks {
        Drawable a(ResourceManagerInternal resourceManagerInternal, Context context, int i2);

        ColorStateList b(Context context, int i2);

        boolean c(Context context, int i2, Drawable drawable);

        PorterDuff.Mode d(int i2);

        boolean e(Context context, int i2, Drawable drawable);
    }

    private static class VdcInflateDelegate implements InflateDelegate {
        VdcInflateDelegate() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return VectorDrawableCompat.c(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e2);
                return null;
            }
        }
    }

    private void a(String str, InflateDelegate inflateDelegate) {
        if (this.f1341b == null) {
            this.f1341b = new SimpleArrayMap<>();
        }
        this.f1341b.put(str, inflateDelegate);
    }

    private synchronized boolean b(Context context, long j2, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        LongSparseArray longSparseArray = this.f1343d.get(context);
        if (longSparseArray == null) {
            longSparseArray = new LongSparseArray();
            this.f1343d.put(context, longSparseArray);
        }
        longSparseArray.k(j2, new WeakReference(constantState));
        return true;
    }

    private void c(Context context, int i2, ColorStateList colorStateList) {
        if (this.f1340a == null) {
            this.f1340a = new WeakHashMap<>();
        }
        SparseArrayCompat sparseArrayCompat = this.f1340a.get(context);
        if (sparseArrayCompat == null) {
            sparseArrayCompat = new SparseArrayCompat();
            this.f1340a.put(context, sparseArrayCompat);
        }
        sparseArrayCompat.a(i2, colorStateList);
    }

    private void d(Context context) {
        if (!this.f1345f) {
            this.f1345f = true;
            Drawable j2 = j(context, R$drawable.f643a);
            if (j2 == null || !q(j2)) {
                this.f1345f = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    private static long e(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private Drawable f(Context context, int i2) {
        Drawable drawable;
        if (this.f1344e == null) {
            this.f1344e = new TypedValue();
        }
        TypedValue typedValue = this.f1344e;
        context.getResources().getValue(i2, typedValue, true);
        long e2 = e(typedValue);
        Drawable i3 = i(context, e2);
        if (i3 != null) {
            return i3;
        }
        ResourceManagerHooks resourceManagerHooks = this.f1346g;
        if (resourceManagerHooks == null) {
            drawable = null;
        } else {
            drawable = resourceManagerHooks.a(this, context, i2);
        }
        if (drawable != null) {
            drawable.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, e2, drawable);
        }
        return drawable;
    }

    private static PorterDuffColorFilter g(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return l(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized ResourceManagerInternal h() {
        ResourceManagerInternal resourceManagerInternal;
        synchronized (ResourceManagerInternal.class) {
            if (f1338i == null) {
                ResourceManagerInternal resourceManagerInternal2 = new ResourceManagerInternal();
                f1338i = resourceManagerInternal2;
                p(resourceManagerInternal2);
            }
            resourceManagerInternal = f1338i;
        }
        return resourceManagerInternal;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized android.graphics.drawable.Drawable i(android.content.Context r4, long r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.WeakHashMap<android.content.Context, androidx.collection.LongSparseArray<java.lang.ref.WeakReference<android.graphics.drawable.Drawable$ConstantState>>> r0 = r3.f1343d     // Catch:{ all -> 0x002d }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x002d }
            androidx.collection.LongSparseArray r0 = (androidx.collection.LongSparseArray) r0     // Catch:{ all -> 0x002d }
            r1 = 0
            if (r0 != 0) goto L_0x000e
            monitor-exit(r3)
            return r1
        L_0x000e:
            java.lang.Object r2 = r0.f(r5)     // Catch:{ all -> 0x002d }
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x002b
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x002d }
            android.graphics.drawable.Drawable$ConstantState r2 = (android.graphics.drawable.Drawable.ConstantState) r2     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x0028
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x002d }
            android.graphics.drawable.Drawable r4 = r2.newDrawable(r4)     // Catch:{ all -> 0x002d }
            monitor-exit(r3)
            return r4
        L_0x0028:
            r0.l(r5)     // Catch:{ all -> 0x002d }
        L_0x002b:
            monitor-exit(r3)
            return r1
        L_0x002d:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ResourceManagerInternal.i(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    public static synchronized PorterDuffColorFilter l(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter b2;
        synchronized (ResourceManagerInternal.class) {
            ColorFilterLruCache colorFilterLruCache = f1339j;
            b2 = colorFilterLruCache.b(i2, mode);
            if (b2 == null) {
                b2 = new PorterDuffColorFilter(i2, mode);
                colorFilterLruCache.c(i2, mode, b2);
            }
        }
        return b2;
    }

    private ColorStateList n(Context context, int i2) {
        SparseArrayCompat sparseArrayCompat;
        WeakHashMap<Context, SparseArrayCompat<ColorStateList>> weakHashMap = this.f1340a;
        if (weakHashMap == null || (sparseArrayCompat = weakHashMap.get(context)) == null) {
            return null;
        }
        return (ColorStateList) sparseArrayCompat.e(i2);
    }

    private static void p(ResourceManagerInternal resourceManagerInternal) {
        if (Build.VERSION.SDK_INT < 24) {
            resourceManagerInternal.a("vector", new VdcInflateDelegate());
            resourceManagerInternal.a("animated-vector", new AvdcInflateDelegate());
            resourceManagerInternal.a("animated-selector", new AsldcInflateDelegate());
            resourceManagerInternal.a("drawable", new DrawableDelegate());
        }
    }

    private static boolean q(Drawable drawable) {
        if ((drawable instanceof VectorDrawableCompat) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0073 A[Catch:{ Exception -> 0x00a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009a A[Catch:{ Exception -> 0x00a2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable r(android.content.Context r11, int r12) {
        /*
            r10 = this;
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.appcompat.widget.ResourceManagerInternal$InflateDelegate> r0 = r10.f1341b
            r1 = 0
            if (r0 == 0) goto L_0x00b2
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00b2
            androidx.collection.SparseArrayCompat<java.lang.String> r0 = r10.f1342c
            java.lang.String r2 = "appcompat_skip_skip"
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r0.e(r12)
            java.lang.String r0 = (java.lang.String) r0
            boolean r3 = r2.equals(r0)
            if (r3 != 0) goto L_0x0027
            if (r0 == 0) goto L_0x002f
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.appcompat.widget.ResourceManagerInternal$InflateDelegate> r3 = r10.f1341b
            java.lang.Object r0 = r3.get(r0)
            if (r0 != 0) goto L_0x002f
        L_0x0027:
            return r1
        L_0x0028:
            androidx.collection.SparseArrayCompat r0 = new androidx.collection.SparseArrayCompat
            r0.<init>()
            r10.f1342c = r0
        L_0x002f:
            android.util.TypedValue r0 = r10.f1344e
            if (r0 != 0) goto L_0x003a
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            r10.f1344e = r0
        L_0x003a:
            android.util.TypedValue r0 = r10.f1344e
            android.content.res.Resources r1 = r11.getResources()
            r3 = 1
            r1.getValue(r12, r0, r3)
            long r4 = e(r0)
            android.graphics.drawable.Drawable r6 = r10.i(r11, r4)
            if (r6 == 0) goto L_0x004f
            return r6
        L_0x004f:
            java.lang.CharSequence r7 = r0.string
            if (r7 == 0) goto L_0x00aa
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = ".xml"
            boolean r7 = r7.endsWith(r8)
            if (r7 == 0) goto L_0x00aa
            android.content.res.XmlResourceParser r1 = r1.getXml(r12)     // Catch:{ Exception -> 0x00a2 }
            android.util.AttributeSet r7 = android.util.Xml.asAttributeSet(r1)     // Catch:{ Exception -> 0x00a2 }
        L_0x0067:
            int r8 = r1.next()     // Catch:{ Exception -> 0x00a2 }
            r9 = 2
            if (r8 == r9) goto L_0x0071
            if (r8 == r3) goto L_0x0071
            goto L_0x0067
        L_0x0071:
            if (r8 != r9) goto L_0x009a
            java.lang.String r3 = r1.getName()     // Catch:{ Exception -> 0x00a2 }
            androidx.collection.SparseArrayCompat<java.lang.String> r8 = r10.f1342c     // Catch:{ Exception -> 0x00a2 }
            r8.a(r12, r3)     // Catch:{ Exception -> 0x00a2 }
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.appcompat.widget.ResourceManagerInternal$InflateDelegate> r8 = r10.f1341b     // Catch:{ Exception -> 0x00a2 }
            java.lang.Object r3 = r8.get(r3)     // Catch:{ Exception -> 0x00a2 }
            androidx.appcompat.widget.ResourceManagerInternal$InflateDelegate r3 = (androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate) r3     // Catch:{ Exception -> 0x00a2 }
            if (r3 == 0) goto L_0x008f
            android.content.res.Resources$Theme r8 = r11.getTheme()     // Catch:{ Exception -> 0x00a2 }
            android.graphics.drawable.Drawable r1 = r3.a(r11, r1, r7, r8)     // Catch:{ Exception -> 0x00a2 }
            r6 = r1
        L_0x008f:
            if (r6 == 0) goto L_0x00aa
            int r0 = r0.changingConfigurations     // Catch:{ Exception -> 0x00a2 }
            r6.setChangingConfigurations(r0)     // Catch:{ Exception -> 0x00a2 }
            r10.b(r11, r4, r6)     // Catch:{ Exception -> 0x00a2 }
            goto L_0x00aa
        L_0x009a:
            org.xmlpull.v1.XmlPullParserException r11 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x00a2 }
            java.lang.String r0 = "No start tag found"
            r11.<init>(r0)     // Catch:{ Exception -> 0x00a2 }
            throw r11     // Catch:{ Exception -> 0x00a2 }
        L_0x00a2:
            r11 = move-exception
            java.lang.String r0 = "ResourceManagerInternal"
            java.lang.String r1 = "Exception while inflating drawable"
            android.util.Log.e(r0, r1, r11)
        L_0x00aa:
            if (r6 != 0) goto L_0x00b1
            androidx.collection.SparseArrayCompat<java.lang.String> r11 = r10.f1342c
            r11.a(r12, r2)
        L_0x00b1:
            return r6
        L_0x00b2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ResourceManagerInternal.r(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    private Drawable v(Context context, int i2, boolean z2, Drawable drawable) {
        ColorStateList m2 = m(context, i2);
        if (m2 != null) {
            if (DrawableUtils.a(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable r2 = DrawableCompat.r(drawable);
            DrawableCompat.o(r2, m2);
            PorterDuff.Mode o2 = o(i2);
            if (o2 == null) {
                return r2;
            }
            DrawableCompat.p(r2, o2);
            return r2;
        }
        ResourceManagerHooks resourceManagerHooks = this.f1346g;
        if ((resourceManagerHooks == null || !resourceManagerHooks.e(context, i2, drawable)) && !x(context, i2, drawable) && z2) {
            return null;
        }
        return drawable;
    }

    static void w(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        ColorStateList colorStateList;
        PorterDuff.Mode mode;
        boolean z2;
        int[] state = drawable.getState();
        if (DrawableUtils.a(drawable)) {
            if (drawable.mutate() == drawable) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
                return;
            }
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z3 = tintInfo.f1464d;
        if (z3 || tintInfo.f1463c) {
            if (z3) {
                colorStateList = tintInfo.f1461a;
            } else {
                colorStateList = null;
            }
            if (tintInfo.f1463c) {
                mode = tintInfo.f1462b;
            } else {
                mode = f1337h;
            }
            drawable.setColorFilter(g(colorStateList, mode, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public synchronized Drawable j(Context context, int i2) {
        return k(context, i2, false);
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable k(Context context, int i2, boolean z2) {
        Drawable r2;
        d(context);
        r2 = r(context, i2);
        if (r2 == null) {
            r2 = f(context, i2);
        }
        if (r2 == null) {
            r2 = ContextCompat.getDrawable(context, i2);
        }
        if (r2 != null) {
            r2 = v(context, i2, z2, r2);
        }
        if (r2 != null) {
            DrawableUtils.b(r2);
        }
        return r2;
    }

    /* access modifiers changed from: package-private */
    public synchronized ColorStateList m(Context context, int i2) {
        ColorStateList n2;
        n2 = n(context, i2);
        if (n2 == null) {
            ResourceManagerHooks resourceManagerHooks = this.f1346g;
            if (resourceManagerHooks == null) {
                n2 = null;
            } else {
                n2 = resourceManagerHooks.b(context, i2);
            }
            if (n2 != null) {
                c(context, i2, n2);
            }
        }
        return n2;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode o(int i2) {
        ResourceManagerHooks resourceManagerHooks = this.f1346g;
        if (resourceManagerHooks == null) {
            return null;
        }
        return resourceManagerHooks.d(i2);
    }

    public synchronized void s(Context context) {
        LongSparseArray longSparseArray = this.f1343d.get(context);
        if (longSparseArray != null) {
            longSparseArray.b();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable t(Context context, VectorEnabledTintResources vectorEnabledTintResources, int i2) {
        Drawable r2 = r(context, i2);
        if (r2 == null) {
            r2 = vectorEnabledTintResources.a(i2);
        }
        if (r2 == null) {
            return null;
        }
        return v(context, i2, false, r2);
    }

    public synchronized void u(ResourceManagerHooks resourceManagerHooks) {
        this.f1346g = resourceManagerHooks;
    }

    /* access modifiers changed from: package-private */
    public boolean x(Context context, int i2, Drawable drawable) {
        ResourceManagerHooks resourceManagerHooks = this.f1346g;
        return resourceManagerHooks != null && resourceManagerHooks.c(context, i2, drawable);
    }
}
