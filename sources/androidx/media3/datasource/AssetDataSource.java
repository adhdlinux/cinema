package androidx.media3.datasource;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class AssetDataSource extends BaseDataSource {

    /* renamed from: e  reason: collision with root package name */
    private final AssetManager f4797e;

    /* renamed from: f  reason: collision with root package name */
    private Uri f4798f;

    /* renamed from: g  reason: collision with root package name */
    private InputStream f4799g;

    /* renamed from: h  reason: collision with root package name */
    private long f4800h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4801i;

    public static final class AssetDataSourceException extends DataSourceException {
        public AssetDataSourceException(Throwable th, int i2) {
            super(th, i2);
        }
    }

    public AssetDataSource(Context context) {
        super(false);
        this.f4797e = context.getAssets();
    }

    public Uri b() {
        return this.f4798f;
    }

    public void close() throws AssetDataSourceException {
        this.f4798f = null;
        try {
            InputStream inputStream = this.f4799g;
            if (inputStream != null) {
                inputStream.close();
            }
            this.f4799g = null;
            if (this.f4801i) {
                this.f4801i = false;
                p();
            }
        } catch (IOException e2) {
            throw new AssetDataSourceException(e2, 2000);
        } catch (Throwable th) {
            this.f4799g = null;
            if (this.f4801i) {
                this.f4801i = false;
                p();
            }
            throw th;
        }
    }

    public long i(DataSpec dataSpec) throws AssetDataSourceException {
        int i2;
        try {
            Uri uri = dataSpec.f4823a;
            this.f4798f = uri;
            String str = (String) Assertions.f(uri.getPath());
            if (str.startsWith("/android_asset/")) {
                str = str.substring(15);
            } else if (str.startsWith("/")) {
                str = str.substring(1);
            }
            q(dataSpec);
            InputStream open = this.f4797e.open(str, 1);
            this.f4799g = open;
            if (open.skip(dataSpec.f4829g) >= dataSpec.f4829g) {
                long j2 = dataSpec.f4830h;
                if (j2 != -1) {
                    this.f4800h = j2;
                } else {
                    long available = (long) this.f4799g.available();
                    this.f4800h = available;
                    if (available == 2147483647L) {
                        this.f4800h = -1;
                    }
                }
                this.f4801i = true;
                r(dataSpec);
                return this.f4800h;
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
        long j2 = this.f4800h;
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
        int read = ((InputStream) Util.i(this.f4799g)).read(bArr, i2, i3);
        if (read == -1) {
            return -1;
        }
        long j3 = this.f4800h;
        if (j3 != -1) {
            this.f4800h = j3 - ((long) read);
        }
        o(read);
        return read;
    }
}
