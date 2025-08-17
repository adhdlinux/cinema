package androidx.media3.exoplayer.video;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.Surface;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import com.facebook.react.uimanager.ViewProps;

public final class VideoFrameReleaseHelper {

    /* renamed from: a  reason: collision with root package name */
    private final FixedFrameRateEstimator f7722a = new FixedFrameRateEstimator();

    /* renamed from: b  reason: collision with root package name */
    private final DisplayHelper f7723b;

    /* renamed from: c  reason: collision with root package name */
    private final VSyncSampler f7724c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7725d;

    /* renamed from: e  reason: collision with root package name */
    private Surface f7726e;

    /* renamed from: f  reason: collision with root package name */
    private float f7727f;

    /* renamed from: g  reason: collision with root package name */
    private float f7728g;

    /* renamed from: h  reason: collision with root package name */
    private float f7729h;

    /* renamed from: i  reason: collision with root package name */
    private float f7730i;

    /* renamed from: j  reason: collision with root package name */
    private int f7731j;

    /* renamed from: k  reason: collision with root package name */
    private long f7732k;

    /* renamed from: l  reason: collision with root package name */
    private long f7733l;

    /* renamed from: m  reason: collision with root package name */
    private long f7734m;

    /* renamed from: n  reason: collision with root package name */
    private long f7735n;

    /* renamed from: o  reason: collision with root package name */
    private long f7736o;

    /* renamed from: p  reason: collision with root package name */
    private long f7737p;

    /* renamed from: q  reason: collision with root package name */
    private long f7738q;

    private static final class Api30 {
        private Api30() {
        }

        public static void a(Surface surface, float f2) {
            int i2;
            if (f2 == 0.0f) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            try {
                surface.setFrameRate(f2, i2);
            } catch (IllegalStateException e2) {
                Log.d("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e2);
            }
        }
    }

    private final class DisplayHelper implements DisplayManager.DisplayListener {

        /* renamed from: a  reason: collision with root package name */
        private final DisplayManager f7739a;

        public DisplayHelper(DisplayManager displayManager) {
            this.f7739a = displayManager;
        }

        private Display a() {
            return this.f7739a.getDisplay(0);
        }

        public void b() {
            this.f7739a.registerDisplayListener(this, Util.A());
            VideoFrameReleaseHelper.this.p(a());
        }

        public void c() {
            this.f7739a.unregisterDisplayListener(this);
        }

        public void onDisplayAdded(int i2) {
        }

        public void onDisplayChanged(int i2) {
            if (i2 == 0) {
                VideoFrameReleaseHelper.this.p(a());
            }
        }

        public void onDisplayRemoved(int i2) {
        }
    }

    private static final class VSyncSampler implements Choreographer.FrameCallback, Handler.Callback {

        /* renamed from: g  reason: collision with root package name */
        private static final VSyncSampler f7741g = new VSyncSampler();

        /* renamed from: b  reason: collision with root package name */
        public volatile long f7742b = -9223372036854775807L;

        /* renamed from: c  reason: collision with root package name */
        private final Handler f7743c;

        /* renamed from: d  reason: collision with root package name */
        private final HandlerThread f7744d;

        /* renamed from: e  reason: collision with root package name */
        private Choreographer f7745e;

        /* renamed from: f  reason: collision with root package name */
        private int f7746f;

        private VSyncSampler() {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            this.f7744d = handlerThread;
            handlerThread.start();
            Handler z2 = Util.z(handlerThread.getLooper(), this);
            this.f7743c = z2;
            z2.sendEmptyMessage(1);
        }

        private void b() {
            Choreographer choreographer = this.f7745e;
            if (choreographer != null) {
                int i2 = this.f7746f + 1;
                this.f7746f = i2;
                if (i2 == 1) {
                    choreographer.postFrameCallback(this);
                }
            }
        }

        private void c() {
            try {
                this.f7745e = Choreographer.getInstance();
            } catch (RuntimeException e2) {
                Log.i("VideoFrameReleaseHelper", "Vsync sampling disabled due to platform error", e2);
            }
        }

        public static VSyncSampler d() {
            return f7741g;
        }

        private void f() {
            Choreographer choreographer = this.f7745e;
            if (choreographer != null) {
                int i2 = this.f7746f - 1;
                this.f7746f = i2;
                if (i2 == 0) {
                    choreographer.removeFrameCallback(this);
                    this.f7742b = -9223372036854775807L;
                }
            }
        }

        public void a() {
            this.f7743c.sendEmptyMessage(2);
        }

        public void doFrame(long j2) {
            this.f7742b = j2;
            ((Choreographer) Assertions.f(this.f7745e)).postFrameCallbackDelayed(this, 500);
        }

        public void e() {
            this.f7743c.sendEmptyMessage(3);
        }

        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                c();
                return true;
            } else if (i2 == 2) {
                b();
                return true;
            } else if (i2 != 3) {
                return false;
            } else {
                f();
                return true;
            }
        }
    }

    public VideoFrameReleaseHelper(Context context) {
        VSyncSampler vSyncSampler;
        DisplayHelper f2 = f(context);
        this.f7723b = f2;
        if (f2 != null) {
            vSyncSampler = VSyncSampler.d();
        } else {
            vSyncSampler = null;
        }
        this.f7724c = vSyncSampler;
        this.f7732k = -9223372036854775807L;
        this.f7733l = -9223372036854775807L;
        this.f7727f = -1.0f;
        this.f7730i = 1.0f;
        this.f7731j = 0;
    }

    private static boolean c(long j2, long j3) {
        return Math.abs(j2 - j3) <= 20000000;
    }

    private void d() {
        Surface surface;
        if (Util.f4714a >= 30 && (surface = this.f7726e) != null && this.f7731j != Integer.MIN_VALUE && this.f7729h != 0.0f) {
            this.f7729h = 0.0f;
            Api30.a(surface, 0.0f);
        }
    }

    private static long e(long j2, long j3, long j4) {
        long j5;
        long j6 = j3 + (((j2 - j3) / j4) * j4);
        if (j2 <= j6) {
            j5 = j6 - j4;
        } else {
            long j7 = j6;
            j6 = j4 + j6;
            j5 = j7;
        }
        return j6 - j2 < j2 - j5 ? j6 : j5;
    }

    private DisplayHelper f(Context context) {
        DisplayManager displayManager;
        if (context == null || (displayManager = (DisplayManager) context.getSystemService(ViewProps.DISPLAY)) == null) {
            return null;
        }
        return new DisplayHelper(displayManager);
    }

    private void n() {
        this.f7734m = 0;
        this.f7737p = -1;
        this.f7735n = -1;
    }

    /* access modifiers changed from: private */
    public void p(Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / ((double) display.getRefreshRate()));
            this.f7732k = refreshRate;
            this.f7733l = (refreshRate * 80) / 100;
            return;
        }
        Log.h("VideoFrameReleaseHelper", "Unable to query display refresh rate");
        this.f7732k = -9223372036854775807L;
        this.f7733l = -9223372036854775807L;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005c, code lost:
        if (java.lang.Math.abs(r0 - r8.f7728g) >= r1) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006a, code lost:
        if (r8.f7722a.c() >= 30) goto L_0x006c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void q() {
        /*
            r8 = this;
            int r0 = androidx.media3.common.util.Util.f4714a
            r1 = 30
            if (r0 < r1) goto L_0x0073
            android.view.Surface r0 = r8.f7726e
            if (r0 != 0) goto L_0x000c
            goto L_0x0073
        L_0x000c:
            androidx.media3.exoplayer.video.FixedFrameRateEstimator r0 = r8.f7722a
            boolean r0 = r0.e()
            if (r0 == 0) goto L_0x001b
            androidx.media3.exoplayer.video.FixedFrameRateEstimator r0 = r8.f7722a
            float r0 = r0.b()
            goto L_0x001d
        L_0x001b:
            float r0 = r8.f7727f
        L_0x001d:
            float r2 = r8.f7728g
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 != 0) goto L_0x0024
            return
        L_0x0024:
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            r4 = 0
            r5 = 1
            int r6 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r6 == 0) goto L_0x0061
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0061
            androidx.media3.exoplayer.video.FixedFrameRateEstimator r1 = r8.f7722a
            boolean r1 = r1.e()
            if (r1 == 0) goto L_0x0049
            androidx.media3.exoplayer.video.FixedFrameRateEstimator r1 = r8.f7722a
            long r1 = r1.d()
            r6 = 5000000000(0x12a05f200, double:2.470328229E-314)
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 < 0) goto L_0x0049
            r1 = 1
            goto L_0x004a
        L_0x0049:
            r1 = 0
        L_0x004a:
            if (r1 == 0) goto L_0x0050
            r1 = 1017370378(0x3ca3d70a, float:0.02)
            goto L_0x0052
        L_0x0050:
            r1 = 1065353216(0x3f800000, float:1.0)
        L_0x0052:
            float r2 = r8.f7728g
            float r2 = r0 - r2
            float r2 = java.lang.Math.abs(r2)
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 < 0) goto L_0x005f
            goto L_0x006c
        L_0x005f:
            r5 = 0
            goto L_0x006c
        L_0x0061:
            if (r6 == 0) goto L_0x0064
            goto L_0x006c
        L_0x0064:
            androidx.media3.exoplayer.video.FixedFrameRateEstimator r2 = r8.f7722a
            int r2 = r2.c()
            if (r2 < r1) goto L_0x005f
        L_0x006c:
            if (r5 == 0) goto L_0x0073
            r8.f7728g = r0
            r8.r(r4)
        L_0x0073:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.VideoFrameReleaseHelper.q():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void r(boolean r4) {
        /*
            r3 = this;
            int r0 = androidx.media3.common.util.Util.f4714a
            r1 = 30
            if (r0 < r1) goto L_0x0031
            android.view.Surface r0 = r3.f7726e
            if (r0 == 0) goto L_0x0031
            int r1 = r3.f7731j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 != r2) goto L_0x0011
            goto L_0x0031
        L_0x0011:
            boolean r1 = r3.f7725d
            if (r1 == 0) goto L_0x0022
            float r1 = r3.f7728g
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0022
            float r2 = r3.f7730i
            float r1 = r1 * r2
            goto L_0x0023
        L_0x0022:
            r1 = 0
        L_0x0023:
            if (r4 != 0) goto L_0x002c
            float r4 = r3.f7729h
            int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r4 != 0) goto L_0x002c
            return
        L_0x002c:
            r3.f7729h = r1
            androidx.media3.exoplayer.video.VideoFrameReleaseHelper.Api30.a(r0, r1)
        L_0x0031:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.VideoFrameReleaseHelper.r(boolean):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0058 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long b(long r11) {
        /*
            r10 = this;
            long r0 = r10.f7737p
            r2 = -1
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0030
            androidx.media3.exoplayer.video.FixedFrameRateEstimator r0 = r10.f7722a
            boolean r0 = r0.e()
            if (r0 == 0) goto L_0x0030
            androidx.media3.exoplayer.video.FixedFrameRateEstimator r0 = r10.f7722a
            long r0 = r0.a()
            long r2 = r10.f7738q
            long r4 = r10.f7734m
            long r6 = r10.f7737p
            long r4 = r4 - r6
            long r0 = r0 * r4
            float r0 = (float) r0
            float r1 = r10.f7730i
            float r0 = r0 / r1
            long r0 = (long) r0
            long r2 = r2 + r0
            boolean r0 = c(r11, r2)
            if (r0 == 0) goto L_0x002d
            r4 = r2
            goto L_0x0031
        L_0x002d:
            r10.n()
        L_0x0030:
            r4 = r11
        L_0x0031:
            long r11 = r10.f7734m
            r10.f7735n = r11
            r10.f7736o = r4
            androidx.media3.exoplayer.video.VideoFrameReleaseHelper$VSyncSampler r11 = r10.f7724c
            if (r11 == 0) goto L_0x0058
            long r0 = r10.f7732k
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r12 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r12 != 0) goto L_0x0047
            goto L_0x0058
        L_0x0047:
            long r6 = r11.f7742b
            int r11 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r11 != 0) goto L_0x004e
            return r4
        L_0x004e:
            long r8 = r10.f7732k
            long r11 = e(r4, r6, r8)
            long r0 = r10.f7733l
            long r11 = r11 - r0
            return r11
        L_0x0058:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.VideoFrameReleaseHelper.b(long):long");
    }

    public void g(float f2) {
        this.f7727f = f2;
        this.f7722a.g();
        q();
    }

    public void h(long j2) {
        long j3 = this.f7735n;
        if (j3 != -1) {
            this.f7737p = j3;
            this.f7738q = this.f7736o;
        }
        this.f7734m++;
        this.f7722a.f(j2 * 1000);
        q();
    }

    public void i(float f2) {
        this.f7730i = f2;
        n();
        r(false);
    }

    public void j() {
        n();
    }

    public void k() {
        this.f7725d = true;
        n();
        if (this.f7723b != null) {
            ((VSyncSampler) Assertions.f(this.f7724c)).a();
            this.f7723b.b();
        }
        r(false);
    }

    public void l() {
        this.f7725d = false;
        DisplayHelper displayHelper = this.f7723b;
        if (displayHelper != null) {
            displayHelper.c();
            ((VSyncSampler) Assertions.f(this.f7724c)).e();
        }
        d();
    }

    public void m(Surface surface) {
        if (surface instanceof PlaceholderSurface) {
            surface = null;
        }
        if (this.f7726e != surface) {
            d();
            this.f7726e = surface;
            r(true);
        }
    }

    public void o(int i2) {
        if (this.f7731j != i2) {
            this.f7731j = i2;
            r(true);
        }
    }
}
