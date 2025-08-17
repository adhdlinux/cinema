package com.applovin.impl.adview.activity.b;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.applovin.adview.AppLovinAdView;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.adview.j;
import com.applovin.impl.adview.m;
import com.applovin.impl.adview.s;
import com.applovin.impl.adview.t;
import com.applovin.impl.adview.u;
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
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class e extends a implements AppLovinCommunicatorSubscriber {
    protected boolean A;
    protected long B;
    protected int C;
    protected boolean D;
    protected boolean E;
    private final com.applovin.impl.adview.activity.a.c F = new com.applovin.impl.adview.activity.a.c(this.f13883a, this.f13887e, this.f13884b);
    private final a G;
    private final Handler H;
    private final boolean I;
    private long J;
    private final AtomicBoolean K;
    private final AtomicBoolean L;
    /* access modifiers changed from: private */
    public long M;
    /* access modifiers changed from: private */
    public long N;

    /* renamed from: s  reason: collision with root package name */
    protected final PlayerView f13936s;

    /* renamed from: t  reason: collision with root package name */
    protected final SimpleExoPlayer f13937t;

    /* renamed from: u  reason: collision with root package name */
    protected final com.applovin.impl.adview.a f13938u;

    /* renamed from: v  reason: collision with root package name */
    protected final m f13939v;

    /* renamed from: w  reason: collision with root package name */
    protected final ImageView f13940w;

    /* renamed from: x  reason: collision with root package name */
    protected final t f13941x;

    /* renamed from: y  reason: collision with root package name */
    protected final ProgressBar f13942y;

    /* renamed from: z  reason: collision with root package name */
    protected final j f13943z;

    private class a implements u.a {
        private a() {
        }

        public void a(t tVar) {
            if (v.a()) {
                e.this.f13885c.b("AppLovinFullscreenActivity", "Clicking through from video button...");
            }
            e.this.a(tVar.getAndClearLastClickLocation());
        }

        public void b(t tVar) {
            if (v.a()) {
                e.this.f13885c.b("AppLovinFullscreenActivity", "Closing ad from video button...");
            }
            e.this.h();
        }

        public void c(t tVar) {
            if (v.a()) {
                e.this.f13885c.b("AppLovinFullscreenActivity", "Skipping video from video button...");
            }
            e.this.c();
        }
    }

    private class b implements AppLovinTouchToClickListener.OnClickListener, Player.EventListener, PlayerControlView.VisibilityListener {
        private b() {
        }

        public void onClick(View view, PointF pointF) {
            e.this.a(pointF);
        }

        public void onPlaybackStateChanged(int i2) {
            if (v.a()) {
                v vVar = e.this.f13885c;
                vVar.b("AppLovinFullscreenActivity", "Player state changed to state " + i2 + " and will play when ready: " + e.this.f13937t.A());
            }
            if (i2 == 2) {
                e.this.v();
                e.this.f13886d.g();
            } else if (i2 == 3) {
                e eVar = e.this;
                eVar.f13937t.d(eVar.A ^ true ? 1.0f : 0.0f);
                e eVar2 = e.this;
                eVar2.c(eVar2.f13937t.getDuration());
                e.this.u();
                if (v.a()) {
                    v vVar2 = e.this.f13885c;
                    vVar2.b("AppLovinFullscreenActivity", "MediaPlayer prepared: " + e.this.f13937t);
                }
                e.this.f13943z.a();
                e eVar3 = e.this;
                if (eVar3.f13939v != null) {
                    eVar3.A();
                }
                e.this.w();
                if (e.this.f13899q.c()) {
                    e.this.e();
                }
            } else if (i2 == 4) {
                if (v.a()) {
                    e.this.f13885c.b("AppLovinFullscreenActivity", "Video completed");
                }
                e eVar4 = e.this;
                eVar4.E = true;
                eVar4.y();
            }
        }

        public void onPlayerError(PlaybackException playbackException) {
            e eVar = e.this;
            eVar.c("Video view error (" + playbackException + ")");
            e.this.h();
        }

        public void onVisibilityChange(int i2) {
            if (i2 == 0) {
                e.this.f13936s.u();
            }
        }
    }

    private class c implements View.OnClickListener {
        private c() {
        }

        public void onClick(View view) {
            e eVar = e.this;
            if (view == eVar.f13939v) {
                if (eVar.s()) {
                    e.this.e();
                    e.this.p();
                    e.this.f13899q.b();
                    return;
                }
                e.this.c();
            } else if (view == eVar.f13940w) {
                eVar.x();
            } else if (v.a()) {
                v vVar = e.this.f13885c;
                vVar.e("AppLovinFullscreenActivity", "Unhandled click on widget: " + view);
            }
        }
    }

    public e(com.applovin.impl.sdk.ad.e eVar, Activity activity, com.applovin.impl.sdk.m mVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(eVar, activity, mVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        a aVar = new a();
        this.G = aVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.H = handler;
        j jVar = new j(handler, this.f13884b);
        this.f13943z = jVar;
        boolean f2 = this.f13883a.f();
        this.I = f2;
        this.A = Utils.isVideoMutedInitially(this.f13884b);
        this.J = -1;
        this.K = new AtomicBoolean();
        this.L = new AtomicBoolean();
        this.M = -2;
        this.N = 0;
        if (eVar.hasVideoUrl()) {
            c cVar = new c();
            if (eVar.q() >= 0) {
                m mVar2 = new m(eVar.w(), activity);
                this.f13939v = mVar2;
                mVar2.setVisibility(8);
                mVar2.setOnClickListener(cVar);
            } else {
                this.f13939v = null;
            }
            if (a(this.A, mVar)) {
                ImageView imageView = new ImageView(activity);
                this.f13940w = imageView;
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setClickable(true);
                imageView.setOnClickListener(cVar);
                d(this.A);
            } else {
                this.f13940w = null;
            }
            String B2 = eVar.B();
            if (StringUtils.isValidString(B2)) {
                u uVar = new u(mVar);
                uVar.a(new WeakReference(aVar));
                t tVar = new t(uVar, activity);
                this.f13941x = tVar;
                tVar.a(B2);
            } else {
                this.f13941x = null;
            }
            if (f2) {
                com.applovin.impl.adview.a aVar2 = new com.applovin.impl.adview.a(activity, ((Integer) mVar.a(com.applovin.impl.sdk.c.b.cB)).intValue(), 16842874);
                this.f13938u = aVar2;
                aVar2.setColor(Color.parseColor("#75FFFFFF"));
                aVar2.setBackgroundColor(Color.parseColor("#00000000"));
                aVar2.setVisibility(8);
                AppLovinCommunicator.getInstance(activity).subscribe((AppLovinCommunicatorSubscriber) this, "video_caching_failed");
            } else {
                this.f13938u = null;
            }
            if (eVar.O()) {
                ProgressBar progressBar = new ProgressBar(activity, (AttributeSet) null, 16842872);
                this.f13942y = progressBar;
                progressBar.setMax(10000);
                progressBar.setPadding(0, 0, 0, 0);
                if (g.d()) {
                    progressBar.setProgressTintList(ColorStateList.valueOf(eVar.P()));
                }
                jVar.a("PROGRESS_BAR", ((Long) mVar.a(com.applovin.impl.sdk.c.b.cy)).longValue(), (j.a) new j.a() {
                    public void a() {
                        e eVar = e.this;
                        if (eVar.D) {
                            eVar.f13942y.setVisibility(8);
                            return;
                        }
                        e eVar2 = e.this;
                        eVar2.f13942y.setProgress((int) ((((float) eVar.f13937t.getCurrentPosition()) / ((float) eVar2.B)) * 10000.0f));
                    }

                    public boolean b() {
                        return !e.this.D;
                    }
                });
            } else {
                this.f13942y = null;
            }
            SimpleExoPlayer a2 = new SimpleExoPlayer.Builder(activity).a();
            this.f13937t = a2;
            b bVar = new b();
            a2.addListener(bVar);
            a2.setRepeatMode(0);
            PlayerView playerView = new PlayerView(activity);
            this.f13936s = playerView;
            playerView.u();
            playerView.setControllerVisibilityListener(bVar);
            playerView.setPlayer(a2);
            playerView.setOnTouchListener(new AppLovinTouchToClickListener(mVar, com.applovin.impl.sdk.c.b.aM, activity, bVar));
            z();
            return;
        }
        throw new IllegalStateException("Attempting to use fullscreen video ad presenter for non-video ad");
    }

    private void E() {
        t tVar;
        s C2 = this.f13883a.C();
        if (C2 != null && C2.e() && !this.D && (tVar = this.f13941x) != null) {
            final boolean z2 = tVar.getVisibility() == 4;
            final long f2 = C2.f();
            AppLovinSdkUtils.runOnUiThread(new Runnable() {
                public void run() {
                    if (z2) {
                        q.a((View) e.this.f13941x, f2, (Runnable) null);
                    } else {
                        q.b(e.this.f13941x, f2, (Runnable) null);
                    }
                }
            });
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

    /* access modifiers changed from: protected */
    public void A() {
        if (this.L.compareAndSet(false, true)) {
            a(this.f13939v, this.f13883a.q(), new Runnable() {
                public void run() {
                    long unused = e.this.M = -1;
                    long unused2 = e.this.N = SystemClock.elapsedRealtime();
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void B() {
        this.C = D();
        this.f13937t.l(false);
    }

    /* access modifiers changed from: protected */
    public void C() {
        if (this.D) {
            if (v.a()) {
                this.f13885c.d("AppLovinFullscreenActivity", "Skip video resume - postitial shown");
            }
        } else if (!this.f13884b.ad().a()) {
            long j2 = this.J;
            if (j2 >= 0) {
                if (v.a()) {
                    v vVar = this.f13885c;
                    vVar.b("AppLovinFullscreenActivity", "Resuming video at position " + j2 + "ms for MediaPlayer: " + this.f13937t);
                }
                this.f13937t.l(true);
                this.f13943z.a();
                this.J = -1;
                if (!this.f13937t.isPlaying()) {
                    v();
                }
            } else if (v.a()) {
                v vVar2 = this.f13885c;
                vVar2.b("AppLovinFullscreenActivity", "Invalid last video position, isVideoPlaying=" + this.f13937t.isPlaying());
            }
        } else if (v.a()) {
            this.f13885c.d("AppLovinFullscreenActivity", "Skip video resume - app paused");
        }
    }

    /* access modifiers changed from: protected */
    public int D() {
        SimpleExoPlayer simpleExoPlayer = this.f13937t;
        if (simpleExoPlayer == null) {
            return 0;
        }
        long currentPosition = simpleExoPlayer.getCurrentPosition();
        if (this.E) {
            return 100;
        }
        return currentPosition > 0 ? (int) ((((float) currentPosition) / ((float) this.B)) * 100.0f) : this.C;
    }

    public void a() {
        if (v.a()) {
            this.f13885c.b("AppLovinFullscreenActivity", "Continue video from prompt - will resume in onWindowFocusChanged(true) when alert dismisses");
        }
    }

    public void a(long j2) {
        a((Runnable) new Runnable() {
            public void run() {
                e.this.C();
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
        E();
    }

    public void a(ViewGroup viewGroup) {
        this.F.a(this.f13940w, this.f13939v, this.f13941x, this.f13938u, this.f13942y, this.f13936s, this.f13888f, viewGroup);
        this.f13937t.l(true);
        if (this.f13883a.am()) {
            this.f13899q.a(this.f13883a, (Runnable) new Runnable() {
                public void run() {
                    e.this.a(250);
                }
            });
        }
        if (this.I) {
            v();
        }
        this.f13888f.renderAd(this.f13883a);
        this.f13886d.b(this.I ? 1 : 0);
        if (this.f13939v != null) {
            this.f13884b.S().a(new z(this.f13884b, new Runnable() {
                public void run() {
                    e.this.A();
                }
            }), o.a.MAIN, this.f13883a.r(), true);
        }
        super.b(this.A);
    }

    public void b() {
        if (v.a()) {
            this.f13885c.b("AppLovinFullscreenActivity", "Skipping video from prompt");
        }
        c();
    }

    public void c() {
        this.M = SystemClock.elapsedRealtime() - this.N;
        if (v.a()) {
            this.f13885c.b("AppLovinFullscreenActivity", "Skipping video with skip time: " + this.M + "ms");
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
        this.B = j2;
    }

    /* access modifiers changed from: protected */
    public void c(String str) {
        if (v.a()) {
            v vVar = this.f13885c;
            vVar.e("AppLovinFullscreenActivity", "Encountered media error: " + str + " for ad: " + this.f13883a);
        }
        if (this.K.compareAndSet(false, true)) {
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
        } else if (!this.D) {
            e();
        }
    }

    public void d() {
        a((ViewGroup) null);
    }

    /* access modifiers changed from: protected */
    public void d(boolean z2) {
        if (g.d()) {
            AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) this.f13887e.getDrawable(z2 ? R.drawable.unmute_to_mute : R.drawable.mute_to_unmute);
            if (animatedVectorDrawable != null) {
                this.f13940w.setScaleType(ImageView.ScaleType.FIT_XY);
                this.f13940w.setImageDrawable(animatedVectorDrawable);
                animatedVectorDrawable.start();
                return;
            }
        }
        Uri aC = z2 ? this.f13883a.aC() : this.f13883a.aD();
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        this.f13940w.setImageURI(aC);
        StrictMode.setThreadPolicy(allowThreadDiskReads);
    }

    public void e() {
        String str;
        v vVar;
        if (v.a()) {
            this.f13885c.b("AppLovinFullscreenActivity", "Pausing video");
        }
        if (this.f13937t.isPlaying()) {
            this.J = this.f13937t.getCurrentPosition();
            this.f13937t.l(false);
            this.f13943z.c();
            if (v.a()) {
                vVar = this.f13885c;
                str = "Paused video at position " + this.J + "ms";
            } else {
                return;
            }
        } else if (v.a()) {
            vVar = this.f13885c;
            str = "Nothing to pause";
        } else {
            return;
        }
        vVar.b("AppLovinFullscreenActivity", str);
    }

    public String getCommunicatorId() {
        return "FullscreenVideoAdExoPlayerPresenter";
    }

    public void h() {
        this.f13943z.b();
        this.H.removeCallbacksAndMessages((Object) null);
        m();
        super.h();
    }

    public void k() {
        this.f13937t.release();
        if (this.I) {
            AppLovinCommunicator.getInstance(this.f13887e).unsubscribe((AppLovinCommunicatorSubscriber) this, "video_caching_failed");
        }
        super.k();
    }

    /* access modifiers changed from: protected */
    public void m() {
        super.a(D(), this.I, r(), this.M);
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if ("video_caching_failed".equals(appLovinCommunicatorMessage.getTopic())) {
            Bundle messageData = appLovinCommunicatorMessage.getMessageData();
            long j2 = messageData.getLong("ad_id");
            if (((Boolean) this.f13884b.a(com.applovin.impl.sdk.c.b.eM)).booleanValue() && j2 == this.f13883a.getAdIdNumber() && this.I) {
                int i2 = messageData.getInt("load_response_code");
                String string = messageData.getString("load_exception_message");
                if ((string != null || i2 < 200 || i2 >= 300) && !this.E && !this.f13937t.isPlaying()) {
                    c("Video cache error during stream. ResponseCode=" + i2 + ", exception=" + string);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean r() {
        return this.f13883a != null && D() >= this.f13883a.Q();
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
            com.applovin.impl.sdk.ad.e eVar = this.f13883a;
            if (i2 >= 0) {
                j2 = eVar.ad();
            } else {
                com.applovin.impl.sdk.ad.a aVar = (com.applovin.impl.sdk.ad.a) eVar;
                long j4 = this.B;
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
                com.applovin.impl.adview.a aVar = e.this.f13938u;
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
                com.applovin.impl.adview.a aVar = e.this.f13938u;
                if (aVar != null) {
                    aVar.b();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void x() {
        boolean z2 = !this.A;
        this.A = z2;
        this.f13937t.d(z2 ^ true ? 1.0f : 0.0f);
        d(this.A);
        a(this.A, 0);
    }

    public void y() {
        B();
        this.F.a(this.f13889g, this.f13888f);
        a("javascript:al_onPoststitialShow(" + this.f13892j + "," + this.f13893k + ");", (long) this.f13883a.S());
        if (this.f13889g != null) {
            int i2 = (this.f13883a.s() > 0 ? 1 : (this.f13883a.s() == 0 ? 0 : -1));
            m mVar = this.f13889g;
            if (i2 >= 0) {
                a(mVar, this.f13883a.s(), new Runnable() {
                    public void run() {
                        e.this.f13891i = SystemClock.elapsedRealtime();
                    }
                });
            } else {
                mVar.setVisibility(0);
            }
        }
        this.D = true;
    }

    /* access modifiers changed from: protected */
    public void z() {
        a(!this.I);
        Activity activity = this.f13887e;
        ProgressiveMediaSource e2 = new ProgressiveMediaSource.Factory(new DefaultDataSourceFactory(activity, Util.o0(activity, "com.applovin.sdk"))).a(MediaItem.d(this.f13883a.h()));
        this.f13937t.d(this.A ^ true ? 1.0f : 0.0f);
        this.f13937t.r0(e2);
        this.f13937t.prepare();
        this.f13937t.l(false);
    }
}
