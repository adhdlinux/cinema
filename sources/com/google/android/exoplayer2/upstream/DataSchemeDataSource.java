package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.util.Base64;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Charsets;
import java.io.IOException;
import java.net.URLDecoder;

public final class DataSchemeDataSource extends BaseDataSource {

    /* renamed from: e  reason: collision with root package name */
    private DataSpec f28328e;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f28329f;

    /* renamed from: g  reason: collision with root package name */
    private int f28330g;

    /* renamed from: h  reason: collision with root package name */
    private int f28331h;

    public DataSchemeDataSource() {
        super(false);
    }

    public Uri b() {
        DataSpec dataSpec = this.f28328e;
        if (dataSpec != null) {
            return dataSpec.f28339a;
        }
        return null;
    }

    public void close() {
        if (this.f28329f != null) {
            this.f28329f = null;
            t();
        }
        this.f28328e = null;
    }

    public long i(DataSpec dataSpec) throws IOException {
        u(dataSpec);
        this.f28328e = dataSpec;
        Uri uri = dataSpec.f28339a;
        String scheme = uri.getScheme();
        boolean equals = "data".equals(scheme);
        Assertions.b(equals, "Unsupported scheme: " + scheme);
        String[] W0 = Util.W0(uri.getSchemeSpecificPart(), ",");
        if (W0.length == 2) {
            String str = W0[1];
            if (W0[0].contains(";base64")) {
                try {
                    this.f28329f = Base64.decode(str, 0);
                } catch (IllegalArgumentException e2) {
                    throw ParserException.b("Error while parsing Base64 encoded string: " + str, e2);
                }
            } else {
                this.f28329f = Util.p0(URLDecoder.decode(str, Charsets.US_ASCII.name()));
            }
            long j2 = dataSpec.f28345g;
            byte[] bArr = this.f28329f;
            if (j2 <= ((long) bArr.length)) {
                int i2 = (int) j2;
                this.f28330g = i2;
                int length = bArr.length - i2;
                this.f28331h = length;
                long j3 = dataSpec.f28346h;
                if (j3 != -1) {
                    this.f28331h = (int) Math.min((long) length, j3);
                }
                v(dataSpec);
                long j4 = dataSpec.f28346h;
                if (j4 != -1) {
                    return j4;
                }
                return (long) this.f28331h;
            }
            this.f28329f = null;
            throw new DataSourceException(2008);
        }
        throw ParserException.b("Unexpected URI format: " + uri, (Throwable) null);
    }

    public int read(byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        int i4 = this.f28331h;
        if (i4 == 0) {
            return -1;
        }
        int min = Math.min(i3, i4);
        System.arraycopy(Util.j(this.f28329f), this.f28330g, bArr, i2, min);
        this.f28330g += min;
        this.f28331h -= min;
        s(min);
        return min;
    }
}
