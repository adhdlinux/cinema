package androidx.media3.extractor;

import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.TrackOutput;
import com.google.protobuf.CodedOutputStream;
import java.io.EOFException;
import java.io.IOException;

public final class DiscardingTrackOutput implements TrackOutput {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f7994a = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];

    public void a(ParsableByteArray parsableByteArray, int i2, int i3) {
        parsableByteArray.V(i2);
    }

    public /* synthetic */ void b(ParsableByteArray parsableByteArray, int i2) {
        g.b(this, parsableByteArray, i2);
    }

    public void c(Format format) {
    }

    public /* synthetic */ int d(DataReader dataReader, int i2, boolean z2) {
        return g.a(this, dataReader, i2, z2);
    }

    public int e(DataReader dataReader, int i2, boolean z2, int i3) throws IOException {
        int read = dataReader.read(this.f7994a, 0, Math.min(this.f7994a.length, i2));
        if (read != -1) {
            return read;
        }
        if (z2) {
            return -1;
        }
        throw new EOFException();
    }

    public void f(long j2, int i2, int i3, int i4, TrackOutput.CryptoData cryptoData) {
    }
}
