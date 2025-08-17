package com.vungle.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import com.vungle.ads.internal.bidding.BidTokenEncoder;
import com.vungle.ads.internal.downloader.Downloader;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.locale.LocaleInfo;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.omsdk.OMInjector;
import com.vungle.ads.internal.omsdk.OMTracker;
import com.vungle.ads.internal.persistence.FilePreferences;
import com.vungle.ads.internal.platform.Platform;
import com.vungle.ads.internal.signals.SignalManager;
import com.vungle.ads.internal.task.JobCreator;
import com.vungle.ads.internal.task.JobRunner;
import com.vungle.ads.internal.util.ConcurrencyTimeoutProvider;
import com.vungle.ads.internal.util.PathProvider;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class ServiceLocator {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @SuppressLint({"StaticFieldLeak"})
    public static volatile ServiceLocator INSTANCE;
    private final Map<Class<?>, Object> cache;
    private final Map<Class<?>, Creator<?>> creators;
    /* access modifiers changed from: private */
    public final Context ctx;

    @Keep
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getINSTANCE$vungle_ads_release$annotations() {
        }

        public final synchronized void deInit() {
            setINSTANCE$vungle_ads_release((ServiceLocator) null);
        }

        public final ServiceLocator getINSTANCE$vungle_ads_release() {
            return ServiceLocator.INSTANCE;
        }

        public final ServiceLocator getInstance(Context context) {
            Intrinsics.f(context, "context");
            ServiceLocator iNSTANCE$vungle_ads_release = getINSTANCE$vungle_ads_release();
            if (iNSTANCE$vungle_ads_release == null) {
                synchronized (this) {
                    Companion companion = ServiceLocator.Companion;
                    ServiceLocator iNSTANCE$vungle_ads_release2 = companion.getINSTANCE$vungle_ads_release();
                    if (iNSTANCE$vungle_ads_release2 == null) {
                        iNSTANCE$vungle_ads_release2 = new ServiceLocator(context, (DefaultConstructorMarker) null);
                        companion.setINSTANCE$vungle_ads_release(iNSTANCE$vungle_ads_release2);
                    }
                    iNSTANCE$vungle_ads_release = iNSTANCE$vungle_ads_release2;
                }
            }
            return iNSTANCE$vungle_ads_release;
        }

        public final /* synthetic */ <T> Lazy<T> inject(Context context) {
            Intrinsics.f(context, "context");
            LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
            Intrinsics.k();
            return LazyKt__LazyJVMKt.a(lazyThreadSafetyMode, new ServiceLocator$Companion$inject$1(context));
        }

        public final void setINSTANCE$vungle_ads_release(ServiceLocator serviceLocator) {
            ServiceLocator.INSTANCE = serviceLocator;
        }
    }

    private abstract class Creator<T> {
        private final boolean isSingleton;

        public Creator(boolean z2) {
            this.isSingleton = z2;
        }

        public abstract T create();

        public final boolean isSingleton() {
            return this.isSingleton;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Creator(ServiceLocator serviceLocator, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? true : z2);
        }
    }

    private ServiceLocator(Context context) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.e(applicationContext, "context.applicationContext");
        this.ctx = applicationContext;
        this.creators = new HashMap();
        this.cache = new HashMap();
        buildCreators();
    }

    public /* synthetic */ ServiceLocator(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    private final void buildCreators() {
        this.creators.put(JobCreator.class, new ServiceLocator$buildCreators$1(this));
        this.creators.put(JobRunner.class, new ServiceLocator$buildCreators$2(this));
        this.creators.put(VungleApiClient.class, new ServiceLocator$buildCreators$3(this));
        this.creators.put(Platform.class, new ServiceLocator$buildCreators$4(this));
        this.creators.put(Executors.class, new ServiceLocator$buildCreators$5(this));
        this.creators.put(OMInjector.class, new ServiceLocator$buildCreators$6(this));
        this.creators.put(OMTracker.Factory.class, new ServiceLocator$buildCreators$7(this));
        this.creators.put(FilePreferences.class, new ServiceLocator$buildCreators$8(this));
        this.creators.put(LocaleInfo.class, new ServiceLocator$buildCreators$9(this));
        this.creators.put(BidTokenEncoder.class, new ServiceLocator$buildCreators$10(this));
        this.creators.put(PathProvider.class, new ServiceLocator$buildCreators$11(this));
        this.creators.put(Downloader.class, new ServiceLocator$buildCreators$12(this));
        this.creators.put(ConcurrencyTimeoutProvider.class, new ServiceLocator$buildCreators$13(this));
        this.creators.put(SignalManager.class, new ServiceLocator$buildCreators$14(this));
    }

    /* access modifiers changed from: private */
    public final <T> T getOrBuild(Class<T> cls) {
        Class<?> serviceClass = getServiceClass(cls);
        T t2 = this.cache.get(serviceClass);
        if (t2 != null) {
            return t2;
        }
        Creator creator = this.creators.get(serviceClass);
        if (creator != null) {
            T create = creator.create();
            if (creator.isSingleton()) {
                this.cache.put(serviceClass, create);
            }
            return create;
        }
        throw new IllegalArgumentException("Unknown class");
    }

    private final Class<?> getServiceClass(Class<?> cls) {
        for (Class<?> next : this.creators.keySet()) {
            if (next.isAssignableFrom(cls)) {
                return next;
            }
        }
        throw new IllegalArgumentException("Unknown dependency for " + cls);
    }

    public final <T> void bindService$vungle_ads_release(Class<?> cls, T t2) {
        Intrinsics.f(cls, "serviceClass");
        this.cache.put(cls, t2);
    }

    public final synchronized <T> T getService(Class<T> cls) {
        Intrinsics.f(cls, "serviceClass");
        return getOrBuild(cls);
    }

    public final synchronized <T> boolean isCreated(Class<T> cls) {
        Intrinsics.f(cls, "serviceClass");
        return this.cache.containsKey(getServiceClass(cls));
    }
}
