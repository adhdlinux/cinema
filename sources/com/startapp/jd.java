package com.startapp;

import android.content.Context;

public abstract class jd<T> extends dd<T> {

    /* renamed from: e  reason: collision with root package name */
    public final x6 f34769e;

    /* renamed from: f  reason: collision with root package name */
    public final va f34770f;

    /* renamed from: g  reason: collision with root package name */
    public final String f34771g;

    /* renamed from: h  reason: collision with root package name */
    public final String f34772h;

    /* renamed from: i  reason: collision with root package name */
    public final Runnable f34773i = new a();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            jd.this.g();
        }
    }

    public jd(Context context, x6 x6Var, va vaVar, String str, String str2) {
        super(context, 1000);
        this.f34769e = x6Var;
        this.f34770f = vaVar;
        this.f34771g = str;
        this.f34772h = str2;
    }

    public final T a() {
        T a2;
        if (!f()) {
            return null;
        }
        synchronized (this) {
            a2 = a(this.f34769e.getString(this.f34771g, (String) null));
        }
        return a2;
    }

    public abstract T a(String str);

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public synchronized void b(T r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 == 0) goto L_0x0020
            com.startapp.x6 r0 = r4.f34769e     // Catch:{ all -> 0x0046 }
            com.startapp.x6$a r0 = r0.edit()     // Catch:{ all -> 0x0046 }
            java.lang.String r1 = r4.f34771g     // Catch:{ all -> 0x0046 }
            java.lang.String r5 = r4.c(r5)     // Catch:{ all -> 0x0046 }
            com.startapp.x6$a r5 = r0.a((java.lang.String) r1, (java.lang.String) r5)     // Catch:{ all -> 0x0046 }
            java.lang.String r0 = r4.f34772h     // Catch:{ all -> 0x0046 }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0046 }
            com.startapp.x6$a r5 = r5.a((java.lang.String) r0, (long) r1)     // Catch:{ all -> 0x0046 }
            r5.apply()     // Catch:{ all -> 0x0046 }
        L_0x0020:
            long r0 = r4.d()     // Catch:{ all -> 0x0046 }
            r2 = 60000(0xea60, double:2.9644E-319)
            long r0 = java.lang.Math.max(r2, r0)     // Catch:{ all -> 0x0046 }
            monitor-enter(r4)     // Catch:{ all -> 0x0046 }
            boolean r5 = r4.f()     // Catch:{ all -> 0x0043 }
            if (r5 == 0) goto L_0x0040
            com.startapp.va r5 = r4.f34770f     // Catch:{ all -> 0x0043 }
            java.lang.Runnable r2 = r4.f34773i     // Catch:{ all -> 0x0043 }
            r5.a(r2)     // Catch:{ all -> 0x0043 }
            com.startapp.va r5 = r4.f34770f     // Catch:{ all -> 0x0043 }
            java.lang.Runnable r2 = r4.f34773i     // Catch:{ all -> 0x0043 }
            r5.a(r2, r0)     // Catch:{ all -> 0x0043 }
        L_0x0040:
            monitor-exit(r4)     // Catch:{ all -> 0x0046 }
            monitor-exit(r4)
            return
        L_0x0043:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0046 }
            throw r5     // Catch:{ all -> 0x0046 }
        L_0x0046:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.jd.b(java.lang.Object):void");
    }

    public String c(T t2) {
        return t2.toString();
    }

    public abstract long d();

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public synchronized void e() {
        /*
            r8 = this;
            monitor-enter(r8)
            com.startapp.x6 r0 = r8.f34769e     // Catch:{ all -> 0x003b }
            java.lang.String r1 = r8.f34772h     // Catch:{ all -> 0x003b }
            r2 = 0
            long r0 = r0.getLong(r1, r2)     // Catch:{ all -> 0x003b }
            long r4 = r8.d()     // Catch:{ all -> 0x003b }
            r6 = 60000(0xea60, double:2.9644E-319)
            long r4 = java.lang.Math.max(r6, r4)     // Catch:{ all -> 0x003b }
            long r0 = r0 + r4
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x003b }
            long r0 = r0 - r4
            long r0 = java.lang.Math.max(r2, r0)     // Catch:{ all -> 0x003b }
            monitor-enter(r8)     // Catch:{ all -> 0x003b }
            boolean r2 = r8.f()     // Catch:{ all -> 0x0038 }
            if (r2 == 0) goto L_0x0035
            com.startapp.va r2 = r8.f34770f     // Catch:{ all -> 0x0038 }
            java.lang.Runnable r3 = r8.f34773i     // Catch:{ all -> 0x0038 }
            r2.a(r3)     // Catch:{ all -> 0x0038 }
            com.startapp.va r2 = r8.f34770f     // Catch:{ all -> 0x0038 }
            java.lang.Runnable r3 = r8.f34773i     // Catch:{ all -> 0x0038 }
            r2.a(r3, r0)     // Catch:{ all -> 0x0038 }
        L_0x0035:
            monitor-exit(r8)     // Catch:{ all -> 0x003b }
            monitor-exit(r8)
            return
        L_0x0038:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x003b }
            throw r0     // Catch:{ all -> 0x003b }
        L_0x003b:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.jd.e():void");
    }

    public abstract boolean f();

    public abstract void g();
}
