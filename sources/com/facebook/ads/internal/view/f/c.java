package com.facebook.ads.internal.view.f;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.facebook.ads.internal.b.c;
import com.facebook.ads.internal.q.a.p;
import com.facebook.ads.internal.q.a.w;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class c implements p<Bundle> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f21312a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f21313b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f21314c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final com.facebook.ads.internal.m.c f21315d;

    /* renamed from: e  reason: collision with root package name */
    private final a f21316e;

    /* renamed from: f  reason: collision with root package name */
    private final com.facebook.ads.internal.b.a f21317f;

    /* renamed from: g  reason: collision with root package name */
    private int f21318g;

    /* renamed from: h  reason: collision with root package name */
    private int f21319h;

    /* renamed from: i  reason: collision with root package name */
    private final e f21320i;

    /* renamed from: j  reason: collision with root package name */
    private final Map<String, String> f21321j;

    public interface a {
        boolean g();

        int getCurrentPositionInMillis();

        boolean getGlobalVisibleRect(Rect rect);

        long getInitialBufferTime();

        int getMeasuredHeight();

        int getMeasuredWidth();

        com.facebook.ads.internal.view.f.a.a getVideoStartReason();

        float getVolume();

        boolean h();
    }

    protected enum b {
        PLAY(0),
        SKIP(1),
        TIME(2),
        MRC(3),
        PAUSE(4),
        RESUME(5),
        MUTE(6),
        UNMUTE(7),
        VIEWABLE_IMPRESSION(10);
        

        /* renamed from: j  reason: collision with root package name */
        public final int f21352j;

        private b(int i2) {
            this.f21352j = i2;
        }
    }

    public c(Context context, com.facebook.ads.internal.m.c cVar, a aVar, List<com.facebook.ads.internal.b.b> list, String str) {
        this(context, cVar, aVar, list, str, (Bundle) null);
    }

    public c(Context context, com.facebook.ads.internal.m.c cVar, a aVar, List<com.facebook.ads.internal.b.b> list, String str, Bundle bundle) {
        this(context, cVar, aVar, list, str, bundle, (Map<String, String>) null);
    }

    public c(Context context, com.facebook.ads.internal.m.c cVar, a aVar, List<com.facebook.ads.internal.b.b> list, String str, Bundle bundle, Map<String, String> map) {
        com.facebook.ads.internal.b.a aVar2;
        a aVar3 = aVar;
        List<com.facebook.ads.internal.b.b> list2 = list;
        Bundle bundle2 = bundle;
        this.f21313b = true;
        this.f21318g = 0;
        this.f21319h = 0;
        this.f21314c = context;
        this.f21315d = cVar;
        this.f21316e = aVar3;
        this.f21312a = str;
        this.f21321j = map;
        list2.add(new com.facebook.ads.internal.b.b(0.5d, -1.0d, 2.0d, true) {
            /* access modifiers changed from: protected */
            public void a(boolean z2, boolean z3, com.facebook.ads.internal.b.c cVar) {
                if (z3) {
                    c.this.f21315d.e(c.this.f21312a, c.this.a(b.MRC));
                }
            }
        });
        list2.add(new com.facebook.ads.internal.b.b(1.0E-7d, -1.0d, 0.001d, false) {
            /* access modifiers changed from: protected */
            public void a(boolean z2, boolean z3, com.facebook.ads.internal.b.c cVar) {
                if (z3) {
                    c.this.f21315d.e(c.this.f21312a, c.this.a(b.VIEWABLE_IMPRESSION));
                }
            }
        });
        View view = (View) aVar3;
        if (bundle2 != null) {
            Bundle bundle3 = bundle2.getBundle("adQualityManager");
            this.f21317f = aVar2;
            this.f21318g = bundle2.getInt("lastProgressTimeMS");
            this.f21319h = bundle2.getInt("lastBoundaryTimeMS");
        } else {
            aVar2 = new com.facebook.ads.internal.b.a(view, list2);
            this.f21317f = aVar2;
        }
        this.f21320i = new e(new Handler(), this);
    }

    /* access modifiers changed from: private */
    public Map<String, String> a(b bVar) {
        return a(bVar, this.f21316e.getCurrentPositionInMillis());
    }

    private Map<String, String> a(b bVar, int i2) {
        Map<String, String> c2 = c(i2);
        c2.put("action", String.valueOf(bVar.f21352j));
        return c2;
    }

    private void a() {
        this.f21315d.e(this.f21312a, a(b.MUTE));
    }

    private void a(int i2, boolean z2) {
        int i3;
        if (((double) i2) > 0.0d && i2 >= (i3 = this.f21318g)) {
            if (i2 > i3) {
                this.f21317f.a((double) (((float) (i2 - i3)) / 1000.0f), (double) d());
                this.f21318g = i2;
                if (i2 - this.f21319h >= 5000) {
                    this.f21315d.e(this.f21312a, a(b.TIME, i2));
                    this.f21319h = this.f21318g;
                    this.f21317f.a();
                    return;
                }
            }
            if (z2) {
                this.f21315d.e(this.f21312a, a(b.TIME, i2));
            }
        }
    }

    private void a(HashMap<String, String> hashMap) {
        Map<String, String> map = this.f21321j;
        if (map != null) {
            hashMap.putAll(map);
        }
    }

    private void a(Map<String, String> map) {
        map.put("exoplayer", String.valueOf(this.f21316e.g()));
        map.put("prep", Long.toString(this.f21316e.getInitialBufferTime()));
    }

    private void a(Map<String, String> map, int i2) {
        map.put("ptime", String.valueOf(((float) this.f21319h) / 1000.0f));
        map.put("time", String.valueOf(((float) i2) / 1000.0f));
    }

    private void b(Map<String, String> map) {
        com.facebook.ads.internal.b.c c2 = this.f21317f.c();
        c.a c3 = c2.c();
        map.put("vwa", String.valueOf(c3.d()));
        map.put("vwm", String.valueOf(c3.c()));
        map.put("vwmax", String.valueOf(c3.e()));
        map.put("vtime_ms", String.valueOf(c3.g() * 1000.0d));
        map.put("mcvt_ms", String.valueOf(c3.h() * 1000.0d));
        c.a d2 = c2.d();
        map.put("vla", String.valueOf(d2.d()));
        map.put("vlm", String.valueOf(d2.c()));
        map.put("vlmax", String.valueOf(d2.e()));
        map.put("atime_ms", String.valueOf(d2.g() * 1000.0d));
        map.put("mcat_ms", String.valueOf(d2.h() * 1000.0d));
    }

    private Map<String, String> c(int i2) {
        HashMap hashMap = new HashMap();
        w.a(hashMap, this.f21316e.getVideoStartReason() == com.facebook.ads.internal.view.f.a.a.AUTO_STARTED, !this.f21316e.h());
        a((Map<String, String>) hashMap);
        b((Map<String, String>) hashMap);
        a((Map<String, String>) hashMap, i2);
        c((Map<String, String>) hashMap);
        a((HashMap<String, String>) hashMap);
        return hashMap;
    }

    private void c(Map<String, String> map) {
        Rect rect = new Rect();
        this.f21316e.getGlobalVisibleRect(rect);
        map.put("pt", String.valueOf(rect.top));
        map.put("pl", String.valueOf(rect.left));
        map.put("ph", String.valueOf(this.f21316e.getMeasuredHeight()));
        map.put("pw", String.valueOf(this.f21316e.getMeasuredWidth()));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.f21314c.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        map.put("vph", String.valueOf(displayMetrics.heightPixels));
        map.put("vpw", String.valueOf(displayMetrics.widthPixels));
    }

    private void k() {
        this.f21315d.e(this.f21312a, a(b.UNMUTE));
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        a(i2, false);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3) {
        a(i2, true);
        this.f21319h = i3;
        this.f21318g = i3;
        this.f21317f.a();
        this.f21317f.b();
    }

    public void b() {
        this.f21314c.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.f21320i);
    }

    public void b(int i2) {
        a(i2, true);
        this.f21319h = 0;
        this.f21318g = 0;
        this.f21317f.a();
        this.f21317f.b();
    }

    public void c() {
        this.f21314c.getContentResolver().unregisterContentObserver(this.f21320i);
    }

    /* access modifiers changed from: protected */
    public float d() {
        return w.a(this.f21314c) * this.f21316e.getVolume();
    }

    /* access modifiers changed from: package-private */
    public void e() {
        boolean z2;
        int i2 = (((double) d()) > 0.05d ? 1 : (((double) d()) == 0.05d ? 0 : -1));
        boolean z3 = this.f21313b;
        if (i2 < 0) {
            if (z3) {
                a();
                z2 = false;
            } else {
                return;
            }
        } else if (!z3) {
            k();
            z2 = true;
        } else {
            return;
        }
        this.f21313b = z2;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f21315d.e(this.f21312a, a(b.SKIP));
    }

    public Bundle g() {
        a(j(), j());
        Bundle bundle = new Bundle();
        bundle.putInt("lastProgressTimeMS", this.f21318g);
        bundle.putInt("lastBoundaryTimeMS", this.f21319h);
        bundle.putBundle("adQualityManager", this.f21317f.g());
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public void h() {
        this.f21315d.e(this.f21312a, a(b.PAUSE));
    }

    /* access modifiers changed from: package-private */
    public void i() {
        this.f21315d.e(this.f21312a, a(b.RESUME));
    }

    public int j() {
        return this.f21318g;
    }
}
