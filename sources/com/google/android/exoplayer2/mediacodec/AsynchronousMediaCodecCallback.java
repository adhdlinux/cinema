package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayDeque;

final class AsynchronousMediaCodecCallback extends MediaCodec.Callback {

    /* renamed from: a  reason: collision with root package name */
    private final Object f25239a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final HandlerThread f25240b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f25241c;

    /* renamed from: d  reason: collision with root package name */
    private final IntArrayQueue f25242d;

    /* renamed from: e  reason: collision with root package name */
    private final IntArrayQueue f25243e;

    /* renamed from: f  reason: collision with root package name */
    private final ArrayDeque<MediaCodec.BufferInfo> f25244f;

    /* renamed from: g  reason: collision with root package name */
    private final ArrayDeque<MediaFormat> f25245g;

    /* renamed from: h  reason: collision with root package name */
    private MediaFormat f25246h;

    /* renamed from: i  reason: collision with root package name */
    private MediaFormat f25247i;

    /* renamed from: j  reason: collision with root package name */
    private MediaCodec.CodecException f25248j;

    /* renamed from: k  reason: collision with root package name */
    private long f25249k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f25250l;

    /* renamed from: m  reason: collision with root package name */
    private IllegalStateException f25251m;

    AsynchronousMediaCodecCallback(HandlerThread handlerThread) {
        this.f25240b = handlerThread;
        this.f25242d = new IntArrayQueue();
        this.f25243e = new IntArrayQueue();
        this.f25244f = new ArrayDeque<>();
        this.f25245g = new ArrayDeque<>();
    }

    private void b(MediaFormat mediaFormat) {
        this.f25243e.a(-2);
        this.f25245g.add(mediaFormat);
    }

    private void f() {
        if (!this.f25245g.isEmpty()) {
            this.f25247i = this.f25245g.getLast();
        }
        this.f25242d.b();
        this.f25243e.b();
        this.f25244f.clear();
        this.f25245g.clear();
    }

    private boolean i() {
        return this.f25249k > 0 || this.f25250l;
    }

    private void j() {
        k();
        l();
    }

    private void k() {
        IllegalStateException illegalStateException = this.f25251m;
        if (illegalStateException != null) {
            this.f25251m = null;
            throw illegalStateException;
        }
    }

    private void l() {
        MediaCodec.CodecException codecException = this.f25248j;
        if (codecException != null) {
            this.f25248j = null;
            throw codecException;
        }
    }

    /* access modifiers changed from: private */
    public void m() {
        synchronized (this.f25239a) {
            if (!this.f25250l) {
                long j2 = this.f25249k - 1;
                this.f25249k = j2;
                if (j2 <= 0) {
                    if (j2 < 0) {
                        n(new IllegalStateException());
                    } else {
                        f();
                    }
                }
            }
        }
    }

    private void n(IllegalStateException illegalStateException) {
        synchronized (this.f25239a) {
            this.f25251m = illegalStateException;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int c() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f25239a
            monitor-enter(r0)
            boolean r1 = r3.i()     // Catch:{ all -> 0x0020 }
            r2 = -1
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            return r2
        L_0x000c:
            r3.j()     // Catch:{ all -> 0x0020 }
            com.google.android.exoplayer2.mediacodec.IntArrayQueue r1 = r3.f25242d     // Catch:{ all -> 0x0020 }
            boolean r1 = r1.d()     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0018
            goto L_0x001e
        L_0x0018:
            com.google.android.exoplayer2.mediacodec.IntArrayQueue r1 = r3.f25242d     // Catch:{ all -> 0x0020 }
            int r2 = r1.e()     // Catch:{ all -> 0x0020 }
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            return r2
        L_0x0020:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecCallback.c():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int d(android.media.MediaCodec.BufferInfo r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.f25239a
            monitor-enter(r0)
            boolean r1 = r9.i()     // Catch:{ all -> 0x004a }
            r2 = -1
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            return r2
        L_0x000c:
            r9.j()     // Catch:{ all -> 0x004a }
            com.google.android.exoplayer2.mediacodec.IntArrayQueue r1 = r9.f25243e     // Catch:{ all -> 0x004a }
            boolean r1 = r1.d()     // Catch:{ all -> 0x004a }
            if (r1 == 0) goto L_0x0019
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            return r2
        L_0x0019:
            com.google.android.exoplayer2.mediacodec.IntArrayQueue r1 = r9.f25243e     // Catch:{ all -> 0x004a }
            int r1 = r1.e()     // Catch:{ all -> 0x004a }
            if (r1 < 0) goto L_0x003b
            android.media.MediaFormat r2 = r9.f25246h     // Catch:{ all -> 0x004a }
            com.google.android.exoplayer2.util.Assertions.i(r2)     // Catch:{ all -> 0x004a }
            java.util.ArrayDeque<android.media.MediaCodec$BufferInfo> r2 = r9.f25244f     // Catch:{ all -> 0x004a }
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
            java.util.ArrayDeque<android.media.MediaFormat> r10 = r9.f25245g     // Catch:{ all -> 0x004a }
            java.lang.Object r10 = r10.remove()     // Catch:{ all -> 0x004a }
            android.media.MediaFormat r10 = (android.media.MediaFormat) r10     // Catch:{ all -> 0x004a }
            r9.f25246h = r10     // Catch:{ all -> 0x004a }
        L_0x0048:
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            return r1
        L_0x004a:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004a }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecCallback.d(android.media.MediaCodec$BufferInfo):int");
    }

    public void e() {
        synchronized (this.f25239a) {
            this.f25249k++;
            ((Handler) Util.j(this.f25241c)).post(new d(this));
        }
    }

    public MediaFormat g() {
        MediaFormat mediaFormat;
        synchronized (this.f25239a) {
            mediaFormat = this.f25246h;
            if (mediaFormat == null) {
                throw new IllegalStateException();
            }
        }
        return mediaFormat;
    }

    public void h(MediaCodec mediaCodec) {
        boolean z2;
        if (this.f25241c == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        this.f25240b.start();
        Handler handler = new Handler(this.f25240b.getLooper());
        mediaCodec.setCallback(this, handler);
        this.f25241c = handler;
    }

    public void o() {
        synchronized (this.f25239a) {
            this.f25250l = true;
            this.f25240b.quit();
            f();
        }
    }

    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.f25239a) {
            this.f25248j = codecException;
        }
    }

    public void onInputBufferAvailable(MediaCodec mediaCodec, int i2) {
        synchronized (this.f25239a) {
            this.f25242d.a(i2);
        }
    }

    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i2, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f25239a) {
            MediaFormat mediaFormat = this.f25247i;
            if (mediaFormat != null) {
                b(mediaFormat);
                this.f25247i = null;
            }
            this.f25243e.a(i2);
            this.f25244f.add(bufferInfo);
        }
    }

    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.f25239a) {
            b(mediaFormat);
            this.f25247i = null;
        }
    }
}
