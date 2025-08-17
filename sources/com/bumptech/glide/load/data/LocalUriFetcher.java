package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class LocalUriFetcher<T> implements DataFetcher<T> {

    /* renamed from: b  reason: collision with root package name */
    private final Uri f16339b;

    /* renamed from: c  reason: collision with root package name */
    private final ContentResolver f16340c;

    /* renamed from: d  reason: collision with root package name */
    private T f16341d;

    public LocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        this.f16340c = contentResolver;
        this.f16339b = uri;
    }

    public void b() {
        T t2 = this.f16341d;
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

    public final void e(Priority priority, DataFetcher.DataCallback<? super T> dataCallback) {
        try {
            T f2 = f(this.f16339b, this.f16340c);
            this.f16341d = f2;
            dataCallback.f(f2);
        } catch (FileNotFoundException e2) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e2);
            }
            dataCallback.c(e2);
        }
    }

    /* access modifiers changed from: protected */
    public abstract T f(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;
}
