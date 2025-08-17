package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.m;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class e implements AppLovinBroadcastManager.Receiver {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<e> f15793a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private final o f15794b;

    /* renamed from: c  reason: collision with root package name */
    private final m f15795c;

    private e(long j2, m mVar, final Runnable runnable) {
        this.f15794b = o.a(j2, mVar, new Runnable() {
            public void run() {
                e.this.a();
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
        this.f15795c = mVar;
        f15793a.add(this);
        mVar.aj().registerReceiver(this, new IntentFilter("com.applovin.application_paused"));
        mVar.aj().registerReceiver(this, new IntentFilter("com.applovin.application_resumed"));
    }

    public static e a(long j2, m mVar, Runnable runnable) {
        return new e(j2, mVar, runnable);
    }

    public void a() {
        this.f15794b.d();
        this.f15795c.aj().unregisterReceiver(this);
        f15793a.remove(this);
    }

    public long b() {
        return this.f15794b.a();
    }

    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        String action = intent.getAction();
        if ("com.applovin.application_paused".equals(action)) {
            this.f15794b.b();
        } else if ("com.applovin.application_resumed".equals(action)) {
            this.f15794b.c();
        }
    }
}
