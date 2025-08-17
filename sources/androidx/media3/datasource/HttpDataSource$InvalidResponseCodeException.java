package androidx.media3.datasource;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public final class HttpDataSource$InvalidResponseCodeException extends HttpDataSource$HttpDataSourceException {

    /* renamed from: e  reason: collision with root package name */
    public final int f4892e;

    /* renamed from: f  reason: collision with root package name */
    public final String f4893f;

    /* renamed from: g  reason: collision with root package name */
    public final Map<String, List<String>> f4894g;

    /* renamed from: h  reason: collision with root package name */
    public final byte[] f4895h;

    public HttpDataSource$InvalidResponseCodeException(int i2, String str, IOException iOException, Map<String, List<String>> map, DataSpec dataSpec, byte[] bArr) {
        super("Response code: " + i2, iOException, dataSpec, 2004, 1);
        this.f4892e = i2;
        this.f4893f = str;
        this.f4894g = map;
        this.f4895h = bArr;
    }
}
