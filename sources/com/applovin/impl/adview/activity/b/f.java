package com.applovin.impl.adview.activity.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.applovin.adview.AppLovinAdView;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.adview.AppLovinVideoView;
import com.applovin.impl.adview.j;
import com.applovin.impl.adview.m;
import com.applovin.impl.adview.s;
import com.applovin.impl.adview.t;
import com.applovin.impl.adview.u;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.e.z;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.g;
import com.applovin.impl.sdk.utils.q;
import com.applovin.impl.sdk.v;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class f extends a implements AppLovinCommunicatorSubscriber {
    protected long A;
    protected boolean B;
    private final com.applovin.impl.adview.activity.a.c C = new com.applovin.impl.adview.activity.a.c(this.f13883a, this.f13887e, this.f13884b);
    /* access modifiers changed from: private */
    public MediaPlayer D;
    /* access modifiers changed from: private */
    public final b E;
    private final a F;
    private final Handler G;
    private final boolean H;
    private int I;
    private int J;
    /* access modifiers changed from: private */
    public boolean K;
    private final AtomicBoolean L;
    private final AtomicBoolean M;
    /* access modifiers changed from: private */
    public long N;
    /* access modifiers changed from: private */
    public long O;

    /* renamed from: s  reason: collision with root package name */
    protected final AppLovinVideoView f13958s;

    /* renamed from: t  reason: collision with root package name */
    protected final com.applovin.impl.adview.a f13959t;

    /* renamed from: u  reason: collision with root package name */
    protected final m f13960u;

    /* renamed from: v  reason: collision with root package name */
    protected final ImageView f13961v;

    /* renamed from: w  reason: collision with root package name */
    protected final t f13962w;

    /* renamed from: x  reason: collision with root package name */
    protected final ProgressBar f13963x;

    /* renamed from: y  reason: collision with root package name */
    protected final j f13964y;

    /* renamed from: z  reason: collision with root package name */
    protected boolean f13965z;

    private class a implements u.a {
        private a() {
        }

        public void a(t tVar) {
            if (v.a()) {
                f.this.f13885c.b("AppLovinFullscreenActivity", "Clicking through from video button...");
            }
            f.this.a(tVar.getAndClearLastClickLocation());
        }

        public void b(t tVar) {
            if (v.a()) {
                f.this.f13885c.b("AppLovinFullscreenActivity", "Closing ad from video button...");
            }
            f.this.h();
        }

        public void c(t tVar) {
            if (v.a()) {
                f.this.f13885c.b("AppLovinFullscreenActivity", "Skipping video from video button...");
            }
            f.this.c();
        }
    }

    private class b implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, AppLovinTouchToClickListener.OnClickListener {
        private b() {
        }

        public void onClick(View view, PointF pointF) {
            f.this.a(pointF);
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            if (v.a()) {
                f.this.f13885c.b("AppLovinFullscreenActivity", "Video completed");
            }
            boolean unused = f.this.K = true;
            f.this.y();
        }

        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            f fVar = f.this;
            fVar.c("Video view error (" + i2 + "," + i3 + ")");
            f.this.f13958s.start();
            return true;
        }

        public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
            if (v.a()) {
                v vVar = f.this.f13885c;
                vVar.b("AppLovinFullscreenActivity", "MediaPlayer Info: (" + i2 + ", " + i3 + ")");
            }
            if (i2 == 701) {
                f.this.v();
                f.this.f13886d.g();
                return false;
            } else if (i2 == 3) {
                f.this.f13964y.a();
                f fVar = f.this;
                if (fVar.f13960u != null) {
                    fVar.A();
                }
                f.this.w();
                if (!f.this.f13899q.c()) {
                    return false;
                }
                f.this.e();
                return false;
            } else if (i2 != 702) {
                return false;
            } else {
                f.this.w();
                return false;
            }
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            MediaPlayer unused = f.this.D = mediaPlayer;
            mediaPlayer.setOnInfoListener(f.this.E);
            mediaPlayer.setOnErrorListener(f.this.E);
            float f2 = f.this.f13965z ^ true ? 1.0f : 0.0f;
            mediaPlayer.setVolume(f2, f2);
            f.this.c((long) mediaPlayer.getDuration());
            f.this.u();
            if (v.a()) {
                v vVar = f.this.f13885c;
                vVar.b("AppLovinFullscreenActivity", "MediaPlayer prepared: " + f.this.D);
            }
        }
    }

    private class c implements View.OnClickListener {
        private c() {
        }

        public void onClick(View view) {
            f fVar = f.this;
            if (view == fVar.f13960u) {
                if (fVar.s()) {
                    f.this.e();
                    f.this.p();
                    f.this.f13899q.b();
                    return;
                }
                f.this.c();
            } else if (view == fVar.f13961v) {
                fVar.x();
            } else if (v.a()) {
                v vVar = f.this.f13885c;
                vVar.e("AppLovinFullscreenActivity", "Unhandled click on widget: " + view);
            }
        }
    }

    public f(e eVar, Activity activity, com.applovin.impl.sdk.m mVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(eVar, activity, mVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        b bVar = new b();
        this.E = bVar;
        a aVar = new a();
        this.F = aVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.G = handler;
        j jVar = new j(handler, this.f13884b);
        this.f13964y = jVar;
        boolean f2 = this.f13883a.f();
        this.H = f2;
        this.f13965z = Utils.isVideoMutedInitially(this.f13884b);
        this.J = -1;
        this.L = new AtomicBoolean();
        this.M = new AtomicBoolean();
        this.N = -2;
        this.O = 0;
        if (eVar.hasVideoUrl()) {
            AppLovinVideoView appLovinVideoView = new AppLovinVideoView(activity);
            this.f13958s = appLovinVideoView;
            appLovinVideoView.setOnPreparedListener(bVar);
            appLovinVideoView.setOnCompletionListener(bVar);
            appLovinVideoView.setOnErrorListener(bVar);
            appLovinVideoView.setOnTouchListener(new AppLovinTouchToClickListener(mVar, com.applovin.impl.sdk.c.b.aM, activity, bVar));
            c cVar = new c();
            if (eVar.q() >= 0) {
                m mVar2 = new m(eVar.w(), activity);
                this.f13960u = mVar2;
                mVar2.setVisibility(8);
                mVar2.setOnClickListener(cVar);
            } else {
                this.f13960u = null;
            }
            if (a(this.f13965z, mVar)) {
                ImageView imageView = new ImageView(activity);
                this.f13961v = imageView;
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setClickable(true);
                imageView.setOnClickListener(cVar);
                e(this.f13965z);
            } else {
                this.f13961v = null;
            }
            String B2 = eVar.B();
            if (StringUtils.isValidString(B2)) {
                u uVar = new u(mVar);
                uVar.a(new WeakReference(aVar));
                t tVar = new t(uVar, activity);
                this.f13962w = tVar;
                tVar.a(B2);
            } else {
                this.f13962w = null;
            }
            if (f2) {
                com.applovin.impl.adview.a aVar2 = new com.applovin.impl.adview.a(activity, ((Integer) mVar.a(com.applovin.impl.sdk.c.b.cB)).intValue(), 16842874);
                this.f13959t = aVar2;
                aVar2.setColor(Color.parseColor("#75FFFFFF"));
                aVar2.setBackgroundColor(Color.parseColor("#00000000"));
                aVar2.setVisibility(8);
                AppLovinCommunicator.getInstance(activity).subscribe((AppLovinCommunicatorSubscriber) this, "video_caching_failed");
            } else {
                this.f13959t = null;
            }
            if (eVar.O()) {
                ProgressBar progressBar = new ProgressBar(activity, (AttributeSet) null, 16842872);
                this.f13963x = progressBar;
                progressBar.setMax(10000);
                progressBar.setPadding(0, 0, 0, 0);
                if (g.d()) {
                    progressBar.setProgressTintList(ColorStateList.valueOf(eVar.P()));
                }
                jVar.a("PROGRESS_BAR", ((Long) mVar.a(com.applovin.impl.sdk.c.b.cy)).longValue(), (j.a) new j.a() {
                    public void a() {
                        f fVar = f.this;
                        if (fVar.B) {
                            fVar.f13963x.setVisibility(8);
                            return;
                        }
                        f fVar2 = f.this;
                        fVar2.f13963x.setProgress((int) ((((float) fVar.f13958s.getCurrentPosition()) / ((float) fVar2.A)) * 10000.0f));
                    }

                    public boolean b() {
                        return !f.this.B;
                    }
                });
                return;
            }
            this.f13963x = null;
            return;
        }
        throw new IllegalStateException("Attempting to use fullscreen video ad presenter for non-video ad");
    }

    /* access modifiers changed from: private */
    public void A() {
        if (this.M.compareAndSet(false, true)) {
            a(this.f13960u, this.f13883a.q(), new Runnable() {
                public void run() {
                    long unused = f.this.N = -1;
                    long unused2 = f.this.O = SystemClock.elapsedRealtime();
                }
            });
        }
    }

    private void B() {
        t tVar;
        s C2 = this.f13883a.C();
        if (C2 != null && C2.e() && !this.B && (tVar = this.f13962w) != null) {
            final boolean z2 = tVar.getVisibility() == 4;
            final long f2 = C2.f();
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    if (z2) {
                        q.a((View) f.this.f13962w, f2, (Runnable) null);
                    } else {
                        q.b(f.this.f13962w, f2, (Runnable) null);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void C() {
        if (this.B) {
            if (v.a()) {
                this.f13885c.d("AppLovinFullscreenActivity", "Skip video resume - postitial shown");
            }
        } else if (this.f13884b.ad().a()) {
            if (v.a()) {
                this.f13885c.d("AppLovinFullscreenActivity", "Skip video resume - app paused");
            }
        } else if (this.J >= 0) {
            if (v.a()) {
                v vVar = this.f13885c;
                vVar.b("AppLovinFullscreenActivity", "Resuming video at position " + this.J + "ms for MediaPlayer: " + this.D);
            }
            this.f13958s.seekTo(this.J);
            this.f13958s.start();
            this.f13964y.a();
            this.J = -1;
            a((Runnable) new Runnable() {
                public void run() {
                    com.applovin.impl.adview.a aVar = f.this.f13959t;
                    if (aVar != null) {
                        aVar.a();
                        f.this.a((Runnable) new Runnable() {
                            public void run() {
                                f.this.f13959t.b();
                            }
                        }, 2000);
                    }
                }
            }, 250);
        } else if (v.a()) {
            this.f13885c.b("AppLovinFullscreenActivity", "Invalid last video position");
        }
    }

    private static boolean a(boolean z2, com.applovin.impl.sdk.m mVar) {
        if (!((Boolean) mVar.a(com.applovin.impl.sdk.c.b.cq)).booleanValue()) {
            return false;
        }
        if (!((Boolean) mVar.a(com.applovin.impl.sdk.c.b.cr)).booleanValue() || z2) {
            return true;
        }
        return ((Boolean) mVar.a(com.applovin.impl.sdk.c.b.ct)).booleanValue();
    }

    private void d(boolean z2) {
        this.I = z();
        if (z2) {
            this.f13958s.pause();
        } else {
            this.f13958s.stopPlayback();
        }
    }

    private void e(boolean z2) {
        if (g.d()) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) this.f13887e.getDrawable(z2 ? R.drawable.unmute_to_mute : R.drawable.mute_to_unmute);
            if (animatedVectorDrawable != null) {
                this.f13961v.setScaleType(ImageView.ScaleType.FIT_XY);
                this.f13961v.setImageDrawable(animatedVectorDrawable);
                animatedVectorDrawable.start();
                return;
            }
        }
        Uri aC = z2 ? this.f13883a.aC() : this.f13883a.aD();
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        this.f13961v.setImageURI(aC);
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    public void a() {
        if (v.a()) {
            this.f13885c.b("AppLovinFullscreenActivity", "Continue video from prompt - will resume in onWindowFocusChanged(true) when alert dismisses");
        }
    }

    public void a(long j2) {
        a((Runnable) new Runnable() {
            public void run() {
                f.this.C();
            }
        }, j2);
    }

    /* access modifiers changed from: protected */
    public void a(PointF pointF) {
        if (this.f13883a.D()) {
            if (v.a()) {
                this.f13885c.b("AppLovinFullscreenActivity", "Clicking through video");
            }
            Uri k2 = this.f13883a.k();
            if (k2 != null) {
                AppLovinAdView appLovinAdView = this.f13888f;
                this.f13884b.u().trackAndLaunchVideoClick(this.f13883a, k2, pointF, this, appLovinAdView != null ? appLovinAdView.getContext() : this.f13884b.L());
                com.applovin.impl.sdk.utils.j.a(this.f13896n, (AppLovinAd) this.f13883a);
                this.f13886d.b();
                this.f13893k++;
                return;
            }
            return;
        }
        B();
    }

    public void a(ViewGroup viewGroup) {
        String str;
        this.C.a(this.f13961v, this.f13960u, this.f13962w, this.f13959t, this.f13963x, this.f13958s, this.f13888f, viewGroup);
        if (g.g() && (str = this.f13884b.p().getExtraParameters().get("audio_focus_request")) != null) {
            this.f13958s.setAudioFocusRequest(Integer.parseInt(str));
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        a(!this.H);
        this.f13958s.setVideoURI(this.f13883a.h());
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        if (this.f13883a.am()) {
            this.f13899q.a(this.f13883a, (Runnable) new Runnable() {
                public void run() {
                    f.this.a(250);
                }
            });
        }
        this.f13958s.start();
        if (this.H) {
            v();
        }
        this.f13888f.renderAd(this.f13883a);
        this.f13886d.b(this.H ? 1 : 0);
        if (this.f13960u != null) {
            this.f13884b.S().a(new z(this.f13884b, new Runnable() {
                public void run() {
                    f.this.A();
                }
            }), o.a.MAIN, this.f13883a.r(), true);
        }
        super.b(this.f13965z);
    }

    public void b() {
        if (v.a()) {
            this.f13885c.b("AppLovinFullscreenActivity", "Skipping video from prompt");
        }
        c();
    }

    public void c() {
        this.N = SystemClock.elapsedRealtime() - this.O;
        if (v.a()) {
            this.f13885c.b("AppLovinFullscreenActivity", "Skipping video with skip time: " + this.N + "ms");
        }
        this.f13886d.f();
        this.f13892j++;
        if (this.f13883a.x()) {
            h();
        } else {
            y();
        }
    }

    /* access modifiers changed from: protected */
    public void c(long j2) {
        this.A = j2;
    }

    /* access modifiers changed from: protected */
    public void c(String str) {
        if (v.a()) {
            v vVar = this.f13885c;
            vVar.e("AppLovinFullscreenActivity", "Encountered media error: " + str + " for ad: " + this.f13883a);
        }
        if (this.L.compareAndSet(false, true)) {
            AppLovinAdDisplayListener appLovinAdDisplayListener = this.f13897o;
            if (appLovinAdDisplayListener instanceof com.applovin.impl.sdk.ad.g) {
                ((com.applovin.impl.sdk.ad.g) appLovinAdDisplayListener).onAdDisplayFailed(str);
            }
            h();
        }
    }

    public void c(boolean z2) {
        super.c(z2);
        if (z2) {
            a(0);
        } else if (!this.B) {
            e();
        }
    }

    public void d() {
        a((ViewGroup) null);
    }

    public void e() {
        if (v.a()) {
            this.f13885c.b("AppLovinFullscreenActivity", "Pausing video");
        }
        this.J = this.f13958s.getCurrentPosition();
        this.f13958s.pause();
        this.f13964y.c();
        if (v.a()) {
            v vVar = this.f13885c;
            vVar.b("AppLovinFullscreenActivity", "Paused video at position " + this.J + "ms");
        }
    }

    public String getCommunicatorId() {
        return "FullscreenVideoAdPresenter";
    }

    public void h() {
        this.f13964y.b();
        this.G.removeCallbacksAndMessages((Object) null);
        m();
        super.h();
    }

    @SuppressLint({"LongLogTag"})
    public void k() {
        if (v.a()) {
            this.f13885c.c("AppLovinFullscreenActivity", "Destroying video components");
        }
        try {
            if (this.H) {
                AppLovinCommunicator.getInstance(this.f13887e).unsubscribe((AppLovinCommunicatorSubscriber) this, "video_caching_failed");
            }
            AppLovinVideoView appLovinVideoView = this.f13958s;
            if (appLovinVideoView != null) {
                appLovinVideoView.pause();
                this.f13958s.stopPlayback();
            }
            MediaPlayer mediaPlayer = this.D;
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
        } catch (Throwable th) {
            Log.e("AppLovinFullscreenActivity", "Unable to destroy presenter", th);
        }
        super.k();
    }

    /* access modifiers changed from: protected */
    public void m() {
        super.a(z(), this.H, r(), this.N);
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("video_caching_failed".equals(appLovinCommunicatorMessage.getTopic())) {
            Bundle messageData = appLovinCommunicatorMessage.getMessageData();
            long j2 = messageData.getLong("ad_id");
            if (((Boolean) this.f13884b.a(com.applovin.impl.sdk.c.b.eM)).booleanValue() && j2 == this.f13883a.getAdIdNumber() && this.H) {
                int i2 = messageData.getInt("load_response_code");
                String string = messageData.getString("load_exception_message");
                if ((string != null || i2 < 200 || i2 >= 300) && !this.K && !this.f13958s.isPlaying()) {
                    c("Video cache error during stream. ResponseCode=" + i2 + ", exception=" + string);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean r() {
        return z() >= this.f13883a.Q();
    }

    /* access modifiers changed from: protected */
    public boolean s() {
        return t() && !r();
    }

    /* access modifiers changed from: protected */
    public void u() {
        long j2;
        int l2;
        long j3 = 0;
        if (this.f13883a.ad() >= 0 || this.f13883a.ae() >= 0) {
            int i2 = (this.f13883a.ad() > 0 ? 1 : (this.f13883a.ad() == 0 ? 0 : -1));
            e eVar = this.f13883a;
            if (i2 >= 0) {
                j2 = eVar.ad();
            } else {
                com.applovin.impl.sdk.ad.a aVar = (com.applovin.impl.sdk.ad.a) eVar;
                long j4 = this.A;
                if (j4 > 0) {
                    j3 = 0 + j4;
                }
                if (aVar.af() && ((l2 = (int) ((com.applovin.impl.sdk.ad.a) this.f13883a).l()) > 0 || (l2 = (int) aVar.s()) > 0)) {
                    j3 += TimeUnit.SECONDS.toMillis((long) l2);
                }
                j2 = (long) (((double) j3) * (((double) this.f13883a.ae()) / 100.0d));
            }
            b(j2);
        }
    }

    /* access modifiers changed from: protected */
    public void v() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                com.applovin.impl.adview.a aVar = f.this.f13959t;
                if (aVar != null) {
                    aVar.a();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void w() {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                com.applovin.impl.adview.a aVar = f.this.f13959t;
                if (aVar != null) {
                    aVar.b();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void x() {
        MediaPlayer mediaPlayer = this.D;
        if (mediaPlayer != null) {
            try {
                boolean z2 = false;
                float f2 = (float) (!this.f13965z ? 0 : 1);
                mediaPlayer.setVolume(f2, f2);
                if (!this.f13965z) {
                    z2 = true;
                }
                this.f13965z = z2;
                e(z2);
                a(this.f13965z, 0);
            } catch (Throwable unused) {
            }
        }
    }

    public void y() {
        if (v.a()) {
            this.f13885c.b("AppLovinFullscreenActivity", "Showing postitial...");
        }
        d(this.f13883a.aJ());
        this.C.a(this.f13889g, this.f13888f);
        a("javascript:al_onPoststitialShow(" + this.f13892j + "," + this.f13893k + ");", (long) this.f13883a.S());
        if (this.f13889g != null) {
            int i2 = (this.f13883a.s() > 0 ? 1 : (this.f13883a.s() == 0 ? 0 : -1));
            m mVar = this.f13889g;
            if (i2 >= 0) {
                a(mVar, this.f13883a.s(), new Runnable() {
                    public void run() {
                        f.this.f13891i = SystemClock.elapsedRealtime();
                    }
                });
            } else {
                mVar.setVisibility(0);
            }
        }
        this.B = true;
    }

    /* access modifiers changed from: protected */
    public int z() {
        long currentPosition = (long) this.f13958s.getCurrentPosition();
        if (this.K) {
            return 100;
        }
        return currentPosition > 0 ? (int) ((((float) currentPosition) / ((float) this.A)) * 100.0f) : this.I;
    }
}
