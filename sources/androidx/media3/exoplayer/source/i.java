package androidx.media3.exoplayer.source;

import androidx.media3.datasource.DataSource;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import com.google.common.base.Supplier;

public final /* synthetic */ class i implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultMediaSourceFactory.DelegateFactoryLoader f7283b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DataSource.Factory f7284c;

    public /* synthetic */ i(DefaultMediaSourceFactory.DelegateFactoryLoader delegateFactoryLoader, DataSource.Factory factory) {
        this.f7283b = delegateFactoryLoader;
        this.f7284c = factory;
    }

    public final Object get() {
        return this.f7283b.k(this.f7284c);
    }
}
