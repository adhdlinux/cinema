package com.startapp;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class z6 {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f36981a = MetaData.f36379h.T();

    /* renamed from: b  reason: collision with root package name */
    public Handler f36982b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public long f36983c;

    /* renamed from: d  reason: collision with root package name */
    public Context f36984d;

    /* renamed from: e  reason: collision with root package name */
    public long f36985e = -1;

    /* renamed from: f  reason: collision with root package name */
    public long f36986f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f36987g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f36988h;

    /* renamed from: i  reason: collision with root package name */
    public String[] f36989i;

    /* renamed from: j  reason: collision with root package name */
    public TrackingParams f36990j;

    /* renamed from: k  reason: collision with root package name */
    public AtomicBoolean f36991k = new AtomicBoolean(false);

    /* renamed from: l  reason: collision with root package name */
    public WeakReference<a> f36992l = new WeakReference<>((Object) null);

    public interface a {
        void onSent();
    }

    public z6(Context context, String[] strArr, TrackingParams trackingParams, long j2) {
        this.f36984d = ia.b(context);
        this.f36989i = strArr;
        this.f36990j = trackingParams;
        this.f36983c = j2;
    }

    public void a() {
        if (this.f36987g && this.f36988h) {
            this.f36982b.removeCallbacksAndMessages((Object) null);
            long currentTimeMillis = System.currentTimeMillis();
            this.f36985e = currentTimeMillis;
            this.f36983c -= currentTimeMillis - this.f36986f;
            this.f36988h = false;
        }
    }

    public void b() {
        if (this.f36991k.get()) {
            return;
        }
        if (f36981a) {
            long j2 = this.f36983c;
            if (!this.f36988h) {
                this.f36988h = true;
                if (!this.f36987g) {
                    this.f36987g = true;
                }
                this.f36986f = System.currentTimeMillis();
                this.f36982b.postDelayed(new y6(this), j2);
                return;
            }
            return;
        }
        b((String) null, (JSONObject) null);
    }

    public void a(String str, JSONObject jSONObject) {
        b(str, jSONObject);
        this.f36987g = false;
        this.f36982b.removeCallbacksAndMessages((Object) null);
        this.f36988h = false;
        this.f36985e = -1;
        this.f36986f = 0;
    }

    public void b(String str, JSONObject jSONObject) {
        if (!this.f36991k.compareAndSet(false, true)) {
            return;
        }
        if (str == null) {
            Context context = this.f36984d;
            String[] strArr = this.f36989i;
            TrackingParams trackingParams = this.f36990j;
            if (strArr != null) {
                for (String str2 : strArr) {
                    if (str2 != null && !str2.equalsIgnoreCase("")) {
                        lb.a(context, false, "Sending impression", true);
                        o6.b(context, str2, trackingParams);
                    }
                }
            }
            a aVar = this.f36992l.get();
            if (aVar != null) {
                aVar.onSent();
                return;
            }
            return;
        }
        o6.a(this.f36984d, this.f36989i, this.f36990j.a(), 0, str, jSONObject);
    }
}
