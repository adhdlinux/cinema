package com.iab.omid.library.applovin.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.iab.omid.library.applovin.c.a;
import com.iab.omid.library.applovin.c.b;
import com.iab.omid.library.applovin.d.d;
import com.iab.omid.library.applovin.d.f;
import com.iab.omid.library.applovin.walking.a;
import com.iab.omid.library.applovin.walking.a.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class TreeWalker implements a.C0045a {

    /* renamed from: a  reason: collision with root package name */
    private static TreeWalker f31540a = new TreeWalker();

    /* renamed from: b  reason: collision with root package name */
    private static Handler f31541b = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static Handler f31542c = null;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public static final Runnable f31543l = new Runnable() {
        public void run() {
            TreeWalker.getInstance().h();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static final Runnable f31544m = new Runnable() {
        public void run() {
            if (TreeWalker.f31542c != null) {
                TreeWalker.f31542c.post(TreeWalker.f31543l);
                TreeWalker.f31542c.postDelayed(TreeWalker.f31544m, 200);
            }
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private List<TreeWalkerTimeLogger> f31545d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private int f31546e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f31547f = false;

    /* renamed from: g  reason: collision with root package name */
    private final List<com.iab.omid.library.applovin.e.a> f31548g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private b f31549h = new b();

    /* renamed from: i  reason: collision with root package name */
    private a f31550i = new a();
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public b f31551j = new b(new c());

    /* renamed from: k  reason: collision with root package name */
    private long f31552k;

    public interface TreeWalkerNanoTimeLogger extends TreeWalkerTimeLogger {
        void onTreeProcessedNano(int i2, long j2);
    }

    public interface TreeWalkerTimeLogger {
        void onTreeProcessed(int i2, long j2);
    }

    TreeWalker() {
    }

    private void a(long j2) {
        if (this.f31545d.size() > 0) {
            for (TreeWalkerTimeLogger next : this.f31545d) {
                next.onTreeProcessed(this.f31546e, TimeUnit.NANOSECONDS.toMillis(j2));
                if (next instanceof TreeWalkerNanoTimeLogger) {
                    ((TreeWalkerNanoTimeLogger) next).onTreeProcessedNano(this.f31546e, j2);
                }
            }
        }
    }

    private void a(View view, a aVar, JSONObject jSONObject, c cVar, boolean z2) {
        aVar.a(view, jSONObject, this, cVar == c.PARENT_VIEW, z2);
    }

    private void a(String str, View view, JSONObject jSONObject) {
        a b2 = this.f31549h.b();
        String a2 = this.f31550i.a(str);
        if (a2 != null) {
            JSONObject a3 = b2.a(view);
            com.iab.omid.library.applovin.d.b.a(a3, str);
            com.iab.omid.library.applovin.d.b.b(a3, a2);
            com.iab.omid.library.applovin.d.b.a(jSONObject, a3);
        }
    }

    private boolean a(View view, JSONObject jSONObject) {
        String a2 = this.f31550i.a(view);
        if (a2 == null) {
            return false;
        }
        com.iab.omid.library.applovin.d.b.a(jSONObject, a2);
        com.iab.omid.library.applovin.d.b.a(jSONObject, Boolean.valueOf(this.f31550i.d(view)));
        this.f31550i.e();
        return true;
    }

    private boolean b(View view, JSONObject jSONObject) {
        a.C0046a b2 = this.f31550i.b(view);
        if (b2 == null) {
            return false;
        }
        com.iab.omid.library.applovin.d.b.a(jSONObject, b2);
        return true;
    }

    public static TreeWalker getInstance() {
        return f31540a;
    }

    /* access modifiers changed from: private */
    public void h() {
        i();
        d();
        j();
    }

    private void i() {
        this.f31546e = 0;
        this.f31548g.clear();
        this.f31547f = false;
        Iterator<com.iab.omid.library.applovin.adsession.a> it2 = com.iab.omid.library.applovin.b.a.a().c().iterator();
        while (true) {
            if (it2.hasNext()) {
                if (it2.next().b()) {
                    this.f31547f = true;
                    break;
                }
            } else {
                break;
            }
        }
        this.f31552k = d.a();
    }

    private void j() {
        a(d.a() - this.f31552k);
    }

    private void k() {
        if (f31542c == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f31542c = handler;
            handler.post(f31543l);
            f31542c.postDelayed(f31544m, 200);
        }
    }

    private void l() {
        Handler handler = f31542c;
        if (handler != null) {
            handler.removeCallbacks(f31544m);
            f31542c = null;
        }
    }

    public void a() {
        k();
    }

    public void a(View view, com.iab.omid.library.applovin.c.a aVar, JSONObject jSONObject, boolean z2) {
        c c2;
        if (f.d(view) && (c2 = this.f31550i.c(view)) != c.UNDERLYING_VIEW) {
            JSONObject a2 = aVar.a(view);
            com.iab.omid.library.applovin.d.b.a(jSONObject, a2);
            if (!a(view, a2)) {
                boolean z3 = z2 || b(view, a2);
                if (this.f31547f && c2 == c.OBSTRUCTION_VIEW && !z3) {
                    this.f31548g.add(new com.iab.omid.library.applovin.e.a(view));
                }
                a(view, aVar, a2, c2, z3);
            }
            this.f31546e++;
        }
    }

    public void addTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (!this.f31545d.contains(treeWalkerTimeLogger)) {
            this.f31545d.add(treeWalkerTimeLogger);
        }
    }

    public void b() {
        c();
        this.f31545d.clear();
        f31541b.post(new Runnable() {
            public void run() {
                TreeWalker.this.f31551j.a();
            }
        });
    }

    public void c() {
        l();
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f31550i.c();
        long a2 = d.a();
        com.iab.omid.library.applovin.c.a a3 = this.f31549h.a();
        if (this.f31550i.b().size() > 0) {
            Iterator<String> it2 = this.f31550i.b().iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                JSONObject a4 = a3.a((View) null);
                a(next, this.f31550i.b(next), a4);
                com.iab.omid.library.applovin.d.b.a(a4);
                HashSet hashSet = new HashSet();
                hashSet.add(next);
                this.f31551j.b(a4, hashSet, a2);
            }
        }
        if (this.f31550i.a().size() > 0) {
            JSONObject a5 = a3.a((View) null);
            a((View) null, a3, a5, c.PARENT_VIEW, false);
            com.iab.omid.library.applovin.d.b.a(a5);
            this.f31551j.a(a5, this.f31550i.a(), a2);
            if (this.f31547f) {
                for (com.iab.omid.library.applovin.adsession.a a6 : com.iab.omid.library.applovin.b.a.a().c()) {
                    a6.a(this.f31548g);
                }
            }
        } else {
            this.f31551j.a();
        }
        this.f31550i.d();
    }

    public void removeTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f31545d.contains(treeWalkerTimeLogger)) {
            this.f31545d.remove(treeWalkerTimeLogger);
        }
    }
}
