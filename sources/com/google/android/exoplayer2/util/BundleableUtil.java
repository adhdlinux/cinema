package com.google.android.exoplayer2.util;

import android.os.Bundle;
import android.util.SparseArray;
import com.google.android.exoplayer2.Bundleable;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class BundleableUtil {
    private BundleableUtil() {
    }

    public static void a(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader((ClassLoader) Util.j(BundleableUtil.class.getClassLoader()));
        }
    }

    public static <T extends Bundleable> ImmutableList<T> b(Bundleable.Creator<T> creator, List<Bundle> list) {
        ImmutableList.Builder k2 = ImmutableList.k();
        for (int i2 = 0; i2 < list.size(); i2++) {
            k2.d(creator.a((Bundle) Assertions.e(list.get(i2))));
        }
        return k2.k();
    }

    public static <T extends Bundleable> SparseArray<T> c(Bundleable.Creator<T> creator, SparseArray<Bundle> sparseArray) {
        SparseArray<T> sparseArray2 = new SparseArray<>(sparseArray.size());
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            sparseArray2.put(sparseArray.keyAt(i2), creator.a(sparseArray.valueAt(i2)));
        }
        return sparseArray2;
    }

    public static <T extends Bundleable> ArrayList<Bundle> d(Collection<T> collection) {
        ArrayList<Bundle> arrayList = new ArrayList<>(collection.size());
        for (T bundle : collection) {
            arrayList.add(bundle.toBundle());
        }
        return arrayList;
    }

    public static <T extends Bundleable> SparseArray<Bundle> e(SparseArray<T> sparseArray) {
        SparseArray<Bundle> sparseArray2 = new SparseArray<>(sparseArray.size());
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            sparseArray2.put(sparseArray.keyAt(i2), ((Bundleable) sparseArray.valueAt(i2)).toBundle());
        }
        return sparseArray2;
    }
}
