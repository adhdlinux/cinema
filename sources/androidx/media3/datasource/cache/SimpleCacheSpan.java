package androidx.media3.datasource.cache;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class SimpleCacheSpan extends CacheSpan {

    /* renamed from: h  reason: collision with root package name */
    private static final Pattern f5030h = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);

    /* renamed from: i  reason: collision with root package name */
    private static final Pattern f5031i = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);

    /* renamed from: j  reason: collision with root package name */
    private static final Pattern f5032j = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    private SimpleCacheSpan(String str, long j2, long j3, long j4, File file) {
        super(str, j2, j3, j4, file);
    }

    public static SimpleCacheSpan e(File file, long j2, long j3, CachedContentIndex cachedContentIndex) {
        File file2;
        String i2;
        long j4;
        long j5;
        CachedContentIndex cachedContentIndex2 = cachedContentIndex;
        String name = file.getName();
        if (!name.endsWith(".v3.exo")) {
            File file3 = file;
            File j6 = j(file, cachedContentIndex2);
            if (j6 == null) {
                return null;
            }
            file2 = j6;
            name = j6.getName();
        } else {
            file2 = file;
        }
        Matcher matcher = f5032j.matcher(name);
        if (!matcher.matches() || (i2 = cachedContentIndex2.i(Integer.parseInt((String) Assertions.f(matcher.group(1))))) == null) {
            return null;
        }
        if (j2 == -1) {
            j4 = file2.length();
        } else {
            j4 = j2;
        }
        if (j4 == 0) {
            return null;
        }
        long parseLong = Long.parseLong((String) Assertions.f(matcher.group(2)));
        if (j3 == -9223372036854775807L) {
            j5 = Long.parseLong((String) Assertions.f(matcher.group(3)));
        } else {
            j5 = j3;
        }
        return new SimpleCacheSpan(i2, parseLong, j4, j5, file2);
    }

    public static SimpleCacheSpan f(File file, long j2, CachedContentIndex cachedContentIndex) {
        return e(file, j2, -9223372036854775807L, cachedContentIndex);
    }

    public static SimpleCacheSpan g(String str, long j2, long j3) {
        return new SimpleCacheSpan(str, j2, j3, -9223372036854775807L, (File) null);
    }

    public static SimpleCacheSpan h(String str, long j2) {
        return new SimpleCacheSpan(str, j2, -1, -9223372036854775807L, (File) null);
    }

    public static File i(File file, int i2, long j2, long j3) {
        return new File(file, i2 + "." + j2 + "." + j3 + ".v3.exo");
    }

    private static File j(File file, CachedContentIndex cachedContentIndex) {
        String str;
        String name = file.getName();
        Matcher matcher = f5031i.matcher(name);
        if (matcher.matches()) {
            str = Util.s1((String) Assertions.f(matcher.group(1)));
        } else {
            matcher = f5030h.matcher(name);
            if (matcher.matches()) {
                str = (String) Assertions.f(matcher.group(1));
            } else {
                str = null;
            }
        }
        if (str == null) {
            return null;
        }
        File i2 = i((File) Assertions.j(file.getParentFile()), cachedContentIndex.e(str), Long.parseLong((String) Assertions.f(matcher.group(2))), Long.parseLong((String) Assertions.f(matcher.group(3))));
        if (!file.renameTo(i2)) {
            return null;
        }
        return i2;
    }

    public SimpleCacheSpan d(File file, long j2) {
        Assertions.h(this.f4979e);
        return new SimpleCacheSpan(this.f4976b, this.f4977c, this.f4978d, j2, file);
    }
}
