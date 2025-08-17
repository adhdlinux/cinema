package com.facebook.ads.internal.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.text.TextUtils;
import com.facebook.ads.internal.c.c;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f20042a = "a";

    /* renamed from: b  reason: collision with root package name */
    private final String f20043b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f20044c;

    /* renamed from: d  reason: collision with root package name */
    private final c f20045d;

    /* renamed from: com.facebook.ads.internal.c.a$a  reason: collision with other inner class name */
    private static final class C0030a implements IInterface {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f20046a;

        C0030a(IBinder iBinder) {
            this.f20046a = iBinder;
        }

        public String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f20046a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public IBinder asBinder() {
            return this.f20046a;
        }

        public boolean b() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z2 = true;
                obtain.writeInt(1);
                this.f20046a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z2 = false;
                }
                return z2;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    private static final class b implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        private AtomicBoolean f20047a;

        /* renamed from: b  reason: collision with root package name */
        private final BlockingQueue<IBinder> f20048b;

        private b() {
            this.f20047a = new AtomicBoolean(false);
            this.f20048b = new LinkedBlockingDeque();
        }

        public IBinder a() {
            if (!this.f20047a.compareAndSet(true, true)) {
                return this.f20048b.take();
            }
            throw new IllegalStateException("Binder already consumed");
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f20048b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public enum c {
        SHARED_PREFS,
        FB4A,
        DIRECT,
        REFLECTION,
        SERVICE
    }

    private a(String str, boolean z2, c cVar) {
        this.f20043b = str;
        this.f20044c = z2;
        this.f20045d = cVar;
    }

    private static a a(Context context) {
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            if (advertisingIdInfo != null) {
                return new a(advertisingIdInfo.getId(), advertisingIdInfo.isLimitAdTrackingEnabled(), c.DIRECT);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static a a(Context context, c.a aVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot get advertising info on main thread.");
        } else if (com.facebook.ads.internal.q.a.b.a() && com.facebook.ads.internal.q.a.b.b("idfa_override")) {
            return new a(com.facebook.ads.internal.q.a.b.a("idfa_override"), false, c.DIRECT);
        } else {
            if (aVar != null && !TextUtils.isEmpty(aVar.f20060b)) {
                return new a(aVar.f20060b, aVar.f20061c, c.FB4A);
            }
            a a2 = a(context);
            if (a2 == null || TextUtils.isEmpty(a2.a())) {
                a2 = b(context);
            }
            return (a2 == null || TextUtils.isEmpty(a2.a())) ? c(context) : a2;
        }
    }

    private static a b(Context context) {
        Object a2;
        Method a3;
        Object a4;
        Class<Context> cls = Context.class;
        Method a5 = d.a("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", (Class<?>[]) new Class[]{cls});
        if (a5 == null || (a2 = d.a((Object) null, a5, context)) == null || ((Integer) a2).intValue() != 0 || (a3 = d.a("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", (Class<?>[]) new Class[]{cls})) == null || (a4 = d.a((Object) null, a3, context)) == null) {
            return null;
        }
        Method a6 = d.a(a4.getClass(), "getId", (Class<?>[]) new Class[0]);
        Method a7 = d.a(a4.getClass(), "isLimitAdTrackingEnabled", (Class<?>[]) new Class[0]);
        if (!(a6 == null || a7 == null)) {
            return new a((String) d.a(a4, a6, new Object[0]), ((Boolean) d.a(a4, a7, new Object[0])).booleanValue(), c.REFLECTION);
        }
        return null;
    }

    private static a c(Context context) {
        b bVar = new b();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, bVar, 1)) {
            try {
                C0030a aVar = new C0030a(bVar.a());
                return new a(aVar.a(), aVar.b(), c.SERVICE);
            } catch (Exception unused) {
            } finally {
                context.unbindService(bVar);
            }
        }
        return null;
    }

    public String a() {
        return this.f20043b;
    }

    public boolean b() {
        return this.f20044c;
    }

    public c c() {
        return this.f20045d;
    }
}
