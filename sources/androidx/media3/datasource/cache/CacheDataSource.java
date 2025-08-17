package androidx.media3.datasource.cache;

import android.net.Uri;
import androidx.media3.common.PriorityTaskManager;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSink;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceException;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.FileDataSource;
import androidx.media3.datasource.PlaceholderDataSource;
import androidx.media3.datasource.PriorityDataSource;
import androidx.media3.datasource.TeeDataSource;
import androidx.media3.datasource.TransferListener;
import androidx.media3.datasource.cache.Cache;
import androidx.media3.datasource.cache.CacheDataSink;
import com.facebook.common.time.Clock;
import d.c;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class CacheDataSource implements DataSource {

    /* renamed from: a  reason: collision with root package name */
    private final Cache f4941a;

    /* renamed from: b  reason: collision with root package name */
    private final DataSource f4942b;

    /* renamed from: c  reason: collision with root package name */
    private final DataSource f4943c;

    /* renamed from: d  reason: collision with root package name */
    private final DataSource f4944d;

    /* renamed from: e  reason: collision with root package name */
    private final CacheKeyFactory f4945e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f4946f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f4947g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f4948h;

    /* renamed from: i  reason: collision with root package name */
    private Uri f4949i;

    /* renamed from: j  reason: collision with root package name */
    private DataSpec f4950j;

    /* renamed from: k  reason: collision with root package name */
    private DataSpec f4951k;

    /* renamed from: l  reason: collision with root package name */
    private DataSource f4952l;

    /* renamed from: m  reason: collision with root package name */
    private long f4953m;

    /* renamed from: n  reason: collision with root package name */
    private long f4954n;

    /* renamed from: o  reason: collision with root package name */
    private long f4955o;

    /* renamed from: p  reason: collision with root package name */
    private CacheSpan f4956p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f4957q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f4958r;

    /* renamed from: s  reason: collision with root package name */
    private long f4959s;

    /* renamed from: t  reason: collision with root package name */
    private long f4960t;

    public interface EventListener {
    }

    public static final class Factory implements DataSource.Factory {

        /* renamed from: a  reason: collision with root package name */
        private Cache f4961a;

        /* renamed from: b  reason: collision with root package name */
        private DataSource.Factory f4962b = new FileDataSource.Factory();

        /* renamed from: c  reason: collision with root package name */
        private DataSink.Factory f4963c;

        /* renamed from: d  reason: collision with root package name */
        private CacheKeyFactory f4964d = CacheKeyFactory.f4975a;

        /* renamed from: e  reason: collision with root package name */
        private boolean f4965e;

        /* renamed from: f  reason: collision with root package name */
        private DataSource.Factory f4966f;

        /* renamed from: g  reason: collision with root package name */
        private PriorityTaskManager f4967g;

        /* renamed from: h  reason: collision with root package name */
        private int f4968h;

        /* renamed from: i  reason: collision with root package name */
        private int f4969i;

        private CacheDataSource d(DataSource dataSource, int i2, int i3) {
            DataSink dataSink;
            Cache cache = (Cache) Assertions.f(this.f4961a);
            if (this.f4965e || dataSource == null) {
                dataSink = null;
            } else {
                DataSink.Factory factory = this.f4963c;
                if (factory != null) {
                    dataSink = factory.a();
                } else {
                    dataSink = new CacheDataSink.Factory().b(cache).a();
                }
            }
            return new CacheDataSource(cache, dataSource, this.f4962b.a(), dataSink, this.f4964d, i2, this.f4967g, i3, (EventListener) null);
        }

        /* renamed from: c */
        public CacheDataSource a() {
            DataSource dataSource;
            DataSource.Factory factory = this.f4966f;
            if (factory != null) {
                dataSource = factory.a();
            } else {
                dataSource = null;
            }
            return d(dataSource, this.f4969i, this.f4968h);
        }

        public Factory e(Cache cache) {
            this.f4961a = cache;
            return this;
        }

        public Factory f(DataSource.Factory factory) {
            this.f4966f = factory;
            return this;
        }
    }

    private void o() throws IOException {
        DataSource dataSource = this.f4952l;
        if (dataSource != null) {
            try {
                dataSource.close();
            } finally {
                this.f4951k = null;
                this.f4952l = null;
                CacheSpan cacheSpan = this.f4956p;
                if (cacheSpan != null) {
                    this.f4941a.g(cacheSpan);
                    this.f4956p = null;
                }
            }
        }
    }

    private static Uri p(Cache cache, String str, Uri uri) {
        Uri b2 = c.b(cache.b(str));
        return b2 != null ? b2 : uri;
    }

    private void q(Throwable th) {
        if (s() || (th instanceof Cache.CacheException)) {
            this.f4957q = true;
        }
    }

    private boolean r() {
        return this.f4952l == this.f4944d;
    }

    private boolean s() {
        return this.f4952l == this.f4942b;
    }

    private boolean t() {
        return !s();
    }

    private boolean u() {
        return this.f4952l == this.f4943c;
    }

    private void v() {
    }

    private void w(int i2) {
    }

    private void x(DataSpec dataSpec, boolean z2) throws IOException {
        CacheSpan cacheSpan;
        DataSpec dataSpec2;
        DataSource dataSource;
        long j2;
        long j3;
        DataSpec dataSpec3 = dataSpec;
        String str = (String) Util.i(dataSpec3.f4831i);
        Uri uri = null;
        if (this.f4958r) {
            cacheSpan = null;
        } else if (this.f4946f) {
            try {
                cacheSpan = this.f4941a.d(str, this.f4954n, this.f4955o);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            cacheSpan = this.f4941a.c(str, this.f4954n, this.f4955o);
        }
        if (cacheSpan == null) {
            dataSource = this.f4944d;
            dataSpec2 = dataSpec.a().h(this.f4954n).g(this.f4955o).a();
        } else if (cacheSpan.f4979e) {
            Uri fromFile = Uri.fromFile((File) Util.i(cacheSpan.f4980f));
            long j4 = cacheSpan.f4977c;
            long j5 = this.f4954n - j4;
            long j6 = cacheSpan.f4978d - j5;
            long j7 = this.f4955o;
            if (j7 != -1) {
                j6 = Math.min(j6, j7);
            }
            dataSpec2 = dataSpec.a().i(fromFile).k(j4).h(j5).g(j6).a();
            dataSource = this.f4942b;
        } else {
            if (cacheSpan.c()) {
                j3 = this.f4955o;
            } else {
                j3 = cacheSpan.f4978d;
                long j8 = this.f4955o;
                if (j8 != -1) {
                    j3 = Math.min(j3, j8);
                }
            }
            dataSpec2 = dataSpec.a().h(this.f4954n).g(j3).a();
            dataSource = this.f4943c;
            if (dataSource == null) {
                dataSource = this.f4944d;
                this.f4941a.g(cacheSpan);
                cacheSpan = null;
            }
        }
        if (this.f4958r || dataSource != this.f4944d) {
            j2 = Clock.MAX_TIME;
        } else {
            j2 = this.f4954n + 102400;
        }
        this.f4960t = j2;
        if (z2) {
            Assertions.h(r());
            if (dataSource != this.f4944d) {
                try {
                    o();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    if (((CacheSpan) Util.i(cacheSpan)).b()) {
                        this.f4941a.g(cacheSpan);
                    }
                    throw th2;
                }
            } else {
                return;
            }
        }
        if (cacheSpan != null && cacheSpan.b()) {
            this.f4956p = cacheSpan;
        }
        this.f4952l = dataSource;
        this.f4951k = dataSpec2;
        this.f4953m = 0;
        long i2 = dataSource.i(dataSpec2);
        ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
        if (dataSpec2.f4830h == -1 && i2 != -1) {
            this.f4955o = i2;
            ContentMetadataMutations.g(contentMetadataMutations, this.f4954n + i2);
        }
        if (t()) {
            Uri b2 = dataSource.b();
            this.f4949i = b2;
            if (!dataSpec3.f4823a.equals(b2)) {
                uri = this.f4949i;
            }
            ContentMetadataMutations.h(contentMetadataMutations, uri);
        }
        if (u()) {
            this.f4941a.h(str, contentMetadataMutations);
        }
    }

    private void y(String str) throws IOException {
        this.f4955o = 0;
        if (u()) {
            ContentMetadataMutations contentMetadataMutations = new ContentMetadataMutations();
            ContentMetadataMutations.g(contentMetadataMutations, this.f4954n);
            this.f4941a.h(str, contentMetadataMutations);
        }
    }

    private int z(DataSpec dataSpec) {
        if (this.f4947g && this.f4957q) {
            return 0;
        }
        if (!this.f4948h || dataSpec.f4830h != -1) {
            return -1;
        }
        return 1;
    }

    public Uri b() {
        return this.f4949i;
    }

    public void close() throws IOException {
        this.f4950j = null;
        this.f4949i = null;
        this.f4954n = 0;
        v();
        try {
            o();
        } catch (Throwable th) {
            q(th);
            throw th;
        }
    }

    public Map<String, List<String>> d() {
        if (t()) {
            return this.f4944d.d();
        }
        return Collections.emptyMap();
    }

    public long i(DataSpec dataSpec) throws IOException {
        boolean z2;
        try {
            String a2 = this.f4945e.a(dataSpec);
            DataSpec a3 = dataSpec.a().f(a2).a();
            this.f4950j = a3;
            this.f4949i = p(this.f4941a, a2, a3.f4823a);
            this.f4954n = dataSpec.f4829g;
            int z3 = z(dataSpec);
            if (z3 != -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f4958r = z2;
            if (z2) {
                w(z3);
            }
            if (this.f4958r) {
                this.f4955o = -1;
            } else {
                long a4 = c.a(this.f4941a.b(a2));
                this.f4955o = a4;
                if (a4 != -1) {
                    long j2 = a4 - dataSpec.f4829g;
                    this.f4955o = j2;
                    if (j2 < 0) {
                        throw new DataSourceException(2008);
                    }
                }
            }
            long j3 = dataSpec.f4830h;
            if (j3 != -1) {
                long j4 = this.f4955o;
                if (j4 != -1) {
                    j3 = Math.min(j4, j3);
                }
                this.f4955o = j3;
            }
            long j5 = this.f4955o;
            if (j5 > 0 || j5 == -1) {
                x(a3, false);
            }
            long j6 = dataSpec.f4830h;
            if (j6 != -1) {
                return j6;
            }
            return this.f4955o;
        } catch (Throwable th) {
            q(th);
            throw th;
        }
    }

    public void n(TransferListener transferListener) {
        Assertions.f(transferListener);
        this.f4942b.n(transferListener);
        this.f4944d.n(transferListener);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (i3 == 0) {
            return 0;
        }
        if (this.f4955o == 0) {
            return -1;
        }
        DataSpec dataSpec = (DataSpec) Assertions.f(this.f4950j);
        DataSpec dataSpec2 = (DataSpec) Assertions.f(this.f4951k);
        try {
            if (this.f4954n >= this.f4960t) {
                x(dataSpec, true);
            }
            int read = ((DataSource) Assertions.f(this.f4952l)).read(bArr, i2, i3);
            if (read != -1) {
                if (s()) {
                    this.f4959s += (long) read;
                }
                long j2 = (long) read;
                this.f4954n += j2;
                this.f4953m += j2;
                long j3 = this.f4955o;
                if (j3 != -1) {
                    this.f4955o = j3 - j2;
                }
            } else {
                if (t()) {
                    long j4 = dataSpec2.f4830h;
                    if (j4 == -1 || this.f4953m < j4) {
                        y((String) Util.i(dataSpec.f4831i));
                    }
                }
                long j5 = this.f4955o;
                if (j5 <= 0) {
                    if (j5 == -1) {
                    }
                }
                o();
                x(dataSpec, false);
                return read(bArr, i2, i3);
            }
            return read;
        } catch (Throwable th) {
            q(th);
            throw th;
        }
    }

    private CacheDataSource(Cache cache, DataSource dataSource, DataSource dataSource2, DataSink dataSink, CacheKeyFactory cacheKeyFactory, int i2, PriorityTaskManager priorityTaskManager, int i3, EventListener eventListener) {
        this.f4941a = cache;
        this.f4942b = dataSource2;
        this.f4945e = cacheKeyFactory == null ? CacheKeyFactory.f4975a : cacheKeyFactory;
        boolean z2 = false;
        this.f4946f = (i2 & 1) != 0;
        this.f4947g = (i2 & 2) != 0;
        this.f4948h = (i2 & 4) != 0 ? true : z2;
        TeeDataSource teeDataSource = null;
        if (dataSource != null) {
            dataSource = priorityTaskManager != null ? new PriorityDataSource(dataSource, priorityTaskManager, i3) : dataSource;
            this.f4944d = dataSource;
            this.f4943c = dataSink != null ? new TeeDataSource(dataSource, dataSink) : teeDataSource;
            return;
        }
        this.f4944d = PlaceholderDataSource.f4900a;
        this.f4943c = null;
    }
}
