package com.facebook.ads.internal.r;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.facebook.ads.internal.q.a.t;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.q.a.y;
import com.facebook.ads.internal.q.a.z;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;
import org.json.JSONObject;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f20764a = "a";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final View f20765b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final int f20766c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final int f20767d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final WeakReference<C0035a> f20768e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final Handler f20769f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final boolean f20770g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Runnable f20771h;

    /* renamed from: i  reason: collision with root package name */
    private int f20772i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public int f20773j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public boolean f20774k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public b f20775l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public Map<String, Integer> f20776m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public long f20777n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public int f20778o;

    /* renamed from: com.facebook.ads.internal.r.a$a  reason: collision with other inner class name */
    public static abstract class C0035a {
        public abstract void a();

        public void b() {
        }
    }

    private static final class b extends y<a> {
        b(a aVar) {
            super(aVar);
        }

        public void run() {
            a aVar = (a) a();
            if (aVar != null) {
                View a2 = aVar.f20765b;
                C0035a aVar2 = (C0035a) aVar.f20768e.get();
                if (a2 != null && aVar2 != null) {
                    b a3 = a.a(a2, aVar.f20766c);
                    int i2 = 0;
                    if (a3.a()) {
                        a.d(aVar);
                    } else {
                        int unused = aVar.f20778o = 0;
                    }
                    boolean z2 = aVar.f20778o > aVar.f20767d;
                    boolean z3 = aVar.f20775l != null && aVar.f20775l.a();
                    if (z2 || !a3.a()) {
                        b unused2 = aVar.f20775l = a3;
                    }
                    String valueOf = String.valueOf(a3.b());
                    synchronized (aVar) {
                        if (aVar.f20776m.containsKey(valueOf)) {
                            i2 = ((Integer) aVar.f20776m.get(valueOf)).intValue();
                        }
                        aVar.f20776m.put(valueOf, Integer.valueOf(i2 + 1));
                    }
                    if (z2 && !z3) {
                        long unused3 = aVar.f20777n = System.currentTimeMillis();
                        aVar2.a();
                        if (!aVar.f20770g) {
                            return;
                        }
                    } else if (!z2 && z3) {
                        aVar2.b();
                    }
                    if (!aVar.f20774k && aVar.f20771h != null) {
                        aVar.f20769f.postDelayed(aVar.f20771h, (long) aVar.f20773j);
                    }
                }
            }
        }
    }

    public a(View view, int i2, int i3, boolean z2, C0035a aVar) {
        this.f20769f = new Handler();
        this.f20772i = 0;
        this.f20773j = 1000;
        this.f20774k = true;
        this.f20775l = new b(c.UNKNOWN);
        this.f20776m = new HashMap();
        this.f20777n = 0;
        this.f20778o = 0;
        this.f20765b = view;
        if (view.getId() == -1) {
            x.a(view);
        }
        this.f20766c = i2;
        this.f20768e = new WeakReference<>(aVar);
        this.f20770g = z2;
        this.f20767d = i3 < 0 ? 0 : i3;
    }

    public a(View view, int i2, C0035a aVar) {
        this(view, i2, 0, false, aVar);
    }

    public a(View view, int i2, boolean z2, C0035a aVar) {
        this(view, i2, 0, z2, aVar);
    }

    static float a(View view) {
        float alpha = view.getAlpha();
        while (view.getParent() instanceof ViewGroup) {
            view = (View) view.getParent();
            float alpha2 = view.getAlpha();
            if (alpha2 < 0.0f) {
                alpha2 = 0.0f;
            }
            if (alpha2 > 1.0f) {
                alpha2 = 1.0f;
            }
            alpha *= alpha2;
        }
        return alpha;
    }

    public static int a(int i2, View view) {
        int width = view.getWidth() * view.getHeight();
        float f2 = 100.0f;
        if (width > 0) {
            f2 = 100.0f / ((float) width);
        }
        return (int) Math.max((double) i2, Math.ceil((double) f2));
    }

    private static int a(Vector<Rect> vector) {
        int size = vector.size();
        int i2 = size * 2;
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        int[] iArr3 = new int[2];
        iArr3[1] = i2;
        iArr3[0] = i2;
        boolean[][] zArr = (boolean[][]) Array.newInstance(Boolean.TYPE, iArr3);
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < size) {
            Rect elementAt = vector.elementAt(i3);
            int i6 = i4 + 1;
            iArr[i4] = elementAt.left;
            int i7 = i5 + 1;
            iArr2[i5] = elementAt.bottom;
            int i8 = i6 + 1;
            iArr[i6] = elementAt.right;
            int i9 = i7 + 1;
            iArr2[i7] = elementAt.top;
            i3++;
            i4 = i8;
            i5 = i9;
        }
        Arrays.sort(iArr);
        Arrays.sort(iArr2);
        for (int i10 = 0; i10 < size; i10++) {
            Rect elementAt2 = vector.elementAt(i10);
            int a2 = a(iArr, elementAt2.left);
            int a3 = a(iArr, elementAt2.right);
            int a4 = a(iArr2, elementAt2.top);
            int a5 = a(iArr2, elementAt2.bottom);
            for (int i11 = a2 + 1; i11 <= a3; i11++) {
                for (int i12 = a4 + 1; i12 <= a5; i12++) {
                    zArr[i11][i12] = true;
                }
            }
        }
        int i13 = 0;
        for (int i14 = 0; i14 < i2; i14++) {
            for (int i15 = 0; i15 < i2; i15++) {
                i13 += zArr[i14][i15] ? (iArr[i14] - iArr[i14 - 1]) * (iArr2[i15] - iArr2[i15 - 1]) : 0;
            }
        }
        return i13;
    }

    private static int a(int[] iArr, int i2) {
        int length = iArr.length;
        int i3 = 0;
        while (i3 < length) {
            int i4 = ((length - i3) / 2) + i3;
            int i5 = iArr[i4];
            if (i5 == i2) {
                return i4;
            }
            if (i5 > i2) {
                length = i4;
            } else {
                i3 = i4 + 1;
            }
        }
        return -1;
    }

    public static b a(View view, int i2) {
        View view2 = view;
        boolean z2 = false;
        if (view2 == null) {
            a((View) null, false, "mAdView is null.");
            return new b(c.AD_IS_NULL);
        } else if (view.getParent() == null) {
            a(view2, false, "mAdView has no parent.");
            return new b(c.INVALID_PARENT);
        } else if (!view.isShown()) {
            a(view2, false, "mAdView parent is not set to VISIBLE.");
            return new b(c.INVALID_PARENT);
        } else if (view.getWindowVisibility() != 0) {
            a(view2, false, "mAdView window is not set to VISIBLE.");
            return new b(c.INVALID_WINDOW);
        } else if (view.getMeasuredWidth() <= 0 || view.getMeasuredHeight() <= 0) {
            a(view2, false, "mAdView has invisible dimensions (w=" + view.getMeasuredWidth() + ", h=" + view.getMeasuredHeight());
            return new b(c.INVALID_DIMENSIONS);
        } else if (a(view) < 0.9f) {
            a(view2, false, "mAdView is too transparent.");
            return new b(c.AD_IS_TRANSPARENT);
        } else {
            int width = view.getWidth();
            int height = view.getHeight();
            int[] iArr = new int[2];
            try {
                view2.getLocationOnScreen(iArr);
                Rect rect = new Rect();
                if (!view2.getGlobalVisibleRect(rect)) {
                    return new b(c.AD_IS_NOT_VISIBLE);
                }
                Context context = view.getContext();
                Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getRealMetrics(displayMetrics);
                Vector<Rect> b2 = b(view);
                int a2 = a(b2);
                b2.add(rect);
                float a3 = (((float) (a(b2) - a2)) * 1.0f) / ((float) (view.getMeasuredHeight() * view.getMeasuredWidth()));
                boolean t2 = com.facebook.ads.internal.l.a.t(context);
                int a4 = a(i2, view2);
                float f2 = ((float) a4) / 100.0f;
                if (!t2) {
                    int i3 = iArr[0];
                    if (i3 < 0 || displayMetrics.widthPixels - i3 < width) {
                        a(view2, false, "mAdView is not fully on screen horizontally.");
                        return new b(c.AD_OFFSCREEN_HORIZONTALLY, a3);
                    }
                    int i4 = (int) ((((double) height) * (100.0d - ((double) a4))) / 100.0d);
                    int i5 = rect.top;
                    int i6 = iArr[1];
                    if (i5 - i6 > i4) {
                        a(view2, false, "mAdView is not visible from the top.");
                        return new b(c.AD_OFFSCREEN_TOP, a3);
                    }
                    z2 = false;
                    if ((i6 + height) - rect.bottom > i4) {
                        a(view2, false, "mAdView is not visible from the bottom.");
                        return new b(c.AD_OFFSCREEN_BOTTOM, a3);
                    }
                } else if (a3 < f2) {
                    a(view2, false, String.format(Locale.US, "mAdView visible area is too small [%.2f%% visible, current threshold %.2f%%]", new Object[]{Float.valueOf(a3), Float.valueOf(f2)}));
                    return new b(c.AD_INSUFFICIENT_VISIBLE_AREA, a3);
                }
                if (!com.facebook.ads.internal.q.e.a.b(context)) {
                    a(view2, z2, "Screen is not interactive.");
                    return new b(c.SCREEN_NOT_INTERACTIVE, a3);
                }
                Map<String, String> a5 = com.facebook.ads.internal.q.e.b.a(context);
                if (z.b(a5)) {
                    a(view2, z2, "Keyguard is obstructing view.");
                    return new b(c.AD_IS_OBSTRUCTED_BY_KEYGUARD, a3);
                } else if (!com.facebook.ads.internal.l.a.c(context) || !z.a(a5)) {
                    Float a6 = com.facebook.ads.internal.l.a.r(context) ? d.a(view) : null;
                    if (a6 != null) {
                        if (a6.floatValue() == -1.0f) {
                            a(view2, false, "mAdView is not in the top activity");
                            return new b(c.AD_IS_NOT_IN_ACTIVITY);
                        } else if (a6.floatValue() == 0.0f) {
                            a(view2, false, "mAdView is not visible");
                            return new b(c.AD_IS_NOT_VISIBLE);
                        }
                    }
                    if (!com.facebook.ads.internal.l.a.s(context) || a6 == null || a6.floatValue() >= f2) {
                        a(view2, true, "mAdView is visible.");
                        return new b(c.IS_VIEWABLE, a3, a5);
                    }
                    a(view2, false, String.format(Locale.US, "mAdView visible area is too small [%.2f%% visible, current threshold %.2f%%]", new Object[]{a6, Float.valueOf(f2)}));
                    return new b(c.AD_INSUFFICIENT_VISIBLE_AREA, a3, a5);
                } else {
                    a(view2, z2, "Ad is on top of the Lockscreen.");
                    return new b(c.AD_IN_LOCKSCREEN, a3, a5);
                }
            } catch (NullPointerException unused) {
                a(view2, false, "Cannot get location on screen.");
                return new b(c.INVALID_DIMENSIONS);
            }
        }
    }

    private static void a(View view, boolean z2, String str) {
    }

    private static Vector<Rect> b(View view) {
        Vector<Rect> vector = new Vector<>();
        if (!(view.getParent() instanceof ViewGroup)) {
            return vector;
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int indexOfChild = viewGroup.indexOfChild(view);
        while (true) {
            indexOfChild++;
            if (indexOfChild < viewGroup.getChildCount()) {
                vector.addAll(c(viewGroup.getChildAt(indexOfChild)));
            } else {
                vector.addAll(b((View) viewGroup));
                return vector;
            }
        }
    }

    private static Vector<Rect> c(View view) {
        Vector<Rect> vector = new Vector<>();
        if (view.isShown() && view.getAlpha() > 0.0f) {
            if (!(view instanceof ViewGroup) || !d(view)) {
                Rect rect = new Rect();
                if (view.getGlobalVisibleRect(rect)) {
                    vector.add(rect);
                }
            } else {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    vector.addAll(c(viewGroup.getChildAt(i2)));
                }
                return vector;
            }
        }
        return vector;
    }

    static /* synthetic */ int d(a aVar) {
        int i2 = aVar.f20778o;
        aVar.f20778o = i2 + 1;
        return i2;
    }

    private static boolean d(View view) {
        return view.getBackground() == null || view.getBackground().getAlpha() <= 0;
    }

    public synchronized void a() {
        if (this.f20771h != null) {
            c();
        }
        b bVar = new b(this);
        this.f20771h = bVar;
        this.f20769f.postDelayed(bVar, (long) this.f20772i);
        this.f20774k = false;
        this.f20778o = 0;
        this.f20775l = new b(c.UNKNOWN);
        this.f20776m = new HashMap();
    }

    public void a(int i2) {
        this.f20772i = i2;
    }

    public synchronized void a(Map<String, String> map) {
        map.put("vrc", String.valueOf(this.f20775l.b()));
        map.put("vp", String.valueOf(this.f20775l.c()));
        map.put("vh", new JSONObject(this.f20776m).toString());
        map.put("vt", t.a(this.f20777n));
        map.putAll(this.f20775l.d());
    }

    public void b(int i2) {
        this.f20773j = i2;
    }

    public synchronized boolean b() {
        return this.f20774k;
    }

    public synchronized void c() {
        this.f20769f.removeCallbacks(this.f20771h);
        this.f20771h = null;
        this.f20774k = true;
        this.f20778o = 0;
    }

    public synchronized String d() {
        c cVar;
        cVar = c.values()[this.f20775l.b()];
        return cVar.toString() + String.format(" (%.1f%%)", new Object[]{Float.valueOf(this.f20775l.c() * 100.0f)});
    }
}
