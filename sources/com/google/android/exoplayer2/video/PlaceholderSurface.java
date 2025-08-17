package com.google.android.exoplayer2.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.EGLSurfaceTexture;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.util.Log;

public final class PlaceholderSurface extends Surface {

    /* renamed from: e  reason: collision with root package name */
    private static int f28901e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f28902f;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f28903b;

    /* renamed from: c  reason: collision with root package name */
    private final PlaceholderSurfaceThread f28904c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f28905d;

    private static class PlaceholderSurfaceThread extends HandlerThread implements Handler.Callback {

        /* renamed from: b  reason: collision with root package name */
        private EGLSurfaceTexture f28906b;

        /* renamed from: c  reason: collision with root package name */
        private Handler f28907c;

        /* renamed from: d  reason: collision with root package name */
        private Error f28908d;

        /* renamed from: e  reason: collision with root package name */
        private RuntimeException f28909e;

        /* renamed from: f  reason: collision with root package name */
        private PlaceholderSurface f28910f;

        public PlaceholderSurfaceThread() {
            super("ExoPlayer:PlaceholderSurface");
        }

        private void b(int i2) throws GlUtil.GlException {
            boolean z2;
            Assertions.e(this.f28906b);
            this.f28906b.h(i2);
            SurfaceTexture g2 = this.f28906b.g();
            if (i2 != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f28910f = new PlaceholderSurface(this, g2, z2);
        }

        private void d() {
            Assertions.e(this.f28906b);
            this.f28906b.i();
        }

        public PlaceholderSurface a(int i2) {
            boolean z2;
            start();
            this.f28907c = new Handler(getLooper(), this);
            this.f28906b = new EGLSurfaceTexture(this.f28907c);
            synchronized (this) {
                z2 = false;
                this.f28907c.obtainMessage(1, i2, 0).sendToTarget();
                while (this.f28910f == null && this.f28909e == null && this.f28908d == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z2 = true;
                    }
                }
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.f28909e;
            if (runtimeException == null) {
                Error error = this.f28908d;
                if (error == null) {
                    return (PlaceholderSurface) Assertions.e(this.f28910f);
                }
                throw error;
            }
            throw runtimeException;
        }

        public void c() {
            Assertions.e(this.f28907c);
            this.f28907c.sendEmptyMessage(2);
        }

        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                try {
                    b(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e2) {
                    Log.d("PlaceholderSurface", "Failed to initialize placeholder surface", e2);
                    this.f28909e = e2;
                    synchronized (this) {
                        notify();
                    }
                } catch (GlUtil.GlException e3) {
                    Log.d("PlaceholderSurface", "Failed to initialize placeholder surface", e3);
                    this.f28909e = new IllegalStateException(e3);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e4) {
                    try {
                        Log.d("PlaceholderSurface", "Failed to initialize placeholder surface", e4);
                        this.f28908d = e4;
                        synchronized (this) {
                            notify();
                        }
                    } catch (Throwable th) {
                        synchronized (this) {
                            notify();
                            throw th;
                        }
                    }
                }
                return true;
            } else if (i2 != 2) {
                return true;
            } else {
                try {
                    d();
                } catch (Throwable th2) {
                    quit();
                    throw th2;
                }
                quit();
                return true;
            }
        }
    }

    private static int b(Context context) {
        if (!GlUtil.h(context)) {
            return 0;
        }
        if (GlUtil.i()) {
            return 1;
        }
        return 2;
    }

    public static synchronized boolean c(Context context) {
        boolean z2;
        synchronized (PlaceholderSurface.class) {
            z2 = true;
            if (!f28902f) {
                f28901e = b(context);
                f28902f = true;
            }
            if (f28901e == 0) {
                z2 = false;
            }
        }
        return z2;
    }

    public static PlaceholderSurface d(Context context, boolean z2) {
        boolean z3;
        int i2 = 0;
        if (!z2 || c(context)) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assertions.g(z3);
        PlaceholderSurfaceThread placeholderSurfaceThread = new PlaceholderSurfaceThread();
        if (z2) {
            i2 = f28901e;
        }
        return placeholderSurfaceThread.a(i2);
    }

    public void release() {
        super.release();
        synchronized (this.f28904c) {
            if (!this.f28905d) {
                this.f28904c.c();
                this.f28905d = true;
            }
        }
    }

    private PlaceholderSurface(PlaceholderSurfaceThread placeholderSurfaceThread, SurfaceTexture surfaceTexture, boolean z2) {
        super(surfaceTexture);
        this.f28904c = placeholderSurfaceThread;
        this.f28903b = z2;
    }
}
