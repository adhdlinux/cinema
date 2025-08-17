package androidx.media3.common.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class NetworkTypeObserver {

    /* renamed from: e  reason: collision with root package name */
    private static NetworkTypeObserver f4681e;

    /* renamed from: a  reason: collision with root package name */
    private final Handler f4682a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    private final CopyOnWriteArrayList<WeakReference<Listener>> f4683b = new CopyOnWriteArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final Object f4684c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private int f4685d = 0;

    private static final class Api31 {

        private static final class DisplayInfoCallback extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {

            /* renamed from: a  reason: collision with root package name */
            private final NetworkTypeObserver f4686a;

            public DisplayInfoCallback(NetworkTypeObserver networkTypeObserver) {
                this.f4686a = networkTypeObserver;
            }

            public void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
                boolean z2;
                int a2 = f.a(telephonyDisplayInfo);
                int i2 = 5;
                if (a2 == 3 || a2 == 4 || a2 == 5) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                NetworkTypeObserver networkTypeObserver = this.f4686a;
                if (z2) {
                    i2 = 10;
                }
                networkTypeObserver.k(i2);
            }
        }

        private Api31() {
        }

        public static void a(Context context, NetworkTypeObserver networkTypeObserver) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) Assertions.f((TelephonyManager) context.getSystemService("phone"));
                DisplayInfoCallback displayInfoCallback = new DisplayInfoCallback(networkTypeObserver);
                telephonyManager.registerTelephonyCallback(context.getMainExecutor(), displayInfoCallback);
                telephonyManager.unregisterTelephonyCallback(displayInfoCallback);
            } catch (RuntimeException unused) {
                networkTypeObserver.k(5);
            }
        }
    }

    public interface Listener {
        void a(int i2);
    }

    private final class Receiver extends BroadcastReceiver {
        private Receiver() {
        }

        public void onReceive(Context context, Intent intent) {
            int b2 = NetworkTypeObserver.g(context);
            if (Util.f4714a < 31 || b2 != 5) {
                NetworkTypeObserver.this.k(b2);
            } else {
                Api31.a(context, NetworkTypeObserver.this);
            }
        }
    }

    private NetworkTypeObserver(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(new Receiver(), intentFilter);
    }

    public static synchronized NetworkTypeObserver d(Context context) {
        NetworkTypeObserver networkTypeObserver;
        synchronized (NetworkTypeObserver.class) {
            if (f4681e == null) {
                f4681e = new NetworkTypeObserver(context);
            }
            networkTypeObserver = f4681e;
        }
        return networkTypeObserver;
    }

    private static int e(NetworkInfo networkInfo) {
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
                return 3;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 17:
                return 4;
            case 13:
                return 5;
            case 18:
                return 2;
            case 20:
                if (Util.f4714a >= 29) {
                    return 9;
                }
                return 0;
            default:
                return 6;
        }
    }

    /* access modifiers changed from: private */
    public static int g(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        int i2 = 0;
        if (connectivityManager == null) {
            return 0;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            i2 = 1;
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    if (type == 1) {
                        return 2;
                    }
                    if (!(type == 4 || type == 5)) {
                        if (type == 6) {
                            return 5;
                        }
                        if (type != 9) {
                            return 8;
                        }
                        return 7;
                    }
                }
                return e(activeNetworkInfo);
            }
        } catch (SecurityException unused) {
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(Listener listener) {
        listener.a(f());
    }

    private void j() {
        Iterator<WeakReference<Listener>> it2 = this.f4683b.iterator();
        while (it2.hasNext()) {
            WeakReference next = it2.next();
            if (next.get() == null) {
                this.f4683b.remove(next);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0016, code lost:
        if (r0.hasNext() == false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0018, code lost:
        r1 = r0.next();
        r2 = (androidx.media3.common.util.NetworkTypeObserver.Listener) r1.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
        if (r2 == null) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        r2.a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        r3.f4683b.remove(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0030, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000c, code lost:
        r0 = r3.f4683b.iterator();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void k(int r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f4684c
            monitor-enter(r0)
            int r1 = r3.f4685d     // Catch:{ all -> 0x0031 }
            if (r1 != r4) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            return
        L_0x0009:
            r3.f4685d = r4     // Catch:{ all -> 0x0031 }
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            java.util.concurrent.CopyOnWriteArrayList<java.lang.ref.WeakReference<androidx.media3.common.util.NetworkTypeObserver$Listener>> r0 = r3.f4683b
            java.util.Iterator r0 = r0.iterator()
        L_0x0012:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0030
            java.lang.Object r1 = r0.next()
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1
            java.lang.Object r2 = r1.get()
            androidx.media3.common.util.NetworkTypeObserver$Listener r2 = (androidx.media3.common.util.NetworkTypeObserver.Listener) r2
            if (r2 == 0) goto L_0x002a
            r2.a(r4)
            goto L_0x0012
        L_0x002a:
            java.util.concurrent.CopyOnWriteArrayList<java.lang.ref.WeakReference<androidx.media3.common.util.NetworkTypeObserver$Listener>> r2 = r3.f4683b
            r2.remove(r1)
            goto L_0x0012
        L_0x0030:
            return
        L_0x0031:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0031 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.util.NetworkTypeObserver.k(int):void");
    }

    public int f() {
        int i2;
        synchronized (this.f4684c) {
            i2 = this.f4685d;
        }
        return i2;
    }

    public void i(Listener listener) {
        j();
        this.f4683b.add(new WeakReference(listener));
        this.f4682a.post(new c(this, listener));
    }
}
