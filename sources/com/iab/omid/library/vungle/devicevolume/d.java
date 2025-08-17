package com.iab.omid.library.vungle.devicevolume;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import com.unity3d.services.core.device.MimeTypes;

public final class d extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private final Context f31691a;

    /* renamed from: b  reason: collision with root package name */
    private final AudioManager f31692b;

    /* renamed from: c  reason: collision with root package name */
    private final a f31693c;

    /* renamed from: d  reason: collision with root package name */
    private final c f31694d;

    /* renamed from: e  reason: collision with root package name */
    private float f31695e;

    public d(Handler handler, Context context, a aVar, c cVar) {
        super(handler);
        this.f31691a = context;
        this.f31692b = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.f31693c = aVar;
        this.f31694d = cVar;
    }

    private float a() {
        return this.f31693c.a(this.f31692b.getStreamVolume(3), this.f31692b.getStreamMaxVolume(3));
    }

    private boolean b(float f2) {
        return f2 != this.f31695e;
    }

    private void c() {
        this.f31694d.a(this.f31695e);
    }

    public void d() {
        this.f31695e = a();
        c();
        this.f31691a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public void e() {
        this.f31691a.getContentResolver().unregisterContentObserver(this);
    }

    public void onChange(boolean z2) {
        super.onChange(z2);
        float a2 = a();
        if (b(a2)) {
            this.f31695e = a2;
            c();
        }
    }
}
