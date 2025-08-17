package com.iab.omid.library.applovin.a;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import com.unity3d.services.core.device.MimeTypes;

public final class d extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private final Context f31464a;

    /* renamed from: b  reason: collision with root package name */
    private final AudioManager f31465b;

    /* renamed from: c  reason: collision with root package name */
    private final a f31466c;

    /* renamed from: d  reason: collision with root package name */
    private final c f31467d;

    /* renamed from: e  reason: collision with root package name */
    private float f31468e;

    public d(Handler handler, Context context, a aVar, c cVar) {
        super(handler);
        this.f31464a = context;
        this.f31465b = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.f31466c = aVar;
        this.f31467d = cVar;
    }

    private boolean a(float f2) {
        return f2 != this.f31468e;
    }

    private float c() {
        return this.f31466c.a(this.f31465b.getStreamVolume(3), this.f31465b.getStreamMaxVolume(3));
    }

    private void d() {
        this.f31467d.a(this.f31468e);
    }

    public void a() {
        this.f31468e = c();
        d();
        this.f31464a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public void b() {
        this.f31464a.getContentResolver().unregisterContentObserver(this);
    }

    public void onChange(boolean z2) {
        super.onChange(z2);
        float c2 = c();
        if (a(c2)) {
            this.f31468e = c2;
            d();
        }
    }
}
