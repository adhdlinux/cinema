package com.vungle.ads.internal.model;

import java.util.Comparator;

public final class AdPayload$getDownloadableAssets$$inlined$sortByDescending$1<T> implements Comparator {
    public final int compare(T t2, T t3) {
        return ComparisonsKt__ComparisonsKt.a(Boolean.valueOf(((AdAsset) t3).isRequired()), Boolean.valueOf(((AdAsset) t2).isRequired()));
    }
}
