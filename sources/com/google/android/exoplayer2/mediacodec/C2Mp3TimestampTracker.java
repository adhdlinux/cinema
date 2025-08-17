package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import java.nio.ByteBuffer;

final class C2Mp3TimestampTracker {

    /* renamed from: a  reason: collision with root package name */
    private long f25255a;

    /* renamed from: b  reason: collision with root package name */
    private long f25256b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f25257c;

    C2Mp3TimestampTracker() {
    }

    private long a(long j2) {
        return this.f25255a + Math.max(0, ((this.f25256b - 529) * 1000000) / j2);
    }

    public long b(Format format) {
        return a((long) format.A);
    }

    public void c() {
        this.f25255a = 0;
        this.f25256b = 0;
        this.f25257c = false;
    }

    public long d(Format format, DecoderInputBuffer decoderInputBuffer) {
        if (this.f25256b == 0) {
            this.f25255a = decoderInputBuffer.f23963f;
        }
        if (this.f25257c) {
            return decoderInputBuffer.f23963f;
        }
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.e(decoderInputBuffer.f23961d);
        byte b2 = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            b2 = (b2 << 8) | (byteBuffer.get(i2) & 255);
        }
        int m2 = MpegAudioUtil.m(b2);
        if (m2 == -1) {
            this.f25257c = true;
            this.f25256b = 0;
            this.f25255a = decoderInputBuffer.f23963f;
            Log.i("C2Mp3TimestampTracker", "MPEG audio header is invalid.");
            return decoderInputBuffer.f23963f;
        }
        long a2 = a((long) format.A);
        this.f25256b += (long) m2;
        return a2;
    }
}
