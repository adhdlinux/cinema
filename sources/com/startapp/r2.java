package com.startapp;

import android.location.Location;
import android.os.AsyncTask;
import android.os.SystemClock;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.startapp.networkTest.data.TimeInfo;
import com.startapp.networkTest.enums.TimeSources;
import com.startapp.networkTest.threads.ThreadManager;
import java.util.Date;

public class r2 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f35735a = "r2";

    /* renamed from: b  reason: collision with root package name */
    private static final String f35736b = "0.de.pool.ntp.org";

    /* renamed from: c  reason: collision with root package name */
    private static final long f35737c = 28800000;

    /* renamed from: d  reason: collision with root package name */
    private static final int f35738d = 10000;

    /* renamed from: e  reason: collision with root package name */
    private static final int f35739e = 30000;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f35740f = false;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f35741g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f35742h = false;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public long f35743i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public long f35744j = -1;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public long f35745k = -1;

    /* renamed from: l  reason: collision with root package name */
    private long f35746l = -1;

    /* renamed from: m  reason: collision with root package name */
    private long f35747m = -1;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public q2 f35748n = new q2();

    public r2() {
        if (w0.b().NTP_SYNC_ENABLED()) {
            g();
        }
    }

    public static long d() {
        return w0.f().f();
    }

    public static TimeInfo e() {
        return w0.f().c();
    }

    private long f() {
        if (this.f35742h && this.f35746l > this.f35744j) {
            if (SystemClock.elapsedRealtime() - this.f35744j > f35737c) {
                b();
            }
            return this.f35747m + (SystemClock.elapsedRealtime() - this.f35746l);
        } else if (this.f35741g) {
            if (SystemClock.elapsedRealtime() - this.f35744j > f35737c) {
                b();
            }
            return this.f35745k + (SystemClock.elapsedRealtime() - this.f35744j);
        } else {
            b();
            return System.currentTimeMillis();
        }
    }

    private void g() {
        new a().executeOnExecutor(ThreadManager.b().a(), new Void[0]);
    }

    private TimeInfo c() {
        long j2;
        TimeInfo timeInfo = new TimeInfo();
        boolean z2 = this.f35741g;
        timeInfo.IsSynced = z2 || this.f35742h;
        if (this.f35742h && this.f35746l > this.f35744j) {
            j2 = this.f35747m + (SystemClock.elapsedRealtime() - this.f35746l);
            timeInfo.DeviceDriftMillis = System.currentTimeMillis() - j2;
            timeInfo.MillisSinceLastSync = j2 - this.f35747m;
            timeInfo.TimeSource = TimeSources.GPS;
            if (SystemClock.elapsedRealtime() - this.f35744j > f35737c) {
                b();
            }
        } else if (z2) {
            if (SystemClock.elapsedRealtime() - this.f35744j > f35737c) {
                b();
            }
            j2 = this.f35745k + (SystemClock.elapsedRealtime() - this.f35744j);
            timeInfo.DeviceDriftMillis = System.currentTimeMillis() - j2;
            timeInfo.MillisSinceLastSync = j2 - this.f35745k;
            timeInfo.TimeSource = TimeSources.NTP;
        } else {
            b();
            j2 = System.currentTimeMillis();
            timeInfo.TimeSource = TimeSources.Device;
        }
        timeInfo.setMillis(j2);
        return timeInfo;
    }

    private void b() {
        if (w0.b().NTP_SYNC_ENABLED() && !this.f35740f && SystemClock.elapsedRealtime() - this.f35743i > NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS) {
            g();
        }
    }

    public void a(Location location) {
        this.f35747m = location.getTime();
        this.f35746l = SystemClock.elapsedRealtime();
        this.f35742h = true;
    }

    public class a extends AsyncTask<Void, Void, Void> {
        public a() {
        }

        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            try {
                String unused = r2.f35735a;
                if (r2.this.f35748n.a(r2.f35736b, (int) r2.f35738d)) {
                    long a2 = r2.this.f35748n.a();
                    if (a2 <= 1458564533202L || a2 >= 3468524400000L) {
                        return null;
                    }
                    long unused2 = r2.this.f35744j = SystemClock.elapsedRealtime();
                    long unused3 = r2.this.f35745k = a2;
                    String unused4 = r2.f35735a;
                    new Date(r2.this.f35745k).toString();
                    boolean unused5 = r2.this.f35741g = true;
                    return null;
                }
                String unused6 = r2.f35735a;
                long unused7 = r2.this.f35743i = SystemClock.elapsedRealtime();
                return null;
            } catch (Throwable th) {
                l2.a(th);
                return null;
            }
        }

        public void onPreExecute() {
            boolean unused = r2.this.f35740f = true;
        }

        /* renamed from: a */
        public void onPostExecute(Void voidR) {
            boolean unused = r2.this.f35740f = false;
        }
    }
}
