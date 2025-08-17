package com.startapp.sdk.ads.video;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Paint;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.facebook.react.uimanager.ViewProps;
import com.iab.omid.library.startio.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.startio.adsession.media.InteractionType;
import com.iab.omid.library.startio.adsession.media.Position;
import com.startapp.a6;
import com.startapp.d6;
import com.startapp.e6;
import com.startapp.fg;
import com.startapp.gc;
import com.startapp.h5;
import com.startapp.hc;
import com.startapp.ia;
import com.startapp.l;
import com.startapp.lb;
import com.startapp.m;
import com.startapp.me;
import com.startapp.n5;
import com.startapp.o5;
import com.startapp.o6;
import com.startapp.p;
import com.startapp.p5;
import com.startapp.q5;
import com.startapp.r;
import com.startapp.r5;
import com.startapp.s5;
import com.startapp.sdk.ads.video.player.NativeVideoPlayer;
import com.startapp.sdk.ads.video.player.VideoPlayerInterface;
import com.startapp.sdk.ads.video.tracking.AbsoluteTrackingLink;
import com.startapp.sdk.ads.video.tracking.ActionTrackingLink;
import com.startapp.sdk.ads.video.tracking.FractionTrackingLink;
import com.startapp.sdk.ads.video.tracking.VideoClickedTrackingParams;
import com.startapp.sdk.ads.video.tracking.VideoPausedTrackingParams;
import com.startapp.sdk.ads.video.tracking.VideoProgressTrackingParams;
import com.startapp.sdk.ads.video.tracking.VideoTrackingLink;
import com.startapp.sdk.ads.video.tracking.VideoTrackingParams;
import com.startapp.sdk.ads.video.vast.VASTErrorCodes;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.VideoConfig;
import com.startapp.sdk.adsbase.adinformation.AdInformationView;
import com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.t5;
import com.startapp.td;
import com.startapp.u5;
import com.startapp.v5;
import com.startapp.w3;
import com.startapp.w5;
import com.startapp.wb;
import com.startapp.x;
import com.startapp.x5;
import com.startapp.y;
import com.startapp.y5;
import com.startapp.y8;
import com.startapp.z;
import com.startapp.z5;
import com.startapp.z8;
import com.unity3d.services.core.device.MimeTypes;
import com.uwetrottmann.trakt5.TraktV2;
import com.vungle.ads.internal.Constants;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoMode extends w3 {
    public static final String L = "VideoMode";
    public VideoPlayerInterface M;
    public VideoView N;
    public RelativeLayout O;
    public RelativeLayout P;
    public ProgressBar Q;
    public boolean R = false;
    public int S = 0;
    public int T = 0;
    public int U = 0;
    public boolean V;
    public boolean W = false;
    public boolean X = false;
    public boolean Y = false;
    public boolean Z = false;

    /* renamed from: a0  reason: collision with root package name */
    public HashMap<Integer, Boolean> f36067a0 = new HashMap<>();

    /* renamed from: b0  reason: collision with root package name */
    public HashMap<Integer, Boolean> f36068b0 = new HashMap<>();

    /* renamed from: c0  reason: collision with root package name */
    public int f36069c0 = 1;

    /* renamed from: d0  reason: collision with root package name */
    public boolean f36070d0 = false;

    /* renamed from: e0  reason: collision with root package name */
    public boolean f36071e0 = false;

    /* renamed from: f0  reason: collision with root package name */
    public int f36072f0 = 0;

    /* renamed from: g0  reason: collision with root package name */
    public boolean f36073g0 = false;

    /* renamed from: h0  reason: collision with root package name */
    public boolean f36074h0 = false;

    /* renamed from: i0  reason: collision with root package name */
    public boolean f36075i0 = false;

    /* renamed from: j0  reason: collision with root package name */
    public boolean f36076j0 = false;

    /* renamed from: k0  reason: collision with root package name */
    public int f36077k0 = 0;

    /* renamed from: l0  reason: collision with root package name */
    public int f36078l0;

    /* renamed from: m0  reason: collision with root package name */
    public String f36079m0 = null;

    /* renamed from: n0  reason: collision with root package name */
    public Handler f36080n0 = new Handler();

    /* renamed from: o0  reason: collision with root package name */
    public Handler f36081o0 = new Handler();

    /* renamed from: p0  reason: collision with root package name */
    public Handler f36082p0 = new Handler();

    /* renamed from: q0  reason: collision with root package name */
    public Handler f36083q0 = new Handler();

    /* renamed from: r0  reason: collision with root package name */
    public final Map<Integer, List<FractionTrackingLink>> f36084r0 = new HashMap();

    /* renamed from: s0  reason: collision with root package name */
    public final Map<Integer, List<AbsoluteTrackingLink>> f36085s0 = new HashMap();

    /* renamed from: t0  reason: collision with root package name */
    public long f36086t0;

    /* renamed from: u0  reason: collision with root package name */
    public long f36087u0;

    /* renamed from: v0  reason: collision with root package name */
    public boolean f36088v0 = false;

    /* renamed from: w0  reason: collision with root package name */
    public final BroadcastReceiver f36089w0 = new d();

    /* renamed from: x0  reason: collision with root package name */
    public final Runnable f36090x0 = new e();

    public enum HtmlMode {
        PLAYER,
        POST_ROLL
    }

    public enum VideoFinishedReason {
        COMPLETE,
        CLICKED,
        SKIPPED
    }

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f36098a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Handler f36099b;

        public a(int i2, Handler handler) {
            this.f36098a = i2;
            this.f36099b = handler;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
            r1 = r5.f36100c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r5 = this;
                com.startapp.sdk.ads.video.VideoMode r0 = com.startapp.sdk.ads.video.VideoMode.this
                com.startapp.sdk.ads.video.player.VideoPlayerInterface r1 = r0.M
                if (r1 == 0) goto L_0x007c
                r0.P()
                int r0 = r5.f36098a
                if (r0 <= 0) goto L_0x006b
                com.startapp.sdk.ads.video.VideoMode r1 = com.startapp.sdk.ads.video.VideoMode.this
                com.startapp.me r2 = r1.I
                if (r2 == 0) goto L_0x006b
                float r0 = (float) r0
                boolean r1 = r1.R
                r3 = 0
                if (r1 == 0) goto L_0x001b
                r1 = 0
                goto L_0x001d
            L_0x001b:
                r1 = 1065353216(0x3f800000, float:1.0)
            L_0x001d:
                com.startapp.y r2 = r2.f34941c
                if (r2 == 0) goto L_0x006b
                int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
                if (r3 <= 0) goto L_0x0063
                r2.a((float) r1)
                com.startapp.x r3 = r2.f36932a
                com.startapp.p.a((com.startapp.x) r3)
                org.json.JSONObject r3 = new org.json.JSONObject
                r3.<init>()
                java.lang.Float r0 = java.lang.Float.valueOf(r0)
                java.lang.String r4 = "duration"
                com.startapp.fg.a(r3, r4, r0)
                java.lang.Float r0 = java.lang.Float.valueOf(r1)
                java.lang.String r1 = "mediaPlayerVolume"
                com.startapp.fg.a(r3, r1, r0)
                com.startapp.m r0 = com.startapp.m.a()
                float r0 = r0.f34886b
                java.lang.Float r0 = java.lang.Float.valueOf(r0)
                java.lang.String r1 = "deviceVolume"
                com.startapp.fg.a(r3, r1, r0)
                com.startapp.x r0 = r2.f36932a
                com.iab.omid.library.startio.publisher.AdSessionStatePublisher r0 = r0.f36850f
                com.startapp.l r1 = com.startapp.l.f34848a
                android.webkit.WebView r0 = r0.c()
                java.lang.String r2 = "start"
                r1.a((android.webkit.WebView) r0, (java.lang.String) r2, (org.json.JSONObject) r3)
                goto L_0x006b
            L_0x0063:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.String r1 = "Invalid Media duration"
                r0.<init>(r1)
                throw r0
            L_0x006b:
                com.startapp.sdk.ads.video.VideoMode r0 = com.startapp.sdk.ads.video.VideoMode.this
                r1 = 1
                r0.Y = r1
                r0.R()
                android.os.Handler r0 = r5.f36099b
                com.startapp.sdk.ads.video.VideoMode r1 = com.startapp.sdk.ads.video.VideoMode.this
                java.lang.Runnable r1 = r1.f36090x0
                r0.post(r1)
            L_0x007c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.ads.video.VideoMode.a.run():void");
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            try {
                VideoPlayerInterface videoPlayerInterface = VideoMode.this.M;
                if (videoPlayerInterface == null) {
                    return;
                }
                if (((NativeVideoPlayer) videoPlayerInterface).f36113g.getCurrentPosition() > 0) {
                    VideoMode.this.f(0);
                    VideoMode.this.e(0);
                    VideoMode videoMode = VideoMode.this;
                    if (videoMode.F == 0) {
                        videoMode.J();
                        wb.a((Context) VideoMode.this.f36704b).a(new Intent("com.startapp.android.ShowDisplayBroadcastListener"));
                        return;
                    }
                    return;
                }
                VideoMode videoMode2 = VideoMode.this;
                if (!videoMode2.Z) {
                    videoMode2.f36080n0.postDelayed(this, 100);
                }
            } catch (Throwable th) {
                y8.a((Context) VideoMode.this.f36704b, th);
                VideoMode.this.b();
            }
        }
    }

    public class c implements Runnable {

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                try {
                    VideoMode.this.R();
                    VideoMode.this.getClass();
                    VideoMode videoMode = VideoMode.this;
                    videoMode.a(new VideoPlayerInterface.e(VideoPlayerInterface.VideoPlayerErrorType.BUFFERING_TIMEOUT, "Buffering timeout reached", videoMode.S));
                } catch (Throwable th) {
                    y8.a((Context) VideoMode.this.f36704b, th);
                }
            }
        }

        public c() {
        }

        public void run() {
            y yVar;
            try {
                VideoMode.this.Q.setVisibility(0);
                me meVar = VideoMode.this.I;
                if (!(meVar == null || (yVar = meVar.f34941c) == null)) {
                    p.a(yVar.f36932a);
                    l.f34848a.a(yVar.f36932a.f36850f.c(), "bufferStart", (JSONObject) null);
                }
                VideoMode.this.f36083q0.postDelayed(new a(), AdsCommonMetaData.f36186h.G().c());
            } catch (Throwable th) {
                VideoMode.this.R();
                y8.a((Context) VideoMode.this.f36704b, th);
            }
        }
    }

    public class d extends BroadcastReceiver {
        public d() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!VideoMode.this.f36089w0.isInitialStickyBroadcast()) {
                VideoMode videoMode = VideoMode.this;
                if (videoMode.R != videoMode.H()) {
                    VideoMode videoMode2 = VideoMode.this;
                    videoMode2.R = !videoMode2.R;
                    videoMode2.L();
                    VideoMode videoMode3 = VideoMode.this;
                    videoMode3.a(videoMode3.R);
                }
            }
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public void run() {
            VideoMode.this.B();
        }
    }

    public class f extends w3.g {
        public f() {
            super();
        }

        public void onPageFinished(WebView webView, String str) {
            VideoMode.this.j();
            VideoMode.this.w();
        }
    }

    public final void A() {
        boolean z2;
        String e2 = y().e();
        if (e2 != null) {
            this.f36800w.setWebViewClient(new f());
            lb.a((Context) this.f36704b, this.f36800w, e2);
            return;
        }
        Object[] objArr = new Object[1];
        if (this.M != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        objArr[0] = Boolean.valueOf(z2);
        lb.a(this.f36800w, true, "videoApi.setReplayEnabled", objArr);
        lb.a(this.f36800w, true, "videoApi.setMode", HtmlMode.POST_ROLL + "_" + y().f());
        lb.a(this.f36800w, true, "videoApi.setCloseable", Boolean.TRUE);
    }

    public void B() {
        boolean z2;
        if (this.Y) {
            b((View) this.N);
            if (!I()) {
                lb.a(this.f36800w, true, "videoApi.setClickableVideo", Boolean.valueOf(y().k()));
                lb.a(this.f36800w, true, "videoApi.setMode", "PLAYER");
                Object[] objArr = new Object[1];
                if (y().l() || this.f36071e0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr[0] = Boolean.valueOf(z2);
                lb.a(this.f36800w, true, "videoApi.setCloseable", objArr);
                lb.a(this.f36800w, true, "videoApi.setSkippable", Boolean.valueOf(G()));
            }
        }
    }

    public final void C() {
        FractionTrackingLink[] c2 = y().h().c();
        if (c2 != null) {
            for (FractionTrackingLink fractionTrackingLink : c2) {
                List list = this.f36084r0.get(Integer.valueOf(fractionTrackingLink.e()));
                if (list == null) {
                    list = new ArrayList();
                    this.f36084r0.put(Integer.valueOf(fractionTrackingLink.e()), list);
                }
                list.add(fractionTrackingLink);
            }
        }
        AbsoluteTrackingLink[] a2 = y().h().a();
        if (a2 != null) {
            for (AbsoluteTrackingLink absoluteTrackingLink : a2) {
                List list2 = this.f36085s0.get(Integer.valueOf(absoluteTrackingLink.e()));
                if (list2 == null) {
                    list2 = new ArrayList();
                    this.f36085s0.put(Integer.valueOf(absoluteTrackingLink.e()), list2);
                }
                list2.add(absoluteTrackingLink);
            }
        }
    }

    public boolean D() {
        if (!this.f36073g0) {
            if (!E() || !this.W) {
                return false;
            }
            return true;
        } else if (this.f36072f0 < AdsCommonMetaData.f36186h.G().i() || !E() || !this.W) {
            return false;
        } else {
            return true;
        }
    }

    public boolean E() {
        boolean z2;
        VideoPlayerInterface videoPlayerInterface = this.M;
        if (videoPlayerInterface == null) {
            return false;
        }
        if (((NativeVideoPlayer) videoPlayerInterface).f36112f != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return true;
        }
        return false;
    }

    public boolean F() {
        ProgressBar progressBar = this.Q;
        return progressBar != null && progressBar.isShown();
    }

    public final boolean G() {
        return this.F > 0 || y().m() || this.f36070d0;
    }

    public boolean H() {
        AudioManager audioManager = (AudioManager) this.f36704b.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager == null || (audioManager.getRingerMode() != 0 && audioManager.getRingerMode() != 1)) {
            return false;
        }
        return true;
    }

    public boolean I() {
        return this.S == -1;
    }

    public void J() {
        this.C.b();
        a(y().h().d(), new VideoTrackingParams(this.f36718p, 0, this.F, this.f36079m0), 0, "impression");
        a(y().h().b(), new VideoTrackingParams(this.f36718p, 0, this.F, this.f36079m0), 0, "creativeView");
        me meVar = this.I;
        if (meVar != null) {
            meVar.b();
        }
    }

    public final void K() {
        lb.a(this.f36800w, true, "videoApi.setSkipTimer", Long.valueOf(c(this.S + 50)));
    }

    public void L() {
        String str;
        VideoPlayerInterface videoPlayerInterface = this.M;
        if (videoPlayerInterface != null) {
            try {
                boolean z2 = this.R;
                MediaPlayer mediaPlayer = ((NativeVideoPlayer) videoPlayerInterface).f36112f;
                if (mediaPlayer != null) {
                    if (z2) {
                        mediaPlayer.setVolume(0.0f, 0.0f);
                    } else {
                        mediaPlayer.setVolume(1.0f, 1.0f);
                    }
                }
            } catch (Throwable th) {
                y8.a((Context) this.f36704b, th);
            }
        }
        Object[] objArr = new Object[1];
        if (this.R) {
            str = "OFF";
        } else {
            str = "ON";
        }
        objArr[0] = str;
        lb.a(this.f36800w, true, "videoApi.setSound", objArr);
    }

    public void M() {
        String str;
        if (this.M != null) {
            boolean p2 = AdsCommonMetaData.f36186h.G().p();
            String c2 = y().c();
            if (c2 != null) {
                VideoPlayerInterface videoPlayerInterface = this.M;
                if (videoPlayerInterface != null) {
                    ((NativeVideoPlayer) videoPlayerInterface).a(c2);
                }
                if (p2 && c2.endsWith(".temp")) {
                    this.f36073g0 = true;
                    this.f36076j0 = true;
                    this.f36072f0 = AdsCommonMetaData.f36186h.G().i();
                }
            } else if (p2) {
                String i2 = y().i();
                h5 h5Var = h5.b.f34617a;
                if (i2 != null && i2.equals(h5Var.f34616c)) {
                    h5Var.f34614a = false;
                }
                VideoPlayerInterface videoPlayerInterface2 = this.M;
                if (videoPlayerInterface2 != null) {
                    ((NativeVideoPlayer) videoPlayerInterface2).a(i2);
                }
                this.f36073g0 = true;
                O();
            } else {
                a(VideoFinishedReason.SKIPPED);
            }
            if (this.f36079m0 == null) {
                if (this.f36073g0) {
                    str = TraktV2.API_VERSION;
                } else {
                    str = "1";
                }
                this.f36079m0 = str;
            }
        }
    }

    public int N() {
        int i2;
        VideoPlayerInterface videoPlayerInterface = this.M;
        if (videoPlayerInterface == null) {
            i2 = 0;
        } else if (((NativeVideoPlayer) videoPlayerInterface).f36113g.getCurrentPosition() != ((NativeVideoPlayer) this.M).f36113g.getDuration() || I()) {
            i2 = ((NativeVideoPlayer) this.M).f36113g.getDuration() - ((NativeVideoPlayer) this.M).f36113g.getCurrentPosition();
        } else {
            i2 = ((NativeVideoPlayer) this.M).f36113g.getDuration();
        }
        int i3 = i2 / 1000;
        if (i3 > 0 && i2 % 1000 < 100) {
            i3--;
        }
        lb.a(this.f36800w, true, "videoApi.setVideoRemainingTimer", Integer.valueOf(i3));
        return i2;
    }

    public void O() {
        if (!F()) {
            this.f36083q0.postDelayed(new c(), AdsCommonMetaData.f36186h.G().g());
        }
    }

    public void P() {
        VideoPlayerInterface videoPlayerInterface = this.M;
        if (videoPlayerInterface != null) {
            ((NativeVideoPlayer) videoPlayerInterface).f36113g.start();
            this.f36800w.setBackgroundColor(33554431);
            a((View) null);
        }
    }

    public void Q() {
        int i2;
        int i3;
        long j2;
        this.f36075i0 = true;
        VideoPlayerInterface videoPlayerInterface = this.M;
        int i4 = 0;
        if (videoPlayerInterface != null) {
            i2 = ((NativeVideoPlayer) videoPlayerInterface).f36113g.getDuration() / 1000;
        } else {
            i2 = 0;
        }
        lb.a(this.f36800w, true, "videoApi.setVideoDuration", Integer.valueOf(i2));
        N();
        K();
        lb.a(this.f36800w, true, "videoApi.setVideoCurrentPosition", Integer.valueOf(this.S / 1000));
        if (I()) {
            VideoPlayerInterface videoPlayerInterface2 = this.M;
            if (videoPlayerInterface2 != null) {
                ((NativeVideoPlayer) videoPlayerInterface2).f36113g.pause();
                return;
            }
            return;
        }
        VideoPlayerInterface videoPlayerInterface3 = this.M;
        if (videoPlayerInterface3 != null) {
            i3 = ((NativeVideoPlayer) videoPlayerInterface3).f36113g.getDuration();
        } else {
            i3 = 0;
        }
        Handler handler = new Handler();
        a aVar = new a(i3, handler);
        long currentTimeMillis = System.currentTimeMillis() - this.f36086t0;
        if (this.S == 0 && this.F == 0 && currentTimeMillis < 500) {
            j2 = Math.max(200, 500 - currentTimeMillis);
        } else {
            j2 = 0;
        }
        handler.postDelayed(aVar, j2);
        if (this.S == 0) {
            this.f36080n0.postDelayed(new b(), 100);
        }
        VideoPlayerInterface videoPlayerInterface4 = this.M;
        if (videoPlayerInterface4 != null) {
            i4 = ((NativeVideoPlayer) videoPlayerInterface4).f36113g.getDuration();
        }
        this.U = i4;
        for (Integer intValue : this.f36084r0.keySet()) {
            int intValue2 = intValue.intValue();
            a(d(intValue2), this.f36080n0, new q5(this, intValue2));
        }
        for (Integer intValue3 : this.f36085s0.keySet()) {
            int intValue4 = intValue3.intValue();
            a(intValue4, this.f36080n0, new r5(this, intValue4));
        }
        if (!this.f36073g0) {
            a(d(AdsCommonMetaData.f36186h.G().k()), this.f36082p0, new s5(this));
        }
        this.f36081o0.post(new o5(this));
        K();
        this.f36081o0.post(new p5(this));
        this.f36705c.f36263b.setVisibility(4);
        L();
    }

    public void R() {
        y yVar;
        this.f36083q0.removeCallbacksAndMessages((Object) null);
        if (F()) {
            this.Q.setVisibility(8);
            me meVar = this.I;
            if (meVar != null && (yVar = meVar.f34941c) != null) {
                p.a(yVar.f36932a);
                l.f34848a.a(yVar.f36932a.f36850f.c(), "bufferFinish", (JSONObject) null);
            }
        }
    }

    public void S() {
        if (F()) {
            R();
        }
        a(VideoFinishedReason.SKIPPED);
        a(y().h().p(), new VideoTrackingParams(this.f36718p, b(this.T), this.F, this.f36079m0), this.T, "skipped");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0050 A[Catch:{ all -> 0x008b }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.os.Bundle r4) {
        /*
            r3 = this;
            java.lang.String r0 = "currentPosition"
            super.a((android.os.Bundle) r4)
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x008b }
            r3.f36086t0 = r1     // Catch:{ all -> 0x008b }
            com.startapp.sdk.adsbase.AdsCommonMetaData r1 = com.startapp.sdk.adsbase.AdsCommonMetaData.f36186h     // Catch:{ all -> 0x008b }
            com.startapp.sdk.adsbase.VideoConfig r1 = r1.G()     // Catch:{ all -> 0x008b }
            int r1 = r1.h()     // Catch:{ all -> 0x008b }
            r2 = 100
            int r2 = r2 / r1
            r3.f36078l0 = r2     // Catch:{ all -> 0x008b }
            r3.z()     // Catch:{ all -> 0x008b }
            r3.C()     // Catch:{ all -> 0x008b }
            boolean r1 = r3.H()     // Catch:{ all -> 0x008b }
            if (r1 != 0) goto L_0x0045
            com.startapp.sdk.ads.video.VideoAdDetails r1 = r3.y()     // Catch:{ all -> 0x008b }
            boolean r1 = r1.n()     // Catch:{ all -> 0x008b }
            if (r1 != 0) goto L_0x0045
            com.startapp.sdk.adsbase.AdsCommonMetaData r1 = com.startapp.sdk.adsbase.AdsCommonMetaData.f36186h     // Catch:{ all -> 0x008b }
            com.startapp.sdk.adsbase.VideoConfig r1 = r1.G()     // Catch:{ all -> 0x008b }
            java.lang.String r1 = r1.l()     // Catch:{ all -> 0x008b }
            java.lang.String r2 = "muted"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x008b }
            if (r1 == 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r1 = 0
            goto L_0x0046
        L_0x0045:
            r1 = 1
        L_0x0046:
            r3.R = r1     // Catch:{ all -> 0x008b }
            if (r4 == 0) goto L_0x0097
            boolean r1 = r4.containsKey(r0)     // Catch:{ all -> 0x008b }
            if (r1 == 0) goto L_0x0097
            int r0 = r4.getInt(r0)     // Catch:{ all -> 0x008b }
            r3.S = r0     // Catch:{ all -> 0x008b }
            java.lang.String r0 = "latestPosition"
            int r0 = r4.getInt(r0)     // Catch:{ all -> 0x008b }
            r3.T = r0     // Catch:{ all -> 0x008b }
            java.lang.String r0 = "fractionProgressImpressionsSent"
            java.io.Serializable r0 = r4.getSerializable(r0)     // Catch:{ all -> 0x008b }
            java.util.HashMap r0 = (java.util.HashMap) r0     // Catch:{ all -> 0x008b }
            r3.f36067a0 = r0     // Catch:{ all -> 0x008b }
            java.lang.String r0 = "absoluteProgressImpressionsSent"
            java.io.Serializable r0 = r4.getSerializable(r0)     // Catch:{ all -> 0x008b }
            java.util.HashMap r0 = (java.util.HashMap) r0     // Catch:{ all -> 0x008b }
            r3.f36068b0 = r0     // Catch:{ all -> 0x008b }
            java.lang.String r0 = "isMuted"
            boolean r0 = r4.getBoolean(r0)     // Catch:{ all -> 0x008b }
            r3.R = r0     // Catch:{ all -> 0x008b }
            java.lang.String r0 = "shouldSetBg"
            boolean r0 = r4.getBoolean(r0)     // Catch:{ all -> 0x008b }
            r3.V = r0     // Catch:{ all -> 0x008b }
            java.lang.String r0 = "pauseNum"
            int r4 = r4.getInt(r0)     // Catch:{ all -> 0x008b }
            r3.f36069c0 = r4     // Catch:{ all -> 0x008b }
            goto L_0x0097
        L_0x008b:
            r4 = move-exception
            android.app.Activity r0 = r3.f36704b
            com.startapp.y8.a((android.content.Context) r0, (java.lang.Throwable) r4)
            r3.x()
            r3.b()
        L_0x0097:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.ads.video.VideoMode.a(android.os.Bundle):void");
    }

    public void b(WebView webView) {
        this.D = false;
        webView.setOnTouchListener(new w3.d());
        hc.a(webView, (Paint) null);
    }

    public long c(int i2) {
        if (this.f36070d0 || this.F > 0) {
            return 0;
        }
        long g2 = y().g() - ((long) i2);
        if (g2 <= 0) {
            return 0;
        }
        return (g2 / 1000) + 1;
    }

    public int d(int i2) {
        return (this.U * i2) / 100;
    }

    public void e() {
        y yVar;
        if (!I() && !this.f36704b.isFinishing() && !this.f36071e0 && !this.f36070d0) {
            VideoPausedTrackingParams.PauseOrigin pauseOrigin = VideoPausedTrackingParams.PauseOrigin.EXTERNAL;
            VideoPlayerInterface videoPlayerInterface = this.M;
            if (videoPlayerInterface != null) {
                int currentPosition = ((NativeVideoPlayer) videoPlayerInterface).f36113g.getCurrentPosition();
                this.S = currentPosition;
                this.T = currentPosition;
                ((NativeVideoPlayer) this.M).f36113g.pause();
                me meVar = this.I;
                if (!(meVar == null || (yVar = meVar.f34941c) == null)) {
                    p.a(yVar.f36932a);
                    l.f34848a.a(yVar.f36932a.f36850f.c(), "pause", (JSONObject) null);
                }
            }
            a(y().h().j(), new VideoPausedTrackingParams(this.f36718p, b(this.T), this.F, this.f36069c0, pauseOrigin, this.f36079m0), this.T, "paused");
        }
        VideoPlayerInterface videoPlayerInterface2 = this.M;
        if (videoPlayerInterface2 != null) {
            NativeVideoPlayer nativeVideoPlayer = (NativeVideoPlayer) videoPlayerInterface2;
            if (nativeVideoPlayer.f36112f != null) {
                nativeVideoPlayer.f36112f = null;
            }
            h5.b.f34617a.f34615b = null;
            this.M = null;
        }
        this.f36080n0.removeCallbacksAndMessages((Object) null);
        this.f36081o0.removeCallbacksAndMessages((Object) null);
        this.f36082p0.removeCallbacksAndMessages((Object) null);
        R();
        this.V = true;
        if (this.f36088v0) {
            this.f36704b.unregisterReceiver(this.f36089w0);
            this.f36088v0 = false;
        }
        super.e();
    }

    public void f() {
        y yVar;
        super.f();
        this.f36704b.registerReceiver(this.f36089w0, new IntentFilter("android.media.RINGER_MODE_CHANGED"));
        this.f36088v0 = true;
        if (!this.f36704b.isFinishing()) {
            if (this.N == null) {
                Context a2 = ia.a(this.f36704b);
                if (a2 == null) {
                    a2 = this.f36704b;
                }
                this.f36087u0 = SystemClock.uptimeMillis();
                this.P = (RelativeLayout) this.f36704b.findViewById(1475346432);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                VideoView videoView = new VideoView(a2);
                this.N = videoView;
                videoView.setId(100);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams2.addRule(13);
                ProgressBar progressBar = new ProgressBar(a2, (AttributeSet) null, 16843399);
                this.Q = progressBar;
                progressBar.setVisibility(4);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams3.addRule(14);
                layoutParams3.addRule(15);
                RelativeLayout relativeLayout = new RelativeLayout(a2);
                this.O = relativeLayout;
                relativeLayout.setId(1475346436);
                this.f36704b.setContentView(this.O);
                this.O.addView(this.N, layoutParams2);
                this.O.addView(this.P, layoutParams);
                this.O.addView(this.Q, layoutParams3);
                if (AdsConstants.f36194h.booleanValue()) {
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams4.addRule(12);
                    layoutParams4.addRule(14);
                    RelativeLayout relativeLayout2 = this.O;
                    TextView textView = new TextView(a2);
                    textView.setBackgroundColor(-16777216);
                    int i2 = hc.f34643a;
                    textView.setAlpha(0.5f);
                    textView.setTextColor(-7829368);
                    textView.setSingleLine(false);
                    textView.setText("url=" + y().i());
                    relativeLayout2.addView(textView, layoutParams4);
                }
                this.f36705c.f36263b.setVisibility(4);
            }
            if (this.M == null) {
                this.M = new NativeVideoPlayer(this.N);
            }
            this.X = false;
            this.O.setBackgroundColor(-16777216);
            M();
            if (I()) {
                this.f36705c.f36263b.setVisibility(0);
                this.N.setVisibility(4);
            } else {
                int i3 = this.S;
                if (i3 != 0) {
                    ((NativeVideoPlayer) this.M).f36113g.seekTo(i3);
                    VideoPausedTrackingParams.PauseOrigin pauseOrigin = VideoPausedTrackingParams.PauseOrigin.EXTERNAL;
                    me meVar = this.I;
                    if (!(meVar == null || (yVar = meVar.f34941c) == null)) {
                        p.a(yVar.f36932a);
                        l.f34848a.a(yVar.f36932a.f36850f.c(), "resume", (JSONObject) null);
                    }
                    a(y().h().n(), new VideoPausedTrackingParams(this.f36718p, b(this.T), this.F, this.f36069c0, pauseOrigin, this.f36079m0), this.T, "resumed");
                    this.f36069c0++;
                }
            }
            e6 e6Var = (e6) this.M;
            e6Var.f34445b = new w5(this);
            e6Var.f34447d = new x5(this);
            y5 y5Var = new y5(this);
            e6Var.f34446c = new z5(this);
            ((e6) this.M).f34448e = y5Var;
            VideoView videoView2 = this.N;
            a6 a6Var = new a6(this);
            int i4 = hc.f34643a;
            videoView2.addOnLayoutChangeListener(new gc(a6Var));
        }
    }

    public void h() {
        if (!this.Z) {
            wb.a((Context) this.f36704b).a(new Intent("com.startapp.android.HideDisplayBroadcastListener"));
        }
    }

    public void i() {
        int i2;
        if (this.Z) {
            return;
        }
        if (I() || this.N == null) {
            a(y().h().l(), new VideoTrackingParams(this.f36718p, b(this.T), this.F, this.f36079m0), this.T, "postrollClosed");
            super.i();
            return;
        }
        VideoPlayerInterface videoPlayerInterface = this.M;
        if (videoPlayerInterface != null) {
            i2 = ((NativeVideoPlayer) videoPlayerInterface).f36113g.getCurrentPosition();
        } else {
            i2 = 0;
        }
        a(y().h().i(), new VideoTrackingParams(this.f36718p, b(i2), this.F, this.f36079m0), i2, "closed");
    }

    public long k() {
        return (SystemClock.uptimeMillis() - this.f36087u0) / 1000;
    }

    public td l() {
        Activity activity = this.f36704b;
        Runnable runnable = this.J;
        return new n5(activity, runnable, runnable, new v5(this), new u5(this), new t5(this), new TrackingParams(this.f36718p), a(0));
    }

    public long m() {
        Long l2 = this.f36719q;
        if (l2 != null) {
            return TimeUnit.SECONDS.toMillis(l2.longValue());
        }
        return TimeUnit.SECONDS.toMillis(MetaData.f36379h.o());
    }

    public TrackingParams n() {
        return new VideoTrackingParams(this.f36718p, 0, this.F, this.f36079m0);
    }

    public void onClick(View view) {
        this.J.run();
    }

    public boolean p() {
        if (this.f36714l.getType() == Ad.AdType.REWARDED_VIDEO) {
            return true;
        }
        return false;
    }

    public void q() {
    }

    public void r() {
        this.W = true;
        if (this.X && E()) {
            B();
        } else if (I()) {
            b((View) this.f36800w);
        }
        if (D()) {
            Q();
        }
        if (I()) {
            A();
        }
    }

    public boolean s() {
        return false;
    }

    public void t() {
        a(y().h().o(), new VideoTrackingParams(this.f36718p, AdsCommonMetaData.f36186h.G().k(), this.F, this.f36079m0), d(AdsCommonMetaData.f36186h.G().k()), Constants.PLACEMENT_TYPE_REWARDED);
    }

    public final void x() {
        Intent intent = new Intent("com.startapp.android.ShowFailedDisplayBroadcastListener");
        intent.putExtra("showFailedReason", NotDisplayedReason.VIDEO_ERROR);
        wb.a((Context) this.f36704b).a(intent);
        this.Z = true;
    }

    public VideoAdDetails y() {
        return ((VideoEnabledAd) this.f36714l).w();
    }

    public final void z() {
        if (!this.f36710h.equals("back")) {
            return;
        }
        if (AdsCommonMetaData.f36186h.G().a().equals(VideoConfig.BackMode.BOTH)) {
            this.f36070d0 = true;
            this.f36071e0 = true;
        } else if (AdsCommonMetaData.f36186h.G().a().equals(VideoConfig.BackMode.SKIP)) {
            this.f36070d0 = true;
            this.f36071e0 = false;
        } else if (AdsCommonMetaData.f36186h.G().a().equals(VideoConfig.BackMode.CLOSE)) {
            this.f36070d0 = false;
            this.f36071e0 = true;
        } else if (AdsCommonMetaData.f36186h.G().a().equals(VideoConfig.BackMode.DISABLED)) {
            this.f36070d0 = false;
            this.f36071e0 = false;
        } else {
            this.f36070d0 = false;
            this.f36071e0 = false;
        }
    }

    public final void b(View view) {
        lb.a(this.f36800w, true, "videoApi.setVideoFrame", Integer.valueOf(p.b((Context) this.f36704b, view.getLeft())), Integer.valueOf(p.b((Context) this.f36704b, view.getTop())), Integer.valueOf(p.b((Context) this.f36704b, view.getWidth())), Integer.valueOf(p.b((Context) this.f36704b, view.getHeight())));
    }

    public boolean c() {
        if (I()) {
            i();
            return false;
        }
        VideoPlayerInterface videoPlayerInterface = this.M;
        if (videoPlayerInterface == null) {
            return false;
        }
        long c2 = c(((NativeVideoPlayer) videoPlayerInterface).f36113g.getCurrentPosition() + 50);
        if (G() && c2 == 0) {
            S();
            return true;
        } else if (!y().l() && !this.f36071e0) {
            return true;
        } else {
            i();
            return false;
        }
    }

    public void b(Bundle bundle) {
        super.b(bundle);
        bundle.putInt("currentPosition", this.S);
        bundle.putInt("latestPosition", this.T);
        bundle.putSerializable("fractionProgressImpressionsSent", this.f36067a0);
        bundle.putSerializable("absoluteProgressImpressionsSent", this.f36068b0);
        bundle.putBoolean("isMuted", this.R);
        bundle.putBoolean("shouldSetBg", this.V);
        bundle.putInt("pauseNum", this.f36069c0);
    }

    public void a(View view) {
        VideoAdDetails y2;
        z zVar;
        if (MetaData.f36379h.P() && (y2 = y()) != null) {
            me meVar = new me(this.f36800w.getContext(), y2.a(), true);
            this.I = meVar;
            if (meVar.c()) {
                try {
                    AdInformationView adInformationView = this.f36705c.f36263b;
                    if (adInformationView != null) {
                        this.I.a(adInformationView, FriendlyObstructionPurpose.OTHER, (String) null);
                    }
                    if (view != null) {
                        this.I.a(view, FriendlyObstructionPurpose.CLOSE_AD, (String) null);
                    }
                    this.I.a(this.f36800w, FriendlyObstructionPurpose.VIDEO_CONTROLS, (String) null);
                    this.I.a(this.P, FriendlyObstructionPurpose.OTHER, (String) null);
                } catch (RuntimeException e2) {
                    Log.e(L, "OMSDK error", e2);
                }
                this.I.a(this.N);
                this.I.e();
                me meVar2 = this.I;
                boolean G = G();
                long g2 = y().m() ? y().g() : 0;
                if (meVar2.f34940b != null && meVar2.f34943e.compareAndSet(false, true)) {
                    if (G) {
                        Position position = Position.STANDALONE;
                        p.a((Object) position, "Position is null");
                        zVar = new z(true, Float.valueOf((float) g2), true, position);
                    } else {
                        Position position2 = Position.STANDALONE;
                        p.a((Object) position2, "Position is null");
                        zVar = new z(false, (Float) null, true, position2);
                    }
                    r rVar = meVar2.f34940b;
                    rVar.getClass();
                    p.a((Object) zVar, "VastProperties is null");
                    p.a(rVar.f35730a);
                    p.c(rVar.f35730a);
                    x xVar = rVar.f35730a;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("skippable", zVar.f36973a);
                        if (zVar.f36973a) {
                            jSONObject.put("skipOffset", zVar.f36974b);
                        }
                        jSONObject.put("autoPlay", zVar.f36975c);
                        jSONObject.put(ViewProps.POSITION, zVar.f36976d);
                    } catch (JSONException e3) {
                        p.a("VastProperties: JSON error", (Exception) e3);
                    }
                    if (!xVar.f36855k) {
                        l.f34848a.a(xVar.f36850f.c(), "publishLoadedEvent", jSONObject);
                        xVar.f36855k = true;
                        return;
                    }
                    throw new IllegalStateException("Loaded event can only be sent once");
                }
            }
        }
    }

    public void b() {
        super.b();
        if (this.f36076j0) {
            String c2 = y().c();
            if (c2 != null && c2.endsWith(".temp")) {
                new File(c2).delete();
            }
        }
    }

    public final int b(int i2) {
        int i3 = this.U;
        if (i3 > 0) {
            return (i2 * 100) / i3;
        }
        return 0;
    }

    public void e(int i2) {
        List list;
        if (this.f36068b0.get(Integer.valueOf(i2)) == null) {
            if (this.f36085s0.containsKey(Integer.valueOf(i2)) && (list = this.f36085s0.get(Integer.valueOf(i2))) != null) {
                a((VideoTrackingLink[]) list.toArray(new AbsoluteTrackingLink[0]), new VideoProgressTrackingParams(this.f36718p, i2, this.F, this.f36079m0), i2, "absolute");
            }
            this.f36068b0.put(Integer.valueOf(i2), Boolean.TRUE);
        }
    }

    public void a(VideoFinishedReason videoFinishedReason) {
        me meVar;
        y yVar;
        me meVar2;
        y yVar2;
        if (!(videoFinishedReason != VideoFinishedReason.COMPLETE || (meVar2 = this.I) == null || (yVar2 = meVar2.f34941c) == null)) {
            p.a(yVar2.f36932a);
            l.f34848a.a(yVar2.f36932a.f36850f.c(), "complete", (JSONObject) null);
        }
        VideoFinishedReason videoFinishedReason2 = VideoFinishedReason.SKIPPED;
        if (!(videoFinishedReason != videoFinishedReason2 || (meVar = this.I) == null || (yVar = meVar.f34941c) == null)) {
            p.a(yVar.f36932a);
            l.f34848a.a(yVar.f36932a.f36850f.c(), "skipped", (JSONObject) null);
        }
        if (videoFinishedReason == videoFinishedReason2 || videoFinishedReason == VideoFinishedReason.CLICKED) {
            this.f36080n0.removeCallbacksAndMessages((Object) null);
            this.f36082p0.removeCallbacksAndMessages((Object) null);
            VideoPlayerInterface videoPlayerInterface = this.M;
            if (videoPlayerInterface != null) {
                this.T = ((NativeVideoPlayer) videoPlayerInterface).f36113g.getCurrentPosition();
                ((NativeVideoPlayer) this.M).f36113g.pause();
            }
        } else {
            this.T = this.U;
            u();
        }
        this.f36081o0.removeCallbacksAndMessages((Object) null);
        this.f36067a0.clear();
        this.f36068b0.clear();
        if (videoFinishedReason == VideoFinishedReason.CLICKED) {
            this.S = -1;
            return;
        }
        if (y().j()) {
            A();
            this.f36705c.f36263b.setVisibility(0);
        } else {
            b();
        }
        this.S = -1;
        if (y().j()) {
            a(y().h().m(), new VideoTrackingParams(this.f36718p, b(this.T), this.F, this.f36079m0), this.T, "postrollImression");
        }
    }

    public void f(int i2) {
        y yVar;
        if (this.f36067a0.get(Integer.valueOf(i2)) == null) {
            if (this.f36084r0.containsKey(Integer.valueOf(i2))) {
                List list = this.f36084r0.get(Integer.valueOf(i2));
                if (list != null) {
                    a((VideoTrackingLink[]) list.toArray(new FractionTrackingLink[0]), new VideoProgressTrackingParams(this.f36718p, i2, this.F, this.f36079m0), (this.U * i2) / 100, "fraction");
                }
                me meVar = this.I;
                if (meVar != null) {
                    if (i2 == 25) {
                        y yVar2 = meVar.f34941c;
                        if (yVar2 != null) {
                            p.a(yVar2.f36932a);
                            l.f34848a.a(yVar2.f36932a.f36850f.c(), "firstQuartile", (JSONObject) null);
                        }
                    } else if (i2 == 50) {
                        y yVar3 = meVar.f34941c;
                        if (yVar3 != null) {
                            p.a(yVar3.f36932a);
                            l.f34848a.a(yVar3.f36932a.f36850f.c(), "midpoint", (JSONObject) null);
                        }
                    } else if (i2 == 75 && (yVar = meVar.f34941c) != null) {
                        p.a(yVar.f36932a);
                        l.f34848a.a(yVar.f36932a.f36850f.c(), "thirdQuartile", (JSONObject) null);
                    }
                }
            }
            this.f36067a0.put(Integer.valueOf(i2), Boolean.TRUE);
        }
    }

    public final void a(int i2, Handler handler, Runnable runnable) {
        int i3 = this.S;
        if (i3 < i2) {
            handler.postDelayed(runnable, (long) (i2 - i3));
        }
    }

    public void a(VideoPlayerInterface.e eVar) {
        VASTErrorCodes vASTErrorCodes;
        int i2;
        VideoPlayerInterface videoPlayerInterface;
        y8 y8Var = new y8(z8.f36996c);
        y8Var.f36954d = "Video player error: " + eVar.f36128a;
        y8Var.f36955e = eVar.f36129b;
        y8Var.f36957g = a();
        y8Var.a(this.f36704b);
        int ordinal = eVar.f36128a.ordinal();
        boolean z2 = true;
        if (ordinal == 1) {
            vASTErrorCodes = VASTErrorCodes.GeneralLinearError;
        } else if (ordinal == 2) {
            vASTErrorCodes = VASTErrorCodes.TimeoutMediaFileURI;
        } else if (ordinal != 3) {
            vASTErrorCodes = VASTErrorCodes.UndefinedError;
        } else {
            vASTErrorCodes = VASTErrorCodes.MediaFileDisplayError;
        }
        d6 d6Var = new d6(y().h().e(), new VideoTrackingParams(this.f36718p, b(this.T), this.F, this.f36079m0), y().i(), this.T);
        d6Var.f34347f = vASTErrorCodes;
        d6Var.f34346e = MRAIDPresenter.ERROR;
        p.a((Context) this.f36704b, d6Var.a());
        if (!this.f36073g0 || (videoPlayerInterface = this.M) == null) {
            i2 = this.S;
        } else {
            i2 = ((NativeVideoPlayer) videoPlayerInterface).f36113g.getCurrentPosition();
        }
        if (i2 == 0) {
            o6.a((Context) this.f36704b, this.f36711i, this.f36718p, this.F, "VIDEO_ERROR", (JSONObject) null);
            if (!this.f36073g0) {
                p.d(this.f36704b);
            } else if (!eVar.f36128a.equals(VideoPlayerInterface.VideoPlayerErrorType.BUFFERING_TIMEOUT)) {
                p.d(this.f36704b);
            }
        }
        if (this.f36714l.getType() != Ad.AdType.REWARDED_VIDEO) {
            z2 = false;
        }
        if ((!z2 || this.E) && y().j()) {
            a(VideoFinishedReason.SKIPPED);
            return;
        }
        x();
        b();
    }

    public boolean a(String str, boolean z2) {
        String str2;
        ActionTrackingLink[] actionTrackingLinkArr;
        boolean I = I();
        if (I) {
            str2 = y().d();
        } else {
            str2 = y().b();
        }
        if (!TextUtils.isEmpty(str2)) {
            z2 = true;
            str = str2;
        }
        if (!I) {
            a(VideoFinishedReason.CLICKED);
        }
        if (I) {
            actionTrackingLinkArr = y().h().k();
        } else {
            actionTrackingLinkArr = y().h().h();
        }
        a(actionTrackingLinkArr, new VideoClickedTrackingParams(this.f36718p, b(this.T), this.F, I, this.f36079m0), this.T, "clicked");
        me meVar = this.I;
        if (meVar != null) {
            InteractionType interactionType = InteractionType.CLICK;
            y yVar = meVar.f34941c;
            if (yVar != null) {
                p.a((Object) interactionType, "InteractionType is null");
                p.a(yVar.f36932a);
                JSONObject jSONObject = new JSONObject();
                fg.a(jSONObject, "interactionType", interactionType);
                l.f34848a.a(yVar.f36932a.f36850f.c(), "adUserInteraction", jSONObject);
            }
        }
        return super.a(str, z2);
    }

    public void a(boolean z2) {
        ActionTrackingLink[] actionTrackingLinkArr;
        if (this.M != null) {
            if (z2) {
                actionTrackingLinkArr = y().h().f();
            } else {
                actionTrackingLinkArr = y().h().g();
            }
            a(actionTrackingLinkArr, new VideoTrackingParams(this.f36718p, b(((NativeVideoPlayer) this.M).f36113g.getCurrentPosition()), this.F, this.f36079m0), ((NativeVideoPlayer) this.M).f36113g.getCurrentPosition(), "sound");
            me meVar = this.I;
            if (meVar != null) {
                float f2 = z2 ? 0.0f : 1.0f;
                y yVar = meVar.f34941c;
                if (yVar != null) {
                    yVar.a(f2);
                    p.a(yVar.f36932a);
                    JSONObject jSONObject = new JSONObject();
                    fg.a(jSONObject, "mediaPlayerVolume", Float.valueOf(f2));
                    fg.a(jSONObject, "deviceVolume", Float.valueOf(m.a().f34886b));
                    l.f34848a.a(yVar.f36932a.f36850f.c(), "volumeChange", jSONObject);
                }
            }
        }
    }

    public final void a(VideoTrackingLink[] videoTrackingLinkArr, VideoTrackingParams videoTrackingParams, int i2, String str) {
        d6 d6Var = new d6(videoTrackingLinkArr, videoTrackingParams, y().i(), i2);
        d6Var.f34346e = str;
        p.a((Context) this.f36704b, d6Var.a());
    }
}
