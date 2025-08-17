package com.bumptech.glide.load.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;

public final class MediaStoreFileLoader implements ModelLoader<Uri, File> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f16713a;

    public static final class Factory implements ModelLoaderFactory<Uri, File> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f16714a;

        public Factory(Context context) {
            this.f16714a = context;
        }

        public void a() {
        }

        public ModelLoader<Uri, File> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreFileLoader(this.f16714a);
        }
    }

    private static class FilePathFetcher implements DataFetcher<File> {

        /* renamed from: d  reason: collision with root package name */
        private static final String[] f16715d = {"_data"};

        /* renamed from: b  reason: collision with root package name */
        private final Context f16716b;

        /* renamed from: c  reason: collision with root package name */
        private final Uri f16717c;

        FilePathFetcher(Context context, Uri uri) {
            this.f16716b = context;
            this.f16717c = uri;
        }

        public Class<File> a() {
            return File.class;
        }

        public void b() {
        }

        public void cancel() {
        }

        public DataSource d() {
            return DataSource.LOCAL;
        }

        public void e(Priority priority, DataFetcher.DataCallback<? super File> dataCallback) {
            Cursor query = this.f16716b.getContentResolver().query(this.f16717c, f16715d, (String) null, (String[]) null, (String) null);
            String str = null;
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(str)) {
                dataCallback.c(new FileNotFoundException("Failed to find file path for: " + this.f16717c));
                return;
            }
            dataCallback.f(new File(str));
        }
    }

    public MediaStoreFileLoader(Context context) {
        this.f16713a = context;
    }

    /* renamed from: c */
    public ModelLoader.LoadData<File> b(Uri uri, int i2, int i3, Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(uri), new FilePathFetcher(this.f16713a, uri));
    }

    /* renamed from: d */
    public boolean a(Uri uri) {
        return MediaStoreUtil.b(uri);
    }
}
