package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.model.AssetUriLoader;
import com.bumptech.glide.load.model.ByteArrayLoader;
import com.bumptech.glide.load.model.ByteBufferEncoder;
import com.bumptech.glide.load.model.ByteBufferFileLoader;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.bumptech.glide.load.model.FileLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.MediaStoreFileLoader;
import com.bumptech.glide.load.model.ResourceLoader;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.model.StringLoader;
import com.bumptech.glide.load.model.UnitModelLoader;
import com.bumptech.glide.load.model.UriLoader;
import com.bumptech.glide.load.model.UrlUriLoader;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.model.stream.HttpUriLoader;
import com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader;
import com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader;
import com.bumptech.glide.load.model.stream.QMediaStoreUriLoader;
import com.bumptech.glide.load.model.stream.UrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.InputStreamBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.ParcelFileDescriptorBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.bytes.ByteBufferRewinder;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.load.resource.drawable.UnitDrawableDecoder;
import com.bumptech.glide.load.resource.file.FileDecoder;
import com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableEncoder;
import com.bumptech.glide.load.resource.gif.GifFrameResourceDecoder;
import com.bumptech.glide.load.resource.gif.StreamGifDecoder;
import com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.BitmapDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.DrawableBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.module.ManifestParser;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Glide implements ComponentCallbacks2 {

    /* renamed from: m  reason: collision with root package name */
    private static volatile Glide f16099m;

    /* renamed from: n  reason: collision with root package name */
    private static volatile boolean f16100n;

    /* renamed from: b  reason: collision with root package name */
    private final Engine f16101b;

    /* renamed from: c  reason: collision with root package name */
    private final BitmapPool f16102c;

    /* renamed from: d  reason: collision with root package name */
    private final MemoryCache f16103d;

    /* renamed from: e  reason: collision with root package name */
    private final GlideContext f16104e;

    /* renamed from: f  reason: collision with root package name */
    private final Registry f16105f;

    /* renamed from: g  reason: collision with root package name */
    private final ArrayPool f16106g;

    /* renamed from: h  reason: collision with root package name */
    private final RequestManagerRetriever f16107h;

    /* renamed from: i  reason: collision with root package name */
    private final ConnectivityMonitorFactory f16108i;

    /* renamed from: j  reason: collision with root package name */
    private final List<RequestManager> f16109j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    private final RequestOptionsFactory f16110k;

    /* renamed from: l  reason: collision with root package name */
    private MemoryCategory f16111l = MemoryCategory.NORMAL;

    public interface RequestOptionsFactory {
        RequestOptions build();
    }

    Glide(Context context, Engine engine, MemoryCache memoryCache, BitmapPool bitmapPool, ArrayPool arrayPool, RequestManagerRetriever requestManagerRetriever, ConnectivityMonitorFactory connectivityMonitorFactory, int i2, RequestOptionsFactory requestOptionsFactory, Map<Class<?>, TransitionOptions<?, ?>> map, List<RequestListener<Object>> list, boolean z2, boolean z3) {
        ResourceDecoder resourceDecoder;
        ResourceDecoder resourceDecoder2;
        Registry registry;
        Context context2 = context;
        BitmapPool bitmapPool2 = bitmapPool;
        ArrayPool arrayPool2 = arrayPool;
        this.f16101b = engine;
        this.f16102c = bitmapPool2;
        this.f16106g = arrayPool2;
        this.f16103d = memoryCache;
        this.f16107h = requestManagerRetriever;
        this.f16108i = connectivityMonitorFactory;
        this.f16110k = requestOptionsFactory;
        Resources resources = context.getResources();
        Registry registry2 = new Registry();
        this.f16105f = registry2;
        registry2.o(new DefaultImageHeaderParser());
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 27) {
            registry2.o(new ExifInterfaceImageHeaderParser());
        }
        List<ImageHeaderParser> g2 = registry2.g();
        ByteBufferGifDecoder byteBufferGifDecoder = new ByteBufferGifDecoder(context2, g2, bitmapPool2, arrayPool2);
        ResourceDecoder<ParcelFileDescriptor, Bitmap> h2 = VideoDecoder.h(bitmapPool);
        Downsampler downsampler = new Downsampler(registry2.g(), resources.getDisplayMetrics(), bitmapPool2, arrayPool2);
        if (!z3 || i3 < 28) {
            resourceDecoder = new ByteBufferBitmapDecoder(downsampler);
            resourceDecoder2 = new StreamBitmapDecoder(downsampler, arrayPool2);
        } else {
            resourceDecoder2 = new InputStreamBitmapImageDecoderResourceDecoder();
            resourceDecoder = new ByteBufferBitmapImageDecoderResourceDecoder();
        }
        ResourceDrawableDecoder resourceDrawableDecoder = new ResourceDrawableDecoder(context2);
        ResourceLoader.StreamFactory streamFactory = new ResourceLoader.StreamFactory(resources);
        ResourceLoader.UriFactory uriFactory = new ResourceLoader.UriFactory(resources);
        ResourceLoader.FileDescriptorFactory fileDescriptorFactory = new ResourceLoader.FileDescriptorFactory(resources);
        int i4 = i3;
        ResourceLoader.AssetFileDescriptorFactory assetFileDescriptorFactory = new ResourceLoader.AssetFileDescriptorFactory(resources);
        BitmapEncoder bitmapEncoder = new BitmapEncoder(arrayPool2);
        ResourceLoader.AssetFileDescriptorFactory assetFileDescriptorFactory2 = assetFileDescriptorFactory;
        BitmapBytesTranscoder bitmapBytesTranscoder = new BitmapBytesTranscoder();
        GifDrawableBytesTranscoder gifDrawableBytesTranscoder = new GifDrawableBytesTranscoder();
        ContentResolver contentResolver = context.getContentResolver();
        ResourceLoader.UriFactory uriFactory2 = uriFactory;
        Class<ByteBuffer> cls = ByteBuffer.class;
        ResourceLoader.FileDescriptorFactory fileDescriptorFactory2 = fileDescriptorFactory;
        ResourceLoader.StreamFactory streamFactory2 = streamFactory;
        Class<InputStream> cls2 = InputStream.class;
        ResourceDrawableDecoder resourceDrawableDecoder2 = resourceDrawableDecoder;
        Class<Bitmap> cls3 = Bitmap.class;
        registry2.a(cls, new ByteBufferEncoder()).a(cls2, new StreamEncoder(arrayPool2)).e("Bitmap", cls, cls3, resourceDecoder).e("Bitmap", cls2, cls3, resourceDecoder2);
        Class<ParcelFileDescriptor> cls4 = ParcelFileDescriptor.class;
        if (ParcelFileDescriptorRewinder.c()) {
            registry2.e("Bitmap", cls4, cls3, new ParcelFileDescriptorBitmapDecoder(downsampler));
        }
        Registry registry3 = registry2;
        Class<AssetFileDescriptor> cls5 = AssetFileDescriptor.class;
        Class<AssetFileDescriptor> cls6 = cls5;
        Class<BitmapDrawable> cls7 = BitmapDrawable.class;
        Registry b2 = registry2.e("Bitmap", cls4, cls3, h2).e("Bitmap", cls5, cls3, VideoDecoder.c(bitmapPool)).d(cls3, cls3, UnitModelLoader.Factory.b()).e("Bitmap", cls3, cls3, new UnitBitmapDecoder()).b(cls3, bitmapEncoder).e("BitmapDrawable", cls, cls7, new BitmapDrawableDecoder(resources, resourceDecoder)).e("BitmapDrawable", cls2, cls7, new BitmapDrawableDecoder(resources, resourceDecoder2)).e("BitmapDrawable", cls4, cls7, new BitmapDrawableDecoder(resources, h2)).b(cls7, new BitmapDrawableEncoder(bitmapPool2, bitmapEncoder));
        Class<ParcelFileDescriptor> cls8 = cls4;
        ArrayPool arrayPool3 = arrayPool;
        Class<GifDrawable> cls9 = GifDrawable.class;
        Class<GifDecoder> cls10 = GifDecoder.class;
        Registry e2 = b2.e("Gif", cls2, cls9, new StreamGifDecoder(g2, byteBufferGifDecoder, arrayPool3)).e("Gif", cls, cls9, byteBufferGifDecoder).b(cls9, new GifDrawableEncoder()).d(cls10, cls10, UnitModelLoader.Factory.b()).e("Bitmap", cls10, cls3, new GifFrameResourceDecoder(bitmapPool2));
        Class<Uri> cls11 = Uri.class;
        Class<Drawable> cls12 = Drawable.class;
        ResourceDrawableDecoder resourceDrawableDecoder3 = resourceDrawableDecoder2;
        Class<File> cls13 = File.class;
        e2.c(cls11, cls12, resourceDrawableDecoder3).c(cls11, cls3, new ResourceBitmapDecoder(resourceDrawableDecoder3, bitmapPool2)).p(new ByteBufferRewinder.Factory()).d(cls13, cls, new ByteBufferFileLoader.Factory()).d(cls13, cls2, new FileLoader.StreamFactory()).c(cls13, cls13, new FileDecoder()).d(cls13, cls8, new FileLoader.FileDescriptorFactory()).d(cls13, cls13, UnitModelLoader.Factory.b()).p(new InputStreamRewinder.Factory(arrayPool3));
        if (ParcelFileDescriptorRewinder.c()) {
            registry = registry3;
            registry.p(new ParcelFileDescriptorRewinder.Factory());
        } else {
            registry = registry3;
        }
        Class cls14 = Integer.TYPE;
        ResourceLoader.StreamFactory streamFactory3 = streamFactory2;
        ResourceLoader.FileDescriptorFactory fileDescriptorFactory3 = fileDescriptorFactory2;
        Class<GifDrawable> cls15 = cls9;
        Class<Integer> cls16 = Integer.class;
        Registry d2 = registry.d(cls14, cls2, streamFactory3).d(cls14, cls8, fileDescriptorFactory3).d(cls16, cls2, streamFactory3).d(cls16, cls8, fileDescriptorFactory3);
        ResourceLoader.UriFactory uriFactory3 = uriFactory2;
        ResourceLoader.AssetFileDescriptorFactory assetFileDescriptorFactory3 = assetFileDescriptorFactory2;
        Class<AssetFileDescriptor> cls17 = cls6;
        Class<String> cls18 = String.class;
        Context context3 = context;
        d2.d(cls16, cls11, uriFactory3).d(cls14, cls17, assetFileDescriptorFactory3).d(cls16, cls17, assetFileDescriptorFactory3).d(cls14, cls11, uriFactory3).d(cls18, cls2, new DataUrlLoader.StreamFactory()).d(cls11, cls2, new DataUrlLoader.StreamFactory()).d(cls18, cls2, new StringLoader.StreamFactory()).d(cls18, cls8, new StringLoader.FileDescriptorFactory()).d(cls18, cls17, new StringLoader.AssetFileDescriptorFactory()).d(cls11, cls2, new HttpUriLoader.Factory()).d(cls11, cls2, new AssetUriLoader.StreamFactory(context.getAssets())).d(cls11, cls8, new AssetUriLoader.FileDescriptorFactory(context.getAssets())).d(cls11, cls2, new MediaStoreImageThumbLoader.Factory(context3)).d(cls11, cls2, new MediaStoreVideoThumbLoader.Factory(context3));
        int i5 = i4;
        if (i5 >= 29) {
            registry.d(cls11, cls2, new QMediaStoreUriLoader.InputStreamFactory(context3));
            registry.d(cls11, cls8, new QMediaStoreUriLoader.FileDescriptorFactory(context3));
        }
        ContentResolver contentResolver2 = contentResolver;
        Class<GlideUrl> cls19 = GlideUrl.class;
        Class<byte[]> cls20 = byte[].class;
        Registry q2 = registry.d(cls11, cls2, new UriLoader.StreamFactory(contentResolver2)).d(cls11, cls8, new UriLoader.FileDescriptorFactory(contentResolver2)).d(cls11, cls17, new UriLoader.AssetFileDescriptorFactory(contentResolver2)).d(cls11, cls2, new UrlUriLoader.StreamFactory()).d(URL.class, cls2, new UrlLoader.StreamFactory()).d(cls11, cls13, new MediaStoreFileLoader.Factory(context3)).d(cls19, cls2, new HttpGlideUrlLoader.Factory()).d(cls20, cls, new ByteArrayLoader.ByteBufferFactory()).d(cls20, cls2, new ByteArrayLoader.StreamFactory()).d(cls11, cls11, UnitModelLoader.Factory.b()).d(cls12, cls12, UnitModelLoader.Factory.b()).c(cls12, cls12, new UnitDrawableDecoder()).q(cls3, cls7, new BitmapDrawableTranscoder(resources));
        BitmapBytesTranscoder bitmapBytesTranscoder2 = bitmapBytesTranscoder;
        GifDrawableBytesTranscoder gifDrawableBytesTranscoder2 = gifDrawableBytesTranscoder;
        q2.q(cls3, cls20, bitmapBytesTranscoder2).q(cls12, cls20, new DrawableBytesTranscoder(bitmapPool, bitmapBytesTranscoder2, gifDrawableBytesTranscoder2)).q(cls15, cls20, gifDrawableBytesTranscoder2);
        if (i5 >= 23) {
            ResourceDecoder<ByteBuffer, Bitmap> d3 = VideoDecoder.d(bitmapPool);
            registry.c(cls, cls3, d3);
            registry.c(cls, cls7, new BitmapDrawableDecoder(resources, d3));
        }
        this.f16104e = new GlideContext(context, arrayPool, registry, new ImageViewTargetFactory(), requestOptionsFactory, map, list, engine, z2, i2);
    }

    private static void a(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        if (!f16100n) {
            f16100n = true;
            m(context, generatedAppGlideModule);
            f16100n = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    public static Glide c(Context context) {
        if (f16099m == null) {
            GeneratedAppGlideModule d2 = d(context.getApplicationContext());
            synchronized (Glide.class) {
                if (f16099m == null) {
                    a(context, d2);
                }
            }
        }
        return f16099m;
    }

    private static GeneratedAppGlideModule d(Context context) {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{context.getApplicationContext()});
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable("Glide", 5)) {
                Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
        } catch (InstantiationException e2) {
            q(e2);
        } catch (IllegalAccessException e3) {
            q(e3);
        } catch (NoSuchMethodException e4) {
            q(e4);
        } catch (InvocationTargetException e5) {
            q(e5);
        }
        return null;
    }

    private static RequestManagerRetriever l(Context context) {
        Preconditions.e(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return c(context).k();
    }

    private static void m(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        n(context, new GlideBuilder(), generatedAppGlideModule);
    }

    private static void n(Context context, GlideBuilder glideBuilder, GeneratedAppGlideModule generatedAppGlideModule) {
        RequestManagerRetriever.RequestManagerFactory requestManagerFactory;
        Context applicationContext = context.getApplicationContext();
        List<GlideModule> emptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.c()) {
            emptyList = new ManifestParser(applicationContext).a();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.d().isEmpty()) {
            Set<Class<?>> d2 = generatedAppGlideModule.d();
            Iterator<GlideModule> it2 = emptyList.iterator();
            while (it2.hasNext()) {
                GlideModule next = it2.next();
                if (d2.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it2.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            for (GlideModule glideModule : emptyList) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + glideModule.getClass());
            }
        }
        if (generatedAppGlideModule != null) {
            requestManagerFactory = generatedAppGlideModule.e();
        } else {
            requestManagerFactory = null;
        }
        glideBuilder.b(requestManagerFactory);
        for (GlideModule a2 : emptyList) {
            a2.a(applicationContext, glideBuilder);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.b(applicationContext, glideBuilder);
        }
        Glide a3 = glideBuilder.a(applicationContext);
        for (GlideModule next2 : emptyList) {
            try {
                next2.b(applicationContext, a3, a3.f16105f);
            } catch (AbstractMethodError e2) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + next2.getClass().getName(), e2);
            }
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.a(applicationContext, a3, a3.f16105f);
        }
        applicationContext.registerComponentCallbacks(a3);
        f16099m = a3;
    }

    private static void q(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public static RequestManager t(Context context) {
        return l(context).e(context);
    }

    public static RequestManager u(Fragment fragment) {
        return l(fragment.getContext()).f(fragment);
    }

    public static RequestManager v(FragmentActivity fragmentActivity) {
        return l(fragmentActivity).g(fragmentActivity);
    }

    public void b() {
        Util.a();
        this.f16103d.b();
        this.f16102c.b();
        this.f16106g.b();
    }

    public ArrayPool e() {
        return this.f16106g;
    }

    public BitmapPool f() {
        return this.f16102c;
    }

    /* access modifiers changed from: package-private */
    public ConnectivityMonitorFactory g() {
        return this.f16108i;
    }

    public Context h() {
        return this.f16104e.getBaseContext();
    }

    /* access modifiers changed from: package-private */
    public GlideContext i() {
        return this.f16104e;
    }

    public Registry j() {
        return this.f16105f;
    }

    public RequestManagerRetriever k() {
        return this.f16107h;
    }

    /* access modifiers changed from: package-private */
    public void o(RequestManager requestManager) {
        synchronized (this.f16109j) {
            if (!this.f16109j.contains(requestManager)) {
                this.f16109j.add(requestManager);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
        b();
    }

    public void onTrimMemory(int i2) {
        r(i2);
    }

    /* access modifiers changed from: package-private */
    public boolean p(Target<?> target) {
        synchronized (this.f16109j) {
            for (RequestManager o2 : this.f16109j) {
                if (o2.o(target)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void r(int i2) {
        Util.a();
        for (RequestManager onTrimMemory : this.f16109j) {
            onTrimMemory.onTrimMemory(i2);
        }
        this.f16103d.a(i2);
        this.f16102c.a(i2);
        this.f16106g.a(i2);
    }

    /* access modifiers changed from: package-private */
    public void s(RequestManager requestManager) {
        synchronized (this.f16109j) {
            if (this.f16109j.contains(requestManager)) {
                this.f16109j.remove(requestManager);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }
}
