package com.unity3d.services.core.di;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

public final class ServiceKey {
    private final KClass<?> instanceClass;
    private final String named;

    public ServiceKey(String str, KClass<?> kClass) {
        Intrinsics.f(str, "named");
        Intrinsics.f(kClass, "instanceClass");
        this.named = str;
        this.instanceClass = kClass;
    }

    public static /* synthetic */ ServiceKey copy$default(ServiceKey serviceKey, String str, KClass<?> kClass, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = serviceKey.named;
        }
        if ((i2 & 2) != 0) {
            kClass = serviceKey.instanceClass;
        }
        return serviceKey.copy(str, kClass);
    }

    public final String component1() {
        return this.named;
    }

    public final KClass<?> component2() {
        return this.instanceClass;
    }

    public final ServiceKey copy(String str, KClass<?> kClass) {
        Intrinsics.f(str, "named");
        Intrinsics.f(kClass, "instanceClass");
        return new ServiceKey(str, kClass);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ServiceKey)) {
            return false;
        }
        ServiceKey serviceKey = (ServiceKey) obj;
        return Intrinsics.a(this.named, serviceKey.named) && Intrinsics.a(this.instanceClass, serviceKey.instanceClass);
    }

    public final KClass<?> getInstanceClass() {
        return this.instanceClass;
    }

    public final String getNamed() {
        return this.named;
    }

    public int hashCode() {
        return (this.named.hashCode() * 31) + this.instanceClass.hashCode();
    }

    public String toString() {
        return "ServiceKey(named=" + this.named + ", instanceClass=" + this.instanceClass + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ServiceKey(String str, KClass kClass, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, kClass);
    }
}
