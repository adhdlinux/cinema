package com.facebook.ads.internal.adapters;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.ads.AdError;
import com.facebook.ads.internal.view.f.b.z;

public class ad extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private String f19754a;

    /* renamed from: b  reason: collision with root package name */
    private ac f19755b;

    /* renamed from: c  reason: collision with root package name */
    private ab f19756c;

    public ad(String str, ab abVar, ac acVar) {
        this.f19756c = abVar;
        this.f19755b = acVar;
        this.f19754a = str;
    }

    public IntentFilter a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(z.REWARDED_VIDEO_COMPLETE.a(this.f19754a));
        intentFilter.addAction(z.REWARDED_VIDEO_ERROR.a(this.f19754a));
        intentFilter.addAction(z.REWARDED_VIDEO_AD_CLICK.a(this.f19754a));
        intentFilter.addAction(z.REWARDED_VIDEO_IMPRESSION.a(this.f19754a));
        intentFilter.addAction(z.REWARDED_VIDEO_CLOSED.a(this.f19754a));
        intentFilter.addAction(z.REWARD_SERVER_SUCCESS.a(this.f19754a));
        intentFilter.addAction(z.REWARD_SERVER_FAILED.a(this.f19754a));
        intentFilter.addAction(z.REWARDED_VIDEO_ACTIVITY_DESTROYED.a(this.f19754a));
        return intentFilter;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (z.REWARDED_VIDEO_COMPLETE.a(this.f19754a).equals(action)) {
            this.f19755b.d(this.f19756c);
        } else if (z.REWARDED_VIDEO_ERROR.a(this.f19754a).equals(action)) {
            this.f19755b.a(this.f19756c, AdError.INTERNAL_ERROR);
        } else if (z.REWARDED_VIDEO_AD_CLICK.a(this.f19754a).equals(action)) {
            this.f19755b.b(this.f19756c);
        } else if (z.REWARDED_VIDEO_IMPRESSION.a(this.f19754a).equals(action)) {
            this.f19755b.c(this.f19756c);
        } else if (z.REWARDED_VIDEO_CLOSED.a(this.f19754a).equals(action)) {
            this.f19755b.a();
        } else if (z.REWARD_SERVER_FAILED.a(this.f19754a).equals(action)) {
            this.f19755b.e(this.f19756c);
        } else if (z.REWARD_SERVER_SUCCESS.a(this.f19754a).equals(action)) {
            this.f19755b.f(this.f19756c);
        } else if (z.REWARDED_VIDEO_ACTIVITY_DESTROYED.a(this.f19754a).equals(action)) {
            this.f19755b.b();
        }
    }
}
