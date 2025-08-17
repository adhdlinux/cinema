package com.google.android.exoplayer2.video;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import w0.b;

public final class VideoFrameReleaseHelper {

    /* renamed from: a  reason: collision with root package name */
    private final FixedFrameRateEstimator f28928a = new FixedFrameRateEstimator();

    /* renamed from: b  reason: collision with root package name */
    private final DisplayHelper f28929b;

    /* renamed from: c  reason: collision with root package name */
    private final VSyncSampler f28930c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f28931d;

    /* renamed from: e  reason: collision with root package name */
    private Surface f28932e;

    /* renamed from: f  reason: collision with root package name */
    private float f28933f;

    /* renamed from: g  reason: collision with root package name */
    private float f28934g;

    /* renamed from: h  reason: collision with root package name */
    private float f28935h;

    /* renamed from: i  reason: collision with root package name */
    private float f28936i;

    /* renamed from: j  reason: collision with root package name */
    private int f28937j;

    /* renamed from: k  reason: collision with root package name */
    private long f28938k;

    /* renamed from: l  reason: collision with root package name */
    private long f28939l;

    /* renamed from: m  reason: collision with root package name */
    private long f28940m;

    /* renamed from: n  reason: collision with root package name */
    private long f28941n;

    /* renamed from: o  reason: collision with root package name */
    private long f28942o;

    /* renamed from: p  reason: collision with root package name */
    private long f28943p;

    /* renamed from: q  reason: collision with root package name */
    private long f28944q;

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

    private interface DisplayHelper {

        public interface Listener {
            void a(Display display);
        }

        void a(Listener listener);

        void b();
    }

    private static final class DisplayHelperV16 implements DisplayHelper {

        /* renamed from: a  reason: collision with root package name */
        private final WindowManager f28945a;

        private DisplayHelperV16(WindowManager windowManager) {
            this.f28945a = windowManager;
        }

        public static DisplayHelper c(Context context) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                return new DisplayHelperV16(windowManager);
            }
            return null;
        }

        public void a(DisplayHelper.Listener listener) {
            listener.a(this.f28945a.getDefaultDisplay());
        }

        public void b() {
        }
    }

    private static final class DisplayHelperV17 implements DisplayHelper, DisplayManager.DisplayListener {

        /* renamed from: a  reason: collision with root package name */
        private final DisplayManager f28946a;

        /* renamed from: b  reason: collision with root package name */
        private DisplayHelper.Listener f28947b;

        private DisplayHelperV17(DisplayManager displayManager) {
            this.f28946a = displayManager;
        }

        private Display c() {
            return this.f28946a.getDisplay(0);
        }

        public static DisplayHelper d(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService(ViewProps.DISPLAY);
            if (displayManager != null) {
                return new DisplayHelperV17(displayManager);
            }
            return null;
        }

        public void a(DisplayHelper.Listener listener) {
            this.f28947b = listener;
            this.f28946a.registerDisplayListener(this, Util.w());
            listener.a(c());
        }

        public void b() {
            this.f28946a.unregisterDisplayListener(this);
            this.f28947b = null;
        }

        public void onDisplayAdded(int i2) {
        }

        public void onDisplayChanged(int i2) {
            DisplayHelper.Listener listener = this.f28947b;
            if (listener != null && i2 == 0) {
                listener.a(c());
            }
        }

        public void onDisplayRemoved(int i2) {
        }
    }

    private static final class VSyncSampler implements Choreographer.FrameCallback, Handler.Callback {

        /* renamed from: g  reason: collision with root package name */
        private static final VSyncSampler f28948g = new VSyncSampler();

        /* renamed from: b  reason: collision with root package name */
        public volatile long f28949b = -9223372036854775807L;

        /* renamed from: c  reason: collision with root package name */
        private final Handler f28950c;

        /* renamed from: d  reason: collision with root package name */
        private final HandlerThread f28951d;

        /* renamed from: e  reason: collision with root package name */
        private Choreographer f28952e;

        /* renamed from: f  reason: collision with root package name */
        private int f28953f;

        private VSyncSampler() {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            this.f28951d = handlerThread;
            handlerThread.start();
            Handler v2 = Util.v(handlerThread.getLooper(), this);
            this.f28950c = v2;
            v2.sendEmptyMessage(0);
        }

        private void b() {
            Choreographer choreographer = this.f28952e;
            if (choreographer != null) {
                int i2 = this.f28953f + 1;
                this.f28953f = i2;
                if (i2 == 1) {
                    choreographer.postFrameCallback(this);
                }
            }
        }

        private void c() {
            try {
                this.f28952e = Choreographer.getInstance();
            } catch (RuntimeException e2) {
                Log.j("VideoFrameReleaseHelper", "Vsync sampling disabled due to platform error", e2);
            }
        }

        public static VSyncSampler d() {
            return f28948g;
        }

        private void f() {
            Choreographer choreographer = this.f28952e;
            if (choreographer != null) {
                int i2 = this.f28953f - 1;
                this.f28953f = i2;
                if (i2 == 0) {
                    choreographer.removeFrameCallback(this);
                    this.f28949b = -9223372036854775807L;
                }
            }
        }

        public void a() {
            this.f28950c.sendEmptyMessage(1);
        }

        public void doFrame(long j2) {
            this.f28949b = j2;
            ((Choreographer) Assertions.e(this.f28952e)).postFrameCallbackDelayed(this, 500);
        }

        public void e() {
            this.f28950c.sendEmptyMessage(2);
        }

        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                c();
                return true;
            } else if (i2 == 1) {
                b();
                return true;
            } else if (i2 != 2) {
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
        this.f28929b = f2;
        if (f2 != null) {
            vSyncSampler = VSyncSampler.d();
        } else {
            vSyncSampler = null;
        }
        this.f28930c = vSyncSampler;
        this.f28938k = -9223372036854775807L;
        this.f28939l = -9223372036854775807L;
        this.f28933f = -1.0f;
        this.f28936i = 1.0f;
        this.f28937j = 0;
    }

    private static boolean c(long j2, long j3) {
        return Math.abs(j2 - j3) <= 20000000;
    }

    private void d() {
        Surface surface;
        if (Util.f28808a >= 30 && (surface = this.f28932e) != null && this.f28937j != Integer.MIN_VALUE && this.f28935h != 0.0f) {
            this.f28935h = 0.0f;
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

    private static DisplayHelper f(Context context) {
        DisplayHelper displayHelper = null;
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        if (Util.f28808a >= 17) {
            displayHelper = DisplayHelperV17.d(applicationContext);
        }
        if (displayHelper == null) {
            return DisplayHelperV16.c(applicationContext);
        }
        return displayHelper;
    }

    private void n() {
        this.f28940m = 0;
        this.f28943p = -1;
        this.f28941n = -1;
    }

    /* access modifiers changed from: private */
    public void p(Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / ((double) display.getRefreshRate()));
            this.f28938k = refreshRate;
            this.f28939l = (refreshRate * 80) / 100;
            return;
        }
        Log.i("VideoFrameReleaseHelper", "Unable to query display refresh rate");
        this.f28938k = -9223372036854775807L;
        this.f28939l = -9223372036854775807L;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005c, code lost:
        if (java.lang.Math.abs(r0 - r8.f28934g) >= r1) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006a, code lost:
        if (r8.f28928a.c() >= 30) goto L_0x006c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void q() {
        /*
            r8 = this;
            int r0 = com.google.android.exoplayer2.util.Util.f28808a
            r1 = 30
            if (r0 < r1) goto L_0x0073
            android.view.Surface r0 = r8.f28932e
            if (r0 != 0) goto L_0x000c
            goto L_0x0073
        L_0x000c:
            com.google.android.exoplayer2.video.FixedFrameRateEstimator r0 = r8.f28928a
            boolean r0 = r0.e()
            if (r0 == 0) goto L_0x001b
            com.google.android.exoplayer2.video.FixedFrameRateEstimator r0 = r8.f28928a
            float r0 = r0.b()
            goto L_0x001d
        L_0x001b:
            float r0 = r8.f28933f
        L_0x001d:
            float r2 = r8.f28934g
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
            com.google.android.exoplayer2.video.FixedFrameRateEstimator r1 = r8.f28928a
            boolean r1 = r1.e()
            if (r1 == 0) goto L_0x0049
            com.google.android.exoplayer2.video.FixedFrameRateEstimator r1 = r8.f28928a
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
            float r2 = r8.f28934g
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
            com.google.android.exoplayer2.video.FixedFrameRateEstimator r2 = r8.f28928a
            int r2 = r2.c()
            if (r2 < r1) goto L_0x005f
        L_0x006c:
            if (r5 == 0) goto L_0x0073
            r8.f28934g = r0
            r8.r(r4)
        L_0x0073:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.VideoFrameReleaseHelper.q():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void r(boolean r4) {
        /*
            r3 = this;
            int r0 = com.google.android.exoplayer2.util.Util.f28808a
            r1 = 30
            if (r0 < r1) goto L_0x0031
            android.view.Surface r0 = r3.f28932e
            if (r0 == 0) goto L_0x0031
            int r1 = r3.f28937j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 != r2) goto L_0x0011
            goto L_0x0031
        L_0x0011:
            boolean r1 = r3.f28931d
            if (r1 == 0) goto L_0x0022
            float r1 = r3.f28934g
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0022
            float r2 = r3.f28936i
            float r1 = r1 * r2
            goto L_0x0023
        L_0x0022:
            r1 = 0
        L_0x0023:
            if (r4 != 0) goto L_0x002c
            float r4 = r3.f28935h
            int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r4 != 0) goto L_0x002c
            return
        L_0x002c:
            r3.f28935h = r1
            com.google.android.exoplayer2.video.VideoFrameReleaseHelper.Api30.a(r0, r1)
        L_0x0031:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.VideoFrameReleaseHelper.r(boolean):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0058 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long b(long r11) {
        /*
            r10 = this;
            long r0 = r10.f28943p
            r2 = -1
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0030
            com.google.android.exoplayer2.video.FixedFrameRateEstimator r0 = r10.f28928a
            boolean r0 = r0.e()
            if (r0 == 0) goto L_0x0030
            com.google.android.exoplayer2.video.FixedFrameRateEstimator r0 = r10.f28928a
            long r0 = r0.a()
            long r2 = r10.f28944q
            long r4 = r10.f28940m
            long r6 = r10.f28943p
            long r4 = r4 - r6
            long r0 = r0 * r4
            float r0 = (float) r0
            float r1 = r10.f28936i
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
            long r11 = r10.f28940m
            r10.f28941n = r11
            r10.f28942o = r4
            com.google.android.exoplayer2.video.VideoFrameReleaseHelper$VSyncSampler r11 = r10.f28930c
            if (r11 == 0) goto L_0x0058
            long r0 = r10.f28938k
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r12 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r12 != 0) goto L_0x0047
            goto L_0x0058
        L_0x0047:
            long r6 = r11.f28949b
            int r11 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r11 != 0) goto L_0x004e
            return r4
        L_0x004e:
            long r8 = r10.f28938k
            long r11 = e(r4, r6, r8)
            long r0 = r10.f28939l
            long r11 = r11 - r0
            return r11
        L_0x0058:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.VideoFrameReleaseHelper.b(long):long");
    }

    public void g(float f2) {
        this.f28933f = f2;
        this.f28928a.g();
        q();
    }

    public void h(long j2) {
        long j3 = this.f28941n;
        if (j3 != -1) {
            this.f28943p = j3;
            this.f28944q = this.f28942o;
        }
        this.f28940m++;
        this.f28928a.f(j2 * 1000);
        q();
    }

    public void i(float f2) {
        this.f28936i = f2;
        n();
        r(false);
    }

    public void j() {
        n();
    }

    public void k() {
        this.f28931d = true;
        n();
        if (this.f28929b != null) {
            ((VSyncSampler) Assertions.e(this.f28930c)).a();
            this.f28929b.a(new b(this));
        }
        r(false);
    }

    public void l() {
        this.f28931d = false;
        DisplayHelper displayHelper = this.f28929b;
        if (displayHelper != null) {
            displayHelper.b();
            ((VSyncSampler) Assertions.e(this.f28930c)).e();
        }
        d();
    }

    public void m(Surface surface) {
        if (surface instanceof PlaceholderSurface) {
            surface = null;
        }
        if (this.f28932e != surface) {
            d();
            this.f28932e = surface;
            r(true);
        }
    }

    public void o(int i2) {
        if (this.f28937j != i2) {
            this.f28937j = i2;
            r(true);
        }
    }
}
