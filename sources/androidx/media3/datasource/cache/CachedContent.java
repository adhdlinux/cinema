package androidx.media3.datasource.cache;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.TreeSet;

final class CachedContent {

    /* renamed from: a  reason: collision with root package name */
    public final int f4982a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4983b;

    /* renamed from: c  reason: collision with root package name */
    private final TreeSet<SimpleCacheSpan> f4984c;

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<Range> f4985d;

    /* renamed from: e  reason: collision with root package name */
    private DefaultContentMetadata f4986e;

    private static final class Range {

        /* renamed from: a  reason: collision with root package name */
        public final long f4987a;

        /* renamed from: b  reason: collision with root package name */
        public final long f4988b;

        public Range(long j2, long j3) {
            this.f4987a = j2;
            this.f4988b = j3;
        }

        public boolean a(long j2, long j3) {
            long j4 = this.f4988b;
            if (j4 == -1) {
                if (j2 >= this.f4987a) {
                    return true;
                }
                return false;
            } else if (j3 == -1) {
                return false;
            } else {
                long j5 = this.f4987a;
                if (j5 > j2 || j2 + j3 > j5 + j4) {
                    return false;
                }
                return true;
            }
        }

        public boolean b(long j2, long j3) {
            long j4 = this.f4987a;
            if (j4 <= j2) {
                long j5 = this.f4988b;
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
        this(i2, str, DefaultContentMetadata.f5009c);
    }

    public void a(SimpleCacheSpan simpleCacheSpan) {
        this.f4984c.add(simpleCacheSpan);
    }

    public boolean b(ContentMetadataMutations contentMetadataMutations) {
        DefaultContentMetadata defaultContentMetadata = this.f4986e;
        DefaultContentMetadata e2 = defaultContentMetadata.e(contentMetadataMutations);
        this.f4986e = e2;
        return !e2.equals(defaultContentMetadata);
    }

    public DefaultContentMetadata c() {
        return this.f4986e;
    }

    public SimpleCacheSpan d(long j2, long j3) {
        SimpleCacheSpan h2 = SimpleCacheSpan.h(this.f4983b, j2);
        SimpleCacheSpan floor = this.f4984c.floor(h2);
        if (floor != null && floor.f4977c + floor.f4978d > j2) {
            return floor;
        }
        SimpleCacheSpan ceiling = this.f4984c.ceiling(h2);
        if (ceiling != null) {
            long j4 = ceiling.f4977c - j2;
            if (j3 == -1) {
                j3 = j4;
            } else {
                j3 = Math.min(j4, j3);
            }
        }
        return SimpleCacheSpan.g(this.f4983b, j2, j3);
    }

    public TreeSet<SimpleCacheSpan> e() {
        return this.f4984c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CachedContent.class != obj.getClass()) {
            return false;
        }
        CachedContent cachedContent = (CachedContent) obj;
        if (this.f4982a != cachedContent.f4982a || !this.f4983b.equals(cachedContent.f4983b) || !this.f4984c.equals(cachedContent.f4984c) || !this.f4986e.equals(cachedContent.f4986e)) {
            return false;
        }
        return true;
    }

    public boolean f() {
        return this.f4984c.isEmpty();
    }

    public boolean g(long j2, long j3) {
        for (int i2 = 0; i2 < this.f4985d.size(); i2++) {
            if (this.f4985d.get(i2).a(j2, j3)) {
                return true;
            }
        }
        return false;
    }

    public boolean h() {
        return this.f4985d.isEmpty();
    }

    public int hashCode() {
        return (((this.f4982a * 31) + this.f4983b.hashCode()) * 31) + this.f4986e.hashCode();
    }

    public boolean i(long j2, long j3) {
        for (int i2 = 0; i2 < this.f4985d.size(); i2++) {
            if (this.f4985d.get(i2).b(j2, j3)) {
                return false;
            }
        }
        this.f4985d.add(new Range(j2, j3));
        return true;
    }

    public boolean j(CacheSpan cacheSpan) {
        if (!this.f4984c.remove(cacheSpan)) {
            return false;
        }
        File file = cacheSpan.f4980f;
        if (file == null) {
            return true;
        }
        file.delete();
        return true;
    }

    public SimpleCacheSpan k(SimpleCacheSpan simpleCacheSpan, long j2, boolean z2) {
        Assertions.h(this.f4984c.remove(simpleCacheSpan));
        File file = (File) Assertions.f(simpleCacheSpan.f4980f);
        if (z2) {
            File i2 = SimpleCacheSpan.i((File) Assertions.f(file.getParentFile()), this.f4982a, simpleCacheSpan.f4977c, j2);
            if (file.renameTo(i2)) {
                file = i2;
            } else {
                Log.h("CachedContent", "Failed to rename " + file + " to " + i2);
            }
        }
        SimpleCacheSpan d2 = simpleCacheSpan.d(file, j2);
        this.f4984c.add(d2);
        return d2;
    }

    public void l(long j2) {
        for (int i2 = 0; i2 < this.f4985d.size(); i2++) {
            if (this.f4985d.get(i2).f4987a == j2) {
                this.f4985d.remove(i2);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public CachedContent(int i2, String str, DefaultContentMetadata defaultContentMetadata) {
        this.f4982a = i2;
        this.f4983b = str;
        this.f4986e = defaultContentMetadata;
        this.f4984c = new TreeSet<>();
        this.f4985d = new ArrayList<>();
    }
}
