package androidx.media3.datasource.cache;

import androidx.media3.datasource.DataSpec;
import d.a;

public interface CacheKeyFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final CacheKeyFactory f4975a = new a();

    String a(DataSpec dataSpec);
}
