package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.adcolony.sdk.e0;
import com.facebook.common.util.UriUtil;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.uimanager.ViewProps;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

@TargetApi(14)
class a1 extends TextureView implements MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnSeekCompleteListener, TextureView.SurfaceTextureListener {
    /* access modifiers changed from: private */
    public boolean A;
    private boolean B;
    /* access modifiers changed from: private */
    public boolean C;
    /* access modifiers changed from: private */
    public boolean D;
    private boolean E;
    private String F;
    /* access modifiers changed from: private */
    public String G;
    private FileInputStream H;
    private h0 I;
    /* access modifiers changed from: private */
    public c J;
    private Surface K;
    private SurfaceTexture L;
    /* access modifiers changed from: private */
    public RectF M = new RectF();
    /* access modifiers changed from: private */
    public j N;
    private ProgressBar O;
    /* access modifiers changed from: private */
    public MediaPlayer P;
    /* access modifiers changed from: private */
    public f1 Q = c0.q();
    private ExecutorService R = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */
    public h0 S;

    /* renamed from: b  reason: collision with root package name */
    private float f12912b;

    /* renamed from: c  reason: collision with root package name */
    private float f12913c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public float f12914d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public float f12915e;

    /* renamed from: f  reason: collision with root package name */
    private float f12916f;

    /* renamed from: g  reason: collision with root package name */
    private float f12917g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f12918h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f12919i = true;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public Paint f12920j = new Paint();
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public Paint f12921k = new Paint(1);

    /* renamed from: l  reason: collision with root package name */
    private int f12922l;

    /* renamed from: m  reason: collision with root package name */
    private int f12923m;

    /* renamed from: n  reason: collision with root package name */
    private int f12924n;

    /* renamed from: o  reason: collision with root package name */
    private int f12925o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public int f12926p;

    /* renamed from: q  reason: collision with root package name */
    private int f12927q;

    /* renamed from: r  reason: collision with root package name */
    private int f12928r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public double f12929s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public double f12930t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public long f12931u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public boolean f12932v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public boolean f12933w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public boolean f12934x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public boolean f12935y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f12936z;

    class a implements j0 {
        a() {
        }

        public void a(h0 h0Var) {
            if (a1.this.h(h0Var)) {
                a1.this.I();
            }
        }
    }

    class b implements j0 {
        b() {
        }

        public void a(h0 h0Var) {
            if (a1.this.h(h0Var)) {
                a1.this.q(h0Var);
            }
        }
    }

    class c implements j0 {
        c() {
        }

        public void a(h0 h0Var) {
            if (a1.this.h(h0Var)) {
                a1.this.u(h0Var);
            }
        }
    }

    class d implements j0 {
        d() {
        }

        public void a(h0 h0Var) {
            if (a1.this.h(h0Var)) {
                a1.this.H();
            }
        }
    }

    class e implements j0 {
        e() {
        }

        public void a(h0 h0Var) {
            if (a1.this.h(h0Var)) {
                boolean unused = a1.this.n(h0Var);
            }
        }
    }

    class f implements j0 {
        f() {
        }

        public void a(h0 h0Var) {
            if (a1.this.h(h0Var)) {
                boolean unused = a1.this.A(h0Var);
            }
        }
    }

    class g implements Runnable {
        g() {
        }

        public void run() {
            try {
                Thread.sleep(150);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (a1.this.S != null) {
                f1 q2 = c0.q();
                c0.u(q2, "id", a1.this.f12926p);
                c0.n(q2, "ad_session_id", a1.this.G);
                c0.w(q2, "success", true);
                a1.this.S.b(q2).e();
                h0 unused = a1.this.S = null;
            }
        }
    }

    class h implements Runnable {
        h() {
        }

        public void run() {
            long unused = a1.this.f12931u = 0;
            while (!a1.this.f12932v && !a1.this.f12935y && a.h()) {
                Context a2 = a.a();
                if (!a1.this.f12932v && !a1.this.A && a2 != null && (a2 instanceof Activity)) {
                    if (a1.this.P.isPlaying()) {
                        if (a1.this.f12931u == 0 && a.f12895d) {
                            long unused2 = a1.this.f12931u = System.currentTimeMillis();
                        }
                        boolean unused3 = a1.this.f12934x = true;
                        a1 a1Var = a1.this;
                        double unused4 = a1Var.f12929s = ((double) a1Var.P.getCurrentPosition()) / 1000.0d;
                        a1 a1Var2 = a1.this;
                        double unused5 = a1Var2.f12930t = ((double) a1Var2.P.getDuration()) / 1000.0d;
                        if (System.currentTimeMillis() - a1.this.f12931u > 1000 && !a1.this.D && a.f12895d) {
                            if (a1.this.f12929s == 0.0d) {
                                new e0.a().c("getCurrentPosition() not working, firing ").c("AdSession.on_error").d(e0.f13114i);
                                a1.this.E();
                            } else {
                                boolean unused6 = a1.this.D = true;
                            }
                        }
                        if (a1.this.C) {
                            a1.this.y();
                        }
                    }
                    if (a1.this.f12934x && !a1.this.f12932v && !a1.this.f12935y) {
                        c0.u(a1.this.Q, "id", a1.this.f12926p);
                        c0.u(a1.this.Q, "container_id", a1.this.J.p());
                        c0.n(a1.this.Q, "ad_session_id", a1.this.G);
                        c0.k(a1.this.Q, "elapsed", a1.this.f12929s);
                        c0.k(a1.this.Q, "duration", a1.this.f12930t);
                        new h0("VideoView.on_progress", a1.this.J.I(), a1.this.Q).e();
                    }
                    if (a1.this.f12933w || ((Activity) a2).isFinishing()) {
                        boolean unused7 = a1.this.f12933w = false;
                        a1.this.L();
                        return;
                    }
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException unused8) {
                        a1.this.E();
                        new e0.a().c("InterruptedException in ADCVideoView's update thread.").d(e0.f13113h);
                    }
                } else {
                    return;
                }
            }
            if (a1.this.f12933w) {
                a1.this.L();
            }
        }
    }

    class i implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f12945b;

        i(Context context) {
            this.f12945b = context;
        }

        public void run() {
            j unused = a1.this.N = new j(this.f12945b);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (a1.this.f12914d * 4.0f), (int) (a1.this.f12914d * 4.0f));
            layoutParams.setMargins(0, a1.this.J.k() - ((int) (a1.this.f12914d * 4.0f)), 0, 0);
            layoutParams.gravity = 0;
            a1.this.J.addView(a1.this.N, layoutParams);
        }
    }

    private class j extends View {
        j(Context context) {
            super(context);
            setWillNotDraw(false);
            Class<j> cls = j.class;
            try {
                cls.getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class}).invoke(this, new Object[]{1, null});
            } catch (Exception unused) {
            }
        }

        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawArc(a1.this.M, 270.0f, a1.this.f12915e, false, a1.this.f12920j);
            canvas.drawText("" + a1.this.f12918h, a1.this.M.centerX(), (float) (((double) a1.this.M.centerY()) + (((double) a1.this.f12921k.getFontMetrics().bottom) * 1.35d)), a1.this.f12921k);
            invalidate();
        }
    }

    a1(Context context, h0 h0Var, int i2, c cVar) {
        super(context);
        this.J = cVar;
        this.I = h0Var;
        this.f12926p = i2;
        setSurfaceTextureListener(this);
    }

    /* access modifiers changed from: private */
    public boolean A(h0 h0Var) {
        boolean z2 = false;
        if (!this.f12936z) {
            return false;
        }
        float y2 = (float) c0.y(h0Var.a(), "volume");
        AdColonyInterstitial q02 = a.f().q0();
        if (q02 != null) {
            if (((double) y2) <= 0.0d) {
                z2 = true;
            }
            q02.h(z2);
        }
        this.P.setVolume(y2, y2);
        f1 q2 = c0.q();
        c0.w(q2, "success", true);
        h0Var.b(q2).e();
        return true;
    }

    /* access modifiers changed from: private */
    public void E() {
        f1 q2 = c0.q();
        c0.n(q2, "id", this.G);
        new h0("AdSession.on_error", this.J.I(), q2).e();
        this.f12932v = true;
    }

    private void O() {
        double min = Math.min(((double) this.f12924n) / ((double) this.f12927q), ((double) this.f12925o) / ((double) this.f12928r));
        int i2 = (int) (((double) this.f12927q) * min);
        int i3 = (int) (((double) this.f12928r) * min);
        new e0.a().c("setMeasuredDimension to ").a(i2).c(" by ").a(i3).d(e0.f13110e);
        setMeasuredDimension(i2, i3);
        if (this.B) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
            layoutParams.width = i2;
            layoutParams.height = i3;
            layoutParams.gravity = 17;
            layoutParams.setMargins(0, 0, 0, 0);
            setLayoutParams(layoutParams);
        }
    }

    private void R() {
        try {
            this.R.submit(new h());
        } catch (RejectedExecutionException unused) {
            E();
        }
    }

    /* access modifiers changed from: private */
    public boolean h(h0 h0Var) {
        f1 a2 = h0Var.a();
        if (c0.A(a2, "id") == this.f12926p && c0.A(a2, "container_id") == this.J.p() && c0.E(a2, "ad_session_id").equals(this.J.b())) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean n(h0 h0Var) {
        if (!this.f12936z) {
            return false;
        }
        if (this.f12932v) {
            this.f12932v = false;
        }
        this.S = h0Var;
        int A2 = c0.A(h0Var.a(), "time");
        int duration = this.P.getDuration() / 1000;
        this.P.setOnSeekCompleteListener(this);
        this.P.seekTo(A2 * 1000);
        if (duration == A2) {
            this.f12932v = true;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void q(h0 h0Var) {
        f1 a2 = h0Var.a();
        this.f12922l = c0.A(a2, "x");
        this.f12923m = c0.A(a2, "y");
        this.f12924n = c0.A(a2, "width");
        this.f12925o = c0.A(a2, "height");
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.setMargins(this.f12922l, this.f12923m, 0, 0);
        layoutParams.width = this.f12924n;
        layoutParams.height = this.f12925o;
        setLayoutParams(layoutParams);
        if (this.C && this.N != null) {
            int i2 = (int) (this.f12914d * 4.0f);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i2, i2);
            layoutParams2.setMargins(0, this.J.k() - ((int) (this.f12914d * 4.0f)), 0, 0);
            layoutParams2.gravity = 0;
            this.N.setLayoutParams(layoutParams2);
        }
    }

    /* access modifiers changed from: private */
    public void u(h0 h0Var) {
        j jVar;
        j jVar2;
        if (c0.t(h0Var.a(), ViewProps.VISIBLE)) {
            setVisibility(0);
            if (this.C && (jVar2 = this.N) != null) {
                jVar2.setVisibility(0);
                return;
            }
            return;
        }
        setVisibility(4);
        if (this.C && (jVar = this.N) != null) {
            jVar.setVisibility(4);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean D() {
        return this.f12932v;
    }

    /* access modifiers changed from: package-private */
    public boolean H() {
        if (!this.f12936z) {
            new e0.a().c("ADCVideoView pause() called while MediaPlayer is not prepared.").d(e0.f13112g);
            return false;
        } else if (!this.f12934x) {
            return false;
        } else {
            this.P.getCurrentPosition();
            this.f12930t = (double) this.P.getDuration();
            this.P.pause();
            this.f12935y = true;
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean I() {
        if (!this.f12936z) {
            return false;
        }
        if (!this.f12935y && a.f12895d) {
            this.P.start();
            R();
        } else if (!this.f12932v && a.f12895d) {
            this.P.start();
            this.f12935y = false;
            if (!this.R.isShutdown()) {
                R();
            }
            j jVar = this.N;
            if (jVar != null) {
                jVar.invalidate();
            }
        }
        setWillNotDraw(false);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void L() {
        new e0.a().c("MediaPlayer stopped and released.").d(e0.f13110e);
        try {
            if (!this.f12932v && this.f12936z && this.P.isPlaying()) {
                this.P.stop();
            }
        } catch (IllegalStateException unused) {
            new e0.a().c("Caught IllegalStateException when calling stop on MediaPlayer").d(e0.f13112g);
        }
        ProgressBar progressBar = this.O;
        if (progressBar != null) {
            this.J.removeView(progressBar);
        }
        this.f12932v = true;
        this.f12936z = false;
        this.P.release();
    }

    /* access modifiers changed from: package-private */
    public void N() {
        this.f12933w = true;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (this.L != null) {
            this.A = true;
        }
        this.R.shutdown();
    }

    /* access modifiers changed from: package-private */
    public MediaPlayer j() {
        return this.P;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f12932v = true;
        this.f12929s = this.f12930t;
        c0.u(this.Q, "id", this.f12926p);
        c0.u(this.Q, "container_id", this.J.p());
        c0.n(this.Q, "ad_session_id", this.G);
        c0.k(this.Q, "elapsed", this.f12929s);
        c0.k(this.Q, "duration", this.f12930t);
        new h0("VideoView.on_progress", this.J.I(), this.Q).e();
    }

    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        E();
        e0.a aVar = new e0.a();
        aVar.c("MediaPlayer error: " + i2 + "," + i3).d(e0.f13113h);
        return true;
    }

    public void onMeasure(int i2, int i3) {
        O();
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f12936z = true;
        if (this.E) {
            this.J.removeView(this.O);
        }
        if (this.B) {
            this.f12927q = mediaPlayer.getVideoWidth();
            this.f12928r = mediaPlayer.getVideoHeight();
            O();
            new e0.a().c("MediaPlayer getVideoWidth = ").a(mediaPlayer.getVideoWidth()).d(e0.f13110e);
            new e0.a().c("MediaPlayer getVideoHeight = ").a(mediaPlayer.getVideoHeight()).d(e0.f13110e);
        }
        f1 q2 = c0.q();
        c0.u(q2, "id", this.f12926p);
        c0.u(q2, "container_id", this.J.p());
        c0.n(q2, "ad_session_id", this.G);
        new h0("VideoView.on_ready", this.J.I(), q2).e();
    }

    public void onSeekComplete(MediaPlayer mediaPlayer) {
        ExecutorService executorService = this.R;
        if (executorService != null && !executorService.isShutdown()) {
            try {
                this.R.submit(new g());
            } catch (RejectedExecutionException unused) {
                E();
            }
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        if (surfaceTexture == null || this.A) {
            new e0.a().c("Null texture provided by system's onSurfaceTextureAvailable or ").c("MediaPlayer has been destroyed.").d(e0.f13114i);
            return;
        }
        Surface surface = new Surface(surfaceTexture);
        this.K = surface;
        try {
            this.P.setSurface(surface);
        } catch (IllegalStateException unused) {
            new e0.a().c("IllegalStateException thrown when calling MediaPlayer.setSurface()").d(e0.f13113h);
            E();
        }
        this.L = surfaceTexture;
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.L = surfaceTexture;
        if (!this.A) {
            return false;
        }
        surfaceTexture.release();
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.L = surfaceTexture;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.L = surfaceTexture;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        k f2 = a.f();
        d T = f2.T();
        int action = motionEvent.getAction() & JfifUtil.MARKER_FIRST_BYTE;
        if (action != 0 && action != 1 && action != 3 && action != 2 && action != 5 && action != 6) {
            return false;
        }
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        f1 q2 = c0.q();
        c0.u(q2, "view_id", this.f12926p);
        c0.n(q2, "ad_session_id", this.G);
        c0.u(q2, "container_x", this.f12922l + x2);
        c0.u(q2, "container_y", this.f12923m + y2);
        c0.u(q2, "view_x", x2);
        c0.u(q2, "view_y", y2);
        c0.u(q2, "id", this.J.p());
        if (action == 0) {
            new h0("AdContainer.on_touch_began", this.J.I(), q2).e();
        } else if (action == 1) {
            if (!this.J.N()) {
                f2.v(T.s().get(this.G));
            }
            new h0("AdContainer.on_touch_ended", this.J.I(), q2).e();
        } else if (action == 2) {
            new h0("AdContainer.on_touch_moved", this.J.I(), q2).e();
        } else if (action == 3) {
            new h0("AdContainer.on_touch_cancelled", this.J.I(), q2).e();
        } else if (action == 5) {
            int action2 = (motionEvent.getAction() & 65280) >> 8;
            c0.u(q2, "container_x", ((int) motionEvent2.getX(action2)) + this.f12922l);
            c0.u(q2, "container_y", ((int) motionEvent2.getY(action2)) + this.f12923m);
            c0.u(q2, "view_x", (int) motionEvent2.getX(action2));
            c0.u(q2, "view_y", (int) motionEvent2.getY(action2));
            new h0("AdContainer.on_touch_began", this.J.I(), q2).e();
        } else if (action == 6) {
            int action3 = (motionEvent.getAction() & 65280) >> 8;
            c0.u(q2, "container_x", ((int) motionEvent2.getX(action3)) + this.f12922l);
            c0.u(q2, "container_y", ((int) motionEvent2.getY(action3)) + this.f12923m);
            c0.u(q2, "view_x", (int) motionEvent2.getX(action3));
            c0.u(q2, "view_y", (int) motionEvent2.getY(action3));
            if (!this.J.N()) {
                f2.v(T.s().get(this.G));
            }
            new h0("AdContainer.on_touch_ended", this.J.I(), q2).e();
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean r() {
        return this.P != null;
    }

    /* access modifiers changed from: package-private */
    public void t() {
        Context a2;
        f1 a3 = this.I.a();
        this.G = c0.E(a3, "ad_session_id");
        this.f12922l = c0.A(a3, "x");
        this.f12923m = c0.A(a3, "y");
        this.f12924n = c0.A(a3, "width");
        this.f12925o = c0.A(a3, "height");
        this.C = c0.t(a3, "enable_timer");
        this.E = c0.t(a3, "enable_progress");
        this.F = c0.E(a3, "filepath");
        this.f12927q = c0.A(a3, "video_width");
        this.f12928r = c0.A(a3, "video_height");
        this.f12917g = a.f().x0().U();
        new e0.a().c("Original video dimensions = ").a(this.f12927q).c("x").a(this.f12928r).d(e0.f13108c);
        setVisibility(4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f12924n, this.f12925o);
        layoutParams.setMargins(this.f12922l, this.f12923m, 0, 0);
        layoutParams.gravity = 0;
        this.J.addView(this, layoutParams);
        if (this.E && (a2 = a.a()) != null) {
            ProgressBar progressBar = new ProgressBar(a2);
            this.O = progressBar;
            c cVar = this.J;
            int i2 = (int) (this.f12917g * 100.0f);
            cVar.addView(progressBar, new FrameLayout.LayoutParams(i2, i2, 17));
        }
        this.P = new MediaPlayer();
        this.f12936z = false;
        try {
            if (!this.F.startsWith(UriUtil.HTTP_SCHEME)) {
                FileInputStream fileInputStream = new FileInputStream(this.F);
                this.H = fileInputStream;
                this.P.setDataSource(fileInputStream.getFD());
            } else {
                this.B = true;
                this.P.setDataSource(this.F);
            }
            this.P.setOnErrorListener(this);
            this.P.setOnPreparedListener(this);
            this.P.setOnCompletionListener(this);
            this.P.prepareAsync();
        } catch (IOException e2) {
            new e0.a().c("Failed to create/prepare MediaPlayer: ").c(e2.toString()).d(e0.f13113h);
            E();
        }
        this.J.E().add(a.b("VideoView.play", new a(), true));
        this.J.E().add(a.b("VideoView.set_bounds", new b(), true));
        this.J.E().add(a.b("VideoView.set_visible", new c(), true));
        this.J.E().add(a.b("VideoView.pause", new d(), true));
        this.J.E().add(a.b("VideoView.seek_to_time", new e(), true));
        this.J.E().add(a.b("VideoView.set_volume", new f(), true));
        this.J.G().add("VideoView.play");
        this.J.G().add("VideoView.set_bounds");
        this.J.G().add("VideoView.set_visible");
        this.J.G().add("VideoView.pause");
        this.J.G().add("VideoView.seek_to_time");
        this.J.G().add("VideoView.set_volume");
    }

    /* access modifiers changed from: package-private */
    public void y() {
        if (this.f12919i) {
            this.f12916f = (float) (360.0d / this.f12930t);
            this.f12921k.setColor(-3355444);
            this.f12921k.setShadowLayer((float) ((int) (this.f12917g * 2.0f)), 0.0f, 0.0f, -16777216);
            this.f12921k.setTextAlign(Paint.Align.CENTER);
            this.f12921k.setLinearText(true);
            this.f12921k.setTextSize(this.f12917g * 12.0f);
            this.f12920j.setStyle(Paint.Style.STROKE);
            float f2 = this.f12917g * 2.0f;
            if (f2 > 6.0f) {
                f2 = 6.0f;
            }
            if (f2 < 4.0f) {
                f2 = 4.0f;
            }
            this.f12920j.setStrokeWidth(f2);
            this.f12920j.setShadowLayer((float) ((int) (this.f12917g * 3.0f)), 0.0f, 0.0f, -16777216);
            this.f12920j.setColor(-3355444);
            Rect rect = new Rect();
            this.f12921k.getTextBounds("0123456789", 0, 9, rect);
            this.f12914d = (float) rect.height();
            Context a2 = a.a();
            if (a2 != null) {
                z0.A(new i(a2));
            }
            this.f12919i = false;
        }
        this.f12918h = (int) (this.f12930t - this.f12929s);
        float f3 = this.f12914d;
        float f4 = (float) ((int) f3);
        this.f12912b = f4;
        float f5 = (float) ((int) (3.0f * f3));
        this.f12913c = f5;
        float f6 = f3 / 2.0f;
        float f7 = f3 * 2.0f;
        this.M.set(f4 - f6, f5 - f7, f4 + f7, f5 + f6);
        this.f12915e = (float) (((double) this.f12916f) * (this.f12930t - this.f12929s));
    }
}
