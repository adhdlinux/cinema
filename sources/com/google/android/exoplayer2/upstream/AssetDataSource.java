package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class AssetDataSource extends BaseDataSource {

    /* renamed from: e  reason: collision with root package name */
    private final AssetManager f28309e;

    /* renamed from: f  reason: collision with root package name */
    private Uri f28310f;

    /* renamed from: g  reason: collision with root package name */
    private InputStream f28311g;

    /* renamed from: h  reason: collision with root package name */
    private long f28312h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f28313i;

    public static final class AssetDataSourceException extends DataSourceException {
        public AssetDataSourceException(Throwable th, int i2) {
            super(th, i2);
        }
    }

    public AssetDataSource(Context context) {
        super(false);
        this.f28309e = context.getAssets();
    }

    public Uri b() {
        return this.f28310f;
    }

    public void close() throws AssetDataSourceException {
        this.f28310f = null;
        try {
            InputStream inputStream = this.f28311g;
            if (inputStream != null) {
                inputStream.close();
            }
            this.f28311g = null;
            if (this.f28313i) {
                this.f28313i = false;
                t();
            }
        } catch (IOException e2) {
            throw new AssetDataSourceException(e2, 2000);
        } catch (Throwable th) {
            this.f28311g = null;
            if (this.f28313i) {
                this.f28313i = false;
                t();
            }
            throw th;
        }
    }

    public long i(DataSpec dataSpec) throws AssetDataSourceException {
        int i2;
        try {
            Uri uri = dataSpec.f28339a;
            this.f28310f = uri;
            String str = (String) Assertions.e(uri.getPath());
            if (str.startsWith("/android_asset/")) {
                str = str.substring(15);
            } else if (str.startsWith("/")) {
                str = str.substring(1);
            }
            u(dataSpec);
            InputStream open = this.f28309e.open(str, 1);
            this.f28311g = open;
            if (open.skip(dataSpec.f28345g) >= dataSpec.f28345g) {
                long j2 = dataSpec.f28346h;
                if (j2 != -1) {
                    this.f28312h = j2;
                } else {
                    long available = (long) this.f28311g.available();
                    this.f28312h = available;
                    if (available == 2147483647L) {
                        this.f28312h = -1;
                    }
                }
                this.f28313i = true;
                v(dataSpec);
                return this.f28312h;
            }
            throw new AssetDataSourceException((Throwable) null, 2008);
        } catch (AssetDataSourceException e2) {
            throw e2;
        } catch (IOException e3) {
            if (e3 instanceof FileNotFoundException) {
                i2 = 2005;
            } else {
                i2 = 2000;
            }
            throw new AssetDataSourceException(e3, i2);
        }
    }

    public int read(byte[] bArr, int i2, int i3) throws AssetDataSourceException {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f28312h;
        if (j2 == 0) {
            return -1;
        }
        if (j2 != -1) {
            try {
                i3 = (int) Math.min(j2, (long) i3);
            } catch (IOException e2) {
                throw new AssetDataSourceException(e2, 2000);
            }
        }
        int read = ((InputStream) Util.j(this.f28311g)).read(bArr, i2, i3);
        if (read == -1) {
            return -1;
        }
        long j3 = this.f28312h;
        if (j3 != -1) {
            this.f28312h = j3 - ((long) read);
        }
        s(read);
        return read;
    }
}
