package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class IcyDataSource implements DataSource {

    /* renamed from: a  reason: collision with root package name */
    private final DataSource f25752a;

    /* renamed from: b  reason: collision with root package name */
    private final int f25753b;

    /* renamed from: c  reason: collision with root package name */
    private final Listener f25754c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f25755d;

    /* renamed from: e  reason: collision with root package name */
    private int f25756e;

    public interface Listener {
        void c(ParsableByteArray parsableByteArray);
    }

    public IcyDataSource(DataSource dataSource, int i2, Listener listener) {
        boolean z2;
        if (i2 > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        this.f25752a = dataSource;
        this.f25753b = i2;
        this.f25754c = listener;
        this.f25755d = new byte[1];
        this.f25756e = i2;
    }

    private boolean q() throws IOException {
        if (this.f25752a.read(this.f25755d, 0, 1) == -1) {
            return false;
        }
        int i2 = (this.f25755d[0] & 255) << 4;
        if (i2 == 0) {
            return true;
        }
        byte[] bArr = new byte[i2];
        int i3 = i2;
        int i4 = 0;
        while (i3 > 0) {
            int read = this.f25752a.read(bArr, i4, i3);
            if (read == -1) {
                return false;
            }
            i4 += read;
            i3 -= read;
        }
        while (i2 > 0 && bArr[i2 - 1] == 0) {
            i2--;
        }
        if (i2 > 0) {
            this.f25754c.c(new ParsableByteArray(bArr, i2));
        }
        return true;
    }

    public Uri b() {
        return this.f25752a.b();
    }

    public void close() {
        throw new UnsupportedOperationException();
    }

    public Map<String, List<String>> d() {
        return this.f25752a.d();
    }

    public long i(DataSpec dataSpec) {
        throw new UnsupportedOperationException();
    }

    public void p(TransferListener transferListener) {
        Assertions.e(transferListener);
        this.f25752a.p(transferListener);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (this.f25756e == 0) {
            if (!q()) {
                return -1;
            }
            this.f25756e = this.f25753b;
        }
        int read = this.f25752a.read(bArr, i2, Math.min(this.f25756e, i3));
        if (read != -1) {
            this.f25756e -= read;
        }
        return read;
    }
}
