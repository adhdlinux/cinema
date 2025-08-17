package com.google.android.gms.common.util;

import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@KeepForSdk
public final class CollectionUtils {
    private CollectionUtils() {
    }

    @KeepForSdk
    public static boolean isEmpty(Collection<?> collection) {
        if (collection == null) {
            return true;
        }
        return collection.isEmpty();
    }

    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf() {
        return Collections.emptyList();
    }

    @KeepForSdk
    public static <K, V> Map<K, V> mapOf(K k2, V v2, K k3, V v3, K k4, V v4) {
        Map zza = zza(3, false);
        zza.put(k2, v2);
        zza.put(k3, v3);
        zza.put(k4, v4);
        return Collections.unmodifiableMap(zza);
    }

    @KeepForSdk
    public static <K, V> Map<K, V> mapOfKeyValueArrays(K[] kArr, V[] vArr) {
        int length = kArr.length;
        int length2 = vArr.length;
        if (length != length2) {
            throw new IllegalArgumentException("Key and values array lengths not equal: " + length + " != " + length2);
        } else if (length == 0) {
            return Collections.emptyMap();
        } else {
            if (length == 1) {
                return Collections.singletonMap(kArr[0], vArr[0]);
            }
            Map zza = zza(length, false);
            for (int i2 = 0; i2 < kArr.length; i2++) {
                zza.put(kArr[i2], vArr[i2]);
            }
            return Collections.unmodifiableMap(zza);
        }
    }

    @KeepForSdk
    public static <T> Set<T> mutableSetOfWithSize(int i2) {
        if (i2 == 0) {
            return new ArraySet();
        }
        return zzb(i2, true);
    }

    @KeepForSdk
    @Deprecated
    public static <T> Set<T> setOf(T t2, T t3, T t4) {
        Set zzb = zzb(3, false);
        zzb.add(t2);
        zzb.add(t3);
        zzb.add(t4);
        return Collections.unmodifiableSet(zzb);
    }

    private static Map zza(int i2, boolean z2) {
        if (i2 <= 256) {
            return new ArrayMap(i2);
        }
        return new HashMap(i2, 1.0f);
    }

    private static Set zzb(int i2, boolean z2) {
        int i3;
        float f2;
        if (true != z2) {
            i3 = UserVerificationMethods.USER_VERIFY_HANDPRINT;
        } else {
            i3 = 128;
        }
        if (i2 <= i3) {
            return new ArraySet(i2);
        }
        if (true != z2) {
            f2 = 1.0f;
        } else {
            f2 = 0.75f;
        }
        return new HashSet(i2, f2);
    }

    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf(T t2) {
        return Collections.singletonList(t2);
    }

    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf(T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return Collections.emptyList();
        }
        if (length != 1) {
            return Collections.unmodifiableList(Arrays.asList(tArr));
        }
        return Collections.singletonList(tArr[0]);
    }

    @KeepForSdk
    public static <K, V> Map<K, V> mapOf(K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6, K k7, V v7) {
        Map zza = zza(6, false);
        zza.put(k2, v2);
        zza.put(k3, v3);
        zza.put(k4, v4);
        zza.put(k5, v5);
        zza.put(k6, v6);
        zza.put(k7, v7);
        return Collections.unmodifiableMap(zza);
    }

    @KeepForSdk
    @Deprecated
    public static <T> Set<T> setOf(T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return Collections.emptySet();
        }
        if (length == 1) {
            return Collections.singleton(tArr[0]);
        }
        if (length == 2) {
            T t2 = tArr[0];
            T t3 = tArr[1];
            Set zzb = zzb(2, false);
            zzb.add(t2);
            zzb.add(t3);
            return Collections.unmodifiableSet(zzb);
        } else if (length == 3) {
            return setOf(tArr[0], tArr[1], tArr[2]);
        } else {
            if (length != 4) {
                Set zzb2 = zzb(length, false);
                Collections.addAll(zzb2, tArr);
                return Collections.unmodifiableSet(zzb2);
            }
            T t4 = tArr[0];
            T t5 = tArr[1];
            T t6 = tArr[2];
            T t7 = tArr[3];
            Set zzb3 = zzb(4, false);
            zzb3.add(t4);
            zzb3.add(t5);
            zzb3.add(t6);
            zzb3.add(t7);
            return Collections.unmodifiableSet(zzb3);
        }
    }
}
