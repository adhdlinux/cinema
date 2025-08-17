package com.google.android.exoplayer2.upstream;

import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

public class HttpDataSource$HttpDataSourceException extends DataSourceException {

    /* renamed from: c  reason: collision with root package name */
    public final DataSpec f28441c;

    /* renamed from: d  reason: collision with root package name */
    public final int f28442d;

    public HttpDataSource$HttpDataSourceException(DataSpec dataSpec, int i2, int i3) {
        super(b(i2, i3));
        this.f28441c = dataSpec;
        this.f28442d = i3;
    }

    private static int b(int i2, int i3) {
        if (i2 == 2000 && i3 == 1) {
            return 2001;
        }
        return i2;
    }

    public static HttpDataSource$HttpDataSourceException c(IOException iOException, DataSpec dataSpec, int i2) {
        int i3;
        String message = iOException.getMessage();
        if (iOException instanceof SocketTimeoutException) {
            i3 = 2002;
        } else if (iOException instanceof InterruptedIOException) {
            i3 = GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION;
        } else if (message == null || !Ascii.e(message).matches("cleartext.*not permitted.*")) {
            i3 = 2001;
        } else {
            i3 = 2007;
        }
        if (i3 == 2007) {
            return new HttpDataSource$CleartextNotPermittedException(iOException, dataSpec);
        }
        return new HttpDataSource$HttpDataSourceException(iOException, dataSpec, i3, i2);
    }

    public HttpDataSource$HttpDataSourceException(String str, DataSpec dataSpec, int i2, int i3) {
        super(str, b(i2, i3));
        this.f28441c = dataSpec;
        this.f28442d = i3;
    }

    public HttpDataSource$HttpDataSourceException(IOException iOException, DataSpec dataSpec, int i2, int i3) {
        super((Throwable) iOException, b(i2, i3));
        this.f28441c = dataSpec;
        this.f28442d = i3;
    }

    public HttpDataSource$HttpDataSourceException(String str, IOException iOException, DataSpec dataSpec, int i2, int i3) {
        super(str, iOException, b(i2, i3));
        this.f28441c = dataSpec;
        this.f28442d = i3;
    }
}
