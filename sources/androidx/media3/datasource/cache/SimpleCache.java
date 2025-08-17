package androidx.media3.datasource.cache;

import android.os.ConditionVariable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.database.DatabaseProvider;
import androidx.media3.datasource.cache.Cache;
import d.c;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public final class SimpleCache implements Cache {

    /* renamed from: l  reason: collision with root package name */
    private static final HashSet<File> f5016l = new HashSet<>();

    /* renamed from: a  reason: collision with root package name */
    private final File f5017a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final CacheEvictor f5018b;

    /* renamed from: c  reason: collision with root package name */
    private final CachedContentIndex f5019c;

    /* renamed from: d  reason: collision with root package name */
    private final CacheFileMetadataIndex f5020d;

    /* renamed from: e  reason: collision with root package name */
    private final HashMap<String, ArrayList<Cache.Listener>> f5021e;

    /* renamed from: f  reason: collision with root package name */
    private final Random f5022f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f5023g;

    /* renamed from: h  reason: collision with root package name */
    private long f5024h;

    /* renamed from: i  reason: collision with root package name */
    private long f5025i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f5026j;

    /* renamed from: k  reason: collision with root package name */
    private Cache.CacheException f5027k;

    public SimpleCache(File file, CacheEvictor cacheEvictor, DatabaseProvider databaseProvider) {
        this(file, cacheEvictor, databaseProvider, (byte[]) null, false, false);
    }

    private SimpleCacheSpan A(String str, SimpleCacheSpan simpleCacheSpan) {
        boolean z2;
        if (!this.f5023g) {
            return simpleCacheSpan;
        }
        String name = ((File) Assertions.f(simpleCacheSpan.f4980f)).getName();
        long j2 = simpleCacheSpan.f4978d;
        long currentTimeMillis = System.currentTimeMillis();
        CacheFileMetadataIndex cacheFileMetadataIndex = this.f5020d;
        if (cacheFileMetadataIndex != null) {
            try {
                cacheFileMetadataIndex.h(name, j2, currentTimeMillis);
            } catch (IOException unused) {
                Log.h("SimpleCache", "Failed to update index with new touch timestamp.");
            }
            z2 = false;
        } else {
            z2 = true;
        }
        SimpleCacheSpan k2 = ((CachedContent) Assertions.f(this.f5019c.f(str))).k(simpleCacheSpan, currentTimeMillis, z2);
        v(simpleCacheSpan, k2);
        return k2;
    }

    private static synchronized void B(File file) {
        synchronized (SimpleCache.class) {
            f5016l.remove(file.getAbsoluteFile());
        }
    }

    private void k(SimpleCacheSpan simpleCacheSpan) {
        this.f5019c.k(simpleCacheSpan.f4976b).a(simpleCacheSpan);
        this.f5025i += simpleCacheSpan.f4978d;
        t(simpleCacheSpan);
    }

    private static void m(File file) throws Cache.CacheException {
        if (!file.mkdirs() && !file.isDirectory()) {
            String str = "Failed to create cache directory: " + file;
            Log.c("SimpleCache", str);
            throw new Cache.CacheException(str);
        }
    }

    private static long n(File file) throws IOException {
        long j2;
        long nextLong = new SecureRandom().nextLong();
        if (nextLong == Long.MIN_VALUE) {
            j2 = 0;
        } else {
            j2 = Math.abs(nextLong);
        }
        String l2 = Long.toString(j2, 16);
        File file2 = new File(file, l2 + ".uid");
        if (file2.createNewFile()) {
            return j2;
        }
        throw new IOException("Failed to create UID file: " + file2);
    }

    private SimpleCacheSpan o(String str, long j2, long j3) {
        SimpleCacheSpan d2;
        CachedContent f2 = this.f5019c.f(str);
        if (f2 == null) {
            return SimpleCacheSpan.g(str, j2, j3);
        }
        while (true) {
            d2 = f2.d(j2, j3);
            if (!d2.f4979e || ((File) Assertions.f(d2.f4980f)).length() == d2.f4978d) {
                return d2;
            }
            z();
        }
        return d2;
    }

    /* access modifiers changed from: private */
    public void p() {
        if (!this.f5017a.exists()) {
            try {
                m(this.f5017a);
            } catch (Cache.CacheException e2) {
                this.f5027k = e2;
                return;
            }
        }
        File[] listFiles = this.f5017a.listFiles();
        if (listFiles == null) {
            String str = "Failed to list cache directory files: " + this.f5017a;
            Log.c("SimpleCache", str);
            this.f5027k = new Cache.CacheException(str);
            return;
        }
        long r2 = r(listFiles);
        this.f5024h = r2;
        if (r2 == -1) {
            try {
                this.f5024h = n(this.f5017a);
            } catch (IOException e3) {
                String str2 = "Failed to create cache UID: " + this.f5017a;
                Log.d("SimpleCache", str2, e3);
                this.f5027k = new Cache.CacheException(str2, e3);
                return;
            }
        }
        try {
            this.f5019c.l(this.f5024h);
            CacheFileMetadataIndex cacheFileMetadataIndex = this.f5020d;
            if (cacheFileMetadataIndex != null) {
                cacheFileMetadataIndex.e(this.f5024h);
                Map<String, CacheFileMetadata> b2 = this.f5020d.b();
                q(this.f5017a, true, listFiles, b2);
                this.f5020d.g(b2.keySet());
            } else {
                q(this.f5017a, true, listFiles, (Map<String, CacheFileMetadata>) null);
            }
            this.f5019c.p();
            try {
                this.f5019c.q();
            } catch (IOException e4) {
                Log.d("SimpleCache", "Storing index file failed", e4);
            }
        } catch (IOException e5) {
            String str3 = "Failed to initialize cache indices: " + this.f5017a;
            Log.d("SimpleCache", str3, e5);
            this.f5027k = new Cache.CacheException(str3, e5);
        }
    }

    private void q(File file, boolean z2, File[] fileArr, Map<String, CacheFileMetadata> map) {
        CacheFileMetadata cacheFileMetadata;
        long j2;
        long j3;
        if (fileArr != null && fileArr.length != 0) {
            for (File file2 : fileArr) {
                String name = file2.getName();
                if (z2 && name.indexOf(46) == -1) {
                    q(file2, false, file2.listFiles(), map);
                } else if (!z2 || (!CachedContentIndex.m(name) && !name.endsWith(".uid"))) {
                    if (map != null) {
                        cacheFileMetadata = map.remove(name);
                    } else {
                        cacheFileMetadata = null;
                    }
                    if (cacheFileMetadata != null) {
                        j3 = cacheFileMetadata.f4970a;
                        j2 = cacheFileMetadata.f4971b;
                    } else {
                        j2 = -9223372036854775807L;
                        j3 = -1;
                    }
                    SimpleCacheSpan e2 = SimpleCacheSpan.e(file2, j3, j2, this.f5019c);
                    if (e2 != null) {
                        k(e2);
                    } else {
                        file2.delete();
                    }
                }
            }
        } else if (!z2) {
            file.delete();
        }
    }

    private static long r(File[] fileArr) {
        int length = fileArr.length;
        int i2 = 0;
        while (i2 < length) {
            File file = fileArr[i2];
            String name = file.getName();
            if (name.endsWith(".uid")) {
                try {
                    return w(name);
                } catch (NumberFormatException unused) {
                    Log.c("SimpleCache", "Malformed UID file: " + file);
                    file.delete();
                }
            } else {
                i2++;
            }
        }
        return -1;
    }

    private static synchronized boolean s(File file) {
        boolean add;
        synchronized (SimpleCache.class) {
            add = f5016l.add(file.getAbsoluteFile());
        }
        return add;
    }

    private void t(SimpleCacheSpan simpleCacheSpan) {
        ArrayList arrayList = this.f5021e.get(simpleCacheSpan.f4976b);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.Listener) arrayList.get(size)).b(this, simpleCacheSpan);
            }
        }
        this.f5018b.b(this, simpleCacheSpan);
    }

    private void u(CacheSpan cacheSpan) {
        ArrayList arrayList = this.f5021e.get(cacheSpan.f4976b);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.Listener) arrayList.get(size)).d(this, cacheSpan);
            }
        }
        this.f5018b.d(this, cacheSpan);
    }

    private void v(SimpleCacheSpan simpleCacheSpan, CacheSpan cacheSpan) {
        ArrayList arrayList = this.f5021e.get(simpleCacheSpan.f4976b);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.Listener) arrayList.get(size)).a(this, simpleCacheSpan, cacheSpan);
            }
        }
        this.f5018b.a(this, simpleCacheSpan, cacheSpan);
    }

    private static long w(String str) {
        return Long.parseLong(str.substring(0, str.indexOf(46)), 16);
    }

    private void y(CacheSpan cacheSpan) {
        CachedContent f2 = this.f5019c.f(cacheSpan.f4976b);
        if (f2 != null && f2.j(cacheSpan)) {
            this.f5025i -= cacheSpan.f4978d;
            if (this.f5020d != null) {
                String name = ((File) Assertions.f(cacheSpan.f4980f)).getName();
                try {
                    this.f5020d.f(name);
                } catch (IOException unused) {
                    Log.h("SimpleCache", "Failed to remove file index entry for: " + name);
                }
            }
            this.f5019c.n(f2.f4983b);
            u(cacheSpan);
        }
    }

    private void z() {
        ArrayList arrayList = new ArrayList();
        for (CachedContent e2 : this.f5019c.g()) {
            Iterator<SimpleCacheSpan> it2 = e2.e().iterator();
            while (it2.hasNext()) {
                CacheSpan next = it2.next();
                if (((File) Assertions.f(next.f4980f)).length() != next.f4978d) {
                    arrayList.add(next);
                }
            }
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            y((CacheSpan) arrayList.get(i2));
        }
    }

    public synchronized File a(String str, long j2, long j3) throws Cache.CacheException {
        boolean z2;
        CachedContent f2;
        File file;
        if (!this.f5026j) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        l();
        f2 = this.f5019c.f(str);
        Assertions.f(f2);
        Assertions.h(f2.g(j2, j3));
        if (!this.f5017a.exists()) {
            m(this.f5017a);
            z();
        }
        this.f5018b.c(this, str, j2, j3);
        file = new File(this.f5017a, Integer.toString(this.f5022f.nextInt(10)));
        if (!file.exists()) {
            m(file);
        }
        return SimpleCacheSpan.i(file, f2.f4982a, j2, System.currentTimeMillis());
    }

    public synchronized ContentMetadata b(String str) {
        boolean z2;
        if (!this.f5026j) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        return this.f5019c.h(str);
    }

    public synchronized CacheSpan c(String str, long j2, long j3) throws Cache.CacheException {
        boolean z2;
        if (!this.f5026j) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        l();
        SimpleCacheSpan o2 = o(str, j2, j3);
        if (o2.f4979e) {
            return A(str, o2);
        } else if (this.f5019c.k(str).i(j2, o2.f4978d)) {
            return o2;
        } else {
            return null;
        }
    }

    public synchronized CacheSpan d(String str, long j2, long j3) throws InterruptedException, Cache.CacheException {
        boolean z2;
        CacheSpan c2;
        if (!this.f5026j) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        l();
        while (true) {
            c2 = c(str, j2, j3);
            if (c2 == null) {
                wait();
            }
        }
        return c2;
    }

    public synchronized void e(File file, long j2) throws Cache.CacheException {
        boolean z2;
        boolean z3 = true;
        if (!this.f5026j) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        if (file.exists()) {
            if (j2 == 0) {
                file.delete();
                return;
            }
            SimpleCacheSpan simpleCacheSpan = (SimpleCacheSpan) Assertions.f(SimpleCacheSpan.f(file, j2, this.f5019c));
            CachedContent cachedContent = (CachedContent) Assertions.f(this.f5019c.f(simpleCacheSpan.f4976b));
            Assertions.h(cachedContent.g(simpleCacheSpan.f4977c, simpleCacheSpan.f4978d));
            long a2 = c.a(cachedContent.c());
            if (a2 != -1) {
                if (simpleCacheSpan.f4977c + simpleCacheSpan.f4978d > a2) {
                    z3 = false;
                }
                Assertions.h(z3);
            }
            if (this.f5020d != null) {
                try {
                    this.f5020d.h(file.getName(), simpleCacheSpan.f4978d, simpleCacheSpan.f4981g);
                } catch (IOException e2) {
                    throw new Cache.CacheException((Throwable) e2);
                } catch (IOException e3) {
                    throw new Cache.CacheException((Throwable) e3);
                }
            }
            k(simpleCacheSpan);
            this.f5019c.q();
            notifyAll();
        }
    }

    public synchronized void f(CacheSpan cacheSpan) {
        boolean z2;
        if (!this.f5026j) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        y(cacheSpan);
    }

    public synchronized void g(CacheSpan cacheSpan) {
        boolean z2;
        if (!this.f5026j) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        CachedContent cachedContent = (CachedContent) Assertions.f(this.f5019c.f(cacheSpan.f4976b));
        cachedContent.l(cacheSpan.f4977c);
        this.f5019c.n(cachedContent.f4983b);
        notifyAll();
    }

    public synchronized void h(String str, ContentMetadataMutations contentMetadataMutations) throws Cache.CacheException {
        boolean z2;
        if (!this.f5026j) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        l();
        this.f5019c.d(str, contentMetadataMutations);
        try {
            this.f5019c.q();
        } catch (IOException e2) {
            throw new Cache.CacheException((Throwable) e2);
        }
    }

    public synchronized void l() throws Cache.CacheException {
        Cache.CacheException cacheException = this.f5027k;
        if (cacheException != null) {
            throw cacheException;
        }
    }

    public synchronized void x() {
        if (!this.f5026j) {
            this.f5021e.clear();
            z();
            try {
                this.f5019c.q();
                B(this.f5017a);
            } catch (IOException e2) {
                try {
                    Log.d("SimpleCache", "Storing index file failed", e2);
                    B(this.f5017a);
                } catch (Throwable th) {
                    B(this.f5017a);
                    this.f5026j = true;
                    throw th;
                }
            }
            this.f5026j = true;
            return;
        }
        return;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SimpleCache(File file, CacheEvictor cacheEvictor, DatabaseProvider databaseProvider, byte[] bArr, boolean z2, boolean z3) {
        this(file, cacheEvictor, new CachedContentIndex(databaseProvider, file, bArr, z2, z3), (databaseProvider == null || z3) ? null : new CacheFileMetadataIndex(databaseProvider));
    }

    SimpleCache(File file, CacheEvictor cacheEvictor, CachedContentIndex cachedContentIndex, CacheFileMetadataIndex cacheFileMetadataIndex) {
        if (s(file)) {
            this.f5017a = file;
            this.f5018b = cacheEvictor;
            this.f5019c = cachedContentIndex;
            this.f5020d = cacheFileMetadataIndex;
            this.f5021e = new HashMap<>();
            this.f5022f = new Random();
            this.f5023g = cacheEvictor.requiresCacheSpanTouches();
            this.f5024h = -1;
            final ConditionVariable conditionVariable = new ConditionVariable();
            new Thread("ExoPlayer:SimpleCacheInit") {
                public void run() {
                    synchronized (SimpleCache.this) {
                        conditionVariable.open();
                        SimpleCache.this.p();
                        SimpleCache.this.f5018b.onCacheInitialized();
                    }
                }
            }.start();
            conditionVariable.block();
            return;
        }
        throw new IllegalStateException("Another SimpleCache instance uses the folder: " + file);
    }
}
