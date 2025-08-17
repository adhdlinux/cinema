package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.collection.CircularIntArray;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import java.util.ArrayDeque;

final class AsynchronousMediaCodecCallback extends MediaCodec.Callback {

    /* renamed from: a  reason: collision with root package name */
    private final Object f6657a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final HandlerThread f6658b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f6659c;

    /* renamed from: d  reason: collision with root package name */
    private final CircularIntArray f6660d;

    /* renamed from: e  reason: collision with root package name */
    private final CircularIntArray f6661e;

    /* renamed from: f  reason: collision with root package name */
    private final ArrayDeque<MediaCodec.BufferInfo> f6662f;

    /* renamed from: g  reason: collision with root package name */
    private final ArrayDeque<MediaFormat> f6663g;

    /* renamed from: h  reason: collision with root package name */
    private MediaFormat f6664h;

    /* renamed from: i  reason: collision with root package name */
    private MediaFormat f6665i;

    /* renamed from: j  reason: collision with root package name */
    private MediaCodec.CodecException f6666j;

    /* renamed from: k  reason: collision with root package name */
    private MediaCodec.CryptoException f6667k;

    /* renamed from: l  reason: collision with root package name */
    private long f6668l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f6669m;

    /* renamed from: n  reason: collision with root package name */
    private IllegalStateException f6670n;

    /* renamed from: o  reason: collision with root package name */
    private MediaCodecAdapter.OnBufferAvailableListener f6671o;

    AsynchronousMediaCodecCallback(HandlerThread handlerThread) {
        this.f6658b = handlerThread;
        this.f6660d = new CircularIntArray();
        this.f6661e = new CircularIntArray();
        this.f6662f = new ArrayDeque<>();
        this.f6663g = new ArrayDeque<>();
    }

    private void b(MediaFormat mediaFormat) {
        this.f6661e.a(-2);
        this.f6663g.add(mediaFormat);
    }

    private void f() {
        if (!this.f6663g.isEmpty()) {
            this.f6665i = this.f6663g.getLast();
        }
        this.f6660d.b();
        this.f6661e.b();
        this.f6662f.clear();
        this.f6663g.clear();
    }

    private boolean i() {
        return this.f6668l > 0 || this.f6669m;
    }

    private void j() {
        k();
        m();
        l();
    }

    private void k() {
        IllegalStateException illegalStateException = this.f6670n;
        if (illegalStateException != null) {
            this.f6670n = null;
            throw illegalStateException;
        }
    }

    private void l() {
        MediaCodec.CryptoException cryptoException = this.f6667k;
        if (cryptoException != null) {
            this.f6667k = null;
            throw cryptoException;
        }
    }

    private void m() {
        MediaCodec.CodecException codecException = this.f6666j;
        if (codecException != null) {
            this.f6666j = null;
            throw codecException;
        }
    }

    /* access modifiers changed from: private */
    public void n() {
        synchronized (this.f6657a) {
            if (!this.f6669m) {
                long j2 = this.f6668l - 1;
                this.f6668l = j2;
                if (j2 <= 0) {
                    if (j2 < 0) {
                        o(new IllegalStateException());
                    } else {
                        f();
                    }
                }
            }
        }
    }

    private void o(IllegalStateException illegalStateException) {
        synchronized (this.f6657a) {
            this.f6670n = illegalStateException;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int c() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f6657a
            monitor-enter(r0)
            r3.j()     // Catch:{ all -> 0x0020 }
            boolean r1 = r3.i()     // Catch:{ all -> 0x0020 }
            r2 = -1
            if (r1 == 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            return r2
        L_0x000f:
            androidx.collection.CircularIntArray r1 = r3.f6660d     // Catch:{ all -> 0x0020 }
            boolean r1 = r1.d()     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0018
            goto L_0x001e
        L_0x0018:
            androidx.collection.CircularIntArray r1 = r3.f6660d     // Catch:{ all -> 0x0020 }
            int r2 = r1.e()     // Catch:{ all -> 0x0020 }
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            return r2
        L_0x0020:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecCallback.c():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int d(android.media.MediaCodec.BufferInfo r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.f6657a
            monitor-enter(r0)
            r9.j()     // Catch:{ all -> 0x004a }
            boolean r1 = r9.i()     // Catch:{ all -> 0x004a }
            r2 = -1
            if (r1 == 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            return r2
        L_0x000f:
            androidx.collection.CircularIntArray r1 = r9.f6661e     // Catch:{ all -> 0x004a }
            boolean r1 = r1.d()     // Catch:{ all -> 0x004a }
            if (r1 == 0) goto L_0x0019
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            return r2
        L_0x0019:
            androidx.collection.CircularIntArray r1 = r9.f6661e     // Catch:{ all -> 0x004a }
            int r1 = r1.e()     // Catch:{ all -> 0x004a }
            if (r1 < 0) goto L_0x003b
            android.media.MediaFormat r2 = r9.f6664h     // Catch:{ all -> 0x004a }
            androidx.media3.common.util.Assertions.j(r2)     // Catch:{ all -> 0x004a }
            java.util.ArrayDeque<android.media.MediaCodec$BufferInfo> r2 = r9.f6662f     // Catch:{ all -> 0x004a }
            java.lang.Object r2 = r2.remove()     // Catch:{ all -> 0x004a }
            android.media.MediaCodec$BufferInfo r2 = (android.media.MediaCodec.BufferInfo) r2     // Catch:{ all -> 0x004a }
            int r4 = r2.offset     // Catch:{ all -> 0x004a }
            int r5 = r2.size     // Catch:{ all -> 0x004a }
            long r6 = r2.presentationTimeUs     // Catch:{ all -> 0x004a }
            int r8 = r2.flags     // Catch:{ all -> 0x004a }
            r3 = r10
            r3.set(r4, r5, r6, r8)     // Catch:{ all -> 0x004a }
            goto L_0x0048
        L_0x003b:
            r10 = -2
            if (r1 != r10) goto L_0x0048
            java.util.ArrayDeque<android.media.MediaFormat> r10 = r9.f6663g     // Catch:{ all -> 0x004a }
            java.lang.Object r10 = r10.remove()     // Catch:{ all -> 0x004a }
            android.media.MediaFormat r10 = (android.media.MediaFormat) r10     // Catch:{ all -> 0x004a }
            r9.f6664h = r10     // Catch:{ all -> 0x004a }
        L_0x0048:
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            return r1
        L_0x004a:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecCallback.d(android.media.MediaCodec$BufferInfo):int");
    }

    public void e() {
        synchronized (this.f6657a) {
            this.f6668l++;
            ((Handler) Util.i(this.f6659c)).post(new h(this));
        }
    }

    public MediaFormat g() {
        MediaFormat mediaFormat;
        synchronized (this.f6657a) {
            mediaFormat = this.f6664h;
            if (mediaFormat == null) {
                throw new IllegalStateException();
            }
        }
        return mediaFormat;
    }

    public void h(MediaCodec mediaCodec) {
        boolean z2;
        if (this.f6659c == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        this.f6658b.start();
        Handler handler = new Handler(this.f6658b.getLooper());
        mediaCodec.setCallback(this, handler);
        this.f6659c = handler;
    }

    public void onCryptoError(MediaCodec mediaCodec, MediaCodec.CryptoException cryptoException) {
        synchronized (this.f6657a) {
            this.f6667k = cryptoException;
        }
    }

    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.f6657a) {
            this.f6666j = codecException;
        }
    }

    public void onInputBufferAvailable(MediaCodec mediaCodec, int i2) {
        synchronized (this.f6657a) {
            this.f6660d.a(i2);
            MediaCodecAdapter.OnBufferAvailableListener onBufferAvailableListener = this.f6671o;
            if (onBufferAvailableListener != null) {
                onBufferAvailableListener.a();
            }
        }
    }

    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i2, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f6657a) {
            MediaFormat mediaFormat = this.f6665i;
            if (mediaFormat != null) {
                b(mediaFormat);
                this.f6665i = null;
            }
            this.f6661e.a(i2);
            this.f6662f.add(bufferInfo);
            MediaCodecAdapter.OnBufferAvailableListener onBufferAvailableListener = this.f6671o;
            if (onBufferAvailableListener != null) {
                onBufferAvailableListener.b();
            }
        }
    }

    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.f6657a) {
            b(mediaFormat);
            this.f6665i = null;
        }
    }

    public void p(MediaCodecAdapter.OnBufferAvailableListener onBufferAvailableListener) {
        synchronized (this.f6657a) {
            this.f6671o = onBufferAvailableListener;
        }
    }

    public void q() {
        synchronized (this.f6657a) {
            this.f6669m = true;
            this.f6658b.quit();
            f();
        }
    }
}
