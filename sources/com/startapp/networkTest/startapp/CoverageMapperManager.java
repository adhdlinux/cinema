package com.startapp.networkTest.startapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.telephony.CellLocation;
import android.telephony.ServiceState;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.startapp.c1;
import com.startapp.l2;
import com.startapp.networkTest.controller.LocationController;
import com.startapp.networkTest.data.LocationInfo;
import com.startapp.networkTest.enums.LocationProviders;
import com.startapp.networkTest.enums.TriggerEvents;
import com.startapp.networkTest.results.NetworkInformationResult;
import com.startapp.networkTest.threads.ThreadManager;
import com.startapp.w1;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class CoverageMapperManager implements LocationController.c, c1 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f35478a = "CoverageMapperManager";

    /* renamed from: b  reason: collision with root package name */
    private static final long f35479b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final long f35480c = 10000;

    /* renamed from: d  reason: collision with root package name */
    private static final long f35481d = 10000;

    /* renamed from: e  reason: collision with root package name */
    private static final int f35482e = 500;

    /* renamed from: f  reason: collision with root package name */
    private static final int f35483f = 10000;

    /* renamed from: g  reason: collision with root package name */
    private static final int f35484g = 1000;

    /* renamed from: h  reason: collision with root package name */
    private static final int f35485h = 1000;

    /* renamed from: i  reason: collision with root package name */
    private static final int f35486i = 1000;

    /* renamed from: j  reason: collision with root package name */
    private static final int f35487j = 2000;
    private Runnable A = new d();
    private BroadcastReceiver B = new e();

    /* renamed from: k  reason: collision with root package name */
    private Context f35488k;

    /* renamed from: l  reason: collision with root package name */
    private w1 f35489l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f35490m = false;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public long f35491n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public ScheduledFuture<?> f35492o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public ScheduledFuture<?> f35493p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public ScheduledFuture<?> f35494q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public long f35495r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public long f35496s;

    /* renamed from: t  reason: collision with root package name */
    private int f35497t = -1;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public long f35498u;

    /* renamed from: v  reason: collision with root package name */
    private int f35499v = -1;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public long f35500w;

    /* renamed from: x  reason: collision with root package name */
    private OnNetworkInfoResultListener f35501x;

    /* renamed from: y  reason: collision with root package name */
    private Runnable f35502y = new b();

    /* renamed from: z  reason: collision with root package name */
    private Runnable f35503z = new c();

    public interface OnNetworkInfoResultListener {
        void onNetworkInfoResult(NetworkInformationResult networkInformationResult);
    }

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LocationInfo f35504a;

        public a(LocationInfo locationInfo) {
            this.f35504a = locationInfo;
        }

        public void run() {
            CoverageMapperManager.this.a(this.f35504a, TriggerEvents.LocationUpdateGps, false);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            CoverageMapperManager.this.a((LocationInfo) null, TriggerEvents.OutOfService, true);
            if (CoverageMapperManager.this.f35495r + NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS < SystemClock.elapsedRealtime()) {
                CoverageMapperManager.this.f35492o.cancel(false);
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            CoverageMapperManager.this.a((LocationInfo) null, TriggerEvents.CellIdChange, true);
            if (CoverageMapperManager.this.f35498u + 1 < SystemClock.elapsedRealtime()) {
                CoverageMapperManager.this.f35493p.cancel(false);
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            if (SystemClock.elapsedRealtime() > CoverageMapperManager.this.f35491n + 2000) {
                CoverageMapperManager.this.a((LocationInfo) null, TriggerEvents.Foreground, false);
            }
            if (CoverageMapperManager.this.f35500w + NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS < SystemClock.elapsedRealtime()) {
                CoverageMapperManager.this.f35494q.cancel(false);
            }
        }
    }

    public class e extends BroadcastReceiver {
        public e() {
        }

        public void onReceive(Context context, Intent intent) {
            long unused = CoverageMapperManager.this.f35496s = SystemClock.elapsedRealtime();
        }
    }

    public CoverageMapperManager(Context context) {
        this.f35489l = new w1(context);
        this.f35488k = context;
    }

    private void d() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f35496s + NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS <= elapsedRealtime) {
            this.f35495r = elapsedRealtime;
            ScheduledFuture<?> scheduledFuture = this.f35492o;
            if (scheduledFuture == null || scheduledFuture.isDone()) {
                this.f35492o = ThreadManager.b().d().scheduleWithFixedDelay(this.f35502y, 0, 1000, TimeUnit.MILLISECONDS);
            }
        }
    }

    public void b() {
        if (!this.f35490m) {
            this.f35490m = true;
            this.f35489l.a((c1) this);
            this.f35489l.a((LocationController.c) this);
            this.f35489l.e();
            IntentFilter intentFilter = new IntentFilter("android.intent.action.AIRPLANE_MODE");
            intentFilter.addAction("android.intent.action.ACTION_SHUTDOWN");
            this.f35488k.registerReceiver(this.B, intentFilter);
        }
    }

    public void c() {
        this.f35500w = SystemClock.elapsedRealtime();
        ScheduledFuture<?> scheduledFuture = this.f35494q;
        if (scheduledFuture == null || scheduledFuture.isDone()) {
            this.f35494q = ThreadManager.b().d().scheduleWithFixedDelay(this.A, 0, 1000, TimeUnit.MILLISECONDS);
        }
    }

    public void e() {
        if (this.f35490m) {
            this.f35489l.b(this);
            this.f35489l.c();
            this.f35489l.f();
            try {
                this.f35488k.unregisterReceiver(this.B);
            } catch (Throwable th) {
                l2.a(th);
            }
            this.f35490m = false;
        }
    }

    public void f() {
        ScheduledFuture<?> scheduledFuture = this.f35494q;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    public void a(OnNetworkInfoResultListener onNetworkInfoResultListener) {
        this.f35501x = onNetworkInfoResultListener;
    }

    public void a(LocationInfo locationInfo) {
        if (locationInfo.LocationProvider == LocationProviders.Gps) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime >= this.f35491n + 500) {
                this.f35491n = elapsedRealtime;
                ThreadManager.b().a().execute(new a(locationInfo));
            }
        }
    }

    public void a(ServiceState serviceState, int i2) {
        if (this.f35489l.b().b().DefaultDataSimId == i2) {
            int state = serviceState.getState();
            if (state == 1 && this.f35497t == 0) {
                d();
            }
            this.f35497t = state;
        }
    }

    public void a(CellLocation cellLocation, int i2) {
        int i3;
        if (this.f35489l.b().b().DefaultDataSimId == i2 && cellLocation != null) {
            if (cellLocation.getClass().equals(GsmCellLocation.class)) {
                i3 = ((GsmCellLocation) cellLocation).getCid();
            } else {
                i3 = cellLocation.getClass().equals(CdmaCellLocation.class) ? ((CdmaCellLocation) cellLocation).getBaseStationId() : -1;
            }
            int i4 = this.f35499v;
            if (i3 != i4 && i4 != -1 && i3 > 0 && i3 != Integer.MAX_VALUE) {
                this.f35499v = i3;
                a();
            } else if (i3 > 0 && i3 < Integer.MAX_VALUE) {
                this.f35499v = i3;
            }
        }
    }

    private void a() {
        this.f35498u = SystemClock.elapsedRealtime();
        ScheduledFuture<?> scheduledFuture = this.f35493p;
        if (scheduledFuture == null || scheduledFuture.isDone()) {
            this.f35493p = ThreadManager.b().d().scheduleWithFixedDelay(this.f35503z, 0, 1000, TimeUnit.MILLISECONDS);
        }
    }

    /* access modifiers changed from: private */
    public void a(LocationInfo locationInfo, TriggerEvents triggerEvents, boolean z2) {
        NetworkInformationResult networkInformationResult;
        if (locationInfo == null) {
            networkInformationResult = this.f35489l.a(triggerEvents, z2);
        } else {
            networkInformationResult = this.f35489l.a(locationInfo, triggerEvents, z2);
        }
        OnNetworkInfoResultListener onNetworkInfoResultListener = this.f35501x;
        if (onNetworkInfoResultListener != null) {
            onNetworkInfoResultListener.onNetworkInfoResult(networkInformationResult);
        }
    }
}
