package com.google.android.exoplayer2.upstream.cache;

import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class CacheDataSink implements DataSink {

    /* renamed from: a  reason: collision with root package name */
    private final Cache f28533a;

    /* renamed from: b  reason: collision with root package name */
    private final long f28534b;

    /* renamed from: c  reason: collision with root package name */
    private final int f28535c;

    /* renamed from: d  reason: collision with root package name */
    private DataSpec f28536d;

    /* renamed from: e  reason: collision with root package name */
    private long f28537e;

    /* renamed from: f  reason: collision with root package name */
    private File f28538f;

    /* renamed from: g  reason: collision with root package name */
    private OutputStream f28539g;

    /* renamed from: h  reason: collision with root package name */
    private long f28540h;

    /* renamed from: i  reason: collision with root package name */
    private long f28541i;

    /* renamed from: j  reason: collision with root package name */
    private ReusableBufferedOutputStream f28542j;

    public static final class CacheDataSinkException extends Cache.CacheException {
        public CacheDataSinkException(IOException iOException) {
            super((Throwable) iOException);
        }
    }

    public static final class Factory implements DataSink.Factory {

        /* renamed from: a  reason: collision with root package name */
        private Cache f28543a;

        /* renamed from: b  reason: collision with root package name */
        private long f28544b = 5242880;

        /* renamed from: c  reason: collision with root package name */
        private int f28545c = 20480;

        public DataSink a() {
            return new CacheDataSink((Cache) Assertions.e(this.f28543a), this.f28544b, this.f28545c);
        }

        public Factory b(Cache cache) {
            this.f28543a = cache;
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
        Assertions.h(z2, "fragmentSize must be positive or C.LENGTH_UNSET.");
        int i3 = (j2 > -1 ? 1 : (j2 == -1 ? 0 : -1));
        if (i3 != 0 && j2 < PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) {
            Log.i("CacheDataSink", "fragmentSize is below the minimum recommended value of 2097152. This may cause poor cache performance.");
        }
        this.f28533a = (Cache) Assertions.e(cache);
        this.f28534b = i3 == 0 ? Clock.MAX_TIME : j2;
        this.f28535c = i2;
    }

    private void a() throws IOException {
        OutputStream outputStream = this.f28539g;
        if (outputStream != null) {
            try {
                outputStream.flush();
                Util.n(this.f28539g);
                this.f28539g = null;
                this.f28538f = null;
                this.f28533a.e((File) Util.j(this.f28538f), this.f28540h);
            } catch (Throwable th) {
                Util.n(this.f28539g);
                this.f28539g = null;
                this.f28538f = null;
                ((File) Util.j(this.f28538f)).delete();
                throw th;
            }
        }
    }

    private void b(DataSpec dataSpec) throws IOException {
        long j2 = dataSpec.f28346h;
        long j3 = -1;
        if (j2 != -1) {
            j3 = Math.min(j2 - this.f28541i, this.f28537e);
        }
        this.f28538f = this.f28533a.a((String) Util.j(dataSpec.f28347i), dataSpec.f28345g + this.f28541i, j3);
        FileOutputStream fileOutputStream = new FileOutputStream(this.f28538f);
        if (this.f28535c > 0) {
            ReusableBufferedOutputStream reusableBufferedOutputStream = this.f28542j;
            if (reusableBufferedOutputStream == null) {
                this.f28542j = new ReusableBufferedOutputStream(fileOutputStream, this.f28535c);
            } else {
                reusableBufferedOutputStream.a(fileOutputStream);
            }
            this.f28539g = this.f28542j;
        } else {
            this.f28539g = fileOutputStream;
        }
        this.f28540h = 0;
    }

    public void close() throws CacheDataSinkException {
        if (this.f28536d != null) {
            try {
                a();
            } catch (IOException e2) {
                throw new CacheDataSinkException(e2);
            }
        }
    }

    public void i(DataSpec dataSpec) throws CacheDataSinkException {
        long j2;
        Assertions.e(dataSpec.f28347i);
        if (dataSpec.f28346h != -1 || !dataSpec.d(2)) {
            this.f28536d = dataSpec;
            if (dataSpec.d(4)) {
                j2 = this.f28534b;
            } else {
                j2 = Clock.MAX_TIME;
            }
            this.f28537e = j2;
            this.f28541i = 0;
            try {
                b(dataSpec);
            } catch (IOException e2) {
                throw new CacheDataSinkException(e2);
            }
        } else {
            this.f28536d = null;
        }
    }

    public void write(byte[] bArr, int i2, int i3) throws CacheDataSinkException {
        DataSpec dataSpec = this.f28536d;
        if (dataSpec != null) {
            int i4 = 0;
            while (i4 < i3) {
                try {
                    if (this.f28540h == this.f28537e) {
                        a();
                        b(dataSpec);
                    }
                    int min = (int) Math.min((long) (i3 - i4), this.f28537e - this.f28540h);
                    ((OutputStream) Util.j(this.f28539g)).write(bArr, i2 + i4, min);
                    i4 += min;
                    long j2 = (long) min;
                    this.f28540h += j2;
                    this.f28541i += j2;
                } catch (IOException e2) {
                    throw new CacheDataSinkException(e2);
                }
            }
        }
    }
}
