package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.graphics.ColorUtils;

public final class AppCompatDrawableManager {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final PorterDuff.Mode f1122b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c  reason: collision with root package name */
    private static AppCompatDrawableManager f1123c;

    /* renamed from: a  reason: collision with root package name */
    private ResourceManagerInternal f1124a;

    public static synchronized AppCompatDrawableManager b() {
        AppCompatDrawableManager appCompatDrawableManager;
        synchronized (AppCompatDrawableManager.class) {
            if (f1123c == null) {
                h();
            }
            appCompatDrawableManager = f1123c;
        }
        return appCompatDrawableManager;
    }

    public static synchronized PorterDuffColorFilter e(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter l2;
        synchronized (AppCompatDrawableManager.class) {
            l2 = ResourceManagerInternal.l(i2, mode);
        }
        return l2;
    }

    public static synchronized void h() {
        synchronized (AppCompatDrawableManager.class) {
            if (f1123c == null) {
                AppCompatDrawableManager appCompatDrawableManager = new AppCompatDrawableManager();
                f1123c = appCompatDrawableManager;
                appCompatDrawableManager.f1124a = ResourceManagerInternal.h();
                f1123c.f1124a.u(new ResourceManagerInternal.ResourceManagerHooks() {

                    /* renamed from: a  reason: collision with root package name */
                    private final int[] f1125a = {R$drawable.R, R$drawable.P, R$drawable.f140a};

                    /* renamed from: b  reason: collision with root package name */
                    private final int[] f1126b = {R$drawable.f154o, R$drawable.B, R$drawable.f159t, R$drawable.f155p, R$drawable.f156q, R$drawable.f158s, R$drawable.f157r};

                    /* renamed from: c  reason: collision with root package name */
                    private final int[] f1127c = {R$drawable.O, R$drawable.Q, R$drawable.f150k, R$drawable.K, R$drawable.L, R$drawable.M, R$drawable.N};

                    /* renamed from: d  reason: collision with root package name */
                    private final int[] f1128d = {R$drawable.f162w, R$drawable.f148i, R$drawable.f161v};

                    /* renamed from: e  reason: collision with root package name */
                    private final int[] f1129e = {R$drawable.J, R$drawable.S};

                    /* renamed from: f  reason: collision with root package name */
                    private final int[] f1130f = {R$drawable.f142c, R$drawable.f146g, R$drawable.f143d, R$drawable.f147h};

                    private boolean f(int[] iArr, int i2) {
                        for (int i3 : iArr) {
                            if (i3 == i2) {
                                return true;
                            }
                        }
                        return false;
                    }

                    private ColorStateList g(Context context) {
                        return h(context, 0);
                    }

                    private ColorStateList h(Context context, int i2) {
                        int c2 = ThemeUtils.c(context, R$attr.f112w);
                        int b2 = ThemeUtils.b(context, R$attr.f110u);
                        return new ColorStateList(new int[][]{ThemeUtils.f1448b, ThemeUtils.f1451e, ThemeUtils.f1449c, ThemeUtils.f1455i}, new int[]{b2, ColorUtils.k(c2, i2), ColorUtils.k(c2, i2), i2});
                    }

                    private ColorStateList i(Context context) {
                        return h(context, ThemeUtils.c(context, R$attr.f109t));
                    }

                    private ColorStateList j(Context context) {
                        return h(context, ThemeUtils.c(context, R$attr.f110u));
                    }

                    private ColorStateList k(Context context) {
                        int[][] iArr = new int[3][];
                        int[] iArr2 = new int[3];
                        int i2 = R$attr.A;
                        ColorStateList e2 = ThemeUtils.e(context, i2);
                        if (e2 == null || !e2.isStateful()) {
                            iArr[0] = ThemeUtils.f1448b;
                            iArr2[0] = ThemeUtils.b(context, i2);
                            iArr[1] = ThemeUtils.f1452f;
                            iArr2[1] = ThemeUtils.c(context, R$attr.f111v);
                            iArr[2] = ThemeUtils.f1455i;
                            iArr2[2] = ThemeUtils.c(context, i2);
                        } else {
                            int[] iArr3 = ThemeUtils.f1448b;
                            iArr[0] = iArr3;
                            iArr2[0] = e2.getColorForState(iArr3, 0);
                            iArr[1] = ThemeUtils.f1452f;
                            iArr2[1] = ThemeUtils.c(context, R$attr.f111v);
                            iArr[2] = ThemeUtils.f1455i;
                            iArr2[2] = e2.getDefaultColor();
                        }
                        return new ColorStateList(iArr, iArr2);
                    }

                    private LayerDrawable l(ResourceManagerInternal resourceManagerInternal, Context context, int i2) {
                        BitmapDrawable bitmapDrawable;
                        BitmapDrawable bitmapDrawable2;
                        BitmapDrawable bitmapDrawable3;
                        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i2);
                        Drawable j2 = resourceManagerInternal.j(context, R$drawable.F);
                        Drawable j3 = resourceManagerInternal.j(context, R$drawable.G);
                        if ((j2 instanceof BitmapDrawable) && j2.getIntrinsicWidth() == dimensionPixelSize && j2.getIntrinsicHeight() == dimensionPixelSize) {
                            bitmapDrawable2 = (BitmapDrawable) j2;
                            bitmapDrawable = new BitmapDrawable(bitmapDrawable2.getBitmap());
                        } else {
                            Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                            Canvas canvas = new Canvas(createBitmap);
                            j2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                            j2.draw(canvas);
                            bitmapDrawable2 = new BitmapDrawable(createBitmap);
                            bitmapDrawable = new BitmapDrawable(createBitmap);
                        }
                        bitmapDrawable.setTileModeX(Shader.TileMode.REPEAT);
                        if ((j3 instanceof BitmapDrawable) && j3.getIntrinsicWidth() == dimensionPixelSize && j3.getIntrinsicHeight() == dimensionPixelSize) {
                            bitmapDrawable3 = (BitmapDrawable) j3;
                        } else {
                            Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                            Canvas canvas2 = new Canvas(createBitmap2);
                            j3.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                            j3.draw(canvas2);
                            bitmapDrawable3 = new BitmapDrawable(createBitmap2);
                        }
                        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable2, bitmapDrawable3, bitmapDrawable});
                        layerDrawable.setId(0, 16908288);
                        layerDrawable.setId(1, 16908303);
                        layerDrawable.setId(2, 16908301);
                        return layerDrawable;
                    }

                    private void m(Drawable drawable, int i2, PorterDuff.Mode mode) {
                        if (DrawableUtils.a(drawable)) {
                            drawable = drawable.mutate();
                        }
                        if (mode == null) {
                            mode = AppCompatDrawableManager.f1122b;
                        }
                        drawable.setColorFilter(AppCompatDrawableManager.e(i2, mode));
                    }

                    public Drawable a(ResourceManagerInternal resourceManagerInternal, Context context, int i2) {
                        if (i2 == R$drawable.f149j) {
                            return new LayerDrawable(new Drawable[]{resourceManagerInternal.j(context, R$drawable.f148i), resourceManagerInternal.j(context, R$drawable.f150k)});
                        } else if (i2 == R$drawable.f164y) {
                            return l(resourceManagerInternal, context, R$dimen.f133i);
                        } else {
                            if (i2 == R$drawable.f163x) {
                                return l(resourceManagerInternal, context, R$dimen.f134j);
                            }
                            if (i2 == R$drawable.f165z) {
                                return l(resourceManagerInternal, context, R$dimen.f135k);
                            }
                            return null;
                        }
                    }

                    public ColorStateList b(Context context, int i2) {
                        if (i2 == R$drawable.f152m) {
                            return AppCompatResources.a(context, R$color.f121e);
                        }
                        if (i2 == R$drawable.I) {
                            return AppCompatResources.a(context, R$color.f124h);
                        }
                        if (i2 == R$drawable.H) {
                            return k(context);
                        }
                        if (i2 == R$drawable.f145f) {
                            return j(context);
                        }
                        if (i2 == R$drawable.f141b) {
                            return g(context);
                        }
                        if (i2 == R$drawable.f144e) {
                            return i(context);
                        }
                        if (i2 == R$drawable.D || i2 == R$drawable.E) {
                            return AppCompatResources.a(context, R$color.f123g);
                        }
                        if (f(this.f1126b, i2)) {
                            return ThemeUtils.e(context, R$attr.f113x);
                        }
                        if (f(this.f1129e, i2)) {
                            return AppCompatResources.a(context, R$color.f120d);
                        }
                        if (f(this.f1130f, i2)) {
                            return AppCompatResources.a(context, R$color.f119c);
                        }
                        if (i2 == R$drawable.A) {
                            return AppCompatResources.a(context, R$color.f122f);
                        }
                        return null;
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:19:0x0052  */
                    /* JADX WARNING: Removed duplicated region for block: B:26:0x006d A[RETURN] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public boolean c(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
                        /*
                            r6 = this;
                            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.AppCompatDrawableManager.f1122b
                            int[] r1 = r6.f1125a
                            boolean r1 = r6.f(r1, r8)
                            r2 = 1
                            r3 = 0
                            r4 = -1
                            if (r1 == 0) goto L_0x0015
                            int r8 = androidx.appcompat.R$attr.f113x
                        L_0x0011:
                            r1 = r0
                        L_0x0012:
                            r0 = -1
                            r5 = 1
                            goto L_0x0050
                        L_0x0015:
                            int[] r1 = r6.f1127c
                            boolean r1 = r6.f(r1, r8)
                            if (r1 == 0) goto L_0x0020
                            int r8 = androidx.appcompat.R$attr.f111v
                            goto L_0x0011
                        L_0x0020:
                            int[] r1 = r6.f1128d
                            boolean r1 = r6.f(r1, r8)
                            r5 = 16842801(0x1010031, float:2.3693695E-38)
                            if (r1 == 0) goto L_0x0032
                            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
                        L_0x002d:
                            r1 = r0
                            r8 = 16842801(0x1010031, float:2.3693695E-38)
                            goto L_0x0012
                        L_0x0032:
                            int r1 = androidx.appcompat.R$drawable.f160u
                            if (r8 != r1) goto L_0x0047
                            r8 = 1109603123(0x42233333, float:40.8)
                            int r8 = java.lang.Math.round(r8)
                            r1 = 16842800(0x1010030, float:2.3693693E-38)
                            r1 = r0
                            r5 = 1
                            r0 = r8
                            r8 = 16842800(0x1010030, float:2.3693693E-38)
                            goto L_0x0050
                        L_0x0047:
                            int r1 = androidx.appcompat.R$drawable.f151l
                            if (r8 != r1) goto L_0x004c
                            goto L_0x002d
                        L_0x004c:
                            r1 = r0
                            r8 = 0
                            r0 = -1
                            r5 = 0
                        L_0x0050:
                            if (r5 == 0) goto L_0x006d
                            boolean r3 = androidx.appcompat.widget.DrawableUtils.a(r9)
                            if (r3 == 0) goto L_0x005c
                            android.graphics.drawable.Drawable r9 = r9.mutate()
                        L_0x005c:
                            int r7 = androidx.appcompat.widget.ThemeUtils.c(r7, r8)
                            android.graphics.PorterDuffColorFilter r7 = androidx.appcompat.widget.AppCompatDrawableManager.e(r7, r1)
                            r9.setColorFilter(r7)
                            if (r0 == r4) goto L_0x006c
                            r9.setAlpha(r0)
                        L_0x006c:
                            return r2
                        L_0x006d:
                            return r3
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatDrawableManager.AnonymousClass1.c(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
                    }

                    public PorterDuff.Mode d(int i2) {
                        if (i2 == R$drawable.H) {
                            return PorterDuff.Mode.MULTIPLY;
                        }
                        return null;
                    }

                    public boolean e(Context context, int i2, Drawable drawable) {
                        if (i2 == R$drawable.C) {
                            LayerDrawable layerDrawable = (LayerDrawable) drawable;
                            Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908288);
                            int i3 = R$attr.f113x;
                            m(findDrawableByLayerId, ThemeUtils.c(context, i3), AppCompatDrawableManager.f1122b);
                            m(layerDrawable.findDrawableByLayerId(16908303), ThemeUtils.c(context, i3), AppCompatDrawableManager.f1122b);
                            m(layerDrawable.findDrawableByLayerId(16908301), ThemeUtils.c(context, R$attr.f111v), AppCompatDrawableManager.f1122b);
                            return true;
                        } else if (i2 != R$drawable.f164y && i2 != R$drawable.f163x && i2 != R$drawable.f165z) {
                            return false;
                        } else {
                            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                            m(layerDrawable2.findDrawableByLayerId(16908288), ThemeUtils.b(context, R$attr.f113x), AppCompatDrawableManager.f1122b);
                            Drawable findDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(16908303);
                            int i4 = R$attr.f111v;
                            m(findDrawableByLayerId2, ThemeUtils.c(context, i4), AppCompatDrawableManager.f1122b);
                            m(layerDrawable2.findDrawableByLayerId(16908301), ThemeUtils.c(context, i4), AppCompatDrawableManager.f1122b);
                            return true;
                        }
                    }
                });
            }
        }
    }

    static void i(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        ResourceManagerInternal.w(drawable, tintInfo, iArr);
    }

    public synchronized Drawable c(Context context, int i2) {
        return this.f1124a.j(context, i2);
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable d(Context context, int i2, boolean z2) {
        return this.f1124a.k(context, i2, z2);
    }

    /* access modifiers changed from: package-private */
    public synchronized ColorStateList f(Context context, int i2) {
        return this.f1124a.m(context, i2);
    }

    public synchronized void g(Context context) {
        this.f1124a.s(context);
    }
}
