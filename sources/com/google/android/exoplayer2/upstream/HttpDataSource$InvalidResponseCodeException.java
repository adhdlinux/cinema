package com.google.android.exoplayer2.upstream;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public final class HttpDataSource$InvalidResponseCodeException extends HttpDataSource$HttpDataSourceException {

    /* renamed from: e  reason: collision with root package name */
    public final int f28444e;

    /* renamed from: f  reason: collision with root package name */
    public final String f28445f;

    /* renamed from: g  reason: collision with root package name */
    public final Map<String, List<String>> f28446g;

    /* renamed from: h  reason: collision with root package name */
    public final byte[] f28447h;

    public HttpDataSource$InvalidResponseCodeException(int i2, String str, IOException iOException, Map<String, List<String>> map, DataSpec dataSpec, byte[] bArr) {
        super("Response code: " + i2, iOException, dataSpec, 2004, 1);
        this.f28444e = i2;
        this.f28445f = str;
        this.f28446g = map;
        this.f28447h = bArr;
    }
}
