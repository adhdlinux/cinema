package com.startapp;

import android.content.Context;

public class i9 implements Runnable, Comparable<i9> {

    /* renamed from: a  reason: collision with root package name */
    public final Context f34689a;

    /* renamed from: b  reason: collision with root package name */
    public final y8 f34690b;

    /* renamed from: c  reason: collision with root package name */
    public final a9 f34691c;

    /* renamed from: d  reason: collision with root package name */
    public final d9 f34692d;

    /* renamed from: e  reason: collision with root package name */
    public final Exception f34693e = new Exception();

    public i9(Context context, y8 y8Var, a9 a9Var, d9 d9Var) {
        this.f34689a = context;
        this.f34690b = y8Var;
        this.f34691c = a9Var;
        this.f34692d = d9Var;
    }

    public Throwable a(Throwable th) {
        th.addSuppressed(this.f34693e);
        return th;
    }

    public int compareTo(Object obj) {
        return ((i9) obj).f34691c.f34196c - this.f34691c.f34196c;
    }

    public void run() {
        d9 d9Var;
        boolean z2 = false;
        try {
            z2 = a(a());
            d9Var = this.f34692d;
            if (d9Var == null) {
                return;
            }
        } catch (OutOfMemoryError unused) {
            d9Var = this.f34692d;
            if (d9Var == null) {
                return;
            }
        } catch (Throwable th) {
            d9 d9Var2 = this.f34692d;
            if (d9Var2 != null) {
                d9Var2.a(this.f34690b, 0);
            }
            throw th;
        }
        d9Var.a(this.f34690b, z2 ? 1 : 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x015d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.startapp.h9 a() {
        /*
            r8 = this;
            com.startapp.h9 r0 = new com.startapp.h9
            com.startapp.y8 r1 = r8.f34690b
            r0.<init>(r1)
            android.content.Context r1 = r8.f34689a
            r0.c(r1)
            com.startapp.y8 r1 = r8.f34690b
            java.lang.String r1 = r1.f36953c
            if (r1 == 0) goto L_0x001a
            int r2 = r1.length()
            if (r2 <= 0) goto L_0x001a
            r0.f35655d = r1
        L_0x001a:
            com.startapp.a9 r1 = r8.f34691c
            int r1 = r1.f34195b
            r1 = r1 & 32
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0026
            r1 = 1
            goto L_0x0027
        L_0x0026:
            r1 = 0
        L_0x0027:
            if (r1 == 0) goto L_0x0041
            android.content.Context r1 = r8.f34689a     // Catch:{ all -> 0x002f }
            com.startapp.sdk.adsbase.SimpleTokenUtils.e(r1)     // Catch:{ all -> 0x002f }
            goto L_0x0041
        L_0x002f:
            r1 = move-exception
            com.startapp.y8 r4 = r8.f34690b
            com.startapp.z8 r4 = r4.f36951a
            com.startapp.z8 r5 = com.startapp.z8.f36997d
            if (r4 == r5) goto L_0x0041
            android.content.Context r4 = r8.f34689a
            java.lang.Throwable r1 = r8.a((java.lang.Throwable) r1)
            com.startapp.y8.a((android.content.Context) r4, (java.lang.Throwable) r1)
        L_0x0041:
            com.startapp.a9 r1 = r8.f34691c
            int r1 = r1.f34195b
            r1 = r1 & 8
            if (r1 == 0) goto L_0x004b
            r1 = 1
            goto L_0x004c
        L_0x004b:
            r1 = 0
        L_0x004c:
            if (r1 == 0) goto L_0x0078
            android.content.Context r1 = r8.f34689a     // Catch:{ all -> 0x0066 }
            com.startapp.sdk.components.ComponentLocator r1 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r1)     // Catch:{ all -> 0x0066 }
            com.startapp.od r1 = r1.s()     // Catch:{ all -> 0x0066 }
            java.lang.Object r1 = r1.b()     // Catch:{ all -> 0x0066 }
            com.startapp.nd r1 = (com.startapp.nd) r1     // Catch:{ all -> 0x0066 }
            r4 = 6
            java.lang.String r1 = r1.b(r4)     // Catch:{ all -> 0x0066 }
            r0.f34631l0 = r1     // Catch:{ all -> 0x0066 }
            goto L_0x0078
        L_0x0066:
            r1 = move-exception
            com.startapp.y8 r4 = r8.f34690b
            com.startapp.z8 r4 = r4.f36951a
            com.startapp.z8 r5 = com.startapp.z8.f36997d
            if (r4 == r5) goto L_0x0078
            android.content.Context r4 = r8.f34689a
            java.lang.Throwable r1 = r8.a((java.lang.Throwable) r1)
            com.startapp.y8.a((android.content.Context) r4, (java.lang.Throwable) r1)
        L_0x0078:
            com.startapp.a9 r1 = r8.f34691c
            int r1 = r1.f34195b
            r1 = r1 & r3
            if (r1 == 0) goto L_0x0081
            r1 = 1
            goto L_0x0082
        L_0x0081:
            r1 = 0
        L_0x0082:
            if (r1 == 0) goto L_0x009d
            android.content.Context r1 = r8.f34689a     // Catch:{ all -> 0x008b }
            r4 = 0
            r0.b(r1, r4)     // Catch:{ all -> 0x008b }
            goto L_0x009d
        L_0x008b:
            r1 = move-exception
            com.startapp.y8 r4 = r8.f34690b
            com.startapp.z8 r4 = r4.f36951a
            com.startapp.z8 r5 = com.startapp.z8.f36997d
            if (r4 == r5) goto L_0x009d
            android.content.Context r4 = r8.f34689a
            java.lang.Throwable r1 = r8.a((java.lang.Throwable) r1)
            com.startapp.y8.a((android.content.Context) r4, (java.lang.Throwable) r1)
        L_0x009d:
            com.startapp.a9 r1 = r8.f34691c
            int r1 = r1.f34195b
            r4 = 2
            r1 = r1 & r4
            if (r1 == 0) goto L_0x00a7
            r1 = 1
            goto L_0x00a8
        L_0x00a7:
            r1 = 0
        L_0x00a8:
            if (r1 == 0) goto L_0x00c2
            android.content.Context r1 = r8.f34689a     // Catch:{ all -> 0x00b0 }
            r0.d(r1)     // Catch:{ all -> 0x00b0 }
            goto L_0x00c2
        L_0x00b0:
            r1 = move-exception
            com.startapp.y8 r5 = r8.f34690b
            com.startapp.z8 r5 = r5.f36951a
            com.startapp.z8 r6 = com.startapp.z8.f36997d
            if (r5 == r6) goto L_0x00c2
            android.content.Context r5 = r8.f34689a
            java.lang.Throwable r1 = r8.a((java.lang.Throwable) r1)
            com.startapp.y8.a((android.content.Context) r5, (java.lang.Throwable) r1)
        L_0x00c2:
            com.startapp.a9 r1 = r8.f34691c
            int r1 = r1.f34195b
            r1 = r1 & 4
            if (r1 == 0) goto L_0x00cc
            r1 = 1
            goto L_0x00cd
        L_0x00cc:
            r1 = 0
        L_0x00cd:
            if (r1 == 0) goto L_0x00e7
            android.content.Context r1 = r8.f34689a     // Catch:{ all -> 0x00d5 }
            r0.e(r1)     // Catch:{ all -> 0x00d5 }
            goto L_0x00e7
        L_0x00d5:
            r1 = move-exception
            com.startapp.y8 r5 = r8.f34690b
            com.startapp.z8 r5 = r5.f36951a
            com.startapp.z8 r6 = com.startapp.z8.f36997d
            if (r5 == r6) goto L_0x00e7
            android.content.Context r5 = r8.f34689a
            java.lang.Throwable r1 = r8.a((java.lang.Throwable) r1)
            com.startapp.y8.a((android.content.Context) r5, (java.lang.Throwable) r1)
        L_0x00e7:
            com.startapp.a9 r1 = r8.f34691c
            int r1 = r1.f34195b
            r1 = r1 & 16
            if (r1 == 0) goto L_0x00f1
            r1 = 1
            goto L_0x00f2
        L_0x00f1:
            r1 = 0
        L_0x00f2:
            if (r1 == 0) goto L_0x010c
            android.content.Context r1 = r8.f34689a     // Catch:{ all -> 0x00fa }
            r0.a((android.content.Context) r1)     // Catch:{ all -> 0x00fa }
            goto L_0x010c
        L_0x00fa:
            r1 = move-exception
            com.startapp.y8 r5 = r8.f34690b
            com.startapp.z8 r5 = r5.f36951a
            com.startapp.z8 r6 = com.startapp.z8.f36997d
            if (r5 == r6) goto L_0x010c
            android.content.Context r5 = r8.f34689a
            java.lang.Throwable r1 = r8.a((java.lang.Throwable) r1)
            com.startapp.y8.a((android.content.Context) r5, (java.lang.Throwable) r1)
        L_0x010c:
            com.startapp.a9 r1 = r8.f34691c
            int r1 = r1.f34195b
            r1 = r1 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0116
            r1 = 1
            goto L_0x0117
        L_0x0116:
            r1 = 0
        L_0x0117:
            if (r1 == 0) goto L_0x0131
            android.content.Context r1 = r8.f34689a     // Catch:{ all -> 0x011f }
            r0.b(r1)     // Catch:{ all -> 0x011f }
            goto L_0x0131
        L_0x011f:
            r1 = move-exception
            com.startapp.y8 r5 = r8.f34690b
            com.startapp.z8 r5 = r5.f36951a
            com.startapp.z8 r6 = com.startapp.z8.f36997d
            if (r5 == r6) goto L_0x0131
            android.content.Context r5 = r8.f34689a
            java.lang.Throwable r1 = r8.a((java.lang.Throwable) r1)
            com.startapp.y8.a((android.content.Context) r5, (java.lang.Throwable) r1)
        L_0x0131:
            com.startapp.a9 r1 = r8.f34691c
            int r1 = r1.f34195b
            r1 = r1 & 64
            if (r1 == 0) goto L_0x013b
            r1 = 1
            goto L_0x013c
        L_0x013b:
            r1 = 0
        L_0x013c:
            if (r1 == 0) goto L_0x0177
            android.content.Context r1 = r8.f34689a     // Catch:{ all -> 0x0165 }
            java.util.Map<android.app.Activity, java.lang.Integer> r5 = com.startapp.lb.f34876a     // Catch:{ all -> 0x0165 }
            android.content.res.Resources r5 = r1.getResources()     // Catch:{ all -> 0x0159 }
            java.lang.String r6 = "com_startapp_sdk_aar"
            java.lang.String r7 = "integer"
            java.lang.String r1 = r1.getPackageName()     // Catch:{ all -> 0x0159 }
            int r1 = r5.getIdentifier(r6, r7, r1)     // Catch:{ all -> 0x0159 }
            if (r1 == 0) goto L_0x015a
            int r1 = r5.getInteger(r1)     // Catch:{ all -> 0x0159 }
            goto L_0x015b
        L_0x0159:
        L_0x015a:
            r1 = 0
        L_0x015b:
            if (r1 != r3) goto L_0x0160
            java.lang.String r1 = "aar"
            goto L_0x0162
        L_0x0160:
            java.lang.String r1 = "jar"
        L_0x0162:
            r0.f34634o0 = r1     // Catch:{ all -> 0x0165 }
            goto L_0x0177
        L_0x0165:
            r1 = move-exception
            com.startapp.y8 r5 = r8.f34690b
            com.startapp.z8 r5 = r5.f36951a
            com.startapp.z8 r6 = com.startapp.z8.f36997d
            if (r5 == r6) goto L_0x0177
            android.content.Context r5 = r8.f34689a
            java.lang.Throwable r1 = r8.a((java.lang.Throwable) r1)
            com.startapp.y8.a((android.content.Context) r5, (java.lang.Throwable) r1)
        L_0x0177:
            com.startapp.a9 r1 = r8.f34691c
            int r1 = r1.f34195b
            r1 = r1 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0181
            r1 = 1
            goto L_0x0182
        L_0x0181:
            r1 = 0
        L_0x0182:
            if (r1 == 0) goto L_0x01bd
            android.content.Context r1 = r8.f34689a     // Catch:{ all -> 0x01ab }
            com.startapp.sdk.components.ComponentLocator r1 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r1)     // Catch:{ all -> 0x01ab }
            com.startapp.jc<com.startapp.ed> r1 = r1.f36446t     // Catch:{ all -> 0x01ab }
            java.lang.Object r1 = r1.b()     // Catch:{ all -> 0x01ab }
            com.startapp.ed r1 = (com.startapp.ed) r1     // Catch:{ all -> 0x01ab }
            java.lang.Object r1 = r1.b()     // Catch:{ all -> 0x01ab }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x01ab }
            if (r1 == 0) goto L_0x01bd
            byte[] r5 = com.startapp.fc.f34529a     // Catch:{ all -> 0x01ab }
            byte[] r1 = r1.getBytes()     // Catch:{ all -> 0x01ab }
            byte[] r1 = com.startapp.fc.a((byte[]) r1)     // Catch:{ all -> 0x01ab }
            java.lang.String r1 = android.util.Base64.encodeToString(r1, r4)     // Catch:{ all -> 0x01ab }
            r0.f34633n0 = r1     // Catch:{ all -> 0x01ab }
            goto L_0x01bd
        L_0x01ab:
            r1 = move-exception
            com.startapp.y8 r5 = r8.f34690b
            com.startapp.z8 r5 = r5.f36951a
            com.startapp.z8 r6 = com.startapp.z8.f36997d
            if (r5 == r6) goto L_0x01bd
            android.content.Context r5 = r8.f34689a
            java.lang.Throwable r1 = r8.a((java.lang.Throwable) r1)
            com.startapp.y8.a((android.content.Context) r5, (java.lang.Throwable) r1)
        L_0x01bd:
            com.startapp.a9 r1 = r8.f34691c
            int r1 = r1.f34195b
            r1 = r1 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x01c7
            r1 = 1
            goto L_0x01c8
        L_0x01c7:
            r1 = 0
        L_0x01c8:
            if (r1 == 0) goto L_0x0203
            android.content.Context r1 = r8.f34689a     // Catch:{ all -> 0x01f1 }
            com.startapp.sdk.components.ComponentLocator r1 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r1)     // Catch:{ all -> 0x01f1 }
            com.startapp.jc<com.startapp.kd> r1 = r1.f36447u     // Catch:{ all -> 0x01f1 }
            java.lang.Object r1 = r1.b()     // Catch:{ all -> 0x01f1 }
            com.startapp.kd r1 = (com.startapp.kd) r1     // Catch:{ all -> 0x01f1 }
            java.lang.Object r1 = r1.b()     // Catch:{ all -> 0x01f1 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x01f1 }
            if (r1 == 0) goto L_0x0203
            byte[] r5 = com.startapp.fc.f34529a     // Catch:{ all -> 0x01f1 }
            byte[] r1 = r1.getBytes()     // Catch:{ all -> 0x01f1 }
            byte[] r1 = com.startapp.fc.a((byte[]) r1)     // Catch:{ all -> 0x01f1 }
            java.lang.String r1 = android.util.Base64.encodeToString(r1, r4)     // Catch:{ all -> 0x01f1 }
            r0.f34632m0 = r1     // Catch:{ all -> 0x01f1 }
            goto L_0x0203
        L_0x01f1:
            r1 = move-exception
            com.startapp.y8 r4 = r8.f34690b
            com.startapp.z8 r4 = r4.f36951a
            com.startapp.z8 r5 = com.startapp.z8.f36997d
            if (r4 == r5) goto L_0x0203
            android.content.Context r4 = r8.f34689a
            java.lang.Throwable r1 = r8.a((java.lang.Throwable) r1)
            com.startapp.y8.a((android.content.Context) r4, (java.lang.Throwable) r1)
        L_0x0203:
            com.startapp.a9 r1 = r8.f34691c
            int r1 = r1.f34195b
            r1 = r1 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x020d
            r1 = 1
            goto L_0x020e
        L_0x020d:
            r1 = 0
        L_0x020e:
            if (r1 == 0) goto L_0x0233
            android.content.Context r1 = r8.f34689a     // Catch:{ all -> 0x0221 }
            com.startapp.sdk.components.ComponentLocator r1 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r1)     // Catch:{ all -> 0x0221 }
            com.startapp.rb r1 = r1.b()     // Catch:{ all -> 0x0221 }
            java.lang.String r1 = r1.a()     // Catch:{ all -> 0x0221 }
            r0.Z = r1     // Catch:{ all -> 0x0221 }
            goto L_0x0233
        L_0x0221:
            r1 = move-exception
            com.startapp.y8 r4 = r8.f34690b
            com.startapp.z8 r4 = r4.f36951a
            com.startapp.z8 r5 = com.startapp.z8.f36997d
            if (r4 == r5) goto L_0x0233
            android.content.Context r4 = r8.f34689a
            java.lang.Throwable r1 = r8.a((java.lang.Throwable) r1)
            com.startapp.y8.a((android.content.Context) r4, (java.lang.Throwable) r1)
        L_0x0233:
            com.startapp.a9 r1 = r8.f34691c
            int r1 = r1.f34195b
            r1 = r1 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x023c
            r2 = 1
        L_0x023c:
            if (r2 == 0) goto L_0x0265
            android.content.Context r1 = r8.f34689a     // Catch:{ all -> 0x0253 }
            com.startapp.sdk.components.ComponentLocator r1 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r1)     // Catch:{ all -> 0x0253 }
            com.startapp.rd r1 = r1.t()     // Catch:{ all -> 0x0253 }
            com.startapp.y8 r2 = r8.f34690b     // Catch:{ all -> 0x0253 }
            com.startapp.z8 r2 = r2.f36951a     // Catch:{ all -> 0x0253 }
            java.util.Map r1 = r1.a((com.startapp.z8) r2)     // Catch:{ all -> 0x0253 }
            r0.f34635p0 = r1     // Catch:{ all -> 0x0253 }
            goto L_0x0265
        L_0x0253:
            r1 = move-exception
            com.startapp.y8 r2 = r8.f34690b
            com.startapp.z8 r2 = r2.f36951a
            com.startapp.z8 r3 = com.startapp.z8.f36997d
            if (r2 == r3) goto L_0x0265
            android.content.Context r2 = r8.f34689a
            java.lang.Throwable r1 = r8.a((java.lang.Throwable) r1)
            com.startapp.y8.a((android.content.Context) r2, (java.lang.Throwable) r1)
        L_0x0265:
            android.content.Context r1 = r8.f34689a     // Catch:{ all -> 0x0276 }
            com.startapp.sdk.components.ComponentLocator r1 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r1)     // Catch:{ all -> 0x0276 }
            com.startapp.qe r1 = r1.p()     // Catch:{ all -> 0x0276 }
            java.lang.String r1 = r1.a((java.lang.Object) r0)     // Catch:{ all -> 0x0276 }
            r0.K = r1     // Catch:{ all -> 0x0276 }
            goto L_0x0288
        L_0x0276:
            r1 = move-exception
            com.startapp.y8 r2 = r8.f34690b
            com.startapp.z8 r2 = r2.f36951a
            com.startapp.z8 r3 = com.startapp.z8.f36997d
            if (r2 == r3) goto L_0x0288
            android.content.Context r2 = r8.f34689a
            java.lang.Throwable r1 = r8.a((java.lang.Throwable) r1)
            com.startapp.y8.a((android.content.Context) r2, (java.lang.Throwable) r1)
        L_0x0288:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.i9.a():com.startapp.h9");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0066 A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0068 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.startapp.h9 r12) {
        /*
            r11 = this;
            com.startapp.sdk.adsbase.remoteconfig.MetaData r0 = com.startapp.sdk.adsbase.remoteconfig.MetaData.f36379h
            com.startapp.sdk.adsbase.remoteconfig.AnalyticsConfig r0 = r0.analytics
            com.startapp.sdk.adsbase.remoteconfig.MetaData r1 = com.startapp.sdk.adsbase.remoteconfig.MetaData.f36379h
            com.startapp.sdk.insight.NetworkTestsMetaData r1 = r1.v()
            com.startapp.y8 r2 = r11.f34690b
            com.startapp.z8 r2 = r2.f36951a
            com.startapp.z8 r3 = com.startapp.z8.f37005l
            r4 = 0
            if (r2 != r3) goto L_0x001a
            if (r1 == 0) goto L_0x0030
            java.lang.String r1 = r1.g()
            goto L_0x003d
        L_0x001a:
            com.startapp.z8 r3 = com.startapp.z8.f37006m
            if (r2 != r3) goto L_0x0025
            if (r1 == 0) goto L_0x0030
            java.lang.String r1 = r1.h()
            goto L_0x003d
        L_0x0025:
            com.startapp.z8 r3 = com.startapp.z8.f37007n
            if (r2 != r3) goto L_0x0032
            if (r1 == 0) goto L_0x0030
            java.lang.String r1 = r1.i()
            goto L_0x003d
        L_0x0030:
            r1 = r4
            goto L_0x003d
        L_0x0032:
            com.startapp.z8 r1 = com.startapp.z8.f37002i
            if (r2 != r1) goto L_0x0030
            java.lang.String r1 = r0.hostPeriodic
            if (r1 == 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            java.lang.String r1 = com.startapp.sdk.adsbase.remoteconfig.AnalyticsConfig.f36371a
        L_0x003d:
            if (r1 != 0) goto L_0x0046
            java.lang.String r1 = r0.hostSecured
            if (r1 == 0) goto L_0x0044
            goto L_0x0046
        L_0x0044:
            java.lang.String r1 = com.startapp.sdk.adsbase.remoteconfig.AnalyticsConfig.f36371a
        L_0x0046:
            r6 = r1
            android.content.Context r0 = r11.f34689a
            com.startapp.sdk.components.ComponentLocator r0 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r0)
            com.startapp.w8 r0 = r0.j()
            r0.getClass()
            r10 = 0
            r9 = 0
            r8 = 0
            r5 = r0
            r7 = r12
            java.lang.String r4 = r5.a(r6, r7, r8, r9, r10)     // Catch:{ all -> 0x005e }
            goto L_0x0064
        L_0x005e:
            r12 = move-exception
            android.content.Context r0 = r0.f36819a
            com.startapp.y8.a((android.content.Context) r0, (java.lang.Throwable) r12)
        L_0x0064:
            if (r4 == 0) goto L_0x0068
            r12 = 1
            goto L_0x0069
        L_0x0068:
            r12 = 0
        L_0x0069:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.i9.a(com.startapp.h9):boolean");
    }
}
