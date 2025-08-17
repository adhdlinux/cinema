package com.iab.omid.library.adcolony.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.iab.omid.library.adcolony.c.a;
import com.iab.omid.library.adcolony.c.b;
import com.iab.omid.library.adcolony.d.d;
import com.iab.omid.library.adcolony.d.f;
import com.iab.omid.library.adcolony.walking.a;
import com.iab.omid.library.adcolony.walking.a.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class TreeWalker implements a.C0042a {

    /* renamed from: i  reason: collision with root package name */
    private static TreeWalker f31423i = new TreeWalker();

    /* renamed from: j  reason: collision with root package name */
    private static Handler f31424j = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static Handler f31425k = null;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public static final Runnable f31426l = new Runnable() {
        public void run() {
            TreeWalker.p().q();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static final Runnable f31427m = new Runnable() {
        public void run() {
            if (TreeWalker.f31425k != null) {
                TreeWalker.f31425k.post(TreeWalker.f31426l);
                TreeWalker.f31425k.postDelayed(TreeWalker.f31427m, 200);
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private List<TreeWalkerTimeLogger> f31428a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private int f31429b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f31430c = false;

    /* renamed from: d  reason: collision with root package name */
    private final List<com.iab.omid.library.adcolony.e.a> f31431d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private b f31432e = new b();

    /* renamed from: f  reason: collision with root package name */
    private a f31433f = new a();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public b f31434g = new b(new c());

    /* renamed from: h  reason: collision with root package name */
    private long f31435h;

    public interface TreeWalkerNanoTimeLogger extends TreeWalkerTimeLogger {
        void onTreeProcessedNano(int i2, long j2);
    }

    public interface TreeWalkerTimeLogger {
        void onTreeProcessed(int i2, long j2);
    }

    TreeWalker() {
    }

    private void d(long j2) {
        if (this.f31428a.size() > 0) {
            for (TreeWalkerTimeLogger next : this.f31428a) {
                next.onTreeProcessed(this.f31429b, TimeUnit.NANOSECONDS.toMillis(j2));
                if (next instanceof TreeWalkerNanoTimeLogger) {
                    ((TreeWalkerNanoTimeLogger) next).onTreeProcessedNano(this.f31429b, j2);
                }
            }
        }
    }

    private void e(View view, a aVar, JSONObject jSONObject, c cVar, boolean z2) {
        aVar.a(view, jSONObject, this, cVar == c.PARENT_VIEW, z2);
    }

    private void f(String str, View view, JSONObject jSONObject) {
        a b2 = this.f31432e.b();
        String b3 = this.f31433f.b(str);
        if (b3 != null) {
            JSONObject a2 = b2.a(view);
            com.iab.omid.library.adcolony.d.b.g(a2, str);
            com.iab.omid.library.adcolony.d.b.l(a2, b3);
            com.iab.omid.library.adcolony.d.b.i(jSONObject, a2);
        }
    }

    private boolean g(View view, JSONObject jSONObject) {
        String a2 = this.f31433f.a(view);
        if (a2 == null) {
            return false;
        }
        com.iab.omid.library.adcolony.d.b.g(jSONObject, a2);
        com.iab.omid.library.adcolony.d.b.f(jSONObject, Boolean.valueOf(this.f31433f.l(view)));
        this.f31433f.n();
        return true;
    }

    private boolean j(View view, JSONObject jSONObject) {
        a.C0043a g2 = this.f31433f.g(view);
        if (g2 == null) {
            return false;
        }
        com.iab.omid.library.adcolony.d.b.e(jSONObject, g2);
        return true;
    }

    public static TreeWalker p() {
        return f31423i;
    }

    /* access modifiers changed from: private */
    public void q() {
        r();
        l();
        s();
    }

    private void r() {
        this.f31429b = 0;
        this.f31431d.clear();
        this.f31430c = false;
        Iterator<com.iab.omid.library.adcolony.adsession.a> it2 = com.iab.omid.library.adcolony.b.a.a().e().iterator();
        while (true) {
            if (it2.hasNext()) {
                if (it2.next().n()) {
                    this.f31430c = true;
                    break;
                }
            } else {
                break;
            }
        }
        this.f31435h = d.a();
    }

    private void s() {
        d(d.a() - this.f31435h);
    }

    private void t() {
        if (f31425k == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f31425k = handler;
            handler.post(f31426l);
            f31425k.postDelayed(f31427m, 200);
        }
    }

    private void u() {
        Handler handler = f31425k;
        if (handler != null) {
            handler.removeCallbacks(f31427m);
            f31425k = null;
        }
    }

    public void a(View view, com.iab.omid.library.adcolony.c.a aVar, JSONObject jSONObject, boolean z2) {
        c i2;
        if (f.d(view) && (i2 = this.f31433f.i(view)) != c.UNDERLYING_VIEW) {
            JSONObject a2 = aVar.a(view);
            com.iab.omid.library.adcolony.d.b.i(jSONObject, a2);
            if (!g(view, a2)) {
                boolean z3 = z2 || j(view, a2);
                if (this.f31430c && i2 == c.OBSTRUCTION_VIEW && !z3) {
                    this.f31431d.add(new com.iab.omid.library.adcolony.e.a(view));
                }
                e(view, aVar, a2, i2, z3);
            }
            this.f31429b++;
        }
    }

    public void c() {
        t();
    }

    public void h() {
        k();
        this.f31428a.clear();
        f31424j.post(new Runnable() {
            public void run() {
                TreeWalker.this.f31434g.a();
            }
        });
    }

    public void k() {
        u();
    }

    /* access modifiers changed from: package-private */
    public void l() {
        this.f31433f.j();
        long a2 = d.a();
        com.iab.omid.library.adcolony.c.a a3 = this.f31432e.a();
        if (this.f31433f.h().size() > 0) {
            Iterator<String> it2 = this.f31433f.h().iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                JSONObject a4 = a3.a((View) null);
                f(next, this.f31433f.f(next), a4);
                com.iab.omid.library.adcolony.d.b.d(a4);
                HashSet hashSet = new HashSet();
                hashSet.add(next);
                this.f31434g.c(a4, hashSet, a2);
            }
        }
        if (this.f31433f.c().size() > 0) {
            JSONObject a5 = a3.a((View) null);
            e((View) null, a3, a5, c.PARENT_VIEW, false);
            com.iab.omid.library.adcolony.d.b.d(a5);
            this.f31434g.b(a5, this.f31433f.c(), a2);
            if (this.f31430c) {
                for (com.iab.omid.library.adcolony.adsession.a k2 : com.iab.omid.library.adcolony.b.a.a().e()) {
                    k2.k(this.f31431d);
                }
            }
        } else {
            this.f31434g.a();
        }
        this.f31433f.k();
    }
}
