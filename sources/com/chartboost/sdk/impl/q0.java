package com.chartboost.sdk.impl;

import android.media.MediaPlayer;
import android.os.Build;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import b0.j0;
import b0.k0;
import b0.l0;
import b0.m0;
import com.chartboost.sdk.impl.tc;
import com.chartboost.sdk.impl.zc;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

public final class q0 implements s0, SurfaceHolder.Callback, zc.b, tc.b, o1 {

    /* renamed from: a  reason: collision with root package name */
    public MediaPlayer f18402a;

    /* renamed from: b  reason: collision with root package name */
    public SurfaceView f18403b;

    /* renamed from: c  reason: collision with root package name */
    public t0 f18404c;

    /* renamed from: d  reason: collision with root package name */
    public final bc f18405d;

    /* renamed from: e  reason: collision with root package name */
    public final Function4 f18406e;

    /* renamed from: f  reason: collision with root package name */
    public final CoroutineDispatcher f18407f;

    /* renamed from: g  reason: collision with root package name */
    public final v5 f18408g;

    /* renamed from: h  reason: collision with root package name */
    public long f18409h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f18410i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f18411j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f18412k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f18413l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f18414m;

    /* renamed from: n  reason: collision with root package name */
    public SurfaceHolder f18415n;

    /* renamed from: o  reason: collision with root package name */
    public s9 f18416o;

    /* renamed from: p  reason: collision with root package name */
    public tc f18417p;

    /* renamed from: q  reason: collision with root package name */
    public final zc f18418q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f18419r;

    /* renamed from: s  reason: collision with root package name */
    public float f18420s;

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function0 {
        public a(Object obj) {
            super(0, obj, q0.class, "startMediaPlayer", "startMediaPlayer()V", 0);
        }

        public final void a() {
            ((q0) this.receiver).n();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f40298a;
        }
    }

    public q0(MediaPlayer mediaPlayer, SurfaceView surfaceView, t0 t0Var, bc bcVar, Function3 function3, Function4 function4, CoroutineDispatcher coroutineDispatcher, v5 v5Var) {
        Intrinsics.f(bcVar, "uiPoster");
        Intrinsics.f(function3, "videoProgressFactory");
        Intrinsics.f(function4, "videoBufferFactory");
        Intrinsics.f(coroutineDispatcher, "coroutineDispatcher");
        Intrinsics.f(v5Var, "fileCache");
        this.f18402a = mediaPlayer;
        this.f18403b = surfaceView;
        this.f18404c = t0Var;
        this.f18405d = bcVar;
        this.f18406e = function4;
        this.f18407f = coroutineDispatcher;
        this.f18408g = v5Var;
        this.f18415n = surfaceView != null ? surfaceView.getHolder() : null;
        this.f18418q = (zc) function3.invoke(this.f18404c, this, bcVar);
    }

    public void b() {
        MediaPlayer mediaPlayer = this.f18402a;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(1.0f, 1.0f);
        }
    }

    public final void c(int i2, int i3) {
        String str = "error: " + i2 + " extra: " + i3;
        String a2 = r0.f18506a;
        Intrinsics.e(a2, "TAG");
        w7.b(a2, "MediaPlayer error: " + str);
        if (this.f18410i) {
            e();
        }
    }

    public long d() {
        MediaPlayer mediaPlayer = this.f18402a;
        if (mediaPlayer == null) {
            return 0;
        }
        long currentPosition = (long) mediaPlayer.getCurrentPosition();
        this.f18409h = currentPosition;
        return currentPosition;
    }

    public final void e() {
        if (this.f18411j && !this.f18413l) {
            tc tcVar = this.f18417p;
            if (tcVar != null) {
                tcVar.a();
            }
            this.f18413l = false;
            t0 t0Var = this.f18404c;
            if (t0Var != null) {
                t0Var.a();
            }
            pause();
            tc tcVar2 = this.f18417p;
            if (tcVar2 != null) {
                tcVar2.c();
            }
        }
    }

    public void f() {
        this.f18420s = 0.0f;
        MediaPlayer mediaPlayer = this.f18402a;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(0.0f, 0.0f);
        }
    }

    public float g() {
        return this.f18420s;
    }

    public boolean h() {
        return this.f18419r;
    }

    public final void i() {
        MediaPlayer mediaPlayer = this.f18402a;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        this.f18404c = null;
        this.f18402a = null;
        this.f18415n = null;
        this.f18403b = null;
        this.f18417p = null;
    }

    public final void j() {
        this.f18418q.a();
    }

    public final void k() {
        zc.a.a(this.f18418q, 0, 1, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
        if (r2 == null) goto L_0x001a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l() {
        /*
            r5 = this;
            java.lang.String r0 = "TAG"
            r1 = 0
            com.chartboost.sdk.impl.s9 r2 = r5.f18416o     // Catch:{ IOException -> 0x0036 }
            if (r2 == 0) goto L_0x001a
            java.io.FileDescriptor r2 = r2.b()     // Catch:{ IOException -> 0x0036 }
            if (r2 == 0) goto L_0x001a
            android.media.MediaPlayer r3 = r5.f18402a     // Catch:{ IOException -> 0x0036 }
            if (r3 == 0) goto L_0x0017
            r3.setDataSource(r2)     // Catch:{ IOException -> 0x0036 }
            kotlin.Unit r2 = kotlin.Unit.f40298a     // Catch:{ IOException -> 0x0036 }
            goto L_0x0018
        L_0x0017:
            r2 = r1
        L_0x0018:
            if (r2 != 0) goto L_0x0027
        L_0x001a:
            com.chartboost.sdk.impl.t0 r2 = r5.f18404c     // Catch:{ IOException -> 0x0036 }
            if (r2 == 0) goto L_0x0026
            java.lang.String r3 = "Missing video asset"
            r2.a((java.lang.String) r3)     // Catch:{ IOException -> 0x0036 }
            kotlin.Unit r2 = kotlin.Unit.f40298a     // Catch:{ IOException -> 0x0036 }
            goto L_0x0027
        L_0x0026:
            r2 = r1
        L_0x0027:
            if (r2 != 0) goto L_0x0070
            java.lang.String r2 = com.chartboost.sdk.impl.r0.f18506a     // Catch:{ IOException -> 0x0036 }
            kotlin.jvm.internal.Intrinsics.e(r2, r0)     // Catch:{ IOException -> 0x0036 }
            java.lang.String r3 = "MediaPlayer missing callback on error"
            com.chartboost.sdk.impl.w7.b(r2, r3)     // Catch:{ IOException -> 0x0036 }
            goto L_0x0070
        L_0x0036:
            r2 = move-exception
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 23
            if (r3 >= r4) goto L_0x0046
            android.media.MediaPlayer r3 = r5.f18402a
            if (r3 == 0) goto L_0x0046
            java.lang.String r4 = ""
            r3.setDataSource(r4)
        L_0x0046:
            com.chartboost.sdk.impl.t0 r3 = r5.f18404c
            if (r3 == 0) goto L_0x0053
            java.lang.String r1 = r2.toString()
            r3.a((java.lang.String) r1)
            kotlin.Unit r1 = kotlin.Unit.f40298a
        L_0x0053:
            if (r1 != 0) goto L_0x0070
            java.lang.String r1 = com.chartboost.sdk.impl.r0.f18506a
            kotlin.jvm.internal.Intrinsics.e(r1, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "MediaPlayer missing callback on IOException: "
            r0.append(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.chartboost.sdk.impl.w7.b(r1, r0)
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.q0.l():void");
    }

    public final void m() {
        MediaPlayer mediaPlayer = this.f18402a;
        if (mediaPlayer != null) {
            mediaPlayer.setOnPreparedListener(new j0(this));
            mediaPlayer.setOnInfoListener(new k0(this));
            mediaPlayer.setOnCompletionListener(new l0(this));
            mediaPlayer.setOnErrorListener(new m0(this));
        }
    }

    public final void n() {
        Unit unit;
        MediaPlayer mediaPlayer = this.f18402a;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.start();
                this.f18419r = true;
                k();
                t0 t0Var = this.f18404c;
                if (t0Var != null) {
                    t0Var.b();
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    mediaPlayer.seekTo(this.f18409h, 3);
                } else {
                    mediaPlayer.seekTo((int) this.f18409h);
                }
                unit = Unit.f40298a;
            } catch (IllegalStateException e2) {
                t0 t0Var2 = this.f18404c;
                if (t0Var2 != null) {
                    t0Var2.a(e2.toString());
                    unit = Unit.f40298a;
                } else {
                    unit = null;
                }
            }
            if (unit != null) {
                return;
            }
        }
        t0 t0Var3 = this.f18404c;
        if (t0Var3 != null) {
            t0Var3.a("Missing video player during startVideoPlayer");
            Unit unit2 = Unit.f40298a;
        }
    }

    public final void o() {
        this.f18405d.a(500, new a(this));
    }

    public void pause() {
        String a2 = r0.f18506a;
        Intrinsics.e(a2, "TAG");
        w7.a(a2, "pause()");
        if (this.f18410i && this.f18411j) {
            tc tcVar = this.f18417p;
            if (tcVar != null) {
                tcVar.e();
            }
            j();
            try {
                MediaPlayer mediaPlayer = this.f18402a;
                if (mediaPlayer != null) {
                    mediaPlayer.pause();
                }
            } catch (Exception e2) {
                t0 t0Var = this.f18404c;
                if (t0Var != null) {
                    t0Var.a(e2.toString());
                }
            }
            this.f18409h = d();
            this.f18411j = false;
            this.f18412k = true;
        }
    }

    public void play() {
        String a2 = r0.f18506a;
        Intrinsics.e(a2, "TAG");
        w7.a(a2, "play()");
        if (this.f18410i && !this.f18411j) {
            o();
        }
        this.f18411j = true;
        this.f18412k = this.f18414m;
        this.f18414m = false;
    }

    public void stop() {
        String a2 = r0.f18506a;
        Intrinsics.e(a2, "TAG");
        w7.a(a2, "stop()");
        if (this.f18410i) {
            tc tcVar = this.f18417p;
            if (tcVar != null) {
                tcVar.e();
            }
            this.f18417p = null;
            this.f18409h = 0;
            j();
            try {
                MediaPlayer mediaPlayer = this.f18402a;
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                }
            } catch (Exception e2) {
                t0 t0Var = this.f18404c;
                if (t0Var != null) {
                    t0Var.a(e2.toString());
                }
            }
            this.f18411j = false;
            this.f18412k = false;
            s9 s9Var = this.f18416o;
            if (s9Var != null) {
                s9Var.a();
            }
            this.f18416o = null;
            i();
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Intrinsics.f(surfaceHolder, "holder");
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Intrinsics.f(surfaceHolder, "holder");
        if (this.f18412k) {
            MediaPlayer mediaPlayer = this.f18402a;
            if (mediaPlayer != null) {
                mediaPlayer.setDisplay(surfaceHolder);
            }
            play();
            return;
        }
        try {
            m();
            l();
            MediaPlayer mediaPlayer2 = this.f18402a;
            if (mediaPlayer2 != null) {
                mediaPlayer2.prepareAsync();
            }
            MediaPlayer mediaPlayer3 = this.f18402a;
            if (mediaPlayer3 != null) {
                mediaPlayer3.setDisplay(surfaceHolder);
            }
        } catch (Exception e2) {
            String a2 = r0.f18506a;
            Intrinsics.e(a2, "TAG");
            w7.b(a2, "SurfaceCreated exception: " + e2);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Intrinsics.f(surfaceHolder, "holder");
        MediaPlayer mediaPlayer = this.f18402a;
        if (mediaPlayer != null) {
            mediaPlayer.setDisplay((SurfaceHolder) null);
        }
    }

    private final void b(int i2, int i3) {
        MediaPlayer mediaPlayer = this.f18402a;
        if (mediaPlayer != null) {
            SurfaceView surfaceView = this.f18403b;
            int videoHeight = mediaPlayer.getVideoHeight();
            MediaPlayer mediaPlayer2 = this.f18402a;
            jd.a(surfaceView, mediaPlayer2 != null ? mediaPlayer2.getVideoWidth() : 1, videoHeight, i2, i3);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0048, code lost:
        if (r0 == null) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.chartboost.sdk.impl.rc r4) {
        /*
            r3 = this;
            java.lang.String r0 = "asset"
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            java.lang.String r0 = com.chartboost.sdk.impl.r0.f18506a
            java.lang.String r1 = "TAG"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "asset() - asset: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            com.chartboost.sdk.impl.w7.a(r0, r1)
            android.media.MediaPlayer r0 = r3.f18402a
            if (r0 == 0) goto L_0x004a
            kotlin.jvm.functions.Function4 r0 = r3.f18406e
            kotlinx.coroutines.CoroutineDispatcher r1 = r3.f18407f
            com.chartboost.sdk.impl.v5 r2 = r3.f18408g
            java.lang.Object r4 = r0.invoke(r4, r3, r1, r2)
            com.chartboost.sdk.impl.tc r4 = (com.chartboost.sdk.impl.tc) r4
            r3.f18417p = r4
            r0 = 0
            if (r4 == 0) goto L_0x003c
            com.chartboost.sdk.impl.s9 r4 = r4.d()
            goto L_0x003d
        L_0x003c:
            r4 = r0
        L_0x003d:
            r3.f18416o = r4
            android.view.SurfaceHolder r4 = r3.f18415n
            if (r4 == 0) goto L_0x0048
            r4.addCallback(r3)
            kotlin.Unit r0 = kotlin.Unit.f40298a
        L_0x0048:
            if (r0 != 0) goto L_0x0055
        L_0x004a:
            com.chartboost.sdk.impl.t0 r4 = r3.f18404c
            if (r4 == 0) goto L_0x0055
            java.lang.String r0 = "Missing media player during startMediaPlayer"
            r4.a((java.lang.String) r0)
            kotlin.Unit r4 = kotlin.Unit.f40298a
        L_0x0055:
            r4 = 0
            r3.f18419r = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.q0.a(com.chartboost.sdk.impl.rc):void");
    }

    public void c() {
        this.f18411j = true;
        MediaPlayer mediaPlayer = this.f18402a;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
        }
        l();
        MediaPlayer mediaPlayer2 = this.f18402a;
        if (mediaPlayer2 != null) {
            mediaPlayer2.prepareAsync();
        }
        t0 t0Var = this.f18404c;
        if (t0Var != null) {
            t0Var.c();
        }
    }

    public static final boolean b(q0 q0Var, MediaPlayer mediaPlayer, int i2, int i3) {
        Intrinsics.f(q0Var, "this$0");
        q0Var.c(i2, i3);
        return true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q0(MediaPlayer mediaPlayer, SurfaceView surfaceView, t0 t0Var, bc bcVar, Function3 function3, Function4 function4, CoroutineDispatcher coroutineDispatcher, v5 v5Var, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new MediaPlayer() : mediaPlayer, surfaceView, t0Var, bcVar, function3, function4, (i2 & 64) != 0 ? Dispatchers.c() : coroutineDispatcher, v5Var);
    }

    public void a() {
        this.f18414m = true;
    }

    public void a(int i2, int i3) {
        b(i3, i2);
    }

    public final void a(MediaPlayer mediaPlayer) {
        int i2 = 0;
        this.f18413l = false;
        int duration = mediaPlayer.getDuration();
        SurfaceView surfaceView = this.f18403b;
        int width = surfaceView != null ? surfaceView.getWidth() : 0;
        SurfaceView surfaceView2 = this.f18403b;
        if (surfaceView2 != null) {
            i2 = surfaceView2.getHeight();
        }
        b(width, i2);
        t0 t0Var = this.f18404c;
        if (t0Var != null) {
            t0Var.b((long) duration);
        }
        this.f18410i = true;
        tc tcVar = this.f18417p;
        if (tcVar != null) {
            tcVar.a(duration);
        }
        if (this.f18411j) {
            n();
        }
    }

    public static final boolean a(q0 q0Var, MediaPlayer mediaPlayer, int i2, int i3) {
        Intrinsics.f(q0Var, "this$0");
        if ((i2 != 805 && i2 != 804) || i3 != -1004) {
            return true;
        }
        q0Var.e();
        return true;
    }

    public static final void a(q0 q0Var, MediaPlayer mediaPlayer) {
        Intrinsics.f(q0Var, "this$0");
        if (((double) q0Var.f18409h) >= ((double) mediaPlayer.getDuration()) - (((double) mediaPlayer.getDuration()) * 0.05d)) {
            t0 t0Var = q0Var.f18404c;
            if (t0Var != null) {
                t0Var.d();
                return;
            }
            return;
        }
        q0Var.e();
    }
}
