package com.chartboost.sdk.impl;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import com.unity3d.services.core.device.MimeTypes;

public final class ue extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public final Context f18783a;

    /* renamed from: b  reason: collision with root package name */
    public final AudioManager f18784b;

    /* renamed from: c  reason: collision with root package name */
    public final rd f18785c;

    /* renamed from: d  reason: collision with root package name */
    public final je f18786d;

    /* renamed from: e  reason: collision with root package name */
    public float f18787e;

    public ue(Handler handler, Context context, rd rdVar, je jeVar) {
        super(handler);
        this.f18783a = context;
        this.f18784b = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.f18785c = rdVar;
        this.f18786d = jeVar;
    }

    public final float a() {
        return this.f18785c.a(this.f18784b.getStreamVolume(3), this.f18784b.getStreamMaxVolume(3));
    }

    public final void b() {
        this.f18786d.a(this.f18787e);
    }

    public void c() {
        this.f18787e = a();
        b();
        this.f18783a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public void d() {
        this.f18783a.getContentResolver().unregisterContentObserver(this);
    }

    public void onChange(boolean z2) {
        super.onChange(z2);
        float a2 = a();
        if (a(a2)) {
            this.f18787e = a2;
            b();
        }
    }

    public final boolean a(float f2) {
        return f2 != this.f18787e;
    }
}
