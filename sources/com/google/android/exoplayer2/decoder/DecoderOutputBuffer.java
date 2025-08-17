package com.google.android.exoplayer2.decoder;

public abstract class DecoderOutputBuffer extends Buffer {

    /* renamed from: c  reason: collision with root package name */
    public long f23969c;

    /* renamed from: d  reason: collision with root package name */
    public int f23970d;

    public interface Owner<S extends DecoderOutputBuffer> {
        void a(S s2);
    }

    public abstract void p();
}
