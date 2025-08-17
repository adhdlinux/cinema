package com.unity3d.services.core.di;

import java.util.Map;
import kotlin.Lazy;
import kotlin.reflect.KClass;

public interface IServicesRegistry {

    public static final class DefaultImpls {
        public static /* synthetic */ Object getService$default(IServicesRegistry iServicesRegistry, String str, KClass kClass, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    str = "";
                }
                return iServicesRegistry.getService(str, kClass);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getService");
        }
    }

    <T> T getService(String str, KClass<?> kClass);

    Map<ServiceKey, Lazy<?>> getServices();

    <T> T resolveService(ServiceKey serviceKey);

    <T> T resolveServiceOrNull(ServiceKey serviceKey);

    <T> void updateService(ServiceKey serviceKey, Lazy<? extends T> lazy);
}
