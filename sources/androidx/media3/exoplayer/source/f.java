package androidx.media3.exoplayer.source;

import androidx.media3.datasource.DataSource;
import com.google.common.base.Supplier;

public final /* synthetic */ class f implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Class f7278b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DataSource.Factory f7279c;

    public /* synthetic */ f(Class cls, DataSource.Factory factory) {
        this.f7278b = cls;
        this.f7279c = factory;
    }

    public final Object get() {
        return DefaultMediaSourceFactory.o(this.f7278b, this.f7279c);
    }
}
