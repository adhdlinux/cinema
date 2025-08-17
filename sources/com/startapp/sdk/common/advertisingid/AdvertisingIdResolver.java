package com.startapp.sdk.common.advertisingid;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.startapp.hc;
import com.startapp.sdk.adsbase.remoteconfig.AdvertisingIdResolverMetadata;
import com.startapp.ua;
import com.startapp.y8;
import com.startapp.yb;
import com.startapp.z8;
import com.startapp.zb;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AdvertisingIdResolver {

    /* renamed from: a  reason: collision with root package name */
    public final Context f36417a;

    /* renamed from: b  reason: collision with root package name */
    public final ThreadFactory f36418b;

    /* renamed from: c  reason: collision with root package name */
    public final ua<AdvertisingIdResolverMetadata> f36419c;

    /* renamed from: d  reason: collision with root package name */
    public final Lock f36420d;

    /* renamed from: e  reason: collision with root package name */
    public final Condition f36421e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<yb> f36422f = new AtomicReference<>();

    /* renamed from: g  reason: collision with root package name */
    public final AtomicInteger f36423g = new AtomicInteger(0);

    /* renamed from: h  reason: collision with root package name */
    public final double f36424h = Math.random();

    /* renamed from: i  reason: collision with root package name */
    public int f36425i;

    public static class InternalException extends Exception {
        public final int infoEventFlags;

        public InternalException(int i2) {
            super(String.valueOf(i2));
            this.infoEventFlags = i2;
        }
    }

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            AdvertisingIdResolver advertisingIdResolver;
            AtomicReference<yb> atomicReference;
            Context context;
            yb ybVar;
            boolean z2 = false;
            try {
                AdvertisingIdResolver.this.f36420d.lock();
                z2 = true;
                advertisingIdResolver = AdvertisingIdResolver.this;
                atomicReference = advertisingIdResolver.f36422f;
                context = advertisingIdResolver.f36417a;
                ybVar = AdvertisingIdResolver.a(context);
            } catch (InternalException e2) {
                advertisingIdResolver.b(e2.infoEventFlags);
            } catch (Throwable th) {
                try {
                    if (AdvertisingIdResolver.this.a(64)) {
                        y8.a(AdvertisingIdResolver.this.f36417a, th);
                    }
                    if (!z2) {
                        return;
                    }
                    return;
                } finally {
                    AdvertisingIdResolver.this.f36423g.set(2);
                    if (z2) {
                        AdvertisingIdResolver.this.f36421e.signalAll();
                        AdvertisingIdResolver.this.f36420d.unlock();
                    }
                }
            }
            atomicReference.set(ybVar);
            AdvertisingIdResolver.this.f36423g.set(2);
            AdvertisingIdResolver.this.f36421e.signalAll();
            AdvertisingIdResolver.this.f36420d.unlock();
            try {
                ybVar = AdvertisingIdResolver.b(context);
            } catch (InternalException e3) {
                advertisingIdResolver.b(e3.infoEventFlags);
                ybVar = yb.f36966a;
                atomicReference.set(ybVar);
                AdvertisingIdResolver.this.f36423g.set(2);
                AdvertisingIdResolver.this.f36421e.signalAll();
                AdvertisingIdResolver.this.f36420d.unlock();
            } catch (Throwable th2) {
                if (advertisingIdResolver.a((int) UserVerificationMethods.USER_VERIFY_HANDPRINT)) {
                    y8.a(context, th2);
                }
                ybVar = yb.f36966a;
                atomicReference.set(ybVar);
                AdvertisingIdResolver.this.f36423g.set(2);
                AdvertisingIdResolver.this.f36421e.signalAll();
                AdvertisingIdResolver.this.f36420d.unlock();
            }
            atomicReference.set(ybVar);
            AdvertisingIdResolver.this.f36423g.set(2);
            AdvertisingIdResolver.this.f36421e.signalAll();
            AdvertisingIdResolver.this.f36420d.unlock();
        }
    }

    public AdvertisingIdResolver(Context context, ThreadFactory threadFactory, ua<AdvertisingIdResolverMetadata> uaVar) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f36420d = reentrantLock;
        this.f36421e = reentrantLock.newCondition();
        this.f36417a = context;
        this.f36418b = threadFactory;
        this.f36419c = uaVar;
    }

    public boolean a(int i2) {
        AdvertisingIdResolverMetadata call = this.f36419c.call();
        if (call == null || !call.c()) {
            call = null;
        }
        if (call == null || this.f36424h >= call.b() || (call.a() & i2) != i2) {
            return false;
        }
        return true;
    }

    public final void b(int i2) {
        if (a(i2)) {
            int i3 = this.f36425i;
            if (!((i3 & i2) == i2)) {
                this.f36425i = i3 | i2;
                y8 y8Var = new y8(z8.f36996c);
                y8Var.f36954d = "AIR";
                y8Var.f36955e = String.valueOf(i2);
                y8Var.a(this.f36417a);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0083, code lost:
        if (r9.f36417a.checkSelfPermission("com.google.android.gms.permission.AD_ID") == 0) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0094, code lost:
        r2 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.startapp.yb a() {
        /*
            r9 = this;
            java.util.concurrent.atomic.AtomicReference<com.startapp.yb> r0 = r9.f36422f
            java.lang.Object r0 = r0.get()
            com.startapp.yb r0 = (com.startapp.yb) r0
            if (r0 != 0) goto L_0x00c1
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            java.lang.Thread r1 = r1.getThread()
            r2 = 1
            if (r0 != r1) goto L_0x001f
            r9.b((int) r2)
            com.startapp.yb r0 = com.startapp.yb.f36966a
            return r0
        L_0x001f:
            long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x00b1 }
            java.util.concurrent.locks.Lock r3 = r9.f36420d     // Catch:{ all -> 0x00b1 }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x00b1 }
            r5 = 1000(0x3e8, double:4.94E-321)
            boolean r3 = r3.tryLock(r5, r4)     // Catch:{ all -> 0x00b1 }
            if (r3 == 0) goto L_0x00a9
            r9.b()     // Catch:{ all -> 0x00a2 }
        L_0x0032:
            java.util.concurrent.atomic.AtomicInteger r3 = r9.f36423g     // Catch:{ all -> 0x00a2 }
            int r3 = r3.get()     // Catch:{ all -> 0x00a2 }
            r4 = 2
            if (r3 == r4) goto L_0x0059
            long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x00a2 }
            long r7 = r7 - r0
            int r3 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x004f
            r9.b((int) r4)     // Catch:{ all -> 0x00a2 }
            com.startapp.yb r0 = com.startapp.yb.f36966a     // Catch:{ all -> 0x00a2 }
            java.util.concurrent.locks.Lock r1 = r9.f36420d     // Catch:{ all -> 0x00b1 }
            r1.unlock()     // Catch:{ all -> 0x00b1 }
            return r0
        L_0x004f:
            java.util.concurrent.locks.Condition r3 = r9.f36421e     // Catch:{ all -> 0x00a2 }
            long r7 = r5 - r7
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x00a2 }
            r3.await(r7, r4)     // Catch:{ all -> 0x00a2 }
            goto L_0x0032
        L_0x0059:
            java.util.concurrent.atomic.AtomicReference<com.startapp.yb> r0 = r9.f36422f     // Catch:{ all -> 0x00a2 }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x00a2 }
            com.startapp.yb r0 = (com.startapp.yb) r0     // Catch:{ all -> 0x00a2 }
            if (r0 != 0) goto L_0x006a
            r0 = 4
            r9.b((int) r0)     // Catch:{ all -> 0x00a2 }
            com.startapp.yb r0 = com.startapp.yb.f36966a     // Catch:{ all -> 0x00a2 }
            goto L_0x009c
        L_0x006a:
            java.lang.String r1 = "00000000-0000-0000-0000-000000000000"
            java.lang.String r3 = r0.f36967b     // Catch:{ all -> 0x00a2 }
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x00a2 }
            if (r1 == 0) goto L_0x009c
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00a2 }
            r3 = 31
            if (r1 >= r3) goto L_0x007b
            goto L_0x0095
        L_0x007b:
            android.content.Context r1 = r9.f36417a     // Catch:{ all -> 0x0086 }
            java.lang.String r3 = "com.google.android.gms.permission.AD_ID"
            int r1 = r1.checkSelfPermission(r3)     // Catch:{ all -> 0x0086 }
            if (r1 != 0) goto L_0x0094
            goto L_0x0095
        L_0x0086:
            r1 = move-exception
            r2 = 8192(0x2000, float:1.14794E-41)
            boolean r2 = r9.a((int) r2)     // Catch:{ all -> 0x00a2 }
            if (r2 == 0) goto L_0x0094
            android.content.Context r2 = r9.f36417a     // Catch:{ all -> 0x00a2 }
            com.startapp.y8.a((android.content.Context) r2, (java.lang.Throwable) r1)     // Catch:{ all -> 0x00a2 }
        L_0x0094:
            r2 = 0
        L_0x0095:
            if (r2 != 0) goto L_0x009c
            r1 = 4096(0x1000, float:5.74E-42)
            r9.b((int) r1)     // Catch:{ all -> 0x00a2 }
        L_0x009c:
            java.util.concurrent.locks.Lock r1 = r9.f36420d     // Catch:{ all -> 0x00b1 }
            r1.unlock()     // Catch:{ all -> 0x00b1 }
            goto L_0x00c1
        L_0x00a2:
            r0 = move-exception
            java.util.concurrent.locks.Lock r1 = r9.f36420d     // Catch:{ all -> 0x00b1 }
            r1.unlock()     // Catch:{ all -> 0x00b1 }
            throw r0     // Catch:{ all -> 0x00b1 }
        L_0x00a9:
            r0 = 8
            r9.b((int) r0)     // Catch:{ all -> 0x00b1 }
            com.startapp.yb r0 = com.startapp.yb.f36966a     // Catch:{ all -> 0x00b1 }
            goto L_0x00c1
        L_0x00b1:
            r0 = move-exception
            r1 = 32
            boolean r1 = r9.a((int) r1)
            if (r1 == 0) goto L_0x00bf
            android.content.Context r1 = r9.f36417a
            com.startapp.y8.a((android.content.Context) r1, (java.lang.Throwable) r0)
        L_0x00bf:
            com.startapp.yb r0 = com.startapp.yb.f36966a
        L_0x00c1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.common.advertisingid.AdvertisingIdResolver.a():com.startapp.yb");
    }

    public final void b() {
        if (this.f36423g.get() == 0) {
            this.f36418b.newThread(new a()).start();
            this.f36423g.set(1);
        }
    }

    public static yb b(Context context) throws Exception {
        zb zbVar;
        Parcel obtain;
        Parcel obtain2;
        Parcel obtain3;
        Parcel obtain4;
        try {
            boolean z2 = false;
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            zbVar = new zb();
            try {
                if (!context.bindService(intent, zbVar, 1)) {
                    throw new InternalException(2048);
                } else if (!zbVar.f37013b) {
                    IBinder take = zbVar.f37012a.take();
                    if (take != null) {
                        zbVar.f37013b = true;
                        obtain = Parcel.obtain();
                        obtain2 = Parcel.obtain();
                        obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                        take.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        String readString = obtain2.readString();
                        obtain2.recycle();
                        obtain.recycle();
                        if (readString != null) {
                            obtain3 = Parcel.obtain();
                            obtain4 = Parcel.obtain();
                            obtain3.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                            obtain3.writeInt(1);
                            take.transact(2, obtain3, obtain4, 0);
                            obtain4.readException();
                            if (obtain4.readInt() != 0) {
                                z2 = true;
                            }
                            obtain4.recycle();
                            obtain3.recycle();
                            yb ybVar = new yb(readString, "DEVICE", z2);
                            hc.a(context, (ServiceConnection) zbVar);
                            return ybVar;
                        }
                        throw new RemoteException("Receive null from remote service");
                    }
                    throw new IllegalStateException("Binder is null");
                } else {
                    throw new IllegalStateException("Binder already retrieved");
                }
            } catch (Throwable th) {
                th = th;
                hc.a(context, (ServiceConnection) zbVar);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            zbVar = null;
            hc.a(context, (ServiceConnection) zbVar);
            throw th;
        }
    }

    public static yb a(Context context) throws Exception {
        Object invoke = AdvertisingIdClient.class.getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke((Object) null, new Object[]{context});
        if (invoke != null) {
            String str = (String) invoke.getClass().getMethod("getId", new Class[0]).invoke(invoke, new Object[0]);
            if (str == null || str.length() < 1) {
                throw new InternalException(1024);
            }
            return new yb(str, "APP", Boolean.TRUE.equals((Boolean) invoke.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(invoke, new Object[0])));
        }
        throw new InternalException(512);
    }
}
