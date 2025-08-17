package com.applovin.impl.sdk.network;

import android.content.SharedPreferences;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.c.d;
import com.applovin.impl.sdk.e.a;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.e.z;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private final m f15681a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final v f15682b;

    /* renamed from: c  reason: collision with root package name */
    private final int f15683c;

    /* renamed from: d  reason: collision with root package name */
    private final g f15684d;

    /* renamed from: e  reason: collision with root package name */
    private final SharedPreferences f15685e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final Object f15686f = new Object();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final ArrayList<h> f15687g;

    /* renamed from: h  reason: collision with root package name */
    private final ArrayList<h> f15688h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private long f15689i = 0;

    /* renamed from: j  reason: collision with root package name */
    private final Set<h> f15690j = new HashSet();

    public f(m mVar) {
        if (mVar != null) {
            this.f15681a = mVar;
            this.f15682b = mVar.A();
            int intValue = ((Integer) mVar.a(b.cL)).intValue();
            this.f15683c = intValue;
            if (mVar.aa() != null) {
                this.f15685e = mVar.L().getSharedPreferences("com.applovin.sdk.impl.postbackQueue.domain", 0);
                this.f15687g = d();
                this.f15684d = null;
                return;
            }
            g gVar = new g(this, mVar);
            this.f15684d = gVar;
            this.f15687g = gVar.a(intValue);
            gVar.a();
            this.f15685e = null;
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0064, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0078, code lost:
        r0 = ((java.lang.Integer) r4.f15681a.a(com.applovin.impl.sdk.c.b.cJ)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008a, code lost:
        if (r5.k() <= r0) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0090, code lost:
        if (com.applovin.impl.sdk.v.a() == false) goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0092, code lost:
        r6 = r4.f15682b;
        r6.d("PersistentPostbackManager", "Exceeded maximum persisted attempt count of " + r0 + ". Dequeuing postback: " + r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b2, code lost:
        d(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b7, code lost:
        r1 = r4.f15686f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b9, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r4.f15690j.add(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00bf, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c4, code lost:
        if (r5.f() == null) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c6, code lost:
        r0 = new org.json.JSONObject(r5.f());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00d0, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d1, code lost:
        r4.f15681a.X().dispatchPostbackRequest(com.applovin.impl.sdk.network.i.b(r4.f15681a).d(r5.b()).e(r5.c()).c(r5.d()).f(r5.a()).d(r5.e()).b(r0).f(r5.h()).e(r5.g()).g(r5.i()).g(r5.j()).b(), new com.applovin.impl.sdk.network.f.AnonymousClass2(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(final com.applovin.impl.sdk.network.h r5, final com.applovin.sdk.AppLovinPostbackListener r6) {
        /*
            r4 = this;
            boolean r0 = com.applovin.impl.sdk.v.a()
            if (r0 == 0) goto L_0x001e
            com.applovin.impl.sdk.v r0 = r4.f15682b
            java.lang.String r1 = "PersistentPostbackManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Preparing to submit postback..."
            r2.append(r3)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r0.b(r1, r2)
        L_0x001e:
            com.applovin.impl.sdk.m r0 = r4.f15681a
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x0036
            boolean r5 = com.applovin.impl.sdk.v.a()
            if (r5 == 0) goto L_0x0035
            com.applovin.impl.sdk.v r5 = r4.f15682b
            java.lang.String r6 = "PersistentPostbackManager"
            java.lang.String r0 = "Skipping postback dispatch because SDK is still initializing - postback will be dispatched afterwards"
            r5.b(r6, r0)
        L_0x0035:
            return
        L_0x0036:
            java.lang.Object r0 = r4.f15686f
            monitor-enter(r0)
            java.util.Set<com.applovin.impl.sdk.network.h> r1 = r4.f15690j     // Catch:{ all -> 0x0139 }
            boolean r1 = r1.contains(r5)     // Catch:{ all -> 0x0139 }
            if (r1 == 0) goto L_0x0065
            boolean r6 = com.applovin.impl.sdk.v.a()     // Catch:{ all -> 0x0139 }
            if (r6 == 0) goto L_0x0063
            com.applovin.impl.sdk.v r6 = r4.f15682b     // Catch:{ all -> 0x0139 }
            java.lang.String r1 = "PersistentPostbackManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0139 }
            r2.<init>()     // Catch:{ all -> 0x0139 }
            java.lang.String r3 = "Skip pending postback: "
            r2.append(r3)     // Catch:{ all -> 0x0139 }
            java.lang.String r5 = r5.b()     // Catch:{ all -> 0x0139 }
            r2.append(r5)     // Catch:{ all -> 0x0139 }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x0139 }
            r6.b(r1, r5)     // Catch:{ all -> 0x0139 }
        L_0x0063:
            monitor-exit(r0)     // Catch:{ all -> 0x0139 }
            return
        L_0x0065:
            r5.l()     // Catch:{ all -> 0x0139 }
            com.applovin.impl.sdk.m r1 = r4.f15681a     // Catch:{ all -> 0x0139 }
            com.applovin.impl.sdk.r r1 = r1.aa()     // Catch:{ all -> 0x0139 }
            if (r1 == 0) goto L_0x0074
            r4.f()     // Catch:{ all -> 0x0139 }
            goto L_0x0077
        L_0x0074:
            r4.e()     // Catch:{ all -> 0x0139 }
        L_0x0077:
            monitor-exit(r0)     // Catch:{ all -> 0x0139 }
            com.applovin.impl.sdk.m r0 = r4.f15681a
            com.applovin.impl.sdk.c.b<java.lang.Integer> r1 = com.applovin.impl.sdk.c.b.cJ
            java.lang.Object r0 = r0.a(r1)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            int r1 = r5.k()
            if (r1 <= r0) goto L_0x00b7
            boolean r6 = com.applovin.impl.sdk.v.a()
            if (r6 == 0) goto L_0x00b2
            com.applovin.impl.sdk.v r6 = r4.f15682b
            java.lang.String r1 = "PersistentPostbackManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Exceeded maximum persisted attempt count of "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = ". Dequeuing postback: "
            r2.append(r0)
            r2.append(r5)
            java.lang.String r0 = r2.toString()
            r6.d(r1, r0)
        L_0x00b2:
            r4.d((com.applovin.impl.sdk.network.h) r5)
            goto L_0x0135
        L_0x00b7:
            java.lang.Object r1 = r4.f15686f
            monitor-enter(r1)
            java.util.Set<com.applovin.impl.sdk.network.h> r0 = r4.f15690j     // Catch:{ all -> 0x0136 }
            r0.add(r5)     // Catch:{ all -> 0x0136 }
            monitor-exit(r1)     // Catch:{ all -> 0x0136 }
            java.util.Map r0 = r5.f()
            if (r0 == 0) goto L_0x00d0
            org.json.JSONObject r0 = new org.json.JSONObject
            java.util.Map r1 = r5.f()
            r0.<init>(r1)
            goto L_0x00d1
        L_0x00d0:
            r0 = 0
        L_0x00d1:
            com.applovin.impl.sdk.m r1 = r4.f15681a
            com.applovin.impl.sdk.network.i$a r1 = com.applovin.impl.sdk.network.i.b(r1)
            java.lang.String r2 = r5.b()
            com.applovin.impl.sdk.network.i$a r1 = r1.a((java.lang.String) r2)
            java.lang.String r2 = r5.c()
            com.applovin.impl.sdk.network.i$a r1 = r1.c((java.lang.String) r2)
            java.util.Map r2 = r5.d()
            com.applovin.impl.sdk.network.i$a r1 = r1.a((java.util.Map<java.lang.String, java.lang.String>) r2)
            java.lang.String r2 = r5.a()
            com.applovin.impl.sdk.network.i$a r1 = r1.b((java.lang.String) r2)
            java.util.Map r2 = r5.e()
            com.applovin.impl.sdk.network.i$a r1 = r1.b((java.util.Map<java.lang.String, java.lang.String>) r2)
            com.applovin.impl.sdk.network.i$a r0 = r1.a((org.json.JSONObject) r0)
            boolean r1 = r5.h()
            com.applovin.impl.sdk.network.i$a r0 = r0.d((boolean) r1)
            boolean r1 = r5.g()
            com.applovin.impl.sdk.network.i$a r0 = r0.c((boolean) r1)
            boolean r1 = r5.i()
            com.applovin.impl.sdk.network.i$a r0 = r0.g((boolean) r1)
            java.lang.String r1 = r5.j()
            com.applovin.impl.sdk.network.i$a r0 = r0.g((java.lang.String) r1)
            com.applovin.impl.sdk.network.i r0 = r0.a()
            com.applovin.impl.sdk.m r1 = r4.f15681a
            com.applovin.impl.sdk.network.PostbackServiceImpl r1 = r1.X()
            com.applovin.impl.sdk.network.f$2 r2 = new com.applovin.impl.sdk.network.f$2
            r2.<init>(r5, r6)
            r1.dispatchPostbackRequest(r0, r2)
        L_0x0135:
            return
        L_0x0136:
            r5 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0136 }
            throw r5
        L_0x0139:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0139 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.network.f.a(com.applovin.impl.sdk.network.h, com.applovin.sdk.AppLovinPostbackListener):void");
    }

    /* access modifiers changed from: private */
    public void b(h hVar) {
        synchronized (this.f15686f) {
            if (this.f15681a.aa() != null) {
                this.f15687g.add(hVar);
                f();
            } else {
                while (this.f15687g.size() > this.f15683c) {
                    this.f15687g.remove(0);
                }
                this.f15687g.add(hVar);
                e();
            }
            if (v.a()) {
                v vVar = this.f15682b;
                vVar.b("PersistentPostbackManager", "Enqueued postback: " + hVar);
            }
        }
    }

    /* access modifiers changed from: private */
    public void c(h hVar) {
        a(hVar, (AppLovinPostbackListener) null);
    }

    private ArrayList<h> d() {
        Set<String> set = (Set) this.f15681a.b(d.f15230p, new LinkedHashSet(0), this.f15685e);
        ArrayList<h> arrayList = new ArrayList<>(Math.max(1, set.size()));
        int intValue = ((Integer) this.f15681a.a(b.cJ)).intValue();
        v vVar = this.f15682b;
        vVar.b("PersistentPostbackManager", "Deserializing " + set.size() + " postback(s).");
        for (String str : set) {
            try {
                h hVar = new h(new JSONObject(str), this.f15681a);
                if (hVar.k() < intValue) {
                    arrayList.add(hVar);
                } else if (v.a(this.f15681a)) {
                    v vVar2 = this.f15682b;
                    vVar2.b("PersistentPostbackManager", "Skipping deserialization because maximum attempt count exceeded for postback: " + hVar);
                }
            } catch (Throwable th) {
                if (v.a(this.f15681a)) {
                    v vVar3 = this.f15682b;
                    vVar3.b("PersistentPostbackManager", "Unable to deserialize postback request from json: " + str, th);
                }
            }
        }
        if (v.a(this.f15681a)) {
            v vVar4 = this.f15682b;
            vVar4.b("PersistentPostbackManager", "Successfully loaded postback queue with " + arrayList.size() + " postback(s).");
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void d(h hVar) {
        synchronized (this.f15686f) {
            this.f15690j.remove(hVar);
            this.f15687g.remove(hVar);
            if (this.f15681a.aa() != null) {
                f();
            } else {
                e();
            }
        }
        if (v.a()) {
            v vVar = this.f15682b;
            vVar.b("PersistentPostbackManager", "Dequeued successfully transmitted postback: " + hVar);
        }
    }

    private void e() {
        this.f15689i = System.currentTimeMillis();
    }

    /* access modifiers changed from: private */
    public void e(h hVar) {
        synchronized (this.f15686f) {
            this.f15690j.remove(hVar);
            this.f15688h.add(hVar);
        }
    }

    private void f() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(this.f15687g.size());
        Iterator<h> it2 = this.f15687g.iterator();
        while (it2.hasNext()) {
            try {
                linkedHashSet.add(it2.next().n().toString());
            } catch (Throwable th) {
                this.f15682b.b("PersistentPostbackManager", "Unable to serialize postback request to JSON.", th);
            }
        }
        this.f15681a.a(d.f15230p, linkedHashSet, this.f15685e);
        this.f15682b.b("PersistentPostbackManager", "Wrote updated postback queue to disk.");
    }

    /* access modifiers changed from: private */
    public void g() {
        synchronized (this.f15686f) {
            Iterator<h> it2 = this.f15688h.iterator();
            while (it2.hasNext()) {
                c(it2.next());
            }
            this.f15688h.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public long a() {
        return this.f15689i;
    }

    public void a(h hVar) {
        a(hVar, true);
    }

    public void a(h hVar, boolean z2) {
        a(hVar, z2, (AppLovinPostbackListener) null);
    }

    public void a(final h hVar, boolean z2, final AppLovinPostbackListener appLovinPostbackListener) {
        if (StringUtils.isValidString(hVar.b())) {
            if (z2) {
                hVar.m();
            }
            AnonymousClass1 r3 = new Runnable() {
                public void run() {
                    synchronized (f.this.f15686f) {
                        f.this.b(hVar);
                        f.this.a(hVar, appLovinPostbackListener);
                    }
                }
            };
            if (Utils.isMainThread()) {
                this.f15681a.S().a((a) new z(this.f15681a, r3), o.a.POSTBACKS);
                return;
            }
            r3.run();
        }
    }

    /* access modifiers changed from: package-private */
    public List<h> b() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f15686f) {
            arrayList.ensureCapacity(this.f15687g.size());
            arrayList.addAll(this.f15687g);
        }
        return arrayList;
    }

    public void c() {
        AnonymousClass3 r02 = new Runnable() {
            public void run() {
                synchronized (f.this.f15686f) {
                    if (f.this.f15687g != null) {
                        for (h d2 : new ArrayList(f.this.f15687g)) {
                            f.this.c(d2);
                        }
                    }
                }
            }
        };
        if (((Boolean) this.f15681a.a(b.cK)).booleanValue()) {
            this.f15681a.S().a((a) new z(this.f15681a, r02), o.a.POSTBACKS);
            return;
        }
        r02.run();
    }
}
