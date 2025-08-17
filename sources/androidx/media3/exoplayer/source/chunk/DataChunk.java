package androidx.media3.exoplayer.source.chunk;

import androidx.media3.common.Format;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceUtil;
import androidx.media3.datasource.DataSpec;
import java.io.IOException;
import java.util.Arrays;
import okhttp3.internal.http2.Http2;

public abstract class DataChunk extends Chunk {

    /* renamed from: j  reason: collision with root package name */
    private byte[] f7262j;

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f7263k;

    public DataChunk(DataSource dataSource, DataSpec dataSpec, int i2, Format format, int i3, Object obj, byte[] bArr) {
        super(dataSource, dataSpec, i2, format, i3, obj, -9223372036854775807L, -9223372036854775807L);
        DataChunk dataChunk;
        byte[] bArr2;
        if (bArr == null) {
            bArr2 = Util.f4719f;
            dataChunk = this;
        } else {
            dataChunk = this;
            bArr2 = bArr;
        }
        dataChunk.f7262j = bArr2;
    }

    private void i(int i2) {
        byte[] bArr = this.f7262j;
        if (bArr.length < i2 + Http2.INITIAL_MAX_FRAME_SIZE) {
            this.f7262j = Arrays.copyOf(bArr, bArr.length + Http2.INITIAL_MAX_FRAME_SIZE);
        }
    }

    public final void a() throws IOException {
        try {
            this.f7225i.i(this.f7218b);
            int i2 = 0;
            int i3 = 0;
            while (i2 != -1 && !this.f7263k) {
                i(i3);
                i2 = this.f7225i.read(this.f7262j, i3, Http2.INITIAL_MAX_FRAME_SIZE);
                if (i2 != -1) {
                    i3 += i2;
                }
            }
            if (!this.f7263k) {
                g(this.f7262j, i3);
            }
        } finally {
            DataSourceUtil.a(this.f7225i);
        }
    }

    public final void b() {
        this.f7263k = true;
    }

    /* access modifiers changed from: protected */
    public abstract void g(byte[] bArr, int i2) throws IOException;

    public byte[] h() {
        return this.f7262j;
    }
}
