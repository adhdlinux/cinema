package androidx.media3.exoplayer.source;

import androidx.media3.datasource.DataSource;
import com.google.common.base.Supplier;

public final /* synthetic */ class e implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Class f7276b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DataSource.Factory f7277c;

    public /* synthetic */ e(Class cls, DataSource.Factory factory) {
        this.f7276b = cls;
        this.f7277c = factory;
    }

    public final Object get() {
        return DefaultMediaSourceFactory.o(this.f7276b, this.f7277c);
    }
}
