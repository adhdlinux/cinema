package androidx.media3.exoplayer.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.EGLSurfaceTexture;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;

public final class PlaceholderSurface extends Surface {

    /* renamed from: e  reason: collision with root package name */
    private static int f7681e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f7682f;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f7683b;

    /* renamed from: c  reason: collision with root package name */
    private final PlaceholderSurfaceThread f7684c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7685d;

    private static class PlaceholderSurfaceThread extends HandlerThread implements Handler.Callback {

        /* renamed from: b  reason: collision with root package name */
        private EGLSurfaceTexture f7686b;

        /* renamed from: c  reason: collision with root package name */
        private Handler f7687c;

        /* renamed from: d  reason: collision with root package name */
        private Error f7688d;

        /* renamed from: e  reason: collision with root package name */
        private RuntimeException f7689e;

        /* renamed from: f  reason: collision with root package name */
        private PlaceholderSurface f7690f;

        public PlaceholderSurfaceThread() {
            super("ExoPlayer:PlaceholderSurface");
        }

        private void b(int i2) throws GlUtil.GlException {
            boolean z2;
            Assertions.f(this.f7686b);
            this.f7686b.h(i2);
            SurfaceTexture g2 = this.f7686b.g();
            if (i2 != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f7690f = new PlaceholderSurface(this, g2, z2);
        }

        private void d() {
            Assertions.f(this.f7686b);
            this.f7686b.i();
        }

        public PlaceholderSurface a(int i2) {
            boolean z2;
            start();
            this.f7687c = new Handler(getLooper(), this);
            this.f7686b = new EGLSurfaceTexture(this.f7687c);
            synchronized (this) {
                z2 = false;
                this.f7687c.obtainMessage(1, i2, 0).sendToTarget();
                while (this.f7690f == null && this.f7689e == null && this.f7688d == null) {
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
            RuntimeException runtimeException = this.f7689e;
            if (runtimeException == null) {
                Error error = this.f7688d;
                if (error == null) {
                    return (PlaceholderSurface) Assertions.f(this.f7690f);
                }
                throw error;
            }
            throw runtimeException;
        }

        public void c() {
            Assertions.f(this.f7687c);
            this.f7687c.sendEmptyMessage(2);
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
                    this.f7689e = e2;
                    synchronized (this) {
                        notify();
                    }
                } catch (GlUtil.GlException e3) {
                    Log.d("PlaceholderSurface", "Failed to initialize placeholder surface", e3);
                    this.f7689e = new IllegalStateException(e3);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e4) {
                    try {
                        Log.d("PlaceholderSurface", "Failed to initialize placeholder surface", e4);
                        this.f7688d = e4;
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
        if (!GlUtil.i(context)) {
            return 0;
        }
        if (GlUtil.j()) {
            return 1;
        }
        return 2;
    }

    public static synchronized boolean c(Context context) {
        boolean z2;
        synchronized (PlaceholderSurface.class) {
            z2 = true;
            if (!f7682f) {
                f7681e = b(context);
                f7682f = true;
            }
            if (f7681e == 0) {
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
        Assertions.h(z3);
        PlaceholderSurfaceThread placeholderSurfaceThread = new PlaceholderSurfaceThread();
        if (z2) {
            i2 = f7681e;
        }
        return placeholderSurfaceThread.a(i2);
    }

    public void release() {
        super.release();
        synchronized (this.f7684c) {
            if (!this.f7685d) {
                this.f7684c.c();
                this.f7685d = true;
            }
        }
    }

    private PlaceholderSurface(PlaceholderSurfaceThread placeholderSurfaceThread, SurfaceTexture surfaceTexture, boolean z2) {
        super(surfaceTexture);
        this.f7684c = placeholderSurfaceThread;
        this.f7683b = z2;
    }
}
