package com.google.android.exoplayer2.upstream.cache;

import android.os.ConditionVariable;
import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Random;
import java.util.TreeSet;
import v0.c;

public final class SimpleCache implements Cache {

    /* renamed from: l  reason: collision with root package name */
    private static final HashSet<File> f28628l = new HashSet<>();

    /* renamed from: a  reason: collision with root package name */
    private final File f28629a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final CacheEvictor f28630b;

    /* renamed from: c  reason: collision with root package name */
    private final CachedContentIndex f28631c;

    /* renamed from: d  reason: collision with root package name */
    private final CacheFileMetadataIndex f28632d;

    /* renamed from: e  reason: collision with root package name */
    private final HashMap<String, ArrayList<Cache.Listener>> f28633e;

    /* renamed from: f  reason: collision with root package name */
    private final Random f28634f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f28635g;

    /* renamed from: h  reason: collision with root package name */
    private long f28636h;

    /* renamed from: i  reason: collision with root package name */
    private long f28637i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f28638j;

    /* renamed from: k  reason: collision with root package name */
    private Cache.CacheException f28639k;

    public SimpleCache(File file, CacheEvictor cacheEvictor, DatabaseProvider databaseProvider) {
        this(file, cacheEvictor, databaseProvider, (byte[]) null, false, false);
    }

    private static long A(String str) {
        return Long.parseLong(str.substring(0, str.indexOf(46)), 16);
    }

    private void B(CacheSpan cacheSpan) {
        CachedContent g2 = this.f28631c.g(cacheSpan.f28581b);
        if (g2 != null && g2.k(cacheSpan)) {
            this.f28637i -= cacheSpan.f28583d;
            if (this.f28632d != null) {
                String name = cacheSpan.f28585f.getName();
                try {
                    this.f28632d.f(name);
                } catch (IOException unused) {
                    Log.i("SimpleCache", "Failed to remove file index entry for: " + name);
                }
            }
            this.f28631c.p(g2.f28598b);
            y(cacheSpan);
        }
    }

    private void C() {
        ArrayList arrayList = new ArrayList();
        for (CachedContent f2 : this.f28631c.h()) {
            Iterator<SimpleCacheSpan> it2 = f2.f().iterator();
            while (it2.hasNext()) {
                CacheSpan next = it2.next();
                if (next.f28585f.length() != next.f28583d) {
                    arrayList.add(next);
                }
            }
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            B((CacheSpan) arrayList.get(i2));
        }
    }

    private SimpleCacheSpan D(String str, SimpleCacheSpan simpleCacheSpan) {
        boolean z2;
        if (!this.f28635g) {
            return simpleCacheSpan;
        }
        String name = ((File) Assertions.e(simpleCacheSpan.f28585f)).getName();
        long j2 = simpleCacheSpan.f28583d;
        long currentTimeMillis = System.currentTimeMillis();
        CacheFileMetadataIndex cacheFileMetadataIndex = this.f28632d;
        if (cacheFileMetadataIndex != null) {
            try {
                cacheFileMetadataIndex.h(name, j2, currentTimeMillis);
            } catch (IOException unused) {
                Log.i("SimpleCache", "Failed to update index with new touch timestamp.");
            }
            z2 = false;
        } else {
            z2 = true;
        }
        SimpleCacheSpan l2 = this.f28631c.g(str).l(simpleCacheSpan, currentTimeMillis, z2);
        z(simpleCacheSpan, l2);
        return l2;
    }

    private void n(SimpleCacheSpan simpleCacheSpan) {
        this.f28631c.m(simpleCacheSpan.f28581b).a(simpleCacheSpan);
        this.f28637i += simpleCacheSpan.f28583d;
        x(simpleCacheSpan);
    }

    private static void p(File file) throws Cache.CacheException {
        if (!file.mkdirs() && !file.isDirectory()) {
            String str = "Failed to create cache directory: " + file;
            Log.c("SimpleCache", str);
            throw new Cache.CacheException(str);
        }
    }

    private static long q(File file) throws IOException {
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

    private SimpleCacheSpan s(String str, long j2, long j3) {
        SimpleCacheSpan e2;
        CachedContent g2 = this.f28631c.g(str);
        if (g2 == null) {
            return SimpleCacheSpan.g(str, j2, j3);
        }
        while (true) {
            e2 = g2.e(j2, j3);
            if (!e2.f28584e || e2.f28585f.length() == e2.f28583d) {
                return e2;
            }
            C();
        }
        return e2;
    }

    /* access modifiers changed from: private */
    public void t() {
        if (!this.f28629a.exists()) {
            try {
                p(this.f28629a);
            } catch (Cache.CacheException e2) {
                this.f28639k = e2;
                return;
            }
        }
        File[] listFiles = this.f28629a.listFiles();
        if (listFiles == null) {
            String str = "Failed to list cache directory files: " + this.f28629a;
            Log.c("SimpleCache", str);
            this.f28639k = new Cache.CacheException(str);
            return;
        }
        long v2 = v(listFiles);
        this.f28636h = v2;
        if (v2 == -1) {
            try {
                this.f28636h = q(this.f28629a);
            } catch (IOException e3) {
                String str2 = "Failed to create cache UID: " + this.f28629a;
                Log.d("SimpleCache", str2, e3);
                this.f28639k = new Cache.CacheException(str2, e3);
                return;
            }
        }
        try {
            this.f28631c.n(this.f28636h);
            CacheFileMetadataIndex cacheFileMetadataIndex = this.f28632d;
            if (cacheFileMetadataIndex != null) {
                cacheFileMetadataIndex.e(this.f28636h);
                Map<String, CacheFileMetadata> b2 = this.f28632d.b();
                u(this.f28629a, true, listFiles, b2);
                this.f28632d.g(b2.keySet());
            } else {
                u(this.f28629a, true, listFiles, (Map<String, CacheFileMetadata>) null);
            }
            this.f28631c.r();
            try {
                this.f28631c.s();
            } catch (IOException e4) {
                Log.d("SimpleCache", "Storing index file failed", e4);
            }
        } catch (IOException e5) {
            String str3 = "Failed to initialize cache indices: " + this.f28629a;
            Log.d("SimpleCache", str3, e5);
            this.f28639k = new Cache.CacheException(str3, e5);
        }
    }

    private void u(File file, boolean z2, File[] fileArr, Map<String, CacheFileMetadata> map) {
        CacheFileMetadata cacheFileMetadata;
        long j2;
        long j3;
        if (fileArr != null && fileArr.length != 0) {
            for (File file2 : fileArr) {
                String name = file2.getName();
                if (z2 && name.indexOf(46) == -1) {
                    u(file2, false, file2.listFiles(), map);
                } else if (!z2 || (!CachedContentIndex.o(name) && !name.endsWith(".uid"))) {
                    if (map != null) {
                        cacheFileMetadata = map.remove(name);
                    } else {
                        cacheFileMetadata = null;
                    }
                    if (cacheFileMetadata != null) {
                        j3 = cacheFileMetadata.f28575a;
                        j2 = cacheFileMetadata.f28576b;
                    } else {
                        j2 = -9223372036854775807L;
                        j3 = -1;
                    }
                    SimpleCacheSpan e2 = SimpleCacheSpan.e(file2, j3, j2, this.f28631c);
                    if (e2 != null) {
                        n(e2);
                    } else {
                        file2.delete();
                    }
                }
            }
        } else if (!z2) {
            file.delete();
        }
    }

    private static long v(File[] fileArr) {
        int length = fileArr.length;
        int i2 = 0;
        while (i2 < length) {
            File file = fileArr[i2];
            String name = file.getName();
            if (name.endsWith(".uid")) {
                try {
                    return A(name);
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

    private static synchronized boolean w(File file) {
        boolean add;
        synchronized (SimpleCache.class) {
            add = f28628l.add(file.getAbsoluteFile());
        }
        return add;
    }

    private void x(SimpleCacheSpan simpleCacheSpan) {
        ArrayList arrayList = this.f28633e.get(simpleCacheSpan.f28581b);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.Listener) arrayList.get(size)).onSpanAdded(this, simpleCacheSpan);
            }
        }
        this.f28630b.onSpanAdded(this, simpleCacheSpan);
    }

    private void y(CacheSpan cacheSpan) {
        ArrayList arrayList = this.f28633e.get(cacheSpan.f28581b);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.Listener) arrayList.get(size)).onSpanRemoved(this, cacheSpan);
            }
        }
        this.f28630b.onSpanRemoved(this, cacheSpan);
    }

    private void z(SimpleCacheSpan simpleCacheSpan, CacheSpan cacheSpan) {
        ArrayList arrayList = this.f28633e.get(simpleCacheSpan.f28581b);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Cache.Listener) arrayList.get(size)).onSpanTouched(this, simpleCacheSpan, cacheSpan);
            }
        }
        this.f28630b.onSpanTouched(this, simpleCacheSpan, cacheSpan);
    }

    public synchronized File a(String str, long j2, long j3) throws Cache.CacheException {
        boolean z2;
        CachedContent g2;
        File file;
        if (!this.f28638j) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        o();
        g2 = this.f28631c.g(str);
        Assertions.e(g2);
        Assertions.g(g2.h(j2, j3));
        if (!this.f28629a.exists()) {
            p(this.f28629a);
            C();
        }
        this.f28630b.onStartFile(this, str, j2, j3);
        file = new File(this.f28629a, Integer.toString(this.f28634f.nextInt(10)));
        if (!file.exists()) {
            p(file);
        }
        return SimpleCacheSpan.i(file, g2.f28597a, j2, System.currentTimeMillis());
    }

    public synchronized ContentMetadata b(String str) {
        boolean z2;
        if (!this.f28638j) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        return this.f28631c.j(str);
    }

    public synchronized CacheSpan c(String str, long j2, long j3) throws Cache.CacheException {
        boolean z2;
        if (!this.f28638j) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        o();
        SimpleCacheSpan s2 = s(str, j2, j3);
        if (s2.f28584e) {
            return D(str, s2);
        } else if (this.f28631c.m(str).j(j2, s2.f28583d)) {
            return s2;
        } else {
            return null;
        }
    }

    public synchronized CacheSpan d(String str, long j2, long j3) throws InterruptedException, Cache.CacheException {
        boolean z2;
        CacheSpan c2;
        if (!this.f28638j) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        o();
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
        if (!this.f28638j) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        if (file.exists()) {
            if (j2 == 0) {
                file.delete();
                return;
            }
            SimpleCacheSpan simpleCacheSpan = (SimpleCacheSpan) Assertions.e(SimpleCacheSpan.f(file, j2, this.f28631c));
            CachedContent cachedContent = (CachedContent) Assertions.e(this.f28631c.g(simpleCacheSpan.f28581b));
            Assertions.g(cachedContent.h(simpleCacheSpan.f28582c, simpleCacheSpan.f28583d));
            long a2 = c.a(cachedContent.d());
            if (a2 != -1) {
                if (simpleCacheSpan.f28582c + simpleCacheSpan.f28583d > a2) {
                    z3 = false;
                }
                Assertions.g(z3);
            }
            if (this.f28632d != null) {
                try {
                    this.f28632d.h(file.getName(), simpleCacheSpan.f28583d, simpleCacheSpan.f28586g);
                } catch (IOException e2) {
                    throw new Cache.CacheException((Throwable) e2);
                } catch (IOException e3) {
                    throw new Cache.CacheException((Throwable) e3);
                }
            }
            n(simpleCacheSpan);
            this.f28631c.s();
            notifyAll();
        }
    }

    public synchronized void f(String str, ContentMetadataMutations contentMetadataMutations) throws Cache.CacheException {
        boolean z2;
        if (!this.f28638j) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        o();
        this.f28631c.e(str, contentMetadataMutations);
        try {
            this.f28631c.s();
        } catch (IOException e2) {
            throw new Cache.CacheException((Throwable) e2);
        }
    }

    public synchronized long g(String str, long j2, long j3) {
        long j4;
        long j5;
        long j6 = Clock.MAX_TIME;
        if (j3 == -1) {
            j4 = Long.MAX_VALUE;
        } else {
            j4 = j3 + j2;
        }
        if (j4 >= 0) {
            j6 = j4;
        }
        j5 = 0;
        while (j2 < j6) {
            long h2 = h(str, j2, j6 - j2);
            if (h2 > 0) {
                j5 += h2;
            } else {
                h2 = -h2;
            }
            j2 += h2;
        }
        return j5;
    }

    public synchronized long h(String str, long j2, long j3) {
        boolean z2;
        long j4;
        if (!this.f28638j) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        if (j3 == -1) {
            j3 = Clock.MAX_TIME;
        }
        CachedContent g2 = this.f28631c.g(str);
        if (g2 != null) {
            j4 = g2.c(j2, j3);
        } else {
            j4 = -j3;
        }
        return j4;
    }

    public synchronized void i(CacheSpan cacheSpan) {
        boolean z2;
        if (!this.f28638j) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        CachedContent cachedContent = (CachedContent) Assertions.e(this.f28631c.g(cacheSpan.f28581b));
        cachedContent.m(cacheSpan.f28582c);
        this.f28631c.p(cachedContent.f28598b);
        notifyAll();
    }

    public synchronized void j(CacheSpan cacheSpan) {
        boolean z2;
        if (!this.f28638j) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        B(cacheSpan);
    }

    public synchronized void k(String str) {
        boolean z2;
        if (!this.f28638j) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        for (CacheSpan B : r(str)) {
            B(B);
        }
    }

    public synchronized void o() throws Cache.CacheException {
        Cache.CacheException cacheException = this.f28639k;
        if (cacheException != null) {
            throw cacheException;
        }
    }

    public synchronized NavigableSet<CacheSpan> r(String str) {
        boolean z2;
        TreeSet treeSet;
        if (!this.f28638j) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        CachedContent g2 = this.f28631c.g(str);
        if (g2 != null) {
            if (!g2.g()) {
                treeSet = new TreeSet(g2.f());
            }
        }
        treeSet = new TreeSet();
        return treeSet;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SimpleCache(File file, CacheEvictor cacheEvictor, DatabaseProvider databaseProvider, byte[] bArr, boolean z2, boolean z3) {
        this(file, cacheEvictor, new CachedContentIndex(databaseProvider, file, bArr, z2, z3), (databaseProvider == null || z3) ? null : new CacheFileMetadataIndex(databaseProvider));
    }

    SimpleCache(File file, CacheEvictor cacheEvictor, CachedContentIndex cachedContentIndex, CacheFileMetadataIndex cacheFileMetadataIndex) {
        if (w(file)) {
            this.f28629a = file;
            this.f28630b = cacheEvictor;
            this.f28631c = cachedContentIndex;
            this.f28632d = cacheFileMetadataIndex;
            this.f28633e = new HashMap<>();
            this.f28634f = new Random();
            this.f28635g = cacheEvictor.requiresCacheSpanTouches();
            this.f28636h = -1;
            final ConditionVariable conditionVariable = new ConditionVariable();
            new Thread("ExoPlayer:SimpleCacheInit") {
                public void run() {
                    synchronized (SimpleCache.this) {
                        conditionVariable.open();
                        SimpleCache.this.t();
                        SimpleCache.this.f28630b.onCacheInitialized();
                    }
                }
            }.start();
            conditionVariable.block();
            return;
        }
        throw new IllegalStateException("Another SimpleCache instance uses the folder: " + file);
    }
}
