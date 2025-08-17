package androidx.media3.datasource;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class FileDataSource extends BaseDataSource {

    /* renamed from: e  reason: collision with root package name */
    private RandomAccessFile f4884e;

    /* renamed from: f  reason: collision with root package name */
    private Uri f4885f;

    /* renamed from: g  reason: collision with root package name */
    private long f4886g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4887h;

    private static final class Api21 {
        private Api21() {
        }

        /* access modifiers changed from: private */
        public static boolean b(Throwable th) {
            return (th instanceof ErrnoException) && ((ErrnoException) th).errno == OsConstants.EACCES;
        }
    }

    public static final class Factory implements DataSource.Factory {

        /* renamed from: a  reason: collision with root package name */
        private TransferListener f4888a;

        /* renamed from: c */
        public FileDataSource a() {
            FileDataSource fileDataSource = new FileDataSource();
            TransferListener transferListener = this.f4888a;
            if (transferListener != null) {
                fileDataSource.n(transferListener);
            }
            return fileDataSource;
        }
    }

    public static class FileDataSourceException extends DataSourceException {
        public FileDataSourceException(Throwable th, int i2) {
            super(th, i2);
        }

        public FileDataSourceException(String str, Throwable th, int i2) {
            super(str, th, i2);
        }
    }

    public FileDataSource() {
        super(false);
    }

    private static RandomAccessFile s(Uri uri) throws FileDataSourceException {
        int i2 = 2006;
        try {
            return new RandomAccessFile((String) Assertions.f(uri.getPath()), "r");
        } catch (FileNotFoundException e2) {
            if (!TextUtils.isEmpty(uri.getQuery()) || !TextUtils.isEmpty(uri.getFragment())) {
                throw new FileDataSourceException(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", new Object[]{uri.getPath(), uri.getQuery(), uri.getFragment()}), e2, GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION);
            }
            if (Util.f4714a < 21 || !Api21.b(e2.getCause())) {
                i2 = 2005;
            }
            throw new FileDataSourceException(e2, i2);
        } catch (SecurityException e3) {
            throw new FileDataSourceException(e3, 2006);
        } catch (RuntimeException e4) {
            throw new FileDataSourceException(e4, 2000);
        }
    }

    public Uri b() {
        return this.f4885f;
    }

    public void close() throws FileDataSourceException {
        this.f4885f = null;
        try {
            RandomAccessFile randomAccessFile = this.f4884e;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            this.f4884e = null;
            if (this.f4887h) {
                this.f4887h = false;
                p();
            }
        } catch (IOException e2) {
            throw new FileDataSourceException(e2, 2000);
        } catch (Throwable th) {
            this.f4884e = null;
            if (this.f4887h) {
                this.f4887h = false;
                p();
            }
            throw th;
        }
    }

    public long i(DataSpec dataSpec) throws FileDataSourceException {
        Uri uri = dataSpec.f4823a;
        this.f4885f = uri;
        q(dataSpec);
        RandomAccessFile s2 = s(uri);
        this.f4884e = s2;
        try {
            s2.seek(dataSpec.f4829g);
            long j2 = dataSpec.f4830h;
            if (j2 == -1) {
                j2 = this.f4884e.length() - dataSpec.f4829g;
            }
            this.f4886g = j2;
            if (j2 >= 0) {
                this.f4887h = true;
                r(dataSpec);
                return this.f4886g;
            }
            throw new FileDataSourceException((String) null, (Throwable) null, 2008);
        } catch (IOException e2) {
            throw new FileDataSourceException(e2, 2000);
        }
    }

    public int read(byte[] bArr, int i2, int i3) throws FileDataSourceException {
        if (i3 == 0) {
            return 0;
        }
        if (this.f4886g == 0) {
            return -1;
        }
        try {
            int read = ((RandomAccessFile) Util.i(this.f4884e)).read(bArr, i2, (int) Math.min(this.f4886g, (long) i3));
            if (read > 0) {
                this.f4886g -= (long) read;
                o(read);
            }
            return read;
        } catch (IOException e2) {
            throw new FileDataSourceException(e2, 2000);
        }
    }
}
