package com.bumptech.glide.load.engine;

import android.os.Build;
import android.util.Log;
import androidx.core.util.Pools$Pool;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.GlideTrace;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class DecodeJob<R> implements DataFetcherGenerator.FetcherReadyCallback, Runnable, Comparable<DecodeJob<?>>, FactoryPools.Poolable {
    private Object A;
    private DataSource B;
    private DataFetcher<?> C;
    private volatile DataFetcherGenerator D;
    private volatile boolean E;
    private volatile boolean F;

    /* renamed from: b  reason: collision with root package name */
    private final DecodeHelper<R> f16402b = new DecodeHelper<>();

    /* renamed from: c  reason: collision with root package name */
    private final List<Throwable> f16403c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final StateVerifier f16404d = StateVerifier.a();

    /* renamed from: e  reason: collision with root package name */
    private final DiskCacheProvider f16405e;

    /* renamed from: f  reason: collision with root package name */
    private final Pools$Pool<DecodeJob<?>> f16406f;

    /* renamed from: g  reason: collision with root package name */
    private final DeferredEncodeManager<?> f16407g = new DeferredEncodeManager<>();

    /* renamed from: h  reason: collision with root package name */
    private final ReleaseManager f16408h = new ReleaseManager();

    /* renamed from: i  reason: collision with root package name */
    private GlideContext f16409i;

    /* renamed from: j  reason: collision with root package name */
    private Key f16410j;

    /* renamed from: k  reason: collision with root package name */
    private Priority f16411k;

    /* renamed from: l  reason: collision with root package name */
    private EngineKey f16412l;

    /* renamed from: m  reason: collision with root package name */
    private int f16413m;

    /* renamed from: n  reason: collision with root package name */
    private int f16414n;

    /* renamed from: o  reason: collision with root package name */
    private DiskCacheStrategy f16415o;

    /* renamed from: p  reason: collision with root package name */
    private Options f16416p;

    /* renamed from: q  reason: collision with root package name */
    private Callback<R> f16417q;

    /* renamed from: r  reason: collision with root package name */
    private int f16418r;

    /* renamed from: s  reason: collision with root package name */
    private Stage f16419s;

    /* renamed from: t  reason: collision with root package name */
    private RunReason f16420t;

    /* renamed from: u  reason: collision with root package name */
    private long f16421u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f16422v;

    /* renamed from: w  reason: collision with root package name */
    private Object f16423w;

    /* renamed from: x  reason: collision with root package name */
    private Thread f16424x;

    /* renamed from: y  reason: collision with root package name */
    private Key f16425y;

    /* renamed from: z  reason: collision with root package name */
    private Key f16426z;

    /* renamed from: com.bumptech.glide.load.engine.DecodeJob$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f16427a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f16428b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f16429c;

        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|12|13|15|16|17|18|19|20|21|23|24|25|26|27|28|30) */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x006a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0074 */
        static {
            /*
                com.bumptech.glide.load.EncodeStrategy[] r0 = com.bumptech.glide.load.EncodeStrategy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f16429c = r0
                r1 = 1
                com.bumptech.glide.load.EncodeStrategy r2 = com.bumptech.glide.load.EncodeStrategy.SOURCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f16429c     // Catch:{ NoSuchFieldError -> 0x001d }
                com.bumptech.glide.load.EncodeStrategy r3 = com.bumptech.glide.load.EncodeStrategy.TRANSFORMED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.bumptech.glide.load.engine.DecodeJob$Stage[] r2 = com.bumptech.glide.load.engine.DecodeJob.Stage.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f16428b = r2
                com.bumptech.glide.load.engine.DecodeJob$Stage r3 = com.bumptech.glide.load.engine.DecodeJob.Stage.RESOURCE_CACHE     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r2 = f16428b     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.bumptech.glide.load.engine.DecodeJob$Stage r3 = com.bumptech.glide.load.engine.DecodeJob.Stage.DATA_CACHE     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                r2 = 3
                int[] r3 = f16428b     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.bumptech.glide.load.engine.DecodeJob$Stage r4 = com.bumptech.glide.load.engine.DecodeJob.Stage.SOURCE     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r3 = f16428b     // Catch:{ NoSuchFieldError -> 0x004e }
                com.bumptech.glide.load.engine.DecodeJob$Stage r4 = com.bumptech.glide.load.engine.DecodeJob.Stage.FINISHED     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r3 = f16428b     // Catch:{ NoSuchFieldError -> 0x0059 }
                com.bumptech.glide.load.engine.DecodeJob$Stage r4 = com.bumptech.glide.load.engine.DecodeJob.Stage.INITIALIZE     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                com.bumptech.glide.load.engine.DecodeJob$RunReason[] r3 = com.bumptech.glide.load.engine.DecodeJob.RunReason.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f16427a = r3
                com.bumptech.glide.load.engine.DecodeJob$RunReason r4 = com.bumptech.glide.load.engine.DecodeJob.RunReason.INITIALIZE     // Catch:{ NoSuchFieldError -> 0x006a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x006a }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x006a }
            L_0x006a:
                int[] r1 = f16427a     // Catch:{ NoSuchFieldError -> 0x0074 }
                com.bumptech.glide.load.engine.DecodeJob$RunReason r3 = com.bumptech.glide.load.engine.DecodeJob.RunReason.SWITCH_TO_SOURCE_SERVICE     // Catch:{ NoSuchFieldError -> 0x0074 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0074 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0074 }
            L_0x0074:
                int[] r0 = f16427a     // Catch:{ NoSuchFieldError -> 0x007e }
                com.bumptech.glide.load.engine.DecodeJob$RunReason r1 = com.bumptech.glide.load.engine.DecodeJob.RunReason.DECODE_DATA     // Catch:{ NoSuchFieldError -> 0x007e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007e }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007e }
            L_0x007e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.AnonymousClass1.<clinit>():void");
        }
    }

    interface Callback<R> {
        void a(DecodeJob<?> decodeJob);

        void onLoadFailed(GlideException glideException);

        void onResourceReady(Resource<R> resource, DataSource dataSource);
    }

    private final class DecodeCallback<Z> implements DecodePath.DecodeCallback<Z> {

        /* renamed from: a  reason: collision with root package name */
        private final DataSource f16430a;

        DecodeCallback(DataSource dataSource) {
            this.f16430a = dataSource;
        }

        public Resource<Z> a(Resource<Z> resource) {
            return DecodeJob.this.v(this.f16430a, resource);
        }
    }

    private static class DeferredEncodeManager<Z> {

        /* renamed from: a  reason: collision with root package name */
        private Key f16432a;

        /* renamed from: b  reason: collision with root package name */
        private ResourceEncoder<Z> f16433b;

        /* renamed from: c  reason: collision with root package name */
        private LockedResource<Z> f16434c;

        DeferredEncodeManager() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f16432a = null;
            this.f16433b = null;
            this.f16434c = null;
        }

        /* access modifiers changed from: package-private */
        public void b(DiskCacheProvider diskCacheProvider, Options options) {
            GlideTrace.a("DecodeJob.encode");
            try {
                diskCacheProvider.a().a(this.f16432a, new DataCacheWriter(this.f16433b, this.f16434c, options));
            } finally {
                this.f16434c.f();
                GlideTrace.d();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            return this.f16434c != null;
        }

        /* access modifiers changed from: package-private */
        public <X> void d(Key key, ResourceEncoder<X> resourceEncoder, LockedResource<X> lockedResource) {
            this.f16432a = key;
            this.f16433b = resourceEncoder;
            this.f16434c = lockedResource;
        }
    }

    interface DiskCacheProvider {
        DiskCache a();
    }

    private static class ReleaseManager {

        /* renamed from: a  reason: collision with root package name */
        private boolean f16435a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f16436b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f16437c;

        ReleaseManager() {
        }

        private boolean a(boolean z2) {
            return (this.f16437c || z2 || this.f16436b) && this.f16435a;
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean b() {
            this.f16436b = true;
            return a(false);
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean c() {
            this.f16437c = true;
            return a(false);
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean d(boolean z2) {
            this.f16435a = true;
            return a(z2);
        }

        /* access modifiers changed from: package-private */
        public synchronized void e() {
            this.f16436b = false;
            this.f16435a = false;
            this.f16437c = false;
        }
    }

    private enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    private enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    DecodeJob(DiskCacheProvider diskCacheProvider, Pools$Pool<DecodeJob<?>> pools$Pool) {
        this.f16405e = diskCacheProvider;
        this.f16406f = pools$Pool;
    }

    private void A() {
        int i2 = AnonymousClass1.f16427a[this.f16420t.ordinal()];
        if (i2 == 1) {
            this.f16419s = k(Stage.INITIALIZE);
            this.D = j();
            y();
        } else if (i2 == 2) {
            y();
        } else if (i2 == 3) {
            i();
        } else {
            throw new IllegalStateException("Unrecognized run reason: " + this.f16420t);
        }
    }

    private void B() {
        Throwable th;
        this.f16404d.c();
        if (this.E) {
            if (this.f16403c.isEmpty()) {
                th = null;
            } else {
                List<Throwable> list = this.f16403c;
                th = list.get(list.size() - 1);
            }
            throw new IllegalStateException("Already notified", th);
        }
        this.E = true;
    }

    private <Data> Resource<R> g(DataFetcher<?> dataFetcher, Data data, DataSource dataSource) throws GlideException {
        if (data == null) {
            dataFetcher.b();
            return null;
        }
        try {
            long b2 = LogTime.b();
            Resource<R> h2 = h(data, dataSource);
            if (Log.isLoggable("DecodeJob", 2)) {
                o("Decoded result " + h2, b2);
            }
            return h2;
        } finally {
            dataFetcher.b();
        }
    }

    private <Data> Resource<R> h(Data data, DataSource dataSource) throws GlideException {
        return z(data, dataSource, this.f16402b.h(data.getClass()));
    }

    private void i() {
        Resource<R> resource;
        if (Log.isLoggable("DecodeJob", 2)) {
            long j2 = this.f16421u;
            p("Retrieved data", j2, "data: " + this.A + ", cache key: " + this.f16425y + ", fetcher: " + this.C);
        }
        try {
            resource = g(this.C, this.A, this.B);
        } catch (GlideException e2) {
            e2.i(this.f16426z, this.B);
            this.f16403c.add(e2);
            resource = null;
        }
        if (resource != null) {
            r(resource, this.B);
        } else {
            y();
        }
    }

    private DataFetcherGenerator j() {
        int i2 = AnonymousClass1.f16428b[this.f16419s.ordinal()];
        if (i2 == 1) {
            return new ResourceCacheGenerator(this.f16402b, this);
        }
        if (i2 == 2) {
            return new DataCacheGenerator(this.f16402b, this);
        }
        if (i2 == 3) {
            return new SourceGenerator(this.f16402b, this);
        }
        if (i2 == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.f16419s);
    }

    private Stage k(Stage stage) {
        int i2 = AnonymousClass1.f16428b[stage.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3 || i2 == 4) {
                    return Stage.FINISHED;
                }
                if (i2 != 5) {
                    throw new IllegalArgumentException("Unrecognized stage: " + stage);
                } else if (this.f16415o.b()) {
                    return Stage.RESOURCE_CACHE;
                } else {
                    return k(Stage.RESOURCE_CACHE);
                }
            } else if (this.f16422v) {
                return Stage.FINISHED;
            } else {
                return Stage.SOURCE;
            }
        } else if (this.f16415o.a()) {
            return Stage.DATA_CACHE;
        } else {
            return k(Stage.DATA_CACHE);
        }
    }

    private Options l(DataSource dataSource) {
        boolean z2;
        Options options = this.f16416p;
        if (Build.VERSION.SDK_INT < 26) {
            return options;
        }
        if (dataSource == DataSource.RESOURCE_DISK_CACHE || this.f16402b.w()) {
            z2 = true;
        } else {
            z2 = false;
        }
        Option option = Downsampler.f16842j;
        Boolean bool = (Boolean) options.c(option);
        if (bool != null && (!bool.booleanValue() || z2)) {
            return options;
        }
        Options options2 = new Options();
        options2.d(this.f16416p);
        options2.e(option, Boolean.valueOf(z2));
        return options2;
    }

    private int m() {
        return this.f16411k.ordinal();
    }

    private void o(String str, long j2) {
        p(str, j2, (String) null);
    }

    private void p(String str, long j2, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(LogTime.a(j2));
        sb.append(", load key: ");
        sb.append(this.f16412l);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }

    private void q(Resource<R> resource, DataSource dataSource) {
        B();
        this.f16417q.onResourceReady(resource, dataSource);
    }

    private void r(Resource<R> resource, DataSource dataSource) {
        LockedResource<R> lockedResource;
        LockedResource<R> lockedResource2;
        if (resource instanceof Initializable) {
            ((Initializable) resource).initialize();
        }
        if (this.f16407g.c()) {
            LockedResource<R> d2 = LockedResource.d(resource);
            lockedResource2 = d2;
            lockedResource = d2;
        } else {
            lockedResource2 = null;
            lockedResource = resource;
        }
        q(lockedResource, dataSource);
        this.f16419s = Stage.ENCODE;
        try {
            if (this.f16407g.c()) {
                this.f16407g.b(this.f16405e, this.f16416p);
            }
            t();
        } finally {
            if (lockedResource2 != null) {
                lockedResource2.f();
            }
        }
    }

    private void s() {
        B();
        this.f16417q.onLoadFailed(new GlideException("Failed to load resource", (List<Throwable>) new ArrayList(this.f16403c)));
        u();
    }

    private void t() {
        if (this.f16408h.b()) {
            x();
        }
    }

    private void u() {
        if (this.f16408h.c()) {
            x();
        }
    }

    private void x() {
        this.f16408h.e();
        this.f16407g.a();
        this.f16402b.a();
        this.E = false;
        this.f16409i = null;
        this.f16410j = null;
        this.f16416p = null;
        this.f16411k = null;
        this.f16412l = null;
        this.f16417q = null;
        this.f16419s = null;
        this.D = null;
        this.f16424x = null;
        this.f16425y = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.f16421u = 0;
        this.F = false;
        this.f16423w = null;
        this.f16403c.clear();
        this.f16406f.release(this);
    }

    private void y() {
        this.f16424x = Thread.currentThread();
        this.f16421u = LogTime.b();
        boolean z2 = false;
        while (!this.F && this.D != null && !(z2 = this.D.b())) {
            this.f16419s = k(this.f16419s);
            this.D = j();
            if (this.f16419s == Stage.SOURCE) {
                c();
                return;
            }
        }
        if ((this.f16419s == Stage.FINISHED || this.F) && !z2) {
            s();
        }
    }

    private <Data, ResourceType> Resource<R> z(Data data, DataSource dataSource, LoadPath<Data, ResourceType, R> loadPath) throws GlideException {
        Options l2 = l(dataSource);
        DataRewinder l3 = this.f16409i.h().l(data);
        try {
            return loadPath.a(l3, l2, this.f16413m, this.f16414n, new DecodeCallback(dataSource));
        } finally {
            l3.b();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean C() {
        Stage k2 = k(Stage.INITIALIZE);
        if (k2 == Stage.RESOURCE_CACHE || k2 == Stage.DATA_CACHE) {
            return true;
        }
        return false;
    }

    public void a(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        dataFetcher.b();
        GlideException glideException = new GlideException("Fetching data failed", (Throwable) exc);
        glideException.j(key, dataSource, dataFetcher.a());
        this.f16403c.add(glideException);
        if (Thread.currentThread() != this.f16424x) {
            this.f16420t = RunReason.SWITCH_TO_SOURCE_SERVICE;
            this.f16417q.a(this);
            return;
        }
        y();
    }

    public StateVerifier b() {
        return this.f16404d;
    }

    public void c() {
        this.f16420t = RunReason.SWITCH_TO_SOURCE_SERVICE;
        this.f16417q.a(this);
    }

    public void d(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.f16425y = key;
        this.A = obj;
        this.C = dataFetcher;
        this.B = dataSource;
        this.f16426z = key2;
        if (Thread.currentThread() != this.f16424x) {
            this.f16420t = RunReason.DECODE_DATA;
            this.f16417q.a(this);
            return;
        }
        GlideTrace.a("DecodeJob.decodeFromRetrievedData");
        try {
            i();
        } finally {
            GlideTrace.d();
        }
    }

    public void e() {
        this.F = true;
        DataFetcherGenerator dataFetcherGenerator = this.D;
        if (dataFetcherGenerator != null) {
            dataFetcherGenerator.cancel();
        }
    }

    /* renamed from: f */
    public int compareTo(DecodeJob<?> decodeJob) {
        int m2 = m() - decodeJob.m();
        if (m2 == 0) {
            return this.f16418r - decodeJob.f16418r;
        }
        return m2;
    }

    /* access modifiers changed from: package-private */
    public DecodeJob<R> n(GlideContext glideContext, Object obj, EngineKey engineKey, Key key, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z2, boolean z3, boolean z4, Options options, Callback<R> callback, int i4) {
        this.f16402b.u(glideContext, obj, key, i2, i3, diskCacheStrategy, cls, cls2, priority, options, map, z2, z3, this.f16405e);
        this.f16409i = glideContext;
        this.f16410j = key;
        this.f16411k = priority;
        this.f16412l = engineKey;
        this.f16413m = i2;
        this.f16414n = i3;
        this.f16415o = diskCacheStrategy;
        this.f16422v = z4;
        this.f16416p = options;
        this.f16417q = callback;
        this.f16418r = i4;
        this.f16420t = RunReason.INITIALIZE;
        this.f16423w = obj;
        return this;
    }

    public void run() {
        GlideTrace.b("DecodeJob#run(model=%s)", this.f16423w);
        DataFetcher<?> dataFetcher = this.C;
        try {
            if (this.F) {
                s();
                if (dataFetcher != null) {
                    dataFetcher.b();
                }
                GlideTrace.d();
                return;
            }
            A();
            if (dataFetcher != null) {
                dataFetcher.b();
            }
            GlideTrace.d();
        } catch (CallbackException e2) {
            throw e2;
        } catch (Throwable th) {
            if (dataFetcher != null) {
                dataFetcher.b();
            }
            GlideTrace.d();
            throw th;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: com.bumptech.glide.load.engine.ResourceCacheKey} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: com.bumptech.glide.load.engine.DataCacheKey} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v8, resolved type: com.bumptech.glide.load.engine.ResourceCacheKey} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: com.bumptech.glide.load.engine.ResourceCacheKey} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <Z> com.bumptech.glide.load.engine.Resource<Z> v(com.bumptech.glide.load.DataSource r12, com.bumptech.glide.load.engine.Resource<Z> r13) {
        /*
            r11 = this;
            java.lang.Object r0 = r13.get()
            java.lang.Class r8 = r0.getClass()
            com.bumptech.glide.load.DataSource r0 = com.bumptech.glide.load.DataSource.RESOURCE_DISK_CACHE
            r1 = 0
            if (r12 == r0) goto L_0x0020
            com.bumptech.glide.load.engine.DecodeHelper<R> r0 = r11.f16402b
            com.bumptech.glide.load.Transformation r0 = r0.r(r8)
            com.bumptech.glide.GlideContext r2 = r11.f16409i
            int r3 = r11.f16413m
            int r4 = r11.f16414n
            com.bumptech.glide.load.engine.Resource r2 = r0.a(r2, r13, r3, r4)
            r7 = r0
            r0 = r2
            goto L_0x0022
        L_0x0020:
            r0 = r13
            r7 = r1
        L_0x0022:
            boolean r2 = r13.equals(r0)
            if (r2 != 0) goto L_0x002b
            r13.recycle()
        L_0x002b:
            com.bumptech.glide.load.engine.DecodeHelper<R> r13 = r11.f16402b
            boolean r13 = r13.v(r0)
            if (r13 == 0) goto L_0x0040
            com.bumptech.glide.load.engine.DecodeHelper<R> r13 = r11.f16402b
            com.bumptech.glide.load.ResourceEncoder r1 = r13.n(r0)
            com.bumptech.glide.load.Options r13 = r11.f16416p
            com.bumptech.glide.load.EncodeStrategy r13 = r1.b(r13)
            goto L_0x0042
        L_0x0040:
            com.bumptech.glide.load.EncodeStrategy r13 = com.bumptech.glide.load.EncodeStrategy.NONE
        L_0x0042:
            r10 = r1
            com.bumptech.glide.load.engine.DecodeHelper<R> r1 = r11.f16402b
            com.bumptech.glide.load.Key r2 = r11.f16425y
            boolean r1 = r1.x(r2)
            r2 = 1
            r1 = r1 ^ r2
            com.bumptech.glide.load.engine.DiskCacheStrategy r3 = r11.f16415o
            boolean r12 = r3.d(r1, r12, r13)
            if (r12 == 0) goto L_0x00b3
            if (r10 == 0) goto L_0x00a5
            int[] r12 = com.bumptech.glide.load.engine.DecodeJob.AnonymousClass1.f16429c
            int r1 = r13.ordinal()
            r12 = r12[r1]
            if (r12 == r2) goto L_0x0092
            r1 = 2
            if (r12 != r1) goto L_0x007b
            com.bumptech.glide.load.engine.ResourceCacheKey r12 = new com.bumptech.glide.load.engine.ResourceCacheKey
            com.bumptech.glide.load.engine.DecodeHelper<R> r13 = r11.f16402b
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r2 = r13.b()
            com.bumptech.glide.load.Key r3 = r11.f16425y
            com.bumptech.glide.load.Key r4 = r11.f16410j
            int r5 = r11.f16413m
            int r6 = r11.f16414n
            com.bumptech.glide.load.Options r9 = r11.f16416p
            r1 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x009b
        L_0x007b:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown strategy: "
            r0.append(r1)
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            r12.<init>(r13)
            throw r12
        L_0x0092:
            com.bumptech.glide.load.engine.DataCacheKey r12 = new com.bumptech.glide.load.engine.DataCacheKey
            com.bumptech.glide.load.Key r13 = r11.f16425y
            com.bumptech.glide.load.Key r1 = r11.f16410j
            r12.<init>(r13, r1)
        L_0x009b:
            com.bumptech.glide.load.engine.LockedResource r0 = com.bumptech.glide.load.engine.LockedResource.d(r0)
            com.bumptech.glide.load.engine.DecodeJob$DeferredEncodeManager<?> r13 = r11.f16407g
            r13.d(r12, r10, r0)
            goto L_0x00b3
        L_0x00a5:
            com.bumptech.glide.Registry$NoResultEncoderAvailableException r12 = new com.bumptech.glide.Registry$NoResultEncoderAvailableException
            java.lang.Object r13 = r0.get()
            java.lang.Class r13 = r13.getClass()
            r12.<init>(r13)
            throw r12
        L_0x00b3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.v(com.bumptech.glide.load.DataSource, com.bumptech.glide.load.engine.Resource):com.bumptech.glide.load.engine.Resource");
    }

    /* access modifiers changed from: package-private */
    public void w(boolean z2) {
        if (this.f16408h.d(z2)) {
            x();
        }
    }
}
