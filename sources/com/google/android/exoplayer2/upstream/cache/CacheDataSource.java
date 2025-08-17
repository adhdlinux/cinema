package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
import com.applovin.mediation.MaxErrorCode;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.PlaceholderDataSource;
import com.google.android.exoplayer2.upstream.PriorityDataSource;
import com.google.android.exoplayer2.upstream.TeeDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Util;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import v0.c;

public final class CacheDataSource implements DataSource {

    /* renamed from: a  reason: collision with root package name */
    private final Cache f28546a;

    /* renamed from: b  reason: collision with root package name */
    private final DataSource f28547b;

    /* renamed from: c  reason: collision with root package name */
    private final DataSource f28548c;

    /* renamed from: d  reason: collision with root package name */
    private final DataSource f28549d;

    /* renamed from: e  reason: collision with root package name */
    private final CacheKeyFactory f28550e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f28551f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f28552g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f28553h;

    /* renamed from: i  reason: collision with root package name */
    private Uri f28554i;

    /* renamed from: j  reason: collision with root package name */
    private DataSpec f28555j;

    /* renamed from: k  reason: collision with root package name */
    private DataSpec f28556k;

    /* renamed from: l  reason: collision with root package name */
    private DataSource f28557l;

    /* renamed from: m  reason: collision with root package name */
    private long f28558m;

    /* renamed from: n  reason: collision with root package name */
    private long f28559n;

    /* renamed from: o  reason: collision with root package name */
    private long f28560o;

    /* renamed from: p  reason: collision with root package name */
    private CacheSpan f28561p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f28562q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f28563r;

    /* renamed from: s  reason: collision with root package name */
    private long f28564s;

    /* renamed from: t  reason: collision with root package name */
    private long f28565t;

    public interface EventListener {
    }

    public static final class Factory implements DataSource.Factory {

        /* renamed from: a  reason: collision with root package name */
        private Cache f28566a;

        /* renamed from: b  reason: collision with root package name */
        private DataSource.Factory f28567b = new FileDataSource.Factory();

        /* renamed from: c  reason: collision with root package name */
        private DataSink.Factory f28568c;

        /* renamed from: d  reason: collision with root package name */
        private CacheKeyFactory f28569d = CacheKeyFactory.f28580a;

        /* renamed from: e  reason: collision with root package name */
        private boolean f28570e;

        /* renamed from: f  reason: collision with root package name */
        private DataSource.Factory f28571f;

        /* renamed from: g  reason: collision with root package name */
        private PriorityTaskManager f28572g;

        /* renamed from: h  reason: collision with root package name */
        private int f28573h;

        /* renamed from: i  reason: collision with root package name */
        private int f28574i;

        private CacheDataSource e(DataSource dataSource, int i2, int i3) {
            DataSink dataSink;
            Cache cache = (Cache) Assertions.e(this.f28566a);
            if (this.f28570e || dataSource == null) {
                dataSink = null;
            } else {
                DataSink.Factory factory = this.f28568c;
                if (factory != null) {
                    dataSink = factory.a();
                } else {
                    dataSink = new CacheDataSink.Factory().b(cache).a();
                }
            }
            return new CacheDataSource(cache, dataSource, this.f28567b.a(), dataSink, this.f28569d, i2, this.f28572g, i3, (EventListener) null);
        }

        /* renamed from: b */
        public CacheDataSource a() {
            DataSource dataSource;
            DataSource.Factory factory = this.f28571f;
            if (factory != null) {
                dataSource = factory.a();
            } else {
                dataSource = null;
            }
            return e(dataSource, this.f28574i, this.f28573h);
        }

        public CacheDataSource c() {
            DataSource dataSource;
            DataSource.Factory factory = this.f28571f;
            if (factory != null) {
                dataSource = factory.a();
            } else {
                dataSource = null;
            }
            return e(dataSource, this.f28574i | 1, MaxErrorCode.NETWORK_ERROR);
        }

        public CacheDataSource d() {
            return e((DataSource) null, this.f28574i | 1, MaxErrorCode.NETWORK_ERROR);
        }

        public Cache f() {
            return this.f28566a;
        }

        public CacheKeyFactory g() {
            return this.f28569d;
        }

        public PriorityTaskManager h() {
            return this.f28572g;
        }

        public Factory i(Cache cache) {
            this.f28566a = cache;
            return this;
        }

        public Factory j(DataSink.Factory factory) {
            boolean z2;
            this.f28568c = factory;
            if (factory == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f28570e = z2;
            return this;
        }

        public Factory k(DataSource.Factory factory) {
            this.f28571f = factory;
            return this;
        }
    }

    private void A() {
    }

    private void B(int i2) {
    }

    private void C(DataSpec dataSpec, boolean z2) throws IOException {
        CacheSpan cacheSpan;
        DataSpec dataSpec2;
        DataSource dataSource;
        long j2;
        long j3;
        DataSpec dataSpec3 = dataSpec;
        String str = (String) Util.j(dataSpec3.f28347i);
        Uri uri = null;
        if (this.f28563r) {
            cacheSpan = null;
        } else if (this.f28551f) {
            try {
                cacheSpan = this.f28546a.d(str, this.f28559n, this.f28560o);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            cacheSpan = this.f28546a.c(str, this.f28559n, this.f28560o);
        }
        if (cacheSpan == null) {
            dataSource = this.f28549d;
            dataSpec2 = dataSpec.a().h(this.f28559n).g(this.f28560o).a();
        } else if (cacheSpan.f28584e) {
            Uri fromFile = Uri.fromFile((File) Util.j(cacheSpan.f28585f));
            long j4 = cacheSpan.f28582c;
            long j5 = this.f28559n - j4;
            long j6 = cacheSpan.f28583d - j5;
            long j7 = this.f28560o;
            if (j7 != -1) {
                j6 = Math.min(j6, j7);
            }
            dataSpec2 = dataSpec.a().i(fromFile).k(j4).h(j5).g(j6).a();
            dataSource = this.f28547b;
        } else {
            if (cacheSpan.c()) {
                j3 = this.f28560o;
            } else {
                j3 = cacheSpan.f28583d;
                long j8 = this.f28560o;
                if (j8 != -1) {
                    j3 = Math.min(j3, j8);
                }
            }
            dataSpec2 = dataSpec.a().h(this.f28559n).g(j3).a();
            dataSource = this.f28548c;
            if (dataSource == null) {
                dataSource = this.f28549d;
                this.f28546a.i(cacheSpan);
                cacheSpan = null;
            }
        }
        if (this.f28563r || dataSource != this.f28549d) {
            j2 = Clock.MAX_TIME;
        } else {
            j2 = this.f28559n + 102400;
        }
        this.f28565t = j2;
        if (z2) {
            Assertions.g(w());
            if (dataSource != this.f28549d) {
                try {
                    q();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    if (((CacheSpan) Util.j(cacheSpan)).b()) {
                        this.f28546a.i(cacheSpan);
                    }
                    throw th2;
                }
            } else {
                return;
            }
        }
        if (cacheSpan != null && cacheSpan.b()) {
            this.f28561p = cacheSpan;
        }
        this.f28557l = dataSource;
        this.f28556k = dataSpec2;
        this.f28558m = 0;
        long i2 = dataSource.i(dataSpec2);
        ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
        if (dataSpec2.f28346h == -1 && i2 != -1) {
            this.f28560o = i2;
            ContentMetadataMutations.g(contentMetadataMutations, this.f28559n + i2);
        }
        if (y()) {
            Uri b2 = dataSource.b();
            this.f28554i = b2;
            if (!dataSpec3.f28339a.equals(b2)) {
                uri = this.f28554i;
            }
            ContentMetadataMutations.h(contentMetadataMutations, uri);
        }
        if (z()) {
            this.f28546a.f(str, contentMetadataMutations);
        }
    }

    private void D(String str) throws IOException {
        this.f28560o = 0;
        if (z()) {
            ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
            ContentMetadataMutations.g(contentMetadataMutations, this.f28559n);
            this.f28546a.f(str, contentMetadataMutations);
        }
    }

    private int E(DataSpec dataSpec) {
        if (this.f28552g && this.f28562q) {
            return 0;
        }
        if (!this.f28553h || dataSpec.f28346h != -1) {
            return -1;
        }
        return 1;
    }

    private void q() throws IOException {
        DataSource dataSource = this.f28557l;
        if (dataSource != null) {
            try {
                dataSource.close();
            } finally {
                this.f28556k = null;
                this.f28557l = null;
                CacheSpan cacheSpan = this.f28561p;
                if (cacheSpan != null) {
                    this.f28546a.i(cacheSpan);
                    this.f28561p = null;
                }
            }
        }
    }

    private static Uri u(Cache cache, String str, Uri uri) {
        Uri b2 = c.b(cache.b(str));
        return b2 != null ? b2 : uri;
    }

    private void v(Throwable th) {
        if (x() || (th instanceof Cache.CacheException)) {
            this.f28562q = true;
        }
    }

    private boolean w() {
        return this.f28557l == this.f28549d;
    }

    private boolean x() {
        return this.f28557l == this.f28547b;
    }

    private boolean y() {
        return !x();
    }

    private boolean z() {
        return this.f28557l == this.f28548c;
    }

    public Uri b() {
        return this.f28554i;
    }

    public void close() throws IOException {
        this.f28555j = null;
        this.f28554i = null;
        this.f28559n = 0;
        A();
        try {
            q();
        } catch (Throwable th) {
            v(th);
            throw th;
        }
    }

    public Map<String, List<String>> d() {
        if (y()) {
            return this.f28549d.d();
        }
        return Collections.emptyMap();
    }

    public long i(DataSpec dataSpec) throws IOException {
        boolean z2;
        try {
            String a2 = this.f28550e.a(dataSpec);
            DataSpec a3 = dataSpec.a().f(a2).a();
            this.f28555j = a3;
            this.f28554i = u(this.f28546a, a2, a3.f28339a);
            this.f28559n = dataSpec.f28345g;
            int E = E(dataSpec);
            if (E != -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f28563r = z2;
            if (z2) {
                B(E);
            }
            if (this.f28563r) {
                this.f28560o = -1;
            } else {
                long a4 = c.a(this.f28546a.b(a2));
                this.f28560o = a4;
                if (a4 != -1) {
                    long j2 = a4 - dataSpec.f28345g;
                    this.f28560o = j2;
                    if (j2 < 0) {
                        throw new DataSourceException(2008);
                    }
                }
            }
            long j3 = dataSpec.f28346h;
            if (j3 != -1) {
                long j4 = this.f28560o;
                if (j4 != -1) {
                    j3 = Math.min(j4, j3);
                }
                this.f28560o = j3;
            }
            long j5 = this.f28560o;
            if (j5 > 0 || j5 == -1) {
                C(a3, false);
            }
            long j6 = dataSpec.f28346h;
            if (j6 != -1) {
                return j6;
            }
            return this.f28560o;
        } catch (Throwable th) {
            v(th);
            throw th;
        }
    }

    public void p(TransferListener transferListener) {
        Assertions.e(transferListener);
        this.f28547b.p(transferListener);
        this.f28549d.p(transferListener);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        if (this.f28560o == 0) {
            return -1;
        }
        DataSpec dataSpec = (DataSpec) Assertions.e(this.f28555j);
        DataSpec dataSpec2 = (DataSpec) Assertions.e(this.f28556k);
        try {
            if (this.f28559n >= this.f28565t) {
                C(dataSpec, true);
            }
            int read = ((DataSource) Assertions.e(this.f28557l)).read(bArr, i2, i3);
            if (read != -1) {
                if (x()) {
                    this.f28564s += (long) read;
                }
                long j2 = (long) read;
                this.f28559n += j2;
                this.f28558m += j2;
                long j3 = this.f28560o;
                if (j3 != -1) {
                    this.f28560o = j3 - j2;
                }
            } else {
                if (y()) {
                    long j4 = dataSpec2.f28346h;
                    if (j4 == -1 || this.f28558m < j4) {
                        D((String) Util.j(dataSpec.f28347i));
                    }
                }
                long j5 = this.f28560o;
                if (j5 <= 0) {
                    if (j5 == -1) {
                    }
                }
                q();
                C(dataSpec, false);
                return read(bArr, i2, i3);
            }
            return read;
        } catch (Throwable th) {
            v(th);
            throw th;
        }
    }

    public Cache s() {
        return this.f28546a;
    }

    public CacheKeyFactory t() {
        return this.f28550e;
    }

    private CacheDataSource(Cache cache, DataSource dataSource, DataSource dataSource2, DataSink dataSink, CacheKeyFactory cacheKeyFactory, int i2, PriorityTaskManager priorityTaskManager, int i3, EventListener eventListener) {
        this.f28546a = cache;
        this.f28547b = dataSource2;
        this.f28550e = cacheKeyFactory == null ? CacheKeyFactory.f28580a : cacheKeyFactory;
        boolean z2 = false;
        this.f28551f = (i2 & 1) != 0;
        this.f28552g = (i2 & 2) != 0;
        this.f28553h = (i2 & 4) != 0 ? true : z2;
        TeeDataSource teeDataSource = null;
        if (dataSource != null) {
            dataSource = priorityTaskManager != null ? new PriorityDataSource(dataSource, priorityTaskManager, i3) : dataSource;
            this.f28549d = dataSource;
            this.f28548c = dataSink != null ? new TeeDataSource(dataSource, dataSink) : teeDataSource;
            return;
        }
        this.f28549d = PlaceholderDataSource.f28488a;
        this.f28548c = null;
    }
}
