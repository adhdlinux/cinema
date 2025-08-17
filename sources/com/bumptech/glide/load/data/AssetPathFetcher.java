package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.IOException;

public abstract class AssetPathFetcher<T> implements DataFetcher<T> {

    /* renamed from: b  reason: collision with root package name */
    private final String f16315b;

    /* renamed from: c  reason: collision with root package name */
    private final AssetManager f16316c;

    /* renamed from: d  reason: collision with root package name */
    private T f16317d;

    public AssetPathFetcher(AssetManager assetManager, String str) {
        this.f16316c = assetManager;
        this.f16315b = str;
    }

    public void b() {
        T t2 = this.f16317d;
        if (t2 != null) {
            try {
                c(t2);
            } catch (IOException unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void c(T t2) throws IOException;

    public void cancel() {
    }

    public DataSource d() {
        return DataSource.LOCAL;
    }

    public void e(Priority priority, DataFetcher.DataCallback<? super T> dataCallback) {
        try {
            T f2 = f(this.f16316c, this.f16315b);
            this.f16317d = f2;
            dataCallback.f(f2);
        } catch (IOException e2) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e2);
            }
            dataCallback.c(e2);
        }
    }

    /* access modifiers changed from: protected */
    public abstract T f(AssetManager assetManager, String str) throws IOException;
}
