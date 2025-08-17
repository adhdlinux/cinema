package com.chartboost.sdk.impl;

import android.content.Context;
import b0.s;
import com.chartboost.sdk.impl.dd;
import com.chartboost.sdk.impl.id;
import com.chartboost.sdk.internal.Model.CBError;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class gd implements id.a, dd {

    /* renamed from: a  reason: collision with root package name */
    public final q2 f17769a;

    /* renamed from: b  reason: collision with root package name */
    public final vc f17770b;

    /* renamed from: c  reason: collision with root package name */
    public final r2 f17771c;

    /* renamed from: d  reason: collision with root package name */
    public final v5 f17772d;

    /* renamed from: e  reason: collision with root package name */
    public final cb f17773e;

    /* renamed from: f  reason: collision with root package name */
    public final ScheduledExecutorService f17774f;

    /* renamed from: g  reason: collision with root package name */
    public final Queue f17775g = new ConcurrentLinkedQueue();

    /* renamed from: h  reason: collision with root package name */
    public final ConcurrentLinkedQueue f17776h = new ConcurrentLinkedQueue();

    /* renamed from: i  reason: collision with root package name */
    public final ConcurrentHashMap f17777i = new ConcurrentHashMap();

    /* renamed from: j  reason: collision with root package name */
    public final ConcurrentHashMap f17778j = new ConcurrentHashMap();

    /* renamed from: k  reason: collision with root package name */
    public AtomicInteger f17779k = new AtomicInteger(1);

    /* renamed from: l  reason: collision with root package name */
    public final Runnable f17780l = new s(this);

    public enum a {
        CAN_NOT_DOWNLOAD,
        CREATE_ASSET_AND_DOWNLOAD,
        BRING_TO_FRONT_QUEUE_AND_DOWNLOAD
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f17785a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.chartboost.sdk.impl.gd$a[] r0 = com.chartboost.sdk.impl.gd.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.chartboost.sdk.impl.gd$a r1 = com.chartboost.sdk.impl.gd.a.CAN_NOT_DOWNLOAD     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.chartboost.sdk.impl.gd$a r1 = com.chartboost.sdk.impl.gd.a.CREATE_ASSET_AND_DOWNLOAD     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.chartboost.sdk.impl.gd$a r1 = com.chartboost.sdk.impl.gd.a.BRING_TO_FRONT_QUEUE_AND_DOWNLOAD     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f17785a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.gd.b.<clinit>():void");
        }
    }

    public static final class c implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return ComparisonsKt__ComparisonsKt.a(Long.valueOf(((rc) obj).a()), Long.valueOf(((rc) obj2).a()));
        }
    }

    public gd(q2 q2Var, vc vcVar, r2 r2Var, v5 v5Var, cb cbVar, ScheduledExecutorService scheduledExecutorService) {
        Intrinsics.f(q2Var, "networkRequestService");
        Intrinsics.f(vcVar, "policy");
        Intrinsics.f(cbVar, "tempHelper");
        Intrinsics.f(scheduledExecutorService, "backgroundExecutor");
        this.f17769a = q2Var;
        this.f17770b = vcVar;
        this.f17771c = r2Var;
        this.f17772d = v5Var;
        this.f17773e = cbVar;
        this.f17774f = scheduledExecutorService;
    }

    public void a(Context context) {
        File[] d2;
        Intrinsics.f(context, "context");
        v5 v5Var = this.f17772d;
        if (v5Var != null && (d2 = v5Var.d()) != null) {
            Intrinsics.e(d2, "precacheFiles");
            int length = d2.length;
            boolean z2 = false;
            int i2 = 0;
            while (i2 < length) {
                File file = d2[i2];
                if (file.exists()) {
                    String name = file.getName();
                    Intrinsics.e(name, "file.name");
                    if (StringsKt__StringsKt.L(name, DefaultDiskStorage.FileType.TEMP, z2, 2, (Object) null)) {
                        v5Var.a(file);
                        return;
                    }
                }
                vc vcVar = this.f17770b;
                Intrinsics.e(file, "file");
                if (vcVar.a(file)) {
                    v5Var.a(file);
                } else {
                    String name2 = file.getName();
                    Intrinsics.e(name2, "file.name");
                    rc rcVar = r6;
                    rc rcVar2 = new rc("", name2, file, v5Var.c(), file.lastModified(), (String) null, file.length(), 32, (DefaultConstructorMarker) null);
                    ConcurrentHashMap concurrentHashMap = this.f17778j;
                    String name3 = file.getName();
                    Intrinsics.e(name3, "file.name");
                    concurrentHashMap.put(name3, rcVar);
                }
                i2++;
                z2 = false;
            }
        }
    }

    public rc b(String str) {
        Intrinsics.f(str, "filename");
        return (rc) this.f17778j.get(str);
    }

    public final boolean c() {
        r2 r2Var = this.f17771c;
        return r2Var != null && r2Var.e() && !this.f17770b.g() && this.f17776h.isEmpty();
    }

    public final rc d(String str) {
        Object obj;
        if (str == null) {
            obj = this.f17775g.poll();
        } else {
            rc rcVar = null;
            for (rc rcVar2 : this.f17775g) {
                if (Intrinsics.a(rcVar2.d(), str)) {
                    rcVar = rcVar2;
                }
            }
            obj = rcVar;
        }
        rc rcVar3 = (rc) obj;
        if (rcVar3 != null) {
            c(rcVar3);
        }
        return rcVar3;
    }

    public final boolean e(rc rcVar) {
        v5 v5Var;
        if (rcVar == null || rcVar.e() == null || (v5Var = this.f17772d) == null) {
            return false;
        }
        return v5Var.c(rcVar.e());
    }

    public final boolean f(rc rcVar) {
        return this.f17773e.b(rcVar.b(), rcVar.d());
    }

    public boolean g(rc rcVar) {
        if (rcVar == null || !e(rcVar)) {
            return false;
        }
        File e2 = rcVar.e();
        String d2 = rcVar.d();
        v5 v5Var = this.f17772d;
        if (v5Var == null || !v5Var.a(e2)) {
            return false;
        }
        this.f17778j.remove(d2);
        return true;
    }

    public final void h(rc rcVar) {
        String a2 = hd.f17875a;
        Intrinsics.e(a2, "TAG");
        w7.a(a2, "startDownloadNow: " + rcVar.g());
        if (a(rcVar.d())) {
            la.a("File already downloaded or downloading: " + rcVar.d());
            String g2 = rcVar.g();
            n0 n0Var = (n0) this.f17777i.remove(g2);
            if (n0Var != null) {
                n0Var.a(g2);
                return;
            }
            return;
        }
        la.a("Start downloading " + rcVar.g());
        this.f17770b.a();
        this.f17776h.add(rcVar.g());
        r2 r2Var = this.f17771c;
        File e2 = rcVar.e();
        Intrinsics.c(e2);
        String g3 = rcVar.g();
        i9 i9Var = i9.NORMAL;
        String a3 = this.f17769a.a();
        Intrinsics.e(a3, "networkRequestService.appId");
        this.f17769a.a(new id(r2Var, e2, g3, this, i9Var, a3));
    }

    public final boolean b() {
        v5 v5Var = this.f17772d;
        if (v5Var == null) {
            return false;
        }
        return this.f17770b.b(v5Var.b(v5Var.c()));
    }

    public final void c(rc rcVar) {
        if (la.f18112a.g()) {
            File file = new File(rcVar.f());
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public final void b(rc rcVar) {
        if (la.f18112a.g()) {
            File file = new File(rcVar.f());
            try {
                file.createNewFile();
                file.setLastModified(ab.a());
            } catch (IOException e2) {
                String a2 = hd.f17875a;
                Intrinsics.e(a2, "TAG");
                w7.e(a2, "Error while creating queue empty file: " + e2);
            }
        }
    }

    public final File d(rc rcVar) {
        return this.f17773e.a(rcVar.b(), rcVar.d());
    }

    public final void c(String str) {
        for (rc rcVar : new LinkedList(this.f17775g)) {
            if (rcVar != null && Intrinsics.a(rcVar.g(), str)) {
                this.f17775g.remove(rcVar);
            }
        }
    }

    public final boolean b(String str, String str2) {
        if (this.f17775g.size() <= 0) {
            return false;
        }
        for (rc rcVar : this.f17775g) {
            if (Intrinsics.a(rcVar.g(), str) && Intrinsics.a(rcVar.d(), str2)) {
                return true;
            }
        }
        return false;
    }

    public synchronized void a(String str, String str2, boolean z2, n0 n0Var) {
        Intrinsics.f(str, ImagesContract.URL);
        Intrinsics.f(str2, "filename");
        String a2 = hd.f17875a;
        Intrinsics.e(a2, "TAG");
        w7.a(a2, "downloadVideoFile: " + str);
        v5 v5Var = this.f17772d;
        File c2 = v5Var != null ? v5Var.c() : null;
        v5 v5Var2 = this.f17772d;
        int i2 = b.f17785a[a(str, str2, z2, n0Var, a(str2), v5Var2 != null ? v5Var2.a(c2, str2) : null).ordinal()];
        if (i2 == 2) {
            a(str, str2, new File(c2, str2), c2);
            if (!z2) {
                str2 = null;
            }
            a(str2, this.f17779k.get(), z2);
        } else if (i2 == 3) {
            dd.a.a(this, str2, 0, true, 2, (Object) null);
        }
    }

    public final a a(String str, String str2, boolean z2, n0 n0Var, boolean z3, File file) {
        if (z2) {
            if (z3) {
                long j2 = 0;
                if (this.f17777i.containsKey(str)) {
                    String a2 = hd.f17875a;
                    Intrinsics.e(a2, "TAG");
                    w7.a(a2, "Already downloading for show operation: " + str2);
                    la.a("Already downloading for show operation: " + str2);
                    if (file != null) {
                        j2 = file.length();
                    }
                    a(str, str2, j2, n0Var);
                    return a.CAN_NOT_DOWNLOAD;
                } else if (n0Var != null) {
                    String a3 = hd.f17875a;
                    Intrinsics.e(a3, "TAG");
                    w7.a(a3, "Register callback for show operation: " + str2);
                    la.a("Register callback for show operation: " + str2);
                    if (file != null) {
                        j2 = file.length();
                    }
                    a(str, str2, j2, n0Var);
                    return a.CAN_NOT_DOWNLOAD;
                }
            } else {
                String a4 = hd.f17875a;
                Intrinsics.e(a4, "TAG");
                w7.a(a4, "Not downloading for show operation: " + str2);
                if (n0Var != null) {
                    rc rcVar = (rc) this.f17778j.get(str2);
                    if (Intrinsics.a(rcVar != null ? rcVar.d() : null, str2) || this.f17777i.containsKey(str)) {
                        this.f17777i.put(str, n0Var);
                        return a.BRING_TO_FRONT_QUEUE_AND_DOWNLOAD;
                    }
                }
            }
            if (n0Var != null) {
                String a5 = hd.f17875a;
                Intrinsics.e(a5, "TAG");
                w7.a(a5, "Register callback for show operation: " + str2);
                la.a("Register callback for show operation: " + str2);
                this.f17777i.put(str, n0Var);
            }
        } else if (b(str, str2) || z3) {
            String a6 = hd.f17875a;
            Intrinsics.e(a6, "TAG");
            w7.a(a6, "Already queued or downloading for cache operation: " + str2);
            la.a("Already queued or downloading for cache operation: " + str2);
            return a.CAN_NOT_DOWNLOAD;
        }
        return a.CREATE_ASSET_AND_DOWNLOAD;
    }

    public void a(String str, int i2, boolean z2) {
        String a2 = hd.f17875a;
        Intrinsics.e(a2, "TAG");
        w7.a(a2, "startDownloadIfPossible: " + str);
        if (this.f17775g.size() <= 0) {
            return;
        }
        if (z2 || c()) {
            rc d2 = d(str);
            if (d2 != null) {
                h(d2);
                return;
            }
            return;
        }
        la.a("Can't cache next video at the moment");
        this.f17774f.schedule(this.f17780l, ((long) i2) * 5000, TimeUnit.MILLISECONDS);
    }

    public boolean a(String str) {
        Intrinsics.f(str, "videoFilename");
        rc b2 = b(str);
        boolean z2 = b2 != null && f(b2);
        boolean z3 = b2 != null && e(b2);
        if (z2 || z3) {
            return true;
        }
        return false;
    }

    public int a(rc rcVar) {
        if (rcVar == null) {
            return 0;
        }
        if (e(rcVar)) {
            return 5;
        }
        File d2 = d(rcVar);
        long length = d2 != null ? d2.length() : 0;
        if (rcVar.c() == 0) {
            return 0;
        }
        return ba.a(((float) length) / ((float) rcVar.c()));
    }

    public final void a() {
        if (b()) {
            Collection values = this.f17778j.values();
            Intrinsics.e(values, "videoMap.values");
            for (rc g2 : CollectionsKt___CollectionsKt.T(values, new c())) {
                g(g2);
                if (!b()) {
                    return;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0010, code lost:
        r2 = r2.e();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r16, java.lang.String r17, java.io.File r18, java.io.File r19) {
        /*
            r15 = this;
            r0 = r15
            r13 = r17
            com.chartboost.sdk.impl.rc r14 = new com.chartboost.sdk.impl.rc
            r6 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            com.chartboost.sdk.impl.v5 r2 = r0.f17772d
            if (r2 == 0) goto L_0x001b
            java.io.File r2 = r2.e()
            if (r2 == 0) goto L_0x001b
            java.lang.String r2 = r2.getAbsolutePath()
            goto L_0x001c
        L_0x001b:
            r2 = 0
        L_0x001c:
            r1.append(r2)
            java.lang.String r2 = java.io.File.separator
            r1.append(r2)
            r1.append(r13)
            java.lang.String r8 = r1.toString()
            r9 = 0
            r11 = 80
            r12 = 0
            r1 = r14
            r2 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r1.<init>(r2, r3, r4, r5, r6, r8, r9, r11, r12)
            long r1 = r14.a()
            r3 = r18
            r3.setLastModified(r1)
            r15.b((com.chartboost.sdk.impl.rc) r14)
            java.util.concurrent.ConcurrentHashMap r1 = r0.f17778j
            r1.putIfAbsent(r13, r14)
            java.util.Queue r1 = r0.f17775g
            r1.offer(r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.gd.a(java.lang.String, java.lang.String, java.io.File, java.io.File):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: com.chartboost.sdk.impl.n0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r5, java.lang.String r6, long r7, com.chartboost.sdk.impl.n0 r9) {
        /*
            r4 = this;
            java.lang.String r0 = "url"
            kotlin.jvm.internal.Intrinsics.f(r5, r0)
            java.lang.String r0 = "videoFileName"
            kotlin.jvm.internal.Intrinsics.f(r6, r0)
            java.lang.String r0 = com.chartboost.sdk.impl.hd.f17875a
            java.lang.String r1 = "TAG"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "tempFileIsReady: "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            com.chartboost.sdk.impl.w7.a(r0, r1)
            com.chartboost.sdk.impl.rc r0 = r4.b((java.lang.String) r6)
            r1 = 0
            int r3 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0037
            if (r0 != 0) goto L_0x0034
            goto L_0x0037
        L_0x0034:
            r0.a(r7)
        L_0x0037:
            if (r0 == 0) goto L_0x0046
            java.util.concurrent.ConcurrentHashMap r7 = r4.f17778j
            r7.remove(r6)
            java.util.concurrent.ConcurrentHashMap r7 = r4.f17778j
            java.lang.Object r6 = r7.putIfAbsent(r6, r0)
            com.chartboost.sdk.impl.rc r6 = (com.chartboost.sdk.impl.rc) r6
        L_0x0046:
            if (r9 != 0) goto L_0x0051
            java.util.concurrent.ConcurrentHashMap r6 = r4.f17777i
            java.lang.Object r6 = r6.get(r5)
            r9 = r6
            com.chartboost.sdk.impl.n0 r9 = (com.chartboost.sdk.impl.n0) r9
        L_0x0051:
            if (r9 == 0) goto L_0x0056
            r9.a(r5)
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.gd.a(java.lang.String, java.lang.String, long, com.chartboost.sdk.impl.n0):void");
    }

    public void a(String str, String str2) {
        Intrinsics.f(str, "uri");
        Intrinsics.f(str2, "videoFileName");
        String a2 = hd.f17875a;
        Intrinsics.e(a2, "TAG");
        w7.a(a2, "onSuccess: " + str);
        la.a("Video downloaded success " + str);
        a();
        this.f17776h.remove(str);
        this.f17777i.remove(str);
        this.f17779k = new AtomicInteger(1);
        c(str);
        a((String) null, this.f17779k.get(), false);
    }

    public void a(String str, String str2, CBError cBError) {
        String str3;
        Unit unit;
        File e2;
        Intrinsics.f(str, "uri");
        Intrinsics.f(str2, "videoFileName");
        String a2 = hd.f17875a;
        Intrinsics.e(a2, "TAG");
        w7.a(a2, "onError: " + str);
        if (cBError == null || (str3 = cBError.getErrorDesc()) == null) {
            str3 = "Unknown error";
        }
        rc b2 = b(str2);
        if (!(b2 == null || (e2 = b2.e()) == null)) {
            e2.delete();
        }
        if (cBError == null || cBError.getError() != CBError.a.INTERNET_UNAVAILABLE) {
            c(str);
            n0 n0Var = (n0) this.f17777i.get(str);
            if (n0Var != null) {
                n0Var.a(str);
                unit = Unit.f40298a;
            } else {
                unit = null;
            }
            if (unit == null) {
                String a3 = hd.f17875a;
                Intrinsics.e(a3, "TAG");
                w7.b(a3, "Missing callback on error");
            }
        } else if (b2 != null) {
            this.f17775g.add(b2);
            b(b2);
        }
        this.f17777i.remove(str);
        this.f17778j.remove(str2);
        a((String) null, this.f17779k.get(), false);
        String a4 = hd.f17875a;
        Intrinsics.e(a4, "TAG");
        w7.c(a4, "Video download failed: " + str + " with error " + str3);
        la.a("Video downloaded failed " + str + " with error " + str3);
        this.f17776h.remove(str);
    }

    public static final void a(gd gdVar) {
        Intrinsics.f(gdVar, "this$0");
        gdVar.a((String) null, gdVar.f17779k.incrementAndGet(), false);
    }
}
