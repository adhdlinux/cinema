package androidx.media3.exoplayer.source;

import androidx.media3.datasource.DataSource;
import com.google.common.base.Supplier;

public final /* synthetic */ class g implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Class f7280b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DataSource.Factory f7281c;

    public /* synthetic */ g(Class cls, DataSource.Factory factory) {
        this.f7280b = cls;
        this.f7281c = factory;
    }

    public final Object get() {
        return DefaultMediaSourceFactory.o(this.f7280b, this.f7281c);
    }
}
