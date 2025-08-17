package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class FileDataSource extends BaseDataSource {

    /* renamed from: e  reason: collision with root package name */
    private RandomAccessFile f28436e;

    /* renamed from: f  reason: collision with root package name */
    private Uri f28437f;

    /* renamed from: g  reason: collision with root package name */
    private long f28438g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f28439h;

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
        private TransferListener f28440a;

        /* renamed from: b */
        public FileDataSource a() {
            FileDataSource fileDataSource = new FileDataSource();
            TransferListener transferListener = this.f28440a;
            if (transferListener != null) {
                fileDataSource.p(transferListener);
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

    private static RandomAccessFile w(Uri uri) throws FileDataSourceException {
        int i2 = 2006;
        try {
            return new RandomAccessFile((String) Assertions.e(uri.getPath()), "r");
        } catch (FileNotFoundException e2) {
            if (!TextUtils.isEmpty(uri.getQuery()) || !TextUtils.isEmpty(uri.getFragment())) {
                throw new FileDataSourceException(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", new Object[]{uri.getPath(), uri.getQuery(), uri.getFragment()}), e2, GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION);
            }
            if (Util.f28808a < 21 || !Api21.b(e2.getCause())) {
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
        return this.f28437f;
    }

    public void close() throws FileDataSourceException {
        this.f28437f = null;
        try {
            RandomAccessFile randomAccessFile = this.f28436e;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            this.f28436e = null;
            if (this.f28439h) {
                this.f28439h = false;
                t();
            }
        } catch (IOException e2) {
            throw new FileDataSourceException(e2, 2000);
        } catch (Throwable th) {
            this.f28436e = null;
            if (this.f28439h) {
                this.f28439h = false;
                t();
            }
            throw th;
        }
    }

    public long i(DataSpec dataSpec) throws FileDataSourceException {
        Uri uri = dataSpec.f28339a;
        this.f28437f = uri;
        u(dataSpec);
        RandomAccessFile w2 = w(uri);
        this.f28436e = w2;
        try {
            w2.seek(dataSpec.f28345g);
            long j2 = dataSpec.f28346h;
            if (j2 == -1) {
                j2 = this.f28436e.length() - dataSpec.f28345g;
            }
            this.f28438g = j2;
            if (j2 >= 0) {
                this.f28439h = true;
                v(dataSpec);
                return this.f28438g;
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
        if (this.f28438g == 0) {
            return -1;
        }
        try {
            int read = ((RandomAccessFile) Util.j(this.f28436e)).read(bArr, i2, (int) Math.min(this.f28438g, (long) i3));
            if (read > 0) {
                this.f28438g -= (long) read;
                s(read);
            }
            return read;
        } catch (IOException e2) {
            throw new FileDataSourceException(e2, 2000);
        }
    }
}
