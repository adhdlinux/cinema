package androidx.media3.datasource;

import android.net.Uri;
import android.util.Base64;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.google.common.base.Charsets;
import java.io.IOException;
import java.net.URLDecoder;

public final class DataSchemeDataSource extends BaseDataSource {

    /* renamed from: e  reason: collision with root package name */
    private DataSpec f4812e;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f4813f;

    /* renamed from: g  reason: collision with root package name */
    private int f4814g;

    /* renamed from: h  reason: collision with root package name */
    private int f4815h;

    public DataSchemeDataSource() {
        super(false);
    }

    public Uri b() {
        DataSpec dataSpec = this.f4812e;
        if (dataSpec != null) {
            return dataSpec.f4823a;
        }
        return null;
    }

    public void close() {
        if (this.f4813f != null) {
            this.f4813f = null;
            p();
        }
        this.f4812e = null;
    }

    public long i(DataSpec dataSpec) throws IOException {
        q(dataSpec);
        this.f4812e = dataSpec;
        Uri normalizeScheme = dataSpec.f4823a.normalizeScheme();
        String scheme = normalizeScheme.getScheme();
        boolean equals = "data".equals(scheme);
        Assertions.b(equals, "Unsupported scheme: " + scheme);
        String[] k12 = Util.k1(normalizeScheme.getSchemeSpecificPart(), ",");
        if (k12.length == 2) {
            String str = k12[1];
            if (k12[0].contains(";base64")) {
                try {
                    this.f4813f = Base64.decode(str, 0);
                } catch (IllegalArgumentException e2) {
                    throw ParserException.b("Error while parsing Base64 encoded string: " + str, e2);
                }
            } else {
                this.f4813f = Util.t0(URLDecoder.decode(str, Charsets.US_ASCII.name()));
            }
            long j2 = dataSpec.f4829g;
            byte[] bArr = this.f4813f;
            if (j2 <= ((long) bArr.length)) {
                int i2 = (int) j2;
                this.f4814g = i2;
                int length = bArr.length - i2;
                this.f4815h = length;
                long j3 = dataSpec.f4830h;
                if (j3 != -1) {
                    this.f4815h = (int) Math.min((long) length, j3);
                }
                r(dataSpec);
                long j4 = dataSpec.f4830h;
                if (j4 != -1) {
                    return j4;
                }
                return (long) this.f4815h;
            }
            this.f4813f = null;
            throw new DataSourceException(2008);
        }
        throw ParserException.b("Unexpected URI format: " + normalizeScheme, (Throwable) null);
    }

    public int read(byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        int i4 = this.f4815h;
        if (i4 == 0) {
            return -1;
        }
        int min = Math.min(i3, i4);
        System.arraycopy(Util.i(this.f4813f), this.f4814g, bArr, i2, min);
        this.f4814g += min;
        this.f4815h -= min;
        o(min);
        return min;
    }
}
