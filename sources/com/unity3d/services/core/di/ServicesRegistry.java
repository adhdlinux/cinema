package com.unity3d.services.core.di;

import com.google.android.gms.ads.RequestConfiguration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

public final class ServicesRegistry implements IServicesRegistry {
    private final ConcurrentHashMap<ServiceKey, Lazy<?>> _services = new ConcurrentHashMap<>();

    public static /* synthetic */ ServiceKey factory$default(ServicesRegistry servicesRegistry, String str, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        Intrinsics.f(str, "named");
        Intrinsics.f(function0, "instance");
        Intrinsics.l(4, RequestConfiguration.MAX_AD_CONTENT_RATING_T);
        ServiceKey serviceKey = new ServiceKey(str, Reflection.b(Object.class));
        servicesRegistry.updateService(serviceKey, ServiceFactoryKt.factoryOf(function0));
        return serviceKey;
    }

    public static /* synthetic */ Object get$default(ServicesRegistry servicesRegistry, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        Intrinsics.f(str, "named");
        Intrinsics.l(4, RequestConfiguration.MAX_AD_CONTENT_RATING_T);
        return servicesRegistry.resolveService(new ServiceKey(str, Reflection.b(Object.class)));
    }

    public static /* synthetic */ Object getOrNull$default(ServicesRegistry servicesRegistry, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        Intrinsics.f(str, "named");
        Intrinsics.l(4, RequestConfiguration.MAX_AD_CONTENT_RATING_T);
        return servicesRegistry.resolveServiceOrNull(new ServiceKey(str, Reflection.b(Object.class)));
    }

    public static /* synthetic */ ServiceKey single$default(ServicesRegistry servicesRegistry, String str, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        Intrinsics.f(str, "named");
        Intrinsics.f(function0, "instance");
        Intrinsics.l(4, RequestConfiguration.MAX_AD_CONTENT_RATING_T);
        ServiceKey serviceKey = new ServiceKey(str, Reflection.b(Object.class));
        servicesRegistry.updateService(serviceKey, LazyKt__LazyJVMKt.b(function0));
        return serviceKey;
    }

    public final /* synthetic */ <T> ServiceKey factory(String str, Function0<? extends T> function0) {
        Intrinsics.f(str, "named");
        Intrinsics.f(function0, "instance");
        Intrinsics.l(4, RequestConfiguration.MAX_AD_CONTENT_RATING_T);
        ServiceKey serviceKey = new ServiceKey(str, Reflection.b(Object.class));
        updateService(serviceKey, ServiceFactoryKt.factoryOf(function0));
        return serviceKey;
    }

    public final /* synthetic */ <T> T get(String str) {
        Intrinsics.f(str, "named");
        Intrinsics.l(4, RequestConfiguration.MAX_AD_CONTENT_RATING_T);
        return resolveService(new ServiceKey(str, Reflection.b(Object.class)));
    }

    public final /* synthetic */ <T> T getOrNull(String str) {
        Intrinsics.f(str, "named");
        Intrinsics.l(4, RequestConfiguration.MAX_AD_CONTENT_RATING_T);
        return resolveServiceOrNull(new ServiceKey(str, Reflection.b(Object.class)));
    }

    public <T> T getService(String str, KClass<?> kClass) {
        Intrinsics.f(str, "named");
        Intrinsics.f(kClass, "instance");
        return resolveService(new ServiceKey(str, kClass));
    }

    public Map<ServiceKey, Lazy<?>> getServices() {
        return this._services;
    }

    public <T> T resolveService(ServiceKey serviceKey) {
        Intrinsics.f(serviceKey, "key");
        Lazy lazy = getServices().get(serviceKey);
        if (lazy != null) {
            return lazy.getValue();
        }
        throw new IllegalStateException("No service instance found for " + serviceKey);
    }

    public <T> T resolveServiceOrNull(ServiceKey serviceKey) {
        Intrinsics.f(serviceKey, "key");
        Lazy lazy = getServices().get(serviceKey);
        if (lazy == null) {
            return null;
        }
        return lazy.getValue();
    }

    public final /* synthetic */ <T> ServiceKey single(String str, Function0<? extends T> function0) {
        Intrinsics.f(str, "named");
        Intrinsics.f(function0, "instance");
        Intrinsics.l(4, RequestConfiguration.MAX_AD_CONTENT_RATING_T);
        ServiceKey serviceKey = new ServiceKey(str, Reflection.b(Object.class));
        updateService(serviceKey, LazyKt__LazyJVMKt.b(function0));
        return serviceKey;
    }

    public <T> void updateService(ServiceKey serviceKey, Lazy<? extends T> lazy) {
        Intrinsics.f(serviceKey, "key");
        Intrinsics.f(lazy, "instance");
        if (!getServices().containsKey(serviceKey)) {
            this._services.put(serviceKey, lazy);
            return;
        }
        throw new IllegalStateException("Cannot have multiple identical services".toString());
    }
}
