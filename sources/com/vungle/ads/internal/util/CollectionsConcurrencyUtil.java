package com.vungle.ads.internal.util;

import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;

public final class CollectionsConcurrencyUtil {
    public static final CollectionsConcurrencyUtil INSTANCE = new CollectionsConcurrencyUtil();

    private CollectionsConcurrencyUtil() {
    }

    public static final synchronized void addToSet(HashSet<String> hashSet, String str) {
        synchronized (CollectionsConcurrencyUtil.class) {
            Intrinsics.f(hashSet, "hashset");
            Intrinsics.f(str, "set");
            hashSet.add(str);
        }
    }

    public static final synchronized HashSet<String> getNewHashSet(HashSet<String> hashSet) {
        HashSet<String> hashSet2;
        synchronized (CollectionsConcurrencyUtil.class) {
            hashSet2 = new HashSet<>(hashSet);
        }
        return hashSet2;
    }
}
