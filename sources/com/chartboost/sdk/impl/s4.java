package com.chartboost.sdk.impl;

import com.chartboost.sdk.internal.Libraries.CBUtility;
import com.facebook.cache.disk.DefaultDiskStorage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class s4 {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f18548a;

    /* renamed from: b  reason: collision with root package name */
    public final q2 f18549b;

    /* renamed from: c  reason: collision with root package name */
    public final r2 f18550c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference f18551d;

    /* renamed from: e  reason: collision with root package name */
    public final gb f18552e;

    /* renamed from: f  reason: collision with root package name */
    public final v5 f18553f;

    /* renamed from: g  reason: collision with root package name */
    public int f18554g = 1;

    /* renamed from: h  reason: collision with root package name */
    public l1 f18555h = null;

    /* renamed from: i  reason: collision with root package name */
    public final PriorityQueue f18556i;

    /* renamed from: j  reason: collision with root package name */
    public final z4 f18557j;

    public class a implements Comparator {
        public a() {
        }

        /* renamed from: a */
        public int compare(File file, File file2) {
            return Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file2.lastModified()));
        }
    }

    public s4(Executor executor, v5 v5Var, q2 q2Var, r2 r2Var, AtomicReference atomicReference, gb gbVar, z4 z4Var) {
        this.f18548a = executor;
        this.f18553f = v5Var;
        this.f18549b = q2Var;
        this.f18550c = r2Var;
        this.f18551d = atomicReference;
        this.f18552e = gbVar;
        this.f18557j = z4Var;
        this.f18556i = new PriorityQueue();
    }

    public synchronized void a(i9 i9Var, Map map, AtomicInteger atomicInteger, g1 g1Var, String str) {
        synchronized (this) {
            long b2 = this.f18552e.b();
            AtomicInteger atomicInteger2 = new AtomicInteger();
            AtomicReference atomicReference = new AtomicReference(g1Var);
            for (f1 f1Var : map.values()) {
                long j2 = b2;
                long j3 = b2;
                k1 k1Var = r2;
                k1 k1Var2 = new k1(this.f18552e, i9Var, f1Var.f17672b, f1Var.f17673c, f1Var.f17671a, atomicInteger, atomicReference, j2, atomicInteger2, str);
                this.f18556i.add(k1Var);
                atomicReference = atomicReference;
                b2 = j3;
            }
            int i2 = this.f18554g;
            if (i2 == 1 || i2 == 2) {
                d();
            }
        }
    }

    public synchronized void b() {
        boolean z2;
        String str;
        boolean z3;
        boolean z4;
        synchronized (this) {
            if (this.f18554g == 1) {
                try {
                    w7.a("Downloader", "########### Trimming the disk cache");
                    File file = this.f18553f.a().f18887a;
                    ArrayList arrayList = new ArrayList();
                    String[] list = file.list();
                    if (list != null && list.length > 0) {
                        for (String str2 : list) {
                            if (!str2.equalsIgnoreCase("requests") && !str2.equalsIgnoreCase("track") && !str2.equalsIgnoreCase("session") && !str2.equalsIgnoreCase("videoCompletionEvents") && !str2.equalsIgnoreCase("precache")) {
                                if (!str2.contains(".")) {
                                    arrayList.addAll(CBUtility.a(new File(file, str2), true));
                                }
                            }
                        }
                    }
                    int size = arrayList.size();
                    File[] fileArr = new File[size];
                    arrayList.toArray(fileArr);
                    if (size > 1) {
                        Arrays.sort(fileArr, new a());
                    }
                    if (size > 0) {
                        pa paVar = (pa) this.f18551d.get();
                        long j2 = (long) paVar.f18369m;
                        v5 v5Var = this.f18553f;
                        long b2 = v5Var.b(v5Var.a().f18893g);
                        long a2 = this.f18552e.a();
                        List list2 = paVar.f18360d;
                        w7.a("Downloader", "Total local file count:" + size);
                        w7.a("Downloader", "Video Folder Size in bytes :" + b2);
                        w7.a("Downloader", "Max Bytes allowed:" + j2);
                        int i2 = 0;
                        while (i2 < size) {
                            File file2 = fileArr[i2];
                            long j3 = j2;
                            pa paVar2 = paVar;
                            if (TimeUnit.MILLISECONDS.toDays(a2 - file2.lastModified()) >= ((long) paVar.f18371o)) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            boolean endsWith = file2.getName().endsWith(DefaultDiskStorage.FileType.TEMP);
                            File parentFile = file2.getParentFile();
                            if (parentFile != null) {
                                str = parentFile.getAbsolutePath();
                            } else {
                                str = null;
                            }
                            if (str != null) {
                                z3 = str.contains("/videos");
                            } else {
                                z3 = false;
                            }
                            if (b2 <= j3 || !z3) {
                                z4 = false;
                            } else {
                                z4 = true;
                            }
                            if (file2.length() == 0 || endsWith || z2 || list2.contains(parentFile.getName()) || z4) {
                                if (z3) {
                                    b2 -= file2.length();
                                }
                                w7.a("Downloader", "Deleting file at path:" + file2.getPath());
                                if (!file2.delete()) {
                                    w7.b("Downloader", "Unable to delete " + file2.getPath());
                                }
                            }
                            i2++;
                            paVar = paVar2;
                            j2 = j3;
                        }
                    }
                    this.f18553f.b();
                } catch (Exception e2) {
                    w7.a("Downloader", "reduceCacheSize", e2);
                }
            } else {
                return;
            }
        }
        return;
    }

    public synchronized void c() {
        int i2 = this.f18554g;
        if (i2 == 3) {
            w7.a("Downloader", "Change state to DOWNLOADING");
            this.f18554g = 2;
        } else if (i2 == 4) {
            w7.a("Downloader", "Change state to IDLE");
            this.f18554g = 1;
            d();
        }
    }

    public final void d() {
        k1 k1Var;
        k1 k1Var2;
        if (this.f18555h != null && (k1Var2 = (k1) this.f18556i.peek()) != null && this.f18555h.f18086m.f18003c.b() > k1Var2.f18003c.b() && this.f18555h.b()) {
            this.f18556i.add(this.f18555h.f18086m);
            this.f18555h = null;
        }
        while (this.f18555h == null && (k1Var = (k1) this.f18556i.poll()) != null) {
            if (k1Var.f18008h.get() > 0) {
                File file = new File(this.f18553f.a().f18887a, k1Var.f18006f);
                if (file.exists() || file.mkdirs() || file.isDirectory()) {
                    File file2 = new File(file, k1Var.f18004d);
                    if (file2.exists()) {
                        this.f18553f.d(file2);
                        k1Var.a(this.f18548a, true);
                    } else {
                        l1 l1Var = new l1(this, this.f18550c, k1Var, file2, this.f18549b.a());
                        this.f18555h = l1Var;
                        this.f18549b.a(l1Var);
                    }
                } else {
                    w7.b("Downloader", "Unable to create directory " + file.getPath());
                    k1Var.a(this.f18548a, false);
                }
            }
        }
        if (this.f18555h != null) {
            if (this.f18554g != 2) {
                w7.a("Downloader", "Change state to DOWNLOADING");
                this.f18554g = 2;
            }
        } else if (this.f18554g != 1) {
            w7.a("Downloader", "Change state to IDLE");
            this.f18554g = 1;
        }
    }

    public synchronized void a(AtomicInteger atomicInteger) {
        atomicInteger.set(-10000);
        if (this.f18554g == 2) {
            l1 l1Var = this.f18555h;
            if (l1Var.f18086m.f18008h == atomicInteger && l1Var.b()) {
                this.f18555h = null;
                d();
            }
        }
    }

    public synchronized void a() {
        int i2 = this.f18554g;
        if (i2 == 1) {
            w7.a("Downloader", "Change state to PAUSED");
            this.f18554g = 4;
        } else if (i2 == 2) {
            if (this.f18555h.b()) {
                this.f18556i.add(this.f18555h.f18086m);
                this.f18555h = null;
                w7.a("Downloader", "Change state to PAUSED");
                this.f18554g = 4;
            } else {
                w7.a("Downloader", "Change state to PAUSING");
                this.f18554g = 3;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ed, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.chartboost.sdk.impl.l1 r10, com.chartboost.sdk.internal.Model.CBError r11, com.chartboost.sdk.impl.p2 r12) {
        /*
            r9 = this;
            monitor-enter(r9)
            int r0 = r9.f18554g     // Catch:{ all -> 0x00ee }
            r1 = 2
            r2 = 3
            if (r0 == r1) goto L_0x000b
            if (r0 == r2) goto L_0x000b
            goto L_0x00ec
        L_0x000b:
            com.chartboost.sdk.impl.l1 r0 = r9.f18555h     // Catch:{ all -> 0x00ee }
            if (r10 == r0) goto L_0x0011
            monitor-exit(r9)
            return
        L_0x0011:
            r0 = 0
            r9.f18555h = r0     // Catch:{ all -> 0x00ee }
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ all -> 0x00ee }
            long r3 = r10.f18094f     // Catch:{ all -> 0x00ee }
            long r0 = r0.toMillis(r3)     // Catch:{ all -> 0x00ee }
            com.chartboost.sdk.impl.k1 r3 = r10.f18086m     // Catch:{ all -> 0x00ee }
            java.util.concurrent.atomic.AtomicInteger r4 = r3.f18011k     // Catch:{ all -> 0x00ee }
            int r1 = (int) r0     // Catch:{ all -> 0x00ee }
            r4.addAndGet(r1)     // Catch:{ all -> 0x00ee }
            java.util.concurrent.Executor r0 = r9.f18548a     // Catch:{ all -> 0x00ee }
            if (r11 != 0) goto L_0x002a
            r1 = 1
            goto L_0x002b
        L_0x002a:
            r1 = 0
        L_0x002b:
            r3.a(r0, r1)     // Catch:{ all -> 0x00ee }
            if (r11 != 0) goto L_0x004a
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ee }
            r10.<init>()     // Catch:{ all -> 0x00ee }
            java.lang.String r11 = "Downloaded "
            r10.append(r11)     // Catch:{ all -> 0x00ee }
            java.lang.String r11 = r3.f18005e     // Catch:{ all -> 0x00ee }
            r10.append(r11)     // Catch:{ all -> 0x00ee }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x00ee }
            java.lang.String r11 = "Downloader"
            com.chartboost.sdk.impl.w7.a(r11, r10)     // Catch:{ all -> 0x00ee }
            goto L_0x00da
        L_0x004a:
            java.lang.String r0 = ""
            com.chartboost.sdk.impl.k1 r10 = r10.f18086m     // Catch:{ all -> 0x00ee }
            if (r10 == 0) goto L_0x0052
            java.lang.String r0 = r10.f18007g     // Catch:{ all -> 0x00ee }
        L_0x0052:
            r6 = r0
            java.lang.String r10 = r11.getErrorDesc()     // Catch:{ all -> 0x00ee }
            java.lang.String r11 = "Downloader"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ee }
            r0.<init>()     // Catch:{ all -> 0x00ee }
            java.lang.String r1 = "Failed to download "
            r0.append(r1)     // Catch:{ all -> 0x00ee }
            java.lang.String r1 = r3.f18005e     // Catch:{ all -> 0x00ee }
            r0.append(r1)     // Catch:{ all -> 0x00ee }
            if (r12 == 0) goto L_0x0080
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ee }
            r1.<init>()     // Catch:{ all -> 0x00ee }
            java.lang.String r4 = " Status code="
            r1.append(r4)     // Catch:{ all -> 0x00ee }
            int r12 = r12.b()     // Catch:{ all -> 0x00ee }
            r1.append(r12)     // Catch:{ all -> 0x00ee }
            java.lang.String r12 = r1.toString()     // Catch:{ all -> 0x00ee }
            goto L_0x0082
        L_0x0080:
            java.lang.String r12 = ""
        L_0x0082:
            r0.append(r12)     // Catch:{ all -> 0x00ee }
            if (r10 == 0) goto L_0x0099
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ee }
            r12.<init>()     // Catch:{ all -> 0x00ee }
            java.lang.String r1 = " Error message="
            r12.append(r1)     // Catch:{ all -> 0x00ee }
            r12.append(r10)     // Catch:{ all -> 0x00ee }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x00ee }
            goto L_0x009b
        L_0x0099:
            java.lang.String r12 = ""
        L_0x009b:
            r0.append(r12)     // Catch:{ all -> 0x00ee }
            java.lang.String r12 = r0.toString()     // Catch:{ all -> 0x00ee }
            com.chartboost.sdk.impl.w7.a(r11, r12)     // Catch:{ all -> 0x00ee }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ee }
            r11.<init>()     // Catch:{ all -> 0x00ee }
            java.lang.String r12 = "Name: "
            r11.append(r12)     // Catch:{ all -> 0x00ee }
            java.lang.String r12 = r3.f18004d     // Catch:{ all -> 0x00ee }
            r11.append(r12)     // Catch:{ all -> 0x00ee }
            java.lang.String r12 = " Url: "
            r11.append(r12)     // Catch:{ all -> 0x00ee }
            java.lang.String r12 = r3.f18005e     // Catch:{ all -> 0x00ee }
            r11.append(r12)     // Catch:{ all -> 0x00ee }
            java.lang.String r12 = " Error: "
            r11.append(r12)     // Catch:{ all -> 0x00ee }
            r11.append(r10)     // Catch:{ all -> 0x00ee }
            java.lang.String r5 = r11.toString()     // Catch:{ all -> 0x00ee }
            com.chartboost.sdk.impl.z4 r10 = r9.f18557j     // Catch:{ all -> 0x00ee }
            com.chartboost.sdk.impl.x4 r11 = new com.chartboost.sdk.impl.x4     // Catch:{ all -> 0x00ee }
            com.chartboost.sdk.impl.tb$a r4 = com.chartboost.sdk.impl.tb.a.ASSET_DOWNLOAD_ERROR     // Catch:{ all -> 0x00ee }
            java.lang.String r7 = ""
            r8 = 0
            r3 = r11
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00ee }
            r10.track(r11)     // Catch:{ all -> 0x00ee }
        L_0x00da:
            int r10 = r9.f18554g     // Catch:{ all -> 0x00ee }
            if (r10 != r2) goto L_0x00e9
            java.lang.String r10 = "Downloader"
            java.lang.String r11 = "Change state to PAUSED"
            com.chartboost.sdk.impl.w7.a(r10, r11)     // Catch:{ all -> 0x00ee }
            r10 = 4
            r9.f18554g = r10     // Catch:{ all -> 0x00ee }
            goto L_0x00ec
        L_0x00e9:
            r9.d()     // Catch:{ all -> 0x00ee }
        L_0x00ec:
            monitor-exit(r9)
            return
        L_0x00ee:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.s4.a(com.chartboost.sdk.impl.l1, com.chartboost.sdk.internal.Model.CBError, com.chartboost.sdk.impl.p2):void");
    }
}
