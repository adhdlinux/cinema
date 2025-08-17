package com.startapp;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import com.iab.omid.library.startio.publisher.AdSessionStatePublisher;
import com.unity3d.services.core.device.MimeTypes;
import java.util.Collections;

public final class e extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public final Context f34387a;

    /* renamed from: b  reason: collision with root package name */
    public final AudioManager f34388b;

    /* renamed from: c  reason: collision with root package name */
    public final b f34389c;

    /* renamed from: d  reason: collision with root package name */
    public final d f34390d;

    /* renamed from: e  reason: collision with root package name */
    public float f34391e;

    public e(Handler handler, Context context, b bVar, d dVar) {
        super(handler);
        this.f34387a = context;
        this.f34388b = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.f34389c = bVar;
        this.f34390d = dVar;
    }

    public final float a() {
        int streamVolume = this.f34388b.getStreamVolume(3);
        int streamMaxVolume = this.f34388b.getStreamMaxVolume(3);
        this.f34389c.getClass();
        if (streamMaxVolume <= 0 || streamVolume <= 0) {
            return 0.0f;
        }
        float f2 = ((float) streamVolume) / ((float) streamMaxVolume);
        if (f2 > 1.0f) {
            return 1.0f;
        }
        return f2;
    }

    public final void b() {
        d dVar = this.f34390d;
        float f2 = this.f34391e;
        m mVar = (m) dVar;
        mVar.f34886b = f2;
        if (mVar.f34890f == null) {
            mVar.f34890f = g.f34545a;
        }
        for (T t2 : Collections.unmodifiableCollection(mVar.f34890f.f34547c)) {
            AdSessionStatePublisher adSessionStatePublisher = t2.f36850f;
            l.f34848a.a(adSessionStatePublisher.c(), "setDeviceVolume", Float.valueOf(f2));
        }
    }

    public void onChange(boolean z2) {
        boolean z3;
        super.onChange(z2);
        float a2 = a();
        if (a2 != this.f34391e) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            this.f34391e = a2;
            b();
        }
    }
}
