package androidx.media3.datasource.cache;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSink;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.cache.Cache;
import com.facebook.common.time.Clock;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class CacheDataSink implements DataSink {

    /* renamed from: a  reason: collision with root package name */
    private final Cache f4928a;

    /* renamed from: b  reason: collision with root package name */
    private final long f4929b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4930c;

    /* renamed from: d  reason: collision with root package name */
    private DataSpec f4931d;

    /* renamed from: e  reason: collision with root package name */
    private long f4932e;

    /* renamed from: f  reason: collision with root package name */
    private File f4933f;

    /* renamed from: g  reason: collision with root package name */
    private OutputStream f4934g;

    /* renamed from: h  reason: collision with root package name */
    private long f4935h;

    /* renamed from: i  reason: collision with root package name */
    private long f4936i;

    /* renamed from: j  reason: collision with root package name */
    private ReusableBufferedOutputStream f4937j;

    public static final class CacheDataSinkException extends Cache.CacheException {
        public CacheDataSinkException(IOException iOException) {
            super((Throwable) iOException);
        }
    }

    public static final class Factory implements DataSink.Factory {

        /* renamed from: a  reason: collision with root package name */
        private Cache f4938a;

        /* renamed from: b  reason: collision with root package name */
        private long f4939b = 5242880;

        /* renamed from: c  reason: collision with root package name */
        private int f4940c = 20480;

        public DataSink a() {
            return new CacheDataSink((Cache) Assertions.f(this.f4938a), this.f4939b, this.f4940c);
        }

        public Factory b(Cache cache) {
            this.f4938a = cache;
            return this;
        }
    }

    public CacheDataSink(Cache cache, long j2, int i2) {
        boolean z2;
        if (j2 > 0 || j2 == -1) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.i(z2, "fragmentSize must be positive or C.LENGTH_UNSET.");
        int i3 = (j2 > -1 ? 1 : (j2 == -1 ? 0 : -1));
        if (i3 != 0 && j2 < PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) {
            Log.h("CacheDataSink", "fragmentSize is below the minimum recommended value of 2097152. This may cause poor cache performance.");
        }
        this.f4928a = (Cache) Assertions.f(cache);
        this.f4929b = i3 == 0 ? Clock.MAX_TIME : j2;
        this.f4930c = i2;
    }

    private void a() throws IOException {
        OutputStream outputStream = this.f4934g;
        if (outputStream != null) {
            try {
                outputStream.flush();
                Util.m(this.f4934g);
                this.f4934g = null;
                this.f4933f = null;
                this.f4928a.e((File) Util.i(this.f4933f), this.f4935h);
            } catch (Throwable th) {
                Util.m(this.f4934g);
                this.f4934g = null;
                this.f4933f = null;
                ((File) Util.i(this.f4933f)).delete();
                throw th;
            }
        }
    }

    private void b(DataSpec dataSpec) throws IOException {
        long j2 = dataSpec.f4830h;
        long j3 = -1;
        if (j2 != -1) {
            j3 = Math.min(j2 - this.f4936i, this.f4932e);
        }
        this.f4933f = this.f4928a.a((String) Util.i(dataSpec.f4831i), dataSpec.f4829g + this.f4936i, j3);
        FileOutputStream fileOutputStream = new FileOutputStream(this.f4933f);
        if (this.f4930c > 0) {
            ReusableBufferedOutputStream reusableBufferedOutputStream = this.f4937j;
            if (reusableBufferedOutputStream == null) {
                this.f4937j = new ReusableBufferedOutputStream(fileOutputStream, this.f4930c);
            } else {
                reusableBufferedOutputStream.a(fileOutputStream);
            }
            this.f4934g = this.f4937j;
        } else {
            this.f4934g = fileOutputStream;
        }
        this.f4935h = 0;
    }

    public void close() throws CacheDataSinkException {
        if (this.f4931d != null) {
            try {
                a();
            } catch (IOException e2) {
                throw new CacheDataSinkException(e2);
            }
        }
    }

    public void i(DataSpec dataSpec) throws CacheDataSinkException {
        long j2;
        Assertions.f(dataSpec.f4831i);
        if (dataSpec.f4830h != -1 || !dataSpec.d(2)) {
            this.f4931d = dataSpec;
            if (dataSpec.d(4)) {
                j2 = this.f4929b;
            } else {
                j2 = Clock.MAX_TIME;
            }
            this.f4932e = j2;
            this.f4936i = 0;
            try {
                b(dataSpec);
            } catch (IOException e2) {
                throw new CacheDataSinkException(e2);
            }
        } else {
            this.f4931d = null;
        }
    }

    public void write(byte[] bArr, int i2, int i3) throws CacheDataSinkException {
        DataSpec dataSpec = this.f4931d;
        if (dataSpec != null) {
            int i4 = 0;
            while (i4 < i3) {
                try {
                    if (this.f4935h == this.f4932e) {
                        a();
                        b(dataSpec);
                    }
                    int min = (int) Math.min((long) (i3 - i4), this.f4932e - this.f4935h);
                    ((OutputStream) Util.i(this.f4934g)).write(bArr, i2 + i4, min);
                    i4 += min;
                    long j2 = (long) min;
                    this.f4935h += j2;
                    this.f4936i += j2;
                } catch (IOException e2) {
                    throw new CacheDataSinkException(e2);
                }
            }
        }
    }
}
