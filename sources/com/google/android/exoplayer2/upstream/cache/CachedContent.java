package com.google.android.exoplayer2.upstream.cache;

import com.facebook.common.time.Clock;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.TreeSet;

final class CachedContent {

    /* renamed from: a  reason: collision with root package name */
    public final int f28597a;

    /* renamed from: b  reason: collision with root package name */
    public final String f28598b;

    /* renamed from: c  reason: collision with root package name */
    private final TreeSet<SimpleCacheSpan> f28599c;

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<Range> f28600d;

    /* renamed from: e  reason: collision with root package name */
    private DefaultContentMetadata f28601e;

    private static final class Range {

        /* renamed from: a  reason: collision with root package name */
        public final long f28602a;

        /* renamed from: b  reason: collision with root package name */
        public final long f28603b;

        public Range(long j2, long j3) {
            this.f28602a = j2;
            this.f28603b = j3;
        }

        public boolean a(long j2, long j3) {
            long j4 = this.f28603b;
            if (j4 == -1) {
                if (j2 >= this.f28602a) {
                    return true;
                }
                return false;
            } else if (j3 == -1) {
                return false;
            } else {
                long j5 = this.f28602a;
                if (j5 > j2 || j2 + j3 > j5 + j4) {
                    return false;
                }
                return true;
            }
        }

        public boolean b(long j2, long j3) {
            long j4 = this.f28602a;
            if (j4 <= j2) {
                long j5 = this.f28603b;
                if (j5 == -1 || j4 + j5 > j2) {
                    return true;
                }
                return false;
            } else if (j3 == -1 || j2 + j3 > j4) {
                return true;
            } else {
                return false;
            }
        }
    }

    public CachedContent(int i2, String str) {
        this(i2, str, DefaultContentMetadata.f28624c);
    }

    public void a(SimpleCacheSpan simpleCacheSpan) {
        this.f28599c.add(simpleCacheSpan);
    }

    public boolean b(ContentMetadataMutations contentMetadataMutations) {
        DefaultContentMetadata defaultContentMetadata = this.f28601e;
        DefaultContentMetadata e2 = defaultContentMetadata.e(contentMetadataMutations);
        this.f28601e = e2;
        return !e2.equals(defaultContentMetadata);
    }

    public long c(long j2, long j3) {
        boolean z2;
        boolean z3 = true;
        if (j2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.a(z2);
        if (j3 < 0) {
            z3 = false;
        }
        Assertions.a(z3);
        SimpleCacheSpan e2 = e(j2, j3);
        boolean b2 = e2.b();
        long j4 = Clock.MAX_TIME;
        if (b2) {
            if (!e2.c()) {
                j4 = e2.f28583d;
            }
            return -Math.min(j4, j3);
        }
        long j5 = j2 + j3;
        if (j5 >= 0) {
            j4 = j5;
        }
        long j6 = e2.f28582c + e2.f28583d;
        if (j6 < j4) {
            for (SimpleCacheSpan next : this.f28599c.tailSet(e2, false)) {
                long j7 = next.f28582c;
                if (j7 <= j6) {
                    j6 = Math.max(j6, j7 + next.f28583d);
                    if (j6 >= j4) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return Math.min(j6 - j2, j3);
    }

    public DefaultContentMetadata d() {
        return this.f28601e;
    }

    public SimpleCacheSpan e(long j2, long j3) {
        SimpleCacheSpan h2 = SimpleCacheSpan.h(this.f28598b, j2);
        SimpleCacheSpan floor = this.f28599c.floor(h2);
        if (floor != null && floor.f28582c + floor.f28583d > j2) {
            return floor;
        }
        SimpleCacheSpan ceiling = this.f28599c.ceiling(h2);
        if (ceiling != null) {
            long j4 = ceiling.f28582c - j2;
            if (j3 == -1) {
                j3 = j4;
            } else {
                j3 = Math.min(j4, j3);
            }
        }
        return SimpleCacheSpan.g(this.f28598b, j2, j3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CachedContent.class != obj.getClass()) {
            return false;
        }
        CachedContent cachedContent = (CachedContent) obj;
        if (this.f28597a != cachedContent.f28597a || !this.f28598b.equals(cachedContent.f28598b) || !this.f28599c.equals(cachedContent.f28599c) || !this.f28601e.equals(cachedContent.f28601e)) {
            return false;
        }
        return true;
    }

    public TreeSet<SimpleCacheSpan> f() {
        return this.f28599c;
    }

    public boolean g() {
        return this.f28599c.isEmpty();
    }

    public boolean h(long j2, long j3) {
        for (int i2 = 0; i2 < this.f28600d.size(); i2++) {
            if (this.f28600d.get(i2).a(j2, j3)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.f28597a * 31) + this.f28598b.hashCode()) * 31) + this.f28601e.hashCode();
    }

    public boolean i() {
        return this.f28600d.isEmpty();
    }

    public boolean j(long j2, long j3) {
        for (int i2 = 0; i2 < this.f28600d.size(); i2++) {
            if (this.f28600d.get(i2).b(j2, j3)) {
                return false;
            }
        }
        this.f28600d.add(new Range(j2, j3));
        return true;
    }

    public boolean k(CacheSpan cacheSpan) {
        if (!this.f28599c.remove(cacheSpan)) {
            return false;
        }
        File file = cacheSpan.f28585f;
        if (file == null) {
            return true;
        }
        file.delete();
        return true;
    }

    public SimpleCacheSpan l(SimpleCacheSpan simpleCacheSpan, long j2, boolean z2) {
        Assertions.g(this.f28599c.remove(simpleCacheSpan));
        File file = (File) Assertions.e(simpleCacheSpan.f28585f);
        if (z2) {
            File i2 = SimpleCacheSpan.i((File) Assertions.e(file.getParentFile()), this.f28597a, simpleCacheSpan.f28582c, j2);
            if (file.renameTo(i2)) {
                file = i2;
            } else {
                Log.i("CachedContent", "Failed to rename " + file + " to " + i2);
            }
        }
        SimpleCacheSpan d2 = simpleCacheSpan.d(file, j2);
        this.f28599c.add(d2);
        return d2;
    }

    public void m(long j2) {
        for (int i2 = 0; i2 < this.f28600d.size(); i2++) {
            if (this.f28600d.get(i2).f28602a == j2) {
                this.f28600d.remove(i2);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public CachedContent(int i2, String str, DefaultContentMetadata defaultContentMetadata) {
        this.f28597a = i2;
        this.f28598b = str;
        this.f28601e = defaultContentMetadata;
        this.f28599c = new TreeSet<>();
        this.f28600d = new ArrayList<>();
    }
}
