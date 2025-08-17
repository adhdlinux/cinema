package com.iab.omid.library.adcolony.a;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import com.unity3d.services.core.device.MimeTypes;

public final class d extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private final Context f31282a;

    /* renamed from: b  reason: collision with root package name */
    private final AudioManager f31283b;

    /* renamed from: c  reason: collision with root package name */
    private final a f31284c;

    /* renamed from: d  reason: collision with root package name */
    private final c f31285d;

    /* renamed from: e  reason: collision with root package name */
    private float f31286e;

    public d(Handler handler, Context context, a aVar, c cVar) {
        super(handler);
        this.f31282a = context;
        this.f31283b = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.f31284c = aVar;
        this.f31285d = cVar;
    }

    private boolean b(float f2) {
        return f2 != this.f31286e;
    }

    private float d() {
        return this.f31284c.a(this.f31283b.getStreamVolume(3), this.f31283b.getStreamMaxVolume(3));
    }

    private void e() {
        this.f31285d.a(this.f31286e);
    }

    public void a() {
        this.f31286e = d();
        e();
        this.f31282a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public void c() {
        this.f31282a.getContentResolver().unregisterContentObserver(this);
    }

    public void onChange(boolean z2) {
        super.onChange(z2);
        float d2 = d();
        if (b(d2)) {
            this.f31286e = d2;
            e();
        }
    }
}
