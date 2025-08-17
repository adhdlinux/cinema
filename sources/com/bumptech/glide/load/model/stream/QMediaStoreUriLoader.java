package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class QMediaStoreUriLoader<DataT> implements ModelLoader<Uri, DataT> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f16778a;

    /* renamed from: b  reason: collision with root package name */
    private final ModelLoader<File, DataT> f16779b;

    /* renamed from: c  reason: collision with root package name */
    private final ModelLoader<Uri, DataT> f16780c;

    /* renamed from: d  reason: collision with root package name */
    private final Class<DataT> f16781d;

    private static abstract class Factory<DataT> implements ModelLoaderFactory<Uri, DataT> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f16782a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<DataT> f16783b;

        Factory(Context context, Class<DataT> cls) {
            this.f16782a = context;
            this.f16783b = cls;
        }

        public final void a() {
        }

        public final ModelLoader<Uri, DataT> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new QMediaStoreUriLoader(this.f16782a, multiModelLoaderFactory.d(File.class, this.f16783b), multiModelLoaderFactory.d(Uri.class, this.f16783b), this.f16783b);
        }
    }

    public static final class FileDescriptorFactory extends Factory<ParcelFileDescriptor> {
        public FileDescriptorFactory(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    public static final class InputStreamFactory extends Factory<InputStream> {
        public InputStreamFactory(Context context) {
            super(context, InputStream.class);
        }
    }

    private static final class QMediaStoreUriFetcher<DataT> implements DataFetcher<DataT> {

        /* renamed from: l  reason: collision with root package name */
        private static final String[] f16784l = {"_data"};

        /* renamed from: b  reason: collision with root package name */
        private final Context f16785b;

        /* renamed from: c  reason: collision with root package name */
        private final ModelLoader<File, DataT> f16786c;

        /* renamed from: d  reason: collision with root package name */
        private final ModelLoader<Uri, DataT> f16787d;

        /* renamed from: e  reason: collision with root package name */
        private final Uri f16788e;

        /* renamed from: f  reason: collision with root package name */
        private final int f16789f;

        /* renamed from: g  reason: collision with root package name */
        private final int f16790g;

        /* renamed from: h  reason: collision with root package name */
        private final Options f16791h;

        /* renamed from: i  reason: collision with root package name */
        private final Class<DataT> f16792i;

        /* renamed from: j  reason: collision with root package name */
        private volatile boolean f16793j;

        /* renamed from: k  reason: collision with root package name */
        private volatile DataFetcher<DataT> f16794k;

        QMediaStoreUriFetcher(Context context, ModelLoader<File, DataT> modelLoader, ModelLoader<Uri, DataT> modelLoader2, Uri uri, int i2, int i3, Options options, Class<DataT> cls) {
            this.f16785b = context.getApplicationContext();
            this.f16786c = modelLoader;
            this.f16787d = modelLoader2;
            this.f16788e = uri;
            this.f16789f = i2;
            this.f16790g = i3;
            this.f16791h = options;
            this.f16792i = cls;
        }

        private ModelLoader.LoadData<DataT> c() throws FileNotFoundException {
            Uri uri;
            if (Environment.isExternalStorageLegacy()) {
                return this.f16786c.b(h(this.f16788e), this.f16789f, this.f16790g, this.f16791h);
            }
            if (g()) {
                uri = MediaStore.setRequireOriginal(this.f16788e);
            } else {
                uri = this.f16788e;
            }
            return this.f16787d.b(uri, this.f16789f, this.f16790g, this.f16791h);
        }

        private DataFetcher<DataT> f() throws FileNotFoundException {
            ModelLoader.LoadData c2 = c();
            if (c2 != null) {
                return c2.f16726c;
            }
            return null;
        }

        private boolean g() {
            return this.f16785b.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
        }

        private File h(Uri uri) throws FileNotFoundException {
            Cursor cursor = null;
            try {
                cursor = this.f16785b.getContentResolver().query(uri, f16784l, (String) null, (String[]) null, (String) null);
                if (cursor == null || !cursor.moveToFirst()) {
                    throw new FileNotFoundException("Failed to media store entry for: " + uri);
                }
                String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                if (!TextUtils.isEmpty(string)) {
                    File file = new File(string);
                    cursor.close();
                    return file;
                }
                throw new FileNotFoundException("File path was empty in media store for: " + uri);
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }

        public Class<DataT> a() {
            return this.f16792i;
        }

        public void b() {
            DataFetcher<DataT> dataFetcher = this.f16794k;
            if (dataFetcher != null) {
                dataFetcher.b();
            }
        }

        public void cancel() {
            this.f16793j = true;
            DataFetcher<DataT> dataFetcher = this.f16794k;
            if (dataFetcher != null) {
                dataFetcher.cancel();
            }
        }

        public DataSource d() {
            return DataSource.LOCAL;
        }

        public void e(Priority priority, DataFetcher.DataCallback<? super DataT> dataCallback) {
            try {
                DataFetcher<DataT> f2 = f();
                if (f2 == null) {
                    dataCallback.c(new IllegalArgumentException("Failed to build fetcher for: " + this.f16788e));
                    return;
                }
                this.f16794k = f2;
                if (this.f16793j) {
                    cancel();
                } else {
                    f2.e(priority, dataCallback);
                }
            } catch (FileNotFoundException e2) {
                dataCallback.c(e2);
            }
        }
    }

    QMediaStoreUriLoader(Context context, ModelLoader<File, DataT> modelLoader, ModelLoader<Uri, DataT> modelLoader2, Class<DataT> cls) {
        this.f16778a = context.getApplicationContext();
        this.f16779b = modelLoader;
        this.f16780c = modelLoader2;
        this.f16781d = cls;
    }

    /* renamed from: c */
    public ModelLoader.LoadData<DataT> b(Uri uri, int i2, int i3, Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(uri), new QMediaStoreUriFetcher(this.f16778a, this.f16779b, this.f16780c, uri, i2, i3, options, this.f16781d));
    }

    /* renamed from: d */
    public boolean a(Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && MediaStoreUtil.b(uri);
    }
}
