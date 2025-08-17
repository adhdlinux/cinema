package com.adcolony.sdk;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import com.unity3d.services.core.device.MimeTypes;

class i extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private AudioManager f13161a;

    /* renamed from: b  reason: collision with root package name */
    private AdColonyInterstitial f13162b;

    i(Handler handler, AdColonyInterstitial adColonyInterstitial) {
        super(handler);
        Context a2 = a.a();
        if (a2 != null) {
            this.f13161a = (AudioManager) a2.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            this.f13162b = adColonyInterstitial;
            a2.getApplicationContext().getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        Context a2 = a.a();
        if (a2 != null) {
            a2.getApplicationContext().getContentResolver().unregisterContentObserver(this);
        }
        this.f13162b = null;
        this.f13161a = null;
    }

    public boolean deliverSelfNotifications() {
        return false;
    }

    public void onChange(boolean z2) {
        AdColonyInterstitial adColonyInterstitial;
        if (this.f13161a != null && (adColonyInterstitial = this.f13162b) != null && adColonyInterstitial.p() != null) {
            double streamVolume = (double) ((((float) this.f13161a.getStreamVolume(3)) / 15.0f) * 100.0f);
            f1 q2 = c0.q();
            c0.k(q2, "audio_percentage", streamVolume);
            c0.n(q2, "ad_session_id", this.f13162b.p().b());
            c0.u(q2, "id", this.f13162b.p().p());
            new h0("AdContainer.on_audio_change", this.f13162b.p().I(), q2).e();
        }
    }
}
