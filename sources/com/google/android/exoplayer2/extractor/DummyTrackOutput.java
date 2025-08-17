package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.protobuf.CodedOutputStream;
import java.io.EOFException;
import java.io.IOException;

public final class DummyTrackOutput implements TrackOutput {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f24201a = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];

    public int a(DataReader dataReader, int i2, boolean z2, int i3) throws IOException {
        int read = dataReader.read(this.f24201a, 0, Math.min(this.f24201a.length, i2));
        if (read != -1) {
            return read;
        }
        if (z2) {
            return -1;
        }
        throw new EOFException();
    }

    public /* synthetic */ int b(DataReader dataReader, int i2, boolean z2) {
        return f.a(this, dataReader, i2, z2);
    }

    public /* synthetic */ void c(ParsableByteArray parsableByteArray, int i2) {
        f.b(this, parsableByteArray, i2);
    }

    public void d(Format format) {
    }

    public void e(long j2, int i2, int i3, int i4, TrackOutput.CryptoData cryptoData) {
    }

    public void f(ParsableByteArray parsableByteArray, int i2, int i3) {
        parsableByteArray.V(i2);
    }
}
