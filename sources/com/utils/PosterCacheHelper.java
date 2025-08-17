package com.utils;

import com.vincentbrison.openlibraries.android.dualcache.Builder;
import com.vincentbrison.openlibraries.android.dualcache.CacheSerializer;
import com.vincentbrison.openlibraries.android.dualcache.DualCache;

public class PosterCacheHelper {

    /* renamed from: d  reason: collision with root package name */
    private static PosterCacheHelper f37592d;

    /* renamed from: a  reason: collision with root package name */
    private long f37593a = Utils.D(Utils.v().getCacheDir());

    /* renamed from: b  reason: collision with root package name */
    private String f37594b = "poster_url_cache";

    /* renamed from: c  reason: collision with root package name */
    private DualCache<String> f37595c = new Builder(this.f37594b, 1).b().f((int) this.f37593a, true, new CacheSerializer<String>() {
        /* renamed from: c */
        public String a(String str) {
            return str;
        }

        /* renamed from: d */
        public String b(String str) {
            return str;
        }
    }, Utils.v()).d().a();

    PosterCacheHelper() {
    }

    public static PosterCacheHelper d() {
        if (f37592d == null) {
            f37592d = new PosterCacheHelper();
        }
        return f37592d;
    }

    public synchronized void a(long j2, long j3, String str) {
        String str2 = "";
        String str3 = "";
        if (j2 > 0) {
            str2 = "tmdb-poster-" + j2;
            str3 = "tmdb-backdrop-" + j2;
        }
        if (j3 > 0) {
            str2 = "tvdb-poster-" + j3;
            str3 = "tvdb-backdrop-" + j3;
        }
        if (str != null) {
            str2 = "imdb-poster-" + str;
            str3 = "imdb-backdrop-" + str;
        }
        if (!str2.isEmpty()) {
            this.f37595c.b(str2);
            this.f37595c.b(str3);
        }
    }

    public synchronized String b(long j2, long j3, String str) {
        String str2;
        str2 = "";
        if (j2 > 0) {
            str2 = "tmdb-backdrop-" + j2;
        } else if (j3 > 0) {
            str2 = "tvdb-backdrop-" + j3;
        } else if (str != null) {
            str2 = "imdb-backdrop-" + str;
        }
        return this.f37595c.c(str2);
    }

    public synchronized String c(long j2, long j3, String str) {
        String str2;
        str2 = "";
        if (j2 > 0) {
            str2 = "tmdb-genres-" + j2;
        } else if (j3 > 0) {
            str2 = "tvdb-genres-" + j3;
        } else if (str != null) {
            str2 = "imdb-genres-" + str;
        }
        return this.f37595c.c(str2);
    }

    public synchronized String e(long j2, long j3, String str) {
        String str2;
        str2 = "";
        if (j2 > 0) {
            str2 = "tmdb-poster-" + j2;
        } else if (j3 > 0) {
            str2 = "tvdb-poster-" + j3;
        } else if (str != null) {
            str2 = "imdb-poster-" + str;
        }
        return this.f37595c.c(str2);
    }

    public synchronized String f(long j2, long j3, String str) {
        String str2;
        str2 = "";
        if (j2 > 0) {
            str2 = "tmdb-release-" + j2;
        } else if (j3 > 0) {
            str2 = "tvdb-release-" + j3;
        } else if (str != null) {
            str2 = "imdb-release-" + str;
        }
        return this.f37595c.c(str2);
    }

    public synchronized void g(long j2, long j3, String str, String str2, String str3) {
        if (j2 > 0) {
            try {
                String str4 = "tmdb-poster-" + j2;
                if (str2 != null && !this.f37595c.a(str4)) {
                    this.f37595c.g(str4, str2);
                }
                String str5 = "tmdb-backdrop-" + j2;
                if (str3 != null && !this.f37595c.a(str5)) {
                    this.f37595c.g(str5, str3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (j3 > 0) {
            String str6 = "tvdb-poster-" + j3;
            if (str2 != null && !this.f37595c.a(str6)) {
                this.f37595c.g(str6, str2);
            }
            String str7 = "tvdb-backdrop-" + j3;
            if (str3 != null && !this.f37595c.a(str7)) {
                this.f37595c.g(str7, str3);
            }
        }
        if (str != null) {
            String str8 = "imdb-poster-" + str;
            if (str2 != null && !this.f37595c.a(str8)) {
                this.f37595c.g(str8, str2);
            }
            String str9 = "imdb-backdrop-" + str;
            if (str3 != null && !this.f37595c.a(str9)) {
                this.f37595c.g(str9, str3);
            }
        }
    }

    public synchronized void h(long j2, long j3, String str, String str2, String str3) {
        if (j2 > 0) {
            try {
                String str4 = "tmdb-release-" + j2;
                if (str2 != null && !this.f37595c.a(str4)) {
                    this.f37595c.g(str4, str2);
                }
                String str5 = "tmdb-genres-" + j2;
                if (str3 != null && !this.f37595c.a(str5)) {
                    this.f37595c.g(str5, str3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (j3 > 0) {
            String str6 = "tvdb-release-" + j3;
            if (str2 != null && !this.f37595c.a(str6)) {
                this.f37595c.g(str6, str2);
            }
            String str7 = "tvdb-genres-" + j3;
            if (str3 != null && !this.f37595c.a(str7)) {
                this.f37595c.g(str7, str3);
            }
        }
        if (str != null) {
            String str8 = "imdb-release-" + str;
            if (str2 != null && !this.f37595c.a(str8)) {
                this.f37595c.g(str8, str2);
            }
            String str9 = "imdb-genres-" + str;
            if (str3 != null && !this.f37595c.a(str9)) {
                this.f37595c.g(str9, str3);
            }
        }
    }
}
