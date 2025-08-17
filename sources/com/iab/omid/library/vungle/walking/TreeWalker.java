package com.iab.omid.library.vungle.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.iab.omid.library.vungle.internal.j;
import com.iab.omid.library.vungle.processor.a;
import com.iab.omid.library.vungle.utils.f;
import com.iab.omid.library.vungle.utils.h;
import com.iab.omid.library.vungle.walking.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class TreeWalker implements a.C0048a {

    /* renamed from: i  reason: collision with root package name */
    private static TreeWalker f31759i = new TreeWalker();

    /* renamed from: j  reason: collision with root package name */
    private static Handler f31760j = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static Handler f31761k = null;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public static final Runnable f31762l = new b();
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static final Runnable f31763m = new c();

    /* renamed from: a  reason: collision with root package name */
    private List<TreeWalkerTimeLogger> f31764a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private int f31765b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f31766c = false;

    /* renamed from: d  reason: collision with root package name */
    private final List<com.iab.omid.library.vungle.weakreference.a> f31767d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private com.iab.omid.library.vungle.processor.b f31768e = new com.iab.omid.library.vungle.processor.b();

    /* renamed from: f  reason: collision with root package name */
    private a f31769f = new a();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public b f31770g = new b(new com.iab.omid.library.vungle.walking.async.c());

    /* renamed from: h  reason: collision with root package name */
    private long f31771h;

    public interface TreeWalkerNanoTimeLogger extends TreeWalkerTimeLogger {
        void onTreeProcessedNano(int i2, long j2);
    }

    public interface TreeWalkerTimeLogger {
        void onTreeProcessed(int i2, long j2);
    }

    class a implements Runnable {
        a() {
        }

        public void run() {
            TreeWalker.this.f31770g.c();
        }
    }

    class b implements Runnable {
        b() {
        }

        public void run() {
            TreeWalker.p().u();
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            if (TreeWalker.f31761k != null) {
                TreeWalker.f31761k.post(TreeWalker.f31762l);
                TreeWalker.f31761k.postDelayed(TreeWalker.f31763m, 200);
            }
        }
    }

    TreeWalker() {
    }

    private void d(long j2) {
        if (this.f31764a.size() > 0) {
            for (TreeWalkerTimeLogger next : this.f31764a) {
                next.onTreeProcessed(this.f31765b, TimeUnit.NANOSECONDS.toMillis(j2));
                if (next instanceof TreeWalkerNanoTimeLogger) {
                    ((TreeWalkerNanoTimeLogger) next).onTreeProcessedNano(this.f31765b, j2);
                }
            }
        }
    }

    private void e(View view, com.iab.omid.library.vungle.processor.a aVar, JSONObject jSONObject, c cVar, boolean z2) {
        aVar.a(view, jSONObject, this, cVar == c.PARENT_VIEW, z2);
    }

    private void f(String str, View view, JSONObject jSONObject) {
        com.iab.omid.library.vungle.processor.a b2 = this.f31768e.b();
        String h2 = this.f31769f.h(str);
        if (h2 != null) {
            JSONObject a2 = b2.a(view);
            com.iab.omid.library.vungle.utils.c.h(a2, str);
            com.iab.omid.library.vungle.utils.c.o(a2, h2);
            com.iab.omid.library.vungle.utils.c.j(jSONObject, a2);
        }
    }

    private boolean g(View view, JSONObject jSONObject) {
        a.C0050a g2 = this.f31769f.g(view);
        if (g2 == null) {
            return false;
        }
        com.iab.omid.library.vungle.utils.c.f(jSONObject, g2);
        return true;
    }

    private boolean j(View view, JSONObject jSONObject) {
        String j2 = this.f31769f.j(view);
        if (j2 == null) {
            return false;
        }
        com.iab.omid.library.vungle.utils.c.h(jSONObject, j2);
        com.iab.omid.library.vungle.utils.c.g(jSONObject, Boolean.valueOf(this.f31769f.p(view)));
        com.iab.omid.library.vungle.utils.c.n(jSONObject, Boolean.valueOf(this.f31769f.l(j2)));
        this.f31769f.n();
        return true;
    }

    private void l() {
        d(f.b() - this.f31771h);
    }

    private void m() {
        this.f31765b = 0;
        this.f31767d.clear();
        this.f31766c = false;
        Iterator<com.iab.omid.library.vungle.adsession.a> it2 = com.iab.omid.library.vungle.internal.c.e().a().iterator();
        while (true) {
            if (it2.hasNext()) {
                if (it2.next().j()) {
                    this.f31766c = true;
                    break;
                }
            } else {
                break;
            }
        }
        this.f31771h = f.b();
    }

    public static TreeWalker p() {
        return f31759i;
    }

    private void r() {
        if (f31761k == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f31761k = handler;
            handler.post(f31762l);
            f31761k.postDelayed(f31763m, 200);
        }
    }

    private void t() {
        Handler handler = f31761k;
        if (handler != null) {
            handler.removeCallbacks(f31763m);
            f31761k = null;
        }
    }

    /* access modifiers changed from: private */
    public void u() {
        m();
        n();
        l();
        j.f().a();
    }

    public void a(View view, com.iab.omid.library.vungle.processor.a aVar, JSONObject jSONObject, boolean z2) {
        c m2;
        if (h.f(view) && (m2 = this.f31769f.m(view)) != c.UNDERLYING_VIEW) {
            JSONObject a2 = aVar.a(view);
            com.iab.omid.library.vungle.utils.c.j(jSONObject, a2);
            if (!j(view, a2)) {
                boolean z3 = z2 || g(view, a2);
                if (this.f31766c && m2 == c.OBSTRUCTION_VIEW && !z3) {
                    this.f31767d.add(new com.iab.omid.library.vungle.weakreference.a(view));
                }
                e(view, aVar, a2, m2, z3);
            }
            this.f31765b++;
        }
    }

    /* access modifiers changed from: package-private */
    public void n() {
        this.f31769f.o();
        long b2 = f.b();
        com.iab.omid.library.vungle.processor.a a2 = this.f31768e.a();
        if (this.f31769f.i().size() > 0) {
            Iterator<String> it2 = this.f31769f.i().iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                JSONObject a3 = a2.a((View) null);
                f(next, this.f31769f.a(next), a3);
                com.iab.omid.library.vungle.utils.c.m(a3);
                HashSet hashSet = new HashSet();
                hashSet.add(next);
                this.f31770g.b(a3, hashSet, b2);
            }
        }
        if (this.f31769f.k().size() > 0) {
            JSONObject a4 = a2.a((View) null);
            e((View) null, a2, a4, c.PARENT_VIEW, false);
            com.iab.omid.library.vungle.utils.c.m(a4);
            this.f31770g.d(a4, this.f31769f.k(), b2);
            if (this.f31766c) {
                for (com.iab.omid.library.vungle.adsession.a f2 : com.iab.omid.library.vungle.internal.c.e().a()) {
                    f2.f(this.f31767d);
                }
            }
        } else {
            this.f31770g.c();
        }
        this.f31769f.d();
    }

    public void o() {
        t();
    }

    public void q() {
        r();
    }

    public void s() {
        o();
        this.f31764a.clear();
        f31760j.post(new a());
    }
}
