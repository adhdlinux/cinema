package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceUtil;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Arrays;
import okhttp3.internal.http2.Http2;

public abstract class DataChunk extends Chunk {

    /* renamed from: j  reason: collision with root package name */
    private byte[] f26123j;

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f26124k;

    public DataChunk(DataSource dataSource, DataSpec dataSpec, int i2, Format format, int i3, Object obj, byte[] bArr) {
        super(dataSource, dataSpec, i2, format, i3, obj, -9223372036854775807L, -9223372036854775807L);
        DataChunk dataChunk;
        byte[] bArr2;
        if (bArr == null) {
            bArr2 = Util.f28813f;
            dataChunk = this;
        } else {
            dataChunk = this;
            bArr2 = bArr;
        }
        dataChunk.f26123j = bArr2;
    }

    private void i(int i2) {
        byte[] bArr = this.f26123j;
        if (bArr.length < i2 + Http2.INITIAL_MAX_FRAME_SIZE) {
            this.f26123j = Arrays.copyOf(bArr, bArr.length + Http2.INITIAL_MAX_FRAME_SIZE);
        }
    }

    public final void a() throws IOException {
        try {
            this.f26086i.i(this.f26079b);
            int i2 = 0;
            int i3 = 0;
            while (i2 != -1 && !this.f26124k) {
                i(i3);
                i2 = this.f26086i.read(this.f26123j, i3, Http2.INITIAL_MAX_FRAME_SIZE);
                if (i2 != -1) {
                    i3 += i2;
                }
            }
            if (!this.f26124k) {
                g(this.f26123j, i3);
            }
        } finally {
            DataSourceUtil.a(this.f26086i);
        }
    }

    public final void b() {
        this.f26124k = true;
    }

    /* access modifiers changed from: protected */
    public abstract void g(byte[] bArr, int i2) throws IOException;

    public byte[] h() {
        return this.f26123j;
    }
}
