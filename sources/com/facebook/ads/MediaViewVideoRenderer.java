package com.facebook.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.ads.internal.j.f;
import com.facebook.ads.internal.view.f.b.b;
import com.facebook.ads.internal.view.f.b.c;
import com.facebook.ads.internal.view.f.b.d;
import com.facebook.ads.internal.view.f.b.e;
import com.facebook.ads.internal.view.f.b.h;
import com.facebook.ads.internal.view.f.b.i;
import com.facebook.ads.internal.view.f.b.k;
import com.facebook.ads.internal.view.f.b.l;
import com.facebook.ads.internal.view.f.b.m;
import com.facebook.ads.internal.view.f.b.p;
import com.facebook.ads.internal.view.f.b.q;
import com.facebook.ads.internal.view.f.b.v;
import com.facebook.ads.internal.view.f.b.w;
import com.facebook.ads.internal.view.j;

public abstract class MediaViewVideoRenderer extends FrameLayout {

    /* renamed from: d  reason: collision with root package name */
    private static final String f19493d = "MediaViewVideoRenderer";

    /* renamed from: a  reason: collision with root package name */
    protected NativeAd f19494a;

    /* renamed from: b  reason: collision with root package name */
    protected VideoAutoplayBehavior f19495b;

    /* renamed from: c  reason: collision with root package name */
    final j f19496c;

    /* renamed from: e  reason: collision with root package name */
    private final m f19497e = new m() {
        public void a(l lVar) {
            MediaViewVideoRenderer.this.onPrepared();
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final k f19498f = new k() {
        public void a(com.facebook.ads.internal.view.f.b.j jVar) {
            NativeAd nativeAd = MediaViewVideoRenderer.this.f19494a;
            if (nativeAd != null) {
                nativeAd.g().a(true, true);
            }
            MediaViewVideoRenderer.this.onPlayed();
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final i f19499g = new i() {
        public void a(h hVar) {
            MediaViewVideoRenderer.this.onPaused();
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private final q f19500h = new q() {
        public void a(p pVar) {
            MediaViewVideoRenderer.this.onSeek();
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private final c f19501i = new c() {
        public void a(b bVar) {
            MediaViewVideoRenderer.this.onCompleted();
        }
    };

    /* renamed from: j  reason: collision with root package name */
    private final w f19502j = new w() {
        public void a(v vVar) {
            MediaViewVideoRenderer.this.onVolumeChanged();
        }
    };

    /* renamed from: k  reason: collision with root package name */
    private final e f19503k = new e() {
        public void a(d dVar) {
            NativeAd nativeAd = MediaViewVideoRenderer.this.f19494a;
            if (nativeAd != null) {
                nativeAd.g().a(false, true);
            }
            MediaViewVideoRenderer.this.onError();
        }
    };

    /* renamed from: l  reason: collision with root package name */
    private boolean f19504l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f19505m;

    public MediaViewVideoRenderer(Context context) {
        super(context);
        this.f19496c = new j(context);
        b();
    }

    public MediaViewVideoRenderer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19496c = new j(context, attributeSet);
        b();
    }

    public MediaViewVideoRenderer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f19496c = new j(context, attributeSet, i2);
        b();
    }

    @TargetApi(21)
    public MediaViewVideoRenderer(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f19496c = new j(context, attributeSet, i2, i3);
        b();
    }

    private void b() {
        this.f19496c.setEnableBackgroundVideo(shouldAllowBackgroundPlayback());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.f19496c.setLayoutParams(layoutParams);
        super.addView(this.f19496c, -1, layoutParams);
        com.facebook.ads.internal.q.a.j.a(this.f19496c, com.facebook.ads.internal.q.a.j.INTERNAL_AD_MEDIA);
        this.f19496c.getEventBus().a((T[]) new f[]{this.f19497e, this.f19498f, this.f19499g, this.f19500h, this.f19501i, this.f19502j, this.f19503k});
    }

    /* access modifiers changed from: protected */
    public void a() {
        pause(false);
        this.f19496c.a((String) null, (String) null);
        this.f19496c.setVideoMPD((String) null);
        this.f19496c.setVideoURI((Uri) null);
        this.f19496c.setVideoCTA((String) null);
        this.f19496c.setNativeAd((NativeAd) null);
        this.f19495b = VideoAutoplayBehavior.DEFAULT;
        NativeAd nativeAd = this.f19494a;
        if (nativeAd != null) {
            nativeAd.g().a(false, false);
        }
        this.f19494a = null;
    }

    public void addView(View view) {
    }

    public void addView(View view, int i2) {
    }

    public void addView(View view, int i2, int i3) {
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
    }

    public void destroy() {
        this.f19496c.k();
    }

    public final void disengageSeek(VideoStartReason videoStartReason) {
        if (!this.f19504l) {
            Log.w(f19493d, "disengageSeek called without engageSeek.");
            return;
        }
        this.f19504l = false;
        if (this.f19505m) {
            this.f19496c.a(videoStartReason.a());
        }
        onSeekDisengaged();
    }

    public final void engageSeek() {
        if (this.f19504l) {
            Log.w(f19493d, "engageSeek called without disengageSeek.");
            return;
        }
        this.f19504l = true;
        this.f19505m = com.facebook.ads.internal.view.f.d.d.STARTED.equals(this.f19496c.getState());
        this.f19496c.a(false);
        onSeekEngaged();
    }

    public final int getCurrentTimeMs() {
        return this.f19496c.getCurrentPositionInMillis();
    }

    public final int getDuration() {
        return this.f19496c.getDuration();
    }

    /* access modifiers changed from: package-private */
    public final View getVideoView() {
        return this.f19496c.getVideoView();
    }

    public final float getVolume() {
        return this.f19496c.getVolume();
    }

    public void onCompleted() {
    }

    public void onError() {
    }

    public void onPaused() {
    }

    public void onPlayed() {
    }

    public void onPrepared() {
    }

    public void onSeek() {
    }

    public void onSeekDisengaged() {
    }

    public void onSeekEngaged() {
    }

    public void onVolumeChanged() {
    }

    public final void pause(boolean z2) {
        this.f19496c.a(z2);
    }

    public final void play(VideoStartReason videoStartReason) {
        this.f19496c.a(videoStartReason.a());
    }

    public final void seekTo(int i2) {
        if (!this.f19504l) {
            Log.w(f19493d, "Seeking must be preceded by a call to engageSeek, and followed by a call to disengageSeek.");
        } else {
            this.f19496c.a(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void setAdEventManager(com.facebook.ads.internal.m.c cVar) {
        this.f19496c.setAdEventManager(cVar);
    }

    /* access modifiers changed from: package-private */
    public final void setListener(com.facebook.ads.internal.view.k kVar) {
        this.f19496c.setListener(kVar);
    }

    /* access modifiers changed from: protected */
    public void setNativeAd(NativeAd nativeAd) {
        this.f19494a = nativeAd;
        this.f19496c.a(nativeAd.c(), nativeAd.i());
        this.f19496c.setVideoMPD(nativeAd.b());
        this.f19496c.setVideoURI(nativeAd.a());
        this.f19496c.setVideoProgressReportIntervalMs(nativeAd.h().D());
        this.f19496c.setVideoCTA(nativeAd.getAdCallToAction());
        this.f19496c.setNativeAd(nativeAd);
        this.f19495b = nativeAd.d();
    }

    public final void setVolume(float f2) {
        this.f19496c.setVolume(f2);
    }

    public boolean shouldAllowBackgroundPlayback() {
        return false;
    }

    public final boolean shouldAutoplay() {
        j jVar = this.f19496c;
        return (jVar == null || jVar.getState() == com.facebook.ads.internal.view.f.d.d.PLAYBACK_COMPLETED || this.f19495b != VideoAutoplayBehavior.ON) ? false : true;
    }
}
