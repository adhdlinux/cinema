package com.facebook.ads.internal.adapters;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.ads.internal.view.f.a.a;
import com.facebook.ads.internal.view.f.b.b;
import com.facebook.ads.internal.view.f.b.f;
import com.facebook.ads.internal.view.f.b.g;
import com.facebook.ads.internal.view.f.b.h;
import com.facebook.ads.internal.view.f.b.p;
import com.facebook.ads.internal.view.j;
import java.io.Serializable;

public class ae extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private Context f19757a;

    /* renamed from: b  reason: collision with root package name */
    private j f19758b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f19759c = false;

    public ae(j jVar, Context context) {
        this.f19758b = jVar;
        this.f19757a = context.getApplicationContext();
    }

    public void a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.ads.interstitial.displayed:" + this.f19758b.getUniqueId());
        intentFilter.addAction("videoInterstitalEvent:" + this.f19758b.getUniqueId());
        intentFilter.addAction("performCtaClick:" + this.f19758b.getUniqueId());
        LocalBroadcastManager.b(this.f19757a).c(this, intentFilter);
    }

    public void b() {
        try {
            LocalBroadcastManager.b(this.f19757a).e(this);
        } catch (Exception unused) {
        }
    }

    public void onReceive(Context context, Intent intent) {
        String[] split = intent.getAction().split(":");
        if (split.length != 2 || !split[1].equals(this.f19758b.getUniqueId())) {
            return;
        }
        if (split[0].equals("com.facebook.ads.interstitial.displayed")) {
            if (this.f19758b.getListener() != null) {
                this.f19758b.getListener().g();
                this.f19758b.getListener().a();
            }
        } else if (split[0].equals("videoInterstitalEvent")) {
            Serializable serializableExtra = intent.getSerializableExtra("event");
            if (serializableExtra instanceof p) {
                if (this.f19758b.getListener() != null) {
                    this.f19758b.getListener().f();
                    this.f19758b.getListener().a();
                }
                if (this.f19759c) {
                    this.f19758b.a(1);
                } else {
                    this.f19758b.a(((p) serializableExtra).b());
                }
                this.f19758b.setVisibility(0);
                this.f19758b.a(a.USER_STARTED);
            } else if (serializableExtra instanceof f) {
                if (this.f19758b.getListener() != null) {
                    this.f19758b.getListener().d();
                }
            } else if (serializableExtra instanceof g) {
                if (this.f19758b.getListener() != null) {
                    this.f19758b.getListener().e();
                }
            } else if (serializableExtra instanceof b) {
                if (this.f19758b.getListener() != null) {
                    this.f19758b.getListener().h();
                }
                this.f19759c = true;
            } else if (serializableExtra instanceof com.facebook.ads.internal.view.f.b.j) {
                if (this.f19758b.getListener() != null) {
                    this.f19758b.getListener().c();
                }
                this.f19759c = false;
            } else if ((serializableExtra instanceof h) && this.f19758b.getListener() != null) {
                this.f19758b.getListener().b();
            }
        } else if (split[0].equals("performCtaClick")) {
            this.f19758b.b();
        }
    }
}
